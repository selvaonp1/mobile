package com.location.sunday1.society;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Events extends Activity implements AdapterView.OnItemClickListener {

    Button b1,b2,b3,b4,b5;
    Spinner s1,s2,s3,s4,s5;
    SQLiteHelper sq;
    ListView lv,lv1,lv2,lv3,lv4,lv5;
    Cursor cursor;
    String cat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events);


        sq= new SQLiteHelper(this);


        b1 = (Button)findViewById(R.id.button23);
        b2 = (Button)findViewById(R.id.button24);
        b3 = (Button)findViewById(R.id.button25);
        b4 = (Button)findViewById(R.id.button38);
        b5 = (Button)findViewById(R.id.button58);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Events.this,Anyideas.class);
                startActivity(in);
            }
        });


        lv=(ListView)findViewById(R.id.listView17);
        lv1=(ListView)findViewById(R.id.listView18);
        lv2=(ListView)findViewById(R.id.listView19);
        lv3=(ListView)findViewById(R.id.listView30);

        lv.setOnItemClickListener(this);
        lv1.setOnItemClickListener(this);
        lv2.setOnItemClickListener(this);
        lv3.setOnItemClickListener(this);

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
                b5.setBackgroundDrawable(dr1);


                lv.setVisibility(View.VISIBLE);
                lv1.setVisibility(View.INVISIBLE);
                lv2.setVisibility(View.INVISIBLE);
                lv3.setVisibility(View.INVISIBLE);


                cursor = sq.queryNamepay5("this_month");
                cat = "this_month";
                String[] from = {"_id", "id", "event_name", "time"};
                int[] to = {R.id.textViewID, R.id.textViewNAME, R.id.textViewPHONE_NUMBER, R.id.textViewSUBJECT};
                SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(Events.this, R.layout.listviewdatalayout, cursor, from, to);
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
                b5.setBackgroundDrawable(dr1);




                lv.setVisibility(View.INVISIBLE);
                lv1.setVisibility(View.VISIBLE);
                lv2.setVisibility(View.INVISIBLE);
                lv3.setVisibility(View.INVISIBLE);




                cursor = sq.queryNamepay5("upcoming");
                cat = "upcoming";
                String[] from = {"_id", "id", "event_name","time"};
                int[] to = {R.id.textViewID, R.id.textViewNAME, R.id.textViewPHONE_NUMBER,R.id.textViewSUBJECT};
                SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(Events.this, R.layout.listviewdatalayout, cursor, from, to);
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
                b5.setBackgroundDrawable(dr);



                lv.setVisibility(View.INVISIBLE);
                lv1.setVisibility(View.INVISIBLE);
                lv2.setVisibility(View.VISIBLE);

                lv3.setVisibility(View.INVISIBLE);


                cursor = sq.queryNamepay5("previous");
                cat = "previous";
                String[] from = {"_id", "id", "event_name","time"};
                int[] to = {R.id.textViewID, R.id.textViewNAME, R.id.textViewPHONE_NUMBER,R.id.textViewSUBJECT};
                SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(Events.this, R.layout.listviewdatalayout, cursor, from, to);
                lv2.setAdapter(cursorAdapter);

            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
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
                b3.setBackgroundDrawable(dr1);
                b5.setBackgroundDrawable(dr);



                lv.setVisibility(View.INVISIBLE);
                lv1.setVisibility(View.INVISIBLE);
                lv2.setVisibility(View.INVISIBLE);
                lv3.setVisibility(View.VISIBLE);



                cursor = sq.queryNamepay5("others");
                cat = "previous";
                String[] from = {"_id", "id", "event_name","time"};
                int[] to = {R.id.textViewID, R.id.textViewNAME, R.id.textViewPHONE_NUMBER,R.id.textViewSUBJECT};
                SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(Events.this, R.layout.listviewdatalayout, cursor, from, to);
                lv3.setAdapter(cursorAdapter);

            }
        });






    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


        if (adapterView.getId() == R.id.listView17) {
            String s1 = ((TextView) view.findViewById(R.id.textViewNAME)).getText().toString();
            String s2 = ((TextView) view.findViewById(R.id.textViewPHONE_NUMBER)).getText().toString();
            String s3 = ((TextView) view.findViewById(R.id.textViewSUBJECT)).getText().toString();




            Intent newActivity = new Intent(Events.this, ShowEvents.class);
            newActivity.putExtra("subj", s1);
            newActivity.putExtra("sub", s2);
            newActivity.putExtra("sub1", s3);
            newActivity.putExtra("cat", cat);

            startActivity(newActivity);
        }else  if (adapterView.getId() == R.id.listView18) {
            String s1 = ((TextView) view.findViewById(R.id.textViewNAME)).getText().toString();
            String s2 = ((TextView) view.findViewById(R.id.textViewPHONE_NUMBER)).getText().toString();
            String s3 = ((TextView) view.findViewById(R.id.textViewSUBJECT)).getText().toString();




            Intent newActivity = new Intent(Events.this, ShowEvents.class);
            newActivity.putExtra("subj", s1);
            newActivity.putExtra("sub", s2);
            newActivity.putExtra("sub1", s3);
            newActivity.putExtra("cat", cat);

            startActivity(newActivity);
        }else if (adapterView.getId() == R.id.listView19) {
            String s1 = ((TextView) view.findViewById(R.id.textViewNAME)).getText().toString();
            String s2 = ((TextView) view.findViewById(R.id.textViewPHONE_NUMBER)).getText().toString();
            String s3 = ((TextView) view.findViewById(R.id.textViewSUBJECT)).getText().toString();




            Intent newActivity = new Intent(Events.this, ShowEvents.class);
            newActivity.putExtra("subj", s1);
            newActivity.putExtra("sub", s2);
            newActivity.putExtra("sub1", s3);
            newActivity.putExtra("cat", cat);

            startActivity(newActivity);
        }else if (adapterView.getId() == R.id.listView30) {
            String s1 = ((TextView) view.findViewById(R.id.textViewNAME)).getText().toString();
            String s2 = ((TextView) view.findViewById(R.id.textViewPHONE_NUMBER)).getText().toString();
            String s3 = ((TextView) view.findViewById(R.id.textViewSUBJECT)).getText().toString();




            Intent newActivity = new Intent(Events.this, ShowEvents.class);
            newActivity.putExtra("subj", s1);
            newActivity.putExtra("sub", s2);
            newActivity.putExtra("sub1", s3);
            newActivity.putExtra("cat", cat);

            startActivity(newActivity);
        }
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








