package com.asgard.power;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Администратор on 01.02.2016.
 */
public class LikesBtnClick implements View.OnClickListener, ThumbsListener {

    private Word word;
    private TextView likesView;
    private ImageButton like;
    private ThumbsListener subscriber;

    private ThumbsListener getSubscriber() {
        return subscriber;
    }

    private void setSubscriber(ThumbsListener value) {
        subscriber = value;
    }

    public LikesBtnClick(Word word, TextView likesView, ImageButton like, ThumbsListener subscriber) {
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
        word.setLikes(word.getLikes() + 1);
        like.setImageResource(R.drawable.thumb_up_green_hdpi);
        getLikesView().setText(Integer.toString(word.getLikes()));
        getSubscriber().callback(this);
    }

    public void callback(View sender) {
        //Вот тут ебенишь работу по смене отображения.
    }
}
