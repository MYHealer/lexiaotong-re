package com.fancy;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ez implements _nk {
    public final /* synthetic */ _bb _a;

    public _ez(_ig _igVar) {
        this._a = _igVar;
    }

    @Override // com.fancy._nk
    public final void _a(Object obj) {
        _bb _bbVar = this._a;
        if (_bbVar != null) {
            _ig _igVar = (_ig) _bbVar;
            if (obj != null) {
                _ih._a _aVar = _igVar._a;
                if (_aVar != null) {
                    _aVar._b();
                    return;
                }
                return;
            }
            _ih._a _aVar2 = _igVar._a;
            if (_aVar2 != null) {
                _aVar2._a();
            }
        }
    }
}
