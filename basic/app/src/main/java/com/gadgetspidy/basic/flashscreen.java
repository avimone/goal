package com.gadgetspidy.basic;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class flashscreen extends AppCompatActivity {
    private static int sto=2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flashscreen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(flashscreen.this,classselect.class);
                startActivity(homeIntent);
                finish();
            }
        },sto);
    }
}
