package com.asgard.power;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Администратор on 01.02.2016.
 */
public class LikesBtnClick implements View.OnClickListener {

    private Word word;
    private TextView likesView;
    private ImageButton like;

    public LikesBtnClick(Word word, TextView likesView, ImageButton like) {
        setWord(word);
        setLikesView(likesView);
        setLike(like);
    }

    public void setLikesView(TextView likesView) {
        this.likesView = likesView;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public void setLike(ImageButton like) {
        this.like = like;
    }
    public TextView getLikesView() {
        return likesView;
    }

    @Override
    public void onClick(View v) {
        word.setLikes(word.getLikes() + 1);
        like.setImageResource(R.drawable.thumb_up_green_hdpi);
        getLikesView().setText(Integer.toString(word.getLikes()));

    }
}
