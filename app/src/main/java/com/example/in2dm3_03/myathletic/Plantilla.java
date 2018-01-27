package com.example.in2dm3_03.myathletic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Plantilla extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout l1; //LinearLayout galeria principal
    private LayoutInflater mInflater; //Inflador para layout
    private ImageView mScrollImage; //ImageView de itemdegaleria (XML que recogemos)
    private ImageView mImagenGrande; //ImageView  con la foto en Grande
    private int [] mImagenes={R.drawable.kepa,R.drawable.remiro,R.drawable.unai,R.drawable.herrerin,R.drawable.lekue,R.drawable.sanjose,R.drawable.demarcos,
            R.drawable.laporte,R.drawable.balenziaga,R.drawable.boveda,R.drawable.saborit,R.drawable.etxeita,R.drawable.yerai,R.drawable.benat,R.drawable.vesga,
            R.drawable.rico,R.drawable.unailopez,R.drawable.iturraspe,R.drawable.raulgarcia,R.drawable.williams,R.drawable.muniain,R.drawable.cordoba,
            R.drawable.eraso,R.drawable.aketxe,R.drawable.sabinmerino,R.drawable.susaeta,R.drawable.sola,R.drawable.villalibre,R.drawable.aduriz}; //Cargamos un array de imagenes con las ids de las imagenes
    private int mIdImagen=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plantilla);

        //Referenciar las vistas que deseamos usar
        l1=findViewById(R.id.Linear1);
        mInflater=LayoutInflater.from(this);

        for(int i=0; i<mImagenes.length;i++){

            View v =mInflater.inflate(R.layout.inflater_galeria,l1,false);   //Creamos una vista y le pasamos el layout que hemos creado, donde queremos mostrarlo y false
            mScrollImage= v.findViewById(R.id.imageViewJugador);                        //Asociamos la vista creada con la id de la vista de nuestra foto y lo guardamos en un imageview
            mScrollImage.setImageResource(mImagenes[i]);                            //asociamos las imagenes al imageview

            mScrollImage.setOnClickListener(this);       //Creamos un onClickListener para el imageview
            l1.addView(v);                              //Añadimos la vista con el contenido del inflater a el linear layout del Scrollview
        }
        mImagenGrande= findViewById(R.id.imageView_FotoGrande);  //Asociamos la variable con su id
        mImagenGrande.setImageResource(mImagenes[0]);
        if(mIdImagen!=0){
            ImageView a= findViewById(mIdImagen);
            mImagenGrande.setImageDrawable(a.getDrawable());
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("imagen",mIdImagen);
    }

    @Override
    public void onClick(View view) {
        ImageView i=(ImageView) view;
        mImagenGrande.setImageDrawable(i.getDrawable());
    }
}

