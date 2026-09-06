package com.fancy;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.fancy.adsdk.lib.interf.PtgNativeExpressAd;
import com.fancy.adsdk.lib.model.AdSlot;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _dm {
    public PtgNativeExpressAd.AdInteractionListener _a;
    public AdSlot _b;
    public _f _c;
    public ViewGroup _d;
    public List<View> _e;
    public List<View> _f;
    public View _g;
    public _en _h;
    public _gq _i;
    public AtomicBoolean _j = new AtomicBoolean(false);

    public _dm(Context context, _f _fVar, AdSlot adSlot) {
        this._b = adSlot;
        this._c = _fVar;
        this._i = new _gq(context, _fVar, adSlot);
        this._h = this._c._u() ? new _gl() : new _gh();
        this._h._a(context, _fVar, this._j);
    }

    public final void _a() {
        _gq._a _aVar;
        try {
            _gq _gqVar = this._i;
            if (_gqVar != null) {
                if (_io._a(_gqVar._d)) {
                    Handler handler = _gqVar._w;
                    if (handler != null && (_aVar = _gqVar._x) != null) {
                        handler.removeCallbacks(_aVar);
                    }
                    _io._b(_gqVar._d);
                    _ng._a(_gqVar._d);
                }
                if (_gqVar._e != null) {
                    _gqVar._e = null;
                }
                ViewGroup viewGroup = _gqVar._g;
                if (viewGroup != null) {
                    viewGroup.setOnTouchListener(null);
                }
                List<View> list = _gqVar._h;
                if (list != null && !list.isEmpty()) {
                    Iterator<View> it = _gqVar._h.iterator();
                    while (it.hasNext()) {
                        it.next().setOnTouchListener(null);
                    }
                }
                this._i = null;
            }
            _en _enVar = this._h;
            if (_enVar != null) {
                _enVar._a();
                this._h = null;
            }
            if (this._a != null) {
                this._a = null;
            }
            List<View> list2 = this._e;
            if (list2 != null) {
                list2.clear();
            }
            List<View> list3 = this._f;
            if (list3 != null) {
                list3.clear();
            }
        } catch (Exception unused) {
        }
    }
}
