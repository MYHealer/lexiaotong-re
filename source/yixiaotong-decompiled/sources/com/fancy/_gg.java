package com.fancy;

import com.fancy.adsdk.lib.interf.PtgNativeExpressAd;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _gg implements Runnable {
    public final /* synthetic */ _gh _a;

    public _gg(_gh _ghVar) {
        this._a = _ghVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PtgNativeExpressAd.AdInteractionListener adInteractionListener;
        _f _fVar = this._a._c;
        if (_fVar == null || _fVar._t()) {
            _gh _ghVar = this._a;
            _n1._a(_ghVar._d, _ghVar._c);
            AtomicBoolean atomicBoolean = this._a._m;
            if (atomicBoolean != null && atomicBoolean.compareAndSet(false, true) && (adInteractionListener = this._a._g) != null) {
                adInteractionListener.onAdShow();
            }
            _g9 _g9Var = this._a._l;
            if (_g9Var != null) {
                ((_dj) _g9Var)._a();
            }
        }
    }
}
