package com.example.mdsouza5.hw5slideshow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private Button startSlideShowBtn;
    private SeekBar timerseekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //findViewById for
        startSlideShowBtn = (Button) findViewById(R.id.startSlideShowMABtn);
        timerseekBar = (SeekBar) findViewById(R.id.seekbarTimerMA);
        timerseekBar.setMax(10);
        timerseekBar.setProgress(timerseekBar.getMax() / 2);

        startSlideShowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get the Values

                //Call intent and pass values to the next activity
            }
        });
    }
}
