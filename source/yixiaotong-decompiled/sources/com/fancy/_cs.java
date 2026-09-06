package com.fancy;

import com.fancy.adsdk.lib.constants.PtgErrorCode;
import com.fancy.adsdk.lib.utils.Logger;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _cs implements Runnable {
    public final /* synthetic */ AtomicBoolean _a;
    public final /* synthetic */ _cu._a _b;
    public final /* synthetic */ _cu _c;

    public _cs(_cu _cuVar, AtomicBoolean atomicBoolean, _d2 _d2Var) {
        this._c = _cuVar;
        this._a = atomicBoolean;
        this._b = _d2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this._a.getAndSet(true)) {
            return;
        }
        Logger.d("PTG_QM_TAG timeout");
        _cu._a(this._c, this._b, 0, PtgErrorCode.SDK_REQUEST_OVER_TIME, "Operation timeout");
    }
}
