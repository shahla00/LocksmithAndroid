package com.birminghamneedalocksmith.locksmith;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // Start home activity
        startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
        // close splash activity
        finish();
    }
}
