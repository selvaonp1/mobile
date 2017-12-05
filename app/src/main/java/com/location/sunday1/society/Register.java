package com.location.sunday1.society;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity {

    EditText e1,e2,e3,e4,e5,e6,e7,e8,e9,e10;
    String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10;
    Button b1;
    SQLiteHelper sq;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sq=new SQLiteHelper(this);
        e1 = (EditText)findViewById(R.id.editText);
        e2 = (EditText)findViewById(R.id.editText2);
        e3 = (EditText)findViewById(R.id.editText3);
        e4 = (EditText)findViewById(R.id.editText4);
        e5 = (EditText)findViewById(R.id.editText5);
        e6 = (EditText)findViewById(R.id.editText6);
        e7 = (EditText)findViewById(R.id.editText7);
        e8 = (EditText)findViewById(R.id.editText8);
        e9 = (EditText)findViewById(R.id.editText9);
        e10 = (EditText)findViewById(R.id.editText10);

        b1 = (Button)findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {





                    final String s = e2.getText().toString();
                    String s1 = e1.getText().toString();
                    String s2 = e2.getText().toString();
                    String s3 = e3.getText().toString();
                    String s4 = e4.getText().toString();
                    String s5 = e5.getText().toString();
                    String s6 = e6.getText().toString();
                    String s7 = e7.getText().toString();
                    String s8 = e8.getText().toString();
                    String s9 = e9.getText().toString();
                    String s10 = e10.getText().toString();


                            if(validate()==0) {
                                int i = sq.register(s1, s2, s3, s5, s6, s7, s8, s9, s10);
                                if (i == -1) {
                                    Toast.makeText(Register.this, "not registered", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(Register.this, "successfully registered", Toast.LENGTH_SHORT).show();
                                    Intent in = new Intent(Register.this, Login.class);
                                    startActivity(in);
                                }
                            }




            }
        });


    }

    public int validate(){

        int k=0;

        if(TextUtils.isEmpty(e1.getText()))
        {
            k=1;
            e1.setError("Please Fill the Field");
        }
        if(TextUtils.isEmpty(e2.getText()))
        {
            k=1;
            e2.setError("Please Fill the Field");
        }
        if(TextUtils.isEmpty(e3.getText()))
        {
            k=1;
            e3.setError("Please Fill the Field");
        }
        if(TextUtils.isEmpty(e4.getText()))
        {
            k=1;
            e4.setError("Please Fill the Field");
        }
        if(TextUtils.isEmpty(e5.getText()))
        {
            k=1;
            e5.setError("Please Fill the Field");
        }
        if(TextUtils.isEmpty(e6.getText()))
        {
            k=1;
            e6.setError("Please Fill the Field");
        }
        if(TextUtils.isEmpty(e7.getText()))
        {
            k=1;
            e7.setError("Please Fill the Field");
        }
        if(TextUtils.isEmpty(e8.getText()))
        {
            k=1;
            e8.setError("Please Fill the Field");
        }if(TextUtils.isEmpty(e9.getText()))
        {
            k=1;
            e9.setError("Please Fill the Field");
        }
        if(TextUtils.isEmpty(e10.getText()))
        {
            k=1;
            e10.setError("Please Fill the Field");
        }
        if (!(e5.getText().toString().matches(emailPattern)))
        {
            k=1;
            e5.setError("invalid emailid");
        }
        if(!(e3.getText().toString()).equalsIgnoreCase(e4.getText().toString()))
        {
            k=1;
            e4.setError("Password is not matching");
        }
        if (e2.getText().toString().length() != 10)
        {
            k=1;
            e2.setError("Phone Number is Not Valid");
        }
        if (!(e2.getText().toString()).equalsIgnoreCase(e6.getText().toString()))
        {
            k=1;
            e2.setError("Mobile Number and User Id Should be same");
            e6.setError("Mobile Number and User Id Should be same");
        }
        return k;
    }



}
