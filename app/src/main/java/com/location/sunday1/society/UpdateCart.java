package com.location.sunday1.society;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateCart extends AppCompatActivity {

    TextView t1,t2;
    EditText e1,e2,e3,e4,e5;
    Button b1,b2;
    SQLiteHelper sq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_cart);


        final ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.left);




        Intent in=getIntent();
        sq=new SQLiteHelper(this);
        String s1=in.getStringExtra("name");
        String s2=in.getStringExtra("name1");
        String s3=in.getStringExtra("name2");
        final String s4=in.getStringExtra("name3");
        final String s5=in.getStringExtra("name4");
        final String s6=in.getStringExtra("uid");
        final String userid=in.getStringExtra("userid");
        final String aa1=in.getStringExtra("pi");
        final String aa2=in.getStringExtra("pd");
        t1=(TextView)findViewById(R.id.textView77);
        t2=(TextView)findViewById(R.id.textView78);
        e1=(EditText)findViewById(R.id.editText29);
        e2=(EditText)findViewById(R.id.editText30);
        e3=(EditText)findViewById(R.id.editText31);
        e4=(EditText)findViewById(R.id.editText32);

        b1=(Button)findViewById(R.id.button48);
        b2=(Button)findViewById(R.id.button49);
        e1.setText(s1);
        e2.setText(s2);
        e3.setText(s5);
        e4.setText(s4);
        t2.setText(s3);
        t1.setText(s6);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String qty = e4.getText().toString();
                String tot = t2.getText().toString();
                int ij = sq.updateCart(qty, tot, s6);
                if (ij > -1) {
                    Toast.makeText(UpdateCart.this, "Successfully Updated", Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(UpdateCart.this, CartDetails.class);
                    in.putExtra("uid", userid);
                    in.putExtra("pi", aa1);
                    in.putExtra("pd", aa2);
                    startActivity(in);
                } else {
                    Toast.makeText(UpdateCart.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double d = Double.valueOf(e4.getText().toString()) * Double.valueOf(e3.getText().toString());
                t2.setText(String.valueOf(d));
                b1.setVisibility(View.VISIBLE);
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