package com.fancy.adsdk.lib;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _c implements Runnable {
    public final /* synthetic */ _d _a;

    public _c(_d _dVar) {
        this._a = _dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PtgAdSdk.Callback callback = this._a._a;
        if (callback != null) {
            callback.success();
        }
    }
}
