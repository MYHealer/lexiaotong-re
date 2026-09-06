package com.fancy;

import android.os.Looper;
import com.fancy.adsdk.lib.interf.PtgRewardVideoAd;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ki implements Runnable {
    public final /* synthetic */ AtomicBoolean _a;
    public final /* synthetic */ Runnable _b;
    public final /* synthetic */ AtomicBoolean _c;
    public final /* synthetic */ _f _d;
    public final /* synthetic */ PtgRewardVideoAd _e;
    public final /* synthetic */ _kf _f;

    public _ki(_kf _kfVar, AtomicBoolean atomicBoolean, _kh _khVar, AtomicBoolean atomicBoolean2, _f _fVar, PtgRewardVideoAd ptgRewardVideoAd) {
        this._f = _kfVar;
        this._a = atomicBoolean;
        this._b = _khVar;
        this._c = atomicBoolean2;
        this._d = _fVar;
        this._e = ptgRewardVideoAd;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this._a.compareAndSet(false, true)) {
            _fv._a.removeCallbacks(this._b);
            if (this._c.get()) {
                return;
            }
            this._d._J = true;
            _kf _kfVar = this._f;
            PtgRewardVideoAd ptgRewardVideoAd = this._e;
            AtomicBoolean atomicBoolean = this._c;
            _kfVar.getClass();
            _kj _kjVar = new _kj(ptgRewardVideoAd, _kfVar, atomicBoolean);
            if (Looper.getMainLooper().equals(Looper.myLooper())) {
                _kjVar.run();
            } else {
                _fv._a.post(_kjVar);
            }
        }
    }
}
