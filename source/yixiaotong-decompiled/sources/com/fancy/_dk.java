package com.fancy;

import com.fancy.adsdk.lib.interf.PtgNativeExpressAd;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _dk implements Runnable {
    public final /* synthetic */ _dm _a;

    public _dk(_dm _dmVar) {
        this._a = _dmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PtgNativeExpressAd.AdInteractionListener adInteractionListener;
        _dm _dmVar = this._a;
        if (!com.fancy.adsdk.lib.utils._a._a(_dmVar._c, _dmVar._j) || (adInteractionListener = this._a._a) == null) {
            return;
        }
        adInteractionListener.onAdShow();
    }
}
