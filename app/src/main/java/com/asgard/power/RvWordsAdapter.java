package com.asgard.power;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.asgard.power.interfaces.ThumbsListener;

import java.util.List;

public class RvWordsAdapter extends RecyclerView.Adapter<RvWordsAdapter.ViewHolder> {

    private List<Word> words;

    public List<Word> getWords() {
        return words;
    }

    private void setWords(List<Word> words) {
        this.words = words;
    }

    public RvWordsAdapter(List<Word> words) {
        setWords(words);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View wordView = inflater.inflate(R.layout.one_word, parent, false);

        ViewHolder viewHolder = new ViewHolder(wordView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TextView mainWords = holder.getMainWords();
        Word word = getWords().get(position);
        ImageButton likesBtn = holder.getLikes();
        ImageButton dislikesBtn = holder.getDislikesBtn();

        String [] wordsExample = {"Force","Strength","Energy","Influence","Might","Capacity","Potency"};



        final TextView likesView = holder.getLikesTextView();
        likesView.setText(Integer.toString(word.getLikes()));

        LikesBtnClick likeListener = new LikesBtnClick(word, likesView, holder.getLikes());
        DislikesBtnClick disLikeListener = new DislikesBtnClick(word, likesView, holder.getDislikesBtn());

        likeListener.setSubscriber(disLikeListener);
        disLikeListener.setSubscriber(likeListener);

        mainWords.setText(word.getWord());

        likesBtn.setOnClickListener(likeListener);
        dislikesBtn.setOnClickListener(disLikeListener);
    }

    @Override
    public int getItemCount() {
        return getWords().size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageButton wordTextView;
        private TextView likesTextView;
        private ImageButton likesIncBtn;
        private TextView mainWords;


        public ImageButton getLikes() {
            return wordTextView;
        }

        private void setMainWords(View value){
            mainWords = (TextView) value;
        }

        public TextView getMainWords(){
            return mainWords;
        }

        private void setWordTextView(View value) {
            wordTextView = (ImageButton) value;
        }

        public TextView getLikesTextView() {
            return likesTextView;
        }

        private void setLikesTextView(View value) {
            likesTextView = (TextView) value;
        }

        public ImageButton getDislikesBtn() {
            return likesIncBtn;
        }

        public ImageButton getLikesBtn() {
            return wordTextView;
        }

        private void setLikesIncBtn(View value) {
            likesIncBtn = (ImageButton) value;
        }

        public ViewHolder(View itemView) {
            super(itemView);
            setMainWords(itemView.findViewById(R.id.mainwords));
            setWordTextView(itemView.findViewById(R.id.thumpup));
            setLikesTextView(itemView.findViewById(R.id.likes));
            setLikesIncBtn(itemView.findViewById(R.id.thumpdown));
        }
    }
}