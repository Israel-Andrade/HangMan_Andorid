package com.example.hangman;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class MainActivity extends AppCompatActivity {
    ImageView drawing;
    TextView text, textUsed;
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
        textUsed = (TextView) findViewById(R.id.lettersUsed);
        Integer wordLength = 5;
        word = dict.getRandomWord(wordLength);
        String buffer = "";
        for(int i = 0; i < wordLength; i++)
        {
            buffer += "- ";
        }
        //text.setText(word);
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

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event)
    {
        String buffer = " ";
        Log.i("jfkrsj", "Value " + keyCode);
        int charValue = (keyCode - 29) + 97;
        if(charValue >= 65 && charValue <= 122)
        {
            textUsed.setText(" ");
            char character = (char) charValue;
            Log.i("Value", "Character " + character);
            String value = String.valueOf(character);
            textUsed.setText(value);
            for(int i = 0; i < word.length(); i++)
            {
                if(word.charAt(i) == character)
                {
                    buffer += character;
                }
                else
                {
                    buffer += "- ";
                }
            }
            Log.d("Wornfdfkjnafnfakjnjanf", "Character " + character);
            text.setText(buffer);
        }
        else
        {
            return super.onKeyUp(keyCode, event);
        }
        return true;

    }
}
