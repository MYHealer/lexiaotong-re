package com.fancy;

import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _o7 implements Runnable {
    public final /* synthetic */ _i _a;
    public final /* synthetic */ View _b;
    public final /* synthetic */ _o8 _c;

    public _o7(_o8 _o8Var, _i _iVar, View view) {
        this._c = _o8Var;
        this._a = _iVar;
        this._b = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this._c._a(this._a)) {
            this._c._h.set(true);
            _p5._a(this._b, 6);
        }
    }
}
