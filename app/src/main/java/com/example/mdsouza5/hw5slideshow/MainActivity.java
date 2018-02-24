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
        iitlogoImageView = (ImageView) findViewById(R.id.imageviewiitMA);

        //Set Values For Controls
        timerSeekBar.setMax(10);
        timerSeekBar.setProgress(timerSeekBar.getMax() / 2);
        timerTextView.setText(String.valueOf(timerSeekBar.getProgress()));
        iitlogoImageView.setContentDescription("IIT School of Applied Technology");
        iitlogoImageView.setImageDrawable(getDrawable(R.drawable.iit_sat_stack_186_blk));

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

                //Make Toast if SeekBar Value == 0
                if (timerSeekBar.getProgress() == 0) {
                    Toast.makeText(getApplicationContext(), String.format("Timer Value Cannot Be %d", timerSeekBar.getProgress()), Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Button to Call the Next Activity and Start SlideShow
        slideslideshowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(), "Slide Show Started", Toast.LENGTH_SHORT).show();

                //Get the Values
                RetriveValueFromTimerSeekBar();
                //Call intent and pass values to the next activity
            }
        });
    }

    //Get the Values and Perform Validations
    private void RetriveValueFromTimerSeekBar() {
        if (timerSeekBar.getProgress() == 0) {
            Toast.makeText(getApplicationContext(), String.format("Timer Value Cannot Be %d", timerSeekBar.getProgress()), Toast.LENGTH_SHORT).show();
            timerSeekBar.setProgress(timerSeekBar.getProgress() + 1);
            timerTextView.setText(String.valueOf((timerSeekBar.getProgress())));
            Toast.makeText(getApplicationContext(), String.format("Minimum Value Set to %d", timerSeekBar.getProgress()), Toast.LENGTH_LONG).show();
        } else {
            timerForSlideShow = Integer.valueOf(timerSeekBar.getProgress());
        }
    }
}
