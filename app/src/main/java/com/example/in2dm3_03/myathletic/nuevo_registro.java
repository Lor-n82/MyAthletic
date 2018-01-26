package com.example.in2dm3_03.myathletic;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class nuevo_registro extends AppCompatActivity {
    DatabaseHelper helper=new DatabaseHelper(this);
    EditText mUsuario,mPass,mPassConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_registro);
    }

    public void registrarse(View v){
        if(v.getId()==R.id.buttonRegistro){
            mUsuario=(EditText)findViewById(R.id.editTextUsuarionr);
            mPass=(EditText)findViewById(R.id.editTextPasswordnr);
            mPassConfirm=(EditText)findViewById(R.id.editTextConfirmarPass);

            String nombre=mUsuario.getText().toString();
            String username=
            String pass=mPass.getText().toString();
            String pass2=mPassConfirm.getText().toString();

            if(!pass.equals(pass2)){
                Toast p = Toast.makeText(nuevo_registro.this,"Las claves no coinciden", Toast.LENGTH_SHORT);
                p.show();
            }else{
                Contacto c=new Contacto();
                c.setNombre(nombre);
                c.setPass(pass);
            helper.insertContact(c);
            }


        }
    }
}
