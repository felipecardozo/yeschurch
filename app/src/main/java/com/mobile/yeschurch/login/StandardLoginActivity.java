package com.mobile.yeschurch.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.mobile.yeschurch.MapsActivity;
import com.mobile.yeschurch.R;
import com.mobile.yeschurch.services.AuthService;
import com.mobile.yeschurch.signUp.SignUpActivity;
import com.mobile.yeschurch.util.ChurchUtils;

public class StandardLoginActivity extends AppCompatActivity {

    private EditText textEmail;
    private EditText textPassword;
    private Button buttonSignIn;
    private Button buttonLogIn;
    private ProgressDialog progressDialog;
    private AuthService authService;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard_login);
        setTitle("Log In or Sign Up");

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        if( firebaseUser!= null && firebaseUser.getEmail()!= null ){
            String email = firebaseUser.getEmail();
            if( email != null && !email.isEmpty()){
                startActivity(new Intent(this, MapsActivity.class));
            }
        }



        progressDialog = new ProgressDialog(this);
        authService = new AuthService(this, progressDialog);

        textEmail = findViewById(R.id.emailText);
        textPassword = findViewById(R.id.passwordText);

        buttonSignIn = (Button) findViewById(R.id.buttonSignUp);
        buttonLogIn = (Button) findViewById(R.id.buttonLogin2);
        buttonLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                authService.logIn(textEmail, textPassword);
            }
        });

        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextActivity(SignUpActivity.class);
            }
        });
    }

    private void nextActivity(Class clazz){
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

}
