package com.location.sunday1.society;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProductsTest extends AppCompatActivity {

    String s1,s2,s3,s4,s5,s6,uid;
    TextView t1,t2,t3,t4,t5,t6,t7;
    SQLiteHelper sq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_test);

        t1=(TextView)findViewById(R.id.textView121);
        t2=(TextView)findViewById(R.id.textView122);
        t3=(TextView)findViewById(R.id.textView123);
        t4=(TextView)findViewById(R.id.textView124);
        t5=(TextView)findViewById(R.id.textView125);
        t6=(TextView)findViewById(R.id.textView126);
        t7=(TextView)findViewById(R.id.textView127);

        sq=new SQLiteHelper(this);

        Intent i=getIntent();
        s1=i.getStringExtra("subj");
        s2=i.getStringExtra("sub");
        s3=i.getStringExtra("sub1");
        s4=i.getStringExtra("sub2");
        s5=i.getStringExtra("pi");
        s6=i.getStringExtra("pd");
        uid=i.getStringExtra("uid");

        String fe=sq.getUnitDetails(s1);
        String[] de=fe.split(">");
        t4.setText(de[0]);
        t5.setText(de[1]);
        t6.setText(String.valueOf(de.length));
        t7.setText(fe);
        /*
        t1.setText(s1);
        t2.setText(s2);
        t3.setText(s3);
        t4.setText(s4);
        t5.setText(s5);
        t6.setText(s6);
        t7.setText(uid);*/
    }
}
