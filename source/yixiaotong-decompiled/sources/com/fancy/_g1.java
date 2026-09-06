package com.fancy;

import android.graphics.Bitmap;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _g1 {
    public static final long _a = Runtime.getRuntime().maxMemory();
    public static final AtomicBoolean _b = new AtomicBoolean(false);
    public static final _p9 _c = new _p9();
    public static final _p9 _d = new _p9();

    public static void _a() {
        AtomicBoolean atomicBoolean = _b;
        if (atomicBoolean.compareAndSet(false, true)) {
            Runtime runtime = Runtime.getRuntime();
            long jFreeMemory = runtime.freeMemory() + (_a - runtime.totalMemory());
            if (jFreeMemory < 4194304) {
                synchronized (_fr.class) {
                    _fr._a(0L);
                }
            } else if (jFreeMemory < 10485760) {
                synchronized (_fr.class) {
                    _fr._a(Math.max(_fr._b >> 1, _fr._a));
                }
            }
            atomicBoolean.set(false);
        }
    }

    public static void _b(_b0 _b0Var) {
        if (_b0Var == null) {
            return;
        }
        synchronized (_fr.class) {
            _fr._a _aVar = (_fr._a) _fr._c.remove(_b0Var);
            if (_aVar != null) {
                _fr._b -= (long) _aVar._b;
            }
        }
        _p9 _p9Var = _c;
        synchronized (_p9Var) {
            _p9Var._a();
            _p9Var._a.remove(_b0Var);
        }
        _p9 _p9Var2 = _d;
        synchronized (_p9Var2) {
            _p9Var2._a();
            _p9Var2._a.remove(_b0Var);
        }
    }

    public static Bitmap _a(_b0 _b0Var) {
        Bitmap bitmap;
        Object obj;
        synchronized (_fr.class) {
            _fr._a _aVar = (_fr._a) _fr._c.get(_b0Var);
            bitmap = _aVar != null ? _aVar._a : null;
        }
        if (bitmap != null) {
            return bitmap;
        }
        _p9 _p9Var = _c;
        synchronized (_p9Var) {
            _p9Var._a();
            _p9._a _aVar2 = (_p9._a) _p9Var._a.get(_b0Var);
            obj = _aVar2 != null ? _aVar2.get() : null;
        }
        return (Bitmap) obj;
    }

    public static void _a(_b0 _b0Var, Bitmap bitmap, boolean z) {
        _p9._a _aVar;
        if (z) {
            _p9 _p9Var = _c;
            synchronized (_p9Var) {
                _p9Var._a();
                if (bitmap != null && ((_aVar = (_p9._a) _p9Var._a.get(_b0Var)) == null || _aVar.get() != bitmap)) {
                    _p9Var._a.put(_b0Var, new _p9._a(_b0Var, bitmap, _p9Var._b));
                }
            }
            return;
        }
        synchronized (_fr.class) {
            LinkedHashMap linkedHashMap = _fr._c;
            long j = _bn._c;
            if (bitmap != null && j > 0) {
                LinkedHashMap linkedHashMap2 = _fr._c;
                if (!linkedHashMap2.containsKey(_b0Var)) {
                    _fr._a _aVar2 = new _fr._a(bitmap);
                    linkedHashMap2.put(_b0Var, _aVar2);
                    long j2 = _fr._b + ((long) _aVar2._b);
                    _fr._b = j2;
                    if (j2 > j) {
                        _fr._a((j * 9) / 10);
                    }
                }
            }
        }
    }
}
