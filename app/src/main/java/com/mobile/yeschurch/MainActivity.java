package com.mobile.yeschurch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mapsButtons;
    private Button logInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapsButtons = (Button) findViewById(R.id.buttonMaps);

        mapsButtons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextActivity(MapsActivity.class);
            }
        });

        logInButton = findViewById(R.id.buttonLogin);
        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextActivity(LoginActivity.class);
            }
        });
    }

    private void nextActivity(Class clazz){
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }
}
