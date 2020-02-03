package com.gadgetspidy.basic;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class tenth_subjects extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawer;
    private InterstitialAd mInterstitialAd ;
    Button su1,su2,su3,su4,su5,su6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenth_subjects);
        NavigationView navigationView = findViewById(R.id.nav_bar);
        navigationView.setNavigationItemSelectedListener(this);

su1 = (Button) findViewById(R.id.sub11);
su2 =(Button) findViewById(R.id.sub12);
        su3 = (Button) findViewById(R.id.sub13);
        su4 =(Button) findViewById(R.id.sub14);
        su5 = (Button) findViewById(R.id.sub15);
        su6 =(Button) findViewById(R.id.sub16);
su3.setOnClickListener(new View.OnClickListener() { //science
    @Override
    public void onClick(View v) {
        Intent tsub1 = new Intent(getApplicationContext(),vigyan_10_pdf.class);
        startActivity(tsub1);
    }
});
    su2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tsub1 = new Intent(getApplicationContext(),Maths_10_pdf.class);
                startActivity(tsub1);
            }
        });
        su1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tsub1 = new Intent(getApplicationContext(),Gujrati_10_pdf.class);
                startActivity(tsub1);
            }
        });
        su4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tsub1 = new Intent(getApplicationContext(),Samajik_vigyan_10_pdf.class);
                startActivity(tsub1);
            }
        });
        su5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tsub1 = new Intent(getApplicationContext(),English_10_pdf.class);
                startActivity(tsub1);
            }
        });
        su6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tsub1 = new Intent(getApplicationContext(),Sanskrut_12_pdf.class);
                startActivity(tsub1);
            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_layout);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer_layout);



        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this , drawer , toolbar , R.string.navigation_drawer_open ,
                R.string.navigation_drawer_close);


        drawer.addDrawerListener(toggle);
        toggle.syncState();

        MobileAds.initialize(this,"ca-app-pub-8812355770507385~1497021487");
        prepareAd();
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {

            case R.id.item2:
                Intent st = new Intent(this, classselect.class);
                startActivity(st);
                break;
            case R.id.item4:
                Intent sharing = new Intent(Intent.ACTION_SEND);
                sharing.setType("text/plain");
                String sharebody = "https://play.google.com/store/apps/details?id=com.gadgetspidy.basic";
                String sharesubject = "spread knowledge";
                sharing.putExtra(Intent.EXTRA_TEXT, sharebody);
                sharing.putExtra(Intent.EXTRA_SUBJECT, sharesubject);
                startActivity(Intent.createChooser(sharing, "Share Using"));
                break;
            case R.id.item3:
                Intent st2 = new Intent(this, contact.class);
                startActivity(st2);
                break;
            case R.id.about:
                Intent st3 = new Intent(this, about_us.class);
                startActivity(st3);
                break;
            case R.id.samachar:
                Intent st4 = new Intent(this,SAMACHAR.class);
                startActivity(st4);
                break;
            case R.id.item5:
                Intent st6 = new Intent(this,web.class);
                startActivity(st6);
                break;
        }
        //  drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    //ad
    public void prepareAd()
    {
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-8812355770507385/7358339364");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }



    //back press


    @Override
    public void onBackPressed() {
        if(mInterstitialAd.isLoaded())
        {
            mInterstitialAd.show();
            mInterstitialAd.setAdListener(new AdListener(){
                @Override
                public void onAdClosed() {
                    super.onAdClosed();
                    finish();
                }
            });
        }
        else {


            super.onBackPressed();
        }
    }
}
