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

import com.example.sandu_irina_1091.util.Question;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {
    private TextView tv_question;
    private TextView tv_progress;
    private Button btn_opt1,btn_opt2,btn_opt3,btn_opt4;
    private ArrayList<Question> al_QuizList;
    Random random;
    int score=0, position, progress=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        initComponents();
    }

    private void initComponents() {
        tv_question=findViewById(R.id.sandu_irina_quiz_tv_letter);
        tv_progress=findViewById(R.id.sandu_irina_quiz_tv_progress);
        btn_opt1=findViewById(R.id.sandu_irina_quiz_opt1);
        btn_opt2=findViewById(R.id.sandu_irina_quiz_opt2);
        btn_opt3=findViewById(R.id.sandu_irina_quiz_opt3);
        random=new Random();
        al_QuizList= new ArrayList<>();
        getQuestions(al_QuizList);
        position =random.nextInt(al_QuizList.size());
        ChangeQuestion(position);
        btn_opt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Verif",al_QuizList.get(position).getAnswer().toString()+" "+btn_opt1.getText().toString()+al_QuizList.get(position).getAnswer().equals(btn_opt1.getText().toString()));

                if(al_QuizList.get(position).getAnswer().trim().equals(btn_opt1.getText().toString().trim())){
                    score++;
                }
                progress++;
                position = random.nextInt(al_QuizList.size());
                ChangeQuestion(position);

            }
        });
        btn_opt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Verif",al_QuizList.get(position).getAnswer().toString()+" "+btn_opt2.getText().toString()+al_QuizList.get(position).getAnswer().equals(btn_opt2.getText().toString()));

                if(al_QuizList.get(position).getAnswer().trim().equals(btn_opt2.getText().toString().trim())){
                    score++;
                }
                progress++;
                position = random.nextInt(al_QuizList.size());
                ChangeQuestion(position);
            }
        });
        btn_opt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Verif",al_QuizList.get(position).getAnswer().toString()+" "+btn_opt3.getText().toString()+al_QuizList.get(position).getAnswer().equals(btn_opt3.getText().toString()));
                if(al_QuizList.get(position).getAnswer().equals(btn_opt3.getText().toString())){
                    score++;
                }
                progress++;
                position = random.nextInt(al_QuizList.size());
                ChangeQuestion(position);

            }
        });
    }
    private void getQuestions(ArrayList<Question> al_quizList) {
        al_quizList.add(new Question(getString(R.string.g),getString(R.string.giyeok),getString(R.string.nieun),getString(R.string.rieul),getString(R.string.giyeok)));
        al_quizList.add(new Question(getString(R.string.u),getString(R.string.o_k),getString(R.string.u_k),getString(R.string.yu),getString(R.string.u_k)));
        al_quizList.add(new Question(getString(R.string.m),getString(R.string.mieum),getString(R.string.nieun),getString(R.string.bieup),getString(R.string.mieum)));
        al_quizList.add(new Question(getString(R.string.eo),getString(R.string.ae),getString(R.string.e_k),getString(R.string.eo_k),getString(R.string.eo_k)));
        al_quizList.add(new Question(getString(R.string.s),getString(R.string.jieut),getString(R.string.siot),getString(R.string.chieut),getString(R.string.siot)));
        al_quizList.add(new Question(getString(R.string.ye),getString(R.string.ye_k),getString(R.string.yeo_k),getString(R.string.e_k),getString(R.string.ye_k)));
        al_quizList.add(new Question(getString(R.string.d),getString(R.string.mieum),getString(R.string.digeut),getString(R.string.tieut),getString(R.string.digeut)));
        al_quizList.add(new Question(getString(R.string.wa),getString(R.string.wo_k),getString(R.string.we_k),getString(R.string.wa_k),getString(R.string.wa_k)));
        al_quizList.add(new Question(getString(R.string.k),getString(R.string.giyeok),getString(R.string.kieuk),getString(R.string.tieut),getString(R.string.kieuk)));
        al_quizList.add(new Question(getString(R.string.i),getString(R.string.i_k),getString(R.string.eu_k),getString(R.string.eo_k),getString(R.string.i_k)));
    }
    private void ChangeQuestion(int position) {
        tv_progress.setText("Progress: "+ progress +"/10");
        if(progress==10){
            GetScore();
        }
        else
        {
            tv_question.setText(al_QuizList.get(position).getQuestion());
            btn_opt1.setText(al_QuizList.get(position).getOpt1());
            btn_opt2.setText(al_QuizList.get(position).getOpt2());
            btn_opt3.setText(al_QuizList.get(position).getOpt3());
        }

    }
    private void GetScore()
    {
        Intent intent = new Intent(getApplicationContext(), QuizScoreActivity.class);
        intent.putExtra("score", score);
        startActivity(intent);
    }


}