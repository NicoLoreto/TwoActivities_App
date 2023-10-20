package com.example.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    // Crear una Intent de respuesta en la segunda actividad
    // definir la clave para el Intent adicional
    public static final String EXTRA_REPLY =
            "com.example.android.twoactivities.extra.REPLY";

    // Variable privada para contener EditText
    private EditText mReply;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // findViewByID() para obtener una referencia al EditText y asignarlo a
        // esa variable privada
        mReply = findViewById(R.id.editText_second);

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

    public void returnReply(View view) {

        // Obtenga el texto de EditText como una cadena
        String reply = mReply.getText().toString();

        // Nueva Intent para la respuesta
        Intent replyIntent = new Intent();

        // Cadena de respuesta de EditText a la nueva Intent como una Intent
        // adicional. Como los extras son pares clave/valor, aquí la clave es EXTRA_REPLY y el
        // valor es la respuesta:
        replyIntent.putExtra(EXTRA_REPLY, reply);

        // RESULT_OK para indicar que la respuesta fue exitosa. La
        // clase de actividad define los códigos de resultado, incluidos RESULT_OK y
        // RESULT_CANCELLED.
        setResult(RESULT_OK,replyIntent);

        // finish() para cerrar la actividad y volver a MainActivity.
        finish ();




    }
}