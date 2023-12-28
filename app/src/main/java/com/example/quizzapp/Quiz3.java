package com.example.quizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Quiz3 extends AppCompatActivity {

    private int score ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz3);

        // Référencement des composants du layout
        RadioGroup radioGroup = findViewById(R.id.Q3rg);
        RadioButton ouiRadioButton = findViewById(R.id.Q3o);
        RadioButton nonRadioButton = findViewById(R.id.Q3n);
        Button nextButton = findViewById(R.id.Q3next);

        Intent intent = getIntent();
        if (intent.hasExtra("score")) {
            score = intent.getIntExtra("score", 0);
        }

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Récupérer la réponse de l'utilisateur
                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedId);
                String userResponse = selectedRadioButton.getText().toString();
                if (radioGroup.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(Quiz3.this,"Choose a answer "+score,Toast.LENGTH_LONG).show();
                    return;
                }
                if(userResponse.equals("100km/h")) score=score+20;
                Toast.makeText(Quiz3.this,"Score "+score,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Quiz3.this, Quiz4.class);
                intent.putExtra("score",score);
                startActivity(intent);

                radioGroup.clearCheck();
            }
        });
    }
}