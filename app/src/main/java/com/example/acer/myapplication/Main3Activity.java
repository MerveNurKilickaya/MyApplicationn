package com.example.acer.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Main3Activity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        init();
        setWebView();
    }
    public void init(){
        webView=findViewById(R.id.webview);
    }
    public void setWebView(){
        webView.loadUrl("http://www.potensas.com/");
        webView.getSettings().setJavaScriptEnabled(true);  //it works potensas website's js codes.
    }
}
