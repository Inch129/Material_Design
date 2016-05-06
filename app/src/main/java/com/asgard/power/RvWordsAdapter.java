package com.asgard.power;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.BottomSheetBehavior;
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


import java.util.List;

public class RvWordsAdapter extends RecyclerView.Adapter<RvWordsAdapter.ViewHolder> {

    private List<Word> words;
    private Activity activity;
    private BottomSheetBehavior behavior;
    private FrameLayout frameLayout;

    public List<Word> getWords() {
        return words;
    }

    private void setWords(List<Word> words) {
        this.words = words;
    }

    public RvWordsAdapter(List<Word> words, Activity activity, BottomSheetBehavior behavior, FrameLayout frameLayout) {
        setWords(words);
        this.behavior = behavior;
        this.activity = activity;
        this.frameLayout = frameLayout;
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
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d("Test", "onBindViewHolder");

        TextView mainWords = holder.getMainWords();
        Word word = getWords().get(position);
        ImageButton likesBtn = holder.getLikesBtn();
        ImageButton dislikesBtn = holder.getDislikesBtn();
        ImageView infoBtn = holder.getInfo();
        TextView textView = holder.getTest();
        TextView likesView = holder.getLikesTextView();
        likesView.setText(Integer.toString(word.getLikes()));

        LikesBtnClick likeListener = new LikesBtnClick(word, likesView, holder.getLikesBtn());
        DislikesBtnClick disLikeListener = new DislikesBtnClick(word, likesView, holder.getDislikesBtn());
        Log.d("Sheet", "behavior " + behavior.getState());

        likeListener.setSubscriber(disLikeListener);
        disLikeListener.setSubscriber(likeListener);

        mainWords.setText(word.getWord());

        likesBtn.setOnClickListener(likeListener);
        dislikesBtn.setOnClickListener(disLikeListener);

        infoBtn.setOnClickListener(new InfoBtnClick());



    /*    infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Btn", "Событие сработало");
                Toast.makeText(activity, "Тык" , Toast.LENGTH_SHORT).show();
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return getWords().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageButton likesBtn;
        private TextView likesTextView;
        private ImageButton dislikesBtn;
        private TextView mainWords;
        private ImageView info;
        private TextView maintest;

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