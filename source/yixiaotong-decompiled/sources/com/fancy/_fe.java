package com.fancy;

import android.app.Activity;
import com.fancy.mpsdk.activity.PtgInteractionPortraitActivity;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _fe implements _4 {
    public final /* synthetic */ _f2 _a;
    public final /* synthetic */ Activity _b;
    public final /* synthetic */ _fc _c;

    public _fe(_fc _fcVar, PtgInteractionPortraitActivity._a _aVar, Activity activity) {
        this._c = _fcVar;
        this._a = _aVar;
        this._b = activity;
    }

    public final void _a(String str) {
        _fc _fcVar = this._c;
        _f2 _f2Var = this._a;
        _fcVar.getClass();
        try {
            _fg._a()._a(_fcVar._c, str);
            _fcVar._f = true;
            if (_f2Var != null) {
                PtgInteractionPortraitActivity.this.onBackPressed();
            }
            _jd _jdVar = _fcVar._g;
            if (_jdVar != null) {
                _jdVar._c();
                _jdVar._c = null;
                _jdVar._d = null;
                _jdVar._o = null;
                _fcVar._g = null;
            }
        } catch (Exception unused) {
        }
    }
}
