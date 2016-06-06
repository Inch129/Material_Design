package com.asgard.power;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.asgard.power.interfaces.BottomSheetCallbackAdapter;

import java.util.List;

public class RvWordsAdapter extends RecyclerView.Adapter<RvWordsAdapter.ViewHolder> implements BottomSheetCallbackAdapter{
    private List<Word> words;
    private BottomSheetBehavior behavior;
    private boolean checkLikes[];

    public List<Word> getWords() {
        return words;
    }


    private void setWords(List<Word> words) {
        this.words = words;
    }

    public RvWordsAdapter(List<Word> words) {
        this.words = words;
        setWords(words);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("Test", "onCreateViewHolder");
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View wordView = inflater.inflate(R.layout.one_word, parent, false);

        ViewHolder viewHolder = new ViewHolder(wordView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d("Test", "onBindViewHolder");

        TextView mainWords = holder.getMainWords();
        Word word = getWords().get(position);

        holder.setWord(word);



        ImageButton likesBtn = holder.getLikesBtn();
        ImageButton dislikesBtn = holder.getDislikesBtn();

        TextView likesView = holder.getLikesTextView();
        likesView.setText(Integer.toString(word.getLikes()));

        LikesBtnClick like = new LikesBtnClick(words, word, likesView, holder.getLikesBtn());
        DislikesBtnClick dislike = new DislikesBtnClick(word, likesView, holder.getDislikesBtn());

        like.setSubscriber(dislike);
        dislike.setSubscriber(like);

        holder.info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggle();
            }
        });


        mainWords.setText(word.getWord());

        switch (word.getState()){
            case None:
                holder.getLikesBtn().setImageResource(R.drawable.thumbupgrey);
                holder.getDislikesBtn().setImageResource(R.drawable.thumbdowngrey);
                break;

            case Like:
                holder.getLikesBtn().setImageResource(R.drawable.thumb_up_green);
                holder.getDislikesBtn().setImageResource(R.drawable.thumbdowngrey);
                break;

            case Dislike:
                holder.getLikesBtn().setImageResource(R.drawable.thumbupgrey);
                holder.getDislikesBtn().setImageResource(R.drawable.thumb_red_down);
                break;
        }

        likesBtn.setOnClickListener(like);
        dislikesBtn.setOnClickListener(dislike);

    }

    @Override
    public int getItemCount() {
        return getWords().size();
    }

    @Override
    public void toggle() {
        Log.d("subscriber", "Done");
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageButton likesBtn;
        private TextView likesTextView;
        private ImageButton dislikesBtn;
        private TextView mainWords;
        private ImageView info;
        private TextView maintest;
        private Word word;

        public Word getWord() {
            return word;
        }

        public void setWord(Word word) {
            this.word = word;
        }

        public void setInfo(View value) {
            info = (ImageView) value;
        }

        private ImageView getInfo() {
            return info;
        }

        private void setMainWords(View value) {
            mainWords = (TextView) value;
        }

        public TextView getMainWords() {
            return mainWords;
        }

        private void setLikesBtn(View value) {
            likesBtn = (ImageButton) value;
        }

        public TextView getLikesTextView() {
            return likesTextView;
        }

        private void setLikesTextView(View value) {
            likesTextView = (TextView) value;
        }

        public ImageButton getDislikesBtn() {
            return dislikesBtn;
        }

        public ImageButton getLikesBtn() {
            return likesBtn;
        }

        public TextView getTest() {
            return maintest;
        }

        public void setTest(View value) {
            maintest = (TextView) value;
        }

        private void setDislikesBtn(View value) {
            dislikesBtn = (ImageButton) value;
        }

        public ViewHolder(View itemView) {
            super(itemView);
            setInfo(itemView.findViewById(R.id.infobtn));
            setMainWords(itemView.findViewById(R.id.mainwords));
            setLikesBtn(itemView.findViewById(R.id.thumpup));
            setLikesTextView(itemView.findViewById(R.id.likes));
            setDislikesBtn(itemView.findViewById(R.id.thumpdown));
            setTest(itemView.findViewById(R.id.mainwords2));

        }
    }
}