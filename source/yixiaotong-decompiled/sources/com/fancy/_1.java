package com.fancy;

import com.fancy.adsdk.lib.core.model.AdErrorImpl;
import com.fancy.adsdk.lib.model.AdError;
import com.fancy.adsdk.lib.utils.Logger;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _1 implements _b4<_r> {
    public final _t _a;
    public AtomicInteger _b;
    public AtomicBoolean _c = new AtomicBoolean();
    public _b4<_r> _d;

    public _1(_t _tVar, int i, _b4 _b4Var) {
        this._a = _tVar;
        this._b = new AtomicInteger(i);
        this._d = _b4Var;
    }

    public final void _a(_t _tVar, AdError adError) {
        boolean z;
        _r _rVar;
        if (adError != null) {
            _b4<_r> _b4Var = this._d;
            if (_b4Var != null) {
                _b4Var.onError(adError);
                return;
            }
            return;
        }
        _b4<_r> _b4Var2 = this._d;
        if (_b4Var2 != null) {
            _al _alVar = (_al) _tVar;
            synchronized (_alVar._b) {
                z = false;
                if (_alVar._b.isEmpty()) {
                    _rVar = null;
                } else {
                    _rVar = (_r) _alVar._b.remove(0);
                    z = true;
                }
            }
            if (z) {
                _alVar._b();
            }
            _b4Var2._a(_rVar);
        }
    }

    @Override // com.fancy._b4
    public final void onError(AdError adError) {
        if (this._b.decrementAndGet() == 0 && this._c.compareAndSet(false, true)) {
            _t _tVar = this._a;
            if (adError == null) {
                adError = new AdErrorImpl(10001, AdError.ERROR_NO_AD_STR, (Object) null);
            }
            _a(_tVar, adError);
        }
    }

    @Override // com.fancy._b4
    public final void _a(_r _rVar) {
        _r _rVar2 = _rVar;
        this._b.decrementAndGet();
        if (_rVar2 != null) {
            _al _alVar = (_al) this._a;
            if (_alVar._d.get()) {
                synchronized (_alVar._b) {
                    _alVar._b.add(_rVar2);
                }
                _alVar._b();
            } else {
                synchronized (_alVar._a) {
                    _alVar._a.add(_rVar2);
                }
                Logger.e("AdPool 初始化未完成");
            }
        }
        if (this._c.compareAndSet(false, true)) {
            _a(this._a, null);
        }
    }
}
