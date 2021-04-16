package com.test.adharcard_07_04_2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class YoursNameCorrection extends AppCompatActivity {
EditText old_name,new_name;
Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yours_name_correction);
        old_name=findViewById(R.id.ync_nameold);
        new_name=findViewById(R.id.ync_namenew);
        submit=findViewById(R.id.ync_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Your Information is updated",Toast.LENGTH_LONG).show();
            }
        });
    }
}