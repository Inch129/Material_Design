package com.asgard.power;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Word  {

    public Word(String word, int likes) {
        this.word = word;
        this.likes = likes;
    }

    public static List<Word> createWords(String [] words){
        List<Word> content = new ArrayList<>();
        for (String word:words) {
            content.add(new Word(word, new Random().nextInt(100)));
        }
        return content;
    }

    private String word;
    private int likes;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
