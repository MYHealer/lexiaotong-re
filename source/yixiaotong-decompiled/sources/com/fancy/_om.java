package com.fancy;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.utils.TextUtil;
import com.google.android.exoplayer2.ExoPlayer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _om implements _hx, Runnable, _a5, _hl<_k> {
    public final _hx _b;
    public final _cf _c;
    public final AtomicLong _d = new AtomicLong(0);
    public final AtomicLong _e = new AtomicLong(0);
    public final Handler _a = new Handler(Looper.getMainLooper());

    public _om(_cf _cfVar, com.fancy.adsdk.lib._e _eVar) {
        this._c = _cfVar;
        this._b = _eVar;
        _c();
    }

    @Override // com.fancy._hl
    public final void _a(_k _kVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this._e.get();
        if (jCurrentTimeMillis - j >= ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS && this._e.compareAndSet(j, jCurrentTimeMillis)) {
            com.fancy.adsdk.lib.utils._d._b(new _ol(this));
        }
    }

    @Override // com.fancy._hx
    public final void _a(String str) {
        this._b._a(str);
    }

    @Override // com.fancy._a5
    public final void _b() {
        _fn _fnVar = _fn._b;
        _fnVar.getClass();
        if (TextUtil.isEmpty("configUpdate")) {
            return;
        }
        CopyOnWriteArrayList<_hl<_k>> copyOnWriteArrayList = _fnVar._a.get("configUpdate");
        if (TextUtil.isEmpty(copyOnWriteArrayList)) {
            return;
        }
        copyOnWriteArrayList.remove(this);
    }

    @Override // com.fancy._hx
    public final void _b(String str) {
        this._b._b(str);
    }

    public final void _c() {
        PtgAdSdk.getAppLifecycleListener()._a.add(this);
        _fn _fnVar = _fn._b;
        _fnVar.getClass();
        if (TextUtil.isEmpty("configUpdate")) {
            return;
        }
        CopyOnWriteArrayList<_hl<_k>> copyOnWriteArrayList = _fnVar._a.get("configUpdate");
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            _fnVar._a.put("configUpdate", copyOnWriteArrayList);
        }
        copyOnWriteArrayList.add(this);
    }

    @Override // com.fancy._hx
    public final void _c(String str) {
        this._b._c(str);
    }

    @Override // java.lang.Runnable
    public final void run() {
        _cf _cfVar = this._c;
        if (_cfVar != null) {
            _cfVar._a._a(new _ce(_cfVar, _cfVar, this));
        }
    }

    @Override // com.fancy._a5
    public final void _a() {
        if (this._c == null) {
            return;
        }
        try {
            _fn _fnVar = _fn._b;
            _fnVar.getClass();
            if (!TextUtil.isEmpty("configUpdate")) {
                CopyOnWriteArrayList<_hl<_k>> copyOnWriteArrayList = _fnVar._a.get("configUpdate");
                if (copyOnWriteArrayList == null) {
                    copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                    _fnVar._a.put("configUpdate", copyOnWriteArrayList);
                }
                copyOnWriteArrayList.add(this);
            }
            ConcurrentHashMap<String, SharedPreferences> concurrentHashMap = _kr._a;
            long j_b = _kr._b(PtgAdSdk.getContext(), "c_u_t");
            if (j_b > 0) {
                long jCurrentTimeMillis = System.currentTimeMillis() - j_b;
                if (this._d.get() > 0 && jCurrentTimeMillis > this._d.get()) {
                    _cf _cfVar = this._c;
                    _cfVar._a._a(new _ce(_cfVar, _cfVar, this));
                    return;
                }
                this._d.set(this._d.get() > jCurrentTimeMillis ? this._d.get() - jCurrentTimeMillis : this._d.get());
                this._a.removeCallbacks(this);
                if (this._d.get() > 0) {
                    this._a.postDelayed(this, this._d.get());
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.fancy._hx
    public final void _a(_cg _cgVar, _ck _ckVar) {
        this._b._a(_cgVar, _ckVar);
        if (_ckVar != null) {
            long j = _ckVar._l * 1000;
            if (j == this._d.get()) {
                return;
            }
            if (j > 0) {
                ConcurrentHashMap<String, SharedPreferences> concurrentHashMap = _kr._a;
                long j_b = _kr._b(PtgAdSdk.getContext(), "c_u_t");
                if (j_b > 0) {
                    long jCurrentTimeMillis = System.currentTimeMillis() - j_b;
                    if (j > jCurrentTimeMillis) {
                        j -= jCurrentTimeMillis;
                    }
                }
                this._d.set(j);
            } else {
                this._d.set(0L);
            }
        }
        this._a.removeCallbacks(this);
        if (this._d.get() > 0) {
            this._a.postDelayed(this, this._d.get());
        }
    }
}
