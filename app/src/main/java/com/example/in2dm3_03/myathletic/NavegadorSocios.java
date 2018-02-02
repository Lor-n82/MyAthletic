package com.example.in2dm3_03.myathletic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class NavegadorSocios extends AppCompatActivity {
    private String mUrl;
    private WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navegador_socios);


        //Recojo la direccion web que pasare al navegador
        mUrl = getIntent().getStringExtra("ser");
        web = (WebView) findViewById(R.id.navegadorSocios);

        web.setWebViewClient(new MyWebViewClient());
        WebSettings settings = web.getSettings();
        web.loadUrl(mUrl);
    }

    private class MyWebViewClient extends WebViewClient {

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
