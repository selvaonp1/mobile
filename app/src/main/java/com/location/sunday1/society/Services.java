package com.location.sunday1.society;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Services extends Activity implements AdapterView.OnItemClickListener {

    Button b1,b2,b3,b4,b5,b6,b7,b8;
    ListView lv,lv1,lv2,lv3,lv4,lv5,lv6,lv7;
    SQLiteHelper sq;
    Cursor cursor;
    String cat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.services);

        sq= new SQLiteHelper(this);

        b1 = (Button)findViewById(R.id.button12);
        b2 = (Button)findViewById(R.id.button13);
        b3 = (Button)findViewById(R.id.button14);
        b4 = (Button)findViewById(R.id.button15);
        b5 = (Button)findViewById(R.id.button16);
        b6 = (Button)findViewById(R.id.button8);
        b7 = (Button)findViewById(R.id.button19);
        b8 = (Button)findViewById(R.id.button56);
        lv=(ListView)findViewById(R.id.listView4);
        lv1=(ListView)findViewById(R.id.listView5);
        lv2=(ListView)findViewById(R.id.listView6);
        lv3=(ListView)findViewById(R.id.listView7);
        lv4=(ListView)findViewById(R.id.listView8);
        lv5=(ListView)findViewById(R.id.listView9);
        lv6=(ListView)findViewById(R.id.listView10);
        lv7=(ListView)findViewById(R.id.listView27);
        lv.setOnItemClickListener(this);
        lv1.setOnItemClickListener(this);
        lv2.setOnItemClickListener(this);
        lv3.setOnItemClickListener(this);
        lv4.setOnItemClickListener(this);
        lv5.setOnItemClickListener(this);
        lv6.setOnItemClickListener(this);
        lv7.setOnItemClickListener(this);

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
                b7.setBackgroundDrawable(dr1);
                b8.setBackgroundDrawable(dr1);


                lv.setVisibility(View.VISIBLE);
                lv1.setVisibility(View.INVISIBLE);
                lv2.setVisibility(View.INVISIBLE);
                lv3.setVisibility(View.INVISIBLE);
                lv4.setVisibility(View.INVISIBLE);
                lv5.setVisibility(View.INVISIBLE);
                lv6.setVisibility(View.INVISIBLE);
                lv7.setVisibility(View.INVISIBLE);

                cursor = sq.queryNamepay2("Electronic Fixes");
                cat = "Electronic Fixes";
                String[] from = {"_id", "id", "service"};
                int[] to = {R.id.textViewID, R.id.textViewNAME, R.id.textViewPHONE_NUMBER};
                SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(Services.this, R.layout.listviewdatalayout, cursor, from, to);
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
                b7.setBackgroundDrawable(dr1);
                b8.setBackgroundDrawable(dr1);



                lv.setVisibility(View.INVISIBLE);
                lv1.setVisibility(View.VISIBLE);
                lv2.setVisibility(View.INVISIBLE);
                lv3.setVisibility(View.INVISIBLE);
                lv4.setVisibility(View.INVISIBLE);
                lv5.setVisibility(View.INVISIBLE);
                lv6.setVisibility(View.INVISIBLE);
                lv7.setVisibility(View.INVISIBLE);

                cursor = sq.queryNamepay2("Household fixes");
                cat = "Household fixes";
                String[] from = {"_id", "id", "service"};
                int[] to = {R.id.textViewID, R.id.textViewNAME, R.id.textViewPHONE_NUMBER};
                SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(Services.this, R.layout.listviewdatalayout, cursor, from, to);
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
                b7.setBackgroundDrawable(dr1);
                b8.setBackgroundDrawable(dr1);

                lv.setVisibility(View.INVISIBLE);
                lv1.setVisibility(View.INVISIBLE);
                lv2.setVisibility(View.VISIBLE);
                lv3.setVisibility(View.INVISIBLE);
                lv4.setVisibility(View.INVISIBLE);
                lv5.setVisibility(View.INVISIBLE);
                lv6.setVisibility(View.INVISIBLE);
                lv7.setVisibility(View.INVISIBLE);
                cursor = sq.queryNamepay2("Hosuehold needs");
                cat = "Household needs";
                String[] from = {"_id", "id", "service"};
                int[] to = {R.id.textViewID, R.id.textViewNAME, R.id.textViewPHONE_NUMBER};
                SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(Services.this, R.layout.listviewdatalayout, cursor, from, to);
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
                b7.setBackgroundDrawable(dr1);
                b8.setBackgroundDrawable(dr1);



                lv.setVisibility(View.INVISIBLE);
                lv1.setVisibility(View.INVISIBLE);
                lv2.setVisibility(View.INVISIBLE);
                lv3.setVisibility(View.VISIBLE);
                lv4.setVisibility(View.INVISIBLE);
                lv5.setVisibility(View.INVISIBLE);
                lv6.setVisibility(View.INVISIBLE);
                lv7.setVisibility(View.INVISIBLE);
                cursor = sq.queryNamepay2("automobiles");
                cat = "automobiles";
                String[] from = {"_id", "id", "service"};
                int[] to = {R.id.textViewID, R.id.textViewNAME, R.id.textViewPHONE_NUMBER};
                SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(Services.this, R.layout.listviewdatalayout, cursor, from, to);
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
                b6.setBackgroundDrawable(dr1);
                b7.setBackgroundDrawable(dr1);
                b8.setBackgroundDrawable(dr1);


                lv.setVisibility(View.INVISIBLE);
                lv1.setVisibility(View.INVISIBLE);
                lv2.setVisibility(View.INVISIBLE);
                lv3.setVisibility(View.INVISIBLE);
                lv4.setVisibility(View.VISIBLE);
                lv5.setVisibility(View.INVISIBLE);
                lv6.setVisibility(View.INVISIBLE);
                lv7.setVisibility(View.INVISIBLE);
                cursor = sq.queryNamepay2("Medical");
                cat = "Medical";
                String[] from = {"_id", "id", "service"};
                int[] to = {R.id.textViewID, R.id.textViewNAME, R.id.textViewPHONE_NUMBER};
                SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(Services.this, R.layout.listviewdatalayout, cursor, from, to);
                lv4.setAdapter(cursorAdapter);

            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               /* b1.setBackgroundColor(Color.BLUE);
                b2.setBackgroundColor(Color.BLUE);
                b3.setBackgroundColor(Color.BLUE);
                b4.setBackgroundColor(Color.BLUE);
                b5.setBackgroundColor(Color.BLUE);
                b6.setBackgroundColor(Color.GRAY);
                b7.setBackgroundColor(Color.BLUE);*/

                Drawable dr = getResources().getDrawable(R.drawable.border2);
                Drawable dr1 = getResources().getDrawable(R.drawable.border1);

                b1.setBackgroundDrawable(dr1);
                b2.setBackgroundDrawable(dr1);
                b3.setBackgroundDrawable(dr1);
                b4.setBackgroundDrawable(dr1);
                b5.setBackgroundDrawable(dr1);
                b6.setBackgroundDrawable(dr);
                b7.setBackgroundDrawable(dr1);
                b8.setBackgroundDrawable(dr1);

                lv.setVisibility(View.INVISIBLE);
                lv1.setVisibility(View.INVISIBLE);
                lv2.setVisibility(View.INVISIBLE);
                lv3.setVisibility(View.INVISIBLE);
                lv4.setVisibility(View.INVISIBLE);
                lv5.setVisibility(View.VISIBLE);
                lv6.setVisibility(View.INVISIBLE);
                lv7.setVisibility(View.INVISIBLE);
                cursor = sq.queryNamepay2("Sports");
                cat = "Sports";
                String[] from = {"_id", "id", "service"};
                int[] to = {R.id.textViewID, R.id.textViewNAME, R.id.textViewPHONE_NUMBER};
                SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(Services.this, R.layout.listviewdatalayout, cursor, from, to);
                lv5.setAdapter(cursorAdapter);

            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Drawable dr = getResources().getDrawable(R.drawable.border2);
                Drawable dr1 = getResources().getDrawable(R.drawable.border1);

                b1.setBackgroundDrawable(dr1);
                b2.setBackgroundDrawable(dr1);
                b3.setBackgroundDrawable(dr1);
                b4.setBackgroundDrawable(dr1);
                b5.setBackgroundDrawable(dr1);
                b6.setBackgroundDrawable(dr1);
                b7.setBackgroundDrawable(dr);
                b8.setBackgroundDrawable(dr1);


                /*b1.setBackgroundColor(Color.BLUE);
                b2.setBackgroundColor(Color.BLUE);
                b3.setBackgroundColor(Color.BLUE);
                b4.setBackgroundColor(Color.BLUE);
                b5.setBackgroundColor(Color.BLUE);
                b6.setBackgroundColor(Color.BLUE);
                b7.setBackgroundColor(Color.GRAY);
*/

                lv.setVisibility(View.INVISIBLE);
                lv1.setVisibility(View.INVISIBLE);
                lv2.setVisibility(View.INVISIBLE);
                lv3.setVisibility(View.INVISIBLE);
                lv4.setVisibility(View.INVISIBLE);
                lv5.setVisibility(View.INVISIBLE);
                lv6.setVisibility(View.VISIBLE);
                lv7.setVisibility(View.INVISIBLE);
                cursor = sq.queryNamepay2("Transport");
                cat = "Transport";
                String[] from = {"_id", "id", "service"};
                int[] to = {R.id.textViewID, R.id.textViewNAME, R.id.textViewPHONE_NUMBER};
                SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(Services.this, R.layout.listviewdatalayout, cursor, from, to);
                lv6.setAdapter(cursorAdapter);

            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Drawable dr = getResources().getDrawable(R.drawable.border2);
                Drawable dr1 = getResources().getDrawable(R.drawable.border1);

                b1.setBackgroundDrawable(dr1);
                b2.setBackgroundDrawable(dr1);
                b3.setBackgroundDrawable(dr1);
                b4.setBackgroundDrawable(dr1);
                b5.setBackgroundDrawable(dr1);
                b6.setBackgroundDrawable(dr1);
                b7.setBackgroundDrawable(dr1);
                b8.setBackgroundDrawable(dr);


                /*b1.setBackgroundColor(Color.BLUE);
                b2.setBackgroundColor(Color.BLUE);
                b3.setBackgroundColor(Color.BLUE);
                b4.setBackgroundColor(Color.BLUE);
                b5.setBackgroundColor(Color.BLUE);
                b6.setBackgroundColor(Color.BLUE);
                b7.setBackgroundColor(Color.GRAY);
*/

                lv.setVisibility(View.INVISIBLE);
                lv1.setVisibility(View.INVISIBLE);
                lv2.setVisibility(View.INVISIBLE);
                lv3.setVisibility(View.INVISIBLE);
                lv4.setVisibility(View.INVISIBLE);
                lv5.setVisibility(View.INVISIBLE);
                lv6.setVisibility(View.INVISIBLE);
                lv7.setVisibility(View.VISIBLE);

                cursor = sq.queryNamepay2("others");
                cat = "others";
                String[] from = {"_id", "id", "service"};
                int[] to = {R.id.textViewID, R.id.textViewNAME, R.id.textViewPHONE_NUMBER};
                SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(Services.this, R.layout.listviewdatalayout, cursor, from, to);
                lv7.setAdapter(cursorAdapter);

            }
        });





    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


        if (adapterView.getId() == R.id.listView4) {
            String s1 = ((TextView) view.findViewById(R.id.textViewNAME)).getText().toString();
            String s2 = ((TextView) view.findViewById(R.id.textViewPHONE_NUMBER)).getText().toString();



            Intent newActivity = new Intent(Services.this, ServiceList.class);
            newActivity.putExtra("subj", s1);
            newActivity.putExtra("sub", s2);
            newActivity.putExtra("cat", cat);
            startActivity(newActivity);
        }else  if (adapterView.getId() == R.id.listView5) {
            String s1 = ((TextView) view.findViewById(R.id.textViewNAME)).getText().toString();
            String s2 = ((TextView) view.findViewById(R.id.textViewPHONE_NUMBER)).getText().toString();




            Intent newActivity = new Intent(Services.this, ServiceList.class);

            newActivity.putExtra("subj", s1);
            newActivity.putExtra("sub", s2);
            newActivity.putExtra("cat", cat);


            startActivity(newActivity);
        }else if (adapterView.getId() == R.id.listView6) {
            String s1 = ((TextView) view.findViewById(R.id.textViewNAME)).getText().toString();
            String s2 = ((TextView) view.findViewById(R.id.textViewPHONE_NUMBER)).getText().toString();




            Intent newActivity = new Intent(Services.this, ServiceList.class);

            newActivity.putExtra("subj", s1);
            newActivity.putExtra("sub", s2);
            newActivity.putExtra("cat", cat);



            startActivity(newActivity);
        }else  if (adapterView.getId() == R.id.listView7) {
            String s1 = ((TextView) view.findViewById(R.id.textViewNAME)).getText().toString();
            String s2 = ((TextView) view.findViewById(R.id.textViewPHONE_NUMBER)).getText().toString();




            Intent newActivity = new Intent(Services.this, ServiceList.class);

            newActivity.putExtra("subj", s1);
            newActivity.putExtra("sub", s2);
            newActivity.putExtra("cat", cat);



            startActivity(newActivity);
        }else  if (adapterView.getId() == R.id.listView8) {
            String s1 = ((TextView) view.findViewById(R.id.textViewNAME)).getText().toString();
            String s2 = ((TextView) view.findViewById(R.id.textViewPHONE_NUMBER)).getText().toString();




            Intent newActivity = new Intent(Services.this, ServiceList.class);

            newActivity.putExtra("subj", s1);
            newActivity.putExtra("sub", s2);
            newActivity.putExtra("cat", cat);


            startActivity(newActivity);
        }else  if (adapterView.getId() == R.id.listView9) {
            String s1 = ((TextView) view.findViewById(R.id.textViewNAME)).getText().toString();
            String s2 = ((TextView) view.findViewById(R.id.textViewPHONE_NUMBER)).getText().toString();




            Intent newActivity = new Intent(Services.this, ServiceList.class);

            newActivity.putExtra("subj", s1);
            newActivity.putExtra("sub", s2);

            newActivity.putExtra("cat", cat);


            startActivity(newActivity);
        }else  if (adapterView.getId() == R.id.listView10) {
            String s1 = ((TextView) view.findViewById(R.id.textViewNAME)).getText().toString();
            String s2 = ((TextView) view.findViewById(R.id.textViewPHONE_NUMBER)).getText().toString();



            Intent newActivity = new Intent(Services.this, ServiceList.class);

            newActivity.putExtra("subj", s1);
            newActivity.putExtra("sub", s2);
            newActivity.putExtra("cat", cat);



            startActivity(newActivity);
        }else  if (adapterView.getId() == R.id.listView27) {
            String s1 = ((TextView) view.findViewById(R.id.textViewNAME)).getText().toString();
            String s2 = ((TextView) view.findViewById(R.id.textViewPHONE_NUMBER)).getText().toString();


            Intent newActivity = new Intent(Services.this, ServiceList.class);

            newActivity.putExtra("subj", s1);
            newActivity.putExtra("sub", s2);
            newActivity.putExtra("cat", cat);


            startActivity(newActivity);
        }
    }


}
