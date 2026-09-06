package com.fancy;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _o0 implements _ih._a {
    public final /* synthetic */ _nx _a;

    public _o0(_nx _nxVar) {
        this._a = _nxVar;
    }

    @Override // com.fancy._ih._a
    public final void _a() {
    }

    @Override // com.fancy._ih._a
    public final void _b() {
        _nx _nxVar = this._a;
        _f _fVar = _nxVar._m;
        if (_fVar != null) {
            _fVar._J = true;
        }
        if (_nxVar._i != null && !_nxVar._s) {
            this._a._i.onRenderSuccess();
        }
        this._a._s = true;
    }
}
