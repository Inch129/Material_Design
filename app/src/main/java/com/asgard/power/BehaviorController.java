package com.asgard.power;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.util.Log;
import android.view.View;

public class BehaviorController extends ExpandedBottomSheetBehavior.BottomSheetCallback {

    private static BottomSheetBehavior behavior;

    public BehaviorController(BottomSheetBehavior behavior) {
        BehaviorController.behavior = behavior;

    }




    @Override
    public void onStateChanged(@NonNull final View bottomSheet, int newState) {


      }

    @Override
    public void onSlide(@NonNull View bottomSheet, float slideOffset) {

    }
}
