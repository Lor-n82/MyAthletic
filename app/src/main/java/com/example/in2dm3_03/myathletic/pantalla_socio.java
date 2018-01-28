package com.example.in2dm3_03.myathletic;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class pantalla_socio extends AppCompatActivity {

TextView socio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_socio);
        socio=(TextView)findViewById(R.id.textViewNombreSocio);

        socio.setText(getIntent().getStringExtra("Username"));
    }
}
