package com.location.sunday1.society;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class ForgetPassword extends AppCompatActivity {

    EditText emailid;
    Button submit;
    SQLiteHelper sq;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    String mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_password);

        final ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.left);

        sq = new SQLiteHelper(this);
        emailid = (EditText) findViewById(R.id.editText28);
        submit = (Button) findViewById(R.id.button26);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mail= emailid.getText().toString();

                if((emailid.getText().toString()).isEmpty()) {
                    Toast.makeText(getApplicationContext(), "enter the field.", Toast.LENGTH_SHORT).show();
                }
                else {
                    if ((emailid.getText().toString().matches(emailPattern)))
                    {
                        String result = sq.forgetpassword(mail);
                        if (result.equalsIgnoreCase("ok")) {
                            String mail = emailid.getText().toString();
                            String st = sq.getMail(mail);
                            String[] se = st.split("/");
                            String na = se[0];
                            String em = se[1];
                            String pa = se[2];

                            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", em, null));
                            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your Password");
                            emailIntent.putExtra(Intent.EXTRA_TEXT, "Hi " + na + ",\n" + "Your Password is " + pa);
                            startActivity(Intent.createChooser(emailIntent, "Send email..."));
                        }else {
                            Toast.makeText(ForgetPassword.this, "emailid missmatched", Toast.LENGTH_SHORT).show();
                        }


                }
                else{
                    Toast.makeText(getApplicationContext(), "invalid emailid.", Toast.LENGTH_SHORT).show();
                }
                }
            }
        });
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
    private boolean isValidEmaillId(String email){

        return Pattern.compile("\"[a-zA-Z0-9._-]+@[a-z]+\\\\.+[a-z]+\"").matcher(email).matches();
    }

}