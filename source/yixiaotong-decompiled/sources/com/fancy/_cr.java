package com.fancy;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _cr implements Runnable {
    public final /* synthetic */ _cu._a _a;
    public final /* synthetic */ int _b;
    public final /* synthetic */ int _c;
    public final /* synthetic */ String _d;

    public _cr(_cu._a _aVar, int i, int i2, String str) {
        this._a = _aVar;
        this._b = i;
        this._c = i2;
        this._d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        _cu._a _aVar = this._a;
        if (_aVar != null) {
            _d2 _d2Var = (_d2) _aVar;
            _d2Var._d._a(this._b, this._c, this._d, _d2Var._a, _d2Var._b, _d2Var._c);
        }
    }
}
