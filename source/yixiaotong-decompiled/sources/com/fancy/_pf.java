package com.fancy;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _pf {
    public final WeakHashMap _a = new WeakHashMap();
    public final WeakHashMap _b = new WeakHashMap();
    public WeakReference<_pe<?>> _c;

    public static class _a {
    }

    public final void _a(_pe<?> _peVar, _pe<?> _peVar2) {
        WeakReference<_pe<?>> weakReference = this._c;
        if (weakReference == null || weakReference.get() == null || this._c.get() == _peVar) {
            if (this._c == null) {
                this._c = new WeakReference<>(_peVar);
            }
            if (_peVar != null && _peVar._r() != null) {
                _pf _pfVar_r = _peVar._r();
                if (_peVar2 != null) {
                    synchronized (_pfVar_r._a) {
                        if (!_pfVar_r._a.containsKey(_peVar2)) {
                            _pfVar_r._a.put(_peVar2, new _a());
                        }
                    }
                } else {
                    _pfVar_r.getClass();
                }
            }
            synchronized (this._b) {
                if (!this._b.containsKey(_peVar2)) {
                    this._b.put(_peVar2, new _a());
                }
            }
        }
    }

    public final void _a(_pg _pgVar) {
        ArrayList arrayList = new ArrayList();
        synchronized (this._a) {
            arrayList.addAll(this._a.keySet());
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((_pe) it.next())._a(_pgVar);
        }
    }
}
