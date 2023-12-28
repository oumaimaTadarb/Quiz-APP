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

public class Register extends AppCompatActivity {
    EditText emailText , passwordText, nameText,confirmPassword;
    Button register;
    FirebaseAuth auth;
    TextView toLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        emailText =  findViewById(R.id.emailR);
        passwordText = findViewById(R.id.passwordR);
        nameText= findViewById(R.id.nameR);
        register= findViewById(R.id.register);
        auth= FirebaseAuth.getInstance();
        toLogin = findViewById(R.id.tologin);
        confirmPassword =findViewById(R.id.confirmPasswordR);

        toLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);


            }
        });
        register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String name,email, password, confpassword;
                email = String.valueOf(emailText.getText());
                password= String.valueOf(passwordText.getText());
                confpassword=String.valueOf(confirmPassword.getText());
                name = String.valueOf(nameText.getText());


                //verifier si les champs sont vides
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(Register.this,"Enter the email",Toast.LENGTH_SHORT).show();
                    return;

                }
                if(TextUtils.isEmpty(name)){
                    Toast.makeText(Register.this,"Enter the name",Toast.LENGTH_SHORT).show();
                    return;

                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(Register.this,"Enter the password",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!confpassword.equals(password)) {
                    Toast.makeText(Register.this,"Passwords dosen't match",Toast.LENGTH_SHORT).show();
                    return;
                }

                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener( Register.this,new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Register.this, "Compte crée ",
                                            Toast.LENGTH_LONG).show();
                                } else {

                                    Toast.makeText(Register.this, "Authentication failed.",
                                            Toast.LENGTH_LONG).show();

                                }
                            }
                        });
            }
        });

    }
}