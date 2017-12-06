package com.location.sunday1.society;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.regex.Pattern;

public class Login extends AppCompatActivity {

    EditText e1,e2;
    Button b1,b2,b3;

    SQLiteHelper sq;
    SharedPreferences prefs = null;

    String url = "http://my-json-feed";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        prefs = getSharedPreferences("com.mycompany.myAppName", MODE_PRIVATE);
        //MySingleton.getInstance(this).addToRequestQueue(jsObjRequest);

        sq=new SQLiteHelper(this);

        e1 = (EditText)findViewById(R.id.editText11);
        e2 = (EditText)findViewById(R.id.editText12);
        b1 = (Button)findViewById(R.id.button2);



        ////////////////////////////
        try {
            String jsonInput = "{\n" +
                    "   \"embeasy\":{\n" +
                    "      \"products\":[\n" +
                    "         {\n" +
                    "            \"category\":\"food\",\n" +
                    "            \"product\":\"Nuts & Dry Fruits\",\n" +
                    "            \"subproduct\":\"Badam\",\n" +
                    "            \"unit\":\"100\",\n" +
                    "            \"unitname\":\"gm\",\n" +
                    "            \"price\":\"25\",\n" +
                    "            \"image\":\"no\"\n" +
                    "         },\n" +
                    "         {\n" +
                    "            \"category\":\"food\",\n" +
                    "            \"product\":\"Nuts & Dry fruits\",\n" +
                    "            \"subproduct\":\"Badam\",\n" +
                    "            \"unit\":\"250\",\n" +
                    "            \"unitname\":\"gm\",\n" +
                    "            \"price\":\"35\",\n" +
                    "            \"image\":\"no\"\n" +
                    "         }\n" +
                    "      ],\n" +
                    "      \"services\":[\n" +
                    "         {\n" +
                    "            \"category\":\"automobiles\",\n" +
                    "            \"service\":\"bikeservice\",\n" +
                    "            \"serviceprovidername\":\"AB bike Zone\",\n" +
                    "            \"mobileno\":\"9677086686\",\n" +
                    "            \"landline\":\"null\",\n" +
                    "            \"address\":\"no\",\n" +
                    "            \"image\":\"no\",\n" +
                    "            \"rating\":\"4\"\n" +
                    "         },\n" +
                    "         {\n" +
                    "            \"category\":\"Electronic Fixes\",\n" +
                    "            \"service\":\"AC mechanic\",\n" +
                    "            \"serviceprovidername\":\"BB AC Zone\",\n" +
                    "            \"mobileno\":\"9677086686\",\n" +
                    "            \"landline\":\"null\",\n" +
                    "            \"address\":\"no\",\n" +
                    "            \"image\":\"no\",\n" +
                    "            \"rating\":\"1\"\n" +
                    "         }\n" +
                    "      ],\n" +
                    "      \"rating\":[\n" +
                    "         {\n" +
                    "            \"service\":\"AC mechanic\",\n" +
                    "            \"providername\":\"BB AC Zone\",\n" +
                    "            \"mobileno\":\"9677086686\",\n" +
                    "            \"landline\":\"null\",\n" +
                    "            \"address\":\"no\",\n" +
                    "            \"rating\":\"4\"\n" +
                    "         },\n" +
                    "         {\n" +
                    "            \"service\":\"automobiles\",\n" +
                    "            \"providername\":\"AB bike Zone\",\n" +
                    "            \"mobileno\":\"9677086686\",\n" +
                    "            \"landline\":\"null\",\n" +
                    "            \"address\":\"no\",\n" +
                    "            \"rating\":\"1\"\n" +
                    "         }\n" +
                    "      ],\n" +
                    "      \"vipcontacts\":[\n" +
                    "         {\n" +
                    "            \"category\":\"Maintainance office\",\n" +
                    "            \"name\":\"Francis\",\n" +
                    "            \"designation\":\"Property Manager\",\n" +
                    "            \"mobileno\":\"9677086686\",\n" +
                    "            \"landline\":\"null\",\n" +
                    "            \"emailid\":\"no\",\n" +
                    "            \"address\":\"no\"\n" +
                    "         },\n" +
                    "         {\n" +
                    "            \"category\":\"Maintainance office2\",\n" +
                    "            \"name\":\"Francis2\",\n" +
                    "            \"designation\":\"Property Manager2\",\n" +
                    "            \"mobileno\":\"9677086686\",\n" +
                    "            \"landline\":\"null\",\n" +
                    "            \"emailid\":\"no\",\n" +
                    "            \"address\":\"no\"\n" +
                    "         }\n" +
                    "      ],\n" +
                    "      \"events\":[\n" +
                    "         {\n" +
                    "            \"event_name\":\"pongal\",\n" +
                    "            \"time\":\"upcoming\"\n" +
                    "         },\n" +
                    "         {\n" +
                    "            \"event_name\":\"Diwali\",\n" +
                    "            \"time\":\"upcoming\"\n" +
                    "         }\n" +
                    "      ],\n" +
                    "      \"queries\":[\n" +
                    "         {\n" +
                    "            \"category\":\"Lifestyle\",\n" +
                    "            \"service\":\"Nuts & Dry Fruits\",\n" +
                    "            \"service_provider_name\":\"Badam\",\n" +
                    "            \"mobileno\":\"9677086686\",\n" +
                    "            \"landline\":\"null\",\n" +
                    "            \"address\":\"no\"\n" +
                    "         },\n" +
                    "         {\n" +
                    "            \"category\":\"Lifestyle\",\n" +
                    "            \"service\":\"Nuts & Dry Fruits\",\n" +
                    "            \"service_provider_name\":\"Badam\",\n" +
                    "            \"mobileno\":\"9677086686\",\n" +
                    "            \"landline\":\"null\",\n" +
                    "            \"address\":\"no\"\n" +
                    "         }\n" +
                    "      ]\n" +
                    "   }\n" +
                    "} ";

            processResponseJson(new JSONObject(jsonInput));

        } catch(Exception e) {
            e.printStackTrace();
        }
        ////////////////////////////////

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String s = e1.getText().toString();


