package com.example.sandu_irina_1091;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BeginActivity extends AppCompatActivity {
    private Button btnDone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin);
        initComponents();
    }

    private void initComponents() {
        btnDone = findViewById(R.id.sandu_irina_home_btn_done);
        btnDone.setOnClickListener(getDoneClickListener());
    }

    private View.OnClickListener getDoneClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        };
    }
}