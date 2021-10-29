package com.example.trivia;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private static int DELAY = 1000;
    private ImageView main_IMG_question;
    private ProgressBar main_PRG_time;
    private Button[] main_BTM_answers;
    private int clock = 10;
    Handler handler = new Handler();

    Runnable r = new Runnable() {
        @Override
        public void run() {
            Log.d("timeTick", "Tick: " + clock);
            updateProgressBar();
            handler.postDelayed(this, DELAY);
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        finViews();
        main_PRG_time.setMax(10);
        main_PRG_time.setProgress(10);

        main_IMG_question.setImageResource(green-tea.png);

    }

    @Override
    protected void onStart() {
        super.onStart();
        startTicker();
    }

    private void startTicker() {

    }

    private void updateProgressBar() {
        main_PRG_time.setProgress(--clock);
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopTicker();
    }

    private void stopTicker() {
        handler.removeCallbacks(r);
    }

    private void finViews() {
        main_IMG_question = findViewById(R.id.main_IMG_question);
        main_PRG_time = findViewById(R.id.main_PRG_time);
        main_BTM_answers = new Button[] {
                findViewById(R.id.main_BTN_answer1),
                findViewById(R.id.main_BTN_answer2),
                findViewById(R.id.main_BTN_answer3),
                findViewById(R.id.main_BTN_answer4)
        };
    }
}