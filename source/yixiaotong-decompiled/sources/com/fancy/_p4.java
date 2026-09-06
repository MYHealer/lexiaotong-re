package com.fancy;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _p4 implements Runnable {
    public final /* synthetic */ View _a;
    public final /* synthetic */ long _b;
    public final /* synthetic */ long _c;
    public final /* synthetic */ int _d;
    public final /* synthetic */ int _e;

    public _p4(View view, long j, long j2, int i, int i2) {
        this._a = view;
        this._b = j;
        this._c = j2;
        this._d = i;
        this._e = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this._a != null) {
            MotionEvent motionEventObtain = MotionEvent.obtain(this._b, this._c, 1, this._d, this._e, 0);
            this._a.dispatchTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
        }
    }
}
