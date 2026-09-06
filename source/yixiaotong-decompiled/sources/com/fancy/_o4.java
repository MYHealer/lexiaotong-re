package com.fancy;

import android.view.View;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _o4 implements View.OnClickListener {
    public final /* synthetic */ _am _a;
    public final /* synthetic */ _f _b;
    public final /* synthetic */ String _c;
    public final /* synthetic */ _h _d;
    public final /* synthetic */ LinearLayout _e;
    public final /* synthetic */ _o8 _f;

    public _o4(_o8 _o8Var, _an _anVar, _f _fVar, String str, _h _hVar, LinearLayout linearLayout) {
        this._f = _o8Var;
        this._a = _anVar;
        this._b = _fVar;
        this._c = str;
        this._d = _hVar;
        this._e = linearLayout;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        _o8 _o8Var = this._f;
        if (_o8Var._b) {
            _o8._a(_o8Var, this._a, this._b, this._c, view, 4, null, true, false, this._d, this._e);
        }
    }
}
