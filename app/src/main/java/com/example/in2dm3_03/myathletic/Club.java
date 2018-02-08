package com.example.in2dm3_03.myathletic;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Club extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);
    }

    @SuppressLint("MissingPermission")              //Si no lo aplico no ejecuta la llamada
    public void contactarTlf(View v) {
        Intent i1 = new Intent(Intent.ACTION_CALL); //Realizar llamada
        i1.setData(Uri.parse("tel:722466004"));

        startActivity(i1);
    }

    @SuppressLint("MissingPermission")
    public void contactarMail(View v) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "athletic@athletic-club.net", null));     //Enviar Mail
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "A la atención del Athletic Club");      //Se le pasa el asunto
        startActivity(Intent.createChooser(emailIntent, this.getString(R.string.enviar_mail)));
    }
}
