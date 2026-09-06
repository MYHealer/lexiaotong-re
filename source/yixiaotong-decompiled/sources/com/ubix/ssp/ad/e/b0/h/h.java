package com.ubix.ssp.ad.e.b0.h;

import android.net.TrafficStats;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.x;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class h implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.ubix.ssp.ad.e.b0.h.u.c f8789a;
    private final com.ubix.ssp.ad.e.b0.h.t.b b;
    private q c;
    private HttpURLConnection d;
    private InputStream e;

    public h(h hVar) {
        this.c = hVar.c;
        this.f8789a = hVar.f8789a;
        this.b = hVar.b;
    }

    public h(String str) {
        this(str, com.ubix.ssp.ad.e.b0.h.u.d.a());
    }

    public h(String str, com.ubix.ssp.ad.e.b0.h.u.c cVar) {
        this(str, cVar, new com.ubix.ssp.ad.e.b0.h.t.a());
    }

    public h(String str, com.ubix.ssp.ad.e.b0.h.u.c cVar, com.ubix.ssp.ad.e.b0.h.t.b bVar) {
        this.f8789a = (com.ubix.ssp.ad.e.b0.h.u.c) l.a(cVar);
        this.b = (com.ubix.ssp.ad.e.b0.h.t.b) l.a(bVar);
        q qVarA = cVar.a(str);
        this.c = qVarA == null ? new q(str, -2147483648L, o.d(str)) : qVarA;
    }

    private long a(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (headerField == null) {
            return -1L;
        }
        return Long.parseLong(headerField);
    }

    private long a(HttpURLConnection httpURLConnection, long j, int i) {
        long jA = a(httpURLConnection);
        if (i == 200) {
            return jA;
        }
        return i == 206 ? jA + j : this.c.b;
    }

    private HttpURLConnection a(long j, int i) throws IOException, n {
        HttpURLConnection httpURLConnection;
        boolean z;
        String headerField = this.c.f8796a;
        if (TrafficStats.getThreadStatsTag() == -1) {
            TrafficStats.setThreadStatsTag(1);
        }
        int i2 = 0;
        do {
            httpURLConnection = (HttpURLConnection) new URL(headerField).openConnection();
            a(httpURLConnection, headerField);
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
                throw new n("Too many redirects: " + i2);
            }
        } while (z);
        return httpURLConnection;
    }

    private void a(HttpURLConnection httpURLConnection, String str) {
        for (Map.Entry<String, String> entry : this.b.a(str).entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    private void b() throws Throwable {
        InputStream inputStream;
        InputStream inputStream2;
        HttpURLConnection httpURLConnection = null;
        inputStream = null;
        InputStream inputStream3 = null;
        HttpURLConnection httpURLConnection2 = null;
        try {
            HttpURLConnection httpURLConnectionA = a(0L, 10000);
            try {
                long jA = a(httpURLConnectionA);
                String contentType = httpURLConnectionA.getContentType();
                inputStream3 = httpURLConnectionA.getInputStream();
                q qVar = new q(this.c.f8796a, jA, contentType);
                this.c = qVar;
                this.f8789a.a(qVar.f8796a, qVar);
                o.a(inputStream3);
                httpURLConnectionA.disconnect();
            } catch (IOException unused) {
                InputStream inputStream4 = inputStream3;
                httpURLConnection2 = httpURLConnectionA;
                inputStream2 = inputStream4;
                o.a(inputStream2);
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            } catch (Throwable th) {
                th = th;
                InputStream inputStream5 = inputStream3;
                httpURLConnection = httpURLConnectionA;
                inputStream = inputStream5;
                o.a(inputStream);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (IOException unused2) {
            inputStream2 = null;
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
    }

    @Override // com.ubix.ssp.ad.e.b0.h.p
    public int a(byte[] bArr) throws n {
        InputStream inputStream = this.e;
        if (inputStream == null) {
            throw new n("Error reading data from " + this.c.f8796a + ": connection is absent!");
        }
        try {
            return inputStream.read(bArr, 0, bArr.length);
        } catch (InterruptedIOException e) {
            throw new j("Reading source " + this.c.f8796a + " is interrupted", e);
        } catch (IOException e2) {
            throw new n("Error reading data from " + this.c.f8796a, e2);
        }
    }

    @Override // com.ubix.ssp.ad.e.b0.h.p
    public synchronized long a() {
        if (this.c.b == -2147483648L) {
            b();
        }
        return this.c.b;
    }

    @Override // com.ubix.ssp.ad.e.b0.h.p
    public void a(long j) throws n {
        try {
            HttpURLConnection httpURLConnectionA = a(j, -1);
            this.d = httpURLConnectionA;
            String contentType = httpURLConnectionA.getContentType();
            this.e = new BufferedInputStream(this.d.getInputStream(), 8192);
            HttpURLConnection httpURLConnection = this.d;
            q qVar = new q(this.c.f8796a, a(httpURLConnection, j, httpURLConnection.getResponseCode()), contentType);
            this.c = qVar;
            this.f8789a.a(qVar.f8796a, qVar);
        } catch (IOException e) {
            throw new n("Error opening connection for " + this.c.f8796a + " with offset " + j, e);
        }
    }

    public synchronized String c() {
        if (TextUtils.isEmpty(this.c.c)) {
            b();
        }
        return this.c.c;
    }

    @Override // com.ubix.ssp.ad.e.b0.h.p
    public void close() {
        HttpURLConnection httpURLConnection = this.d;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (ArrayIndexOutOfBoundsException unused) {
            } catch (IllegalArgumentException e) {
                e = e;
                throw new RuntimeException("Wait... ", e);
            } catch (NullPointerException e2) {
                e = e2;
                throw new RuntimeException("Wait... ", e);
            }
        }
    }

    public String d() {
        return this.c.f8796a;
    }

    public String toString() {
        return "HttpUrlSource{sourceInfo='" + this.c + com.alipay.sdk.util.i.d;
    }
}
