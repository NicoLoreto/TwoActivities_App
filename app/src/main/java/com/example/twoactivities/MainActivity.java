package com.example.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // a definir la clave para un tipo particular de respuesta:
    public static final int TEXT_REQUEST = 1;

    // Dos variables privadas para contener el encabezado de respuesta y los elementos
    // TextView de respuesta:
    private TextView mReplyHeadTextView;
    private TextView mReplyTextView;

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

        // Obtener la referencia al EditText y asignarlo
        // a la variable privada
        mMessageEditText = findViewById(R.id.editText_main);

        // Asignar esas instancias de vista a las variables privadas:
        mReplyHeadTextView = findViewById(R.id.text_header_reply);
        mReplyTextView = findViewById(R.id.text_message_reply);
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
        startActivityForResult(intent, TEXT_REQUEST);

    }

    // onActivityResult() contienen toda la información que necesita para
    // manejar los datos devueltos: el código de solicitud que estableció cuando inició la actividad
    // con startActivityForResult(), el código de resultado establecido en la actividad iniciada
    // (generalmente uno de RESULT_OK o RESULT_CANCELED), y los datos de intención
    // que contienen los datos devueltos por la actividad de lanzamiento.
    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply =
                        data.getStringExtra(SecondActivity.EXTRA_REPLY);
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }

}