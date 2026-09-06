package com.fancy;

import com.fancy.adsdk.lib.interf.PtgNativeExpressAd;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _gk implements Runnable {
    public final /* synthetic */ _gl _a;

    public _gk(_gl _glVar) {
        this._a = _glVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PtgNativeExpressAd.AdInteractionListener adInteractionListener;
        _f _fVar = this._a._c;
        if (_fVar == null || _fVar._t()) {
            _gl _glVar = this._a;
            _n1._a(_glVar._d, _glVar._c);
            AtomicBoolean atomicBoolean = this._a._o;
            if (atomicBoolean != null && atomicBoolean.compareAndSet(false, true) && (adInteractionListener = this._a._i) != null) {
                adInteractionListener.onAdShow();
            }
            _g9 _g9Var = this._a._n;
            if (_g9Var != null) {
                ((_dj) _g9Var)._a();
            }
        }
    }
}
