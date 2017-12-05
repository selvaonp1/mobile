package com.location.sunday1.society;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Embizzuser extends AppCompatActivity {

    SQLiteHelper sq;
    Cursor cursor;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.embizzuser);

        final ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.left);

        ArrayList<ListItems> lst=new ArrayList<>();
        //initializing objects
        lv = (ListView) findViewById(R.id.listView25);
        sq=new SQLiteHelper(this);
        cursor=sq.getEmizz();
        String[] from = {"id", "service"};
        Intent in=getIntent();
        String ss=in.getStringExtra("uid");

        if(cursor.moveToFirst())
        {
            do{
                ListItems lt=new ListItems();
                lt.setid1(cursor.getString(cursor.getColumnIndex("id")));
                lt.setitem1(cursor.getString(cursor.getColumnIndex("service")));
                lst.add(lt);
            }while (cursor.moveToNext());
        }
        CustomAdapter1 cust=new CustomAdapter1(this,lst,ss);
        lv.setAdapter(cust);
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