package com.miui.zeus.mimo.sdk.ad.nativead.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.miui.zeus.mimo.sdk.n6;
import com.miui.zeus.mimo.sdk.view.component.RootICP;
import ijiami_1011.NCall;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class NativeAdView extends RootICP {
    private int mEvent;

    public NativeAdView(Context context) {
        super(context);
        this.mEvent = 0;
    }

    public NativeAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mEvent = 0;
    }

    public NativeAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mEvent = 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return NCall.IZ(new Object[]{210, this, motionEvent});
    }

    public int getEvent() {
        return NCall.II(new Object[]{211, this});
    }

    public n6 getViewEventInfo() {
        return (n6) NCall.IL(new Object[]{212, this});
    }

    public void resetEvent() {
        NCall.IV(new Object[]{213, this});
    }
}
