package com.example.sandu_irina_1091;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class QuizScoreActivity extends AppCompatActivity {
    private Button btnReturnHome;
    private Button btnTryAgain;
    private TextView tvScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_score);
        initComponents();
    }

    private void initComponents() {
        btnReturnHome = findViewById(R.id.sandu_irina_home_btn_return);
        btnReturnHome.setOnClickListener(getReturnClickListener());
        btnTryAgain = findViewById(R.id.sandu_irina_home_btn_restart);
        btnTryAgain.setOnClickListener(getTryClickListener());
        tvScore = findViewById(R.id.sandu_irina_tv_score);
        Intent intent = getIntent();
        int score = intent.getIntExtra("score",0);
        tvScore.setText(getString(R.string.score)+" "+String.valueOf(score));
    }

    private View.OnClickListener getTryClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), QuizActivity.class);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener getReturnClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        };
    }
}