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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class EmBeventsList extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ListView lv;
    Cursor cursor;
    SQLiteHelper sq;
    Spinner sp;
    String spp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.em_bevents_list);

        final ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.left);


        sq= new SQLiteHelper(this);

        lv = (ListView)findViewById(R.id.listView26);
        sp = (Spinner)findViewById(R.id.spinner3);
        sp.setOnItemSelectedListener(this);

        cursor = sq.queryNamepays15("this_month");
        String[] from = {"_id", "id", "event_name","time"};
        int[] to = {R.id.textView82, R.id.textView84, R.id.textView118,R.id.textView119};
        SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(EmBeventsList.this, R.layout.list5, cursor, from, to);
        lv.setAdapter(cursorAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                String s3 = ((TextView) view.findViewById(R.id.textView82)).getText().toString();
                String s4 = ((TextView) view.findViewById(R.id.textView84)).getText().toString();
                String s5 = ((TextView) view.findViewById(R.id.textView118)).getText().toString();
                String s6 = ((TextView) view.findViewById(R.id.textView119)).getText().toString();


                Intent newActivity = new Intent(EmBeventsList.this, UpdateEmBevents.class);
                newActivity.putExtra("name", s3);
                newActivity.putExtra("name1", s4);
                newActivity.putExtra("name2", s5);
                newActivity.putExtra("name3", s6);


                startActivity(newActivity);

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        spp = sp.getItemAtPosition(position).toString();
        cursor = sq.queryNamepays15(spp);
        String[] from = {"_id", "id", "event_name","time"};
        int[] to = {R.id.textView82, R.id.textView84, R.id.textView118,R.id.textView119};
        SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(EmBeventsList.this, R.layout.list5, cursor, from, to);
        lv.setAdapter(cursorAdapter);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

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
