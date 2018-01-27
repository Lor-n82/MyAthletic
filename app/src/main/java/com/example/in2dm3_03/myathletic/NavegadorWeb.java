package com.example.in2dm3_03.myathletic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class NavegadorWeb extends AppCompatActivity {

    private String mUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navegador_web);

        mUrl=getIntent().getStringExtra("url");

        WebView web = (WebView) findViewById(R.id.navegador);

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
