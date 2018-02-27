package com.example.mdsouza5.hw5slideshow;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

/**
 * Created by mdsouza5 on 2/23/18.
 */

public class StartSlideShow extends AppCompatActivity {

    private TextView cityNameTextView;
    private TextView cityMsgTextView;
    private ImageView cityImageView;
    private static final String timerValueIntentExtra = "TimerValue";
    private int timerForSlideShow;
    private Handler handlerForSlideShow = new Handler();
    private int positionForSlideShow = 0;
    long timerForSlideShow2;

    //Define City Names
    String[] cityNameArray = new String[]{"Cape Town, South Africa", "Chefchaouen, Morocco", "Hong Kong, China", "Istanbul, Turkey", "Lisbon, Portugal", "New York, U.S.A", "Paris, France",
            "Queenstown, New Zealand", "Rio de Janeiro, Brazil", "Venice, Italy"};

    //Define City Desc
    String[] cityMsgArray = new String[]{
            "The whole world witnessed Cape Town's beauty first hand during the 2010 World Cup.",
            "Tucked high in Morocco’s Rif Mountains, the all-blue town of Chefchaouen is a calming respite from the overwhelming frenzy of Marrakech and Fez.",
            "Hong Kong is impressive from many angles—beneath the towering skyscrapers, or from a ferry crossing Victoria Harbour.",
            "A historic crossroads of culture and design, Istanbul's landscape provides a prominent display of its two conquering empires.",
            "Portugal's history of intricate tilework—from its ceilings to floors, homes and hallways—means you can't walk down a street in Lisbon without spotting something beautiful.",
            "New York's beauty is multi-sensory.",
            "I am trying not to play favorites, but really, is there a city more dramatic than Paris?",
            "Queenstown, dubbed the adrenaline-junkie capital of the world, and you’ll find more than a few ways to look danger in the eye.",
            "Christ the Redeemer watches over the sweeping vista, where a pulsing, vibrant city seems to dance down to the sea and mellow as it floats off on a stand-up paddle board.",
            "Here's a general rule to abide by in Venice: If you don't get lost, you're not doing it right."};

    //Define Images
    Integer[] imgSlideShowArray = new Integer[]{R.drawable.capetown, R.drawable.chefchaouen, R.drawable.hongkong, R.drawable.istanbul, R.drawable.lisbon, R.drawable.newyork, R.drawable.paris, R.drawable.queenstown,
            R.drawable.riodejanerio, R.drawable.venice};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slideshow);

        //findViewById All
        cityNameTextView = (TextView) findViewById(R.id.cityNameSS);
        cityMsgTextView = (TextView) findViewById(R.id.cityMsgSS);
        cityImageView = (ImageView) findViewById(R.id.cityViewSS);

        //Read Values From Intent Extras
        timerForSlideShow = getIntent().getIntExtra(timerValueIntentExtra, 5);

        try {
            handlerForSlideShow.postDelayed(runnableInstance, timerForSlideShow * 1000);
        } catch (Exception ex) {
            Log.d("Runnable Error", ex.getMessage());
        }
    }

    //Runnable Interface for the Activity SlideShow
    private Runnable runnableInstance = new Runnable() {
        @Override
        public void run() {
            if (positionForSlideShow < imgSlideShowArray.length) {
                cityNameTextView.setText(cityNameArray[positionForSlideShow]);
                cityMsgTextView.setText(cityMsgArray[positionForSlideShow]);
                cityImageView.setImageResource(imgSlideShowArray[positionForSlideShow]);
                Toast.makeText(getApplicationContext(), String.format("Slide Number : %d", positionForSlideShow + 1), Toast.LENGTH_SHORT).show();
                positionForSlideShow++;
            }
            if (positionForSlideShow == imgSlideShowArray.length) {
                positionForSlideShow = 0;
            }

            handlerForSlideShow.postDelayed(this, timerForSlideShow * 1000);
        }
    };

    //Runnable Methods

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handlerForSlideShow.removeCallbacks(runnableInstance);
        finish();
    }
}
