package com.fancy;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.File;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ec {
    public final AtomicInteger _a = new AtomicInteger(0);
    public final String _b;
    public volatile _ea _c;
    public final _a _d;
    public final _bm _e;

    public static final class _a extends Handler implements _b1 {
        public final List<_b1> _a;

        public _a(String str, CopyOnWriteArrayList copyOnWriteArrayList) {
            super(Looper.getMainLooper());
            this._a = copyOnWriteArrayList;
        }

        @Override // com.fancy._b1
        public final void _a(File file, int i) {
            Message messageObtainMessage = obtainMessage();
            messageObtainMessage.arg1 = i;
            messageObtainMessage.obj = file;
            sendMessage(messageObtainMessage);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Iterator<_b1> it = this._a.iterator();
            while (it.hasNext()) {
                it.next()._a((File) message.obj, message.arg1);
            }
        }
    }

    public _ec(String str, _bm _bmVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this._b = (String) _hy._a(str);
        this._e = (_bm) _hy._a(_bmVar);
        this._d = new _a(str, copyOnWriteArrayList);
    }

    public final void _a(_dx _dxVar, Socket socket) {
        _ea _eaVar;
        synchronized (this) {
            if (this._c == null) {
                String str = this._b;
                _bm _bmVar = this._e;
                _ed _edVar = new _ed(str, _bmVar._d, _bmVar._e);
                _bm _bmVar2 = this._e;
                String str2 = this._b;
                _bmVar2._b.getClass();
                _eaVar = new _ea(_edVar, new _dr(new File(_bmVar2._a, _fw._a(str2)), this._e._c));
                _eaVar._k = this._d;
            } else {
                _eaVar = this._c;
            }
            this._c = _eaVar;
        }
        try {
            this._a.incrementAndGet();
            this._c._a(_dxVar, socket);
            synchronized (this) {
                if (this._a.decrementAndGet() <= 0) {
                    _ea _eaVar2 = this._c;
                    synchronized (_eaVar2._d) {
                        Objects.toString(_eaVar2._a);
                        try {
                            _eaVar2._g = true;
                            if (_eaVar2._f != null) {
                                _eaVar2._f.interrupt();
                            }
                            _eaVar2._b.close();
                        } catch (_i3 e) {
                            boolean z = e instanceof _fh;
                        }
                    }
                    this._c = null;
                }
            }
        } catch (Throwable th) {
            synchronized (this) {
                if (this._a.decrementAndGet() <= 0) {
                    _ea _eaVar3 = this._c;
                    synchronized (_eaVar3._d) {
                        Objects.toString(_eaVar3._a);
                        try {
                            _eaVar3._g = true;
                            if (_eaVar3._f != null) {
                                _eaVar3._f.interrupt();
                            }
                            _eaVar3._b.close();
                        } catch (_i3 e2) {
                            boolean z2 = e2 instanceof _fh;
                        }
                        this._c = null;
                    }
                }
                throw th;
            }
        }
    }
}
