package com.asgard.power;

import android.view.View;
import android.widget.TextView;

class LikesIncBtnClick implements View.OnClickListener {

    private Word word;
    private TextView likesView;

    public TextView getLikesView() {
        return likesView;
    }

    public void setLikesView(TextView likesView) {
        this.likesView = likesView;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public LikesIncBtnClick(Word word, TextView likesView) {
        setWord(word);
        setLikesView(likesView);
    }

    @Override
    public void onClick(View v) {
        word.setLikes(word.getLikes() + 1);
        getLikesView().setText(Integer.toString(word.getLikes()));
    }
}
