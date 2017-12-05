package com.location.sunday1.society;

import android.content.Intent;
import android.media.Rating;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class SubServices extends AppCompatActivity {

    TextView t1,t2,t3,t4,t5,t6,t7;
    Button b1;
    String s1,s2,s3,s4,s,s5;
    SQLiteHelper sq;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub_services);
        sq=new SQLiteHelper(this);

        final ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.left);

        t1 = (TextView)findViewById(R.id.textView43);
        t2 = (TextView)findViewById(R.id.textView44);
        t3 = (TextView)findViewById(R.id.textView45);
        t4 = (TextView)findViewById(R.id.textView46);
        t5 = (TextView)findViewById(R.id.textView48);
        t6 = (TextView)findViewById(R.id.textView92);
        t7 = (TextView)findViewById(R.id.textView100);
        b1 = (Button)findViewById(R.id.button20);



        Intent In = getIntent();
        s = In.getStringExtra("ser");
        s1 = In.getStringExtra("name");
        s2 = In.getStringExtra("mobileno");
        s3 = In.getStringExtra("landline");
        s4 = In.getStringExtra("address");
        s5 = In.getStringExtra("cat");
        String poi=sq.getrating(s1,s);

            t5.setText(poi);

        t1.setText(s1);
        t2.setText(s2);
        t3.setText(s3);
        t4.setText(s4);
        t6.setText(s5+" / ");
        t7.setText(s);




        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ss1=t1.getText().toString();
                String ss2=t2.getText().toString();
                String ss3=t2.getText().toString();
                String ss4=t4.getText().toString();
                String ss5=t5.getText().toString();




            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
