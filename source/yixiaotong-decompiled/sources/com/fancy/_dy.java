package com.fancy;

import android.graphics.Movie;
import java.io.ByteArrayInputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _dy implements _a0 {
    public static final _dy _a = new _dy();

    @Override // com.fancy._a0
    public final Object _a(_c2 _c2Var) {
        try {
            if (_c2Var._a()._c() != 6) {
                return null;
            }
            _bz _bzVar_a = _c2Var._a();
            if (_bzVar_a._f == null) {
                _bzVar_a._f = _bzVar_a._b._b();
            }
            return Movie.decodeStream(new ByteArrayInputStream(_bzVar_a._f));
        } catch (Exception unused) {
            return null;
        }
    }
}
