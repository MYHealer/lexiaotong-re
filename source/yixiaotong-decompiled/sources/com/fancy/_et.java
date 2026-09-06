package com.fancy;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _et implements _nk {
    public final /* synthetic */ _fo _a;

    public _et(_f7 _f7Var) {
        this._a = _f7Var;
    }

    @Override // com.fancy._nk
    public final void _a(Object obj) {
        if (obj instanceof Bitmap) {
            _fo _foVar = this._a;
            if (_foVar != null) {
                _foVar._a((Bitmap) obj);
                return;
            }
            return;
        }
        _fo _foVar2 = this._a;
        if (_foVar2 != null) {
            _foVar2._a();
        }
    }
}
