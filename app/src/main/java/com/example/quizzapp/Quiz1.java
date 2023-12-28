package com.example.quizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz1 extends AppCompatActivity {
    private int score = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);
        RadioGroup radioGroup = findViewById(R.id.Q1rg);
        RadioButton ouiRadioButton = findViewById(R.id.Q1o);
        RadioButton nonRadioButton = findViewById(R.id.Q1n);
        Button nextButton = findViewById(R.id.Q1next);

        Intent intent = getIntent();
        if (intent.hasExtra("score")) {
            score = intent.getIntExtra("score", 0);
        }


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedId);

                if (radioGroup.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(Quiz1.this,"Choose a answer "+score,Toast.LENGTH_LONG).show();
                    return;
                }

                    String userResponse = selectedRadioButton.getText().toString();
                if(userResponse.equals("Une entrée d'aire piétonne")) score=score+20;
                Toast.makeText(Quiz1.this,"Score "+score,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Quiz1.this, Quiz2.class);
                intent.putExtra("score",score);
                startActivity(intent);

                radioGroup.clearCheck();
            }
        });
    }
}