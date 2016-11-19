package com.example.hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by Coleman on 11/18/16.
 * Dictionary to read in words and get a random word of a specified length hangman game.
 */

public class dictionary {

    private HashMap<Integer,ArrayList<String>> sizeToWords = new HashMap<Integer, ArrayList<String>>();
    private static final int MIN_WORD_SZ = 4;
    private static final int MAX_WORD_SZ = 10;
    private Random random = new Random();

    public dictionary(InputStream wordStream) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(wordStream));
        String line;
        while((line = in.readLine()) != null){
            String word = line.trim();
            if(word.length() <= MAX_WORD_SZ && word.length() >= MIN_WORD_SZ){
                if(sizeToWords.containsKey(word.length())){
                    ArrayList<String> temp = sizeToWords.get(word.length());
                    temp.add(word);
                    sizeToWords.put(word.length(),temp);
                }
                else{
                    ArrayList<String> temp = new ArrayList<String>();
                    temp.add(word);
                    sizeToWords.put(word.length(),temp);
                }
            }
        }//end while
    }//end constructor

    public String getRandomWord(int length){
        ArrayList<String> words = sizeToWords.get(length);
        return words.get(random.nextInt(words.size()));
    }

}//end class
