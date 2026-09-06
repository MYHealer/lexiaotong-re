package com.fancy;

import com.fancy.adsdk.lib.model.AdSlot;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _x extends _w implements _pe<AdSlot> {
    public final _pf _U;
    public final LinkedHashSet _V;
    public final _pe<?> _W;
    public WeakReference<AdSlot> _X;

    public _x() {
        throw null;
    }

    public _x(_pe<?> _peVar, AdSlot adSlot, _pf _pfVar) {
        super(0);
        this._V = new LinkedHashSet();
        this._W = _peVar;
        UUID.randomUUID().toString();
        this._U = _pfVar;
        adSlot._a(this);
        this._X = new WeakReference<>(adSlot);
        _pfVar._a(_peVar, this);
    }

    @Override // com.fancy._w, com.fancy.adsdk.lib.model.AdSlot
    public final AdSlot _a(AdSlot adSlot) {
        super._a(adSlot);
        if (adSlot instanceof _x) {
            _x _xVar = (_x) adSlot;
            _xVar.getClass();
            _xVar._X = this._X;
            _xVar._V.clear();
            _xVar._V.addAll(this._V);
        }
        return adSlot;
    }

    @Override // com.fancy._w, com.fancy.adsdk.lib.model.AdSlot
    public final AdSlot _b(_ci _ciVar) {
        _x _xVar = new _x(this._W, super._b(_ciVar), this._U);
        _xVar._X = this._X;
        _xVar._V.clear();
        _xVar._V.addAll(this._V);
        return _xVar;
    }

    @Override // com.fancy._pe
    public final _pf _r() {
        return this._U;
    }

    @Override // com.fancy._pe
    /* JADX INFO: renamed from: _b, reason: merged with bridge method [inline-methods] */
    public final _x _a(_pg _pgVar) {
        boolean zAdd;
        synchronized (this._V) {
            zAdd = !this._V.contains(_pgVar) ? this._V.add(_pgVar) : false;
        }
        if (zAdd) {
            boolean z = _pgVar instanceof _pk;
            boolean z2 = _pgVar instanceof _pj;
            _pf _pfVar = this._U;
            _pfVar.getClass();
            ArrayList arrayList = new ArrayList();
            synchronized (_pfVar._b) {
                arrayList.addAll(_pfVar._b.keySet());
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((_pe) it.next())._a(_pgVar);
            }
            this._U._a(_pgVar);
        }
        return this;
    }
}
