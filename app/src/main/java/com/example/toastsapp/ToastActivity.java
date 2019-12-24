package com.example.toastsapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class ToastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        this.setTitle("Configurar Toast");


        final String[] datoshorizontal = getResources().getStringArray(R.array.arrayOrientacionHorizontal);
        final String[] datosvertical = getResources().getStringArray(R.array.arrayOrientacionVertical);

        //Spinners
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datoshorizontal);
        final Spinner spinnerHorizontal = (Spinner) findViewById(R.id.sp_orientacion_horizontal);
        spinnerHorizontal.setAdapter(adapter);
        final ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datosvertical);
        final Spinner spinnerVertical = (Spinner) findViewById(R.id.sp_tipo_de_orientacion_vertical);
        spinnerVertical.setAdapter(adapter2);
        //Button
        final Button botonMostrar = (Button) findViewById(R.id.btn_Mostrar);
        //EditText
        final EditText textoVertical = (EditText) findViewById(R.id.editTextMargenVertical);
        final EditText textoHorizontal = (EditText) findViewById(R.id.editTextMargenHorizontal);
        final EditText textoToast = findViewById(R.id.editTextTextoToast);


        botonMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try
                {
                    String texto = textoToast.getText().toString();
                    Toast toast = Toast.makeText(getApplicationContext(), texto, Toast.LENGTH_LONG);

                    int margenvertical = Integer.valueOf(textoVertical.getText().toString());
                    int margenhorizontal = Integer.valueOf(textoHorizontal.getText().toString());

                    switch (spinnerHorizontal.getSelectedItem().toString())
                    {
                        case "Izquierda":

                            switch (spinnerVertical.getSelectedItem().toString())
                            {

                                case "Arriba":
                                    toast.setGravity(Gravity.TOP|Gravity.LEFT, margenhorizontal, margenvertical);
                                    break;

                                case "Centro":
                                    toast.setGravity(Gravity.CENTER|Gravity.LEFT, margenhorizontal, margenvertical);
                                    break;

                                case "Abajo":
                                    toast.setGravity(Gravity.BOTTOM|Gravity.LEFT, margenhorizontal, margenvertical);
                                    break;
                            }

                            break;

                        case "Centro":

                            switch (spinnerVertical.getSelectedItem().toString())
                            {

                                case "Arriba":
                                    toast.setGravity(Gravity.TOP|Gravity.CENTER, margenhorizontal, margenvertical);
                                    break;

                                case "Centro":
                                    toast.setGravity(Gravity.CENTER|Gravity.CENTER, margenhorizontal, margenvertical);
                                    break;

                                case "Abajo":
                                    toast.setGravity(Gravity.BOTTOM|Gravity.CENTER, margenhorizontal, margenvertical);
                                    break;
                            }

                            break;

                        case "Derecha":

                            switch (spinnerVertical.getSelectedItem().toString())
                            {

                                case "Arriba":
                                    toast.setGravity(Gravity.TOP|Gravity.RIGHT, margenhorizontal, margenvertical);
                                    break;

                                case "Centro":
                                    toast.setGravity(Gravity.CENTER|Gravity.RIGHT, margenhorizontal, margenvertical);
                                    break;

                                case "Abajo":
                                    toast.setGravity(Gravity.BOTTOM|Gravity.RIGHT, margenhorizontal, margenvertical);
                                    break;
                            }

                            break;

                    }
                    toast.show();
                } catch (Exception exception)
                {
                    Toast.makeText(ToastActivity.this, "Rellena todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}

