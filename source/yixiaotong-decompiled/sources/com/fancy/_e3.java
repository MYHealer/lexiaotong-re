package com.fancy;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _e3 implements _eg {
    public final Context _a;
    public final Handler _b = new Handler(Looper.getMainLooper());

    public class _a implements Runnable {
        public final /* synthetic */ _a4 _a;

        public _a(_a4 _a4Var) {
            this._a = _a4Var;
        }

        @Override // java.lang.Runnable
        public final void run() {
            _5._a _aVar_a;
            _e3 _e3Var = _e3.this;
            _a4 _a4Var = this._a;
            _e3Var.getClass();
            try {
                try {
                    _aVar_a = _5._a(_e3Var._a);
                } catch (Throwable unused) {
                    _aVar_a = null;
                }
                _e3Var._b.post(new _e4(_a4Var, (_aVar_a == null || _aVar_a._b) ? "" : _aVar_a._a));
            } catch (Exception unused2) {
                _e3Var._b.post(new _e4(_a4Var, ""));
            }
        }
    }

    public _e3(Context context) {
        this._a = context;
    }

    @Override // com.fancy._eg
    public final void _a(_a4 _a4Var) {
        if (this._a == null || _a4Var == null) {
            return;
        }
        Executors.newSingleThreadExecutor().execute(new _a(_a4Var));
    }

    public final boolean _a() {
        Context context = this._a;
        if (context == null) {
            return false;
        }
        try {
            new _e5();
            return _e5._a(context);
        } catch (Throwable unused) {
            return false;
        }
    }
}
