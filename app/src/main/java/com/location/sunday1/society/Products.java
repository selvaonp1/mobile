package com.location.sunday1.society;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Products extends Activity implements AdapterView.OnItemClickListener {


    ListView lv,lv1;
    SQLiteHelper sq;
    Cursor cursor;
    Button b1,cart;
    String uid,prod1,aa1,aa2;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.products);




        sq=new SQLiteHelper(this);
        lv=(ListView)findViewById(R.id.listView3);
        lv.setOnItemClickListener(this);
        Intent in=getIntent();
        uid=in.getStringExtra("uid");
        aa1=in.getStringExtra("pi");
        aa2=in.getStringExtra("pd");
        lv.setVisibility(View.INVISIBLE);
        lv1=(ListView)findViewById(R.id.listView2);
        t1 = (TextView)findViewById(R.id.textView34);
        b1 = (Button)findViewById(R.id.button18);
        cart = (Button)findViewById(R.id.button53);
        String tot=sq.getCartNumber(uid);
        cart.setText(tot);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent In = new Intent(Products.this,CartDetails.class);
                In.putExtra("uid",uid);
                In.putExtra("pi",aa1);
                In.putExtra("pd",aa2);
                startActivity(In);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lv.setVisibility(View.VISIBLE);
            }
        });
        String[] from = { "_id","id","product"};
        int[] to = { R.id.textViewID, R.id.textViewNAME, R.id.textViewPHONE_NUMBER};
        cursor=sq.queryNamepay();
        SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(this,R.layout.listviewdatalayout,cursor, from, to);
        lv.setAdapter(cursorAdapter);

    }




    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {




        String prod = null;

            if (adapterView.getId() == R.id.listView3) {


                int p0 = adapterView.getSelectedItemPosition();
                int poi=adapterView.getPositionForView(view);





                String s1 = ((TextView) view.findViewById(R.id.textViewNAME)).getText().toString();
                String s2 = ((TextView) view.findViewById(R.id.textViewPHONE_NUMBER)).getText().toString();
                prod1 = ((TextView) view.findViewById(R.id.textViewPHONE_NUMBER)).getText().toString();


                loadSecondListView(s2);





            } else if (adapterView.getId() == R.id.listView2) {
                String s1 = ((TextView) view.findViewById(R.id.textView28)).getText().toString();
                String s2 = ((TextView) view.findViewById(R.id.textView27)).getText().toString();
                String s3 = ((TextView) view.findViewById(R.id.textView33)).getText().toString();


                Intent newActivity = new Intent(Products.this, SubProducts.class);

                newActivity.putExtra("subj", s1);
                newActivity.putExtra("sub", s2);
                newActivity.putExtra("sub1", prod1);
                newActivity.putExtra("sub2", s3);
                newActivity.putExtra("uid",uid);


                newActivity.putExtra("pi",aa1);
                newActivity.putExtra("pd",aa2);

                startActivity(newActivity);
            }
        }

    private void loadSecondListView(String s1)
    {
        String[] from = { "_id","id","subproduct","price"};
        int[] to = { R.id.textView26, R.id.textView27, R.id.textView28,R.id.textView33};
        cursor=sq.queryNamepay1(s1);
        SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(this,R.layout.listviewdatalayout1,cursor, from, to);
        lv1.setAdapter(cursorAdapter);
        lv1.setOnItemClickListener(this);

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
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            Intent intent = new Intent(Products.this,Home1.class);
            intent.putExtra("uid",uid);
            intent.putExtra("pi",aa1);
            intent.putExtra("pd",aa2);
            startActivity(intent);
            return true;
        }
        return false;
    }

        }
