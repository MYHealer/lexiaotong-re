package com.fancy;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.Locale;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ea extends _i2 {
    public final _ed _i;
    public final _dr _j;
    public _b1 _k;

    public _ea(_ed _edVar, _dr _drVar) {
        super(_edVar, _drVar);
        this._j = _drVar;
        this._i = _edVar;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x01cd */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void _a(_dx _dxVar, Socket socket) throws _i3, IOException {
        String str;
        String str2;
        String str3;
        String str4;
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        _ed _edVar = this._i;
        synchronized (_edVar) {
            if (TextUtils.isEmpty(_edVar._c._c)) {
                _edVar._a();
            }
            str = _edVar._c._c;
        }
        boolean z = !TextUtils.isEmpty(str);
        long jAvailable = this._j._b() ? this._j.available() : this._i.length();
        boolean z2 = jAvailable >= 0;
        boolean z3 = _dxVar._c;
        long j = z3 ? jAvailable - _dxVar._b : jAvailable;
        boolean z4 = z2 && z3;
        StringBuilder sbAppend = new StringBuilder().append(_dxVar._c ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n").append("Accept-Ranges: bytes\n");
        if (z2) {
            str2 = String.format(Locale.US, "Content-Length: %d\n", Long.valueOf(j));
        } else {
            str2 = "";
        }
        StringBuilder sbAppend2 = sbAppend.append(str2);
        if (z4) {
            str3 = String.format(Locale.US, "Content-Range: bytes %d-%d/%d\n", Long.valueOf(_dxVar._b), Long.valueOf(jAvailable - 1), Long.valueOf(jAvailable));
        } else {
            str3 = "";
        }
        StringBuilder sbAppend3 = sbAppend2.append(str3);
        if (z) {
            str4 = String.format(Locale.US, "Content-Type: %s\n", str);
        } else {
            str4 = "";
        }
        bufferedOutputStream.write(sbAppend3.append(str4).append(IOUtils.LINE_SEPARATOR_UNIX).toString().getBytes("UTF-8"));
        long j2 = _dxVar._b;
        long length = this._i.length();
        boolean z5 = length > 0;
        long jAvailable2 = this._j.available();
        if (z5 && _dxVar._c) {
            if (_dxVar._b > (length * 0.2f) + jAvailable2) {
                _ed _edVar2 = new _ed(this._i);
                try {
                    _edVar2._a((int) j2);
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i = _edVar2.read(bArr);
                        if (i == -1) {
                            bufferedOutputStream.flush();
                            return;
                        }
                        bufferedOutputStream.write(bArr, 0, i);
                    }
                } finally {
                    _edVar2.close();
                }
            }
        }
        byte[] bArr2 = new byte[8192];
        while (true) {
            if (!(j2 >= 0)) {
                throw new IllegalArgumentException("Data offset must be positive!");
            }
            while (!this._b._b() && this._b.available() < ((long) 8192) + j2 && !this._g) {
                synchronized (this) {
                    boolean z6 = (this._f == null || this._f.getState() == Thread.State.TERMINATED) ? false : true;
                    if (!this._g && !this._b._b() && !z6) {
                        this._f = new Thread(new _i2._a(this), "Source reader for " + this._a);
                        this._f.start();
                    }
                }
                synchronized (this._c) {
                    try {
                        this._c.wait(1000L);
                    } catch (InterruptedException e) {
                        throw new _i3("Waiting source data is interrupted!", e);
                    }
                }
                int i2 = this._e.get();
                if (i2 >= 1) {
                    this._e.set(0);
                    throw new _i3("Error reading source " + i2 + " times");
                }
            }
            int i_a = this._b._a(bArr2, j2);
            if (this._b._b() && this._h != 100) {
                this._h = 100;
                _b1 _b1Var = this._k;
                if (_b1Var != null) {
                    File file = this._j._b;
                    String str5 = this._i._c._a;
                    _b1Var._a(file, 100);
                }
            }
            if (i_a == -1) {
                bufferedOutputStream.flush();
                return;
            } else {
                bufferedOutputStream.write(bArr2, 0, i_a);
                j2 += (long) i_a;
            }
        }
    }
}
