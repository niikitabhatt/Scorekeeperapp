package com.example.knbhatt.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;
import android.os.SystemClock;

public class secondactivity extends AppCompatActivity {
    private boolean running;
    private Chronometer chronometer;
    private long pauseOffset;
    int scorea = 0;
    int scoreb = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);

        chronometer = (Chronometer) findViewById(R.id.chronometer);
        chronometer.setFormat("%s");
        chronometer.setBase(SystemClock.elapsedRealtime());

        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if ((SystemClock.elapsedRealtime() - chronometer.getBase()) >= 10000) {
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    if (scorea > scoreb) {
                        Toast.makeText(secondactivity.this, "Team A won", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        if (scorea < scoreb) {
                            Toast.makeText(secondactivity.this, "Team B won", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(secondactivity.this, "Tie", Toast.LENGTH_SHORT).show();
                        }
                    }
                } }
        }
        );
    }

    public void startChronometer(View v){
        if(!running)
        {
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
            chronometer.start();
            running=true;
        }
    }

    public void pauseChronometer(View v){
        if (running){
            chronometer.stop();
            pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
            running= false;
        }

    }
    public void resetChronometer(View v){
        chronometer.setBase(SystemClock.elapsedRealtime());
        pauseOffset = 0;
    }
    public void score3a(View view) {
        scorea = scorea + 3;
        displayScoreA(scorea);
    }

    public void score2a(View view) {
        scorea = scorea + 2;
        displayScoreA(scorea);
    }

    public void freethrowa(View view) {
        scorea = scorea + 1;
        displayScoreA(scorea);
    }

    public void score3b(View view) {
        scoreb = scoreb + 3;
        displayScoreB(scoreb);
    }

    public void score2b(View view) {
        scoreb = scoreb + 2;
        displayScoreB(scoreb);
    }

    public void freethrowb(View view) {
        scoreb = scoreb + 1;
        displayScoreB(scoreb);
    }

    public void displayScoreA(int s) {
        TextView a = (TextView) findViewById(R.id.a_score);
        a.setText(String.valueOf(s));
    }

    public void displayScoreB(int s) {
        TextView b = (TextView) findViewById(R.id.b_score);
        b.setText(String.valueOf(s));
    }

    public void reset(View view) {
        scorea = 0;
        scoreb = 0;
        displayScoreA(scorea);
        displayScoreB(scoreb);
    }

}

