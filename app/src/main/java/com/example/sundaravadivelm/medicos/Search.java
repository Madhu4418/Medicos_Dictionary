package com.example.sundaravadivelm.medicos;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Search extends AppCompatActivity {
WebView wv;
    //for going bak while backpressed
    @Override
    public void onBackPressed(){
     if(wv.canGoBack()){
         wv.goBack();
     }else{
         super.onBackPressed();
     }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        wv = (WebView) findViewById(R.id.wv);
        //to enable javascript

wv.getSettings().setJavaScriptEnabled(true);
        wv.setFocusable(true);
wv.setFocusableInTouchMode(true);
        //set render priority to high
        wv.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
    wv.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
wv.getSettings().setDomStorageEnabled(true);
wv.getSettings().setDatabaseEnabled(true);
wv.getSettings().setAppCacheEnabled(true);
        wv.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
    //to load url
        wv.loadUrl("https://en.wikipedia.org/w/index.php?search=&title=Special%3ASearch&go=Go");
        wv.setWebViewClient(new WebViewClient());

    }

}
