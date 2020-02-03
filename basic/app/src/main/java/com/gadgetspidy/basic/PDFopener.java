package com.gadgetspidy.basic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;


public class PDFopener extends AppCompatActivity {
PDFView mypdfview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfopener);
        mypdfview = (PDFView) findViewById(R.id.pdfviewer);
        String getfile = getIntent().getStringExtra("name");



        //vanijya vyavastha

        if (getfile.equals("સંચાલનના સિદ્ધાંતો")) {
            mypdfview.fromAsset("sanchsidhanto.pdf").load();
        }

        if (getfile.equals("સંચાલનનુ સ્વરૂપ અને મહત્વ")) {
            mypdfview.fromAsset("ss.pdf").load();
        }

        if (getfile.equals("આયોજન")) {
            mypdfview.fromAsset("aayojan.pdf").load();
        }

        if (getfile.equals("વ્યવસ્થાતંત્ર")) {
            mypdfview.fromAsset("vyavstha.pdf").load();
        }
        if(getfile.equals("કર્મચારી વ્યવસ્થા"))
        {
            mypdfview.fromAsset("krmchari.pdf").load();
        }

        if(getfile.equals("દોરવણી"))
        {
            mypdfview.fromAsset("krmchari.pdf").load();

        }
        if(getfile.equals("અંકુશ"))
        {
            mypdfview.fromAsset("ankus.pdf").load();
        }

        if(getfile.equals("નાણાકીય સંચાલન"))
        {
            mypdfview.fromAsset("nanakiy.pdf").load();
        }
        if(getfile.equals("નાણાકીય બજાર"))
        {
            mypdfview.fromAsset("nanab.pdf").load();
        }
        if(getfile.equals("બજાર પ્રક્રિયા સંચાલન"))
        {
            mypdfview.fromAsset("bajar.pdf").load();
        }

        if(getfile.equals("ગ્રાહક સુરક્ષા"))
        {
            mypdfview.fromAsset("grahak.pdf").load();
        }
        if(getfile.equals("ધંધાકીય પર્યાવરણ"))
        {
            mypdfview.fromAsset("dhandho.pdf").load();
        }

  //motivation
        if(getfile.equals("Story-1"))
        {
            mypdfview.fromAsset("motivate.pdf").load();
        }



        //vigyan

        if(getfile.equals("રાસાયણિક પ્રક્રિયાઓ અને સમીકરણો"))
        {
            mypdfview.fromAsset("sciencelession.pdf").load();
        }
    }
}
