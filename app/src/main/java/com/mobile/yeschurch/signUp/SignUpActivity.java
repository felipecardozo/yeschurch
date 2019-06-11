package com.mobile.yeschurch.signUp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mobile.yeschurch.MapsActivity;
import com.mobile.yeschurch.R;
import com.mobile.yeschurch.services.AuthService;

public class SignUpActivity extends AppCompatActivity {

    private EditText textEmail;
    private EditText textPassword;
    private AuthService authService;
    private ProgressDialog progressDialog;
    private Button buttonSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        setTitle("Crear cuenta");

        progressDialog = new ProgressDialog(this);
        authService = new AuthService(this, progressDialog);

        textEmail = findViewById(R.id.emailText);
        textPassword = findViewById(R.id.passwordText);

        buttonSignIn = (Button) findViewById(R.id.buttonSignUp);
        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                authService.signUp(textEmail, textPassword);
            }
        });

    }

    private void nextActivity(Class clazz){
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }
}
