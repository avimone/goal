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

public class English_10_pdf extends AppCompatActivity {
    private InterstitialAd mInterstitialAd ;
    RecyclerView recyclerView;
    public static List<PDFModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_10_pdf);

        recyclerView = findViewById(R.id.RV);

        list = new ArrayList<>();




        list.add(new PDFModel("Short note","http://gadgetspidy.com/pdf/.pdf"));
        list.add(new PDFModel("Complete the dialogue (function based)", "http://gadgetspidy.com/pdf/.pdf"));
        list.add(new PDFModel("Match the columns (identify functions)","http://gadgetspidy.com/pdf/.pdf"));
        list.add(new PDFModel("Complete the sentences (function based)","http://gadgetspidy.com/pdf/.pdf"));
        list.add(new PDFModel("Complete the paragraph (Main Text)","http://gadgetspidy.com/pdf/.pdf"));
        list.add(new PDFModel("Nearest meaning","http://gadgetspidy.com/pdf/NearestMeanings10.pdf"));
        list.add(new PDFModel("Indirect speech","http://gadgetspidy.com/pdf/.pdf"));
        list.add(new PDFModel("Conjunctions","http://gadgetspidy.com/pdf/.pdf"));
        list.add(new PDFModel("Correcting errors","http://gadgetspidy.com/pdf/.pdf"));
        list.add(new PDFModel("Do as  directed","http://gadgetspidy.com/pdf/DoAsDirected10.pdf"));
        list.add(new PDFModel("Select the questions","http://gadgetspidy.com/pdf/.pdf"));
        list.add(new PDFModel("Paragraph writing","http://gadgetspidy.com/pdf/ParagraphWriting10.pdf"));
        list.add(new PDFModel("Email writing","http://gadgetspidy.com/pdf/EMailWriting.pdf"));
        list.add(new PDFModel("Report writing","http://gadgetspidy.com/pdf/ReportWriting.pdf"));


        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        ItemClickListener itemClickListener = new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Intent intent = new Intent(English_10_pdf.this,PDFActivity10.class);
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

