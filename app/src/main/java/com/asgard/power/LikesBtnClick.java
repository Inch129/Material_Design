package com.asgard.power;

import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.asgard.power.interfaces.ThumbsListener;

import java.util.List;

public class LikesBtnClick implements View.OnClickListener, ThumbsListener {

    private Word word;
    private TextView likesView;
    private ImageButton like;
    private ThumbsListener subscriber;
    private List<Word> words;
    private ThumbsListener getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(ThumbsListener value) {
        subscriber = value;
    }

    public LikesBtnClick(List<Word> words,Word word, TextView likesView, ImageButton like) {
        this.words = words;
        setWord(word);
        setLikesView(likesView);
        setLike(like);
        setSubscriber(subscriber);
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
        Log.d("Test", "сабскрайбер сработал");
        word.setLikes(word.getLikes() + 1);
        word.setState(LikeState.Like);
        getLikesView().setText(Integer.toString(word.getLikes()));
        getSubscriber().callback(like);
    }

    @Override
    public void callback(ImageButton dislike) {
        Log.d("Test","callback сработал");
        dislike.setImageResource(R.drawable.thumb_red_down);
        like.setImageResource(R.drawable.thumbupgrey);
    }
}
