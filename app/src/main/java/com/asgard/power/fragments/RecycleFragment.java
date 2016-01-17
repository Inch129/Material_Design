package com.asgard.power.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asgard.power.R;

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
        return view;
    }
}
