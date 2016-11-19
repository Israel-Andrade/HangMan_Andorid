package com.example.hangman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ImageView;

import java.util.*;

public class MainActivity extends AppCompatActivity {
    ImageView drawing;
    private dictionary dict;
    private ArrayList<String> ana;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawing = (ImageView) findViewById(R.id.drawing);
        Integer wordLength = 5;

        /*
        Queue<Integer> drawing_queue = new LinkedList<Integer>();
        drawing_queue.add(R.drawable.drawing_0);
        drawing_queue.add(R.drawable.drawing_1);
        drawing_queue.add(R.drawable.drawing_2);
        drawing_queue.add(R.drawable.drawing_3);
        drawing_queue.add(R.drawable.drawing_4);
        drawing_queue.add(R.drawable.drawing_5);
        drawing_queue.add(R.drawable.drawing_6);
        drawing_queue.add(R.drawable.drawing_7);
        drawing_queue.add(R.drawable.drawing_8);
        drawing_queue.add(R.drawable.drawing_9);
        Integer number = drawing_queue.peek();
        Log.d("This", "This " + number);
        Log.d("This", "This " + R.drawable.drawing_0);
        */
        drawing.setImageResource(R.drawable.drawing_0);

    }
}
