package com.asgard.power;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

class DislikesBtnClick implements View.OnClickListener, ThumbsListener {
    private ImageButton dislike;
    private Word word;
    private TextView likesView;
    private ThumbsListener subscriber;

    private ThumbsListener getSubscriber() {
        return subscriber;
    }

    private void setSubscriber(ThumbsListener value) {
        subscriber = value;
    }

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

    public DislikesBtnClick(Word word, TextView likesView, ImageButton like, ThumbsListener subscriber) {
        setWord(word);
        setDislikesView(likesView);
        setDislike(like);
        setSubscriber(subscriber);
    }

    @Override
    public void onClick(View v) {
        word.setLikes(word.getLikes() - 1);
        dislike.setImageResource(R.drawable.thumb_red_down_hdpi);
        getLikesView().setText(Integer.toString(word.getLikes()));
        getSubscriber().callback(this);
    }

    public void callback(View sender) {
        //Вот тут ебенишь работу по смене отображения.
    }
}
