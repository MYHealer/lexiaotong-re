package com.fancy;

import com.fancy.adsdk.lib.interf.PtgAppDownloadListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _cz implements Runnable {
    public final /* synthetic */ String _a;
    public final /* synthetic */ String _b;

    public _cz(String str, String str2) {
        this._a = str;
        this._b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!_cv._c.get() || _cv._b.get()) {
            _cv._c.set(true);
            _cv._b.set(false);
            PtgAppDownloadListener ptgAppDownloadListener_a = _cv._a(this._a);
            if (ptgAppDownloadListener_a != null) {
                ptgAppDownloadListener_a.onInstalled(this._b);
            }
        }
    }
}
