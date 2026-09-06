package com.fancy;

import android.content.Context;
import android.content.DialogInterface;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _cw implements DialogInterface.OnClickListener {
    public final /* synthetic */ Context _a;
    public final /* synthetic */ _f _b;
    public final /* synthetic */ String _c;
    public final /* synthetic */ String _d;
    public final /* synthetic */ _eq _e;

    public _cw(Context context, _f _fVar, String str, String str2, _eq _eqVar) {
        this._a = context;
        this._b = _fVar;
        this._c = str;
        this._d = str2;
        this._e = _eqVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            _cv._a(this._a, this._b, this._c, this._d);
        }
        _eq _eqVar = this._e;
        if (_eqVar != null) {
            _eqVar._a(i);
        }
    }
}
