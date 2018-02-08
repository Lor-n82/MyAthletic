package com.example.in2dm3_03.myathletic;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Himno extends AppCompatActivity {
    static MediaPlayer mp=null;
    int cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_himno);
        mp = MediaPlayer.create(this, R.raw.himno);//Reproducir sonido

        if(savedInstanceState != null && savedInstanceState.containsKey("tiempo")) {
            mp.seekTo(savedInstanceState.getInt("tiempo", 0));
            cont++;
        }

    if (mp!=null && cont==0){
        mp.start();
    }

    }

    protected void onSaveInstanceState(Bundle out) {
        super.onSaveInstanceState(out);
        out.putInt("tiempo", mp.getCurrentPosition());
    }

    @Override
    protected void onPause() {
        mp.stop();
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        mp.stop();
        super.onBackPressed();
    }
}
