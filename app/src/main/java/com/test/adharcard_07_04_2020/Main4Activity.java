package com.test.adharcard_07_04_2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {
TextView landmark,fathername,house_no,city,state,sector,pincode,city2,gender;
Bitmap photo1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        landmark=findViewById(R.id.tv_landmark3);
        fathername=findViewById(R.id.tv_fathername3);
        house_no=findViewById(R.id.tv_house_no3);
        city=findViewById(R.id.tv_city3);
        state=findViewById(R.id.tv_state3);
        sector=findViewById(R.id.tv_sector3);
        pincode=findViewById(R.id.tv_pincode3);
        city2=findViewById(R.id.tv_city4);

        SharedPreferences getsaved=getSharedPreferences("name1",MODE_PRIVATE);
        String landmark3,city4,state4,pincode4,fathername1,sector1,house_no1;
        landmark3 = getsaved.getString("landmark", "try Again");
        landmark.setText(landmark3);
        city4=getsaved.getString("city","try Again");
        city.setText(city4);
        city2.setText(city4);
        state4=getsaved.getString("state","try again");
        state.setText(state4);
        pincode4=getsaved.getString("pincode","try again");
        pincode.setText(pincode4);
        fathername1=getsaved.getString("fathername","try again");
        fathername.setText(fathername1);
        sector1=getsaved.getString("sector","try again");
        sector.setText(sector1);
        house_no1=getsaved.getString("houseno","try again");
        house_no.setText(house_no1);
    }
}
