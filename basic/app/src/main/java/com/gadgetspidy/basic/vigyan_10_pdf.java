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

public class vigyan_10_pdf extends AppCompatActivity {
    private InterstitialAd mInterstitialAd ;
    RecyclerView recyclerView;
    public static List<PDFModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vigyan_10_pdf);

        recyclerView = findViewById(R.id.RV);

        list = new ArrayList<>();
        list.add(new PDFModel("રાસાયણિક પ્રક્રિયાઓ અને સમીકરણો","https://catapultic-adviser.000webhostapp.com/scione.pdf"));
        list.add(new PDFModel("એસિડ બેઇઝ અને ક્ષાર", "https://catapultic-adviser.000webhostapp.com/scitwo.pdf"));
        list.add(new PDFModel("ધાતુઓ અને અધાતુઓ","https://catapultic-adviser.000webhostapp.com/scithree.pdf"));
        list.add(new PDFModel("કાર્બન અને તેનાં સંયોજનો","https://catapultic-adviser.000webhostapp.com/scifour.pdf"));
        list.add(new PDFModel("તત્વોનું આવર્તી  વગીકરણ","https://catapultic-adviser.000webhostapp.com/scifive.pdf"));
        list.add(new PDFModel("જૈવિક ક્રિયાઓ","https://catapultic-adviser.000webhostapp.com/scisix.pdf"));
        list.add(new PDFModel("નિયંત્રણ અને સંકલન","https://catapultic-adviser.000webhostapp.com/sciseven.pdf"));
        list.add(new PDFModel("સજીવો કેવી રીતે પ્રજનન કરે છે?","https://catapultic-adviser.000webhostapp.com/scieight.pdf"));
        list.add(new PDFModel("આનુવંશિકતા અને ઉદવિકાસ", "https://catapultic-adviser.000webhostapp.com/scinine.pdf"));
        list.add(new PDFModel("પ્રકાશ પરાવર્તન અને વક્રીભવન","https://catapultic-adviser.000webhostapp.com/sciten.pdf"));
        list.add(new PDFModel("માનવ આંખ અને રંગબેરંગી દુનિયા","https://catapultic-adviser.000webhostapp.com/scieleven.pdf"));
        list.add(new PDFModel("વિદ્યુત","https://catapultic-adviser.000webhostapp.com/scitwelve.pdf"));
        list.add(new PDFModel("િદ્યુતપ્રવાહની ચુંબકીય અસરો", "https://catapultic-adviser.000webhostapp.com/scithirteen.pdf"));
        list.add(new PDFModel("ઊર્જાના સ્ત્રોતો","https://catapultic-adviser.000webhostapp.com/sciforteen.pdf"));
        list.add(new PDFModel("આપણું પર્યાવરણ","https://catapultic-adviser.000webhostapp.com/scififteen.pdf"));
        list.add(new PDFModel("નૈસર્ગિક સ્ત્રોતો નું ટકાઉ પ્રબંધન","https://catapultic-adviser.000webhostapp.com/scisixteen.pdf"));
        list.add(new PDFModel("March 2020 બોર્ડની પરીક્ષા માટે ના Most Imp પ્રશ્નો","https://catapultic-adviser.000webhostapp.com/sciseventeen.pdf"));






        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        ItemClickListener itemClickListener = new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Intent intent = new Intent(vigyan_10_pdf.this,PDFActivity11.class);
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

