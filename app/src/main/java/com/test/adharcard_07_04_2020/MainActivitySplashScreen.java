package com.test.adharcard_07_04_2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

public class MainActivitySplashScreen extends AppCompatActivity {
ProgressBar  pb;
int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_splash_screen);
        pb=findViewById(R.id.pb_loading);
        i=pb.getProgress();
        i=i+10;
        pb.setProgress(i);
        Handler hand=new Handler();
        Runnable run =new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(getApplicationContext(),Main5Activityfront.class);
                startActivity(intent);
                finish();
            }
        };
        hand.postDelayed(run,10000);
    }
}
