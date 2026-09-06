package com.fancy;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.fancy.adsdk.lib.utils.TextUtil;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _jd {
    public final _f _a;
    public String _b;
    public View _c;
    public View _d;
    public long _e;
    public _i _f;
    public boolean _g;
    public boolean _h;
    public boolean _i;
    public boolean _j;
    public boolean _k;
    public boolean _l;
    public boolean _m;
    public int _n;
    public _b _o;
    public boolean _t;
    public final AtomicBoolean _p = new AtomicBoolean(false);
    public final AtomicBoolean _q = new AtomicBoolean(false);
    public final AtomicBoolean _r = new AtomicBoolean(false);
    public final AtomicBoolean _s = new AtomicBoolean(false);
    public final Handler _u = new Handler(Looper.getMainLooper());
    public final _a _v = new _a();

    public class _a implements Runnable {
        public _a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            View view = _jd.this._d;
            if (view != null && view.hasWindowFocus() && _jd.this._b()) {
                _jd.this._p.set(true);
                _p5._a(_jd.this._d, 6);
            }
        }
    }

    public interface _b {
        void _a(View view, int i, _oj _ojVar);

        void _a(boolean z);

        void _b(View view, int i, _oj _ojVar);
    }

    public _jd(_f _fVar, _b _bVar) {
        this._a = _fVar;
        this._o = _bVar;
        if (_fVar != null) {
            this._b = _fVar._a();
        }
    }

    public final boolean _a() {
        _i _iVar = this._f;
        if (_iVar != null && !_iVar._n && this._s.get()) {
            return false;
        }
        _i _iVar2 = this._f;
        if (_iVar2 == null || !_iVar2._n) {
            return !this._t;
        }
        return true;
    }

    public final boolean _b() {
        return _io._a(this._b) && this._j && !this._p.get() && this._l;
    }

    public final void _c() {
        _a _aVar;
        this._p.set(true);
        this._q.set(true);
        this._r.set(true);
        this._j = false;
        this._g = false;
        this._l = false;
        this._k = false;
        this._m = false;
        Handler handler = this._u;
        if (handler != null && (_aVar = this._v) != null) {
            handler.removeCallbacks(_aVar);
        }
        _io._b(this._b);
        _ng._a(this._b);
    }

    public final void _a(Activity activity) {
        _f _fVar;
        _nf _nfVar_a;
        _jf _jfVar;
        List<Integer> list;
        if (activity == null || (_fVar = this._a) == null) {
            return;
        }
        this._e = _fVar._K;
        try {
            ConcurrentHashMap<String, Long> concurrentHashMap = _io._a;
            if (!(!concurrentHashMap.isEmpty())) {
                _i _iVar = _fVar._s;
                this._f = _iVar;
                if (_iVar != null) {
                    boolean z_d = _iVar._d();
                    this._j = z_d;
                    this._g = this._f._d(z_d);
                    this._h = this._f._c();
                    List<Integer> list2 = this._f._g;
                    this._i = list2 != null && list2.contains(5);
                    this._k = this._f._b(this._j);
                    this._l = this._f._c(this._j);
                    _i _iVar2 = this._f;
                    this._n = _iVar2._j;
                    this._m = this._j && (list = _iVar2._g) != null && list.contains(4);
                }
            }
            View view = this._c;
            if (view != null) {
                view.setEnabled(this._g || this._l);
                if (this._g || this._l) {
                    this._c.setOnClickListener(new _jc(this));
                }
            }
            _b _bVar = this._o;
            if (_bVar != null) {
                _bVar._a(this._h && _a());
            }
            if (this._f != null && this._j) {
                String str = this._b;
                if (!TextUtils.isEmpty(str)) {
                    concurrentHashMap.put(str, Long.valueOf(System.currentTimeMillis()));
                }
                if (_b()) {
                    if (1 == this._n) {
                        _nfVar_a = _nf._a(this._b, true, this._f);
                        _jfVar = new _jf(this, _nfVar_a);
                        _ng._a(activity, _jfVar, _nfVar_a);
                    } else if (TextUtil.isEmpty(_fVar._M)) {
                        long j_a = this._f._a();
                        this._u.removeCallbacks(this._v);
                        this._u.postDelayed(this._v, j_a);
                    }
                } else if (_io._a(this._b) && this._j && !this._r.get() && (this._k || this._l)) {
                    _nfVar_a = _nf._a(this._b, false, this._f);
                    _jfVar = new _jf(this, _nfVar_a);
                    _ng._a(activity, _jfVar, _nfVar_a);
                } else if (this._i && _a()) {
                    _nf _nfVar_a2 = _nf._a(this._b, this._f);
                    _ng._a(activity, new _jf(this, _nfVar_a2), _nfVar_a2);
                }
                if (_io._a(this._b) && this._j && !this._q.get() && this._m && this._d != null && _io._a(this._b) && this._j && !this._q.get() && this._m && !_b()) {
                    this._d.setOnTouchListener(new _je(this, activity));
                    return;
                }
                return;
            }
            if (this._i && _a()) {
                _nf _nfVar_a3 = _nf._a(this._b, this._f);
                _ng._a(activity, new _jf(this, _nfVar_a3), _nfVar_a3);
            }
        } catch (Exception unused) {
        }
    }

    public final void _a(boolean z) {
        Context context;
        _nf _nfVar_a;
        _jf _jfVar;
        this._t = z;
        try {
            _b _bVar = this._o;
            if (_bVar != null) {
                _bVar._a(this._h && _a());
            }
            View view = this._c;
            if (view == null || view.getContext() == null) {
                return;
            }
            if (_b()) {
                if (1 != this._n) {
                    return;
                }
                context = this._c.getContext();
                _nfVar_a = _nf._a(this._b, true, this._f);
                _jfVar = new _jf(this, _nfVar_a);
            } else if (_io._a(this._b) && this._j && !this._r.get() && (this._k || this._l)) {
                context = this._c.getContext();
                _nfVar_a = _nf._a(this._b, false, this._f);
                _jfVar = new _jf(this, _nfVar_a);
            } else {
                if (this._i && _a()) {
                    Context context2 = this._c.getContext();
                    _nf _nfVar_a2 = _nf._a(this._b, this._f);
                    _ng._a(context2, new _jf(this, _nfVar_a2), _nfVar_a2);
                    return;
                }
                return;
            }
            _ng._a(context, _jfVar, _nfVar_a);
        } catch (Exception unused) {
        }
    }
}
