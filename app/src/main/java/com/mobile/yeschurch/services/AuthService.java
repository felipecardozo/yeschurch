package com.mobile.yeschurch.services;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.mobile.yeschurch.login.StandardLoginActivity;

public class AuthService {

    private FirebaseAuth firebaseAuth;
    private StandardLoginActivity context;
    private ProgressDialog progressDialog;
    private EditText textEmail;
    private EditText textPassword;

    public AuthService(StandardLoginActivity context, ProgressDialog progressDialog){
        firebaseAuth = FirebaseAuth.getInstance();
        this.context = context;
        this.progressDialog = progressDialog;
    }

    public void logIn(EditText textEmailInput, EditText textPasswordInput){
        this.textEmail = textEmailInput;
        this.textPassword = textPasswordInput;
        //Obtenemos el email y la contraseña desde las cajas de texto
        if( textEmail.getText().toString().isEmpty() ){
            textEmail.setText("alguien2@dominio.com");
            textPassword.setText("1234567");
        }
        final String email = textEmail.getText().toString().trim();
        String password = textPassword.getText().toString().trim();


        //Verificamos que las cajas de texto no esten vacías
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(context, "Se debe ingresar un email", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(context, "Falta ingresar la contraseña", Toast.LENGTH_LONG).show();
            return;
        }


        progressDialog.setMessage("Realizando Login...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Log.i("FIREBASE", "Login SUCCESS");
                }
                else {
                    Log.i("FIREBASE", "Login NOT SUCCESS");
                }
                progressDialog.dismiss();
            }
        });
    }

    public void signUp(){

    }

}
