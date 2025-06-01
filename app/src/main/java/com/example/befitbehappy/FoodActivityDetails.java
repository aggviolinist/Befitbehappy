package com.example.befitbehappy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class FoodActivityDetails extends AppCompatActivity {

    TextView textView;
    private AdView mAdView1;
    private InterstitialAd mInterstitialAd;
    String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);

        mAdView1 = findViewById(R.id.adView1);
        AdRequest adRequest1 = new AdRequest.Builder().build();
        mAdView1.loadAd(adRequest1);

        AdRequest adRequest = new AdRequest.Builder().build();





        textView = findViewById(R.id.txt);
        String dstory =getIntent().getStringExtra("story");
        textView.setText(dstory);

    }

    public void goback(View view) {


        Intent intent = new Intent(FoodActivityDetails.this,FoodActivity.class);
        startActivity(intent);
        finish();


    }

    /**
     * Called when the activity has detected the user's press of the back
     * key. The {@link #getOnBackPressedDispatcher() OnBackPressedDispatcher} will be given a
     * chance to handle the back button before the default behavior of
     * {@link Activity#onBackPressed()} is invoked.
     *
     * @see #getOnBackPressedDispatcher() 0780533788
     */
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(FoodActivityDetails.this,FoodActivity.class);
        startActivity(intent);
        finish();



    }
}