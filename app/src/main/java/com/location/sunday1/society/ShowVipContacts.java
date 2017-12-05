package com.location.sunday1.society;

        import android.content.Intent;
        import android.support.v7.app.ActionBar;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.MenuItem;
        import android.widget.TextView;

public class ShowVipContacts extends AppCompatActivity {

    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9;
    SQLiteHelper sq;
    String s1,s2,s3,s4,s5,s,s6,s7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_vip_contacts);

        final ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.left);


        sq=new SQLiteHelper(this);

        t1 =(TextView)findViewById(R.id.textView59);
        t2 =(TextView)findViewById(R.id.textView60);
        t3 =(TextView)findViewById(R.id.textView61);
        t4 =(TextView)findViewById(R.id.textView62);
        t5 =(TextView)findViewById(R.id.textView63);
        t6 =(TextView)findViewById(R.id.textView64);
        t7 =(TextView)findViewById(R.id.textView66);
        t8 =(TextView)findViewById(R.id.textView98);
        t9 =(TextView)findViewById(R.id.textView99);

        Intent In = getIntent();
        s = In.getStringExtra("subj");
        s1 = In.getStringExtra("sub");
        s2 = In.getStringExtra("sub1");
        s3 = In.getStringExtra("sub2");
        s4 = In.getStringExtra("sub3");
        s5 = In.getStringExtra("sub4");
        s6 = In.getStringExtra("sub5");
        s7 = In.getStringExtra("sub6");
        t1.setText(s2);
        t2.setText(s3);
        t3.setText(s1);
        t4.setText(s4);
        t5.setText(s5);
        t6.setText(s6);
        t7.setText(s7);
        t8.setText(s2 +" / ");
        t9.setText(s1);




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
