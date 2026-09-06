package com.fancy;

import com.fancy.adsdk.lib.PtgAdSdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _g3 implements Runnable {
    public final /* synthetic */ _g4 _a;

    public _g3(_g4 _g4Var) {
        this._a = _g4Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this._a._f = true;
        _g appLifecycleListener = PtgAdSdk.getAppLifecycleListener();
        _g4 _g4Var = _g4._b._a;
        if (_g4Var != null) {
            appLifecycleListener._a.add(_g4Var);
        } else {
            appLifecycleListener.getClass();
        }
        this._a._c();
    }
}
