package com.asgard.power.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asgard.power.R;
import com.asgard.power.RvWordsAdapter;
import com.asgard.power.Word;

import java.util.ArrayList;
import java.util.List;

public class RecycleFragment extends Fragment {
    private static final int LAYOUT = R.layout.fragment_recycle;
    private View view;


    public static RecycleFragment getInstance(){

        Bundle args = new Bundle();
        RecycleFragment recycleFragment = new RecycleFragment();
        recycleFragment.setArguments(args);

        return recycleFragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT,container,false);

        initRecyclerView(view, container.getContext());
     //   setRetainInstance(true);
        return view;
    }

    private void initRecyclerView(View view, Context context) {
        RecyclerView rvContacts = (RecyclerView) view.findViewById(R.id.rvWords);
        RvWordsAdapter adapter = new RvWordsAdapter(createMock());

        rvContacts.setAdapter(adapter);

        rvContacts.setLayoutManager(new LinearLayoutManager(context));
    }

    private List<Word> createMock() {
        List<Word> content = new ArrayList<>();
        content.add(new Word("Force",0));
        content.add(new Word("Strength",0));
        content.add(new Word("Energy",0));
        content.add(new Word("Influence",0));
        content.add(new Word("Might",0));
        content.add(new Word("Capacity",0));
        content.add(new Word("Potency",0));

        return content;

    }
}
