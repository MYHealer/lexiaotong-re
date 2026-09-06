package com.ubixnow.adtype.banner.api;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UMNBannerView extends FrameLayout {
    private static final String TAG = "UMNBannerView";
    public View mAdView;
    public boolean mIsInWindow;

    public UMNBannerView(Context context) {
        super(context);
    }

    public UMNBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public UMNBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void unregisterView(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setOnClickListener(null);
            if (childAt instanceof ViewGroup) {
                unregisterView((ViewGroup) childAt);
            } else {
                childAt.setOnClickListener(null);
            }
        }
    }

    public boolean isAttachInWindow() {
        return this.mIsInWindow;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsInWindow = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mIsInWindow = false;
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
    }

    public void renderView(View view) {
        try {
            View view2 = this.mAdView;
            if (view2 != null) {
                removeView(view2);
            }
            this.mAdView = view;
            addView(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
