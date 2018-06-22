package com.bangunanbersejarah.masyarakat.bangunanbersejarah.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bangunanbersejarah.masyarakat.bangunanbersejarah.R;
import com.bangunanbersejarah.masyarakat.bangunanbersejarah.model.SoalQuiz;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class QuizActivity extends AppCompatActivity {

    @BindView(R.id.txt_question)
    TextView txtQuestion;
    @BindView(R.id.txt_answer_one)
    TextView txtAnswerOne;
    @BindView(R.id.txt_answer_two)
    TextView txtAnswerTwo;
    @BindView(R.id.txt_answer_three)
    TextView txtAnswerThree;
    @BindView(R.id.txt_answer_four)
    TextView txtAnswerFour;

    @BindView(R.id.btn_next)
    Button btnNext;
    @BindView(R.id.btn_back)
    Button btnBack;

    int question = 0, point = 0;

    List<SoalQuiz> listSoal = new ArrayList<>();
    List<String> listJawaban = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Quiz Bangunan Bersejarah");

        ButterKnife.bind(this);

        initSoal();

        setQuestion(question);
    }

    public void setAnswer(String answer){
        switch (answer){
            case "A" : {
                txtAnswerOne.setTextColor(getResources().getColor(R.color.colorPrimary));
                break;
            }
            case "B" : {
                txtAnswerTwo.setTextColor(getResources().getColor(R.color.colorPrimary));
                break;
            }
            case "C" : {
                txtAnswerThree.setTextColor(getResources().getColor(R.color.colorPrimary));
                break;
            }
            case "D" : {
                txtAnswerFour.setTextColor(getResources().getColor(R.color.colorPrimary));
                break;
            }
            case "-" : {
                txtAnswerOne.setTextColor(getResources().getColor(R.color.colorAccent));
                txtAnswerTwo.setTextColor(getResources().getColor(R.color.colorAccent));
                txtAnswerThree.setTextColor(getResources().getColor(R.color.colorAccent));
                txtAnswerFour.setTextColor(getResources().getColor(R.color.colorAccent));
            }
        }
    }

    public void setQuestion(int question){
        if(question<10){
            SoalQuiz soal = listSoal.get(question);
            txtQuestion.setText(soal.getQuestion());
            txtAnswerOne.setText(soal.getAnswerOne());
            txtAnswerTwo.setText(soal.getAnswerTwo());
            txtAnswerThree.setText(soal.getAnswerThree());
            txtAnswerFour.setText(soal.getAnswerFour());
        }

        switch (question){
            case 0 : {
                btnBack.setVisibility(View.INVISIBLE);
                btnNext.setVisibility(View.VISIBLE);
                break;
            }
            case 1 : {
                btnBack.setVisibility(View.VISIBLE);
                btnNext.setVisibility(View.VISIBLE);
                break;
            }
            case 2 : {
                btnBack.setVisibility(View.VISIBLE);
                btnNext.setVisibility(View.VISIBLE);
                break;
            }
            case 3 : {
                btnBack.setVisibility(View.VISIBLE);
                btnNext.setVisibility(View.VISIBLE);
                break;
            }
            case 4 : {
                btnBack.setVisibility(View.VISIBLE);
                btnNext.setVisibility(View.VISIBLE);
                break;
            }
            case 5 : {
                btnBack.setVisibility(View.VISIBLE);
                btnNext.setVisibility(View.VISIBLE);
                break;
            }
            case 6 : {
                btnBack.setVisibility(View.VISIBLE);
                btnNext.setVisibility(View.VISIBLE);
                break;
            }
            case 7 : {
                btnBack.setVisibility(View.VISIBLE);
                btnNext.setVisibility(View.VISIBLE);
                break;
            }
            case 8 : {
                btnBack.setVisibility(View.VISIBLE);
                btnNext.setVisibility(View.VISIBLE);
                break;
            }
            case 9 : {
                btnBack.setVisibility(View.VISIBLE);
                btnNext.setVisibility(View.INVISIBLE);
                break;
            }
            case 10 : {
                for(int i=0; i<10; i++){
                    if(listSoal.get(i).getCorrectAnswer().equalsIgnoreCase(listJawaban.get(i))){
                        point++;
                    }
                }
                new AlertDialog.Builder(this)
                        .setTitle("Total Nilai : ")
                        .setMessage(""+point)
                        .setCancelable(false)
                        .setPositiveButton("Kembali", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .show();
                break;
            }
        }
    }

    @OnClick(R.id.txt_answer_one)
    public void answerOne(){
        if(question<10){
            listJawaban.set(question, "A");
            question++;
            setQuestion(question);
        }
    }

    @OnClick(R.id.txt_answer_two)
    public void answerTwo(){
        if(question<10){
            listJawaban.set(question, "B");
            question++;
            setQuestion(question);
        }
    }

    @OnClick(R.id.txt_answer_three)
    public void answerThree(){
        if(question<10){
            listJawaban.set(question, "C");
            question++;
            setQuestion(question);
        }
    }

    @OnClick(R.id.txt_answer_four)
    public void answerFour(){
        if(question<10){
            listJawaban.set(question, "D");
            question++;
            setQuestion(question);
        }
    }

    public void initSoal(){
        listSoal.add(new SoalQuiz("Pertanyaan 1", "Opsi A1", "Opsi B1", "Opsi C1", "Opsi D1", "A"));
        listSoal.add(new SoalQuiz("Pertanyaan 2", "Opsi A2", "Opsi B2", "Opsi C2", "Opsi D2", "B"));
        listSoal.add(new SoalQuiz("Pertanyaan 3", "Opsi A3", "Opsi B3", "Opsi C3", "Opsi D3", "C"));
        listSoal.add(new SoalQuiz("Pertanyaan 4", "Opsi A4", "Opsi B4", "Opsi C4", "Opsi D4", "D"));
        listSoal.add(new SoalQuiz("Pertanyaan 5", "Opsi A5", "Opsi B5", "Opsi C5", "Opsi D5", "A"));
        listSoal.add(new SoalQuiz("Pertanyaan 6", "Opsi A6", "Opsi B6", "Opsi C6", "Opsi D6", "B"));
        listSoal.add(new SoalQuiz("Pertanyaan 7", "Opsi A7", "Opsi B7", "Opsi C7", "Opsi D7", "C"));
        listSoal.add(new SoalQuiz("Pertanyaan 8", "Opsi A8", "Opsi B8", "Opsi C8", "Opsi D8", "D"));
        listSoal.add(new SoalQuiz("Pertanyaan 9", "Opsi A9", "Opsi B9", "Opsi C9", "Opsi D9", "A"));
        listSoal.add(new SoalQuiz("Pertanyaan 10", "Opsi A10", "Opsi B10", "Opsi C10", "Opsi D10", "B"));

        for(int i=0;i<10;i++){
            listJawaban.add("-");
        }
    }

    @OnClick(R.id.btn_next)
    public void nextQuestion(){
        question++;
        setQuestion(question);
    }

    @OnClick(R.id.btn_back)
    public void backQuestion(){
        question--;
        setQuestion(question);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home : {
                finish();
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
