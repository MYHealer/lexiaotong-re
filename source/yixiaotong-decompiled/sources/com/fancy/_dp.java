package com.fancy;

import com.fancy.adsdk.lib.interf.PtgNativeExpressAd;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _dp implements Runnable {
    public final /* synthetic */ _do _a;

    public _dp(_do _doVar) {
        this._a = _doVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PtgNativeExpressAd.AdInteractionListener adInteractionListener;
        this._a._a();
        _do _doVar = this._a;
        _n1._a(_doVar, _doVar._c);
        if (!this._a._O.compareAndSet(false, true) || (adInteractionListener = this._a._a) == null) {
            return;
        }
        adInteractionListener.onAdShow();
    }
}
