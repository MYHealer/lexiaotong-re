package com.fancy.adsdk.lib.provider;

import android.content.Context;
import com.fancy._bk;
import com.fancy._ci;
import com.fancy.adsdk.lib.model.AdSlot;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _o implements Runnable {
    public final /* synthetic */ _ci _a;
    public final /* synthetic */ Context _b;
    public final /* synthetic */ AdSlot _c;
    public final /* synthetic */ _bk _d;
    public final /* synthetic */ _c _e;

    public _o(_c _cVar, _ci _ciVar, Context context, AdSlot adSlot, _bk _bkVar) {
        this._e = _cVar;
        this._a = _ciVar;
        this._b = context;
        this._c = adSlot;
        this._d = _bkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this._e._a(this._a).loadRewardVideoAd(this._b, this._c, this._d);
    }
}
