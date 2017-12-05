package com.location.sunday1.society;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class AddItems extends AppCompatActivity {

    Button b1,b2,b3,b4,b5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_items);

        final ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.left);

        b1 = (Button)findViewById(R.id.button40);
        b1  .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent In = new Intent(AddItems.this, Embuddy.class);
                startActivity(In);
            }
        });
        b2 = (Button)findViewById(R.id.button41);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent In = new Intent(AddItems.this, AddProduct.class);
                startActivity(In);
            }
        });
        b3 = (Button)findViewById(R.id.button42);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent In = new Intent(AddItems.this, AddVipContact.class);
                startActivity(In);
            }
        });
        b4 = (Button)findViewById(R.id.button43);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent In = new Intent(AddItems.this, AddEmbizz.class);
                startActivity(In);
            }
        });
        b5 = (Button)findViewById(R.id.button44);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent In = new Intent(AddItems.this,AddEmbevents.class);
                startActivity(In);
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(AddItems.this,AdminHomePage.class);
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
            Intent intent = new Intent(AddItems.this,AdminHomePage.class);

            startActivity(intent);
            return true;
        }
        return false;
    }
}
