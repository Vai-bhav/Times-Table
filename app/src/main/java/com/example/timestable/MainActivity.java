package com.example.timestable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    public void generateTable(int num){

        ArrayList<String> tableContent = new ArrayList<String>();

        for(int j=1;j<=100;j++){

            tableContent.add(num + " X " + j + " = " + Integer.toString(j * num));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,tableContent);

        listView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar = findViewById(R.id.seekBar);
        listView = findViewById(R.id.listView);

        int max = 100;
        int startingPodition = 10;

        seekBar.setMax(max);
        seekBar.setProgress(startingPodition);

        generateTable(10);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
                int min = 1;
                int num;

                if(i < min){
                    num = min;
                    seekBar.setProgress(min);
                }else{
                    num = i;
                }

                Log.i("Touched",Integer.toString(num));

                generateTable(num);

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
