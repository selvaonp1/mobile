package com.location.sunday1.society;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class CustomAdapter extends BaseAdapter {
    Context context;
    String countryList[],countryList1[],countryList2[],countryList3[],countryList4[],countryList5[];
    ArrayList<ListItems> list1;
    int flags[];
    LayoutInflater inflter;
    SQLiteHelper sq;
    TextView tv,total;
    String uid;

    public CustomAdapter(Context applicationContext, String[] countryList,String[] countryList1,String[] countryList2,String[] countryList3,String[] countryList4,String[] countryList5) {
        this.context = applicationContext;
        this.countryList = countryList;
        this.countryList1 = countryList1;
        this.countryList2 = countryList2;
        this.countryList3 = countryList3;
        this.countryList4 = countryList4;
        this.countryList5 = countryList5;
        inflter = (LayoutInflater.from(applicationContext));
    }
    public CustomAdapter(Context applicationContext, ArrayList<ListItems> lista1,TextView tv,TextView total,String uid) {
        this.context = applicationContext;
        sq=new SQLiteHelper(applicationContext);
        this.list1=lista1;
        this.uid=uid;
        inflter = (LayoutInflater.from(applicationContext));
        this.tv=tv;
        this.total=total;
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
        view = inflter.inflate(R.layout.activity_listview, null);
        final ListItems lt=list1.get(i);
        final TextView ss1 = (TextView)view.findViewById(R.id.textViewa1);
        final TextView ss2 = (TextView)view.findViewById(R.id.textViewa2);
        TextView ss3 = (TextView)view.findViewById(R.id.textViewa3);
        TextView ss4 = (TextView)view.findViewById(R.id.textViewa4);
        TextView ss5 = (TextView)view.findViewById(R.id.textViewa5);
        TextView ss6 = (TextView)view.findViewById(R.id.textViewa6);
        Button b1 = (Button)view.findViewById(R.id.button46);
        Button b2 = (Button)view.findViewById(R.id.button47);
        ss1.setText(lt.getid());
        ss2.setText(lt.getitem());
        ss3.setText(lt.getunit());
        ss4.setText(lt.getqty());
        ss5.setText(lt.getprice());
        ss6.setText(lt.gettot());
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(context,UpdateCart.class);
                in.putExtra("name",lt.getitem());
                in.putExtra("name1",lt.getunit());
                in.putExtra("name2",lt.gettot());
                in.putExtra("name3",lt.getqty());
                in.putExtra("name4",lt.getprice());
                in.putExtra("uid",lt.getid());
                in.putExtra("userid",uid);
                Toast.makeText(context, uid, Toast.LENGTH_SHORT).show();
                context.startActivity(in);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(sq.deletecart(lt.getid()))
               {
                   tv.setText("Total Number Of Item : "+sq.getNumberOfItemsInCart(uid));
                   total.setText("Total Amount : " +String.valueOf(sq.getTotalAmount(uid)));
                   list1.remove(i);
                   notifyDataSetChanged();
                   Toast.makeText(context, "Successfully Deleted", Toast.LENGTH_SHORT).show();
               }
                else{
                   Toast.makeText(context, "DeleteFailed", Toast.LENGTH_SHORT).show();
               }
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