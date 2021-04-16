package com.test.adharcard_07_04_2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main5Activityfront extends AppCompatActivity {
Button new_button,kyc,correction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5_activityfront);
        new_button=findViewById(R.id.bt_new);
        kyc=findViewById(R.id.bt_kyc);
        correction=findViewById(R.id.bt_correction);
        new_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
       correction.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent1= new Intent(getApplicationContext(),Main6Activity.class);
               startActivity(intent1);
           }
       });
       kyc.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent1= new Intent(getApplicationContext(),KYC.class);
               startActivity(intent1);
           }
       });
    }

}
