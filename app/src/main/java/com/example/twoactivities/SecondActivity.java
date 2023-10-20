package com.example.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Obtenga la Intent que activó esta actividad:
        Intent intent = getIntent();

        //  Obtenga la cadena que contiene el mensaje de los extras de Intent utilizando la variable
        // estática MainActivity.EXTRA_MESSAGE como clave
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Use findViewByID() para obtener una referencia aTextView para el mensaje del diseño.
        TextView textView = findViewById(R.id.text_message);

        // Establezca el texto de TextView en la cadena del Intent extra:
        textView.setText(message);
    }
}