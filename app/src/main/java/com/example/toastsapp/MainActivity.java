package com.example.toastsapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{

    private Button btn_toast;
    private Button btn_notificaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Inicio");

        btn_toast = (Button) findViewById(R.id.btn_toast);
        btn_notificaciones = (Button) findViewById(R.id.btn_notificaciones);


        btn_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(MainActivity.this, ToastActivity.class);
                startActivity(i);
            }
        });


        btn_notificaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(MainActivity.this, NotificacionesActivity.class);
                startActivity(i);
            }
        });


    }
}
