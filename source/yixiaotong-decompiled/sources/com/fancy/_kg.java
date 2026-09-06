package com.fancy;

import android.os.Looper;
import android.text.TextUtils;
import com.fancy.adsdk.lib.interf.PtgRewardVideoAd;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _kg implements Runnable {
    public final /* synthetic */ AtomicBoolean _a;
    public final /* synthetic */ _f _b;
    public final /* synthetic */ PtgRewardVideoAd _c;
    public final /* synthetic */ _kf _d;

    public _kg(_kk _kkVar, _f _fVar, _kf _kfVar, AtomicBoolean atomicBoolean) {
        this._d = _kfVar;
        this._a = atomicBoolean;
        this._b = _fVar;
        this._c = _kkVar;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:34:0x00a4  */
    @Override // java.lang.Runnable
    public final void run() {
        _kj _kjVar;
        boolean z;
        if (this._a.get()) {
            return;
        }
        _kf _kfVar = this._d;
        _f _fVar = this._b;
        PtgRewardVideoAd ptgRewardVideoAd = this._c;
        AtomicBoolean atomicBoolean = this._a;
        _kfVar.getClass();
        if (_fVar == null || ptgRewardVideoAd == null) {
            return;
        }
        if (_kfVar._b._c != null && _fVar._u() && !TextUtils.isEmpty(_fVar._o())) {
            String str_o = _fVar._o();
            AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
            _kh _khVar = new _kh(_kfVar, atomicBoolean2, str_o, atomicBoolean, _fVar, ptgRewardVideoAd);
            _fv._a.postDelayed(_khVar, 5000L);
            try {
                try {
                    _hz._a(_kfVar._b._c)._a(str_o, new _ki(_kfVar, atomicBoolean2, _khVar, atomicBoolean, _fVar, ptgRewardVideoAd));
                    return;
                } catch (Throwable unused) {
                    z = false;
                    if (atomicBoolean2.compareAndSet(z, true)) {
                        _fv._a.removeCallbacks(_khVar);
                        if (atomicBoolean.get()) {
                            return;
                        }
                        _fVar._J = true;
                        _kjVar = new _kj(ptgRewardVideoAd, _kfVar, atomicBoolean);
                        _fv _fvVar = _fv._a;
                        if (Looper.getMainLooper().equals(Looper.myLooper())) {
                            _kjVar.run();
                        } else {
                            _fv._a.post(_kjVar);
                        }
                    }
                    return;
                }
            } catch (Throwable unused2) {
                z = false;
            }
        } else if (atomicBoolean.get()) {
            return;
        }
        _fVar._J = true;
        _kjVar = new _kj(ptgRewardVideoAd, _kfVar, atomicBoolean);
        _fv _fvVar2 = _fv._a;
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            _kjVar.run();
        } else {
            _fv._a.post(_kjVar);
        }
    }
}
