package com.test.adharcard_07_04_2020;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class Main2Activity<selectedid> extends AppCompatActivity {
    TextView dob, fathername, landmark, city,email, state, house_no, sector, pincode, gender, phone, fname, lname, city2, fname1, lname1, dau_of, son_of;
    ImageView imgpic;
    Bitmap photo1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        fname = findViewById(R.id.tv_fname1);
        lname = findViewById(R.id.tv_lname1);
        fname1 = findViewById(R.id.tv_fname2);
        lname1 = findViewById(R.id.tv_lname2);
        email=findViewById(R.id.tv_email1);
        dob = findViewById(R.id.tv_dob2);
        landmark = findViewById(R.id.tv_landmark1);
        fathername = findViewById(R.id.tv_fathername1);
        house_no = findViewById(R.id.tv_house_no1);
        gender = findViewById(R.id.tv_gender1);
        city = findViewById(R.id.tv_city1);
        state = findViewById(R.id.tv_state1);
        phone = findViewById(R.id.tv_ph1);
        sector = findViewById(R.id.tv_sector1);
        pincode = findViewById(R.id.tv_pincode1);
        imgpic=findViewById(R.id.iv_adhrpic);
        city2 = findViewById(R.id.tv_city2);
        dau_of = findViewById(R.id.tv_do);
        son_of = findViewById(R.id.tv_so);

        String fname2, lname2, gender2, landmark2, fathername2, city3, state2;
        Intent intent=getIntent();
        photo1= intent.getParcelableExtra("photo1");
        imgpic.setImageBitmap(photo1);
        String ph2, pincode2, sector2, house_no2, dob2, email1;


        SharedPreferences getsaved = getSharedPreferences("name1", MODE_PRIVATE);
        fname2 = getsaved.getString("fname", "try Again");
        fname.setText(fname2);
        fname1.setText(fname2);
        lname2 = getsaved.getString("lname", "try Again");
        lname.setText(lname2);
        lname1.setText(lname2);
        landmark2 = getsaved.getString("landmark", "try Again");
        landmark.setText(landmark2);
        gender2 = getsaved.getString("gender", "try Again");
        gender.setText(gender2);
        fathername2 = getsaved.getString("fathername", "try Again");
        fathername.setText(fathername2);
        city3 = getsaved.getString("city", "try Again");
        city.setText(city3);
        city2.setText(city3);
        state2 = getsaved.getString("state", "try Again");
        state.setText(state2);
        ph2 = getsaved.getString("ph1", "try again");
        phone.setText(ph2);
        pincode2 = getsaved.getString("pincode", "try again");
        pincode.setText(pincode2);
        sector2 = getsaved.getString("sector", "try again");
        sector.setText(sector2);
        house_no2 = getsaved.getString("houseno", "try again");
        house_no.setText(house_no2);
        dob2 = getsaved.getString("dob", "try again");
        dob.setText(dob2);
        email1=getsaved.getString("email","try again");
        email.setText(email1);

        if (gender2.equals("Male")) {
            son_of.setVisibility(View.VISIBLE);
            dau_of.setVisibility(View.GONE);

        }
        else {
            dau_of.setVisibility(View.VISIBLE);
            son_of.setVisibility(View.GONE);
        }
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + phone.getText().toString()));//change the number
                if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    Activity#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for Activity#requestPermissions for more details.
                    return;
                }
                startActivity(callIntent);
            }
            });
                   email.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent email = new Intent(Intent.ACTION_SEND);
                    email.putExtra(Intent.EXTRA_EMAIL, new String[]{phone.getText().toString()});
                    email.putExtra(Intent.EXTRA_SUBJECT, "adhaar card");
                    email.putExtra(Intent.EXTRA_TEXT, "hi");

                    //need this to prompts email client only
                    email.setData(Uri.parse("mailto:"));
                    email.setType("text/plain");

                    startActivity(Intent.createChooser(email, "Choose an Email client :"));

                }
                   });

}
}