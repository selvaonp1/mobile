package com.location.sunday1.society;

/**
 * Created by sunday1 on 10/21/2017.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

public class SQLiteHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyDBName.db";

    //  User Details

    public static final String REGISTER_TABLE_NAME = "register";
    public static final String REGISTER_COLUMN_ID = "id";
    public static final String REGISTER_COLUMN_NAME = "name";
    public static final String REGISTER_COLUMN_USERID = "userid";
    public static final String REGISTER_COLUMN_PASSWORD = "password";
    public static final String REGISTER_COLUMN_EMAIL = "email";
    public static final String REGISTER_COLUMN_PHONE = "mobileno";
    public static final String REGISTER_COLUMN_SOCIETY = "society";
    public static final String REGISTER_COLUMN_BLOCK = "block";
    public static final String REGISTER_COLUMN_DOORNO = "doorno";
    public static final String REGISTER_COLUMN_AREA = "area";
    private HashMap hp;

    // Add items
    public static final String ITEMS_TABLE_NAME = "items";
    public static final String ITEMS_COLUMN_ID = "id";
    public static final String ITEMS_COLUMN_NAME = "item";
    public static final String ITEMS_COLUMN_HEADER = "header";

    //User Query
    public static final String QUERY_TABLE_NAME = "Query";
    public static final String QUERY_COLUMN_ID = "id";
    public static final String QUERY_COLUMN_USERNAME = "username";
    public static final String QUERY_COLUMN_SOCIETY = "society";
    public static final String QUERY_COLUMN_QUERY = "query";

    //Products
    public static final String PRODUCTS_TABLE_NAME = "products";
    public static final String PRODUCTS_COLUMN_ID = "id";
    public static final String PRODUCTS_COLUMN_CATEGORY = "category";
    public static final String PRODUCTS_COLUMN_PRODUCTS = "product";
    public static final String PRODUCTS_COLUMN_SUBPRODUCTS = "subproduct";
    public static final String PRODUCTS_COLUMN_UNIT = "unit";
    public static final String PRODUCTS_COLUMN_UNITNAME = "unitname";
    public static final String PRODUCTS_COLUMN_PRICE = "price";
    public static final String PRODUCTS_COLUMN_IMAGE = "image";

    //Services
    public static final String SERVICES_TABLE_NAME = "services";
    public static final String SERVICES_COLUMN_ID = "id";
    public static final String SERVICES_COLUMN_CATEGORY = "category";
    public static final String SERVICES_COLUMN_SERVICE = "service";
    public static final String SERVICES_COLUMN_SERVICEPROVIDERNAME = "service_provider_name";
    public static final String SERVICES_COLUMN_MOBILENO = "mobileno";
    public static final String SERVICES_COLUMN_LANDLINE = "landline";
    public static final String SERVICES_COLUMN_ADDRESS = "address";
    public static final String SERVICES_COLUMN_IMAGE = "image";
    public static final String SERVICES_COLUMN_RATING = "rating";

    //rating

    public static final String RATING_TABLE_NAME = "rating";
    public static final String RATING_COLUMN_ID = "id";
    public static final String RATING_COLUMN_PROVIDERNAME = "providername";
    public static final String RATING_COLUMN_MOBILENO = "mobileno";
    public static final String RATING_COLUMN_LANDLINE = "landline";
    public static final String RATING_COLUMN_ADDRESS = "address";
    public static final String RATING_COLUMN_RATING = "ratings";
    public static final String RATING_COLUMN_USERRATING  = "userrating";

    //cart
    public static final String CART_TABLE_NAME = "cart";
    public static final String CART_COLUMN_ID = "id";
    public static final String CART_COLUMN_USER_ID = "user_id";
    public static final String CART_COLUMN_ITEM = "item";
    public static final String CART_COLUMN_UNIT = "unit";
    public static final String CART_COLUMN_QTY = "qty";
    public static final String CART_COLUMN_PRICE = "price";
    public static final String CART_COLUMN_TOT = "tot";

    //vipcontact

    public static final String VIPCONTACTS_TABLE_NAME = "vipcontacts";
    public static final String VIPCONTACTS_COLUMN_ID = "id";
    public static final String VIPCONTACTS_COLUMN_CATEGORY = "category";
    public static final String VIPCONTACTS_COLUMN_NAME = "name";
    public static final String VIPCONTACTS_COLUMN_DESIGNATION = "designation";
    public static final String VIPCONTACTS_COLUMN_MOBILENO = "mobileno";
    public static final String VIPCONTACTS_COLUMN_LANDLINE = "landline";
    public static final String VIPCONTACTS_COLUMN_EMAILID = "emailid";
    public static final String VIPCONTACTS_COLUMN_ADDRESS = "address";

    //events
    public static final String EVENTS_TABLE_NAME = "events";
    public static final String EVENTS_COLUMN_ID = "id";
    public static final String EVENTS_NAME = "event_name";
    public static final String EVENTS_TIME = "time";

    //Queries
    public static final String QUERIES_TABLE_NAME = "queries";
    public static final String QUERIES_COLUMN_ID = "id";
    public static final String QUERIES_COLUMN_CATEGORY = "category";
    public static final String QUERIES_COLUMN_SERVICE = "service";
    public static final String QUERIES_COLUMN_SERVICE_PROVIDER_NAME = "service_provider_name";
    public static final String QUERIES_COLUMN_MOBILENO = "mobileno";
    public static final String QUERIES_COLUMN_LANDLINE = "landline";
    public static final String QUERIES_COLUMN_ADDRESS = "address";

    //newideas

    public static final String NEWIDEA_TABLE_NAME = "newidea";
    public static final String NEWIDEA_COLUMN_ID = "id";
    public static final String NEWIDEA_COLUMN_IDEA = "idea";








    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL("create table " + REGISTER_TABLE_NAME + "(" + REGISTER_COLUMN_ID + " integer primary key,"+"_id text," + REGISTER_COLUMN_NAME + " text," + REGISTER_COLUMN_USERID + " text," + REGISTER_COLUMN_PASSWORD + " text," + REGISTER_COLUMN_EMAIL + " text," + REGISTER_COLUMN_PHONE + " text," + REGISTER_COLUMN_SOCIETY + " text," + REGISTER_COLUMN_BLOCK + " text," + REGISTER_COLUMN_DOORNO + " text," + REGISTER_COLUMN_AREA + " text)");
        db.execSQL("create table " + ITEMS_TABLE_NAME + "(" + ITEMS_COLUMN_ID + " integer primary key,"+"_id text,"  + ITEMS_COLUMN_NAME + " text," + ITEMS_COLUMN_HEADER + " text)");
        db.execSQL("create table " + QUERY_TABLE_NAME + "(" + QUERY_COLUMN_ID + " integer primary key,"+"_id text,"  + QUERY_COLUMN_USERNAME + " text," + QUERY_COLUMN_SOCIETY + " text," + QUERY_COLUMN_QUERY + " text)");
        db.execSQL("create table " + PRODUCTS_TABLE_NAME + "(" + PRODUCTS_COLUMN_ID + " integer primary key," + PRODUCTS_COLUMN_CATEGORY + " text," + PRODUCTS_COLUMN_PRODUCTS + " text," + PRODUCTS_COLUMN_SUBPRODUCTS + " text," + PRODUCTS_COLUMN_UNIT + " text," + PRODUCTS_COLUMN_UNITNAME + " text," + PRODUCTS_COLUMN_PRICE + " text," + "_id text," + PRODUCTS_COLUMN_IMAGE + " text)");
        db.execSQL("create table " + SERVICES_TABLE_NAME + "(" + SERVICES_COLUMN_ID + " integer primary key," + SERVICES_COLUMN_CATEGORY + " text, " + SERVICES_COLUMN_SERVICE + " text," + SERVICES_COLUMN_SERVICEPROVIDERNAME + " text," + SERVICES_COLUMN_MOBILENO + " text," + SERVICES_COLUMN_LANDLINE + " text," + PRODUCTS_COLUMN_UNITNAME + " text," + SERVICES_COLUMN_ADDRESS + " text," + "_id text," + SERVICES_COLUMN_IMAGE + " text,"+SERVICES_COLUMN_RATING+" text)");
        db.execSQL("create table " + RATING_TABLE_NAME + "(" + RATING_COLUMN_ID + " integer primary key," + RATING_COLUMN_PROVIDERNAME + " text, " + RATING_COLUMN_MOBILENO + " text," + RATING_COLUMN_LANDLINE + " text," + RATING_COLUMN_ADDRESS + " text," + RATING_COLUMN_RATING + " text," + RATING_COLUMN_USERRATING + " text)");
        db.execSQL("create table " + CART_TABLE_NAME + "(" + CART_COLUMN_ID + " integer primary key," + CART_COLUMN_USER_ID + " text, " + CART_COLUMN_ITEM + " text," + CART_COLUMN_UNIT + " text," + CART_COLUMN_QTY + " text," + CART_COLUMN_PRICE + " text,"+ "_id text," + CART_COLUMN_TOT + " text)");
        db.execSQL("create table " + VIPCONTACTS_TABLE_NAME + "(" + VIPCONTACTS_COLUMN_ID + " integer primary key," + VIPCONTACTS_COLUMN_CATEGORY + " text, " + VIPCONTACTS_COLUMN_NAME + " text," + "_id text," + VIPCONTACTS_COLUMN_DESIGNATION + " text," + VIPCONTACTS_COLUMN_MOBILENO + " text," + VIPCONTACTS_COLUMN_LANDLINE + " text," + VIPCONTACTS_COLUMN_EMAILID + " text," + VIPCONTACTS_COLUMN_ADDRESS + " text)");
        db.execSQL("create table " + EVENTS_TABLE_NAME + "(" + EVENTS_COLUMN_ID + " integer primary key," + EVENTS_NAME + " text, " + "_id text," + EVENTS_TIME + " text)");
        db.execSQL("create table " + QUERIES_TABLE_NAME + "(" + QUERIES_COLUMN_ID + " integer primary key," +QUERIES_COLUMN_CATEGORY + " text, " +QUERIES_COLUMN_SERVICE + " text, " + QUERIES_COLUMN_SERVICE_PROVIDER_NAME + " text," + QUERIES_COLUMN_MOBILENO + " text," + QUERIES_COLUMN_LANDLINE + " text," + "_id text," +  QUERIES_COLUMN_ADDRESS + " text)");
        db.execSQL("create table " + NEWIDEA_TABLE_NAME + "(" + NEWIDEA_COLUMN_ID + " integer primary key," + "_id text," + NEWIDEA_COLUMN_IDEA + " text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(db);
    }

    public int insertVipcontacts(String category,String name, String designation, String mobileno, String landline,String emailid,String address) {
        int i=-1;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(VIPCONTACTS_COLUMN_CATEGORY, category);
        contentValues.put(VIPCONTACTS_COLUMN_NAME, name);
        contentValues.put(VIPCONTACTS_COLUMN_DESIGNATION, designation);
        contentValues.put(VIPCONTACTS_COLUMN_MOBILENO, mobileno);
        contentValues.put(VIPCONTACTS_COLUMN_LANDLINE, landline);
        contentValues.put(VIPCONTACTS_COLUMN_EMAILID, emailid);
        contentValues.put(VIPCONTACTS_COLUMN_ADDRESS, address);


        i=(int)db.insert(VIPCONTACTS_TABLE_NAME, null, contentValues);
        return i;
    }

    public int insertQueries(String category,String service, String service_provider_name, String mobileno, String landline,String address) {
        int i=-1;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(QUERIES_COLUMN_CATEGORY, category);
        contentValues.put(QUERIES_COLUMN_SERVICE, service);
        contentValues.put(QUERIES_COLUMN_SERVICE_PROVIDER_NAME, service_provider_name);
        contentValues.put(QUERIES_COLUMN_MOBILENO, mobileno);
        contentValues.put(QUERIES_COLUMN_LANDLINE, landline);
        contentValues.put(QUERIES_COLUMN_ADDRESS, address);


        i=(int)db.insert(QUERIES_TABLE_NAME, null, contentValues);
        return i;
    }
    public int insertEvents(String event_name,String time) {
        int i=-1;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(EVENTS_NAME, event_name);
        contentValues.put(EVENTS_TIME, time);



        i=(int)db.insert(EVENTS_TABLE_NAME, null, contentValues);
        return i;
    }
    public int insertNewIdea(String idea) {
        int i=-1;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(NEWIDEA_COLUMN_IDEA, idea);



        i=(int)db.insert(NEWIDEA_TABLE_NAME, null, contentValues);
        return i;
    }



    public int insertAddcart(String userid,String item, String unit, String qty, String price,String tot) {
        int i=-1;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CART_COLUMN_USER_ID, userid);
        contentValues.put(CART_COLUMN_ITEM, item);
        contentValues.put(CART_COLUMN_UNIT, unit);
        contentValues.put(CART_COLUMN_QTY, qty);
        contentValues.put(CART_COLUMN_PRICE, price);
        contentValues.put(CART_COLUMN_TOT, tot);


        i=(int)db.insert(CART_TABLE_NAME, null, contentValues);
        return i;
    }


    public int register(String name,String userid,String password, String email, String phone, String society,String block, String doorno, String area) {
        int i=-1;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(REGISTER_COLUMN_NAME, name);
        contentValues.put(REGISTER_COLUMN_USERID, userid);
        contentValues.put(REGISTER_COLUMN_PASSWORD, password);
        contentValues.put(REGISTER_COLUMN_EMAIL, email);
        contentValues.put(REGISTER_COLUMN_PHONE, phone);
        contentValues.put(REGISTER_COLUMN_SOCIETY, society);
        contentValues.put(REGISTER_COLUMN_BLOCK, block);
        contentValues.put(REGISTER_COLUMN_DOORNO, doorno);
        contentValues.put(REGISTER_COLUMN_AREA, area);

        i=(int)db.insert(REGISTER_TABLE_NAME, null, contentValues);
        return i;
    }
    public int items(String item, String header) {
        int i=-1;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ITEMS_COLUMN_NAME, item);
        contentValues.put(ITEMS_COLUMN_HEADER, header);

        i=(int)db.insert(ITEMS_TABLE_NAME, null, contentValues);
        return i;
    }
    public int query(String username, String society, String query) {
        int i=-1;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(QUERY_COLUMN_USERNAME, username);
        contentValues.put(QUERY_COLUMN_SOCIETY, society);
        contentValues.put(QUERY_COLUMN_QUERY, query);

        i=(int)db.insert(QUERY_TABLE_NAME, null, contentValues);
        return i;
    }
    public int insertProducts(String category, String product, String subproduct, String unit,String unitname, String price, String image) {
        int i=-1;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PRODUCTS_COLUMN_CATEGORY, category);
        contentValues.put(PRODUCTS_COLUMN_PRODUCTS, product);
        contentValues.put(PRODUCTS_COLUMN_SUBPRODUCTS, subproduct);
        contentValues.put(PRODUCTS_COLUMN_UNIT, unit);
        contentValues.put(PRODUCTS_COLUMN_UNITNAME, unitname);
        contentValues.put(PRODUCTS_COLUMN_PRICE, price);
        contentValues.put(PRODUCTS_COLUMN_IMAGE, image);


        i=(int)db.insert(PRODUCTS_TABLE_NAME, null, contentValues);
        return i;
    }

    public int insertServices(String category, String service, String serviceprovidername, String mobileno,String landline, String address, String image,String rating) {
        int i=-1;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SERVICES_COLUMN_CATEGORY, category);
        contentValues.put(SERVICES_COLUMN_SERVICE, service);
        contentValues.put(SERVICES_COLUMN_SERVICEPROVIDERNAME, serviceprovidername);
        contentValues.put(SERVICES_COLUMN_MOBILENO, mobileno);
        contentValues.put(SERVICES_COLUMN_LANDLINE, landline);
        contentValues.put(SERVICES_COLUMN_ADDRESS, address);
        contentValues.put(SERVICES_COLUMN_IMAGE, image);
        contentValues.put(SERVICES_COLUMN_RATING, rating);


        i=(int)db.insert(SERVICES_TABLE_NAME, null, contentValues);
        return i;
    }
    public int insertRating(String service,String providername, String mobileno, String landline, String address,String rating ) {
        int i=-1;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(RATING_COLUMN_USERRATING, service);
        contentValues.put(RATING_COLUMN_PROVIDERNAME, providername);
        contentValues.put(RATING_COLUMN_MOBILENO, mobileno);
        contentValues.put(RATING_COLUMN_LANDLINE, landline);
        contentValues.put(RATING_COLUMN_ADDRESS, address);
        contentValues.put(RATING_COLUMN_RATING, rating);



        i=(int)db.insert(RATING_TABLE_NAME, null, contentValues);
        return i;
    }

    public String getrating(String s1,String service){

        String re = null;
        Cursor c1 = null;
        String []cols=new String[]{"avg("+RATING_COLUMN_RATING+")",RATING_COLUMN_PROVIDERNAME,RATING_COLUMN_USERRATING};
        SQLiteDatabase db = this.getReadableDatabase();
        c1=db.query(RATING_TABLE_NAME,cols,RATING_COLUMN_PROVIDERNAME+"=?and "+RATING_COLUMN_USERRATING+"=?",new String[]{s1,service},null,null,null,null);
        if(c1.moveToNext())
        {
            re=c1.getString(c1.getColumnIndex("avg("+RATING_COLUMN_RATING+")"));
        }
        return re;
    }

    public Cursor getCartDetailsForUser(String s) {
        SQLiteDatabase db = this.getReadableDatabase();
        String gg = null;
        String[] cols = {"_id",CART_COLUMN_ID,CART_COLUMN_USER_ID, CART_COLUMN_ITEM,CART_COLUMN_PRICE,CART_COLUMN_QTY,CART_COLUMN_TOT,CART_COLUMN_UNIT };
        Cursor c1=db.query(CART_TABLE_NAME, cols, CART_COLUMN_USER_ID + "=?", new String[]{s}, null, null, null);
        return c1;

    }
    public String getTotalAmount(String s) {
        String totamt="0.0";
        Double totInD=0.0;
        SQLiteDatabase db = this.getReadableDatabase();
        String gg = null;
        String[] cols = {CART_COLUMN_TOT};
        Cursor c1=db.query(CART_TABLE_NAME, cols, CART_COLUMN_USER_ID + "=?", new String[]{s}, null, null, null);
        if(c1.moveToFirst())
        {
            do{
                String tot=c1.getString(c1.getColumnIndex(CART_COLUMN_TOT));
                 totInD = totInD+Double.parseDouble(tot);
                totamt=String.valueOf(totInD);
            }while (c1.moveToNext());
        }
        return totamt;

    }

    public String getItemCount(String s)
    {
        String s1 = null,s2;
        SQLiteDatabase db=this.getReadableDatabase();
        String[] cols={"COUNT("+CART_COLUMN_USER_ID+")",CART_COLUMN_USER_ID};
        Cursor c2=db.query(REGISTER_TABLE_NAME,new String[]{REGISTER_COLUMN_ID},REGISTER_COLUMN_PHONE+"=?",new String[]{s},null,null,null);
        if(c2.moveToNext())
        {
            s1=c2.getString(c2.getColumnIndex(REGISTER_COLUMN_ID));
        }
        Cursor c1=db.query(CART_TABLE_NAME,cols,CART_COLUMN_USER_ID+"=?",new String[]{s1},null,null,null);
        if(c1.moveToNext())
        {
            s2=c1.getString(c1.getColumnIndex("COUNT("+CART_COLUMN_USER_ID+")"));
        }
        else {
            s2="0";
        }
        return s2;
    }

    public Cursor queryNamepay() {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] cols = {"_id",PRODUCTS_COLUMN_ID, PRODUCTS_COLUMN_PRODUCTS };
        Cursor c=db.query(PRODUCTS_TABLE_NAME, cols, null, null, null, null, null);
        Cursor c1=db.query(PRODUCTS_TABLE_NAME, cols, null, null, PRODUCTS_COLUMN_PRODUCTS, null, PRODUCTS_COLUMN_PRODUCTS);


        return c1;

    }
    public Cursor queryNamepay7() {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] cols = {"_id",NEWIDEA_COLUMN_ID, NEWIDEA_COLUMN_IDEA };
        Cursor c=db.query(NEWIDEA_TABLE_NAME, cols, null, null, null, null, null);
        Cursor c1=db.query(NEWIDEA_TABLE_NAME, cols, null, null, null, null, null);


        return c1;

    }
    public Cursor queryNamepay1(String s1) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] cols = {"_id",PRODUCTS_COLUMN_ID,PRODUCTS_COLUMN_PRODUCTS, PRODUCTS_COLUMN_SUBPRODUCTS,PRODUCTS_COLUMN_PRICE };
        Cursor c=db.query(PRODUCTS_TABLE_NAME, cols, null, null, null, null, PRODUCTS_COLUMN_SUBPRODUCTS);
        Cursor c1=db.query(PRODUCTS_TABLE_NAME, cols,PRODUCTS_COLUMN_PRODUCTS+"=?",new String[]{s1},PRODUCTS_COLUMN_SUBPRODUCTS,null,PRODUCTS_COLUMN_SUBPRODUCTS);


        return c1;

    }
    public Cursor queryNamepay2(String s1) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] cols = {"_id",SERVICES_COLUMN_ID, SERVICES_COLUMN_SERVICE };
        Cursor c1=db.query(SERVICES_TABLE_NAME, cols,SERVICES_COLUMN_CATEGORY+"=?",new String[]{s1},SERVICES_COLUMN_SERVICE,null,SERVICES_COLUMN_SERVICE);
        return c1;

    }
    public Cursor queryNamepay4(String s1) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] cols = {"_id",VIPCONTACTS_COLUMN_ID, VIPCONTACTS_COLUMN_DESIGNATION,VIPCONTACTS_COLUMN_CATEGORY,VIPCONTACTS_COLUMN_NAME,VIPCONTACTS_COLUMN_MOBILENO,VIPCONTACTS_COLUMN_LANDLINE,VIPCONTACTS_COLUMN_EMAILID,VIPCONTACTS_COLUMN_ADDRESS };
        Cursor c1=db.query(VIPCONTACTS_TABLE_NAME, cols,VIPCONTACTS_COLUMN_CATEGORY+"=?",new String[]{s1},null,null,VIPCONTACTS_COLUMN_DESIGNATION);
        return c1;

    }
    public Cursor queryNamepay5(String s1) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] cols = {"_id",EVENTS_COLUMN_ID, EVENTS_NAME,EVENTS_TIME};
        Cursor c1=db.query(EVENTS_TABLE_NAME, cols,EVENTS_TIME+"=?",new String[]{s1},null,null,EVENTS_NAME);
        return c1;

    }
    public Cursor queryNamepay6(String s1) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] cols = {"_id",QUERIES_COLUMN_ID, QUERIES_COLUMN_CATEGORY,QUERIES_COLUMN_SERVICE,QUERIES_COLUMN_SERVICE_PROVIDER_NAME,QUERIES_COLUMN_MOBILENO,QUERIES_COLUMN_LANDLINE,QUERIES_COLUMN_ADDRESS};
        Cursor c1=db.query(QUERIES_TABLE_NAME, cols,QUERIES_COLUMN_CATEGORY+"=?",new String[]{s1},null,null,QUERIES_COLUMN_SERVICE);
        return c1;

    }

    public Cursor queryNamepay3(String s1) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] cols = {"_id",SERVICES_COLUMN_ID, SERVICES_COLUMN_SERVICE,SERVICES_COLUMN_SERVICEPROVIDERNAME,SERVICES_COLUMN_MOBILENO,SERVICES_COLUMN_LANDLINE,SERVICES_COLUMN_ADDRESS,SERVICES_COLUMN_RATING };
        Cursor c1=db.query(SERVICES_TABLE_NAME, cols,SERVICES_COLUMN_SERVICE+"=?",new String[]{s1},null,null,null);
        return c1;

    }
    public Cursor queryNamepay11() {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] cols = {"_id",SERVICES_COLUMN_ID,SERVICES_COLUMN_CATEGORY, SERVICES_COLUMN_SERVICE,SERVICES_COLUMN_SERVICEPROVIDERNAME,SERVICES_COLUMN_MOBILENO,SERVICES_COLUMN_LANDLINE,SERVICES_COLUMN_ADDRESS,SERVICES_COLUMN_RATING };
        Cursor c1=db.query(SERVICES_TABLE_NAME, cols,null,null,null,null,null);
        return c1;

    }
    public Cursor queryNamepays11(String cat) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] cols = {"_id",SERVICES_COLUMN_ID,SERVICES_COLUMN_CATEGORY, SERVICES_COLUMN_SERVICE,SERVICES_COLUMN_SERVICEPROVIDERNAME,SERVICES_COLUMN_MOBILENO,SERVICES_COLUMN_LANDLINE,SERVICES_COLUMN_ADDRESS,SERVICES_COLUMN_RATING };
        Cursor c1=db.query(SERVICES_TABLE_NAME, cols,SERVICES_COLUMN_CATEGORY+"=?",new String[]{cat},null,null,null);
        return c1;

    }
    public Cursor queryNamepay12() {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] cols = {"_id",PRODUCTS_COLUMN_ID,PRODUCTS_COLUMN_CATEGORY, PRODUCTS_COLUMN_PRODUCTS,PRODUCTS_COLUMN_SUBPRODUCTS,PRODUCTS_COLUMN_UNIT,PRODUCTS_COLUMN_UNITNAME,PRODUCTS_COLUMN_PRICE };
        Cursor c1=db.query(PRODUCTS_TABLE_NAME, cols,null,null,null,null,null);
        return c1;

    }
    public Cursor queryNamepays12(String cat) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] cols = {"_id",PRODUCTS_COLUMN_ID,PRODUCTS_COLUMN_CATEGORY, PRODUCTS_COLUMN_PRODUCTS,PRODUCTS_COLUMN_SUBPRODUCTS,PRODUCTS_COLUMN_UNIT,PRODUCTS_COLUMN_UNITNAME,PRODUCTS_COLUMN_PRICE };
        Cursor c1=db.query(PRODUCTS_TABLE_NAME, cols,PRODUCTS_COLUMN_CATEGORY+"=?",new String[]{cat},null,null,null);
        return c1;

    }
    public Cursor queryNamepay13() {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] cols = {"_id",VIPCONTACTS_COLUMN_ID,VIPCONTACTS_COLUMN_CATEGORY, VIPCONTACTS_COLUMN_NAME,VIPCONTACTS_COLUMN_DESIGNATION,VIPCONTACTS_COLUMN_MOBILENO,VIPCONTACTS_COLUMN_LANDLINE,VIPCONTACTS_COLUMN_EMAILID,VIPCONTACTS_COLUMN_ADDRESS };
        Cursor c1=db.query(VIPCONTACTS_TABLE_NAME, cols,null,null,null,null,null);
        return c1;

    }
    public Cursor queryNamepays13(String cat) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] cols = {"_id",VIPCONTACTS_COLUMN_ID,VIPCONTACTS_COLUMN_CATEGORY, VIPCONTACTS_COLUMN_NAME,VIPCONTACTS_COLUMN_DESIGNATION,VIPCONTACTS_COLUMN_MOBILENO,VIPCONTACTS_COLUMN_LANDLINE,VIPCONTACTS_COLUMN_EMAILID,VIPCONTACTS_COLUMN_ADDRESS };
        Cursor c1=db.query(VIPCONTACTS_TABLE_NAME, cols,VIPCONTACTS_COLUMN_CATEGORY+"=?",new String[]{cat},null,null,null);
        return c1;

    }
    public Cursor queryNamepay14() {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] cols = {"_id",QUERIES_COLUMN_ID,QUERIES_COLUMN_CATEGORY, QUERIES_COLUMN_SERVICE,QUERIES_COLUMN_SERVICE_PROVIDER_NAME,QUERIES_COLUMN_MOBILENO,QUERIES_COLUMN_LANDLINE,QUERIES_COLUMN_ADDRESS};
        Cursor c1=db.query(QUERIES_TABLE_NAME, cols,null,null,null,null,null);
        return c1;

    }

    public Cursor queryNamepays14(String cat) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] cols = {"_id",QUERIES_COLUMN_ID,QUERIES_COLUMN_CATEGORY, QUERIES_COLUMN_SERVICE,QUERIES_COLUMN_SERVICE_PROVIDER_NAME,QUERIES_COLUMN_MOBILENO,QUERIES_COLUMN_LANDLINE,QUERIES_COLUMN_ADDRESS};
        Cursor c1=db.query(QUERIES_TABLE_NAME, cols,QUERIES_COLUMN_CATEGORY+"=?",new String[]{cat},null,null,null);
        return c1;

    }
    public Cursor queryNamepay15() {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] cols = {"_id",EVENTS_COLUMN_ID,EVENTS_NAME, EVENTS_TIME};
        Cursor c1=db.query(EVENTS_TABLE_NAME, cols,null,null,null,null,null);
        return c1;

    }
    public Cursor queryNamepays15(String cat) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] cols = {"_id",EVENTS_COLUMN_ID,EVENTS_NAME, EVENTS_TIME};
        Cursor c1=db.query(EVENTS_TABLE_NAME, cols,EVENTS_TIME+"=?",new String[]{cat},null,null,null);
        return c1;

    }

    public String Login(String userid,String password)
    {


        Cursor c1 = null;

        String[] cols=new String[]{REGISTER_COLUMN_USERID};
        SQLiteDatabase db = this.getReadableDatabase();
        c1=db.query(REGISTER_TABLE_NAME,cols,REGISTER_COLUMN_PHONE+"=? and "+REGISTER_COLUMN_PASSWORD+"=?",new String[]{userid,password},null,null,null,null);

        if (c1.moveToNext()) {

            String n=c1.getString(0);
            return "ok";
        }
        else
        {
            return "no";
        }
    }

    public String forgetpassword(String email)
    {


        Cursor c1 = null;

        String[] cols=new String[]{REGISTER_COLUMN_EMAIL};
        SQLiteDatabase db = this.getReadableDatabase();
        c1=db.query(REGISTER_TABLE_NAME,cols,REGISTER_COLUMN_EMAIL+"=?",new String[]{email},null,null,null,null);

        if (c1.moveToNext()) {

            String n=c1.getString(0);
            return "ok";
        }
        else
        {
            return "no";
        }
    }
    public String getUserId(String userid,String password)
    {


        Cursor c1 = null;
        String[] cols=new String[]{REGISTER_COLUMN_USERID,REGISTER_COLUMN_PASSWORD};
        SQLiteDatabase db = this.getReadableDatabase();
        c1=db.query(REGISTER_TABLE_NAME,cols,REGISTER_COLUMN_PHONE+"=? and "+REGISTER_COLUMN_PASSWORD+"=?",new String[]{userid,password},null,null,null,null);

        if (c1.moveToNext()) {

            String n=c1.getString(0);
            return n;
        }
        else{
            return 0+"";
        }
    }


    public String getDets(String mobno)
    {
        Cursor c1 = null;
        String res = "go",ser = "fl";
        String []cols=new String[]{REGISTER_COLUMN_USERID,REGISTER_COLUMN_NAME,REGISTER_COLUMN_SOCIETY};
        SQLiteDatabase db = this.getReadableDatabase();
        c1=db.query(REGISTER_TABLE_NAME,cols,REGISTER_COLUMN_USERID+"="+mobno,null,null,null,null,null);
        if(c1.moveToNext())
        {
            res=c1.getString(c1.getColumnIndex(REGISTER_COLUMN_NAME));
            ser=c1.getString(c1.getColumnIndex(REGISTER_COLUMN_SOCIETY));
        }
        String re=res+"/"+ser;
        return re;
    }

    public String getMail(String mailid)
    {
        Cursor c1 = null;
        String res = "default",em="default",pas="default";
        String []cols=new String[]{REGISTER_COLUMN_NAME,REGISTER_COLUMN_EMAIL,REGISTER_COLUMN_PASSWORD};
        SQLiteDatabase db = this.getReadableDatabase();
        c1=db.query(REGISTER_TABLE_NAME,cols,REGISTER_COLUMN_EMAIL+"=?",new String[]{mailid},null,null,null,null);
        if(c1.moveToNext())
        {
            res=c1.getString(c1.getColumnIndex(REGISTER_COLUMN_NAME));
            em=c1.getString(c1.getColumnIndex(REGISTER_COLUMN_EMAIL));
            pas=c1.getString(c1.getColumnIndex(REGISTER_COLUMN_PASSWORD));
        }
        String re=res+"/"+em+"/"+pas;
        return re;
    }


    public String getUnit(String pid)
    {
        Cursor c1 = null;
        String s="nothing";
        SQLiteDatabase db = this.getReadableDatabase();
        String []cols=new String[]{PRODUCTS_COLUMN_ID,PRODUCTS_COLUMN_UNIT,PRODUCTS_COLUMN_UNITNAME,PRODUCTS_COLUMN_PRICE};
       // c1=db.query(PRODUCTS_TABLE_NAME,cols,PRODUCTS_COLUMN_ID+"="+pid,null,null,null,null,null);
        c1=db.query(PRODUCTS_TABLE_NAME,cols,PRODUCTS_COLUMN_ID+"="+pid,null,null,null,null,null);
        if(c1.moveToNext())
        {
            s=c1.getString(c1.getColumnIndex(PRODUCTS_COLUMN_UNITNAME));
        }
        return s;
    }
    public String getUnitList(String pid,String unina)
    {
        Cursor c1 = null;
        String s="nothing";
        SQLiteDatabase db = this.getReadableDatabase();
        String []cols=new String[]{PRODUCTS_COLUMN_ID, PRODUCTS_COLUMN_UNIT, PRODUCTS_COLUMN_UNITNAME, PRODUCTS_COLUMN_PRICE, "COUNT(" + PRODUCTS_COLUMN_UNIT+")"};
       // c1=db.query(PRODUCTS_TABLE_NAME,cols,PRODUCTS_COLUMN_ID+"="+pid,null,null,null,null,null);
        c1=db.query(PRODUCTS_TABLE_NAME,cols,PRODUCTS_COLUMN_UNIT+"="+unina,null,PRODUCTS_COLUMN_UNIT,null,null,null);
        if(c1.moveToNext())
        {
            s=c1.getString(c1.getColumnIndex("COUNT("+PRODUCTS_COLUMN_UNIT+")"));
        }
        return s;
    }

    public List<String> getAllLabels(String header){
        List<String> list = new ArrayList<String>();

        // Select All Query
        //String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        String[] col=new String[]{ITEMS_COLUMN_NAME,ITEMS_COLUMN_HEADER};
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(ITEMS_TABLE_NAME, col, ITEMS_COLUMN_HEADER + "=?", new String[]{header}, null, null, null);//selectQuery,selectedArguments

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(0));//adding 2nd column data
            } while (cursor.moveToNext());
        }
        // closing connection
        cursor.close();
        db.close();

        // returning lables
        return list;
    }


    public String getmailid(String uid) {
        String[] col=new String[]{REGISTER_COLUMN_ID,REGISTER_COLUMN_EMAIL};
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query(REGISTER_TABLE_NAME,col,REGISTER_COLUMN_PHONE+"=?",new String[]{uid},null,null,null);
        String ss;
        if(cursor.moveToFirst()){
            ss=cursor.getString(cursor.getColumnIndex(REGISTER_COLUMN_EMAIL));
        }
        else {
            ss="no";
        }
        return ss;
    }
    public String getName(String uid) {
        String[] col=new String[]{REGISTER_COLUMN_ID,REGISTER_COLUMN_NAME};
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query(REGISTER_TABLE_NAME, col, REGISTER_COLUMN_PHONE + "=?", new String[]{uid}, null, null, null);
        String ss;
        if(cursor.moveToFirst()){
            ss=cursor.getString(cursor.getColumnIndex(REGISTER_COLUMN_NAME));
        }
        else {
            ss="no";
        }
        return ss;
    }

    public String getDetails(String uid)
    {
        String[] col=new String[]{REGISTER_COLUMN_ID,REGISTER_COLUMN_SOCIETY,REGISTER_COLUMN_AREA,REGISTER_COLUMN_BLOCK,REGISTER_COLUMN_DOORNO,REGISTER_COLUMN_PHONE};
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query(REGISTER_TABLE_NAME, col, REGISTER_COLUMN_PHONE + "=?", new String[]{uid}, null, null, null);
        String ss;
        if(cursor.moveToFirst()){
            String s1=cursor.getString(cursor.getColumnIndex(REGISTER_COLUMN_DOORNO));
            String s2=cursor.getString(cursor.getColumnIndex(REGISTER_COLUMN_BLOCK));
            String s3=cursor.getString(cursor.getColumnIndex(REGISTER_COLUMN_SOCIETY));
            String s4=cursor.getString(cursor.getColumnIndex(REGISTER_COLUMN_AREA));
            String s5=cursor.getString(cursor.getColumnIndex(REGISTER_COLUMN_PHONE));
            ss=s1+"/"+s2+"/"+s3+"/"+s4+"/"+s5;
        }
        else {
            ss="no/no/no/no/no";;
        }
        return ss;
    }
    public boolean deletecart(String uid)
    {
        boolean res=false;
        String[] col=new String[]{CART_COLUMN_ID};
        SQLiteDatabase db=this.getReadableDatabase();
        int i=db.delete(CART_TABLE_NAME,CART_COLUMN_ID+"=?",new String[]{uid});
        if(i>0)
        {
            res=true;
        }
        return res;

    }
    public boolean deleteEmBuddy(String uid)
    {
        boolean res=false;
        String[] col=new String[]{SERVICES_COLUMN_ID};
        SQLiteDatabase db=this.getReadableDatabase();
        int i=db.delete(SERVICES_TABLE_NAME,SERVICES_COLUMN_ID+"=?",new String[]{uid});
        if(i>0)
        {
            res=true;
        }
        return res;

    }
    public boolean deleteEmBasket(String uid)
    {
        boolean res=false;
        String[] col=new String[]{PRODUCTS_COLUMN_ID};
        SQLiteDatabase db=this.getReadableDatabase();
        int i=db.delete(PRODUCTS_TABLE_NAME,PRODUCTS_COLUMN_ID+"=?",new String[]{uid});
        if(i>0)
        {
            res=true;
        }
        return res;

    }
    public boolean deleteEmBassador(String uid)
    {
        boolean res=false;
        String[] col=new String[]{VIPCONTACTS_COLUMN_ID};
        SQLiteDatabase db=this.getReadableDatabase();
        int i=db.delete(VIPCONTACTS_TABLE_NAME,VIPCONTACTS_COLUMN_ID+"=?",new String[]{uid});
        if(i>0)
        {
            res=true;
        }
        return res;

    }
    public boolean deleteEmBizz(String uid)
    {
        boolean res=false;
        String[] col=new String[]{QUERIES_COLUMN_ID};
        SQLiteDatabase db=this.getReadableDatabase();
        int i=db.delete(QUERIES_TABLE_NAME,QUERIES_COLUMN_ID+"=?",new String[]{uid});
        if(i>0)
        {
            res=true;
        }
        return res;

    }
    public boolean deleteEmBevents(String uid)
    {
        boolean res=false;
        String[] col=new String[]{EVENTS_COLUMN_ID};
        SQLiteDatabase db=this.getReadableDatabase();
        int i=db.delete(EVENTS_TABLE_NAME,EVENTS_COLUMN_ID+"=?",new String[]{uid});
        if(i>0)
        {
            res=true;
        }
        return res;

    }
    public int updateCart(String qty,String tot,String uid)
    {
        int i=-1;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CART_COLUMN_QTY, qty);
        contentValues.put(CART_COLUMN_TOT, tot);


        i=db.update(CART_TABLE_NAME,contentValues,CART_COLUMN_ID+"=?",new String[]{uid});
        return i;
    }
    public int updateembbuddy(String category,String service,String service_provider_name, String mobileno,String landline,String address,String id)
    {
        int i=-1;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SERVICES_COLUMN_CATEGORY, category);
        contentValues.put(SERVICES_COLUMN_SERVICE, service);
        contentValues.put(SERVICES_COLUMN_SERVICEPROVIDERNAME, service_provider_name);
        contentValues.put(SERVICES_COLUMN_MOBILENO, mobileno);
        contentValues.put(SERVICES_COLUMN_LANDLINE, landline);
        contentValues.put(SERVICES_COLUMN_ADDRESS, address);
        i=db.update(SERVICES_TABLE_NAME,contentValues,SERVICES_COLUMN_ID+"=?",new String[]{id});
        return i;
    }
    public int updateEmBasket(String category,String product,String subproduct, String unit,String unitname,String price,String id)
    {
        int i=-1;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PRODUCTS_COLUMN_CATEGORY, category);
        contentValues.put(PRODUCTS_COLUMN_PRODUCTS, product);
        contentValues.put(PRODUCTS_COLUMN_SUBPRODUCTS, subproduct);
        contentValues.put(PRODUCTS_COLUMN_UNIT, unit);
        contentValues.put(PRODUCTS_COLUMN_UNITNAME, unitname);
        contentValues.put(PRODUCTS_COLUMN_PRICE, price);



        i=db.update(PRODUCTS_TABLE_NAME,contentValues,PRODUCTS_COLUMN_ID+"=?",new String[]{id});
        return i;
    }
    public int updateEmBassador(String category,String name,String designation, String mobileno,String landline,String emailid,String address,String id)
    {
        int i=-1;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(VIPCONTACTS_COLUMN_CATEGORY, category);
        contentValues.put(VIPCONTACTS_COLUMN_NAME, name);
        contentValues.put(VIPCONTACTS_COLUMN_DESIGNATION, designation);
        contentValues.put(VIPCONTACTS_COLUMN_MOBILENO, mobileno);
        contentValues.put(VIPCONTACTS_COLUMN_LANDLINE, landline);
        contentValues.put(VIPCONTACTS_COLUMN_EMAILID, emailid);
        contentValues.put(VIPCONTACTS_COLUMN_ADDRESS, address);



        i=db.update(VIPCONTACTS_TABLE_NAME,contentValues,VIPCONTACTS_COLUMN_ID+"=?",new String[]{id});
        return i;
    }
    public int updateEmBizz(String category,String service,String service_provider_name, String mobileno,String landline,String address,String id)
    {
        int i=-1;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(QUERIES_COLUMN_CATEGORY, category);
        contentValues.put(QUERIES_COLUMN_SERVICE, service);
        contentValues.put(QUERIES_COLUMN_SERVICE_PROVIDER_NAME, service_provider_name);
        contentValues.put(QUERIES_COLUMN_MOBILENO, mobileno);
        contentValues.put(QUERIES_COLUMN_LANDLINE, landline);
        contentValues.put(QUERIES_COLUMN_ADDRESS, address);



        i=db.update(QUERIES_TABLE_NAME,contentValues,QUERIES_COLUMN_ID+"=?",new String[]{id});
        return i;
    }
    public int updateEmBevents(String event_name,String time,String id)
    {
        int i=-1;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(EVENTS_NAME, event_name);
        contentValues.put(EVENTS_TIME, time);




        i=db.update(EVENTS_TABLE_NAME,contentValues,EVENTS_COLUMN_ID+"=?",new String[]{id});
        return i;
    }
    public Cursor getEmizz() {
        Cursor cursor;
        SQLiteDatabase db=this.getReadableDatabase();
        String[] col=new String[]{QUERIES_COLUMN_ID,QUERIES_COLUMN_SERVICE};
        cursor=db.query(QUERIES_TABLE_NAME, col, null, null, null, null, null);
        return cursor;
    }

    public String getNumberOfItemsInCart(String getid) {
        String totitem = "-1";
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query(CART_TABLE_NAME,new String[]{"COUNT("+CART_COLUMN_ID+")"},CART_COLUMN_USER_ID+"=?",new String[]{getid},null,null,null);
        if(cursor.moveToNext())
        {
            totitem=String.valueOf(cursor.getString(cursor.getColumnIndex("COUNT("+CART_COLUMN_ID+")")));
        }
        return totitem;
    }

    public String getCartNumber(String uid) {
        String tot="0";
        SQLiteDatabase db=this.getReadableDatabase();
        //Cursor cursor=db.query(CART_TABLE_NAME, new String[]{"COUNT(" + CART_COLUMN_ITEM + ")"}, CART_COLUMN_USER_ID + "=?", new String[]{uid}, CART_COLUMN_ITEM, null, null);
        Cursor cursor=db.query(CART_TABLE_NAME, new String[]{"COUNT(" + CART_COLUMN_ITEM + ")"},CART_COLUMN_USER_ID + "=?", new String[]{uid}, null, null, null);
//        Cursor cursor=db.rawQuery("SELECT COUNT("+CART_COLUMN_ID+") WHERE "+CART_COLUMN_USER_ID+"=? GROUP BY"+CART_COLUMN_ITEM,new String[]{uid});
        if(cursor.moveToNext())
        {
            tot=String.valueOf(cursor.getString(cursor.getColumnIndex("COUNT("+CART_COLUMN_ITEM+")")));
        }
        return tot;
    }

    public String getUnitDetails(String s2) {
        String units = "";
        String tot="";
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query(PRODUCTS_TABLE_NAME, new String[]{PRODUCTS_COLUMN_UNIT,PRODUCTS_COLUMN_UNITNAME,PRODUCTS_COLUMN_PRICE}, PRODUCTS_COLUMN_SUBPRODUCTS+"=?",new String[]{s2}, null, null, null);
        if(cursor.moveToFirst())
        {
            do{
                String unit=cursor.getString(cursor.getColumnIndex(PRODUCTS_COLUMN_UNIT));
                String unitname=cursor.getString(cursor.getColumnIndex(PRODUCTS_COLUMN_UNITNAME));
                String price=cursor.getString(cursor.getColumnIndex(PRODUCTS_COLUMN_PRICE));
                units=units+unit+" "+unitname+"/";
                tot=tot+price+"/";

            }while (cursor.moveToNext());
        }
        else{
            units = "0/0/0/0/0";
            tot="0/0/0/0/0";
        }
        String grt=units+">"+tot;

        return grt;
    }

    public String getPrice(String s2){
        String price="";

        return price;
    }

    public int clearCart(String uid) {
        int i=-1;
        SQLiteDatabase db=this.getWritableDatabase();
        i=(int)db.delete(CART_TABLE_NAME,CART_COLUMN_USER_ID+"=?",new String[]{uid});
        return i;
    }

    private void clearTable(String tableName) {

        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("delete from " + tableName);
      }

    public void clearMasterData() {
        clearTable(PRODUCTS_TABLE_NAME);
        clearTable(SERVICES_TABLE_NAME);
        clearTable(RATING_TABLE_NAME);
        clearTable(VIPCONTACTS_TABLE_NAME);
        clearTable(EVENTS_TABLE_NAME);
        clearTable(QUERIES_TABLE_NAME);
    }

}
