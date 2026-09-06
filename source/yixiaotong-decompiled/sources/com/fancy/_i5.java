package com.fancy;

import android.content.Context;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _i5 {
    public static _eb _a;

    public static synchronized _eb _a(Context context) {
        _eb _ebVar = _a;
        if (_ebVar != null) {
            return _ebVar;
        }
        try {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            _c0 _c0Var = new _c0(origApplicationContext);
            _a = new _eb(new _bm(_o9._a(origApplicationContext), new _fw(), new _oo(), _c0Var, new _dd()));
        } catch (Throwable unused) {
            _a = null;
        }
        return _a;
    }
}
