package com.asgard.power;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.asgard.power.interfaces.ThumbsListener;

class DislikesBtnClick implements View.OnClickListener, ThumbsListener {
    private ImageButton dislike;
    private Word word;
    private TextView likesView;
    private ThumbsListener subscriber;
    private LikesBtnClick likesBtnClick;
    private ThumbsListener getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(ThumbsListener value) {
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

    public DislikesBtnClick(Word word, TextView likesView, ImageButton like) {
        setWord(word);
        setDislikesView(likesView);
        setDislike(like);
        setSubscriber(subscriber);

    }

    @Override
    public void onClick(View v) {
        word.setLikes(word.getLikes() - 1);
        word.setState(LikeState.Dislike);
        getLikesView().setText(Integer.toString(word.getLikes()));
        getSubscriber().callback(dislike);
    }


    @Override
    public void callback(ImageButton like) {
        like.setImageResource(R.drawable.thumb_up_green);
        dislike.setImageResource(R.drawable.thumbdowngrey);

    }
}
