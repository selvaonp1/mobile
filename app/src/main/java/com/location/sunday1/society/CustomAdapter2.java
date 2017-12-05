package com.location.sunday1.society;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomAdapter2 extends BaseAdapter {
    Context context;
    String countryList[],countryList1[],countryList2[],countryList3[],countryList4[],countryList5[];
    ArrayList<ListItems1> list1;
    int flags[];
    LayoutInflater inflter;
    SQLiteHelper sq;

    public CustomAdapter2(Context applicationContext, String[] countryList, String[] countryList1, String[] countryList2, String[] countryList3, String[] countryList4, String[] countryList5) {
        this.context = applicationContext;
        this.countryList = countryList;
        this.countryList1 = countryList1;
        this.countryList2 = countryList2;
        this.countryList3 = countryList3;
        this.countryList4 = countryList4;
        this.countryList5 = countryList5;
        inflter = (LayoutInflater.from(applicationContext));
    }
    public CustomAdapter2(Context applicationContext, ArrayList<ListItems1> lista1) {
        this.context = applicationContext;
        sq=new SQLiteHelper(applicationContext);
        this.list1=lista1;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return list1.size();
    }

    @Override
    public Object getItem(int i) {
        return list1.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.activity_listview1, null);
        final ListItems1 lt=list1.get(i);
        final TextView ss1 = (TextView)view.findViewById(R.id.textViewb1);
        final TextView ss2 = (TextView)view.findViewById(R.id.textViewab1);
        Button b1 = (Button)view.findViewById(R.id.button46);
        ss1.setText(lt.getid());
        ss2.setText(lt.getitem());
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "hi"+ss1.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        /*ss1.setText(countryList[i]);
        ss2.setText(countryList1[i]);
        ss3.setText(countryList2[i]);
        ss4.setText(countryList3[i]);
        ss5.setText(countryList4[i]);
        ss6.setText(countryList5[i]);*/



        return view;
    }
}