package com.asgard.power;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Word {

    private LikeState state;

    public Word(String word, int likes, LikeState state) {
        this.state = state;
        this.word = word;
        this.likes = likes;
    }

    private String word;
    private int likes;

    public LikeState getState() {
        return state;
    }

    public void setState(LikeState state) {
        this.state = state;
    }

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
