package com.location.sunday1.society;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddEmbevents extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText e1,e2,e3,e4,e5,e6,e7;
    Button b1;
    SQLiteHelper sq;
    String s1,s2,s3,s4,s5,s6,s7,s8="no",s9,s10;
    Spinner sp;
    String sp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_emevents);

        final ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.left);

        sq=new SQLiteHelper(this);

        e1 = (EditText)findViewById(R.id.editText20);

        sp = (Spinner)findViewById(R.id.spinner);
        sp.setOnItemSelectedListener(this);







        b1 = (Button)findViewById(R.id.button45);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString();






                int i =sq.insertEvents(s1,sp2 );
                if(i == -1)
                {
                    Toast.makeText(AddEmbevents.this, "not registered", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(AddEmbevents.this, "successfully registered", Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(AddEmbevents.this,AddItems.class);
                    startActivity(in);
                }

            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(AddEmbevents.this,AddItems.class);

                startActivity(intent);
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        sp2 = sp.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            Intent intent = new Intent(AddEmbevents.this,AddItems.class);

            startActivity(intent);
            return true;
        }
        return false;
    }


}

