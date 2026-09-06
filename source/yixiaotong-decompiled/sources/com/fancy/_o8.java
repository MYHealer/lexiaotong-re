package com.fancy;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.LinearLayout;
import com.fancy.adsdk.lib.interf.PtgSplashAd;
import com.fancy.adsdk.lib.model.AdSlot;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _o8 {
    public boolean _f;
    public _o7 _j;
    public boolean _a = false;
    public boolean _b = false;
    public boolean _c = false;
    public boolean _d = false;
    public int _e = 0;
    public boolean _g = false;
    public final AtomicBoolean _h = new AtomicBoolean(false);
    public final Handler _i = new Handler(Looper.getMainLooper());
    public final AtomicBoolean _k = new AtomicBoolean(false);

    public static void _a(_o8 _o8Var, _am _amVar, _f _fVar, String str, View view, int i, _oj _ojVar, boolean z, boolean z2, _h _hVar, LinearLayout linearLayout) {
        _nx._d _dVar;
        _nx _nxVar;
        AdSlot adSlot;
        _f _fVar2;
        _o8Var.getClass();
        if (_amVar == null || _amVar._b() || _amVar._a() || com.fancy.adsdk.lib.utils._a._f()) {
            return;
        }
        if (z) {
            if (_o8Var._k.get()) {
                return;
            } else {
                _o8Var._k.set(true);
            }
        }
        _o8Var._h.set(true);
        _o8Var._f = false;
        _o8Var._d = false;
        _o8Var._b = false;
        if (linearLayout != null && linearLayout.getVisibility() == 0 && !_o8Var._g) {
            linearLayout.setVisibility(8);
        }
        _de._a(_fVar);
        _ng._a(str);
        _o7 _o7Var = _o8Var._j;
        if (_o7Var != null) {
            _o8Var._i.removeCallbacks(_o7Var);
        }
        _kr._a(z, z2);
        if (view != null) {
            _p5._b(view);
        }
        if (_hVar == null || (adSlot = (_nxVar = _nx.this)._n) == null || (_fVar2 = _nxVar._m) == null || !_fVar2._A) {
            return;
        }
        adSlot._e(i);
        _f _fVar3 = _nx.this._m;
        _fVar3._v = _ojVar;
        _n1._a(view, _fVar3, i);
        PtgSplashAd.AdInteractionListener adInteractionListener = _nx.this._i;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
        Context context = _nx.this.getContext();
        _nx _nxVar2 = _nx.this;
        _b3._a(context, _nxVar2._m, _nxVar2._n);
    }

    public final boolean _a(_i _iVar) {
        return _iVar != null && _iVar._d() && !this._h.get() && _iVar._c(true);
    }
}
