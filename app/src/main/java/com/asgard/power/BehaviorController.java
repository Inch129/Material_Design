package com.asgard.power;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.util.Log;
import android.view.View;

public class BehaviorController extends BottomSheetBehavior.BottomSheetCallback {

    private static BottomSheetBehavior behavior;

    public BehaviorController(BottomSheetBehavior behavior) {
        BehaviorController.behavior = behavior;

    }

    public static BottomSheetBehavior getBehavior(){
        return behavior;
    }

    @Override
    public void onStateChanged(@NonNull final View bottomSheet, int newState) {


        switch (newState) {
            case BottomSheetBehavior.STATE_DRAGGING:
                bottomSheet.setVisibility(View.VISIBLE);

                break;
            case BottomSheetBehavior.STATE_COLLAPSED:

            /*    bottomSheet.post(new Runnable() {
                    @Override
                    public void run() {*/
                        behavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                        behavior.setPeekHeight(0);
              /*      }
                });*/

                break;
            case BottomSheetBehavior.STATE_EXPANDED:
               // bottomSheet.setVisibility(View.INVISIBLE);
                behavior.setPeekHeight(400);

                break;

        }
    }


    @Override
    public void onSlide(@NonNull View bottomSheet, float slideOffset) {


    //    behavior.setState(slideOffset > 0 ? behavior.STATE_EXPANDED : behavior.STATE_COLLAPSED);
        bottomSheet.setVisibility(View.VISIBLE);
        Log.d("Shit", "Slide" + behavior.getState());

    }
}
