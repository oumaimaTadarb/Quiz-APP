package com.example.quizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Quiz5 extends AppCompatActivity {

    private int score ,scoreN;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz5);

        RadioGroup radioGroup = findViewById(R.id.Q5rg);
        RadioButton ouiRadioButton = findViewById(R.id.Q5o);
        RadioButton nonRadioButton = findViewById(R.id.Q5n);
        Button nextButton = findViewById(R.id.Q5next);

        Intent intent = getIntent();
        if (intent.hasExtra("score")) {
            score = intent.getIntExtra("score", 0);
        }

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedId);
                String userResponse = selectedRadioButton.getText().toString();
                if (radioGroup.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(Quiz5.this,"Choose a answer "+score,Toast.LENGTH_LONG).show();
                    return;
                }
                if(userResponse.equals("80km/h")) score=score+20;
                Toast.makeText(Quiz5.this,"Score "+score,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Quiz5.this, Score.class);
                intent.putExtra("score",score);
                startActivity(intent);

                radioGroup.clearCheck();
            }
        });
    }
}