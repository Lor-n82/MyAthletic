package com.example.in2dm3_03.myathletic;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextoNombre;
    private Typeface mMisstral;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String fuenteMisstral = "fuentes/misstral.ttf";                            //Pasamos la ruta de la fuente
        this.mMisstral = Typeface.createFromAsset(getAssets(), fuenteMisstral);    //Recogemos el recurso

        mTextoNombre = (TextView) findViewById(R.id.textViewNombreApp);
        mTextoNombre.setTypeface(mMisstral);                                       //Le aplicamos el tipo de letra
    }

    public void onClick(View v) {
        Button boton = (Button) v;

        if (boton.getId() == R.id.buttonEmpezar) {
            MediaPlayer mp = MediaPlayer.create(this, R.raw.eup);//Reproducir sonido
            mp.start();
            Intent i1 = new Intent(this, Main2Activity.class);
            startActivity(i1);
        }
    }
}
