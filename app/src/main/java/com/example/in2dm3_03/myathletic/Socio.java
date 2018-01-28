package com.example.in2dm3_03.myathletic;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Socio extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socio);
    }

    public void onClick(View v) {
        Button boton = (Button) v;

        if (boton.getId() == R.id.buttonLogin) {
            EditText mUsuario = (EditText) findViewById(R.id.editTextUsuario);
            String name = mUsuario.getText().toString();
            EditText mPass = (EditText) findViewById(R.id.editTextPassword);
            String pass = mPass.getText().toString();

            String password = helper.searchPass(name);
            if (pass.equals(password)) {
                Intent i1 = new Intent(this, pantalla_socio.class);
                i1.putExtra("Username", name);
                startActivity(i1);
            } else {
                Toast temp = Toast.makeText(Socio.this, "¡¡¡ El Usuario y la Contraseña, no coinciden !!!", Toast.LENGTH_SHORT);
                temp.show();
            }


        } else if (boton.getId() == R.id.buttonRegistro) {
            Intent i1 = new Intent(this, nuevo_registro.class);
            startActivity(i1);
        }
    }
}
