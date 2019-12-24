package com.example.toastsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NotificacionesActivity extends AppCompatActivity {

    private final static String CHANNEL_ID = "NOTIFICACIÓN";
    private final static int NOTIFICACION_ID = 0;
    EditText textoTitulo;
    EditText textoNotificacion;
    EditText textoretardo;
    PendingIntent pendingIntent;

    Button botonMostrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificaciones);
        this.setTitle("Configurar Notificación");



        textoTitulo = (EditText)findViewById(R.id.editTextTituloNotificacion);
        textoNotificacion = (EditText)findViewById(R.id.editTextTextoNotificacion);
        textoretardo = (EditText) findViewById(R.id.editTextRetardo);
        botonMostrar = (Button)findViewById(R.id.btnMostrarNotificacion);


        botonMostrar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {



                int retardo = Integer.valueOf(textoretardo.getText().toString());

                try {
                    Thread.sleep(retardo*1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                setPendingIntent();
                createNotificationChannel();
                createNotification();

            }
        });
    }

    private void setPendingIntent()
    {
        Intent i = new Intent(this, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(i);
        pendingIntent = stackBuilder.getPendingIntent(1, PendingIntent.FLAG_UPDATE_CURRENT);
    }

    private void createNotificationChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "NOTIFICACIÓN";
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    private void createNotification(){


        String titulo = textoTitulo.getText().toString();
        String texto = textoNotificacion.getText().toString();


        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notifications_active_black_24dp)
                .setContentTitle(titulo)
                .setContentText(texto)
                .setColor(Color.YELLOW)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setDefaults(Notification.DEFAULT_SOUND);

        builder.setContentIntent(pendingIntent);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getApplicationContext());
        notificationManagerCompat.notify(NOTIFICACION_ID, builder.build());
    }

}

