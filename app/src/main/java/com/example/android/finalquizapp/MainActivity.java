package com.example.android.finalquizapp;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.finalquizapp.R;

public class MainActivity extends AppCompatActivity {

    /**
     * This tracks the score for correct answers
     */
    int score;

    private TextView whatYearQuestion;
    private RadioButton question2Amy;
    private RadioButton question3Crossbow;
    private CheckBox question4Maggie;
    private CheckBox question4Hershal;
    private CheckBox question4Carl;
    private CheckBox question4Rick;
    private CheckBox question4Abraham;
    private RadioGroup groupQuestion3;
    private RadioGroup groupQuestion2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        whatYearQuestion = findViewById(R.id.what_year);
        question2Amy = findViewById(R.id.amy);
        question3Crossbow = findViewById(R.id.crossbow);
        question4Maggie = findViewById(R.id.maggie);
        question4Hershal = findViewById(R.id.hershal);
        question4Carl = findViewById(R.id.carl);
        question4Rick = findViewById(R.id.rick);
        question4Abraham = findViewById(R.id.abraham);
        groupQuestion3 = findViewById(R.id.group_question_3);
        groupQuestion2 = findViewById(R.id.group_question_2);

    }


    /**
     * This method is called when the Check the Answer button is clicked.
     */
    public void submitAnswers(View view) {

        score = 0;

        // Question 1 answer is 2010
        String firstEpisodeYearAnswer = whatYearQuestion.getText().toString();
        if (!TextUtils.isEmpty(firstEpisodeYearAnswer) && TextUtils.isDigitsOnly(firstEpisodeYearAnswer)) {
            int firstEpisodeAnswer = Integer.parseInt(firstEpisodeYearAnswer);
            if (firstEpisodeAnswer == 2010) {
                score = score + 1;
            }
        }


        // Question 2 answer is Amy
        boolean amyChecked = question2Amy.isChecked();
        if (amyChecked) {
            score = score + 1;
        }

        // Question 3 answer is crossbow
        boolean crossbowChecked = question3Crossbow.isChecked();
        if (crossbowChecked) {
            score = score + 1;
        }

        //  Question 4 answers are Maggie and Rick
        boolean maggieChecked = question4Maggie.isChecked();
        boolean hershalChecked = question4Hershal.isChecked();
        boolean carlChecked = question4Carl.isChecked();
        boolean rickChecked = question4Rick.isChecked();
        boolean abrahamChecked = question4Abraham.isChecked();
        boolean correctAnswer = false;

        if (rickChecked && maggieChecked) {
            correctAnswer = true;
        }

        if (hershalChecked) {
            correctAnswer = false;
        }
        if (carlChecked) {
            correctAnswer = false;
        }
        if (abrahamChecked) {
            correctAnswer = false;
        }

        if (correctAnswer) {
            score++;
        }


        // Toast displays at bottom of screen showing score
        if (score == 0) {
            Toast.makeText(getApplicationContext(), "You scored " + score + " out of 4 points.", Toast.LENGTH_LONG).show();
        } else if (score == 1) {
            Toast.makeText(getApplicationContext(), "You scored " + score + " out of 4 points.", Toast.LENGTH_LONG).show();
        } else if (score == 2) {
            Toast.makeText(getApplicationContext(), "You scored " + score + " out of 4 points.", Toast.LENGTH_LONG).show();
        } else if (score == 3) {
            Toast.makeText(getApplicationContext(), "You scored " + score + " out of 4 points.", Toast.LENGTH_LONG).show();
        } else if (score == 4) {
            Toast.makeText(getApplicationContext(), "Congrats! You got them all correct! You're a super fan!", Toast.LENGTH_LONG).show();
        }

    }


    /**
     * This method resets the quiz back to starting set up
     */
    public void resetQuiz(View View) {
        score = 0;
        whatYearQuestion.setText("");
        groupQuestion3.clearCheck();
        groupQuestion2.clearCheck();
        question4Abraham.setChecked(false);
        question4Carl.setChecked(false);
        question4Maggie.setChecked(false);
        question4Rick.setChecked(false);
        question4Hershal.setChecked(false);
    }
}