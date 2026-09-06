package com.fancy.mpsdk.activity;

import android.graphics.Bitmap;
import com.fancy._f;
import com.fancy._fg;
import com.fancy._lr;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _b implements _lr {
    public final /* synthetic */ _f _a;
    public final /* synthetic */ PtgInteractionPortraitActivity._c _b;

    public _b(_f _fVar, _a _aVar) {
        this._a = _fVar;
        this._b = _aVar;
    }

    @Override // com.fancy._lr
    public final void _a(Bitmap bitmap) {
        PtgInteractionPortraitActivity._c _cVar;
        if (this._a._u()) {
            _cVar = this._b;
            if (_cVar == null) {
                return;
            }
        } else {
            if (bitmap == null) {
                PtgInteractionPortraitActivity._c _cVar2 = this._b;
                if (_cVar2 != null) {
                    _a _aVar = (_a) _cVar2;
                    if (_aVar._b != null) {
                        _fg._a()._a(String.valueOf(_aVar._b.hashCode()), "资源加载异常");
                        _fg._a()._a(String.valueOf(_aVar._b.hashCode()));
                        return;
                    }
                    return;
                }
                return;
            }
            _cVar = this._b;
            if (_cVar == null) {
                return;
            }
        }
        ((_a) _cVar)._a();
    }
}
