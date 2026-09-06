package com.fancy;

import java.io.BufferedInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _i0 implements Runnable {
    public static final ArrayList _f = new ArrayList();
    public String _a;
    public boolean _b;
    public boolean _c;
    public Runnable _d;
    public _eb _e;

    /* JADX WARN: Code duplicated, block: B:28:0x006a  */
    /* JADX WARN: Code duplicated, block: B:38:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:? A[RETURN, SYNTHETIC] */
    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        Runnable runnable;
        Throwable th;
        HttpURLConnection httpURLConnection;
        if (!this._b && !_f.contains(this._a)) {
            try {
                httpURLConnection = (HttpURLConnection) new URL(this._e._a(this._a, true)).openConnection();
                try {
                    try {
                        httpURLConnection.setConnectTimeout(5000);
                        httpURLConnection.setReadTimeout(5000);
                        httpURLConnection.setUseCaches(true);
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                        byte[] bArr = new byte[8192];
                        int i = -1;
                        do {
                            int i2 = bufferedInputStream.read(bArr);
                            if (i2 == -1) {
                                break;
                            }
                            i += i2;
                            if (this._b) {
                                break;
                            }
                        } while (i < 2097152);
                    } catch (Exception e) {
                        e = e;
                        e.getMessage();
                        _f.add(this._a);
                        if (httpURLConnection != null) {
                            break;
                        }
                        this._c = false;
                        this._b = false;
                        runnable = this._d;
                        this._d = null;
                        if (runnable != null) {
                            try {
                                runnable.run();
                            } catch (Throwable unused) {
                                return;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                httpURLConnection = null;
            } catch (Throwable th3) {
                th = th3;
                httpURLConnection = null;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
            httpURLConnection.disconnect();
        }
        this._c = false;
        this._b = false;
        runnable = this._d;
        this._d = null;
        if (runnable != null) {
            runnable.run();
        }
    }
}
