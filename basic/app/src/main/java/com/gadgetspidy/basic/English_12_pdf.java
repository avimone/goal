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

public class English_12_pdf extends AppCompatActivity {
    private InterstitialAd mInterstitialAd ;
    RecyclerView recyclerView;
    public static List<PDFModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_12_pdf);

        recyclerView = findViewById(R.id.RV);

        list = new ArrayList<>();
        list.add(new PDFModel("Nearest meanings","http://gadgetspidy.com/pdf/.pdf"));
        list.add(new PDFModel("Identification of Functions", "http://gadgetspidy.com/pdf/IdentificationofFunctions12.pdf"));
        list.add(new PDFModel("Respond ( function based)","http://gadgetspidy.com/pdf/"));
        list.add(new PDFModel("Recognise appropriate questions","http://gadgetspidy.com/pdf/"));
        list.add(new PDFModel("Short notes","http://gadgetspidy.com/pdf/"));
        list.add(new PDFModel("Vocabulary (Fill appropriate words)","http://gadgetspidy.com/pdf/"));
        list.add(new PDFModel("Summary writing tips","http://gadgetspidy.com/pdf/"));
        list.add(new PDFModel("Do as directed","http://gadgetspidy.com/pdf/.pdf"));
        list.add(new PDFModel("Indirect speech", "http://gadgetspidy.com/pdf/"));
        list.add(new PDFModel("Complete the sentences using the functions","http://gadgetspidy.com/pdf/"));
        list.add(new PDFModel("Combine sentences","http://gadgetspidy.com/pdf/"));
        list.add(new PDFModel("Correcting the errors","http://gadgetspidy.com/pdf/"));
        list.add(new PDFModel("Information transfer tips", "http://gadgetspidy.com/pdf/"));
        list.add(new PDFModel("Essay writing","http://gadgetspidy.com/pdf/EssayWriting12.pdf"));
        list.add(new PDFModel("Speech writing","http://gadgetspidy.com/pdf/SpeechWriting12.pdf"));
        list.add(new PDFModel("Email writing","http://gadgetspidy.com/pdf/EmailWriting12.pdf"));
        list.add(new PDFModel("Report writing","http://gadgetspidy.com/pdf/Reportwriting12.pdf"));



        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        ItemClickListener itemClickListener = new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Intent intent = new Intent(English_12_pdf.this,PDFActivity4.class);
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

