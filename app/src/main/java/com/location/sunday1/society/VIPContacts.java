package com.location.sunday1.society;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class VIPContacts extends Activity implements AdapterView.OnItemClickListener  {

    Button b1,b2,b3,b4,b5,b6;
    Spinner s1,s2,s3,s4,s5;
    SQLiteHelper sq;
    ListView lv,lv1,lv2,lv3,lv4,lv5,lv6;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vipcontacts);

        sq= new SQLiteHelper(this);
        b1 = (Button)findViewById(R.id.button28);
        b2 = (Button)findViewById(R.id.button29);
        b3 = (Button)findViewById(R.id.button30);
        b4 = (Button)findViewById(R.id.button31);
        b5 = (Button)findViewById(R.id.button32);
        b6 = (Button)findViewById(R.id.button57);

        lv=(ListView)findViewById(R.id.listView12);
        lv1=(ListView)findViewById(R.id.listView13);
        lv2=(ListView)findViewById(R.id.listView14);
        lv3=(ListView)findViewById(R.id.listView15);
        lv4=(ListView)findViewById(R.id.listView16);
        lv5=(ListView)findViewById(R.id.listView9);
        lv6=(ListView)findViewById(R.id.listView28);

        lv.setOnItemClickListener(this);
        lv1.setOnItemClickListener(this);
        lv2.setOnItemClickListener(this);
        lv3.setOnItemClickListener(this);
        lv4.setOnItemClickListener(this);
        lv6.setOnItemClickListener(this);






            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    /*b1.setBackgroundColor(Color.GRAY);
                    b2.setBackgroundColor(Color.BLUE);
                    b3.setBackgroundColor(Color.BLUE);
                    b4.setBackgroundColor(Color.BLUE);
                    b5.setBackgroundColor(Color.BLUE);
                    b6.setBackgroundColor(Color.BLUE);
                    b7.setBackgroundColor(Color.BLUE);*/

                    Drawable dr = getResources().getDrawable(R.drawable.border2);
                    Drawable dr1 = getResources().getDrawable(R.drawable.border1);

                    b1.setBackgroundDrawable(dr);
                    b2.setBackgroundDrawable(dr1);
                    b3.setBackgroundDrawable(dr1);
                    b4.setBackgroundDrawable(dr1);
                    b5.setBackgroundDrawable(dr1);
                    b6.setBackgroundDrawable(dr1);


                    lv.setVisibility(View.VISIBLE);
                    lv1.setVisibility(View.INVISIBLE);
                    lv2.setVisibility(View.INVISIBLE);
                    lv3.setVisibility(View.INVISIBLE);
                    lv4.setVisibility(View.INVISIBLE);
                    lv6.setVisibility(View.INVISIBLE);


                    cursor = sq.queryNamepay4("Maintainance office");
                    String[] from = {"_id", "id", "designation", "category", "name", "mobileno", "landline", "emailid", "address"};
                    int[] to = {R.id.textViewID, R.id.textViewNAME, R.id.textViewPHONE_NUMBER, R.id.textViewSUBJECT, R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4, R.id.textView67};
                    SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(VIPContacts.this, R.layout.listviewdatalayout, cursor, from, to);
                    lv.setAdapter(cursorAdapter);

                }
            });

            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   /* b1.setBackgroundColor(Color.BLUE);
                    b2.setBackgroundColor(Color.GRAY);
                    b3.setBackgroundColor(Color.BLUE);
                    b4.setBackgroundColor(Color.BLUE);
                    b5.setBackgroundColor(Color.BLUE);
                    b6.setBackgroundColor(Color.BLUE);
                    b7.setBackgroundColor(Color.BLUE);
    */
                    Drawable dr = getResources().getDrawable(R.drawable.border2);
                    Drawable dr1 = getResources().getDrawable(R.drawable.border1);

                    b1.setBackgroundDrawable(dr1);
                    b2.setBackgroundDrawable(dr);
                    b3.setBackgroundDrawable(dr1);
                    b4.setBackgroundDrawable(dr1);
                    b5.setBackgroundDrawable(dr1);
                    b6.setBackgroundDrawable(dr1);



                    lv.setVisibility(View.INVISIBLE);
                    lv1.setVisibility(View.VISIBLE);
                    lv2.setVisibility(View.INVISIBLE);
                    lv3.setVisibility(View.INVISIBLE);
                    lv4.setVisibility(View.INVISIBLE);
                    lv6.setVisibility(View.INVISIBLE);



                    cursor = sq.queryNamepay4("Office Bearers");
                    String[] from = {"_id", "id", "designation","category","name","mobileno","landline","emailid","address"};
                    int[] to = {R.id.textViewID, R.id.textViewNAME, R.id.textViewPHONE_NUMBER,R.id.textViewSUBJECT,R.id.textView1,R.id.textView2,R.id.textView3,R.id.textView4,R.id.textView67};
                    SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(VIPContacts.this, R.layout.listviewdatalayout, cursor, from, to);
                    lv1.setAdapter(cursorAdapter);

                }
            });
            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    /*b1.setBackgroundColor(Color.BLUE);
                    b2.setBackgroundColor(Color.BLUE);
                    b3.setBackgroundColor(Color.GRAY);
                    b4.setBackgroundColor(Color.BLUE);
                    b5.setBackgroundColor(Color.BLUE);
                    b6.setBackgroundColor(Color.BLUE);
                    b7.setBackgroundColor(Color.BLUE);*/

                    Drawable dr = getResources().getDrawable(R.drawable.border2);
                    Drawable dr1 = getResources().getDrawable(R.drawable.border1);

                    b1.setBackgroundDrawable(dr1);
                    b2.setBackgroundDrawable(dr1);
                    b3.setBackgroundDrawable(dr);
                    b4.setBackgroundDrawable(dr1);
                    b5.setBackgroundDrawable(dr1);
                    b6.setBackgroundDrawable(dr1);


                    lv.setVisibility(View.INVISIBLE);
                    lv1.setVisibility(View.INVISIBLE);
                    lv2.setVisibility(View.VISIBLE);
                    lv3.setVisibility(View.INVISIBLE);
                    lv4.setVisibility(View.INVISIBLE);
                    lv6.setVisibility(View.INVISIBLE);


                    cursor = sq.queryNamepay4("Builder");
                    String[] from = {"_id", "id", "designation","category","name","mobileno","landline","emailid","address"};
                    int[] to = {R.id.textViewID, R.id.textViewNAME, R.id.textViewPHONE_NUMBER,R.id.textViewSUBJECT,R.id.textView1,R.id.textView2,R.id.textView3,R.id.textView4,R.id.textView67};
                    SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(VIPContacts.this, R.layout.listviewdatalayout, cursor, from, to);
                    lv2.setAdapter(cursorAdapter);

                }
            });
            b4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                   /* b1.setBackgroundColor(Color.BLUE);
                    b2.setBackgroundColor(Color.BLUE);
                    b3.setBackgroundColor(Color.BLUE);
                    b4.setBackgroundColor(Color.GRAY);
                    b5.setBackgroundColor(Color.BLUE);
                    b6.setBackgroundColor(Color.BLUE);
                    b7.setBackgroundColor(Color.BLUE);*/

                    Drawable dr = getResources().getDrawable(R.drawable.border2);
                    Drawable dr1 = getResources().getDrawable(R.drawable.border1);

                    b1.setBackgroundDrawable(dr1);
                    b2.setBackgroundDrawable(dr1);
                    b3.setBackgroundDrawable(dr1);
                    b4.setBackgroundDrawable(dr);
                    b5.setBackgroundDrawable(dr1);
                    b6.setBackgroundDrawable(dr1);



                    lv.setVisibility(View.INVISIBLE);
                    lv1.setVisibility(View.INVISIBLE);
                    lv2.setVisibility(View.INVISIBLE);
                    lv3.setVisibility(View.VISIBLE);
                    lv4.setVisibility(View.INVISIBLE);
                    lv6.setVisibility(View.INVISIBLE);

                    cursor = sq.queryNamepay4("Emergencies");
                    String[] from = {"_id", "id", "designation","category","name","mobileno","landline","emailid","address"};
                    int[] to = {R.id.textViewID, R.id.textViewNAME, R.id.textViewPHONE_NUMBER,R.id.textViewSUBJECT,R.id.textView1,R.id.textView2,R.id.textView3,R.id.textView4,R.id.textView67};
                    SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(VIPContacts.this, R.layout.listviewdatalayout, cursor, from, to);
                    lv3.setAdapter(cursorAdapter);
                }
            });
            b5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    /*b1.setBackgroundColor(Color.BLUE);
                    b2.setBackgroundColor(Color.BLUE);
                    b3.setBackgroundColor(Color.BLUE);
                    b4.setBackgroundColor(Color.BLUE);
                    b5.setBackgroundColor(Color.GRAY);
                    b6.setBackgroundColor(Color.BLUE);
                    b7.setBackgroundColor(Color.BLUE);*/

                    Drawable dr = getResources().getDrawable(R.drawable.border2);
                    Drawable dr1 = getResources().getDrawable(R.drawable.border1);

                    b1.setBackgroundDrawable(dr1);
                    b2.setBackgroundDrawable(dr1);
                    b3.setBackgroundDrawable(dr1);
                    b4.setBackgroundDrawable(dr1);
                    b5.setBackgroundDrawable(dr);
                    b6.setBackgroundDrawable(dr);



                    lv.setVisibility(View.INVISIBLE);
                    lv1.setVisibility(View.INVISIBLE);
                    lv2.setVisibility(View.INVISIBLE);
                    lv3.setVisibility(View.INVISIBLE);
                    lv4.setVisibility(View.VISIBLE);
                    lv6.setVisibility(View.INVISIBLE);

                    cursor = sq.queryNamepay4("Executive Committee");
                    String[] from = {"_id", "id", "designation","category","name","mobileno","landline","emailid","address"};
                    int[] to = {R.id.textViewID, R.id.textViewNAME, R.id.textViewPHONE_NUMBER,R.id.textViewSUBJECT,R.id.textView1,R.id.textView2,R.id.textView3,R.id.textView4,R.id.textView67};
                    SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(VIPContacts.this, R.layout.listviewdatalayout, cursor, from, to);
                    lv4.setAdapter(cursorAdapter);

                }
            });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    /*b1.setBackgroundColor(Color.BLUE);
                    b2.setBackgroundColor(Color.BLUE);
                    b3.setBackgroundColor(Color.BLUE);
                    b4.setBackgroundColor(Color.BLUE);
                    b5.setBackgroundColor(Color.GRAY);
                    b6.setBackgroundColor(Color.BLUE);
                    b7.setBackgroundColor(Color.BLUE);*/

                Drawable dr = getResources().getDrawable(R.drawable.border2);
                Drawable dr1 = getResources().getDrawable(R.drawable.border1);

                b1.setBackgroundDrawable(dr1);
                b2.setBackgroundDrawable(dr1);
                b3.setBackgroundDrawable(dr1);
                b4.setBackgroundDrawable(dr1);
                b5.setBackgroundDrawable(dr1);
                b6.setBackgroundDrawable(dr);



                lv.setVisibility(View.INVISIBLE);
                lv1.setVisibility(View.INVISIBLE);
                lv2.setVisibility(View.INVISIBLE);
                lv3.setVisibility(View.INVISIBLE);
                lv4.setVisibility(View.INVISIBLE);
                lv6.setVisibility(View.VISIBLE);

                cursor = sq.queryNamepay4("others");
                String[] from = {"_id", "id", "designation","category","name","mobileno","landline","emailid","address"};
                int[] to = {R.id.textViewID, R.id.textViewNAME, R.id.textViewPHONE_NUMBER,R.id.textViewSUBJECT,R.id.textView1,R.id.textView2,R.id.textView3,R.id.textView4,R.id.textView67};
                SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(VIPContacts.this, R.layout.listviewdatalayout, cursor, from, to);
                lv6.setAdapter(cursorAdapter);

            }
        });








    }
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


            if (adapterView.getId() == R.id.listView12) {
                String s1 = ((TextView) view.findViewById(R.id.textViewNAME)).getText().toString();
                String s2 = ((TextView) view.findViewById(R.id.textViewPHONE_NUMBER)).getText().toString();
                String s3 = ((TextView) view.findViewById(R.id.textViewSUBJECT)).getText().toString();
                String s4 = ((TextView) view.findViewById(R.id.textView1)).getText().toString();
                String s5 = ((TextView) view.findViewById(R.id.textView2)).getText().toString();
                String s6 = ((TextView) view.findViewById(R.id.textView3)).getText().toString();
                String s7 = ((TextView) view.findViewById(R.id.textView4)).getText().toString();
                String s8 = ((TextView) view.findViewById(R.id.textView67)).getText().toString();



                Intent newActivity = new Intent(VIPContacts.this, ShowVipContacts.class);
                newActivity.putExtra("subj", s1);
                newActivity.putExtra("sub", s2);
                newActivity.putExtra("sub1", s3);
                newActivity.putExtra("sub2", s4);
                newActivity.putExtra("sub3", s5);
                newActivity.putExtra("sub4", s6);
                newActivity.putExtra("sub5", s7);
                newActivity.putExtra("sub6", s8);
                startActivity(newActivity);
            }else  if (adapterView.getId() == R.id.listView13) {
                String s1 = ((TextView) view.findViewById(R.id.textViewNAME)).getText().toString();
                String s2 = ((TextView) view.findViewById(R.id.textViewPHONE_NUMBER)).getText().toString();
                String s3 = ((TextView) view.findViewById(R.id.textViewSUBJECT)).getText().toString();
                String s4 = ((TextView) view.findViewById(R.id.textView1)).getText().toString();
                String s5 = ((TextView) view.findViewById(R.id.textView2)).getText().toString();
                String s6 = ((TextView) view.findViewById(R.id.textView3)).getText().toString();
                String s7 = ((TextView) view.findViewById(R.id.textView4)).getText().toString();
                String s8 = ((TextView) view.findViewById(R.id.textView67)).getText().toString();



                Intent newActivity = new Intent(VIPContacts.this, ShowVipContacts.class);
                newActivity.putExtra("subj", s1);
                newActivity.putExtra("sub", s2);
                newActivity.putExtra("sub1", s3);
                newActivity.putExtra("sub2", s4);
                newActivity.putExtra("sub3", s5);
                newActivity.putExtra("sub4", s6);
                newActivity.putExtra("sub5", s7);
                newActivity.putExtra("sub6", s8);
                startActivity(newActivity);
            }else if (adapterView.getId() == R.id.listView14) {
                String s1 = ((TextView) view.findViewById(R.id.textViewNAME)).getText().toString();
                String s2 = ((TextView) view.findViewById(R.id.textViewPHONE_NUMBER)).getText().toString();
                String s3 = ((TextView) view.findViewById(R.id.textViewSUBJECT)).getText().toString();
                String s4 = ((TextView) view.findViewById(R.id.textView1)).getText().toString();
                String s5 = ((TextView) view.findViewById(R.id.textView2)).getText().toString();
                String s6 = ((TextView) view.findViewById(R.id.textView3)).getText().toString();
                String s7 = ((TextView) view.findViewById(R.id.textView4)).getText().toString();
                String s8 = ((TextView) view.findViewById(R.id.textView67)).getText().toString();



                Intent newActivity = new Intent(VIPContacts.this, ShowVipContacts.class);
                newActivity.putExtra("subj", s1);
                newActivity.putExtra("sub", s2);
                newActivity.putExtra("sub1", s3);
                newActivity.putExtra("sub2", s4);
                newActivity.putExtra("sub3", s5);
                newActivity.putExtra("sub4", s6);
                newActivity.putExtra("sub5", s7);
                newActivity.putExtra("sub6", s8);
                startActivity(newActivity);
            }else  if (adapterView.getId() == R.id.listView15) {
                String s1 = ((TextView) view.findViewById(R.id.textViewNAME)).getText().toString();
                String s2 = ((TextView) view.findViewById(R.id.textViewPHONE_NUMBER)).getText().toString();
                String s3 = ((TextView) view.findViewById(R.id.textViewSUBJECT)).getText().toString();
                String s4 = ((TextView) view.findViewById(R.id.textView1)).getText().toString();
                String s5 = ((TextView) view.findViewById(R.id.textView2)).getText().toString();
                String s6 = ((TextView) view.findViewById(R.id.textView3)).getText().toString();
                String s7 = ((TextView) view.findViewById(R.id.textView4)).getText().toString();
                String s8 = ((TextView) view.findViewById(R.id.textView67)).getText().toString();



                Intent newActivity = new Intent(VIPContacts.this, ShowVipContacts.class);
                newActivity.putExtra("subj", s1);
                newActivity.putExtra("sub", s2);
                newActivity.putExtra("sub1", s3);
                newActivity.putExtra("sub2", s4);
                newActivity.putExtra("sub3", s5);
                newActivity.putExtra("sub4", s6);
                newActivity.putExtra("sub5", s7);
                newActivity.putExtra("sub6", s8);
                startActivity(newActivity);
            }else  if (adapterView.getId() == R.id.listView16) {
                String s1 = ((TextView) view.findViewById(R.id.textViewNAME)).getText().toString();
                String s2 = ((TextView) view.findViewById(R.id.textViewPHONE_NUMBER)).getText().toString();
                String s3 = ((TextView) view.findViewById(R.id.textViewSUBJECT)).getText().toString();
                String s4 = ((TextView) view.findViewById(R.id.textView1)).getText().toString();
                String s5 = ((TextView) view.findViewById(R.id.textView2)).getText().toString();
                String s6 = ((TextView) view.findViewById(R.id.textView3)).getText().toString();
                String s7 = ((TextView) view.findViewById(R.id.textView4)).getText().toString();
                String s8 = ((TextView) view.findViewById(R.id.textView67)).getText().toString();



                Intent newActivity = new Intent(VIPContacts.this, ShowVipContacts.class);
                newActivity.putExtra("subj", s1);
                newActivity.putExtra("sub", s2);
                newActivity.putExtra("sub1", s3);
                newActivity.putExtra("sub2", s4);
                newActivity.putExtra("sub3", s5);
                newActivity.putExtra("sub4", s6);
                newActivity.putExtra("sub5", s7);
                newActivity.putExtra("sub6", s8);
                startActivity(newActivity);
            }else  if (adapterView.getId() == R.id.listView28) {
                String s1 = ((TextView) view.findViewById(R.id.textViewNAME)).getText().toString();
                String s2 = ((TextView) view.findViewById(R.id.textViewPHONE_NUMBER)).getText().toString();
                String s3 = ((TextView) view.findViewById(R.id.textViewSUBJECT)).getText().toString();
                String s4 = ((TextView) view.findViewById(R.id.textView1)).getText().toString();
                String s5 = ((TextView) view.findViewById(R.id.textView2)).getText().toString();
                String s6 = ((TextView) view.findViewById(R.id.textView3)).getText().toString();
                String s7 = ((TextView) view.findViewById(R.id.textView4)).getText().toString();
                String s8 = ((TextView) view.findViewById(R.id.textView67)).getText().toString();



                Intent newActivity = new Intent(VIPContacts.this, ShowVipContacts.class);
                newActivity.putExtra("subj", s1);
                newActivity.putExtra("sub", s2);
                newActivity.putExtra("sub1", s3);
                newActivity.putExtra("sub2", s4);
                newActivity.putExtra("sub3", s5);
                newActivity.putExtra("sub4", s6);
                newActivity.putExtra("sub5", s7);
                newActivity.putExtra("sub6", s8);
                startActivity(newActivity);
            }
        }
    }


