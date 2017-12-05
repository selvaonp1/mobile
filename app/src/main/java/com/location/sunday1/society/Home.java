package com.location.sunday1.society;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Home extends AppCompatActivity {
    TextView t1,t2,t3,t4;
    Button b1;
    SQLiteHelper sq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        final ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.left);


        sq=new SQLiteHelper(this);
        t1 = (TextView)findViewById(R.id.textView);
        t2 = (TextView)findViewById(R.id.textView2);
        t3 = (TextView)findViewById(R.id.textView3);
        t4 = (TextView)findViewById(R.id.textView4);
        b1 = (Button)findViewById(R.id.button5);

        Intent in = getIntent();

        String name = in.getStringExtra("userid");
        final String uid = in.getStringExtra("uid");
        //t1.setText(name);
        String res;
        res=sq.getDets(name);
        String []rr=res.split("/");
        t1.setText(rr[0]);
        t3.setText(rr[1]);
        t3.setAllCaps(true);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Home.this,Home1.class);
                in.putExtra("pi",t1.getText().toString());
                in.putExtra("pd",t3.getText().toString());
                in.putExtra("uid",uid);
                startActivity(in);
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
