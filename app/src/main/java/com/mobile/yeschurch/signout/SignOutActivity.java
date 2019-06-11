package com.mobile.yeschurch.signout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.mobile.yeschurch.R;

public class SignOutActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_out);
        setTitle("Chau !");

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signOut();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if( firebaseUser==null ){
            Log.i("FIREBASE", "Signed out " );
        }

    }
}
