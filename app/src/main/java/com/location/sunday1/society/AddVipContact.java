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

public class AddVipContact extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText e1,e2,e3,e4,e5,e6,e7;
    Button b1;
    SQLiteHelper sq;
    String s1,s2,s3,s4,s5,s6,s7,s8="no",s9,s10,spp;
    Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_vip_contact);

        final ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.left);

        sq=new SQLiteHelper(this);


        e2 = (EditText)findViewById(R.id.editText21);
        e3 = (EditText)findViewById(R.id.editText22);
        e4 = (EditText)findViewById(R.id.editText23);
        e5 = (EditText)findViewById(R.id.editText24);
        e6 = (EditText)findViewById(R.id.editText26);
        e7 = (EditText)findViewById(R.id.editText27);
        sp = (Spinner)findViewById(R.id.spinner2);
        sp.setOnItemSelectedListener(this);


        b1 = (Button)findViewById(R.id.button45);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s2=e2.getText().toString();
                String s3=e3.getText().toString();
                String s4=e4.getText().toString();
                String s5=e5.getText().toString();
                String s6=e6.getText().toString();
                String s7=e7.getText().toString();


                int i =sq.insertVipcontacts(spp, s2, s3, s4, s5,s6,s7);
                if(i == -1)
                {
                    Toast.makeText(AddVipContact.this, "not registered", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(AddVipContact.this, "successfully registered", Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(AddVipContact.this,AddItems.class);
                    startActivity(in);
                }

            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(AddVipContact.this,AddItems.class);

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
        spp = sp.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            Intent intent = new Intent(AddVipContact.this,AddItems.class);

            startActivity(intent);
            return true;
        }
        return false;
    }
}

