package com.fancy;

import android.os.Looper;
import com.fancy.adsdk.lib.core.model.AdErrorImpl;
import com.fancy.adsdk.lib.model.AdError;
import com.fancy.adsdk.lib.provider.PtgAdNative;
import com.fancy.adsdk.lib.provider.arb.ArbitraryAdapter;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _kf implements Runnable {
    public final /* synthetic */ _r _a;
    public final /* synthetic */ _kl _b;

    public class _a implements _ef {
        public final /* synthetic */ _f _a;
        public final /* synthetic */ AtomicBoolean _b;

        public _a(_f _fVar, AtomicBoolean atomicBoolean) {
            this._a = _fVar;
            this._b = atomicBoolean;
        }

        @Override // com.fancy._ef
        public final void _a(long j) {
            _f _fVar = this._a;
            _fVar._m = (int) j;
            _kk _kkVar_a = _kf.this._a(_fVar, this._b);
            if (_kkVar_a != null) {
                _kf _kfVar = _kf.this;
                _f _fVar2 = this._a;
                AtomicBoolean atomicBoolean = this._b;
                _kfVar.getClass();
                _kg _kgVar = new _kg(_kkVar_a, _fVar2, _kfVar, atomicBoolean);
                _fv _fvVar = _fv._a;
                if (Looper.getMainLooper().equals(Looper.myLooper())) {
                    _kgVar.run();
                } else {
                    _fv._a.post(_kgVar);
                }
            }
        }
    }

    public _kf(_kl _klVar, _r _rVar) {
        this._b = _klVar;
        this._a = _rVar;
    }

    public final _kk _a(_f _fVar, AtomicBoolean atomicBoolean) {
        try {
            this._b._b._c(_fVar._m);
            try {
                _fVar._x = com.fancy.adsdk.lib.utils._a._a(String.valueOf(_fVar._m), _oi._a());
            } catch (Exception unused) {
                _fVar._x = "";
            }
            _ci _ciVar_i = this._b._b._i();
            if (_ciVar_i != null) {
                _ciVar_i._T = _fVar._l;
            }
            _kk _kkVar = new _kk(this, _fVar, String.valueOf(_fVar.hashCode()), atomicBoolean);
            PtgAdNative.RewardVideoAdListener rewardVideoAdListener = this._b._a;
            if (rewardVideoAdListener != null) {
                rewardVideoAdListener.onRewardVideoAdLoad(_kkVar);
            }
            return _kkVar;
        } catch (Exception unused2) {
            PtgAdNative.RewardVideoAdListener rewardVideoAdListener2 = this._b._a;
            if (rewardVideoAdListener2 != null) {
                rewardVideoAdListener2.onError(new AdErrorImpl(10001, AdError.ERROR_NO_AD_STR, (Object) null));
            }
            this._b._d._b = null;
            return null;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        List<_f> list;
        _r _rVar = this._a;
        List<_f> list2 = (_rVar == null || (list = _rVar._a) == null || list.isEmpty()) ? null : this._a._a;
        if (list2 == null) {
            PtgAdNative.RewardVideoAdListener rewardVideoAdListener = this._b._a;
            if (rewardVideoAdListener != null) {
                rewardVideoAdListener.onError(new AdErrorImpl(10001, AdError.ERROR_NO_AD_STR, (Object) null));
                return;
            }
            return;
        }
        _f _fVar = list2.get(0);
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        if (!_a9._a()) {
            _kk _kkVar_a = _a(_fVar, atomicBoolean);
            if (_kkVar_a != null) {
                _kg _kgVar = new _kg(_kkVar_a, _fVar, this, atomicBoolean);
                _fv _fvVar = _fv._a;
                if (Looper.getMainLooper().equals(Looper.myLooper())) {
                    _kgVar.run();
                    return;
                } else {
                    _fv._a.post(_kgVar);
                    return;
                }
            }
            return;
        }
        try {
            this._b._d._b = new ArbitraryAdapter();
            _kl _klVar = this._b;
            _klVar._d._b.setSts(_klVar._b._q());
            _kl _klVar2 = this._b;
            _klVar2._d._b.setKey(_klVar2._b._d());
            this._b._d._b.setReqId(_fVar._w);
            ArbitraryAdapter arbitraryAdapter = this._b._d._b;
            _l _lVar = _fVar._q;
            arbitraryAdapter.setAdLoaded(_lVar != null ? _lVar._a : 0L, _fVar._m, _lVar != null ? _lVar._c : 0L, _lVar != null ? _lVar._b : 0L);
            this._b._d._b.setAdLoadCallback(new _a(_fVar, atomicBoolean));
        } catch (Exception unused) {
            PtgAdNative.RewardVideoAdListener rewardVideoAdListener2 = this._b._a;
            if (rewardVideoAdListener2 != null) {
                rewardVideoAdListener2.onError(new AdErrorImpl(10001, AdError.ERROR_NO_AD_STR, (Object) null));
            }
        }
    }
}
