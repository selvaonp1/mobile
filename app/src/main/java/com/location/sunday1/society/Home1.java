package com.location.sunday1.society;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Home1 extends AppCompatActivity {

    Button b1,b2,b3,b4,b5,b6;
    String s1,s2,a,b;
    String s3;
    Button disclaimer,aboutus,contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home1);

        final ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.left);

        b1 = (Button)findViewById(R.id.button6);
        b2 = (Button)findViewById(R.id.button7);

        b4 = (Button)findViewById(R.id.button9);
        b5 = (Button)findViewById(R.id.button10);
        b6 = (Button)findViewById(R.id.button11);
        disclaimer = (Button)findViewById(R.id.button50);
        aboutus = (Button)findViewById(R.id.button51);
        contact = (Button)findViewById(R.id.button52);

        Intent in = getIntent();
       s1 = in.getStringExtra("pi");
        s2 = in.getStringExtra("pd");
        s3 = in.getStringExtra("uid");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Home1.this, Services.class);
                startActivity(in);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent In = new Intent(Home1.this,Products.class);
                In.putExtra("pi",s1);
                In.putExtra("pd",s2);
                In.putExtra("uid",s3);
                startActivity(In);
            }
        });


        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                custpop();
                    //popup();

            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent In = new Intent(Home1.this,VIPContacts.class);
                startActivity(In);
            }
        });


        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Home1.this,Events.class);
                in.putExtra("uid",s3);
                startActivity(in);
            }
        });
        disclaimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Home1.this,Disclaimer.class);
                in.putExtra("uid",s3);
                startActivity(in);
            }
        });
        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Home1.this,Aboutus.class);
                in.putExtra("uid",s3);
                startActivity(in);
            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Home1.this,Contact.class);
                in.putExtra("uid",s3);
                startActivity(in);
            }
        });
    }

    private void popup() {
        AlertDialog.Builder builder=new AlertDialog.Builder(Home1.this);
        builder.setMessage("“EmBizz is to list the products/services offered by Embassy Residents. If interested to list your\n" +
                "products/services, please click “Submit here for listing your products/servicec and contacts”\n" +
                "button.");
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent in = new Intent(Home1.this, Queries.class);
                String a = s1;
                String b = s2;
                in.putExtra("username", a);
                in.putExtra("society", b);
                startActivity(in);
            }
        });
    }
    public void custpop(){
        final Dialog dialog = new Dialog(this);

        dialog.setContentView(R.layout.custom_dialog);
        dialog.setTitle("EmBizz Alert !");
        TextView tv=(TextView)dialog.findViewById(R.id.tv1);
        final EditText editText = (EditText) dialog.findViewById(R.id.editText);
        Button btnSave          = (Button) dialog.findViewById(R.id.save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
                Intent in = new Intent(Home1.this, EmBizzNew.class);
                String a = s1;
                String b = s2;
                in.putExtra("uid", s3);
                in.putExtra("username", a);
                in.putExtra("society", b);
                startActivity(in);
            }
        });
        dialog.show();
    }
/*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            case R.id.item1:
                Intent in=new Intent(Home1.this,Disclaimer.class);
                startActivity(in);
                return true;
            case R.id.item2:
                Intent in1=new Intent(Home1.this,Aboutus.class);
                startActivity(in1);
                return true;
            case R.id.item3:
                Intent in2=new Intent(Home1.this,Contact.class);
                startActivity(in2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);
        return true;
    }
    */
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
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            Intent intent = new Intent(Home1.this,Login.class);

            startActivity(intent);
            return true;
        }
        return false;
    }
}
