package nrv.bstu.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button answer1,answer2,answer3,answer4;

    ProgressBar progressbar;

    TextView score, question, timer;

    private Questions mQuestions = new Questions();

    public CountDownTimer countDownTimer;

    private String mAnswer;
    public int mScore = 0;
    private int mQuestionsLength = mQuestions.mQuestions.length;

    Random r;

    public int timeLeft = 15000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r = new Random();

        progressbar = (ProgressBar) findViewById(R.id.progressBar);

        answer1 = (Button) findViewById(R.id.answer1);
        answer2 = (Button) findViewById(R.id.answer2);
        answer3 = (Button) findViewById(R.id.answer3);
        answer4 = (Button) findViewById(R.id.answer4);

        score = (TextView) findViewById(R.id.score);
        question = (TextView) findViewById(R.id.question);
        timer = (TextView) findViewById(R.id.Timer);

        score.setText("Score: " + mScore);

        if(mScore == 10){
            youWin();
        }

        updateQuestion(r.nextInt(mQuestionsLength));

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answer1.getText() == mAnswer){
                    mScore++;
                    score.setText("Score: " + mScore);
                    updateQuestion(r.nextInt(mQuestionsLength));
                    countDownTimer.cancel();
                    callTimer();
                    if(mScore == 10){
                        youWin();
                    }
                }else{
                    gameOver();
                }
            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answer2.getText() == mAnswer){
                    mScore++;
                    score.setText("Score: " + mScore);
                    updateQuestion(r.nextInt(mQuestionsLength));
                    countDownTimer.cancel();
                    callTimer();
                    if(mScore == 10){
                        youWin();
                    }
                }else{
                    gameOver();
                }
            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answer3.getText() == mAnswer){
                    mScore++;
                    score.setText("Score: " + mScore);
                    updateQuestion(r.nextInt(mQuestionsLength));
                    countDownTimer.cancel();
                    callTimer();
                    if(mScore == 10){
                        youWin();
                    }
                }else{
                    gameOver();
                }
            }
        });

        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answer4.getText() == mAnswer){
                    mScore++;
                    score.setText("Score: " + mScore);
                    updateQuestion(r.nextInt(mQuestionsLength));
                    countDownTimer.cancel();
                    callTimer();
                    if(mScore == 10){
                        youWin();
                    }
                }else{
                    gameOver();
                }
            }
        });

        callTimer();
    }

    private void  updateQuestion(int num) {
        question.setText(mQuestions.getQuestion(num));

        answer1.setText(mQuestions.getChoice1(num));
        answer2.setText(mQuestions.getChoice2(num));
        answer3.setText(mQuestions.getChoice3(num));
        answer4.setText(mQuestions.getChoice4(num));

        mAnswer = mQuestions.getCorrectAnser(num);
    }

    private void gameOver(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder
                .setMessage("Game Over! Your score is: " + mScore + " points.")
                .setCancelable(false)
                .setPositiveButton("New Game", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();
                    }
                })
                .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
        countDownTimer.cancel();
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void youWin(){

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
            alertDialogBuilder
                    .setCancelable(false)
                    .setMessage("You win! Congratulations! Your score is: " + mScore + " points.")
                    .setPositiveButton("New Game", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            finish();
                        }
                    })
                    .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    });
            countDownTimer.cancel();
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

    }

    public void callTimer(){
        countDownTimer = new CountDownTimer(timeLeft, 1000){

            @Override
            public void onTick(long l) {
                timer.setText("" + l/1000);
                progressbar.setProgress((int) (l/1000));
                if(l <= 6000){
                    timer.setTextColor(Color.RED);
                }
                if(l >= 6000){
                    timer.setTextColor(Color.GRAY);
                }
            }

            @Override
            public void onFinish() {
                timer.setText("0");
                gameOver();
            }
        }.start();
    }


}
