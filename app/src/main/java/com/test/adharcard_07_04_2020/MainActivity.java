package com.test.adharcard_07_04_2020;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AlertDialogLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.icu.util.Calendar;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText fname, lname, dob, fathername, landmark, city, state, house_no, sector, pincode, phone,email;
    Button submit, capture;
    String str_fathername, str_ph, str_houseno, str_date_of_birth, str_sec, str_pin,str_email,str_gender;
    String str_fname, str_lname, str_landmark, str_city, str_state,str_female,str_male;
   ImageView img;
   RadioButton genderradiobutton;
   RadioGroup radioGroup;
   Bitmap photo;
   Spinner spinner_city,spinner_haryana;
   int mYear,mMonth,mDate;
   CheckBox accept;

    String[] arr_city={"Select the city","Adoni","Amaravati","Anantapur","Bhopal","Bilaspur","Bhilai","Chamba","Chandragiri","chandigarh","Daman","Diu","Delhi","Dwarka",
            "Faridabad","Firozpur Jhirka","Gandhinagar","Godhra","Gurgaon","Gwalior","Hansi","Hisar","Indore","jind",
            "Jamnagar","junagadh","Kaithal","Karnal","Kangra","Kullu","Kurushetra","Mumbai","Panaji","Panipat","Pehowa","Ranchi","RajMahal","Rewari","Rohtak","Shimla","Sirsa","Sonipat",
            "Thiruvananthapuram"};
    String[] arr_haryana={"Select your state","Andra Pradesh","Andaman and Nicobar Islands","Arunachal Pradesh","Assam","Bihar","Chandigarh","Chattisgarh",
            "Dadra and Nagar Haveli and Daman and Diu","Delhi","Goa","Gujarat",
    "Haryana","Himachal Pradesh","Jammu and Kashmir","Jharkhand","Karnataka","Kerala","Ladakh","Lakshadweep","Madhya Pradesh","Maharashtra","Manipur",
            "Meghalaya","Mizoram","Nagaland","Odisha","Puducherry","Punjab","Rajasthan","Sikkim","Tamil Nadu",
    "Telangana","Tripura","Uttar Pradesh","Uttarakhand","West Bengal"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fname = findViewById(R.id.et_fname);
        lname = findViewById(R.id.et_lname);
        dob = findViewById(R.id.et_dob);
        landmark = findViewById(R.id.et_landmark);
        fathername = findViewById(R.id.et_fathername);
        submit = findViewById(R.id.bt_submit);
        house_no = findViewById(R.id.et_house_no);
        radioGroup = findViewById(R.id.radioGroup);
        email = findViewById(R.id.et_email);
        city = findViewById(R.id.et_city);
        state = findViewById(R.id.et_state);
        phone = findViewById(R.id.et_ph);
        sector = findViewById(R.id.et_sector);
        pincode = findViewById(R.id.et_pincode);
        capture = findViewById(R.id.bt_capture);
        img = findViewById(R.id.tv_img);
        accept = findViewById(R.id.cb_checkBox);
        spinner_haryana = findViewById(R.id.sp_haryana);
        spinner_city = findViewById(R.id.sp_city);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAllText();
                int selectedid = radioGroup.getCheckedRadioButtonId();
                genderradiobutton = findViewById(selectedid);
                //str_gender=genderradiobutton.getText().toString();

                getAllText();

                setAllText();
                saveApplicant();

            }

        });
        capture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Upload a Picture");
                builder.setMessage("Select An Option");
                builder.setPositiveButton("Gallery", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(intent, 1);
                    }
                });
                builder.setNegativeButton("Camera", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(intent1, 2);

                    }
                });
                builder.setCancelable(true);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDate = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerdialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                if ((dayOfMonth <= 31 && month <= 12 && year < mYear) || ((dayOfMonth <= mDate && month == mMonth && year == mYear) || (dayOfMonth <= 31 && month < mMonth && year == mYear) || (dayOfMonth <= mDate && month > 12 && year > mYear))) {
                                    dob.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                                } else {
                                    Toast.makeText(getApplicationContext(), "Please enter valid date", Toast.LENGTH_LONG);
                                }
                            }
                        }, mYear, mMonth, mDate);
                //  datePickerdialog.getDatePicker().setMaxDate(System.currentTimeMillis());
                //  datePickerdialog.getDatePicker().setMinDate(System.currentTimeMillis());
                datePickerdialog.show();
            }
        });


        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, arr_city);
        spinner_city.setAdapter(adapter);
        spinner_city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                str_city = arr_city[position];
                city.setText(str_city);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter adapter1=new ArrayAdapter(this,android.R.layout.simple_spinner_item,arr_haryana);
        spinner_haryana.setAdapter(adapter1);

        spinner_haryana.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                str_state=arr_haryana[position];
                state.setText(str_state);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2 && resultCode == Activity.RESULT_OK)
        {  photo = (Bitmap) data.getExtras().get("data");

             img.setImageBitmap(photo);
        }
        else if (requestCode == 1 && resultCode == Activity.RESULT_OK&& data != null && data.getData() != null){
            Uri selectedImage = data.getData();

            try {
                 photo = MediaStore.Images.Media.getBitmap(getContentResolver(),selectedImage);
            } catch (IOException e) {
                e.printStackTrace();
            }
            img.setImageBitmap(photo);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.clear();
    }
    private void getAllText()
    {
        str_fname = fname.getText().toString();
        str_lname = lname.getText().toString();
        str_landmark = landmark.getText().toString();
        str_fathername = fathername.getText().toString();
        str_city = city.getText().toString();
        str_state = state.getText().toString();
        str_ph = phone.getText().toString();
        str_pin = pincode.getText().toString();
        str_houseno = house_no.getText().toString();
        str_date_of_birth = dob.getText().toString();
        str_email = email.getText().toString();

        str_sec = sector.getText().toString();
    }
    private void setAllText()
    {
        SharedPreferences saving = getSharedPreferences("name1", MODE_PRIVATE);
        SharedPreferences.Editor editor = saving.edit();
        editor.putString("fname", str_fname);
        editor.putString("lname", str_lname);
        editor.putString("fathername", str_fathername);
        editor.putString("landmark", str_landmark);
        editor.putString("female", str_female);
        editor.putString("male", str_male);
        editor.putString("city", str_city);
        editor.putString("state", str_state);
        editor.putString("ph1", str_ph);
        editor.putString("houseno", str_houseno);
        editor.putString("dob", str_date_of_birth);
        editor.putString("sector", str_sec);
        editor.putString("pincode", str_pin);
        editor.putString("email", str_email);
        editor.putString("gender",str_gender);
        editor.apply();
        if(accept.isChecked())
        {
            Toast.makeText(getApplicationContext(),"you accepted all the terms",Toast.LENGTH_LONG);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Please accept all the conditions",Toast.LENGTH_LONG);
        }


        Intent intent = new Intent(MainActivity.this, Main3Activity.class);
        intent.putExtra("photo",photo);
        startActivity(intent);
    }

    private void saveApplicant()
    {

        DatabaseReference myref=FirebaseDatabase.getInstance().getReference("Data");
        User user=new User(str_fname,str_lname,str_fathername,str_city,str_state,str_landmark,str_sec,str_houseno,str_pin,str_ph,str_email,str_date_of_birth);
        myref.child("data_user").push().setValue(user);
    }
}