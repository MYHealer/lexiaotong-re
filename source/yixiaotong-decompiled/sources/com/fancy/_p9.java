package com.fancy;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _p9 {
    public final HashMap _a = new HashMap();
    public final ReferenceQueue<Object> _b = new ReferenceQueue<>();

    public static class _a extends WeakReference<Object> {
        public final _b0 _a;

        public _a(_b0 _b0Var, Object obj, ReferenceQueue<Object> referenceQueue) {
            super(obj, referenceQueue);
            this._a = _b0Var;
        }
    }

    public final void _a() {
        _a _aVar = (_a) this._b.poll();
        while (_aVar != null) {
            _a _aVar2 = (_a) this._a.get(_aVar._a);
            if (_aVar2 != null && _aVar2.get() == null) {
                this._a.remove(_aVar._a);
            }
            _aVar = (_a) this._b.poll();
        }
    }
}
