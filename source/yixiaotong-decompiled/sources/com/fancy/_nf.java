package com.fancy;

import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _nf {
    public String _a;
    public int _b;
    public int _c;
    public boolean _d;
    public long _e;
    public _n6 _f;

    public static _nf _a(String str, boolean z, _i _iVar) {
        int i;
        int i2;
        List<Integer> list;
        float f;
        float f2;
        _n6 _n6Var_a;
        List<Integer> list2;
        _nf _nfVar = new _nf();
        _nfVar._a = str;
        if (_iVar != null) {
            boolean z2 = false;
            if (_iVar._b()) {
                i = 0;
            } else {
                List<Integer> list3 = _iVar._g;
                i = (list3 != null && list3.contains(1) && _iVar._d()) ? _iVar._h : _iVar._b;
            }
            _nfVar._b = i;
            if (_iVar._b()) {
                i2 = 7;
            } else {
                i2 = (_iVar._d() && (list = _iVar._g) != null && list.contains(1)) ? 5 : 1;
            }
            _nfVar._c = i2;
            if (z || (_iVar._d() && (list2 = _iVar._g) != null && list2.contains(1))) {
                z2 = true;
            }
            _nfVar._d = z2;
            _nfVar._e = z ? _iVar._a() : _iVar._c;
            if (_iVar._b()) {
                _n6Var_a = _n6._a(0.0f, 0.0f);
            } else {
                List<Integer> list4 = _iVar._g;
                if (list4 != null && list4.contains(1) && _iVar._d()) {
                    f = _iVar._s;
                    f2 = _iVar._u;
                } else {
                    f = _iVar._r;
                    f2 = _iVar._t;
                }
                _n6Var_a = _n6._a(f, f2);
            }
            _nfVar._f = _n6Var_a;
        }
        return _nfVar;
    }

    public static _nf _a(String str, _i _iVar) {
        _nf _nfVar = new _nf();
        _nfVar._a = str;
        if (_iVar != null) {
            _nfVar._b = _iVar._b;
            _nfVar._c = 1;
            _nfVar._d = false;
            _nfVar._e = _iVar._c;
            _nfVar._f = _n6._a(_iVar._r, _iVar._t);
        }
        return _nfVar;
    }
}
