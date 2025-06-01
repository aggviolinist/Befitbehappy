package com.example.befitbehappy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;








import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {

    Button button1,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);**/



        button1 = findViewById(R.id.startyoga1);
        button2 = findViewById(R.id.startyoga2);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SecondActivity2.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ThirdActivity.class);
                startActivity(intent);
            }
        });



    }

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

    public void squats(View view) {
        Intent intent = new Intent(MainActivity.this,SecondActivity2.class);
        startActivity(intent);
    }

    public void donkey_kicks(View view) {
        Intent intent = new Intent(MainActivity.this,ThirdActivity.class);
        startActivity(intent);
    }

    public void food(View view) {
        Intent intent = new Intent(MainActivity.this,FoodActivity.class);
        startActivity(intent);
    }
}