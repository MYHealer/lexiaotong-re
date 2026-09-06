package com.fancy;

import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class _i2 {
    public final _nl _a;
    public final _az _b;
    public volatile Thread _f;
    public volatile boolean _g;
    public final Object _c = new Object();
    public final Object _d = new Object();
    public volatile int _h = -1;
    public final AtomicInteger _e = new AtomicInteger();

    public class _a implements Runnable {
        public final /* synthetic */ _i2 _a;

        public _a(_ea _eaVar) {
            this._a = _eaVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x003f, code lost:
        
            r3 = r3 + ((long) r6);
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void run() {
            _i2 _i2Var = this._a;
            _i2Var.getClass();
            long length = -1;
            long jAvailable = 0;
            try {
                jAvailable = _i2Var._b.available();
                _i2Var._a._a(jAvailable);
                length = _i2Var._a.length();
                byte[] bArr = new byte[8192];
                while (true) {
                    int i = _i2Var._a.read(bArr);
                    if (i == -1) {
                        synchronized (_i2Var._d) {
                            if (!Thread.currentThread().isInterrupted() && !_i2Var._g && _i2Var._b.available() == _i2Var._a.length()) {
                                _i2Var._b._a();
                            }
                        }
                        _i2Var._h = 100;
                        int i2 = _i2Var._h;
                        _ea _eaVar = (_ea) _i2Var;
                        _b1 _b1Var = _eaVar._k;
                        if (_b1Var == null) {
                            break;
                        }
                        File file = _eaVar._j._b;
                        String str = _eaVar._i._c._a;
                        _b1Var._a(file, i2);
                        break;
                    }
                    synchronized (_i2Var._d) {
                        if (!Thread.currentThread().isInterrupted() && !_i2Var._g) {
                            _i2Var._b._a(i, bArr);
                        }
                    }
                    try {
                        _i2Var._a.close();
                    } catch (_i3 e) {
                        new _i3(_ie._a("Error closing source ").append(_i2Var._a).toString(), e);
                    }
                    _i2Var._a(jAvailable, length);
                    return;
                    try {
                        _i2Var._e.incrementAndGet();
                        boolean z = th instanceof _fh;
                    } finally {
                        try {
                            _i2Var._a.close();
                        } catch (_i3 e2) {
                            new _i3(_ie._a("Error closing source ").append(_i2Var._a).toString(), e2);
                        }
                        _i2Var._a(jAvailable, length);
                    }
                    _i2Var._a(jAvailable, length);
                }
            } catch (Throwable th) {
                _i2Var._e.incrementAndGet();
                boolean z2 = th instanceof _fh;
            }
        }
    }

    public _i2(_nl _nlVar, _az _azVar) {
        this._a = (_nl) _hy._a(_nlVar);
        this._b = (_az) _hy._a(_azVar);
    }

    public final void _a(long j, long j2) {
        _ea _eaVar;
        _b1 _b1Var;
        int i = j2 == 0 ? 100 : (int) ((j / j2) * 100.0f);
        boolean z = i != this._h;
        if (j2 >= 0 && z && (_b1Var = (_eaVar = (_ea) this)._k) != null) {
            File file = _eaVar._j._b;
            String str = _eaVar._i._c._a;
            _b1Var._a(file, i);
        }
        this._h = i;
        synchronized (this._c) {
            this._c.notifyAll();
        }
    }
}
