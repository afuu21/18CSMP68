package com.example.project5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView counterView;
    Button startBtn, stopBtn;
    Handler customHandler = new Handler();
    int i=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterView = findViewById(R.id.counter);
        startBtn = findViewById(R.id.start);
        stopBtn = findViewById(R.id.stop);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customHandler.postDelayed(updateTimer, 0);
            }
        });
        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customHandler.removeCallbacks(updateTimer);
            }
        });
    }
    private final Runnable updateTimer = new Runnable() {
        @Override
        public void run() {
            counterView.setText(""+i);
            customHandler.postDelayed(this,1000);
            i=i+1;
        }
    };
}
