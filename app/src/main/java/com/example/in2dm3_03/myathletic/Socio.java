package com.example.in2dm3_03.myathletic;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Socio extends AppCompatActivity {
    EditText mUsuario,mPass;
    private Cursor fila;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socio);

        mUsuario=(EditText)findViewById(R.id.editTextUsuario);
        mPass=(EditText)findViewById(R.id.editTextPassword);
    }

    /*public void onClick(View v){
        Button boton=(Button)v;

        if(boton.getId()==R.id.buttonLogin){
            Intent i1=new Intent(this,pantalla_socio.class);
            startActivity(i1);
        }else if(boton.getId()==R.id.buttonRegistro){
            Intent i1=new Intent(this,nuevo_registro.class);
            startActivity(i1);
        }
    }*/

    //metodo de ingreso
    public void ingresar(View v){
        AdaptadorDB admin=new AdaptadorDB(this);
        //SQLiteDatabase db=admin.getWritableDatabase();
        String usuario=mUsuario.getText().toString();
        String contrasena=mPass.getText().toString();
       // fila=db.rawQuery("select usuario,contrasena from usuarios where usuario='"+usuario+"' and contrasena='"+contrasena+"'",null);
        //preguntamos si el cursor tiene algun valor almacenado
        if(fila.moveToFirst()==true){
            //capturamos los valores del cursos y lo almacenamos en variable
            String usua=fila.getString(0);
            String pass=fila.getString(1);
            //preguntamos si los datos ingresados son iguales
            if (usuario.equals(usua)&&contrasena.equals(pass)){
                //si son iguales entonces vamos a otra ventana
                //Menu es una nueva actividad empty
                Intent ven=new Intent(this,pantalla_socio.class);
                startActivity(ven);
                //limpiamos las las cajas de texto
                mUsuario.setText("");
                mPass.setText("");
            }
        }
    }
}
