package com.fancy;

import com.fancy.adsdk.lib.interf.PtgSplashAd;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _nz implements Runnable {
    public final /* synthetic */ _k _a;
    public final /* synthetic */ _nx _b;

    public _nz(_nx _nxVar, _k _kVar) {
        this._b = _nxVar;
        this._a = _kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        _k _kVar;
        int i;
        PtgSplashAd.AdInteractionListener adInteractionListener = this._b._i;
        if (adInteractionListener == null || (_kVar = this._a) == null || (i = _kVar._a) <= 0) {
            return;
        }
        adInteractionListener.onDismiss(i);
    }
}