                String s1= e1.getText().toString();
                String s2= e2.getText().toString();

                if(s1.equalsIgnoreCase("Admin")&& s2.equalsIgnoreCase("Admin"))
                {
                    Toast.makeText(Login.this, "Hello Admin", Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(Login.this, AdminHomePage.class);
                    startActivity(in);
                }
                else {

                    if (!isValidPhoneNumber(s)) {
                        e1.setError("please enter valid mobile no");
                    }
                    String result = sq.Login(s1,s2);
                    if (result.equalsIgnoreCase("ok")) {
                        Toast.makeText(Login.this, "Successfully logged in", Toast.LENGTH_SHORT).show();
                        String uid=sq.getUserId(s1,s2);

                        Intent in = new Intent(Login.this, Home.class);
                        String a = s1;
                        in.putExtra("userid", a);
                        in.putExtra("uid",uid);
                        startActivity(in);
                    } else {
                        Toast.makeText(Login.this, "ID and Password miss matched", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        b2 = (Button)findViewById(R.id.button3);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Login.this,Register.class);
                startActivity(in);
            }
        });
        b3 = (Button)findViewById(R.id.button4);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Login.this,ForgetPassword.class);
                startActivity(in);
            }
        });

    }


    public static final boolean isValidPhoneNumber(CharSequence target) {
        if (target.length()!=10) {
            return false;
        } else {
            return android.util.Patterns.PHONE.matcher(target).matches();
        }
    }



    @Override
    protected void onResume() {
        super.onResume();

        if (prefs.getBoolean("firstrun", true)) {
            insertdata();
            prefs.edit().putBoolean("firstrun", false).commit();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            return true;
        }
        return false;
    }

    public void insertdata()
    {
        /*
        sq.items("fridge","Electronic_fixes");
        sq.items("Washing machine","Electronic_fixes");
        sq.items("TV","Electronic_fixes");
        sq.items("AC","Electronic_fixes");
        sq.items("Chimney","Electronic_fixes");
        sq.items("Water purifier","Electronic_fixes");
        sq.items("Laptop","Electronic_fixes");

        sq.items("carpender","Household_fixes");
        sq.items("plumber","Household_fixes");
        sq.items("electrician","Household_fixes");
        sq.items("painter","Household_fixes");
        sq.items("balcony grill","Household_fixes");
        sq.items("balcony cloth dryer","Household_fixes");
        sq.items("BSNL","Household_fixes");
        sq.items("ACT","Household_fixes");
        sq.items("Airtel DTH","Household_fixes");
        sq.items("Tata sky","Household_fixes");

        sq.items("Maid","Household_needs");
        sq.items("Cook","Household_needs");
        sq.items("Bathroom cleaner","Household_needs");
        sq.items("water cane","Household_needs");
        sq.items("Newspaper","Household_needs");
        sq.items("Milk","Household_needs");
        sq.items("old paper buyer","Household_needs");
        sq.items("Medicine","Household_needs");
        sq.items("laundry","Household_needs");
        sq.items("medical help","Household_needs");

        sq.items("car cleaner","Automobiles");
        sq.items("puncture","Automobiles");
        sq.items("car mechanic","Automobiles");
        sq.items("bike mechanic","Automobiles");
        sq.items("cycle repair","Automobiles");
        sq.items("tredmill repair","Automobiles");
        sq.items("car driver","Automobiles");



        sq.items("breakfast","food");
        sq.items("Lunch","food");
        sq.items("Dinner","food");
        sq.items("Briyani","food");
        sq.items("Nuts & Dry fruit","food");
        sq.items("Organic Veg & fruits","food");
        sq.items("Oils","food");
        sq.items("Groceries","food");
        sq.items("Snacks","food");
        sq.items("Milk","food");

        sq.items("school items","stationary");
        sq.items("gift items","stationary");
        sq.items("birthday items","stationary");

        sq.items("yoga","lifestyle");
        sq.items("zumba","lifestyle");
        sq.items("fitness","lifestyle");

        sq.items("keyboard","courses");
        sq.items("singing","courses");
        sq.items("classical dance","courses");
        sq.items("karate","courses");
        sq.items("school tution","courses");
        sq.items("maths tution","courses");
        sq.items("tamil tution","courses");
        sq.items("hindi tution","courses");



        sq.items("durga pooja","This_month");
        sq.items("dandiyaa","This_month");

        sq.items("diwali","Upcoming");
        sq.items("christmas","Upcoming");

        sq.items("Onam","Previous");
        sq.items("AGM","Previous");
        sq.items("Election","Previous");
        sq.items("Vinayakar pooja","Previous");
        sq.items("Radio Mirchi","Previous");
        sq.items("Apparels","Previous");

        sq.items("idly","breakfast");
        sq.items("vadai","breakfast");
        sq.items("dosai","breakfast");
        sq.items("poori","breakfast");
        sq.items("chappathi","breakfast");
        sq.items("pongal","breakfast");

        sq.items("veg meals","lunch");
        sq.items("non-veg meals","lunch");
        sq.items("variety rice","lunch");

        sq.items("idly","dinner");
        sq.items("dosai","dinner");
        sq.items("idiyappam","dinner");
        sq.items("chappathi","dinner");
        sq.items("parotta","dinner");
        sq.items("poori","dinner");

        sq.items("chicken briyani","briyani");
        sq.items("button briyani","briyani");
        sq.items("prawn briyani","briyani");
        sq.items("fish briyani","briyani");
        sq.items("veg briyani","briyani");
        sq.items("egg briyani","briyani");

        sq.items("cashew nut","nuts and dryfruit");
        sq.items("almond nut","nuts and dryfruit");
        sq.items("pista nut","nuts and dryfruit");
        sq.items("walnut","nuts and dryfruit");

        sq.items("apple","organic veg and fruits");
        sq.items("peaches","organic veg and fruits");
        sq.items("nectarines","organic veg and fruits");
        sq.items("strawberries","organic veg and fruits");
        sq.items("grapes","organic veg and fruits");
        sq.items("spinach","organic veg and fruits");
        sq.items("tomato","organic veg and fruits");
        sq.items("onion","organic veg and fruits");
        sq.items("celery","organic veg and fruits");
        sq.items("pea","organic veg and fruits");
        sq.items("bell pepper","organic veg and fruits");
        sq.items("maize","organic veg and fruits");
        sq.items("cucumber","organic veg and fruits");

        sq.items("sunflower oil","oils");
        sq.items("coconut oil","oils");
        sq.items("soybean oil","oils");
        sq.items("olive oil","oils");
        sq.items("safflower oil","oils");
        sq.items("sesame oil","oils");
        sq.items("avacado oil","oils");

        sq.items("wheat","groceries");
        sq.items("bread","groceries");
        sq.items("brown rice","groceries");
        sq.items("grains","groceries");
        sq.items("egg","groceries");

        sq.items("cookies","snacks");
        sq.items("chips","snacks");
        sq.items("samosa","snacks");
        sq.items("chat items","snacks");
        sq.items("beverage","snacks");

        sq.items("butter","milks");
        sq.items("ghee","milks");
        sq.items("cheese","milks");
        sq.items("whey","milks");

        sq.items("books","school items");
        sq.items("pencil","school items");
        sq.items("pen","school items");
        sq.items("sketch","school items");
        sq.items("paint","school items");
        sq.items("chart","school items");
        sq.items("note items","school items");
        sq.items("geomentry box","school items");
        sq.items("erasor and sharpner","school items");

        sq.items("bouquet","gift items");
        sq.items("toy items","gift items");
        sq.items("glass statues","gift items");
        sq.items("gift cards","gift items");
        sq.items("flowers","gift items");

        sq.items("cake","birthday items");
        sq.items("candles","birthday items");
        sq.items("color papers","birthday items");
        sq.items("snow spray","birthday items");
        sq.items("papar blast","birthday items");

        sq.items("chakrasana","yoga");
        sq.items("bhujagasana","yoga");
        sq.items("vajrasana","yoga");
        sq.items("badmasana","yoga");

        sq.items("cumbia","zumba");
        sq.items("salsa","zumba");
        sq.items("merengue","zumba");
        sq.items("mambo","zumba");
        sq.items("flamenco","zumba");
        sq.items("chachacha","zumba");
        sq.items("reggeton","zumba");
        sq.items("hiphop","zumba");

        sq.items("aurobic","fitness");
        sq.items("anarobic","fitness");
        sq.items("joint flexibility","fitness");
        sq.items("muscular endurance","fitness");

        sq.items("electronic","keyboard");
        sq.items("isomorphic","keyboard");
        sq.items("enhamonic","keyboard");
        sq.items("keytar","keyboard");

        sq.items("carnatic","singing");
        sq.items("hindustani","singing");
        sq.items("ghazhals","singing");
        sq.items("film musics","singing");
        sq.items("western","singing");


        sq.items("baratham","classical dance");
        sq.items("kathak","classical dance");
        sq.items("kuchipudi","classical dance");
        sq.items("kathakali","classical dance");
        sq.items("odissi","classical dance");
        sq.items("mohiniyattam","classical dance");
        sq.items("manipuri","classical dance");

        sq.items("Shotokan","karate");
        sq.items("Goju","karate");
        sq.items("Wado","karate");
        sq.items("Shorin","karate");
        sq.items("Uechi","karate");

        sq.items("tamil","school tution");
        sq.items("english","school tution");
        sq.items("maths","school tution");

        sq.items("moohambigai institution","maths tution");
        sq.items("VRR institution","maths tution");
        sq.items("anugraham institution","maths tution");

        sq.items("senthooram","tamil tution");
        sq.items("viruksham","tamil tution");
        sq.items("tamil mozhi koodam","tamil tution");
        sq.items("kamakshi","tamil tution");

        sq.items("Property Manager","Maintainance Office");
        sq.items("Ast Property Manager","Maintainance Office");
        sq.items("Receptionist 1","Maintainance Office");
        sq.items("Receptionist 2","Maintainance Office");
        sq.items("Electrician","Maintainance Office");
        sq.items("Plumber","Maintainance Office");
        sq.items("Carpenter","Maintainance Office");

        sq.items("President","Association Members");
        sq.items("Vice President","Association Members");
        sq.items("Secretary","Association Members");
        sq.items("Joint Secretary","Association Members");
        sq.items("Treasurer","Association Members");
        sq.items("EC Member","Association Members");
        sq.items("Block Rep 1","Association Members");
        sq.items("Block Rep 2","Association Members");
        sq.items("Block Rep 3","Association Members");
        sq.items("Block Rep 4","Association Members");
        sq.items("Block Rep 5","Association Members");
        sq.items("Block Rep 6","Association Members");
        sq.items("Block Rep 7","Association Members");
        sq.items("Block Rep 8","Association Members");
        sq.items("Block Rep 9","Association Members");
        sq.items("Block Rep 10","Association Members");
        sq.items("Block Rep 11","Association Members");
        sq.items("Block Rep 12","Association Members");
        sq.items("Block Rep 13","Association Members");
        sq.items("Block Rep 14","Association Members");
        sq.items("Block Rep 15","Association Members");
        sq.items("Block Rep 16","Association Members");
        sq.items("Block Rep 17","Association Members");
        sq.items("Block Rep 18","Association Members");
        sq.items("Block Rep 19","Association Members");


        sq.items("Sales office","Builder");
        sq.items("CRM office","Builder");
        sq.items("Main office","Builder");

        sq.items("Medical","Emergencies");
        sq.items("Fire","Emergencies");
        sq.items("Police","Emergencies");
        sq.items("Forest","Emergencies");
        sq.items("Human right","Emergencies");
        sq.items("Bluecross","Emergencies");
        sq.items("Redcross","Emergencies");
        sq.items("Panchayat","Emergencies");
        sq.items("Collector","Emergencies");
        sq.items("Sub-collector","Emergencies");
        sq.items("Disaster Management","Emergencies");





        sq.insertProducts("food","Nuts & Dry Fruits","Badam","100", "gm","25","no");
        sq.insertProducts("food","Nuts & Dry Fruits","Badam","250","gm","35","no");
        sq.insertProducts("food","Nuts & Dry Fruits","Badam","500","gm","55","no");
        sq.insertProducts("food","Nuts & Dry Fruits","Badam","1","kg","110","no");
        sq.insertProducts("food","Nuts & Dry Fruits","cashew","100","gm","35","no");
        sq.insertProducts("food","Nuts & Dry Fruits","cashew","250","gm","55","no");
        sq.insertProducts("food","Nuts & Dry Fruits","cashew","500","gm","75","no");
        sq.insertProducts("food","Nuts & Dry Fruits","cashew","1","kg","95","no");
        sq.insertProducts("food","Nuts & Dry Fruits","Walnuts","100","gm","45","no");
        sq.insertProducts("food","Nuts & Dry Fruits","Pista","100","gm","55","no");
        sq.insertProducts("food","Nuts & Dry Fruits","Pista","250","gm","65","no");
        sq.insertProducts("food","Nuts & Dry Fruits","Pista","500","gm","85","no");
        sq.insertProducts("food","Nuts & Dry Fruits","Pista","1","kg","95","no");
        sq.insertProducts("food","Nuts & Dry Fruits","Kishmish Brown","100","gm","30","no");
        sq.insertProducts("food","Nuts & Dry Fruits","Kishmish Brown","250","gm","60","no");
        sq.insertProducts("food","Nuts & Dry Fruits","Kishmish Brown","500","gm","90","no");
        sq.insertProducts("food","Nuts & Dry Fruits","Kishmish Brown","1","kg","120","no");
        sq.insertProducts("food","Nuts & Dry Fruits","Kishmish Black","100","gm","75","no");
        sq.insertProducts("food","Nuts & Dry Fruits","Kishmish Black","250","gm","95","no");
        sq.insertProducts("food","Nuts & Dry Fruits","Kishmish Black","500","gm","135","no");
        sq.insertProducts("food","Nuts & Dry Fruits","Kishmish Black","1","kg","175","no");
        sq.insertProducts("food","Nuts & Dry Fruits","Kimia Dates","1","box","45","no");
        sq.insertProducts("food","Oil","Coconut Organic","1","lit","50","no");
        sq.insertProducts("food","Oil","Coconut Organic","500","ml","50","no");
        sq.insertProducts("food","Oil","Ground nut","1","lit","70","no");
        sq.insertProducts("food","Oil","Ground nut","500","ml","70","no");
        sq.insertProducts("food","Oil","Gingelly","500","ml","80","no");
        sq.insertProducts("food","Oil","Gingelly","1","lit","280","no");
        sq.insertProducts("food","Oil","Cane sugar Organic","1","kg","60","no");
        sq.insertProducts("food","Rice","Boiled Rice","500","ml","60","no");
        sq.insertProducts("food","Rice","Raw Rice","1","kg","60","no");
        sq.insertProducts("food","Rice","Idly Rice","1","kg","60","no");
        sq.insertProducts("food","Rice","Basmati Rice","1","kg","60","no");
        sq.insertProducts("food","Dhal","Toor Dhal","1","kg","60","no");
        sq.insertProducts("food", "Dhal", "Bengal Gram", "1", "kg", "60", "no");
        sq.insertProducts("food", "Dhal", "Uried Dhal Full", "1", "kg", "60", "no");
        sq.insertProducts("food", "Dhal", "Uried Dhal broken", "1", "kg", "60", "no");
        sq.insertProducts("food", "Dhal", "Green Gram Full", "1", "kg", "60", "no");
        sq.insertProducts("food", "Dhal", "Green Gram Broken", "1", "kg", "60", "no");
        sq.insertProducts("food", "Dhal", "Fried Gram", "1", "kg", "60", "no");

        sq.insertServices("automobiles", "bikeservice", "AB bike Zone", "9677086686", "null", "no", "no", "3");
        sq.insertServices("automobiles", "Cycle service", "Muthu ", "9445264947", "null", "no", "no", "4");
        sq.insertServices("automobiles", "Driving school", "OMR driving", "9444257999", "null", "no", "no", "2");
        sq.insertServices("automobiles", "Four wheeler", "Car Puncture", "9382608634", "null", "no", "no", "3");
        sq.insertServices("automobiles", "Water service", "Murugan agency", "9841567893", "9841532868", "no", "no", "4");
        sq.insertServices("automobiles", "Water service", "Janarthan ", "8428571547", "null", "no", "no", "1");
        sq.insertServices("automobiles", "Car Cleaning", "Velu  ", "9094809403", "null", "no", "no", "4");
        sq.insertServices("automobiles", "Car Cleaning", "Sudhakaran  ", "7200211212", "null", "no", "no", "5");
        sq.insertServices("automobiles", "Car Cleaning", "Prabhu ", "9551724238", "null", "no", "no", "3");
        sq.insertServices("automobiles", "Bicycle service ", "Sirfudeen", "9940223123", "null", "no", "no", "2");
        sq.insertServices("automobiles", "Puncture service ", "Naga", "919382608634/919500138637", "null", "no", "no", "1");


        sq.insertServices("Electronic Fixes", "AC mechanic", "Ac Ranjith", "9566101218", "null", "no", "no", "1");
        sq.insertServices("Electronic Fixes", "AC mechanic", "Manohar", "9884012465", "null", "no", "no", "3");
        sq.insertServices("Electronic Fixes", "AC mechanic", "Subramani", "9841333995", "null", "no", "no", "4");
        sq.insertServices("Electronic Fixes", "AC mechanic", "Prem", "9962771499", "null", "no", "no", "5");
        sq.insertServices("Electronic Fixes", "Aquaguard", "Murali", "9042376671", "null", "no", "no","3");
        sq.insertServices("Electronic Fixes", "Chimmey Cleaning", "Chimmey Cleaning Vijay", "8344037865", "null", "no", "no","1");
        sq.insertServices("Electronic Fixes", "Chimmey Cleaning", "Sudhakaran", "8608644785", "null", "no", "no","3");
        sq.insertServices("Electronic Fixes", "Chimmey Cleaning", "Faber Subash", "9677212725", "null", "no", "no","4");
        sq.insertServices("Electronic Fixes", "Electrician", "suberasen", "8682925034", "null", "no","no","5");
        sq.insertServices("Electronic Fixes", "Electrician", "Pankajam eletricals", "9841397757", "null", "no","no","2");
        sq.insertServices("Electronic Fixes", "Electrician", "Pankajam eletricals", "7299444799", "null", "no","no","1");
        sq.insertServices("Electronic Fixes", "Gas Refill", "Gas refill", "8124024365", "null", "no","no","3");
        sq.insertServices("Electronic Fixes", "IFB Washing machine", "RAJA IFB", "9940530470", "7010064966", "no","no","4");
        sq.insertServices("Electronic Fixes", "Washingmachine", "Mohammed", "9840354386", "null", "no","no","5");
        sq.insertServices("Electronic Fixes", "Washingmachine", "suresh LG", "8608743379", "null", "no","no","2");
        sq.insertServices("Electronic Fixes", "Electrician", "Urbistant", "9025352535", "null", "no","no","1");
        sq.insertServices("Electronic Fixes", "Electrician", "Udhayakumar", "9677007649", "null", "no","no","3");
        sq.insertServices("Electronic Fixes", "AC service", "Urbistant", "9025352535", "null", "no","no","4");
        sq.insertServices("Electronic Fixes", "AC mechanic", "Raghu", "9944993958", "null", "no","no","5");
        sq.insertServices("Electronic Fixes", "Electrician for Personal Work", "Bhaskar", "9884008061", "null", "no","no","2");
        sq.insertServices("Electronic Fixes", "Desktop/ Laptop service", "Sathyanarayananan ", "9841259395", "null", "no","no","3");

        sq.insertServices("Hosuehold needs", "Aavin Milk", "Pugal", "9282225555", "null", "no","no","4");
        sq.insertServices("Hosuehold needs", "AYER", "Ganesh", "9840239043", "null", "no","no","2");
        sq.insertServices("Hosuehold needs", "Beautician", "Sudha", "8122392565", "null", "no","no","3");
        sq.insertServices("Hosuehold needs", "Catering", "Radhakrishnan Prk", "9962968950", "null", "no","no","4");
        sq.insertServices("Hosuehold needs", "Catering", "Ambi", "9841117482", "22422707", "no","no","4");
        sq.insertServices("Hosuehold needs", "cleaning person", "Ram", "9841723693", "null", "no","no","2");
        sq.insertServices("Hosuehold needs", "cleaning person", "Tamil", "8056240831", "null", "no","no","2");
        sq.insertServices("Hosuehold needs", "Cloth Hang", "Cloth Hanger Siva", "9840076404", "null", "no","no","1");
        sq.insertServices("Hosuehold needs", "Courier", "Francess Express", "9710891089", "null", "no","no","4");
        sq.insertServices("Hosuehold needs", "Courier", "St Courier Collection", "8528722293", "null", "no","no","5");
        sq.insertServices("Hosuehold needs", "Courier", "DTDC Ebenzer Perumbakkam", "9884155690", "null", "no","no","5");
        sq.insertServices("Hosuehold needs", "Fancy dress", "Sripathy", "9176786345", "null", "no","no","4");
        sq.insertServices("Hosuehold needs", "GAS Agency", "Ganapathyvel Gas Agency", "4442050958", "4443086555", "no","no","3");
        sq.insertServices("Hosuehold needs", "GAS Agency", "Revathy Agency", "4422771802", "4422771800", "no","no","4");
        sq.insertServices("Hosuehold needs", "GAS Agency", "KCVEE HP gas", "null", "27479339", "no","no","3");
        sq.insertServices("Hosuehold needs", "Laundry", "Iron Man Krishnan", "8807632963", "null", "no","no","2");
        sq.insertServices("Hosuehold needs", "Laundry", "Darista wash &dry", "9003443751", "null", "no","no","2");
        sq.insertServices("Hosuehold needs", "Milk", "Arjun", "7358003132", "null", "no","no","1");
        sq.insertServices("Hosuehold needs", "Newspaper agent", "Dhandapani", "9940328411", "null", "no","no","4");
        sq.insertServices("Hosuehold needs", "Old Paper", "Arun Old ppr", "8883959679", "null", "no","no","5");
        sq.insertServices("Hosuehold needs", "Packers", "Ranson writers", "9619487238", "null", "no","no","3");
        sq.insertServices("Hosuehold needs", "Priest", "poojari", "9841125344", "null", "no","no","2");
        sq.insertServices("Hosuehold needs", "Seafood delivery", "Supreme saefood", "null", "66442222", "no","no","2");
        sq.insertServices("Hosuehold needs", "Tamil magazine", "Tamilselvan", "9840975440", "null", "no","no","1");
        sq.insertServices("Hosuehold needs", "toilet cleaning", "Bala Toilet Cleaning", "9042140599", "null", "no","no","1");

        sq.insertServices("Hotel", "Hotel ", "Sakuntala", "9841458766", "null", "no","no","3");
        sq.insertServices("Hotel", "Hotel ", "Hot Breads", "8939332218", "null", "no","no","4");
        sq.insertServices("Hotel", "Subway Delivery", "Subway Home Delivery", "4424501161", "null", "no","no","5");

        sq.insertServices("House Warming", "Catering", "Arun", "9444450112", "null", "no","no","4");
        sq.insertServices("House Warming", "Iyer & Pooja Things", "Nagendra Prasad ", "9884275216", "null", "no","no","2");
        sq.insertServices("House Warming", "Shamiyana", "Venkatesan", "9445154607", "null", "no","no","2");
        sq.insertServices("House Warming", "Shamiyana", "Krishna", "9841444018", "null", "no","no","1");
        sq.insertServices("House Warming", "Water Can", "Karthik", "9176742464", "null", "no","no","2");
        sq.insertServices("House Warming", "Electrition", "Udayakumar", "9677007649", "null", "no","no","3");
        sq.insertServices("House Warming", "Cow", "Anand", "9840787877", "null", "no","no","4");

        sq.insertServices("Household fixes", "ACT", "Dhanasekar", "7358019317", "null", "no","no","5");
        sq.insertServices("Household fixes", "ACT", "ACT Guhan", "9940462260", "null", "no","no","5");
        sq.insertServices("Household fixes", "BSNL", "Customer care", "18003451500", "null", "no","no","4");
        sq.insertServices("Household fixes", "BSNL", "Bilal", "8903070701", "null", "no","no","3");
        sq.insertServices("Household fixes", "DTH", "Prasad", "9444018562", "null", "no","no","3");
        sq.insertServices("Household fixes", "Carpenter", "kantha rao", "9500096993", "null", "no","no","3");
        sq.insertServices("Household fixes", "Gas Mechani", "Guruswamy Gas Mechanic", "7299999112", "null", "no","no","3");
        sq.insertServices("Household fixes", "Interiors", "Robin", "9884102162", "null", "no","no","3");
        sq.insertServices("Household fixes", "Interiors", "Ramamurthi", "9444351179", "null", "no","no","3");
        sq.insertServices("Household fixes", "Jaguar pipe", "Customer care", "18001216808", "null", "no","no","2");
        sq.insertServices("Household fixes", "Pest control", "Ramesh", "9941937308", "null", "no","no","4");
        sq.insertServices("Household fixes", "Window sliding", "Ramkrish", "9865709292", "null", "no","no","4");
        sq.insertServices("Household fixes", "Wall drilling work", "Urbistant", "9025352535", "null", "no","no","2");
        sq.insertServices("Household fixes", "AC Core Cutter", "Suresh", "9841121800", "null", "no","no","2");
        sq.insertServices("Household fixes", "Akash Ganga", "Rajendran", "9500122968/ 044-64611422", "null", "no","no","4");
        sq.insertServices("Household fixes", "Fridge, Washing machine, Microwave oven, Water geyser repair", "Urbistant", "9025352535", "null", "no","no","3");
        sq.insertServices("Household fixes", "Godrej Lock Toll Free #", "Toll Free", "18002094543 /044-24996879", "null", "no","no","5");
        sq.insertServices("Household fixes", "Jaguar Taps Toll Free #", "Toll Free", "18001216808", "null", "no","no","5");
        sq.insertServices("Household fixes", "Lock fixing", "Urbistant", "9025352535", "null", "no","no","5");
        sq.insertServices("Household fixes", "Carpenter", "Urbistant", "9025352535", "null", "no","no","3");
        sq.insertServices("Household fixes", "Carpenter (custom make) / Interiors", "Manikandan", "7092552162", "null", "no","no","4");
        sq.insertServices("Household fixes", "Carpenter for Personal Work", "Kantharao", "9500096993", "null", "no","no","3");
        sq.insertServices("Household fixes", "Carpenter for Personal Work", "Malaiappan", "9444325720", "null", "no","no","4");

        sq.insertServices("Medical", "Clinic physician", "Janya", "9710919253", "null", "no","no","5");
        sq.insertServices("Medical", "Dentist", "Dr.Suresh", "8438399660", "null", "no","no","5");
        sq.insertServices("Medical", "Diagonstic centre", "Venkateswara center", "9941003985", "null", "no","no","5");
        sq.insertServices("Medical", "Hospital", "Suraj", "null", "null", "no","no","4");
        sq.insertServices("Medical", "Leela Eye Clinic", "Dr.Parthasarathy", "9941317019", "null", "no","no","2");
        sq.insertServices("Medical", "Medical store", "Super medicalss", "7871051166", "null", "no","no","3");
        sq.insertServices("Medical", "Medical store", "Green pharmacy", "9789700014", "null", "no","no","2");
        sq.insertServices("Medical", "Medical store", "Muthu", "null", "null", "no","no","2");
        sq.insertServices("Medical", "Nilavembu", "Jini", "9003023298", "null", "no","no","2");
        sq.insertServices("Medical", "Peadric", "Dr chitra raman", "9489136501", "null", "no","no","4");
        sq.insertServices("Medical", "Peadric dr", "DR Prabhakar", "9443639218", "null", "no","no","2");
        sq.insertServices("Medical", "Vcure hospital", "Dr Ganesh", "9841086625", "null", "no","no","1");
        sq.insertServices("Medical", "Walking stick", "Mediaid surgicals", "9158444110", "null", "no","no","4");
        sq.insertServices("Medical", "Global Hospital", "91 44 2424 2424", "null", "null", "no","no","4");
        sq.insertServices("Medical", "Apollo Hospital", "1066 91 44-2829 0792", "null", "null", "no","no","5");
        sq.insertServices("Medical", "Blood Bank", "91 44-2829 4870", "null", "null", "no","no","5");
        sq.insertServices("Medical", "Apollo Medical Centre, Karapakkam, OMR", "91-44-2450 5700  91-44-3070 7777", "null", "null", "no","no","3");
        sq.insertServices("Medical", "Apollo Speciality Hospital, Perungudi, OMR", "91-44-3322 1111   91-44-2496 1111  ", "null", "null", "no","no","3");
        sq.insertServices("Medical", "Doctor", "Dr. Nithya", "9994201095", "null", "no","no","2");
        sq.insertServices("Medical", "Doctor", "Dr.Meena Raj", "8807273901/9840722019", "null", "no","no","2");
        sq.insertServices("Medical", "Doctor", "Dr. Jini", "9003023298", "null", "no","no","2");
        sq.insertServices("Medical", "Doctor", "Dr. Jagadeeswaran", "9962011364", "null", "no","no","2");
        sq.insertServices("Medical", "Doctor", "Dr. Prabhakaran", "91 94 43 639218", "null", "no","no","2");
        sq.insertServices("Medical", "Doctor", "Dr Debjani", "9840205145", "null", "no","no","4");
        sq.insertServices("Medical", "Doctor", "Dr.Chitra", "9489136501", "null", "no","no","4");
        sq.insertServices("Medical", "Hospital", "Suraj hospital", "044-65186134", "null", "no","no","5");

        sq.insertServices("Sports", "Skating", "Challengers acadamy", "9976513132", "null", "no","no","3");
        sq.insertServices("Sports", "Skating", "Challengers acadamy", "9551362132", "null", "no", "no", "3");


        sq.insertServices("Transport", "Auto stand", "Global hospital New", "7358094544", "null", "no", "no", "5");
        sq.insertServices("Transport", "Call driver", "Sudhakar", "9791127789", "null", "no", "no", "3");
        sq.insertServices("Transport", "Call driver", "Alla", "9884136992", "null", "no", "no", "4");
        sq.insertServices("Transport", "Call driver", "Arun", "9710707659", "null", "no", "no", "2");

        sq.insertRating("Clinic physician", "Janya", "04365", "04364", "chennai", "2");
        sq.insertRating("Clinic physician", "Janya", "04365", "04364", "chennai", "5");
        sq.insertRating("Clinic physician", "Janya", "04365", "04364", "chennai", "3");
        sq.insertRating("AC mechanic", "Ac Ranjith", "9566101218", "04364", "chennai", "3");
        sq.insertRating("AC mechanic", "Ac Ranjith", "9566101218", "04364", "chennai", "5");
        sq.insertRating("AC mechanic", "Ac Ranjith", "9566101218", "04364", "chennai", "1");

        sq.insertVipcontacts("Maintainance office", "Francis", "Property Manager", "null", "null", "no", "no");
        sq.insertVipcontacts("Maintainance office", "Raja", "Ast Property Manager", "null", "null", "no", "no");
        sq.insertVipcontacts("Maintainance office", "Gajalakshmi", "Helpdesk", "null", "null", "no", "gajalakshmi.s-ext@embassyservices.in");
        sq.insertVipcontacts("Maintainance office", "null", "Property office", "null", "044-28381699", "no", "gajalakshmi.s-ext@embassyservices.in");


        sq.insertVipcontacts("Builder", "null", "Sales office", "null", "null", "no", "no");
        sq.insertVipcontacts("Builder", "null", "CRM office", "null", "null", "no", "no");
        sq.insertVipcontacts("Builder", "null", "Main office", "null", "null", "no", "no");

        sq.insertVipcontacts("Emergencies", "Any time blood", "Blood donation", "9843193014", "null", "no", "no");
        sq.insertVipcontacts("Emergencies", "Wilson", "Orphanage", "8754499555", "null", "no", "no");
        sq.insertVipcontacts("Emergencies", "null", "Medical", "null", "null", "no", "no");


        sq.insertVipcontacts("Office Bearers", "null", "President", "null", "null", "no", "no");
        sq.insertVipcontacts("Office Bearers", "null", "Vice President", "null", "null", "no", "no");
        sq.insertVipcontacts("Office Bearers", "null", "Secretary", "null", "null", "no", "no");
        sq.insertVipcontacts("Office Bearers", "null", "Joint Secretary", "null", "null", "no", "no");
        sq.insertVipcontacts("Office Bearers", "null", "Treasurer", "null", "null", "no", "no");
        sq.insertVipcontacts("Office Bearers", "null", "EC Member", "null", "null", "no", "no");



        sq.insertVipcontacts("Executive Committee", "null", "Block Rep 1", "null", "null", "no", "no");
        sq.insertVipcontacts("Executive Committee", "null", "Block Rep 2", "null", "null", "no", "no");
        sq.insertVipcontacts("Executive Committee", "null", "Block Rep 3", "null", "null", "no", "no");
        sq.insertVipcontacts("Executive Committee", "null", "Block Rep 4", "null", "null", "no", "no");
        sq.insertVipcontacts("Executive Committee", "null", "Block Rep 5", "null", "null", "no", "no");
        sq.insertVipcontacts("Executive Committee", "null", "Block Rep 6", "null", "null", "no", "no");
        sq.insertVipcontacts("Executive Committee", "null", "Block Rep 7", "null", "null", "no", "no");
        sq.insertVipcontacts("Executive Committee", "null", "Block Rep 8", "null", "null", "no", "no");
        sq.insertVipcontacts("Executive Committee", "null", "Block Rep 9", "null", "null", "no", "no");
        sq.insertVipcontacts("Executive Committee", "null", "Block Rep 10", "null", "null", "no", "no");
        sq.insertVipcontacts("Executive Committee", "null", "Block Rep 11", "null", "null", "no", "no");
        sq.insertVipcontacts("Executive Committee", "null", "Block Rep 12", "null", "null", "no", "no");
        sq.insertVipcontacts("Executive Committee", "null", "Block Rep 13", "null", "null", "no", "no");
        sq.insertVipcontacts("Executive Committee", "null", "Block Rep 14", "null", "null", "no", "no");
        sq.insertVipcontacts("Executive Committee", "null", "Block Rep 15", "null", "null", "no", "no");
        sq.insertVipcontacts("Executive Committee", "null", "Block Rep 16", "null", "null", "no", "no");

        sq.insertEvents("Durga pooja", "this_month");
        sq.insertEvents("Dandiyaa", "this_month");

        sq.insertEvents("Diwali", "upcoming");
        sq.insertEvents("Christmas", "upcoming");


        sq.insertEvents("Onam", "previous");
        sq.insertEvents("AGM","previous");
        sq.insertEvents("Election","previous");
        sq.insertEvents("Vinayakar pooja","previous");
        sq.insertEvents("Radio Mirchi","previous");
        sq.insertEvents("Apparels","previous");

        sq.insertQueries("ECA", "Drawing (Emb)", "null", "null", "null", "null");
        sq.insertQueries("ECA", "Hindi tution(Emb)", "null", "null", "null", "null");
        sq.insertQueries("ECA", "Karate class (Emb)", "null", "null", "null", "null");
        sq.insertQueries("ECA","Phonics class(Emb)","null","null","null","null");

        sq.insertQueries("Food","cake (Emb)","null","null","null","null");
        sq.insertQueries("Food","FnH(EMB)","null","null","null","null");
        sq.insertQueries("Food","Food service(emb)","null","null","null","null");
        sq.insertQueries("Food","Organic pro(EMB)","null","null","null","null");

        sq.insertQueries("Hosuehold needs","Maid","null","null","null","null");

        sq.insertQueries("Lifestyle","Accessiories","null","null","null","null");
        sq.insertQueries("Lifestyle","Adhithi creation(emb","null","null","null","null");
        sq.insertQueries("Lifestyle","Navra beads(Emb)","null","null","null","null");
        sq.insertQueries("Lifestyle","Saree selling (Emb)","null","null","null","null");
        sq.insertQueries("Lifestyle","Vedhanthika health(emb)","null","null","null","null");
        */
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

//    JsonObjectRequest jsObjRequest = new JsonObjectRequest
//            (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//
//                @Override
//                public void onResponse(JSONObject response) {
//                    processResponseJson(response);
//
//                }
//            }, new Response.ErrorListener() {
//
//                @Override
//                public void onErrorResponse(VolleyError error) {
//                    // TODO Auto-generated method stub
//
//                }
//            });

}
