package com.example.quizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Quiz2 extends AppCompatActivity {

    private int score ;
    private int oldscore;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);

        RadioGroup radioGroup = findViewById(R.id.Q2rg);
        RadioButton ouiRadioButton = findViewById(R.id.Q2o);
        RadioButton nonRadioButton = findViewById(R.id.Q2n);
        Button nextButton = findViewById(R.id.Q2next);

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
                    Toast.makeText(Quiz2.this,"Choose a answer "+score,Toast.LENGTH_LONG).show();
                    return;
                }
                String userResponse = selectedRadioButton.getText().toString();
                if(userResponse.equals("Non")) score=score+20;
                Toast.makeText(Quiz2.this,"Score "+score,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Quiz2.this, Quiz3.class);
                intent.putExtra("score",score);
                startActivity(intent);
                radioGroup.clearCheck();

            }
        });
    }
}