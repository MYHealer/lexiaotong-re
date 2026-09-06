package com.fancy;

import com.fancy.adsdk.lib.interf.PtgAd;
import com.fancy.adsdk.lib.model.AdSlot;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _pi {
    public static final _pi _e = new _pi();
    public final WeakHashMap _a = new WeakHashMap();
    public final WeakHashMap _b = new WeakHashMap();
    public final WeakHashMap _c = new WeakHashMap();
    public final _a8 _d = new _a8();

    public final void _a(AdSlot adSlot, PtgAd ptgAd) {
        if (adSlot == null || ptgAd == null) {
            return;
        }
        _x _xVar_b = _b(adSlot);
        ArrayList<_ii> arrayList = new ArrayList();
        synchronized (this._a) {
            List list = (List) this._a.get(_xVar_b);
            if (list != null) {
                arrayList.addAll(list);
            }
        }
        _ii _iiVar = null;
        if (!arrayList.isEmpty()) {
            for (_ii _iiVar2 : arrayList) {
                WeakReference<PtgAd> weakReference = _iiVar2._c;
                if ((weakReference != null ? weakReference.get() : null) == ptgAd) {
                    _iiVar = _iiVar2;
                    break;
                }
            }
        }
        if (_iiVar == null) {
            _ii _iiVar3 = new _ii(_xVar_b, ptgAd);
            synchronized (this._a) {
                List arrayList2 = (List) this._a.get(_xVar_b);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                arrayList2.add(_iiVar3);
                this._a.put(_xVar_b, arrayList2);
            }
            synchronized (this._b) {
                this._b.put(ptgAd, _xVar_b);
            }
        }
    }

    public final boolean _a(AdSlot adSlot) {
        synchronized (this._c) {
            if (adSlot != null) {
                if (this._c.containsKey(adSlot)) {
                    return true;
                }
            }
            return false;
        }
    }

    public final _x _b(AdSlot adSlot) {
        _x _xVar;
        if (adSlot instanceof _x) {
            _x _xVar2 = (_x) adSlot;
            _xVar = _xVar2;
            adSlot = _xVar2._X.get();
        } else {
            _xVar = null;
        }
        synchronized (this._c) {
            if (adSlot != null) {
                if (!this._c.containsKey(adSlot)) {
                    _xVar = new _x(this._d, adSlot, new _pf());
                    this._c.put(adSlot, _xVar);
                }
            }
        }
        return _xVar;
    }
}
