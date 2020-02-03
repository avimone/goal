package com.gadgetspidy.basic;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class web extends AppCompatActivity {
    private  static final  int REQUEST_INTERNET = 1;
    WebView myg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        run();
    }
    void run() {
        myg= (WebView) findViewById(R.id.web);
        WebSettings settings = myg.getSettings();
        settings.setJavaScriptEnabled(true);
        if (ContextCompat.checkSelfPermission(web.this, Manifest.permission.INTERNET)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(web.this,new String []{Manifest.permission.INTERNET},REQUEST_INTERNET);
        }
        myg.loadUrl("https://play.google.com/store/apps/details?id=com.gadgetspidy.basic");
        myg.setWebViewClient(new WebViewClient());
    }

    @Override
    public void onBackPressed() {
        if(myg.canGoBack()) { myg.goBack();}
        else {
            super.onBackPressed();
        }}

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_INTERNET){
            if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                run();
            }
            else {
                Toast.makeText(this,"Permission DENIED",Toast.LENGTH_LONG).show();
            }
        }
    }
}
