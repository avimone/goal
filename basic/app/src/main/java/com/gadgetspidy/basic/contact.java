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

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class contact extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawer;    private InterstitialAd mInterstitialAd ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);


        NavigationView navigationView = findViewById(R.id.nav_bar);
        navigationView.setNavigationItemSelectedListener(this);


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
        switch (menuItem.getItemId())
        {

            case R.id.item2:
                Intent st = new Intent(this,classselect.class);
                startActivity(st);
                break;
            case R.id.item4:
                Intent sharing = new Intent(Intent.ACTION_SEND);
                sharing.setType("text/plain");
                String sharebody = "https://play.google.com/store/apps/details?id=com.gadgetspidy.basic";
                String sharesubject="spread knowledge";
                sharing.putExtra(Intent.EXTRA_TEXT,sharebody);
                sharing.putExtra(Intent.EXTRA_SUBJECT,sharesubject);
                startActivity(Intent.createChooser(sharing,"Share Using"));
                break;
            case R.id.item3:
                Intent st2 = new Intent(this,contact.class);
                startActivity(st2);
                break;
            case R.id.about:
                Intent st3 = new Intent(this,about_us.class);
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