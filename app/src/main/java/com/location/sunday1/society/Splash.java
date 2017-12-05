package com.location.sunday1.society;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.wang.avi.AVLoadingIndicatorView;

public class Splash extends AppCompatActivity {

    AVLoadingIndicatorView avi,avi1,avi2;
    private final int SPLASH_DISPLAY_LENGTH = 5000;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);



        startAnim();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(Splash.this, Login.class);
                Splash.this.startActivity(mainIntent);
                Splash.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
    void startAnim()
    {
        avi=(AVLoadingIndicatorView)findViewById(R.id.avi);
        avi.show();
        avi1=(AVLoadingIndicatorView)findViewById(R.id.avi1);
        avi1.show();

    }

}