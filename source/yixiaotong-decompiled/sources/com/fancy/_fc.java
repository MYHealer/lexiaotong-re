package com.fancy;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.fancy.adsdk.lib.interf.PtgInteractionAd;
import com.fancy.adsdk.lib.model.AdSlot;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _fc {
    public String _c;
    public _f _d;
    public AdSlot _e;
    public boolean _f;
    public _jd _g;
    public boolean _h;
    public FrameLayout _k;
    public _f5 _l;
    public View _m;
    public int _a = 0;
    public int _b = 0;
    public AtomicBoolean _i = new AtomicBoolean(false);
    public final _a _j = new _a();

    public final void _a(View view, int i, _oj _ojVar, boolean z) {
        PtgInteractionAd.AdInteractionListener adInteractionListener;
        _f _fVar;
        if (view == null || this._d == null) {
            return;
        }
        AdSlot adSlot = this._e;
        if (adSlot != null) {
            adSlot._e(i);
        }
        _f _fVar2 = this._d;
        if (_fVar2 != null) {
            _fVar2._v = _ojVar;
        }
        this._h = true;
        _de._a(_fVar2);
        boolean z2 = z && (_fVar = this._d) != null && _fVar._r();
        _f _fVar3 = this._d;
        if (z2) {
            i = 0;
        }
        _n1._a(view, _fVar3, i);
        _fg _fgVar_a = _fg._a();
        String str = this._c;
        _fgVar_a.getClass();
        if (!TextUtils.isEmpty(str) && (adInteractionListener = _fgVar_a._d.get(str)) != null) {
            adInteractionListener.onAdClicked();
        }
        _b3._a(view.getContext(), this._d, this._e);
        _jd _jdVar = this._g;
        if (_jdVar != null) {
            _kr._a(_jdVar._j, _jdVar._l);
            this._g._c();
        }
    }

    public class _a implements _jd._b {
        public _a() {
        }

        @Override // com.fancy._jd._b
        public final void _a(View view, int i, _oj _ojVar) {
            _fc _fcVar = _fc.this;
            _fcVar._a(view, i, _ojVar, true);
            _n1._a(_fcVar._m, view, (View) null);
        }

        @Override // com.fancy._jd._b
        public final void _b(View view, int i, _oj _ojVar) {
            _fc.this._a(view, i, _ojVar, false);
        }

        @Override // com.fancy._jd._b
        public final void _a(boolean z) {
            _f5 _f5Var = _fc.this._l;
            if (_f5Var != null) {
                _f5Var.setShakeLayoutVisible(z);
            }
        }
    }
}
