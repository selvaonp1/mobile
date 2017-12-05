package com.location.sunday1.society;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class AdminHome extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText e1;
    Button b1;
    Spinner sp1;
    TextView t1;
    String s2;
    SQLiteHelper sq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_home);

        final ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.left);

        sq=new SQLiteHelper(this);

        e1 = (EditText)findViewById(R.id.editText13);
        sp1 = (Spinner)findViewById(R.id.spinner6);
        sp1.setOnItemSelectedListener(this);
        b1 = (Button)findViewById(R.id.button17);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String s1=e1.getText().toString();

                int i =sq.items(s1,s2);
                if(i == -1)
                {
                    Toast.makeText(AdminHome.this, "not registered", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(AdminHome.this, "inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(AdminHome.this, ""+sp1.getItemAtPosition(i), Toast.LENGTH_SHORT).show();
        s2 = sp1.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

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
