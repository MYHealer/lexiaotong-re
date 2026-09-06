package com.fancy;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _m2 implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ _m3 _a;

    public _m2(_m3 _m3Var) {
        this._a = _m3Var;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        View view = this._a._o.get();
        if (view == null) {
            return true;
        }
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this);
        }
        this._a._a(view.getWidth(), view.getHeight());
        return true;
    }
}
