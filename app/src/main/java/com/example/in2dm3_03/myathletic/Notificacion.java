package com.example.in2dm3_03.myathletic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Notificacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificacion);

        Toast.makeText(this, "Notoficacion recibida", Toast.LENGTH_SHORT).show();
        finish();
    }
}
