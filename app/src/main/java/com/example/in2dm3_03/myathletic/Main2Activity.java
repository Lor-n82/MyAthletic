package com.example.in2dm3_03.myathletic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
    int btn;
    MediaPlayer mp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mp = MediaPlayer.create(this, R.raw.eup);//Reproducir sonido
        mp.start();
    }

    public void onClick(View v) {
        Button boton = (Button) v;
        mp.stop();
        if (boton.getId() == R.id.buttonClub) {
            Intent i1 = new Intent(this, Club.class);
            startActivity(i1);

        } else if (boton.getId() == R.id.buttonPlantilla) {
            Intent i1 = new Intent(this, Plantilla.class);
            startActivity(i1);
        } else if (boton.getId() == R.id.buttonSocio) {
            Intent i1 = new Intent(this, Socio.class);
            startActivity(i1);
        } else if (boton.getId() == R.id.buttonHimno) {
            Intent i1 = new Intent(this, Himno.class);
            startActivity(i1);
        } else if (boton.getId() == R.id.buttonAcerca) {
            Intent i1 = new Intent(this, Acerca.class);
            startActivity(i1);
        }
    }

    @Override
    public void onBackPressed() {
        mp.stop();
        super.onBackPressed();
    }
}
