package com.example.mdsouza5.hw5slideshow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button slideslideshowButton;
    private SeekBar timerSeekBar;
    private TextView timerTextView;
    private ImageView iitlogoImageView;
    private int timerForSlideShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //findViewById for all
        slideslideshowButton = (Button) findViewById(R.id.startSlideShowMABtn);
        timerSeekBar = (SeekBar) findViewById(R.id.seekbarTimerMA);
        timerTextView = (TextView) findViewById(R.id.seekbarTimerValueMA);

        //Set Values For Controls
        timerSeekBar.setMax(10);
        timerSeekBar.setProgress(timerSeekBar.getMax() / 2);
        timerTextView.setText(String.valueOf(timerSeekBar.getProgress()));

        //SeekBar
        timerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int seekbarProgress, boolean b) {
                timerForSlideShow = Integer.valueOf(seekbarProgress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                timerTextView.setText(String.valueOf(timerSeekBar.getProgress()));
            }
        });

        //Button to Call the Next Activity and Start SlideShow
        slideslideshowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Slide Show Started", Toast.LENGTH_SHORT).show();
                //Get the Values

                //Call intent and pass values to the next activity
            }
        });
    }
}
