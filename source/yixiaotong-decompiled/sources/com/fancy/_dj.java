package com.fancy;

import android.text.TextUtils;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _dj implements _g9 {
    public final /* synthetic */ _dm _a;

    public _dj(_dm _dmVar) {
        this._a = _dmVar;
    }

    public final void _a() {
        _f _fVar;
        List<Integer> list;
        _gq _gqVar = this._a._i;
        if (_gqVar != null) {
            _gqVar._q = System.currentTimeMillis();
            ConcurrentHashMap<String, Long> concurrentHashMap = _io._a;
            if ((!concurrentHashMap.isEmpty()) || (_fVar = _gqVar._c) == null) {
                return;
            }
            _i _iVar = _fVar._s;
            _gqVar._i = _iVar;
            if (_iVar == null) {
                return;
            }
            _gqVar._j = _iVar._d();
            String str = _gqVar._d;
            if (!TextUtils.isEmpty(str)) {
                concurrentHashMap.put(str, Long.valueOf(System.currentTimeMillis()));
            }
            _gqVar._k = _gqVar._i._b(_gqVar._j);
            List<Integer> list2 = _gqVar._i._g;
            _gqVar._l = list2 != null && list2.contains(5);
            _gqVar._i.getClass();
            _gqVar._m = _gqVar._i._d(_gqVar._j);
            _gqVar._n = _gqVar._i._c(_gqVar._j);
            _i _iVar2 = _gqVar._i;
            _gqVar._o = _iVar2._j;
            _gqVar._p = _gqVar._j && (list = _iVar2._g) != null && list.contains(4);
            if (!_gqVar._a()) {
                _gqVar._a(_gqVar._a, false);
            } else {
                if (1 == _gqVar._o) {
                    _gqVar._a(_gqVar._a, true);
                    return;
                }
                long j_a = _gqVar._i._a();
                _gqVar._w.removeCallbacks(_gqVar._x);
                _gqVar._w.postDelayed(_gqVar._x, j_a);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0024 A[Catch: Exception -> 0x0041, PHI: r1
  0x0024: PHI (r1v3 boolean) = (r1v2 boolean), (r1v4 boolean) binds: [B:13:0x001d, B:15:0x0022] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {Exception -> 0x0041, blocks: (B:10:0x0011, B:12:0x0019, B:14:0x001f, B:16:0x0024, B:17:0x002a, B:19:0x0032), top: B:23:0x000f }] */
    public final void _a(int i) {
        _gq _gqVar;
        _dm _dmVar = this._a;
        _f _fVar = _dmVar._c;
        if (_fVar == null || !_fVar._A || (_gqVar = _dmVar._i) == null) {
            return;
        }
        boolean z = false;
        try {
            if (i == 0) {
                if (!_gqVar._A.get()) {
                    if (_gqVar._a()) {
                        z = true;
                        if (1 == _gqVar._o) {
                            _gqVar._a(_gqVar._a, z);
                        }
                    } else {
                        _gqVar._a(_gqVar._a, z);
                    }
                }
            } else if (_gqVar._A.get()) {
                _gqVar._A.set(false);
                _io._b(_gqVar._d);
                _ng._a(_gqVar._d);
            }
        } catch (Exception unused) {
        }
    }
}
