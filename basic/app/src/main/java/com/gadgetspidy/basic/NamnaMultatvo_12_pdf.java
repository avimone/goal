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

public class NamnaMultatvo_12_pdf extends AppCompatActivity {
    private InterstitialAd mInterstitialAd ;
    RecyclerView recyclerView;
    public static List<PDFModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_namna_multatvo_12_pdf);

        recyclerView = findViewById(R.id.RV);

        list = new ArrayList<>();
        list.add(new PDFModel("PDF One","https://www.cs.cmu.edu/afs/cs.cmu.edu/user/gchen/www/download/java/LearnJava.pdf"));
        list.add(new PDFModel("PDF Two", "http://gadgetspidy.com/english_.pdf"));
        list.add(new PDFModel("PDF Three","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"));
        list.add(new PDFModel("PDF Four","http://www.keepandshare.com/doc2/view.php?id=114624&da=y"));
        list.add(new PDFModel("PDF Five","https://firebasestorage.googleapis.com/v0/b/gadgetspidy.appspot.com/o/english_sem1.pdf?alt=media&token=199a5550-62bd-4518-bde0-a43bb130c7c4"));
        list.add(new PDFModel("PDF Six","https://www.cs.cmu.edu/afs/cs.cmu.edu/user/gchen/www/download/java/LearnJava.pdf"));
        list.add(new PDFModel("PDF Seven","https://www.cs.cmu.edu/afs/cs.cmu.edu/user/gchen/www/download/java/LearnJava.pdf"));

        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        ItemClickListener itemClickListener = new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Intent intent = new Intent(NamnaMultatvo_12_pdf.this,PDFActivity5.class);
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

