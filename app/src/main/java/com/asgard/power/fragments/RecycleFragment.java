package com.asgard.power.fragments;

import android.content.Context;
import android.os.Bundle;
import android.provider.UserDictionary;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.asgard.power.MainActivity;
import com.asgard.power.R;
import com.asgard.power.RvWordsAdapter;
import com.asgard.power.SubHeader;
import com.asgard.power.Word;

import java.util.ArrayList;
import java.util.List;

public class RecycleFragment extends Fragment {
    private static final int LAYOUT = R.layout.fragment_recycle;
    private View view;
    private RecyclerView rvContacts;
    private RvWordsAdapter adapter;
    private List<Word> words;
    private BottomSheetBehavior behavior;
    private Context context;
    private FrameLayout frameLayout;

    public void setContext(Context context) {
        this.context = context;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initRecyclerView(view, context, this.behavior);
    //    LinearLayout subHeader = (LinearLayout) getActivity().findViewById(R.id.subhead_linear);
    //    if (subHeader == null) {

          //  LinearLayout recycler = (LinearLayout) getActivity().findViewById(R.id.recyclefragment);
          //  View hiddenInfo = getActivity().getLayoutInflater().inflate(R.layout.test_sub, null, false);
         //   recycler.addView(hiddenInfo);
          //  recycler.postDelayed(new SubHeader(subHeader, recycler, hiddenInfo), 5);
        }

 //   }

    public static RecycleFragment getInstance() {

        Bundle args = new Bundle();

        RecycleFragment recycleFragment = new RecycleFragment();
        recycleFragment.setArguments(args);

        return recycleFragment;
    }

    public void setBehaviorSheet(BottomSheetBehavior behavior, FrameLayout frameLayout) {
        this.behavior = behavior;
        Log.d("Sheet", "behavior setBehaviorSheet" + behavior.getState());
    }

    private List<Word> getWords() {
        if (words == null) {
            return createMock();
        }
        return words;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);
        setRetainInstance(true);
        behavior = ((MainActivity) getActivity()).getBehavior();
        frameLayout = ((MainActivity) getActivity()).getFrameSheet();


        Log.d("Sheet", "behavior onCreateView" + this.behavior);
        return view;
    }

    private void initRecyclerView(View view, Context context, BottomSheetBehavior behavior) {
        rvContacts = (RecyclerView) view.findViewById(R.id.rvWords);
        if (adapter == null) {
            adapter = new RvWordsAdapter(getWords(), getActivity(), behavior, frameLayout);
        }

        rvContacts.setAdapter(adapter);

        rvContacts.setLayoutManager(new LinearLayoutManager(context));
        frameLayout.setVisibility(View.VISIBLE);

    }

    private List<Word> createMock() {
        List<Word> content = new ArrayList<>();
        content.add(new Word("Force", 0));
        content.add(new Word("Strength", 0));
        content.add(new Word("Energy", 0));
        content.add(new Word("Influence", 0));
        content.add(new Word("Might", 0));
        content.add(new Word("Capacity", 0));
        content.add(new Word("Potency", 0));
        content.add(new Word("Force", 0));
        content.add(new Word("Strength", 0));
        content.add(new Word("Energy", 0));
        content.add(new Word("Force", 0));
        content.add(new Word("Strength", 0));
        content.add(new Word("Energy", 0));
        content.add(new Word("Influence", 0));
        content.add(new Word("Might", 0));
        content.add(new Word("Capacity", 0));
        content.add(new Word("Potency", 0));
        content.add(new Word("Force", 0));
        content.add(new Word("Strength", 0));
        content.add(new Word("Energy", 0));
        content.add(new Word("Force", 0));
        content.add(new Word("Strength", 0));
        content.add(new Word("Energy", 0));
        content.add(new Word("Influence", 0));
        content.add(new Word("Might", 0));
        content.add(new Word("Capacity", 0));
        content.add(new Word("Potency", 0));
        content.add(new Word("Force", 0));
        content.add(new Word("Strength", 0));
        content.add(new Word("Energy", 0));
        return content;

    }
}
