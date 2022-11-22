package com.example.sandu_irina_1091;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private AppCompatButton btnHomeQuiz;
    private AppCompatButton btnHomeBegin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }

    private void initComponents() {
        btnHomeQuiz = findViewById(R.id.sandu_irina_home_btn_quiz);
        btnHomeQuiz.setOnClickListener(getQuizClickListener());
        btnHomeBegin = findViewById(R.id.sandu_irina_home_btn_begin);
        btnHomeBegin.setOnClickListener(getBeginClickListener());
    }

    private View.OnClickListener getBeginClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BeginActivity.class);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener getQuizClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), QuizActivity.class);
                startActivity(intent);
            }
        };
    }


}