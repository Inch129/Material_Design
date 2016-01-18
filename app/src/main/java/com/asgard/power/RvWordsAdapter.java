package com.asgard.power;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

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
        Word word = getWords().get(position);

       // TextView wordView = holder.getWordTextView();
        //wordView.setText(word.getWord());

        final TextView likesView = holder.getLikesTextView();
        likesView.setText(Integer.toString(word.getLikes()));

        //Button likesIncBtn = holder.getLikesIncBtn();
       // likesIncBtn.setText("INCREMENT");

        //likesIncBtn.setOnClickListener(new LikesIncBtnClick(word, likesView));
    }

    @Override
    public int getItemCount() {
        return getWords().size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageButton wordTextView;
        private TextView likesTextView;
        private ImageButton likesIncBtn;

        public ImageButton getWordTextView() {
            return wordTextView;
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

        public ImageButton getLikesIncBtn() {
            return likesIncBtn;
        }

        private void setLikesIncBtn(View value) {
            likesIncBtn = (ImageButton) value;
        }

        public ViewHolder(View itemView) {
            super(itemView);

            setWordTextView(itemView.findViewById(R.id.thumpup));
            setLikesTextView(itemView.findViewById(R.id.likes));
            setLikesIncBtn(itemView.findViewById(R.id.thumpdown));
        }
    }
}