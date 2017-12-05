package com.location.sunday1.society;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Anyideas extends AppCompatActivity {

    EditText e1;
    Button b1;
    SQLiteHelper sq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anyideas);

        final ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.left);

        sq=new SQLiteHelper(this);
        e1 = (EditText)findViewById(R.id.editText14);
        b1 = (Button)findViewById(R.id.button39);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent In = new Intent(Anyideas.this, Events.class);

                String s1 = e1.getText().toString();
                if (validate() == 0) {
                    int i = sq.insertNewIdea(s1);
                    if (i == -1) {
                        Toast.makeText(Anyideas.this, "not registered", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Anyideas.this, "successfully registered", Toast.LENGTH_SHORT).show();
                        Intent in = new Intent(Anyideas.this, Events.class);
                        startActivity(in);
                    }

                    startActivity(In);
                }
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

    public int validate(){

        int k=0;

        if(TextUtils.isEmpty(e1.getText()))
        {
            k=1;
            e1.setError("Please Fill the Field");
        }
        return k;
}
}
