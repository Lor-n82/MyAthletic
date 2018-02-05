package com.example.in2dm3_03.myathletic;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Himno extends AppCompatActivity {
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_himno);
        mp = MediaPlayer.create(this, R.raw.himno);//Reproducir sonido
        mp.start();
    }

    @Override
    public void onBackPressed() {
        mp.stop();
        super.onBackPressed();
    }
}
