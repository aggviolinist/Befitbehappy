package com.example.befitbehappy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class ThirdActivity extends AppCompatActivity {


    int[] newArray;
    //private Thread view;
    private AdView mAdView1,mAdView2,mAdView3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);


        //Toolbar toolbar = findViewById(R.id.toolBar);
        //setSupportActionBar(toolbar);

        mAdView1 = findViewById(R.id.adView1);
        AdRequest adRequest1 = new AdRequest.Builder().build();
        mAdView1.loadAd(adRequest1);

        mAdView2 = findViewById(R.id.adView2);
        AdRequest adRequest2 = new AdRequest.Builder().build();
        mAdView2.loadAd(adRequest2);

        mAdView3 = findViewById(R.id.adView3);
        AdRequest adRequest3 = new AdRequest.Builder().build();
        mAdView3.loadAd(adRequest3);




        newArray = new int[]{
                R.id.dips_exercise, R.id.climbers_exercise, R.id.sit_exercise, R.id.bikini_exercise, R.id.flutter_exercise, R.id.obliques_exercise, R.id.pilate_exercise, R.id.planks_exercise, R.id.reverse_exercise, R.id.russian_exercise, R.id.starfish_exercise, R.id.side_exercise,

        };
    }


    /**   public void squats(View view) {

     }
     **/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id== R.id.id_privacy)
        {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.termsfeed.com/live/c6fd5d9a-82e7-4a8a-8cbf-c42b950289bb"));
            startActivity(intent);
            return true;
        }
        if(id== R.id.id_terms)
        {
            Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://app.termly.io/dashboard/website/a067ccb7-68a5-47bc-a602-e57dcfd6d623/terms-of-service"));
            startActivity(intent);
            return true;
        }
        if(id== R.id.rate)
        {
            try {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("market://details?id=" +getPackageName())));

            }catch (Exception ex)
            {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id=" +getPackageName())));
            }
            return true;
        }
        if(id== R.id.more)
        {
            Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(""));
            startActivity(intent);
            return true;
        }
        if(id== R.id.share)
        {
            Intent myintent = new Intent(Intent.ACTION_SEND);
            myintent.setType("text/plain");
            String sharebody = "Hi ladies finally, here is an app to help you workout \n It comprises of upper body section and a lower body section each with different workouts \n There is also a nutrition plan that will be really helpfull if strictly adhered \n To see progress BE CONSISTENT!! \n Download this free app now \n " + "https://play.google.com/store/apps/details?id=com.example.befitbehappy&hl=en";
            String sharehub = "Be fit Be happy";
            myintent.putExtra(Intent.EXTRA_SUBJECT,sharehub);
            myintent.putExtra(Intent.EXTRA_TEXT,sharebody);
            startActivity(Intent.createChooser(myintent,"share using "));
            return true;
        }
        return true;
    }

    public void Imagebuttonclick(View view) {

        for(int i=0;i<newArray.length;i++){


            if(view.getId() == newArray[i]){

                int value = i+1;
                Log.i("FIRST",String.valueOf(value));
                Intent intent = new Intent(ThirdActivity.this,FifthActivity2.class);

                intent.putExtra("value",String.valueOf(value));

                startActivity(intent);
            }
        }

    }
}