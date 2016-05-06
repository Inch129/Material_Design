package com.asgard.power;

import android.support.design.widget.BottomSheetBehavior;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;


public class InfoBtnClick implements View.OnClickListener {
  /*  private BottomSheetBehavior behavior;
    private FrameLayout frameLayout;

    public InfoBtnClick(BottomSheetBehavior behavior, FrameLayout frameLayout) {
        this.behavior = behavior;
        this.frameLayout = frameLayout;

    }*/


    @Override
    public void onClick(View v) {
        BehaviorController.getBehavior().setState(BottomSheetBehavior.STATE_EXPANDED);


    }
}
