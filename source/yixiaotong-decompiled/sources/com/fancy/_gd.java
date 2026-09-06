package com.fancy;

import android.view.View;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _gd implements _ng._b {
    public final /* synthetic */ _nf _a;
    public final /* synthetic */ _gc _b;

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
            if (_okVar == null || _gd.this._a == null) {
                return;
            }
            _okVar._f = System.currentTimeMillis();
            _gc _gcVar = _gd.this._b;
            View cView = _gcVar.getCView();
            _nf _nfVar = _gd.this._a;
            _gcVar._b(cView, _nfVar._c, _oj._a(this._b, this._c, this._d, this._e, this._f, _nfVar._d));
        }
    }

    public _gd(_gc _gcVar, _nf _nfVar) {
        this._b = _gcVar;
        this._a = _nfVar;
    }

    @Override // com.fancy._ng._b
    public final void _a(float f, float f2, float f3, double d, float f4) {
        AtomicBoolean atomicBoolean;
        if (this._a == null) {
            _ng._a(this._b._e);
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        _gc _gcVar = this._b;
        if (jCurrentTimeMillis - _gcVar._s < this._a._e) {
            return;
        }
        _f _fVar = _gcVar._c;
        if (_m5._a(_gcVar, _fVar != null ? _fVar._U : 0.1f) && this._b._b()) {
            if (this._b._b(true)) {
                if (!this._b._A.get()) {
                    _ok _okVar = new _ok(this._b.getCView());
                    _okVar._c = System.currentTimeMillis();
                    this._b.setOnTouchAction(_okVar);
                    _fv._a.post(new _a(_okVar, f, f2, f3, d, f4));
                }
                atomicBoolean = this._b._A;
            } else {
                _gc _gcVar2 = this._b;
                if (!_gcVar2._o) {
                    return;
                }
                View cView = _gcVar2.getCView();
                _nf _nfVar = this._a;
                _gcVar2._a(cView, _nfVar._c, _oj._a(f, f2, f3, d, f4, _nfVar._d));
                atomicBoolean = this._b._q;
            }
            atomicBoolean.set(true);
        }
    }
}
