package com.fancy;

import com.fancy.adsdk.lib.interf.PtgAd;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ii implements _pe<PtgAd> {
    public final _pf _a;
    public ArrayList _b = new ArrayList();
    public WeakReference<PtgAd> _c;

    public _ii(_x _xVar, PtgAd ptgAd) {
        new WeakReference(_xVar);
        this._c = new WeakReference<>(ptgAd);
        _pf _pfVar = new _pf();
        this._a = _pfVar;
        _pfVar._a(_xVar, this);
    }

    @Override // com.fancy._pe
    public final _pe _a(_pg _pgVar) {
        synchronized (this._b) {
            if (!this._b.contains(_pgVar)) {
                this._b.add(_pgVar);
            }
        }
        this._a._a(_pgVar);
        return this;
    }

    @Override // com.fancy._pe
    public final _pf _r() {
        return this._a;
    }
}
