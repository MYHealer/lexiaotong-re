package com.fancy;

import com.fancy.adsdk.lib.interf.PtgNativeExpressAd;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _dq implements Runnable {
    public final /* synthetic */ _do _a;

    public _dq(_do _doVar) {
        this._a = _doVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PtgNativeExpressAd.AdInteractionListener adInteractionListener;
        _do _doVar = this._a;
        if (!com.fancy.adsdk.lib.utils._a._a(_doVar._c, _doVar._O) || (adInteractionListener = this._a._a) == null) {
            return;
        }
        adInteractionListener.onAdShow();
    }
}
