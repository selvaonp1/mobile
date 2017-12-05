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

public class EmBassadorList extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ListView lv;
    Cursor cursor;
    SQLiteHelper sq;
    Spinner sp;
    String spp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.em_bassador_list);

        final ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.left);


        sq= new SQLiteHelper(this);

        lv = (ListView)findViewById(R.id.listView26);
        sp = (Spinner)findViewById(R.id.spinner3);
        sp.setOnItemSelectedListener(this);


        cursor = sq.queryNamepays13("Maintainance office");
        String[] from = {"_id", "id", "category","name","designation","mobileno","landline","emailid","address"};
        int[] to = {R.id.textView110, R.id.textView111, R.id.textView112,R.id.textView113,R.id.textView114,R.id.textView115,R.id.textView116,R.id.textView117,R.id.textView79};
        SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(EmBassadorList.this, R.layout.list4, cursor, from, to);
        lv.setAdapter(cursorAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                String s3 = ((TextView) view.findViewById(R.id.textView110)).getText().toString();
                String s4 = ((TextView) view.findViewById(R.id.textView111)).getText().toString();
                String s5 = ((TextView) view.findViewById(R.id.textView112)).getText().toString();
                String s6 = ((TextView) view.findViewById(R.id.textView113)).getText().toString();
                String s7 = ((TextView) view.findViewById(R.id.textView114)).getText().toString();
                String s8 = ((TextView) view.findViewById(R.id.textView115)).getText().toString();
                String s9 = ((TextView) view.findViewById(R.id.textView116)).getText().toString();
                String s10 = ((TextView) view.findViewById(R.id.textView117)).getText().toString();
                String s11 = ((TextView) view.findViewById(R.id.textView79)).getText().toString();


                Intent newActivity = new Intent(EmBassadorList.this, UpdateEmBassador.class);
                newActivity.putExtra("name", s3);
                newActivity.putExtra("name1", s4);
                newActivity.putExtra("name2", s5);
                newActivity.putExtra("name3", s6);
                newActivity.putExtra("name4", s7);
                newActivity.putExtra("name5", s8);
                newActivity.putExtra("name6", s9);
                newActivity.putExtra("name7", s10);
                newActivity.putExtra("name8", s11);

                startActivity(newActivity);

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        spp = sp.getItemAtPosition(position).toString();
        cursor = sq.queryNamepays13(spp);
        String[] from = {"_id", "id", "category","name","designation","mobileno","landline","emailid","address"};
        int[] to = {R.id.textView110, R.id.textView111, R.id.textView112,R.id.textView113,R.id.textView114,R.id.textView115,R.id.textView116,R.id.textView117,R.id.textView79};
        SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(EmBassadorList.this, R.layout.list4, cursor, from, to);
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
