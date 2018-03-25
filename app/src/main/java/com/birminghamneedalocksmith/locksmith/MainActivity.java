package com.birminghamneedalocksmith.locksmith;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.support.v4.content.ContextCompat;
import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addCallButtonListener();
        addSMSButtonListener();

        addWebsiteButtonListener();
        addFacebookButtonListener();
        addLinkedinButtonListener();
        addTwitterButtonListener();

        addAutoServicesButtonListener();
        addResidentialServicesButtonListener();
        addCommercialServicesButtonListener();

    }

    ///
    ///
    ///
    public void addCallButtonListener() {
        ImageButton button = (ImageButton) findViewById(R.id.callButton);
        final FragmentActivity thisActivity = this;
        button.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:+12052184842"));

                if (ContextCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(thisActivity,
                            new String[]{Manifest.permission.CALL_PHONE},
                            MY_PERMISSIONS_REQUEST_CALL_PHONE);
                } else {
                    //You already have permission
                    try {
                        startActivity(intent);
                    } catch(SecurityException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    ///
    ///
    ///
    public void addSMSButtonListener() {
        Button button = (Button) findViewById(R.id.smsButton);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse( "sms:+12052184842"));
                intent.putExtra( "sms_body", "Help us! We are locked out!" );
                startActivity(intent);
            }
        });
    }

    ///
    ///
    ///
    public void addWebsiteButtonListener() {
        ImageButton button = (ImageButton) findViewById(R.id.websiteButton);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent =
                        new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.birminghamneedalocksmith.com/"));
                startActivity(intent);
            }
        });
    }

    ///
    ///
    ///
    public void addFacebookButtonListener() {
        ImageButton button = (ImageButton) findViewById(R.id.facebookButton);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/thelocksmithco")));
                } catch (Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/thelocksmithco")));
                }
            }
        });
    }

    ///
    ///
    ///
    public void addLinkedinButtonListener() {
        ImageButton button = (ImageButton) findViewById(R.id.linkedInButton);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("linkedin://profile/the-locksmith-company-409198104")));
                } catch (Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/the-locksmith-company-409198104")));
                }
            }
        });
    }

    ///
    ///
    ///
    public void addTwitterButtonListener() {
        ImageButton button = (ImageButton) findViewById(R.id.twitterButton);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("twitter:///user?screen_name=locksmith121212")));
                } catch (Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/locksmith121212")));
                }
            }
        });
    }

    ///
    ///
    ///
    public void addAutoServicesButtonListener() {
        ImageButton button = (ImageButton) findViewById(R.id.autoButton);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                startActivity(new Intent(MainActivity.this, AutoServicesActivity.class));
            }
        });
    }

    ///
    ///
    ///
    public void addCommercialServicesButtonListener() {
        ImageButton button = (ImageButton) findViewById(R.id.commercialButton);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                startActivity(new Intent(MainActivity.this, CommercialServicesActivity.class));
            }
        });
    }

    ///
    ///
    ///
    public void addResidentialServicesButtonListener() {
        ImageButton button = (ImageButton) findViewById(R.id.resButton);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                startActivity(new Intent(MainActivity.this, ResidentialServicesActivity.class));
            }
        });
    }
}
