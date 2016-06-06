package com.asgard.power.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import com.asgard.power.HidingScrollSubheader;
import com.asgard.power.LikeState;
import com.asgard.power.R;
import com.asgard.power.RvWordsAdapter;
import com.asgard.power.Word;
import java.util.ArrayList;
import java.util.List;

public class RecycleFragment extends Fragment {
    private static final int LAYOUT = R.layout.fragment_recycle;
    private View view;
    private RecyclerView rvContacts;
    private static RvWordsAdapter adapter;
    private static List<Word> words;
    private Context context;
    private LinearLayout subheader;
    private Activity activity;


    public void setContext(Context context) {
        this.context = context;
    }



    private void hideView() {
        subheader.animate().translationY(-subheader.getHeight()).setInterpolator(new AccelerateInterpolator(2));
        subheader.setVisibility(View.GONE);
    }

    private void showView() {
        subheader.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2)).start();
        subheader.setVisibility(View.VISIBLE);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initRecyclerView(view);
    }


    public static RecycleFragment getInstance() {

        Bundle args = new Bundle();

        RecycleFragment recycleFragment = new RecycleFragment();
        recycleFragment.setArguments(args);

        return recycleFragment;
    }


    private List<Word> getWords() {
        if (words == null) {
            words = createMock();
        }
        return words;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);
        setRetainInstance(true);
        subheader = (LinearLayout) view.findViewById(R.id.subheader);
        activity = getActivity();
        return view;
    }

    private void initRecyclerView(View view) {
        rvContacts = (RecyclerView) view.findViewById(R.id.rvWords);
        if (adapter == null) {
            adapter = new RvWordsAdapter(getWords());
        }
        rvContacts.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvContacts.setAdapter(adapter);
        rvContacts.setOnScrollListener(new HidingScrollSubheader() {
            @Override
            public void onHide() {
                hideView();
            }
        });

    }

    private List<Word> createMock() {
        List<Word> content = new ArrayList<>();
        content.add(new Word("Force", 0, LikeState.None));
        content.add(new Word("Strength", 0, LikeState.None));
        content.add(new Word("Energy", 0, LikeState.None));
        content.add(new Word("Influence", 0, LikeState.None));
        content.add(new Word("Might", 0, LikeState.None));
        content.add(new Word("Capacity", 0, LikeState.None));
        content.add(new Word("Potency", 0, LikeState.None));
        content.add(new Word("Force", 0, LikeState.None));
        content.add(new Word("Strength", 0, LikeState.None));
        content.add(new Word("Energy", 0, LikeState.None));
        content.add(new Word("Force", 0, LikeState.None));
        content.add(new Word("Strength", 0, LikeState.None));
        content.add(new Word("Energy", 0, LikeState.None));
        content.add(new Word("Influence", 0, LikeState.None));
        content.add(new Word("Might", 0, LikeState.None));
        content.add(new Word("Capacity", 0, LikeState.None));
        content.add(new Word("Potency", 0, LikeState.None));
        content.add(new Word("Force", 0, LikeState.None));
        content.add(new Word("Strength", 0, LikeState.None));
        content.add(new Word("Energy", 0, LikeState.None));
        content.add(new Word("Force", 0, LikeState.None));
        content.add(new Word("Strength", 0, LikeState.None));
        content.add(new Word("Energy", 0, LikeState.None));
        content.add(new Word("Influence", 0, LikeState.None));
        content.add(new Word("Might", 0, LikeState.None));
        content.add(new Word("Capacity", 0, LikeState.None));
        content.add(new Word("Potency", 0, LikeState.None));
        content.add(new Word("Force", 0, LikeState.None));
        content.add(new Word("Strength", 0, LikeState.None));
        content.add(new Word("Energy", 0, LikeState.None));
        return content;

    }
}
