package com.myprofile.pic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(MainActivity.this, "ca-app-pub-3940256099942544~3347511713");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        final TextView result1= findViewById(R.id.result);
        final EditText dia= findViewById(R.id.textView);
        final EditText preis    = findViewById(R.id.textView2);
        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try{
                float dia_f = Float.valueOf(dia.getText().toString());
                float preis_f= Float.valueOf((preis.getText()).toString());
                float pi=(float)Math.PI  ;
                DecimalFormat df = new DecimalFormat(".###");
                float pay = preis_f/(pi*(dia_f/2)*(dia_f/2));
                String pay_r= df.format(pay);
                String value =df.format(1/pay);
                result1.setText("You are paying "+pay_r+" Currency for 1 cm^2 "+"\r\n"+"your Pizza Value is "+value);}
                catch (Exception e){

                }



        }});
    }
}