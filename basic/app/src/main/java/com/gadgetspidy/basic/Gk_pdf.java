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

public class Gk_pdf extends AppCompatActivity {
    private InterstitialAd mInterstitialAd ;
    RecyclerView recyclerView;
    public static List<PDFModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gk_pdf);

        recyclerView = findViewById(R.id.RV);

        list = new ArrayList<>();
        list.add(new PDFModel("All in One - ગણિત","https://gadgetspidy.com/pdf/gk.pdf"));
        list.add(new PDFModel("GK Tricks", "http://gadgetspidy.com/pdf/gk1.pdf"));
        list.add(new PDFModel("Maths Imp Points","http://gadgetspidy.com/pdf/gk2.pdf"));
        list.add(new PDFModel("Roman Numers 1 to 100","http://gadgetspidy.com/pdf/gk3.pdf"));
        list.add(new PDFModel("કેલેન્ડર આધારિત પ્રશ્ન","http://gadgetspidy.com/pdf/gk4.pdf"));
        list.add(new PDFModel("ગણિતના અગત્યના નિયમો અને સૂત્ર","http://gadgetspidy.com/pdf/gk5.pdf"));
        list.add(new PDFModel("ગુજરાત વિશે 4000 પ્રશ્નો","http://gadgetspidy.com/pdf/gk6.pdf"));
        list.add(new PDFModel("તમામ પરીક્ષા માટેનું માર્ગદર્શન","http://gadgetspidy.com/pdf/gk7.pdf"));
        list.add(new PDFModel("તમામ પરીક્ષાઓ માટેનો સિલેબસ", "http://gadgetspidy.com/pdf/gk8.pdf"));
        list.add(new PDFModel("દેશોની રાજધાની અને ચલણ","http://gadgetspidy.com/pdf/gk9.pdf"));
        list.add(new PDFModel("ધાતુ સંજ્ઞાઓ", "http://gadgetspidy.com/pdf/gk10.pdf"));
        list.add(new PDFModel("ધાતુ સંયોજનો", "http://gadgetspidy.com/pdf/gk11.pdf"));
        list.add(new PDFModel("પ્રસિદ્ધ ગુજરાતીઓ","https://gadgetspidy.com/pdf/gk12.pdf"));
        list.add(new PDFModel("ભાગાકારની ચાવીઓ", "http://gadgetspidy.com/pdf/gk13.pdf"));
        list.add(new PDFModel("ભારત વિશે 2000 પ્રશ્નો","http://gadgetspidy.com/pdf/gk14.pdf"));
        list.add(new PDFModel("રાસાયણિક સૂત્રો","http://gadgetspidy.com/pdf/gk15.pdf"));
        list.add(new PDFModel("વિજ્ઞાન  એક લાઈનમાં જનરલ નોલેજ","http://gadgetspidy.com/pdf/gk16.pdf"));
        list.add(new PDFModel("વિજ્ઞાન ભાગ ૧ માનવ શરીર","http://gadgetspidy.com/pdf/gk17.pdf"));
        list.add(new PDFModel("વિજ્ઞાનની વિવિધ શાખાઓ","http://gadgetspidy.com/pdf/gk18.pdf"));
        list.add(new PDFModel("વિટામિનો અને તેના ઉપયોગો","https://gadgetspidy.com/pdf/gk19.pdf"));
        list.add(new PDFModel("વિશ્વની ભૂગોળ", "http://gadgetspidy.com/pdf/gk20.pdf"));
        list.add(new PDFModel("વિશ્વનો ઈતિહાસ","http://gadgetspidy.com/pdf/gk21.pdf"));
        list.add(new PDFModel("શોધ અને શોધકો","http://gadgetspidy.com/pdf/gk22.pdf"));
        list.add(new PDFModel("સંખ્યા પદ્ધતિ","http://gadgetspidy.com/pdf/gk23.pdf"));
        list.add(new PDFModel("સરકાર ની અગત્ય ની યોજનાઓ","http://gadgetspidy.com/pdf/gk24.pdf"));


        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        ItemClickListener itemClickListener = new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Intent intent = new Intent(Gk_pdf.this,PDFActivity17.class);
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

