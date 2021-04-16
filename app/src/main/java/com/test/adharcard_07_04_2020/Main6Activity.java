package com.test.adharcard_07_04_2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main6Activity extends AppCompatActivity {
Button name,emailAddress,phchange,dobadd,addresschange,photochnge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        name=findViewById(R.id.bt_namecorrection);
        emailAddress=findViewById(R.id.bt_emailcorrection);
        phchange=findViewById(R.id.bt_phnochange);
        dobadd=findViewById(R.id.bt_adddob);
        addresschange=findViewById(R.id.bt_addresschange);
        photochnge=findViewById(R.id.bt_photochnge);
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),NameCorrection.class);
                startActivity(i);

            }
        });
        emailAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), EmailAddressUpdate.class);
                startActivity(i);

            }
        });
        photochnge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),PhotoChangeCorrection.class);
                startActivity(i);

            }
        });
        addresschange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), AddressChangeCorrection.class);
                startActivity(i);

            }
        });
        dobadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),AddDob.class);
                startActivity(i);

            }
        });
        phchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),PhoneNumberCorrection.class);
                startActivity(i);

            }
        });

    }
}
