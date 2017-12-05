package com.location.sunday1.society;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomAdapter1 extends BaseAdapter {
    Context context;
    String countryList[],countryList1[],countryList2[],countryList3[],countryList4[],countryList5[];
    ArrayList<ListItems> list1;
    int flags[];
    LayoutInflater inflter;
    SQLiteHelper sq;
    String ss;

    public CustomAdapter1(Context applicationContext, String[] countryList, String[] countryList1, String[] countryList2, String[] countryList3, String[] countryList4, String[] countryList5) {
        this.context = applicationContext;
        this.countryList = countryList;
        this.countryList1 = countryList1;
        this.countryList2 = countryList2;
        this.countryList3 = countryList3;
        this.countryList4 = countryList4;
        this.countryList5 = countryList5;
        inflter = (LayoutInflater.from(applicationContext));
    }
    public CustomAdapter1(Context applicationContext, ArrayList<ListItems> lista1,String ss) {
        this.context = applicationContext;
        sq=new SQLiteHelper(applicationContext);
        this.list1=lista1;
        this.ss=ss;
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
        view = inflter.inflate(R.layout.my_custom_list, null);
        final ListItems lt=list1.get(i);
        final TextView ss1 = (TextView)view.findViewById(R.id.textViewName);
        final TextView ss2 = (TextView)view.findViewById(R.id.textViewTeam);
        Button b1 = (Button)view.findViewById(R.id.buttonDelete);
        ss1.setText(lt.getid1());
        ss2.setText(lt.getitem1());
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                custpop();

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

    public void custpop(){

               final Dialog dialog = new Dialog(context);

        dialog.setContentView(R.layout.custom_dialog1);
        dialog.setTitle("Alert !");
        //String body="Thank you for your interest in listing here products/services here. Our Admin will contact you shortly regarding this.";

        //TextView tv=(TextView)dialog.findViewById(R.id.tv1);
        //tv.setText(body);
        final EditText editText = (EditText) dialog.findViewById(R.id.editText);
        Button btnSave          = (Button) dialog.findViewById(R.id.save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sf="A query posted by ";
                String sg=" to listing his/her products/services and contacts in EmBizz. \n Thanks "+sq.getName(ss)+". Our admin will contact you shortly. \n Thank you \n EmBeasy Services ";

                dialog.cancel();
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"57dot51msm@gmail.com",sq.getmailid(ss)});
                i.putExtra(Intent.EXTRA_SUBJECT, "EmBizz interest submited by,"+sq.getName(ss)+"-");
                i.putExtra(Intent.EXTRA_TEXT, sf+sq.getName(ss)+sg);
                try {
                    context.startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(context, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        dialog.show();
    }
}