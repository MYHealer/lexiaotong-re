package com.fancy;

import android.net.Uri;
import android.text.TextUtils;
import com.fancy._fs._c;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _eb {
    public final Object _a = new Object();
    public final ExecutorService _b = Executors.newFixedThreadPool(8);
    public final ConcurrentHashMap _c = new ConcurrentHashMap();
    public final ServerSocket _d;
    public final int _e;
    public final _bm _f;

    public final class _a implements Runnable {
        public final Socket _a;

        public _a(Socket socket) {
            this._a = socket;
        }

        @Override // java.lang.Runnable
        public final void run() {
            _eb _ebVar = _eb.this;
            Socket socket = this._a;
            _ebVar.getClass();
            try {
                try {
                    _dx _dxVar_a = _dx._a(socket.getInputStream());
                    _dxVar_a.toString();
                    _ebVar._a(_i4._b(_dxVar_a._a))._a(_dxVar_a, socket);
                } catch (Throwable th) {
                    try {
                        if (!socket.isInputShutdown()) {
                            socket.shutdownInput();
                        }
                    } catch (SocketException unused) {
                    } catch (IOException e) {
                        new _i3("Error closing socket input stream", e);
                    }
                    try {
                        if (!socket.isOutputShutdown()) {
                            socket.shutdownOutput();
                        }
                    } catch (IOException unused2) {
                    }
                    try {
                        if (!socket.isClosed()) {
                            socket.close();
                        }
                    } catch (IOException e2) {
                        new _i3("Error closing socket", e2);
                    }
                    synchronized (_ebVar._a) {
                        Iterator it = _ebVar._c.values().iterator();
                        while (it.hasNext()) {
                            ((_ec) it.next())._a.get();
                        }
                        throw th;
                    }
                }
            } catch (_i3 e3) {
                e = e3;
                new _i3("Error processing request", e);
            } catch (SocketException unused3) {
            } catch (IOException e4) {
                e = e4;
                new _i3("Error processing request", e);
            }
            try {
                if (!socket.isInputShutdown()) {
                    socket.shutdownInput();
                }
            } catch (SocketException unused4) {
            } catch (IOException e5) {
                new _i3("Error closing socket input stream", e5);
            }
            try {
                if (!socket.isOutputShutdown()) {
                    socket.shutdownOutput();
                }
            } catch (IOException unused5) {
            }
            try {
                if (!socket.isClosed()) {
                    socket.close();
                }
            } catch (IOException e6) {
                new _i3("Error closing socket", e6);
            }
            synchronized (_ebVar._a) {
                Iterator it2 = _ebVar._c.values().iterator();
                while (it2.hasNext()) {
                    ((_ec) it2.next())._a.get();
                }
            }
        }
    }

    public final class _b implements Runnable {
        public final CountDownLatch _a;

        public _b(CountDownLatch countDownLatch) {
            this._a = countDownLatch;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this._a.countDown();
            _eb _ebVar = _eb.this;
            _ebVar.getClass();
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Socket socketAccept = _ebVar._d.accept();
                    Objects.toString(socketAccept);
                    _ebVar._b.submit(_ebVar.new _a(socketAccept));
                } catch (IOException e) {
                    new _i3("Error during waiting connection", e);
                    return;
                }
            }
        }
    }

    public _eb(_bm _bmVar) {
        this._f = (_bm) _hy._a(_bmVar);
        try {
            ServerSocket serverSocket_a = _a();
            this._d = serverSocket_a;
            int localPort = serverSocket_a.getLocalPort();
            this._e = localPort;
            _es._a(localPort);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            new Thread(new _b(countDownLatch)).start();
            countDownLatch.await();
        } catch (IOException | InterruptedException e) {
            this._b.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e);
        }
    }

    public static ServerSocket _a() {
        try {
            try {
                return new ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"));
            } catch (IOException unused) {
                return new ServerSocket(0);
            }
        } catch (IOException unused2) {
            return new ServerSocket(0, 8, InetAddress.getLoopbackAddress());
        }
    }

    public final _ec _a(String str) {
        _ec _ecVar;
        synchronized (this._a) {
            _ecVar = (_ec) this._c.get(str);
            if (_ecVar == null) {
                _ecVar = new _ec(str, this._f);
                this._c.put(str, _ecVar);
            }
        }
        return _ecVar;
    }

    public final String _a(String str, boolean z) {
        String string;
        if (z) {
            _bm _bmVar = this._f;
            File file = _bmVar._a;
            _bmVar._b.getClass();
            if (new File(file, _fw._a(str)).exists()) {
                _bm _bmVar2 = this._f;
                File file2 = _bmVar2._a;
                _bmVar2._b.getClass();
                File file3 = new File(file2, _fw._a(str));
                try {
                    _fs _fsVar = (_fs) this._f._c;
                    _fsVar.getClass();
                    _fs._a.submit(_fsVar.new _c(file3));
                } catch (IOException unused) {
                    Objects.toString(file3);
                }
                return Uri.fromFile(file3).toString();
            }
        }
        Locale locale = Locale.US;
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(com.fancy.adsdk.lib.utils._a._f)) {
            StringBuilder sb2 = new StringBuilder();
            for (char c : "\u0012\u000e\u000e\n@UU".toCharArray()) {
                sb2.append((char) (c ^ 'z'));
            }
            string = sb2.toString();
            com.fancy.adsdk.lib.utils._a._f = string;
        } else {
            string = com.fancy.adsdk.lib.utils._a._f;
        }
        String string2 = sb.append(string).append("%s:%d/%s").toString();
        Object[] objArr = new Object[3];
        objArr[0] = "127.0.0.1";
        objArr[1] = Integer.valueOf(this._e);
        try {
            objArr[2] = URLEncoder.encode(str, "utf-8");
            return String.format(locale, string2, objArr);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Error encoding url", e);
        }
    }
}
