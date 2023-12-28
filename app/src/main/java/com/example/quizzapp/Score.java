package com.example.quizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Score extends AppCompatActivity {
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        Intent intent = getIntent();
        Button tr,logout;
        int score = intent.getIntExtra("score", 0);
        auth= FirebaseAuth.getInstance();

        int maxScore = 10;
        int pourcentage = (score * 100) / 100;
        tr= findViewById(R.id.ScoreTryAgain);
        logout= findViewById(R.id.ScoreLogout);

        TextView tvScore = findViewById(R.id.finalscore);
        ProgressBar circle = findViewById(R.id.circle);
        circle.setProgress(score);
        tvScore.setText(score + "%");
        tr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Score.this, Quiz1.class);
                startActivity(intent);

            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signOut();
                Intent intent = new Intent(Score.this, Login.class);
                startActivity(intent);

            }
        });


    }
}