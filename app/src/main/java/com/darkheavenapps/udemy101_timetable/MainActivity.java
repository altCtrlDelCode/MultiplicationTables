package com.darkheavenapps.udemy101_timetable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textViewHeading;
    ListView timeTableListView;
    public void generateTimeTable(int timeTableNumber){
        ArrayList<String> timeTableArray = new ArrayList<>();
        for(int i = 1; i <= 10; i++){
            timeTableArray.add(i + " x " + Integer.toString(timeTableNumber) + " = " + Integer.toString(i * timeTableNumber));
            LayoutResourceTable arrayAdapter = new LayoutResourceTable(this, R.layout.layout_resource, timeTableArray);
            timeTableListView.setAdapter(arrayAdapter);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final SeekBar timeTableSeekBar = findViewById(R.id.timeTableSeekBar);
        timeTableListView = findViewById(R.id.timeTableListView);
        textViewHeading = findViewById(R.id.textViewHeading);

        int max = 10;
        int startingPosition = 5;
        timeTableSeekBar.setMax(max);
        timeTableSeekBar.setProgress(startingPosition);
        generateTimeTable(startingPosition);

        timeTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;                                    //setting minimum value for slider
                int timeTableNumber;
                if(progress<min){
                     timeTableNumber = min;
                     timeTableSeekBar.setProgress(1);
                }else{
                    timeTableNumber = progress;
                }
                //Log.i("SeekBar Progress:", Integer.toString(timeTableNumber));
                generateTimeTable(timeTableNumber);
                textViewHeading.setText("MULTIPLICATION TABLE OF "+timeTableNumber);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
