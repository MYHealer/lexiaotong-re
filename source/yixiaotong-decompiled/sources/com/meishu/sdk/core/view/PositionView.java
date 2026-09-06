package com.meishu.sdk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class PositionView extends View {
    private TouchAdContainer.OnWindownEventListener windownEventListener;

    public interface OnWindownEventListener {
        void onAttachedToWindow();

        void onDetachedFromWindow();

        void onWindowFocusChanged(boolean z);
    }

    public PositionView(Context context) {
        super(context);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TouchAdContainer.OnWindownEventListener onWindownEventListener = this.windownEventListener;
        if (onWindownEventListener != null) {
            onWindownEventListener.onAttachedToWindow();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        TouchAdContainer.OnWindownEventListener onWindownEventListener = this.windownEventListener;
        if (onWindownEventListener != null) {
            onWindownEventListener.onDetachedFromWindow();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        TouchAdContainer.OnWindownEventListener onWindownEventListener = this.windownEventListener;
        if (onWindownEventListener != null) {
            onWindownEventListener.onWindowFocusChanged(z);
        }
    }

    public void setOnWindownEventListener(TouchAdContainer.OnWindownEventListener onWindownEventListener) {
        this.windownEventListener = onWindownEventListener;
    }

    public PositionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PositionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
