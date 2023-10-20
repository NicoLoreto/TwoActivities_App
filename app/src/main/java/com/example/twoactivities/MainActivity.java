package com.example.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // constant publica en la parte superior de la clase para definir la llave
    // para el Intent extra
    public static final String EXTRA_MESSAGE =
            "com.example.android.twoactivities.extra.MESSAGE";

    // variable privada en la parte superior de la clase para contener el EditText
    private EditText mMessageEditText;

    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  obtener la referencia al EditText y asignarlo
        // a la variable privada
        mMessageEditText = findViewById(R.id.editText_main);


    }

    public void launchSecondActivity(View view) {

        // intent
        Log.d(LOG_TAG, "¡Botón presionado!");
        Intent intent = new Intent(this, SecondActivity.class);
        // obtenga el texto de
        // EditText como una cadena
        String message = mMessageEditText.getText().toString();

        // Agregue esa cadena al Intent como un extra con la constante EXTRA_MESSAGE como
        // clave y la cadena como valor.
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}