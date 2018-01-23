package com.example.in2dm3_03.myathletic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mBotonEmpezar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBotonEmpezar=(Button)findViewById(R.id.buttonEmpezar);
    }

    public void onClick(View v){
        Button boton=(Button)v;

        if(boton.getId()==R.id.buttonEmpezar){
            //MediaPlayer mp = MediaPlayer.create(this, R.raw.himno);//Reproducir sonido
            //mp.start();
            Intent i1=new Intent(this,Main2Activity.class);
            startActivity(i1);

        }
    }
}
