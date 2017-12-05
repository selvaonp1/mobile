package com.location.sunday1.society;

import android.content.Intent;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.ListView;

public class ViewIdeas extends AppCompatActivity {
    ListView lv;
    Cursor cursor;
    SQLiteHelper sq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_ideas);

        final ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.left);

        sq= new SQLiteHelper(this);

        lv = (ListView)findViewById(R.id.listView24);
        cursor = sq.queryNamepay7();
        String[] from = {"id", "id", "idea"};
        int[] to = {R.id.textViewID, R.id.textViewNAME, R.id.textViewPHONE_NUMBER};
        SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(ViewIdeas.this, R.layout.list, cursor, from, to);
        lv.setAdapter(cursorAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(ViewIdeas.this,AdminHomePage.class);

                startActivity(intent);
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            Intent intent = new Intent(ViewIdeas.this,AdminHomePage.class);

            startActivity(intent);
            return true;
        }
        return false;
    }
}
