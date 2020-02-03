package com.gadgetspidy.basic;


import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.List;

public class vanijya_12_pdf extends AppCompatActivity {
    private InterstitialAd mInterstitialAd ;
    RecyclerView recyclerView;
    public static List<PDFModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vanijya_12_pdf);

        recyclerView = findViewById(R.id.RV);

        list = new ArrayList<>();
        list.add(new PDFModel("સંચાલનનુ સ્વરૂપ અને મહત્વ","http://gadgetspidy.com/pdf/vanijyaone.pdf"));
        list.add(new PDFModel("સંચાલનના સિદ્ધાંતો", "http://gadgetspidy.com/pdf/vanijyatwo.pdf"));
        list.add(new PDFModel("આયોજન","http://gadgetspidy.com/pdf/vanijyathree.pdf"));
        list.add(new PDFModel("વ્યવસ્થાતંત્ર","http://gadgetspidy.com/pdf/vanijyafour.pdf"));
        list.add(new PDFModel("કર્મચારી વ્યવસ્થા","http://gadgetspidy.com/pdf/vanijyafive.pdf"));
        list.add(new PDFModel("દોરવણી","http://gadgetspidy.com/pdf/vanijyasix.pdf"));
        list.add(new PDFModel("અંકુશ","http://gadgetspidy.com/pdf/vanijyaseven.pdf"));
        list.add(new PDFModel("નાણાકીય સંચાલન","http://gadgetspidy.com/pdf/vanijyaeight.pdf"));
        list.add(new PDFModel("નાણાકીય બજાર", "http://gadgetspidy.com/pdf/vanijyanine.pdf"));
        list.add(new PDFModel("બજાર પ્રક્રિયા સંચાલન","http://gadgetspidy.com/pdf/vanijyaten.pdf"));
        list.add(new PDFModel("ગ્રાહક સુરક્ષા","http://gadgetspidy.com/pdf/vanijyaeleven.pdf"));
        list.add(new PDFModel("ધંધાકીય પર્યાવરણ","http://gadgetspidy.com/pdf/vanijyatwelve.pdf"));
        list.add(new PDFModel("March 2020 ની બોર્ડ પરીક્ષા માટે Most Imp પ્રશ્નો", "http://gadgetspidy.com/pdf/vanijya.pdf"));


        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        ItemClickListener itemClickListener = new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Intent intent = new Intent(vanijya_12_pdf.this,PDFActivity8.class);
                //intent.putExtra("url",list.get(position).getPdfUrl());
                intent.putExtra("position",position);
                startActivity(intent);
            }
        };

        PDFAdapter adapter = new PDFAdapter(list,this,itemClickListener);
        recyclerView.setAdapter(adapter);
        MobileAds.initialize(this,"ca-app-pub-8812355770507385~1497021487");
        prepareAd();
    }

    //ad
    public void prepareAd()
    {
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-8812355770507385/5006975368");
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

