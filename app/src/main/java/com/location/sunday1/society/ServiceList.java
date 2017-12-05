package com.location.sunday1.society;

import android.content.Intent;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ServiceList extends AppCompatActivity {

    ListView lv;
    Cursor cursor;
    SQLiteHelper sq;
    String s1,s2,s3,s4,s;
    TextView t1,t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_list);
        final ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.left);



        sq= new SQLiteHelper(this);


        lv = (ListView)findViewById(R.id.listView11);
        t1 = (TextView)findViewById(R.id.textView94);
        t2 = (TextView)findViewById(R.id.textView101);

        Intent In = getIntent();
        s1 = In.getStringExtra("subj");
        s2 = In.getStringExtra("sub");
        s = In.getStringExtra("cat");
        t1.setText(s+" / ");
        t2.setText(s2);

        cursor = sq.queryNamepay3(s2);
        String[] from = {"id", "id", "service_provider_name","mobileno","landline","address"};
        int[] to = {R.id.textViewID, R.id.textViewNAME, R.id.textViewPHONE_NUMBER,R.id.textViewSUBJECT,R.id.textView1,R.id.textView2};
        SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(ServiceList.this, R.layout.list, cursor, from, to);
        lv.setAdapter(cursorAdapter);





        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



                    String s3 = ((TextView) view.findViewById(R.id.textViewPHONE_NUMBER)).getText().toString();
                    String s4 = ((TextView) view.findViewById(R.id.textViewSUBJECT)).getText().toString();
                    String s5 = ((TextView) view.findViewById(R.id.textView1)).getText().toString();
                    String s6 = ((TextView) view.findViewById(R.id.textView2)).getText().toString();
                    String s7 = ((TextView) view.findViewById(R.id.textView50)).getText().toString();


                Intent newActivity = new Intent(ServiceList.this, SubServices.class);
                newActivity.putExtra("ser", s2);
                newActivity.putExtra("name", s3);
                newActivity.putExtra("mobileno", s4);
                newActivity.putExtra("landline", s5);
                newActivity.putExtra("address", s6);
                newActivity.putExtra("cat", s);

                startActivity(newActivity);

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
