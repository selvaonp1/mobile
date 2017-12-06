package com.location.sunday1.society;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Home1 extends AppCompatActivity {

    Button b1,b2,b3,b4,b5,b6;
    String s1,s2,a,b;
    String s3;
    Button disclaimer,aboutus,contact;
    String url = "http://18.220.229.249:8090/struct.json";
    SQLiteHelper sq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home1);
        Intent in = getIntent();
        s1 = in.getStringExtra("pi");
        s2 = in.getStringExtra("pd");
        s3 = in.getStringExtra("uid");
        sq=new SQLiteHelper(this);



            JsonObjectRequest jsObjRequest = new JsonObjectRequest
                    (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            processResponseJson(response);

                        }
                    }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // TODO Auto-generated method stub
                            System.out.println(error.getCause());
                            error.printStackTrace();

                        }
                    });

            MySingleton.getInstance(getApplicationContext()).addToRequestQueue(jsObjRequest);

        final ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.left);

        b1 = (Button)findViewById(R.id.button6);
        b2 = (Button)findViewById(R.id.button7);

        b4 = (Button)findViewById(R.id.button9);
        b5 = (Button)findViewById(R.id.button10);
        b6 = (Button)findViewById(R.id.button11);
        disclaimer = (Button)findViewById(R.id.button50);
        aboutus = (Button)findViewById(R.id.button51);
        contact = (Button)findViewById(R.id.button52);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Home1.this, Services.class);
                startActivity(in);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent In = new Intent(Home1.this,Products.class);
                In.putExtra("pi",s1);
                In.putExtra("pd",s2);
                In.putExtra("uid",s3);
                startActivity(In);
            }
        });


        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                custpop();
                    //popup();

            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent In = new Intent(Home1.this,VIPContacts.class);
                startActivity(In);
            }
        });


        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Home1.this,Events.class);
                in.putExtra("uid",s3);
                startActivity(in);
            }
        });
        disclaimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Home1.this,Disclaimer.class);
                in.putExtra("uid",s3);
                startActivity(in);
            }
        });
        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Home1.this,Aboutus.class);
                in.putExtra("uid",s3);
                startActivity(in);
            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Home1.this,Contact.class);
                in.putExtra("uid",s3);
                startActivity(in);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MySingleton.getInstance(getApplicationContext()).getRequestQueue().stop();
    }



    private void popup() {
        AlertDialog.Builder builder=new AlertDialog.Builder(Home1.this);
        builder.setMessage("“EmBizz is to list the products/services offered by Embassy Residents. If interested to list your\n" +
                "products/services, please click “Submit here for listing your products/servicec and contacts”\n" +
                "button.");
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent in = new Intent(Home1.this, Queries.class);
                String a = s1;
                String b = s2;
                in.putExtra("username", a);
                in.putExtra("society", b);
                startActivity(in);
            }
        });
    }
    public void custpop(){
        final Dialog dialog = new Dialog(this);

        dialog.setContentView(R.layout.custom_dialog);
        dialog.setTitle("EmBizz Alert !");
        TextView tv=(TextView)dialog.findViewById(R.id.tv1);
        final EditText editText = (EditText) dialog.findViewById(R.id.editText);
        Button btnSave          = (Button) dialog.findViewById(R.id.save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
                Intent in = new Intent(Home1.this, EmBizzNew.class);
                String a = s1;
                String b = s2;
                in.putExtra("uid", s3);
                in.putExtra("username", a);
                in.putExtra("society", b);
                startActivity(in);
            }
        });
        dialog.show();
    }
