package com.fancy;

import android.view.View;
import com.fancy.adsdk.lib.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _jf implements _ng._b {
    public final /* synthetic */ _nf _a;
    public final /* synthetic */ _jd _b;

    public class _a implements Runnable {
        public final /* synthetic */ _ok _a;
        public final /* synthetic */ float _b;
        public final /* synthetic */ float _c;
        public final /* synthetic */ float _d;
        public final /* synthetic */ double _e;
        public final /* synthetic */ float _f;

        public _a(_ok _okVar, float f, float f2, float f3, double d, float f4) {
            this._a = _okVar;
            this._b = f;
            this._c = f2;
            this._d = f3;
            this._e = d;
            this._f = f4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            _ok _okVar = this._a;
            if (_okVar == null || _jf.this._a == null) {
                return;
            }
            _okVar._f = System.currentTimeMillis();
            _jf _jfVar = _jf.this;
            _jd _jdVar = _jfVar._b;
            _jd._b _bVar = _jdVar._o;
            if (_bVar != null) {
                View view = _jdVar._d;
                _nf _nfVar = _jfVar._a;
                _bVar._a(view, _nfVar._c, _oj._a(this._b, this._c, this._d, this._e, this._f, _nfVar._d));
            }
        }
    }

    public _jf(_jd _jdVar, _nf _nfVar) {
        this._b = _jdVar;
        this._a = _nfVar;
    }

    @Override // com.fancy._ng._b
    public final void _a(float f, float f2, float f3, double d, float f4) {
        _jd._b _bVar;
        _jd _jdVar = this._b;
        if (_jdVar._c == null || this._a == null) {
            _ng._a(_jdVar._b);
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        _jd _jdVar2 = this._b;
        if (jCurrentTimeMillis - _jdVar2._e >= this._a._e && _jdVar2._c.getWindowVisibility() == 0) {
            if (this._b._r.get()) {
                _jd _jdVar3 = this._b;
                if (!_jdVar3._i || (_bVar = _jdVar3._o) == null) {
                    return;
                }
                View view = _jdVar3._d;
                _nf _nfVar = this._a;
                _bVar._b(view, _nfVar._c, _oj._a(f, f2, f3, d, f4, _nfVar._d));
                this._b._s.set(true);
                return;
            }
            this._b._r.set(true);
            View view2 = this._b._d;
            if (view2 != null) {
                _ok _okVar = new _ok(view2);
                _okVar._c = System.currentTimeMillis();
                this._b._d.setTag(R.id.fancy_native_view_tag, _okVar);
                this._b._d.post(new _a(_okVar, f, f2, f3, d, f4));
            }
        }
    }
}
