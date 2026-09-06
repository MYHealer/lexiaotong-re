package com.fancy;

import com.fancy.adsdk.lib.core.model.AdErrorImpl;
import com.fancy.adsdk.lib.model.AdSlot;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public abstract class _bg {
    public Set<_bg> _a;
    public AdSlot _b;
    public _ci _c;
    public _os _d;
    public AtomicInteger _e;
    public AtomicBoolean _f = new AtomicBoolean();
    public AtomicBoolean _g = new AtomicBoolean();

    public _bg(SortedSet sortedSet, _ci _ciVar, AtomicInteger atomicInteger) {
        this._a = sortedSet;
        this._c = _ciVar;
        this._e = atomicInteger;
    }

    public abstract void _a();

    public abstract void _a(AdErrorImpl adErrorImpl);

    public final String _b() {
        _ci _ciVar = this._c;
        return _ciVar != null ? _ciVar._c : "";
    }

    public final int _c() {
        AtomicInteger atomicInteger = this._e;
        if (atomicInteger == null) {
            return -1;
        }
        return atomicInteger.get();
    }

    public final _os _d() {
        AdSlot adSlot = this._b;
        if (adSlot != null) {
            return adSlot._t();
        }
        return null;
    }

    public final int _e() {
        _ci _ciVar = this._c;
        if (_ciVar != null) {
            return _ciVar._e;
        }
        return 0;
    }

    public abstract boolean _f();

    public abstract boolean _g();

    public final void _h() {
        AtomicInteger atomicInteger;
        if (!this._g.compareAndSet(false, true) || (atomicInteger = this._e) == null) {
            return;
        }
        atomicInteger.incrementAndGet();
    }

    public final void _i() {
        AdSlot adSlot;
        if (this._d == null || (adSlot = this._b) == null || adSlot._i() == null) {
            return;
        }
        _ou._a()._a(this._b._i()._a(), "bidSel", this._d, null);
    }

    public final String toString() {
        StringBuilder sbAppend = _ie._a("codeId(").append(_d()._b).append(")-type(").append(_b()).append(")-price(");
        _ci _ciVar = this._c;
        return sbAppend.append(_ciVar != null ? _ciVar._h : 0L).append(")-runningCounter(").append(_c()).append(")-isLoaded(").append(_g()).append(")").toString();
    }
}
