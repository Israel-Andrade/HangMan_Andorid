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
import android.view.View;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class MainActivity extends AppCompatActivity {
    ImageView drawing;
    TextView text, textUsed;
    private dictionary dict;;
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
        text.setText(buffer);
        Log.d("My word is: ", word);

        drawing.setImageResource(R.drawable.drawing_0);
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
            Log.i("Value", "Character " + character);
            String value = String.valueOf(character);
            value += " ";
            textUsed.setText(value);

            String buffer = "";// "----------------------";
            /*
            for(int i = 0; i < word.length(); i++)
            {

                Log.i("In Loop", "LOOP");

                if(word.charAt(i) == character)
                {
                    Log.i("Comparing", "Comparing " + word.charAt(i) + " with " + character);

                    buffer.concat(value);
                }
                else
                {
                    Log.i("Comparing", "COmparing" + word.charAt(i) + " with " + character);
                    buffer.concat("-  ");
                }

                buffer.concat(value);

                text.setText(buffer);
            }
            */
        }

        else
        {
            return super.onKeyUp(keyCode, event);
        }
        return true;

    }
}
