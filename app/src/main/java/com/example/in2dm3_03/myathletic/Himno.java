package com.example.in2dm3_03.myathletic;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

public class Himno extends AppCompatActivity {

    static MediaPlayer mp = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_himno);
        mp = MediaPlayer.create(this, R.raw.himno);//Reproducir sonido

        //Recupero el sonido donde lo deje al rotar
        if (savedInstanceState != null && savedInstanceState.containsKey("tiempo")) {
            mp.seekTo(savedInstanceState.getInt("tiempo", 0));
        } else
            mp.start();
    }

    protected void onSaveInstanceState(Bundle out) {
        super.onSaveInstanceState(out);
        out.putInt("tiempo", mp.getCurrentPosition());
    }

    /**
     * Entra pero no para el player al rotar
     */
    @Override
    public void onBackPressed() {
        if (mp != null) {
            mp.stop();
            mp = null;
        }
        finish();
    }
}
