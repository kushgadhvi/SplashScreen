package com.gadhvi.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    ImageView i1;
    TextView t1;
    LinearLayout l1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
         getSupportActionBar().hide();
        i1 =(ImageView)findViewById(R.id.splashimage);
        t1=(TextView)findViewById(R.id.splashtext);
        l1=(LinearLayout)findViewById(R.id.splashlinear);
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.anim);
        anim.reset();
        l1.clearAnimation();
        l1.startAnimation(anim);
        anim = AnimationUtils.loadAnimation(this, R.anim.trans);
        anim.reset();
        i1.clearAnimation();
        i1.startAnimation(anim);
        anim = AnimationUtils.loadAnimation(this, R.anim.trans);
        anim.reset();
        t1.clearAnimation();
        t1.startAnimation(anim);
        Thread  splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    // Splash screen pause time
                    while (waited < 5500) {
                        sleep(100);
                        waited += 100;
                    }
                    Intent intent = new Intent(SplashScreen.this,
                            MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    SplashScreen.this.finish();
                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    SplashScreen.this.finish();
                }

            }
        };
        splashTread.start();


    }

}
