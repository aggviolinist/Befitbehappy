package com.example.befitbehappy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class FifthActivity extends AppCompatActivity {


    String buttonvalue;
    Button startBtn;
    private CountDownTimer countDownTimer;
    TextView mtextview;
    private boolean MTimeRunning;
    private long MTimeLeftinmills;

    private InterstitialAd mInterstitialAd;
    String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);





        Intent intent = getIntent();
        buttonvalue = intent.getStringExtra("value");


        int intvalue = Integer.valueOf(buttonvalue);

        switch (intvalue)
        {

            case 1:
                setContentView(R.layout.activity_dips);
                break;
            case 2:
                setContentView(R.layout.activity_climbers);
                break;
            case 3:
                setContentView(R.layout.activity_sit);
                break;
            case 4:
                setContentView(R.layout.activity_bikini);
                break;
            case 5:
                setContentView(R.layout.activity_flutter);
                break;
            case 6:
                setContentView(R.layout.activity_obliques);
                break;
            case 7:
                setContentView(R.layout.activity_pilate);
                break;
            case 8:
                setContentView(R.layout.activity_planks);
                break;
            case 9:
                setContentView(R.layout.activity_reverse);
                break;
            case 10:
                setContentView(R.layout.activity_russian);
                break;
            case 11:
                setContentView(R.layout.activity_starfish);
                break;
            case 12:
                setContentView(R.layout.activity_side);
                break;



        }

        startBtn = findViewById(R.id.startbutton);
        mtextview = findViewById(R.id.time);


        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MTimeRunning)
                {
                    stoptimer();

                }

                else{

                    starTimer();

                }

            }


        });
    }

    private void stoptimer()
    {
        countDownTimer.cancel();
        MTimeRunning = false;
        startBtn.setText("START");

    }

    private void starTimer() {
        final CharSequence value1 = mtextview.getText();
        String num1 = value1.toString();
        String num2 = num1.substring(0, 2);
        String num3 = num1.substring(3, 5);


        final int number = Integer.valueOf(num2) * 60 + Integer.valueOf(num3);
        MTimeLeftinmills = number * 1000;

        countDownTimer = new CountDownTimer(MTimeLeftinmills, 1000) {
            @Override
            public void onTick(long l) {

                MTimeLeftinmills = l;
                updateTimer();

            }

            @Override
            public void onFinish() {

                int newvalue = Integer.valueOf(buttonvalue) + 1;
                if (newvalue <= 7) {
                    Intent intent = new Intent(FifthActivity.this, FifthActivity.class);

                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value", String.valueOf(newvalue));
                    startActivity(intent);
                } else {
                    newvalue = 1;
                    Intent intent = new Intent(FifthActivity.this, FifthActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value", String.valueOf(newvalue));
                    startActivity(intent);
                }


            }
        }.start();
        startBtn.setText("Pause");
        MTimeRunning = true;

    }

    private void updateTimer()
    {



        int minutes = (int) MTimeLeftinmills/60000;
        int seconds = (int) MTimeLeftinmills%60000 /1000;


        String timeLeftText="";
        if(minutes<10)
            timeLeftText = "0";
        timeLeftText = timeLeftText+minutes+":";
        if (seconds<10)
            timeLeftText+="0";
        timeLeftText+=seconds;
        mtextview.setText(timeLeftText);
    }

    /**
     * Called when the activity has detected the user's press of the back
     * key. The {@link #getOnBackPressedDispatcher() OnBackPressedDispatcher} will be given a
     * chance to handle the back button before the default behavior of
     * {@link Activity#onBackPressed()} is invoked.
     *
     * @see #getOnBackPressedDispatcher()
     */
    @Override
    public void onBackPressed() {

        Intent intent = new Intent(FifthActivity.this,SecondActivity2.class);
        startActivity(intent);
        finish();






    }
}