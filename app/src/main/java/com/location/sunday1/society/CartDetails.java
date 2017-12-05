package com.location.sunday1.society;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CartDetails extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {

    String uid,s1,s2,s3,s4,s5,aa1,aa2;
    SQLiteHelper sq;
    Cursor cursor;
    ListView lv;
    TextView tv,total;
    String i1[],i2[],i3[],i4[],i5[],i6[],mob;
    Button b1,upd,del;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_details);

        final ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.left);
        ArrayList<ListItems> lst=new ArrayList<>();

        b1=(Button)findViewById(R.id.button35);
        b1.setOnClickListener(this);
        Intent intr=getIntent();
        uid=intr.getStringExtra("uid");
        aa1=intr.getStringExtra("pi");
        aa2=intr.getStringExtra("pd");
        lv=(ListView)findViewById(R.id.listView17);
        sq=new SQLiteHelper(this);
        tv=(TextView)findViewById(R.id.textView67);
        total=(TextView)findViewById(R.id.textView120);
        //tv.setText("Total Number Of Item : "+sq.getItemCount(uid));

        cursor=sq.getCartDetailsForUser(uid);
        String[] from = {"id", "item", "unit","qty","price", "tot"};
        Double grandTotal=0.0;
        if(cursor.moveToFirst())
        {
            do{
                ListItems lt=new ListItems();
               lt.setid(cursor.getString(cursor.getColumnIndex("id")));
               lt.setitem(cursor.getString(cursor.getColumnIndex("item")));
               lt.setunit(cursor.getString(cursor.getColumnIndex("unit")));
               lt.setqty(cursor.getString(cursor.getColumnIndex("qty")));
               lt.setprice(cursor.getString(cursor.getColumnIndex("price")));
               lt.settot(cursor.getString(cursor.getColumnIndex("tot")));
                grandTotal=grandTotal+Double.parseDouble(cursor.getString(cursor.getColumnIndex("tot")));
                lst.add(lt);
            }while (cursor.moveToNext());
        }
        int[] to = {R.id.textViewa1, R.id.textViewa2, R.id.textViewa3,R.id.textViewa4,R.id.textViewa5,R.id.textViewa6};
       // SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(CartDetails.this, R.layout.list1, cursor, from, to);
       // CustomAdapter customAdapter=new CustomAdapter(this,i1,i2,i3,i4,i5,i6);
       // lv.setAdapter(customAdapter);
       // lv.setAdapter(cursorAdapter);
       // lv.setOnItemClickListener(this);
        CustomAdapter cust=new CustomAdapter(this,lst,tv,total,uid);
        lv.setAdapter(cust);
        tv.setText("Total Number Of Item : " + sq.getNumberOfItemsInCart(uid));
        //Double d = Double.valueOf(s4) + Double.valueOf(s4);
        total.setText("Total Amount : " +String.valueOf(grandTotal));



    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
        if(requestCode==2)
        {
            Intent inte=new Intent(CartDetails.this,Products.class);
            inte.putExtra("uid",uid);
            inte.putExtra("pi",aa1);
            inte.putExtra("pd",aa2);
            startActivity(inte);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        final String usid = ((TextView) view.findViewById(R.id.textViewa1)).getText().toString();
        s1 = ((TextView) view.findViewById(R.id.textViewa2)).getText().toString();
        s2 = ((TextView) view.findViewById(R.id.textViewa3)).getText().toString();
        s3 = ((TextView) view.findViewById(R.id.textViewa4)).getText().toString();
        s4 = ((TextView) view.findViewById(R.id.textViewa5)).getText().toString();
        s5 = ((TextView) view.findViewById(R.id.textViewa6)).getText().toString();

        upd = (Button) view.findViewById(R.id.button46);
        upd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CartDetails.this, "update", Toast.LENGTH_SHORT).show();

                Intent in = new Intent(CartDetails.this,UpdateCart.class);
                Toast.makeText(getApplication(),"uid : "+uid,Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplication(),"usid : "+usid,Toast.LENGTH_SHORT).show();
                in.putExtra("uid", uid);
                in.putExtra("pi", aa1);
                in.putExtra("pd", aa2);
                in.putExtra("name",s1);
                in.putExtra("name1",s2);
                in.putExtra("name2",s3);
                in.putExtra("name3",s4);
                in.putExtra("name4",s5);
                startActivity(in);
            }
        });
        del = (Button) view.findViewById(R.id.button47);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sq.deletecart(usid)){
                    Toast.makeText(CartDetails.this, "Deleted Successfully", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(CartDetails.this, "Deletion Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {


        if(!sq.getNumberOfItemsInCart(uid).equalsIgnoreCase("0")&&!sq.getNumberOfItemsInCart(uid).equalsIgnoreCase("-1")){

            custpop();


    }
    else {
            Toast.makeText(CartDetails.this, "Please add items to cart", Toast.LENGTH_SHORT).show();
        }
    }


    public void custpop(){
        final Dialog dialog = new Dialog(this);

        dialog.setContentView(R.layout.custom_dialog2);
        dialog.setTitle(" Alert !");
        Button btnSave          = (Button) dialog.findViewById(R.id.save1);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
                String emi=sq.getmailid(uid);
                String name=sq.getName(uid);
                String st=sq.getDetails(uid);
                String[] sub=st.split("/");
                String dor=sub[0];
                String bloc=sub[1];
                String soc=sub[2];
                String are=sub[3];
                mob=sub[4];
                String body="Hi "+name+", Below listed products will be delivered to your address"+"\n";
                String body1= total.getText().toString();
                Toast.makeText(CartDetails.this, body1, Toast.LENGTH_SHORT).show();
                String body2="\n\n Flat No : "+dor+"\n Block No : "+bloc+"\n Society : "+soc+"\n Area : "+are+"\n Mobile Number : "+mob;
                String ss1=null,ss2=null,ss3=null,ss4=null,ss5=null,ss=null;
                Cursor cursor1=sq.getCartDetailsForUser(uid);
                if(cursor1.moveToFirst())
                {
                    int i=0;
                    do {

                        ss1= cursor1.getString(cursor1.getColumnIndex("item"));
                        ss2=cursor1.getString(cursor1.getColumnIndex("unit"));
                        ss3=cursor1.getString(cursor1.getColumnIndex("qty"));
                        ss4=cursor1.getString(cursor1.getColumnIndex("price"));
                        ss5=cursor1.getString(cursor1.getColumnIndex("tot"));
                        body = body+"\n"+"Product : "+ss1+"\n"+"Unit : "+ ss2+"\n"+"Price : "+ss3+"\n"+"Qty : "+ss4+"\n"+"Amount : "+ss5+"\n";

                    }while(cursor1.moveToNext());
                }
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", emi+", 57dot51msm@gmail.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "EmBasket orders for "+sq.getName(uid)+"-" + mob);
                emailIntent.putExtra(Intent.EXTRA_TEXT, body+body2+ "\n\n\n" +body1+"\n"+tv.getText().toString()+"\n  \n Thank you \n EmBeasy Services ");
                startActivityForResult(Intent.createChooser(emailIntent, "Send email..."),2);
                int i=sq.clearCart(uid);
            }
        });
        dialog.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(CartDetails.this,Products.class);
                intent.putExtra("uid",uid);
                startActivity(intent);
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
            Intent intent = new Intent(CartDetails.this,Products.class);
            intent.putExtra("uid",uid);
            intent.putExtra("pi",aa1);
            intent.putExtra("pd",aa2);
            startActivity(intent);
            return true;
        }
        return false;
    }

}
