package com.kwad.sdk.widget.swipe;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class a {
    private boolean btP;

    protected abstract boolean XR();

    protected abstract boolean XS();

    public final boolean b(View view, MotionEvent motionEvent) {
        return !this.btP && XR();
    }

    public final boolean c(View view, MotionEvent motionEvent) {
        return !this.btP && XS();
    }
}
