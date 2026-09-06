package com.fancy;

import android.text.TextUtils;
import com.fancy.adsdk.lib.model.AppInfo;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _f implements Serializable {
    public int _B;
    public _ij _C;
    public String _D;
    public _f0 _E;
    public _fi _F;
    public _ba _G;
    public List<String> _H;
    public List<String> _I;
    public boolean _J;
    public long _K;
    public boolean _L;
    public String _M;
    public String _N;
    public String _O;
    public boolean _P;
    public boolean _Q;
    public boolean _R;
    public double _S;
    public int _T;
    public String _W;
    public int _a;
    public String _b;
    public AppInfo _c;
    public String _d;
    public String _e;
    public List<String> _f;
    public List<String> _g;
    public Map<String, List<String>> _h;
    public String _i;
    public int _j;
    public int _k;
    public String _l;
    public int _m;
    public int _n;
    public List<String> _o;
    public Map<Long, List<String>> _p;
    public _l _q;
    public String _r;
    public _i _s;
    public Map<String, String> _t;
    public _lt _u;
    public _oj _v;
    public String _w;
    public String _x;
    public long _y;
    public long _z;
    public boolean _A = false;
    public float _U = 0.1f;
    public int _V = 0;

    public final String _a() {
        return String.valueOf(hashCode());
    }

    public final AppInfo _b() {
        return this._c;
    }

    public final _jz _f() {
        List<_jz> list_h = _h();
        if (list_h == null || list_h.isEmpty()) {
            return null;
        }
        return list_h.get(0);
    }

    public final String _n() {
        _l3 _l3Var_m = _m();
        return _l3Var_m != null ? _l3Var_m._b : "";
    }

    public final String _o() {
        _l3 _l3Var_m = _m();
        return _l3Var_m != null ? _l3Var_m._a : "";
    }

    public final boolean _q() {
        _i _iVar = this._s;
        if (_iVar != null) {
            return _iVar._o;
        }
        return false;
    }

    public final boolean _r() {
        _i _iVar = this._s;
        if (_iVar != null) {
            return _iVar._v;
        }
        return false;
    }

    public final boolean _s() {
        _i _iVar = this._s;
        if (_iVar != null) {
            return _iVar._p;
        }
        return false;
    }

    public final boolean _t() {
        return this._y <= 0 || this._z <= 0 || System.currentTimeMillis() - this._z < this._y;
    }

    public final String _c() {
        AppInfo appInfo = this._c;
        return (appInfo == null || TextUtils.isEmpty(appInfo.getName())) ? "" : this._c.getName();
    }

    public final String _d() {
        _ij _ijVar = this._C;
        return _ijVar != null ? _ijVar._b : "";
    }

    public final int _e() {
        _ij _ijVar = this._C;
        if (_ijVar != null && _ijVar._a() && _ijVar._a()) {
            return _ijVar._f._e;
        }
        return 0;
    }

    public final int _g() {
        _ij _ijVar = this._C;
        if (_ijVar._a()) {
            _l3 _l3Var = _ijVar._f;
            if (_l3Var != null) {
                return _l3Var._d;
            }
            return 0;
        }
        List<_jz> list_h = _h();
        if (list_h == null || list_h.isEmpty()) {
            return 0;
        }
        return list_h.get(0)._c;
    }

    public final List<_jz> _h() {
        _ij _ijVar = this._C;
        if (_ijVar != null) {
            return _ijVar._e;
        }
        return null;
    }

    public final String _i() {
        _ij _ijVar = this._C;
        if (_ijVar != null) {
            return _ijVar._c;
        }
        return null;
    }

    public final String _j() {
        _ij _ijVar = this._C;
        return _ijVar != null ? _ijVar._d : "";
    }

    public final String _k() {
        _ij _ijVar = this._C;
        return _ijVar != null ? _ijVar._h : "";
    }

    public final String _l() {
        _ij _ijVar = this._C;
        return _ijVar != null ? _ijVar._a : "";
    }

    public final _l3 _m() {
        _ij _ijVar = this._C;
        if (_ijVar != null) {
            return _ijVar._f;
        }
        return null;
    }

    public final int _p() {
        _ij _ijVar = this._C;
        if (_ijVar._a()) {
            _l3 _l3Var = _ijVar._f;
            if (_l3Var != null) {
                return _l3Var._c;
            }
            return 0;
        }
        List<_jz> list_h = _h();
        if (list_h == null || list_h.isEmpty()) {
            return 0;
        }
        return list_h.get(0)._b;
    }

    public final boolean _u() {
        _ij _ijVar = this._C;
        if (_ijVar != null) {
            return _ijVar._a();
        }
        return false;
    }
}
