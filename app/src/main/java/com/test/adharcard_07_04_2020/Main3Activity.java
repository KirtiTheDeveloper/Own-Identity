package com.test.adharcard_07_04_2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
Bitmap photo;
    Button front,back,both;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        front=findViewById(R.id.bt_front_card);
        back=findViewById(R.id.bt_back_card);

        Intent intent=getIntent();
        photo=intent.getParcelableExtra("photo");
        front.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(getApplicationContext(),Main2Activity.class);
                intent3.putExtra("photo1",photo);
                startActivity(intent3);

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(getApplicationContext(),Main4Activity.class);
                startActivity(intent2);
            }
        });
    }
    }