/*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            case R.id.item1:
                Intent in=new Intent(Home1.this,Disclaimer.class);
                startActivity(in);
                return true;
            case R.id.item2:
                Intent in1=new Intent(Home1.this,Aboutus.class);
                startActivity(in1);
                return true;
            case R.id.item3:
                Intent in2=new Intent(Home1.this,Contact.class);
                startActivity(in2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);
        return true;
    }
    */
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
            Intent intent = new Intent(Home1.this,Login.class);

            startActivity(intent);
            return true;
        }
        return false;
    }

    private void insertIntoProducts(JSONArray products) throws JSONException {

        for (int i = 0, size = products.length(); i < size; i++) {
            JSONObject objectInArray = products.getJSONObject(i);
            //(String category, String product, String subproduct, String unit,String unitname, String price, String image)
            sq.insertProducts( objectInArray.getString("category"),
                    objectInArray.getString("product"),
                    objectInArray.getString("subproduct"),
                    objectInArray.getString("unit"),
                    objectInArray.getString("unitname"),
                    objectInArray.getString("price"),
                    objectInArray.getString("image")
            );
        }
    }

    private void insertIntoServices(JSONArray services) throws JSONException {
        for (int i = 0, size = services.length(); i < size; i++) {
            JSONObject objectInArray = services.getJSONObject(i);
            //(String category, String service, String serviceprovidername, String mobileno,String landline, String address, String image,String rating) {
            sq.insertServices(objectInArray.getString("category"),
                    objectInArray.getString("service"),
                    objectInArray.getString("serviceprovidername"),
                    objectInArray.getString("mobileno"),
                    objectInArray.getString("landline"),
                    objectInArray.getString("address"),
                    objectInArray.getString("image"),
                    objectInArray.getString("rating")
            );
        }
    }

    private void insertIntoRating(JSONArray rating) throws JSONException {
        for (int i = 0, size = rating.length(); i < size; i++) {
            JSONObject objectInArray = rating.getJSONObject(i);
            //(String service,String providername, String mobileno, String landline, String address,String rating )
            sq.insertRating(objectInArray.getString("service"),
                    objectInArray.getString("providername"),
                    objectInArray.getString("mobileno"),
                    objectInArray.getString("landline"),
                    objectInArray.getString("address"),
                    objectInArray.getString("rating")
            );
        }
    }

    private void insertIntoVipcontacts(JSONArray vipContacts) throws JSONException {
        for (int i = 0, size = vipContacts.length(); i < size; i++) {
            JSONObject objectInArray = vipContacts.getJSONObject(i);
            //(String category,String name, String designation, String mobileno, String landline,String emailid,String address)
            sq.insertVipcontacts(objectInArray.getString("category"),
                    objectInArray.getString("name"),
                    objectInArray.getString("designation"),
                    objectInArray.getString("mobileno"),
                    objectInArray.getString("landline"),
                    objectInArray.getString("emailid"),
                    objectInArray.getString("address")
            );
        }
    }

    private void insertIntoEvents(JSONArray events) throws JSONException {
        for (int i = 0, size = events.length(); i < size; i++) {
            JSONObject objectInArray = events.getJSONObject(i);
            sq.insertEvents(objectInArray.getString("event_name"),
                    objectInArray.getString("time")
            );
        }
    }

    private void insertIntoQueries(JSONArray queries) throws JSONException {
        for (int i = 0, size = queries.length(); i < size; i++) {
            JSONObject objectInArray = queries.getJSONObject(i);
            //(String category,String service, String service_provider_name, String mobileno, String landline,String address)
            sq.insertQueries(objectInArray.getString("category"),
                    objectInArray.getString("service"),
                    objectInArray.getString("service_provider_name"),
                    objectInArray.getString("mobileno"),
                    objectInArray.getString("landline"),
                    objectInArray.getString("address")
            );
        }
    }

    private void processResponseJson(JSONObject response) {
        try {
            response = response.getJSONObject("embeasy");
            JSONArray prodArray = response.getJSONArray("products");
            JSONArray servicesArray = response.getJSONArray("services");
            JSONArray ratingArray = response.getJSONArray("rating");
            JSONArray vipContactsArray = response.getJSONArray("vipcontacts");
            JSONArray eventsArray = response.getJSONArray("events");
            JSONArray queriesArray = response.getJSONArray("queries");
            if(response != null && prodArray.length() > 0) {
                sq.clearMasterData();
                insertIntoProducts(prodArray);
                insertIntoServices(servicesArray);
                insertIntoRating(ratingArray);
                insertIntoVipcontacts(vipContactsArray);
                insertIntoEvents(eventsArray);
                insertIntoQueries(queriesArray);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
