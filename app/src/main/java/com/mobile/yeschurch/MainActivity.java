package com.mobile.yeschurch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mobile.yeschurch.login.StandardLoginActivity;

public class MainActivity extends AppCompatActivity {

    private Button mapsButtons;
    private Button logInButton;
    private Button detailButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logInButton = findViewById(R.id.buttonLogin);
        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextActivity(LoginActivity.class);
            }
        });

        mapsButtons = (Button) findViewById(R.id.buttonMaps);
        mapsButtons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextActivity(MapsActivity.class);
            }
        });

        detailButton = findViewById(R.id.buttonDetail);
        detailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextActivity(DetailActivity.class);
            }
        });

        Button slideButton = (Button) findViewById(R.id.buttonSlide);
        slideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextActivity(SlideActivity.class);
            }
        });

        Button login2 = (Button) findViewById(R.id.buttonLogin2);
        login2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextActivity(StandardLoginActivity.class);
            }
        });
    }

    private void nextActivity(Class clazz){
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }
}
