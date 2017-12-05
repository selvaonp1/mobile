package com.location.sunday1.society;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.location.sunday1.society.AddItems;
import com.location.sunday1.society.R;
import com.location.sunday1.society.SQLiteHelper;

public class UpdateEmBuddy extends AppCompatActivity  {
    EditText e1,e2,e3,e4,e5,e6;
    Button b1,del;
    SQLiteHelper sq;
    String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,spp;
    Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_em_buddy);

        final ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.left);

        sq=new SQLiteHelper(this);

        e1 = (EditText)findViewById(R.id.editText34);
        e2 = (EditText)findViewById(R.id.editText21);
        e3 = (EditText)findViewById(R.id.editText22);
        e4 = (EditText)findViewById(R.id.editText23);
        e5 = (EditText)findViewById(R.id.editText24);
        e6 = (EditText)findViewById(R.id.editText25);


        Intent in = getIntent();
        s1=in.getStringExtra("name1");
        s2=in.getStringExtra("name2");
        s3=in.getStringExtra("name3");
        s4=in.getStringExtra("name4");
        s5=in.getStringExtra("name5");
        s6=in.getStringExtra("name6");
        s7=in.getStringExtra("name7");
        s8=in.getStringExtra("name");

        e1.setText(s2);
        e2.setText(s3);
        e3.setText(s4);
        e4.setText(s5);
        e5.setText(s6);
        e6.setText(s7);



        b1 = (Button)findViewById(R.id.button45);
        del = (Button)findViewById(R.id.button55);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sq.deleteEmBuddy(s1))
                {
                    Toast.makeText(UpdateEmBuddy.this, "Deleted successfully", Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(UpdateEmBuddy.this,UpdateItems.class);
                    startActivity(in);
                }else{
                    Toast.makeText(UpdateEmBuddy.this, "Delete failed", Toast.LENGTH_SHORT).show();
                }


            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ss1=e1.getText().toString();
                String ss2=e2.getText().toString();
                String ss3=e3.getText().toString();
                String ss4=e4.getText().toString();
                String ss5=e5.getText().toString();
                String ss6=e6.getText().toString();

                int i =sq.updateembbuddy(ss1, ss2, ss3, ss4, ss5, ss6, s1);
                if(i == -1)
                {
                    Toast.makeText(UpdateEmBuddy.this, "not Updated", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(UpdateEmBuddy.this, "successfully Updated", Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(UpdateEmBuddy.this,UpdateItems.class);
                    startActivity(in);
                }

            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(UpdateEmBuddy.this,UpdateItems.class);

                startActivity(intent);
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
            Intent intent = new Intent(UpdateEmBuddy.this,UpdateItems.class);

            startActivity(intent);
            return true;
        }
        return false;
    }


}
