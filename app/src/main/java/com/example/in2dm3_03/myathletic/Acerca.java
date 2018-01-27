package com.example.in2dm3_03.myathletic;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Acerca extends AppCompatActivity {

    private String mUrl = "http://www.github.com/lor-n82/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca);

        WebView web = (WebView) findViewById(R.id.visor);

        web.setWebViewClient(new MyWebViewClient());
        WebSettings settings = web.getSettings();
        web.loadUrl(mUrl);

        TextView text = (TextView) findViewById(R.id.textViewAcercaMenu);

        registerForContextMenu(text); //este texto va a tener menu de contexto
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        //crearMenu(menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        seleccionarOpcion(item);
        return true;
    }

    private void seleccionarOpcion(MenuItem item) {
        int itemId = item.getItemId();
        Log.d("mira", "Entra");
        switch (itemId) {
            case R.id.opc1:
                Toast.makeText(this, "Accediento a Twitter", Toast.LENGTH_LONG).show();
                Intent i1=new Intent(this,NavegadorWeb.class);
                i1.putExtra("twitter","http://www.google.es");
                startActivity(i1);
                break;
            case R.id.opc2:
                Toast.makeText(this, "Accediendo a Github", Toast.LENGTH_LONG).show();
                Intent i2=new Intent(this,NavegadorWeb.class);
                i2.putExtra("github","http://www.google.es");
                startActivity(i2);
                break;
            case R.id.opc3:
                Toast.makeText(this, "Accediendo a Github", Toast.LENGTH_LONG).show();
                Intent i3=new Intent(this,NavegadorWeb.class);
                i3.putExtra("youtube","http://www.youtube.es");
                startActivity(i3);
                break;
        }
    }

    private class MyWebViewClient extends WebViewClient {

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }


}
