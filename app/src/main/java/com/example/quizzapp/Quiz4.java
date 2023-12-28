package com.example.quizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Quiz4 extends AppCompatActivity {

    private int score ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz4);

        // Référencement des composants du layout
        RadioGroup radioGroup = findViewById(R.id.Q4rg);
        RadioButton ouiRadioButton = findViewById(R.id.Q4o);
        RadioButton nonRadioButton = findViewById(R.id.Q4n);
        Button nextButton = findViewById(R.id.Q4next);

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
                    Toast.makeText(Quiz4.this,"Choose a answer "+score,Toast.LENGTH_LONG).show();
                    return;
                }
                if(userResponse.equals("Un virage")) score=score+20;
                Toast.makeText(Quiz4.this,"Score "+score,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Quiz4.this, Quiz5.class);
                intent.putExtra("score",score);
                startActivity(intent);

                radioGroup.clearCheck();
            }
        });
    }
}