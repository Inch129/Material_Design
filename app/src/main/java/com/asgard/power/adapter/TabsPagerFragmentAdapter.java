package com.asgard.power.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.asgard.power.fragments.RecycleFragment;

public class TabsPagerFragmentAdapter extends FragmentPagerAdapter {

    String tabs[] = {
            "SYNONYMS",
            "ANTONYMS",
            "BROADER",
            "ARE YOU JEDI?",
            "CHEWIE, WE ARE HOME",
            "ELSE TAB"
    };


    public TabsPagerFragmentAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return RecycleFragment.getInstance();
            case 1:
                return RecycleFragment.getInstance();
            case 2:
                return RecycleFragment.getInstance();
            case 3:
                return RecycleFragment.getInstance();
            case 4:
                return RecycleFragment.getInstance();
            case 5:
                return RecycleFragment.getInstance();
        }
        return null;
    }



    @Override
    public int getCount() {
        return tabs.length;
    }
}
