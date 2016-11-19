package com.example.hangman;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class MainActivity extends AppCompatActivity {
    ImageView drawing;
    TextView text;
    private dictionary dict;
    private ArrayList<String> words;
    private String word;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        AssetManager assetManager = getAssets();
        try {
            InputStream inputStream = assetManager.open("words.txt");
            dict = new dictionary(inputStream);
        } catch (IOException e) {
            Toast toast = Toast.makeText(this, "Could not load dictionary", Toast.LENGTH_LONG);
            toast.show();
        }
        drawing = (ImageView) findViewById(R.id.drawing);
        text = (TextView) findViewById(R.id.wordText);

        Integer wordLength = 5;
        word = dict.getRandomWord(wordLength);
        text.setText(word);
        Log.d("My word is: ", word);

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
