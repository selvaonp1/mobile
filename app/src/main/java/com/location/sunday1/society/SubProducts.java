package com.location.sunday1.society;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class SubProducts extends AppCompatActivity {

    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20,t21;
    String s1,s2,s3,s4,uid,aa1,aa2;
    SQLiteHelper sq;
    EditText e1,e2,e3,e4,e5;
    TextView tot;
    Button calculate,addcart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub_products);

        final ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.left);

        sq=new SQLiteHelper(this);
        findingIds();



        Intent in = getIntent();
        s2 = in.getStringExtra("subj");
        s1 = in.getStringExtra("sub");
        s3 = in.getStringExtra("sub1");
        s4 = in.getStringExtra("sub2");
        uid = in.getStringExtra("uid");
        aa1 = in.getStringExtra("pi");
        aa2 = in.getStringExtra("pd");

        t15.setText(s3+" / ");
        t16.setText(s2);
        t17.setText(s4);


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Edit Text values
                Double a = Double.valueOf(e1.getText().toString());
                Double b = Double.valueOf(e2.getText().toString());
                Double c = Double.valueOf(e3.getText().toString());
                Double d = Double.valueOf(e4.getText().toString());
                Double e = Double.valueOf(e5.getText().toString());

                //TextView Values

                Double a1 = Double.valueOf(t17.getText().toString());
                Double b1 = Double.valueOf(t18.getText().toString());
                Double c1 = Double.valueOf(t19.getText().toString());
                Double d1 = Double.valueOf(t20.getText().toString());
                Double e1 = Double.valueOf(t21.getText().toString());

                Double totalamt = (a * a1) + (b * b1) + (c * c1) + (d * d1) + (e * e1);
                tot.setText(totalamt + "");
                addcart.setVisibility(View.VISIBLE);
            }
        });

        addcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int i = -1;
                if (!(e1.getText().toString().equalsIgnoreCase("0"))) {
                    Double a = Double.valueOf(e1.getText().toString());
                    Double a1 = Double.valueOf(t17.getText().toString());
                    Double at = a * a1;
                    i = sq.insertAddcart(uid, t1.getText().toString(), t6.getText().toString(), e1.getText().toString(), t17.getText().toString(), String.valueOf(at));
                }
                if (!(e2.getText().toString().equalsIgnoreCase("0"))) {
                    Double a = Double.valueOf(e2.getText().toString());
                    Double a1 = Double.valueOf(t18.getText().toString());
                    Double at = a * a1;
                    i = sq.insertAddcart(uid, t2.getText().toString(), t7.getText().toString(), e2.getText().toString(), t18.getText().toString(), String.valueOf(at));
                }
                if (!(e3.getText().toString().equalsIgnoreCase("0"))) {
                    Double a = Double.valueOf(e3.getText().toString());
                    Double a1 = Double.valueOf(t19.getText().toString());
                    Double at = a * a1;
                    i = sq.insertAddcart(uid, t3.getText().toString(), t8.getText().toString(), e3.getText().toString(), t19.getText().toString(), String.valueOf(at));
                }
                if (!(e4.getText().toString().equalsIgnoreCase("0"))) {
                    Double a = Double.valueOf(e4.getText().toString());
                    Double a1 = Double.valueOf(t20.getText().toString());
                    Double at = a * a1;
                    i = sq.insertAddcart(uid, t4.getText().toString(), t9.getText().toString(), e4.getText().toString(), t20.getText().toString(), String.valueOf(at));
                }
                if (!(e5.getText().toString().equalsIgnoreCase("0"))) {
                    Double a = Double.valueOf(e5.getText().toString());
                    Double a1 = Double.valueOf(t21.getText().toString());
                    Double at = a * a1;
                    i = sq.insertAddcart(uid, t5.getText().toString(), t10.getText().toString(), e5.getText().toString(), t21.getText().toString(), String.valueOf(at));
                }

                if (i == -1) {
                    Toast.makeText(SubProducts.this, "fail", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SubProducts.this, "success", Toast.LENGTH_SHORT).show();
                    Intent In = new Intent(SubProducts.this, Products.class);
                    In.putExtra("uid", uid);
                    In.putExtra("pi", aa1);
                    In.putExtra("pd", aa2);
                    startActivity(In);
                    e1.setText("0");
                    e2.setText("0");
                    e3.setText("0");
                    e4.setText("0");
                    e5.setText("0");
                }

            }
        });


        Toast.makeText(SubProducts.this, s2, Toast.LENGTH_SHORT).show();
        String fe=sq.getUnitDetails(s2);
        String det[]=fe.split(">");

        String unitnaTot=det[0];
        String priceTot=det[1];

        String[] unitna=unitnaTot.split("/");
        String[] pricea=priceTot.split("/");

        switch (unitna.length)
        {
            case 1:

                e1.setVisibility(View.VISIBLE);
                t1.setVisibility(View.VISIBLE);
                t17.setVisibility(View.VISIBLE);
                t6.setVisibility(View.VISIBLE);
                t6.setText(unitna[0]);
                t17.setText(pricea[0]);

                break;

            case 2:

                e1.setVisibility(View.VISIBLE);
                e2.setVisibility(View.VISIBLE);

                t1.setVisibility(View.VISIBLE);
                t2.setVisibility(View.VISIBLE);

                t17.setVisibility(View.VISIBLE);
                t18.setVisibility(View.VISIBLE);

                t6.setVisibility(View.VISIBLE);
                t7.setVisibility(View.VISIBLE);

                t6.setText(unitna[0]);
                t7.setText(unitna[1]);
                t17.setText(pricea[0]);
                t18.setText(pricea[1]);


                break;

            case 3:

                e1.setVisibility(View.VISIBLE);
                e2.setVisibility(View.VISIBLE);
                e3.setVisibility(View.VISIBLE);

                t1.setVisibility(View.VISIBLE);
                t2.setVisibility(View.VISIBLE);
                t3.setVisibility(View.VISIBLE);

                t17.setVisibility(View.VISIBLE);
                t18.setVisibility(View.VISIBLE);
                t19.setVisibility(View.VISIBLE);

                t6.setVisibility(View.VISIBLE);
                t7.setVisibility(View.VISIBLE);
                t8.setVisibility(View.VISIBLE);

                t6.setText(unitna[0]);
                t7.setText(unitna[1]);
                t8.setText(unitna[2]);
                t17.setText(pricea[0]);
                t18.setText(pricea[1]);
                t19.setText(pricea[2]);

                break;

            case 4:

                e1.setVisibility(View.VISIBLE);
                e2.setVisibility(View.VISIBLE);
                e3.setVisibility(View.VISIBLE);
                e4.setVisibility(View.VISIBLE);

                t1.setVisibility(View.VISIBLE);
                t2.setVisibility(View.VISIBLE);
                t3.setVisibility(View.VISIBLE);
                t4.setVisibility(View.VISIBLE);

                t17.setVisibility(View.VISIBLE);
                t18.setVisibility(View.VISIBLE);
                t19.setVisibility(View.VISIBLE);
                t20.setVisibility(View.VISIBLE);

                t6.setVisibility(View.VISIBLE);
                t7.setVisibility(View.VISIBLE);
                t8.setVisibility(View.VISIBLE);
                t9.setVisibility(View.VISIBLE);

                t6.setText(unitna[0]);
                t7.setText(unitna[1]);
                t8.setText(unitna[2]);
                t9.setText(unitna[3]);
                t17.setText(pricea[0]);
                t18.setText(pricea[1]);
                t19.setText(pricea[2]);
                t20.setText(pricea[3]);



                break;

            case 5:

                e1.setVisibility(View.VISIBLE);
                e2.setVisibility(View.VISIBLE);
                e3.setVisibility(View.VISIBLE);
                e4.setVisibility(View.VISIBLE);
                e5.setVisibility(View.VISIBLE);

                t1.setVisibility(View.VISIBLE);
                t2.setVisibility(View.VISIBLE);
                t3.setVisibility(View.VISIBLE);
                t4.setVisibility(View.VISIBLE);
                t5.setVisibility(View.VISIBLE);

                t17.setVisibility(View.VISIBLE);
                t18.setVisibility(View.VISIBLE);
                t19.setVisibility(View.VISIBLE);
                t20.setVisibility(View.VISIBLE);
                t21.setVisibility(View.VISIBLE);

                t6.setVisibility(View.VISIBLE);
                t7.setVisibility(View.VISIBLE);
                t8.setVisibility(View.VISIBLE);
                t9.setVisibility(View.VISIBLE);
                t10.setVisibility(View.VISIBLE);

                t6.setText(unitna[0]);
                t7.setText(unitna[1]);
                t8.setText(unitna[2]);
                t9.setText(unitna[3]);
                t10.setText(unitna[4]);
                t17.setText(pricea[0]);
                t18.setText(pricea[1]);
                t19.setText(pricea[2]);
                t20.setText(pricea[3]);
                t21.setText(pricea[4]);

                break;

            default:
                e1.setVisibility(View.VISIBLE);
                t1.setVisibility(View.VISIBLE);
                t11.setVisibility(View.VISIBLE);
                t6.setText("0");
                t6.setVisibility(View.VISIBLE);

                break;
        }


      /*  t17.setText(String.valueOf(Double.valueOf(s4) / 2));
        t18.setText(String.valueOf(Integer.valueOf(s4)));
        Double d =Double.valueOf(t18.getText().toString()) * 2.5;
        t19.setText(String.valueOf(d));
        t20.setText(String.valueOf(d * 2));
        t21.setText(String.valueOf(Double.valueOf(t20.getText().toString()) * 2));
*/
        t1.setText(s2);
        t2.setText(s2);
        t3.setText(s2);
        t4.setText(s2);
        t5.setText(s2);



    }

    private void findingIds() {
        t1 = (TextView)findViewById(R.id.textView9);
        t2 = (TextView)findViewById(R.id.textView10);
        t3 = (TextView)findViewById(R.id.textView11);
        t4 = (TextView)findViewById(R.id.textView14);
        t5 = (TextView)findViewById(R.id.textView23);
        t6 = (TextView)findViewById(R.id.textView15);
        t7 = (TextView)findViewById(R.id.textView16);
        t8 = (TextView)findViewById(R.id.textView17);
        t9 = (TextView)findViewById(R.id.textView18);
        t10 = (TextView)findViewById(R.id.textView24);
        t11 = (TextView)findViewById(R.id.textView20);
        t12 = (TextView)findViewById(R.id.textView21);
        t13 = (TextView)findViewById(R.id.textView22);
        t14 = (TextView)findViewById(R.id.textView25);
        t15 = (TextView)findViewById(R.id.textView38);
        t16 = (TextView)findViewById(R.id.textView39);
        t17 = (TextView)findViewById(R.id.textView19);
        t18 = (TextView)findViewById(R.id.textView20);
        t19 = (TextView)findViewById(R.id.textView21);
        t20 = (TextView)findViewById(R.id.textView22);
        t21 = (TextView)findViewById(R.id.textView25);
        tot = (TextView)findViewById(R.id.textView52);
        calculate = (Button)findViewById(R.id.button21);
        addcart = (Button)findViewById(R.id.button22);
        e1 = (EditText)findViewById(R.id.editText15);
        e2 = (EditText)findViewById(R.id.editText16);
        e3 = (EditText)findViewById(R.id.editText17);
        e4 = (EditText)findViewById(R.id.editText18);
        e5 = (EditText)findViewById(R.id.editText19);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:

                Intent in=new Intent(SubProducts.this,CartDetails.class);
                in.putExtra("uid", uid);
                in.putExtra("pi", aa1);
                in.putExtra("pd", aa2);
                startActivity(in);
                return true;
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
    /*public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_cart, menu);
        return true;
    }*/

}