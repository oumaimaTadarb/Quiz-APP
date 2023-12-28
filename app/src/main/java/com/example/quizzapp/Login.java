package com.example.quizzapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText emailText , passwordText;
    Button login;
    FirebaseAuth auth;
    TextView toRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailText =  findViewById(R.id.email);
        passwordText = findViewById(R.id.password);
        login= findViewById(R.id.login);
        auth= FirebaseAuth.getInstance();
        toRegister = findViewById(R.id.toregister);
        toRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Register.class);
                startActivity(intent);

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name,email, pasword;
                email = String.valueOf(emailText.getText());
                pasword= String.valueOf(passwordText.getText());

                //verifier si les champs sont vides
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(Login.this,"Enter the email",Toast.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty(pasword)){
                    Toast.makeText(Login.this,"Enter the password",Toast.LENGTH_LONG).show();
                    return;
                }
                auth.signInWithEmailAndPassword(email, pasword)
                        .addOnCompleteListener(Login.this,new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(), "login successful.", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(Login.this,Quiz1.class);
                                    startActivity(intent);

                                }
                                else {
                                    Toast.makeText(Login.this, "Authentication failed.",  Toast.LENGTH_LONG).show();
                                }
                            }
                        });

            }
        });
    }
}