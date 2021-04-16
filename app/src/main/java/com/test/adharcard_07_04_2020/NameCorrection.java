package com.test.adharcard_07_04_2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NameCorrection extends AppCompatActivity {
Button yourname_correction,fathername_correction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_correction);
        yourname_correction=findViewById(R.id.bt_yournameCorrection);
        fathername_correction=findViewById(R.id.bt_fathernamecorrection);
        yourname_correction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),YoursNameCorrection.class);
                startActivity(i);
            }
        });
        fathername_correction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),FathersNameCorrection.class);
                startActivity(i);
            }
        });
    }
}