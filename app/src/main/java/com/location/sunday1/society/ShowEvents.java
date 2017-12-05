package com.location.sunday1.society;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class ShowEvents extends AppCompatActivity {

    TextView t1,t2,t3;
    String s1,s2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_events);

        final ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.left);

        t1 =(TextView)findViewById(R.id.textView88);
        t2 =(TextView)findViewById(R.id.textView104);
        t3 =(TextView)findViewById(R.id.textView105);


        Intent in = getIntent();
        s1 = in.getStringExtra("sub");
        s2 = in.getStringExtra("cat");
        t1.setText(s1);
        t2.setText(s2+ " / ");
        t3.setText(s1);
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
