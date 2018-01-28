package com.example.in2dm3_03.myathletic;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class pantalla_socio extends AppCompatActivity {
    static final String NAVEGADOR = "servicio";
    TextView socio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_socio);
        socio = (TextView) findViewById(R.id.textViewNombreSocio);

        socio.setText(getIntent().getStringExtra("Username"));
    }

    public void onClickSocio(View v) {
        ImageView imagen = (ImageView) v;
        Intent i1 = new Intent(this, NavegadorSocios.class);
        if (imagen.getId() == R.id.imageButtonClasificacion) {
            i1.putExtra(NAVEGADOR, "http://www.athletic-club.eus/cas/clasificacion/2017-18/athletic-liga.html");
            startActivity(i1);
        } else if (imagen.getId() == R.id.imageButtonPartidos) {
            i1.putExtra(NAVEGADOR, "http://www.athletic-club.eus/cas/calendario/2017-18/athletic-liga.html");
            startActivity(i1);
        } else if (imagen.getId() == R.id.imageButtonTienda) {
            i1.putExtra(NAVEGADOR, "https://www.athletic-club.eus/cas/tienda/new-balance_1-equipacion/36-356.html");
            startActivity(i1);
        }
    }
}

