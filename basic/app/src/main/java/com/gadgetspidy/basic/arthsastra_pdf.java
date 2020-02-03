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

public class arthsastra_pdf extends AppCompatActivity {
    private InterstitialAd mInterstitialAd ;
    RecyclerView recyclerView;
    public static List<PDFModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arthsastra_pdf);

        recyclerView = findViewById(R.id.RV);

        list = new ArrayList<>();
        list.add(new PDFModel("અર્થશાસ્ત્રમાં આલેખ","https://gadgetspidy.com/pdf/earthshastraone.pdf"));
        list.add(new PDFModel("વૃદ્ધિ અને વિકાસના નિર્દેશકો", "http://gadgetspidy.com/pdf/earthshastratwo.pdf"));
        list.add(new PDFModel("નાણું અને ફુગાવો","http://gadgetspidy.com/pdf/earthshastrathree.pdf"));
        list.add(new PDFModel("બેન્કિંગ અને નાણાકીય નીતિ","http://gadgetspidy.com/pdf/earthshastrafour.pdf"));
        list.add(new PDFModel("ગરીબી","http://gadgetspidy.com/pdf/earthshastrafive.pdf"));
        list.add(new PDFModel("બેરોજગારી","http://gadgetspidy.com/pdf/earthshastrasix.pdf"));
        list.add(new PDFModel("વસ્તી","http://gadgetspidy.com/pdf/earthshastraseven.pdf"));
        list.add(new PDFModel("કૃષિ ક્ષેત્ર","http://gadgetspidy.com/pdf/earthshastraeight.pdf"));
        list.add(new PDFModel("વિદેશ વેપાર", "http://gadgetspidy.com/pdf/earthshastranine.pdf"));
        list.add(new PDFModel("ઉદ્યોગ ક્ષેત્ર","http://gadgetspidy.com/pdf/earthshastraten.pdf"));
        list.add(new PDFModel("ભારતીય અર્થતંત્રમાં નૂતન પ્રશ્નો", "http://gadgetspidy.com/pdf/earthshastraeleven.pdf"));
        list.add(new PDFModel("March 2020 ની બોર્ડ પરીક્ષા માટે Most Imp પ્રશ્નો", "http://gadgetspidy.com/pdf/earthshastratwelve.pdf"));
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        ItemClickListener itemClickListener = new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Intent intent = new Intent(arthsastra_pdf.this,PDFActivity1.class);
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

