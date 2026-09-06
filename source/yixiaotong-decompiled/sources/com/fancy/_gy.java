package com.fancy;

import com.fancy.adsdk.lib.model.AdSlot;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _gy implements Runnable {
    public final /* synthetic */ AdSlot _a;
    public final /* synthetic */ _b4 _b;

    public _gy(AdSlot adSlot, _b4 _b4Var) {
        this._a = adSlot;
        this._b = _b4Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        _m4._b(this._a, this._b);
    }
}
