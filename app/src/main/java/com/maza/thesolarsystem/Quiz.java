package com.maza.thesolarsystem;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Quiz extends AppCompatActivity implements View.OnClickListener {

    public int chosenPlanetQ = 0;
    public int locationOfCorrectAnswer = 0;
    String[] planet_questions;
    String[] planet_answers;
    ArrayList<String> answers = new ArrayList<String>();
    TextView questionText;
    Button button0, button1, button2, button3;
    MediaPlayer mp1, mp2, mp3;
    int incorrectAnswerLocation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mp1 = MediaPlayer.create(getApplicationContext(), R.raw.buzzer);
        mp2 = MediaPlayer.create(getApplicationContext(), R.raw.bell);
        mp3 = MediaPlayer.create(getApplicationContext(), R.raw.tada);

        questionText = (TextView) findViewById(R.id.questionText);
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

        button0.setTag("0");
        button1.setTag("1");
        button2.setTag("2");
        button3.setTag("3");

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

        planet_questions = getResources().getStringArray(R.array.planet_questions);
        planet_answers = getResources().getStringArray(R.array.planet_answers);

        createNewQuestion();

    }

    public void createNewQuestion() {

        answers.clear();
        Random random = new Random();

        try {

            chosenPlanetQ = random.nextInt(planet_questions.length);

            locationOfCorrectAnswer = random.nextInt(4);


            for (int i = 0; i < 4; i++) {

                if (i == locationOfCorrectAnswer) {

                    questionText.setText(planet_questions[chosenPlanetQ]);
                    answers.add(i, planet_answers[chosenPlanetQ]);

                } else {

                    incorrectAnswerLocation = random.nextInt(chosenPlanetQ);

                    while (incorrectAnswerLocation == chosenPlanetQ) {

                        incorrectAnswerLocation = random.nextInt(chosenPlanetQ);

                    }

                    answers.add(i, planet_answers[incorrectAnswerLocation]);

                    if (answers.contains(planet_answers[incorrectAnswerLocation].toString())) {
                        incorrectAnswerLocation = random.nextInt(chosenPlanetQ);
                        answers.add(i, planet_answers[incorrectAnswerLocation]);

                    }

                }
            }

                button0.setText(answers.get(0));
                button1.setText(answers.get(1));
                button2.setText(answers.get(2));
                button3.setText(answers.get(3));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        String tag = v.getTag().toString();

        if ((Integer.parseInt(tag)) == locationOfCorrectAnswer) {
            mp2.start();
            createNewQuestion();
        } else {
            mp1.start();
        }
        createNewQuestion();

    }

}
