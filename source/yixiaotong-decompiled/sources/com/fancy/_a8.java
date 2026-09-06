package com.fancy;

import android.app.Application;
import java.util.ArrayList;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _a8 implements _pe<Application> {
    public final _pf _a;
    public final ArrayList _b = new ArrayList();

    public _a8() {
        UUID.randomUUID().toString();
        _pf _pfVar = new _pf();
        this._a = _pfVar;
        _pfVar._a(null, this);
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
