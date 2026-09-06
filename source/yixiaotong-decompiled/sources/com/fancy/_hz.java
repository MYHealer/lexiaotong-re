package com.fancy;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import com.stub.StubApp;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _hz {
    public static _hz _e;
    public final ExecutorService _a = Executors.newSingleThreadExecutor();
    public final ConcurrentHashMap<String, _i0> _b = new ConcurrentHashMap<>();
    public boolean _c = true;
    public final _eb _d;

    public _hz(Context context) {
        this._d = _i5._a(context);
    }

    public static _hz _a(Context context) {
        if (_e == null) {
            synchronized (_hz.class) {
                if (_e == null) {
                    _e = new _hz(StubApp.getOrigApplicationContext(context.getApplicationContext()));
                }
            }
        }
        return _e;
    }

    public final void _a(String str, _ki _kiVar) {
        if (_a(str)) {
            try {
                _kiVar.run();
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        _bm _bmVar = this._d._f;
        File file = _bmVar._a;
        _bmVar._b.getClass();
        File file2 = new File(file, _fw._a(str));
        if (file2.exists() && file2.length() < 1024) {
            file2.delete();
        }
        _i0 _i0Var = new _i0();
        _i0Var._a = str;
        _i0Var._e = this._d;
        _i0Var._d = _kiVar;
        this._b.put(_i4._a(str), _i0Var);
        if (this._c) {
            ExecutorService executorService = this._a;
            if (_i0Var._c) {
                return;
            }
            _i0Var._c = true;
            executorService.submit(_i0Var);
        }
    }

    public final boolean _a(String str) {
        _bm _bmVar = this._d._f;
        File file = _bmVar._a;
        _bmVar._b.getClass();
        File file2 = new File(file, _fw._a(str));
        if (file2.exists() && file2.length() >= 1024) {
            return true;
        }
        _eb _ebVar = this._d;
        File file3 = _ebVar._f._a;
        StringBuilder sb = new StringBuilder();
        _ebVar._f._b.getClass();
        File file4 = new File(file3, sb.append(_fw._a(str)).append(".download").toString());
        return file4.exists() && file4.length() >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
    }
}
