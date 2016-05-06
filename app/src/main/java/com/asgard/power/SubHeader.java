package com.asgard.power;

import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by Администратор on 29.04.2016.
 */
public class SubHeader implements Runnable {

    private LinearLayout subHeader;
    private LinearLayout root;
    private View info;

    public SubHeader (LinearLayout subHeader, LinearLayout root, View info){
        this.subHeader = subHeader;
        this.root = root;
        this.info = info;
    }


    @Override
    public void run() {
        root.removeView(info);
    }
}