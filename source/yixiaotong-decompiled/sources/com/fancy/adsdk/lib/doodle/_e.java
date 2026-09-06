package com.fancy.adsdk.lib.doodle;

import com.fancy._b0;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _e extends _d._c {
    public final /* synthetic */ _b0 _c;
    public final /* synthetic */ _d._b _d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public _e(_d._b _bVar, FutureTask futureTask, boolean z, _b0 _b0Var) {
        super(futureTask, z);
        this._d = _bVar;
        this._c = _b0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this._a.run();
            _d._b _bVar = this._d;
            _b0 _b0Var = this._c;
            synchronized (_bVar) {
                HashSet hashSet = _d._b._a;
                hashSet.remove(_b0Var);
                HashMap map = _d._b._b;
                LinkedList linkedList = (LinkedList) map.get(_b0Var);
                if (linkedList != null) {
                    _d._c _cVar = (_d._c) linkedList.poll();
                    if (_cVar == null) {
                        map.remove(_b0Var);
                    } else {
                        hashSet.add(_b0Var);
                        (_cVar._b ? _d._b : _d._a).execute(_cVar);
                    }
                }
            }
        } catch (Throwable th) {
            _d._b _bVar2 = this._d;
            _b0 _b0Var2 = this._c;
            synchronized (_bVar2) {
                HashSet hashSet2 = _d._b._a;
                hashSet2.remove(_b0Var2);
                HashMap map2 = _d._b._b;
                LinkedList linkedList2 = (LinkedList) map2.get(_b0Var2);
                if (linkedList2 != null) {
                    _d._c _cVar2 = (_d._c) linkedList2.poll();
                    if (_cVar2 != null) {
                        hashSet2.add(_b0Var2);
                        (_cVar2._b ? _d._b : _d._a).execute(_cVar2);
                    } else {
                        map2.remove(_b0Var2);
                    }
                }
                throw th;
            }
        }
    }
}
