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
        listSoal.add(new SoalQuiz("Tempat untuk menyimpan benda-benda bersejarah adalah..", "Situs", "Monumen", "Museum", "Laboratorium", "C"));
        listSoal.add(new SoalQuiz("Contoh peninggalan sejarah bangunan adalah..", "Arca", "Peralatan", "Candi", "Naskah kuno", "C"));
        listSoal.add(new SoalQuiz("Bangunan besar yang terbuat dari batu atau batu bata disebut..", "Pure", "Candi", "Masjid", "Wihara", "B"));
        listSoal.add(new SoalQuiz("Tempat penemuan benda-benda peninggalan sejarah disebut..", "Situs", "Monumen", "Museum", "Laboratorium", "A"));
        listSoal.add(new SoalQuiz("Dalam rangka menjaga, melindungi, dan melestarikan benda-benda sejarah dan purbakala, pemerintah Indonesia menerbitkan Undang-undang Republik Indonesia Nomor 5 Tahun 1992 tentang..", "Benda cagar budaya dan Penjelasannya", "Benda-benda asing dan perawatannya", "Bangunan bersejarah dan pemugarannya", "Benda-benda antik dan perawatannya", "A"));
        listSoal.add(new SoalQuiz("Berikut ini adalah tindakan yang dapat merusak benda bersejarah..", "Berfoto di bangunan sejarah", "Melukis benda-benda bersejarah", "Mencoret benda bersejarah", "Meneliti benda bersejarah", "C"));
        listSoal.add(new SoalQuiz("Peninggalan sejarah banyak dimanfaatkan sebagai..", "Bahan bangunan", "Objek wisata", "Tempat pembuangan", "Sumber makanan", "B"));
        listSoal.add(new SoalQuiz("Berikut yang tidak termasuk peninggalan sejarah di indonesia adalah..", "Candi", "Masjid", "Benteng", "Bandara", "D"));
        listSoal.add(new SoalQuiz("Masjid, candi, benteng dan pura merupakan peninggalan sejarah yang berupa..", "Sumber makanan", "Objek wisata", "Bangunan", " Tempat pembuangan", "C"));
        listSoal.add(new SoalQuiz("Suatu bangunan yang didirikan untuk memperingati suatu insiden atau kejadian bersejarah disebut..", "Tugu/monumen", "Taman", "Museum", "Lab", "A"));

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
