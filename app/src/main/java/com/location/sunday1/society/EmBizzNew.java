package com.location.sunday1.society;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class EmBizzNew extends AppCompatActivity implements AdapterView.OnItemClickListener {

    Button mail,others;
    EditText services;
    ListView lv;
    SQLiteHelper sq;
    Cursor cursor;
    Context context;
    String countryList[],countryList1[],countryList2[],countryList3[],countryList4[],countryList5[];
    ArrayList<ListItems> list1;
    int flags[];
    LayoutInflater inflter;
    String uid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.em_bizz_new);

        sq= new SQLiteHelper(this);

        services = (EditText)findViewById(R.id.editText35);
        lv = (ListView)findViewById(R.id.listView31);
        lv.setVisibility(View.INVISIBLE);
        mail = (Button)findViewById(R.id.button60);
        others = (Button)findViewById(R.id.button61);

        Intent in = getIntent();
        uid = in.getStringExtra("uid");

        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                custpop();
            }
        });

        lv.setOnItemClickListener(this);

        others.setOnClickListener(new View.OnClickListener() {
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

                others.setBackgroundDrawable(dr);



                lv.setVisibility(View.VISIBLE);



                cursor = sq.queryNamepay6("others");
                String[] from = {"_id", "id", "service", "category", "service_provider_name", "mobileno", "landline", "address"};
                int[] to = {R.id.textViewID, R.id.textViewNAME, R.id.textViewPHONE_NUMBER, R.id.textViewSUBJECT, R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4};
                SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(EmBizzNew.this, R.layout.listviewdatalayout, cursor, from, to);
                lv.setAdapter(cursorAdapter);

            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == R.id.listView31) {
            String s1 = ((TextView) view.findViewById(R.id.textViewNAME)).getText().toString();
            String s2 = ((TextView) view.findViewById(R.id.textViewPHONE_NUMBER)).getText().toString();
            String s3 = ((TextView) view.findViewById(R.id.textViewSUBJECT)).getText().toString();
            String s4 = ((TextView) view.findViewById(R.id.textView1)).getText().toString();
            String s5 = ((TextView) view.findViewById(R.id.textView2)).getText().toString();
            String s6 = ((TextView) view.findViewById(R.id.textView3)).getText().toString();
            String s7 = ((TextView) view.findViewById(R.id.textView4)).getText().toString();




            Intent newActivity = new Intent(EmBizzNew.this, ShowQueries.class);
            newActivity.putExtra("subj", s1);
            newActivity.putExtra("sub", s2);
            newActivity.putExtra("sub1", s3);
            newActivity.putExtra("sub2", s4);
            newActivity.putExtra("sub3", s5);
            newActivity.putExtra("sub4", s6);
            newActivity.putExtra("sub5", s7);

            startActivity(newActivity);

        }
    }
    public void custpop(){

        final Dialog dialog = new Dialog(EmBizzNew.this);

        dialog.setContentView(R.layout.custom_dialog1);
        dialog.setTitle("Alert !");
        //String body="Thank you for your interest in listing here products/services here. Our Admin will contact you shortly regarding this.";

        //TextView tv=(TextView)dialog.findViewById(R.id.tv1);
        //tv.setText(body);

        Button btnSave          = (Button) dialog.findViewById(R.id.save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sf="A query posted by ";
                String sg=" to listing his/her products/services and contacts in EmBizz. \n\n QUERY : \n "+services.getText().toString()+" \n\n Thanks "+sq.getName(uid)+". Our admin will contact you shortly. \n Thank you \n EmBeasy Services ";

                dialog.cancel();
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"57dot51msm@gmail.com",sq.getmailid(uid)});
                i.putExtra(Intent.EXTRA_SUBJECT, "EmBizz interest submited by, "+sq.getName(uid)+"-"+uid);
                i.putExtra(Intent.EXTRA_TEXT, sf+sq.getName(uid)+sg);
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(EmBizzNew.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        dialog.show();
    }
}
