package com.fancy;

import android.graphics.Bitmap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _fr {
    public static final long _a = Runtime.getRuntime().maxMemory() / 64;
    public static long _b = 0;
    public static final LinkedHashMap _c = new LinkedHashMap(16, 0.75f, true);

    public static class _a {
        public final Bitmap _a;
        public final int _b;

        public _a(Bitmap bitmap) {
            this._a = bitmap;
            this._b = _p3._a(bitmap);
        }
    }

    public static void _a(long j) {
        _p9._a _aVar;
        Iterator it = _c.entrySet().iterator();
        while (it.hasNext() && _b > j) {
            Map.Entry entry = (Map.Entry) it.next();
            _a _aVar2 = (_a) entry.getValue();
            _p9 _p9Var = _g1._c;
            _b0 _b0Var = (_b0) entry.getKey();
            Bitmap bitmap = _aVar2._a;
            synchronized (_p9Var) {
                _p9Var._a();
                if (bitmap != null && ((_aVar = (_p9._a) _p9Var._a.get(_b0Var)) == null || _aVar.get() != bitmap)) {
                    _p9Var._a.put(_b0Var, new _p9._a(_b0Var, bitmap, _p9Var._b));
                }
            }
            it.remove();
            _b -= (long) _aVar2._b;
        }
    }
}
