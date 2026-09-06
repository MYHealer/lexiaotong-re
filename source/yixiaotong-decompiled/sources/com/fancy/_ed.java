package com.fancy;

import com.alipay.sdk.util.i;
import com.huawei.openalliance.ad.constant.x;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ed implements _nl {
    public final _nn _a;
    public final _e2 _b;
    public _nm _c;
    public HttpURLConnection _d;
    public BufferedInputStream _e;

    public _ed(_ed _edVar) {
        this._c = _edVar._c;
        this._a = _edVar._a;
        this._b = _edVar._b;
    }

    public _ed(String str, _nn _nnVar, _e2 _e2Var) {
        this._a = (_nn) _hy._a(_nnVar);
        this._b = (_e2) _hy._a(_e2Var);
        _nm _nmVar_a = _nnVar._a(str);
        this._c = _nmVar_a == null ? new _nm(str, _i4._c(str), -2147483648L) : _nmVar_a;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x005b  */
    /* JADX WARN: Code duplicated, block: B:32:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:? A[SYNTHETIC] */
    public final void _a() throws Throwable {
        HttpURLConnection httpURLConnection_a;
        String str = this._c._a;
        InputStream inputStream = null;
        try {
            httpURLConnection_a = _a(0L, 10000);
            try {
                try {
                    String headerField = httpURLConnection_a.getHeaderField("Content-Length");
                    long j = headerField == null ? -1L : Long.parseLong(headerField);
                    String contentType = httpURLConnection_a.getContentType();
                    inputStream = httpURLConnection_a.getInputStream();
                    String str2 = this._c._a;
                    _nm _nmVar = new _nm(str2, contentType, j);
                    this._c = _nmVar;
                    this._a._a(str2, _nmVar);
                    Objects.toString(this._c);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                } catch (IOException unused2) {
                    String str3 = this._c._a;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    if (httpURLConnection_a == null) {
                        return;
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                if (httpURLConnection_a != null) {
                    throw th;
                }
                httpURLConnection_a.disconnect();
                throw th;
            }
        } catch (IOException unused5) {
            httpURLConnection_a = null;
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection_a = null;
            if (inputStream != null) {
                inputStream.close();
            }
            if (httpURLConnection_a != null) {
                throw th;
            }
            httpURLConnection_a.disconnect();
            throw th;
        }
        httpURLConnection_a.disconnect();
    }

    @Override // com.fancy._nl
    public final void close() {
        HttpURLConnection httpURLConnection = this._d;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (ArrayIndexOutOfBoundsException unused) {
            } catch (IllegalArgumentException e) {
                e = e;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            } catch (NullPointerException e2) {
                e = e2;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            }
        }
    }

    @Override // com.fancy._nl
    public final synchronized long length() {
        if (this._c._b == -2147483648L) {
            _a();
        }
        return this._c._b;
    }

    @Override // com.fancy._nl
    public final int read(byte[] bArr) throws _i3 {
        BufferedInputStream bufferedInputStream = this._e;
        if (bufferedInputStream == null) {
            throw new _i3(_ie._a("Error reading data from ").append(this._c._a).append(": connection is absent!").toString());
        }
        try {
            return bufferedInputStream.read(bArr, 0, bArr.length);
        } catch (InterruptedIOException e) {
            throw new _fh(_ie._a("Reading source ").append(this._c._a).append(" is interrupted").toString(), e);
        } catch (IOException e2) {
            throw new _i3(_ie._a("Error reading data from ").append(this._c._a).toString(), e2);
        }
    }

    public final String toString() {
        return _ie._a("HttpUrlSource{sourceInfo='").append(this._c).append(i.d).toString();
    }

    @Override // com.fancy._nl
    public final void _a(long j) throws _i3 {
        try {
            HttpURLConnection httpURLConnection_a = _a(j, -1);
            this._d = httpURLConnection_a;
            String contentType = httpURLConnection_a.getContentType();
            this._e = new BufferedInputStream(this._d.getInputStream(), 8192);
            HttpURLConnection httpURLConnection = this._d;
            int responseCode = httpURLConnection.getResponseCode();
            String headerField = httpURLConnection.getHeaderField("Content-Length");
            long j2 = headerField == null ? -1L : Long.parseLong(headerField);
            if (responseCode != 200) {
                j2 = responseCode == 206 ? j2 + j : this._c._b;
            }
            String str = this._c._a;
            _nm _nmVar = new _nm(str, contentType, j2);
            this._c = _nmVar;
            this._a._a(str, _nmVar);
        } catch (IOException e) {
            throw new _i3(_ie._a("Error opening connection for ").append(this._c._a).append(" with offset ").append(j).toString(), e);
        }
    }

    public final HttpURLConnection _a(long j, int i) throws _i3, IOException {
        HttpURLConnection httpURLConnection;
        boolean z;
        String headerField = this._c._a;
        int i2 = 0;
        do {
            httpURLConnection = (HttpURLConnection) new URL(headerField).openConnection();
            for (Map.Entry entry : this._b._a().entrySet()) {
                httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            if (j > 0) {
                httpURLConnection.setRequestProperty("Range", "bytes=" + j + x.A);
            }
            if (i > 0) {
                httpURLConnection.setConnectTimeout(i);
                httpURLConnection.setReadTimeout(i);
            }
            int responseCode = httpURLConnection.getResponseCode();
            z = responseCode == 301 || responseCode == 302 || responseCode == 303;
            if (z) {
                headerField = httpURLConnection.getHeaderField("Location");
                i2++;
                httpURLConnection.disconnect();
            }
            if (i2 > 5) {
                throw new _i3("Too many redirects: " + i2);
            }
        } while (z);
        return httpURLConnection;
    }
}
