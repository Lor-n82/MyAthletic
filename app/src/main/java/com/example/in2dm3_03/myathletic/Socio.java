package com.example.in2dm3_03.myathletic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Socio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socio);
    }

    public void onClick(View v){
        Button boton=(Button)v;

        if(boton.getId()==R.id.buttonLogin){
            Intent i1=new Intent(this,pantalla_socio.class);
            startActivity(i1);
        }else if(boton.getId()==R.id.buttonRegistro){
            Intent i1=new Intent(this,nuevo_registro.class);
            startActivity(i1);
        }
    }
}
