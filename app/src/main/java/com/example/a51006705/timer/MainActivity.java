package com.example.a51006705.timer;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Chronometer chronometer;
    private long pauseOffSet;
    private boolean timerRunning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chronometer = (findViewById(R.id.chronometer));
        chronometer.setFormat("Time: %s");
        //for setting base what to show: like "Time: "00:00
        chronometer.setBase(SystemClock.elapsedRealtime());
        //to inform user 10 secs has been up
     /*   chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if((SystemClock.elapsedRealtime() - chronometer.getBase()) >= 10000){
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    Toast.makeText(MainActivity.this, "Time's up",Toast.LENGTH_SHORT).show();
                }
            }
        }); */
    }

    public void startChronometer(View view) {
        if(!timerRunning) {
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffSet);
            chronometer.start();
            timerRunning = true;
        }
    }



    public void resetChronometer(View view) {

            chronometer.setBase(SystemClock.elapsedRealtime());
            pauseOffSet = 0;
            timerRunning = false;

    }

    public void pauseChronometer(View view) {
            if(timerRunning) {
                chronometer.stop();
                pauseOffSet = SystemClock.elapsedRealtime() - chronometer.getBase();

                timerRunning = false;
            }
    }
}
