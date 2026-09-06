package com.fancy;

import android.os.Looper;
import com.fancy.adsdk.lib.interf.PtgRewardVideoAd;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _kh implements Runnable {
    public final /* synthetic */ AtomicBoolean _a;
    public final /* synthetic */ String _b;
    public final /* synthetic */ AtomicBoolean _c;
    public final /* synthetic */ _f _d;
    public final /* synthetic */ PtgRewardVideoAd _e;
    public final /* synthetic */ _kf _f;

    public _kh(_kf _kfVar, AtomicBoolean atomicBoolean, String str, AtomicBoolean atomicBoolean2, _f _fVar, PtgRewardVideoAd ptgRewardVideoAd) {
        this._f = _kfVar;
        this._a = atomicBoolean;
        this._b = str;
        this._c = atomicBoolean2;
        this._d = _fVar;
        this._e = ptgRewardVideoAd;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this._a.compareAndSet(false, true)) {
            try {
                _hz _hzVar_a = _hz._a(this._f._b._c);
                String str = this._b;
                _hzVar_a.getClass();
                String str_a = _i4._a(str);
                _i0 _i0Var = _hzVar_a._b.get(str_a);
                if (_i0Var != null) {
                    if (_i0Var._c) {
                        _i0Var._b = true;
                    }
                    _hzVar_a._b.remove(str_a);
                }
            } catch (Throwable unused) {
            }
            if (this._c.get()) {
                return;
            }
            try {
                if (_hz._a(this._f._b._c)._a(this._b)) {
                    this._d._J = true;
                }
            } catch (Throwable unused2) {
            }
            _kf _kfVar = this._f;
            PtgRewardVideoAd ptgRewardVideoAd = this._e;
            AtomicBoolean atomicBoolean = this._c;
            _kfVar.getClass();
            _kj _kjVar = new _kj(ptgRewardVideoAd, _kfVar, atomicBoolean);
            _fv _fvVar = _fv._a;
            if (Looper.getMainLooper().equals(Looper.myLooper())) {
                _kjVar.run();
            } else {
                _fv._a.post(_kjVar);
            }
        }
    }
}
