package com.fancy;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ou {
    public static _ou _c;
    public static final AtomicBoolean _d = new AtomicBoolean();
    public final HashSet _a = new HashSet();
    public _m1 _b;

    public static synchronized _ou _a() {
        if (_c == null) {
            _c = new _ou();
        }
        return _c;
    }

    public final void _a(Set set, String str, _os _osVar, String str2) {
        _m1 _m1Var = this._b;
        if (_m1Var != null) {
            _m1Var._a(set, str, _osVar, str2);
            return;
        }
        _m1 _m1Var2 = new _m1();
        this._b = _m1Var2;
        _m1Var2._a(set, str, _osVar, str2);
    }
}
