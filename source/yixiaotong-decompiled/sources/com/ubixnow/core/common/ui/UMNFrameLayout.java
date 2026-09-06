package com.ubixnow.core.common.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UMNFrameLayout extends FrameLayout {
    private boolean OooO00o;
    private OooO00o OooO0O0;

    public interface OooO00o {
        void visibleChange(boolean z);
    }

    public UMNFrameLayout(Context context) {
        super(context);
    }

    public UMNFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public UMNFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.OooO00o) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.OooO0O0 = null;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        OooO00o oooO00o = this.OooO0O0;
        if (oooO00o != null) {
            oooO00o.visibleChange(z);
        }
    }

    public void setFlag(boolean z) {
        this.OooO00o = z;
    }

    public void setVisibleChangeListener(OooO00o oooO00o) {
        this.OooO0O0 = oooO00o;
    }
}
