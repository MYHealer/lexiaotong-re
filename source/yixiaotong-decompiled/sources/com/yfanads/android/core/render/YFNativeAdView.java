package com.yfanads.android.core.render;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class YFNativeAdView extends FrameLayout {
    View mAdView;

    public YFNativeAdView(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
    }

    public YFNativeAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void renderView(View view) {
        View view2 = this.mAdView;
        if (view2 != null) {
            removeView(view2);
        }
        this.mAdView = view;
        addView(view);
    }

    public YFNativeAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
