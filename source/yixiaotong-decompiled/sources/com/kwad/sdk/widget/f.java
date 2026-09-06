package com.kwad.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class f extends ViewPager {
    private int btE;
    private boolean btF;

    public void setScrollable(boolean z) {
        this.btF = z;
    }

    public f(Context context) {
        super(context);
        this.btF = false;
    }

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.btF = false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.btF && super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.btF && super.onTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean canScrollHorizontally(int i) {
        if (this.btF) {
            return super.canScrollHorizontally(i);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.btF) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int x = (int) motionEvent.getX();
        int action = motionEvent.getAction();
        if (action == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 2) {
            int i = x - this.btE;
            if (getCurrentItem() == 0 && i > 0) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        this.btE = x;
        return super.dispatchTouchEvent(motionEvent);
    }
}
