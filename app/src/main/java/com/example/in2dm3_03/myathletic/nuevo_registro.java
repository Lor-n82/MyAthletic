package com.example.in2dm3_03.myathletic;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class nuevo_registro extends AppCompatActivity {

    EditText mUsuario,mPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_registro);

        mUsuario=(EditText)findViewById(R.id.editTextUsuarionr);
        mPass=(EditText)findViewById(R.id.editTextPasswordnr);
    }

    public void registrar(View v){
        AdaptadorDB admin=new AdaptadorDB(this,"usuarios",null,1);
        SQLiteDatabase db=admin.getWritableDatabase();
        String usuario=mUsuario.getText().toString();
        String pass=mPass.getText().toString();

        ContentValues valores=new ContentValues();
        valores.put("codigo",1);
        valores.put("usuario",usuario);
        valores.put("contrasena",pass);

        db.insert("usuarios",null,valores);
        db.close();

        Intent i1=new Intent(this,Socio.class);
        startActivity(i1);
    }

    public void cancelar(View v){
        finish();
    }
}
