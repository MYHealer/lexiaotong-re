package com.fancy;

import android.widget.LinearLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _o6 implements _ng._b {
    public final /* synthetic */ LinearLayout _a;
    public final /* synthetic */ _nf _b;
    public final /* synthetic */ long _c;
    public final /* synthetic */ _am _d;
    public final /* synthetic */ _f _e;
    public final /* synthetic */ String _f;
    public final /* synthetic */ _i _g;
    public final /* synthetic */ boolean _h;
    public final /* synthetic */ _h _i;
    public final /* synthetic */ _o8 _j;

    public _o6(_o8 _o8Var, LinearLayout linearLayout, _nf _nfVar, long j, _am _amVar, _f _fVar, String str, _i _iVar, boolean z, _h _hVar) {
        this._j = _o8Var;
        this._a = linearLayout;
        this._b = _nfVar;
        this._c = j;
        this._d = _amVar;
        this._e = _fVar;
        this._f = str;
        this._g = _iVar;
        this._h = z;
        this._i = _hVar;
    }

    @Override // com.fancy._ng._b
    public final void _a(float f, float f2, float f3, double d, float f4) {
        if (this._a == null || this._b == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this._c;
        _nf _nfVar = this._b;
        if (jCurrentTimeMillis < _nfVar._e) {
            return;
        }
        _o8._a(this._j, this._d, this._e, this._f, this._a, _nfVar._c, _oj._a(f, f2, f3, d, f4, _nfVar._d), this._g._d(), this._h, this._i, this._a);
    }
}
