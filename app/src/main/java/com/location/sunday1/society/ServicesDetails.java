package com.location.sunday1.society;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ServicesDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.services_details);

        Intent i=getIntent();
        String s=i.getStringExtra("idvalue");
        TextView tv=(TextView)findViewById(R.id.textView13);
        tv.setText(s);
    }
}
