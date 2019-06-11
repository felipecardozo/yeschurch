package com.mobile.yeschurch.profile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.mobile.yeschurch.R;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        setTitle("Perfil");

        EditText editText = findViewById(R.id.emailText);
        EditText fisrtNameText = findViewById(R.id.editFirstName);
        EditText lastNameText = findViewById(R.id.editLastName);
        fisrtNameText.setText("John");
        lastNameText.setText("Doe");
        editText.setEnabled(false);
        Intent intent = getIntent();
        String email = intent.getStringExtra("email");

        if(email != null)
            editText.setText(email);
    }
}
