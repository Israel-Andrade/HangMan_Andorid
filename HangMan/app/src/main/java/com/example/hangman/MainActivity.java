package com.example.hangman;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.*;

public class MainActivity extends AppCompatActivity {
    ImageView drawing;
    TextView text, textUsed;
    private dictionary dict;;
    private String word;
    private Set <String> lettersFound = new HashSet<String>();
    private Queue<Integer> drawings = new LinkedList<Integer>();
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
        lettersFound.add(" ");
        Intent  intent = getIntent();
        int size = 0;
        int wordSize = intent.getIntExtra(StartActivity.dropDownData, size);
        Log.d("My word is: ", "Word size is: " + wordSize);
        drawing = (ImageView) findViewById(R.id.drawing);
        text = (TextView) findViewById(R.id.wordText);
        textUsed = (TextView) findViewById(R.id.wordText);
        word = dict.getRandomWord(wordSize);
        String buffer = "";


        drawings.add((Integer)R.drawable.drawing_0);
        drawings.add((Integer)R.drawable.drawing_1);
        drawings.add((Integer)R.drawable.drawing_2);
        drawings.add((Integer)R.drawable.drawing_3);
        drawings.add((Integer)R.drawable.drawing_4);
        drawings.add((Integer)R.drawable.drawing_5);
        drawings.add((Integer)R.drawable.drawing_6);
        drawings.add((Integer)R.drawable.drawing_7);
        drawings.add((Integer)R.drawable.drawing_8);
        drawings.add((Integer)R.drawable.drawing_9);
        for(int i = 0; i < wordSize; i++)
        {
            buffer += "- ";
        }
        text.setText(buffer);
        Log.d("My word is: ", word);

        drawing.setImageResource(drawings.peek());
        Log.d("Buffer is ", buffer);

    }
@Override

    public boolean onKeyUp(int keyCode, KeyEvent event)
    {
        Log.i("jfkrsj", "Value " + keyCode);

        int charValue = (keyCode - 29) + 97;
        if(charValue >= 65 && charValue <= 122)
        {
            char character = (char) charValue;
            String value = String.valueOf(character);
            String letter = value;
            value += " ";
            textUsed.setText(value);

            String buffer = "";
            boolean isFound = false;
            for(int i = 0; i < word.length(); i++)
            {

                Log.i("In Loop", "LOOP");

                if(word.charAt(i) == character)
                {
                    lettersFound.add(letter);
                    isFound = true;
                    Log.i("Comparing", "Comparing " + word.charAt(i) + " with " + character);

                   // buffer += value;
                }

            }
            for(int i = 0; i < word.length(); i++)
            {
                String characterFound = String.valueOf(word.charAt(i));

                if(lettersFound.contains(characterFound))
                {
                    buffer += word.charAt(i);
                    Log.i("Found letter", "Letter found" + word.charAt(i));
                }
                else
                {
                    buffer += "-   ";

                }
            }
            if(!isFound)
            {
                drawings.remove();
                drawing.setImageResource(drawings.peek());
            }
            text.setText(buffer);

        }

        else
        {
            return super.onKeyUp(keyCode, event);
        }
        return true;

    }

    public void reset(View view){
        Intent i = new Intent(this, StartActivity.class);
        startActivity(i);
    }
}
