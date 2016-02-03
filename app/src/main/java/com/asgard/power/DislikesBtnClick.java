package com.asgard.power;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

class DislikesBtnClick implements View.OnClickListener {
    private ImageButton dislike;
    private Word word;
    private TextView likesView;

    public TextView getLikesView() {
        return likesView;
    }

    public void setDislikesView(TextView likesView) {
        this.likesView = likesView;
    }

    public Word getWord() {
        return word;
    }

    public void setDislike(ImageButton like){
        this.dislike = like;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public DislikesBtnClick(Word word, TextView likesView, ImageButton like) {
        setWord(word);
        setDislikesView(likesView);
        setDislike(like);
    }

    @Override
    public void onClick(View v) {
        word.setLikes(word.getLikes() - 1);
        dislike.setImageResource(R.drawable.thumb_red_down_hdpi);
        getLikesView().setText(Integer.toString(word.getLikes()));
    }
}
