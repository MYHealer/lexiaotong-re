package com.fancy.adsdk.lib.doodle;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.fancy._fm;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public abstract class _c {
    public static final Handler _h = new Handler(Looper.getMainLooper());
    public int _f;
    public boolean _g;
    public volatile boolean _b = false;
    public volatile int _c = 1;
    public final AtomicBoolean _d = new AtomicBoolean();
    public final AtomicBoolean _e = new AtomicBoolean();
    public final _a _a = new _a(new Callable() { // from class: com.fancy.adsdk.lib.doodle._c$$ExternalSyntheticLambda0
        @Override // java.util.concurrent.Callable
        public final Object call() {
            return this.f$0._b();
        }
    });

    public class _a extends FutureTask<Object> {
        public _a(Callable callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        public final void done() {
            _c _cVar;
            _c.this._b = true;
            try {
                _c _cVar2 = _c.this;
                Object obj = get();
                if (_cVar2._a.isCancelled()) {
                    _cVar2._d.set(true);
                }
                if (_cVar2._e.get()) {
                    return;
                }
                _cVar2._c(obj);
            } catch (CancellationException unused) {
                _cVar = _c.this;
                if (_cVar._a.isCancelled()) {
                    _cVar._d.set(true);
                }
                if (_cVar._e.get()) {
                    return;
                }
                _cVar._c(null);
            } catch (Throwable th) {
                Log.w("Doodle", th);
                _cVar = _c.this;
                if (_cVar._a.isCancelled()) {
                    _cVar._d.set(true);
                }
                if (_cVar._e.get()) {
                    return;
                }
                _cVar._c(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _a(Object obj) {
        int i = this._f;
        if (i != 0) {
            synchronized (_fm.class) {
                _fm._a _aVar = _fm._a.get(i);
                if (_aVar != null) {
                    _aVar._a(this);
                }
            }
        }
        if (this._d.get()) {
            _c();
        } else {
            _b(obj);
        }
        this._c = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object _b() {
        Object obj_a;
        this._e.set(true);
        try {
            obj_a = !this._d.get() ? _a() : null;
        } catch (Throwable unused) {
            this._d.set(true);
        }
        _c(obj_a);
        return obj_a;
    }

    public abstract Object _a();

    public void _b(Object obj) {
    }

    public void _c() {
    }

    public final void _c(final Object obj) {
        _h.post(new Runnable() { // from class: com.fancy.adsdk.lib.doodle._c$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0._a(obj);
            }
        });
    }
}
