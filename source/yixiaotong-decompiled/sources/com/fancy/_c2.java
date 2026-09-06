package com.fancy;

import android.content.Context;
import android.net.Uri;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _c2 {
    public final int _a;
    public final int _b;
    public final _m3 _c;
    public _bz _d;

    public _c2(_m3 _m3Var) {
        this._c = _m3Var;
        String str = _m3Var._b;
        this._a = _m3Var._d;
        this._b = _m3Var._e;
    }

    public final _bz _a() throws IOException {
        _bz._a _cVar;
        Context context;
        String str_c;
        if (this._d == null) {
            _m3 _m3Var = this._c;
            String str = _m3Var._b;
            boolean z = false;
            if (str.startsWith("http")) {
                _b0 _b0Var = new _b0(str);
                com.fancy.adsdk.lib.doodle._a _aVar = com.fancy.adsdk.lib.doodle._b._a;
                synchronized (_aVar) {
                    if (_aVar._a()) {
                        com.fancy.adsdk.lib.doodle._a._b _bVar = (com.fancy.adsdk.lib.doodle._a._b) _aVar._h.get(_b0Var);
                        if (_bVar != null) {
                            int i = _aVar._e;
                            _bVar._c = i;
                            _aVar._g.putInt(_bVar._b, i);
                            _aVar._e++;
                        }
                        str_c = _bVar != null ? _aVar._c(_b0Var) : null;
                    } else {
                        str_c = null;
                    }
                }
                if (str_c == null || !new File(str_c).exists()) {
                    _aVar._a(_b0Var);
                    str_c = null;
                }
                if (str_c != null) {
                    _cVar = new _bz._b(new File(str_c));
                    z = true;
                } else {
                    if (_m3Var._i) {
                        throw new IOException("No cache");
                    }
                    int i2 = _m3Var._k;
                    _il._a(i2);
                    if (i2 == 4 || i2 == 2) {
                        String str2 = _bn._a;
                        _cVar = new _bz._b(com.fancy.adsdk.lib.doodle._b._a(com.fancy.adsdk.lib.doodle._b._a(1, str), _b0Var, true));
                    } else {
                        String str3 = _bn._a;
                        _cVar = new _bz._c(str, com.fancy.adsdk.lib.doodle._b._a(1, str), null);
                    }
                }
            } else if (str.startsWith("file:///android_asset/")) {
                _cVar = new _bz._c(str, _p3._a.getAssets().open(str.substring(22)), null);
            } else if (str.startsWith("file://")) {
                _cVar = new _bz._b(new File(str.substring(7)));
            } else {
                String str4 = _bn._a;
                Uri uri = _m3Var._c;
                if (uri == null) {
                    uri = Uri.parse(str);
                }
                if (_p3._b == null && (context = _p3._a) != null) {
                    _p3._b = context.getContentResolver();
                }
                _cVar = new _bz._c(str, _p3._b.openInputStream(uri), uri);
            }
            this._d = new _bz(str, _cVar, z);
        }
        return this._d;
    }
}
