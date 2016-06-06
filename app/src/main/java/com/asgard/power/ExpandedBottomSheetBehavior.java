package com.asgard.power;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;


public class ExpandedBottomSheetBehavior<V extends View> extends android.support.design.widget.BottomSheetBehavior<V> {

    public ExpandedBottomSheetBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onLayoutChild(final CoordinatorLayout parent, final V child, final int layoutDirection) {
        SavedState dummySavedState = new SavedState(super.onSaveInstanceState(parent, child), STATE_HIDDEN);
        super.onRestoreInstanceState(parent, child, dummySavedState);
        return super.onLayoutChild(parent, child, layoutDirection);

    }
}
