package com.opos.videocache;

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
public class d implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.opos.videocache.c.b f8436a;
    private final com.opos.videocache.b.b b;
    private j c;
    private HttpURLConnection d;
    private InputStream e;

    public d(d dVar) {
        this.c = dVar.c;
        this.f8436a = dVar.f8436a;
        this.b = dVar.b;
    }

    public d(String str) {
        this(str, com.opos.videocache.c.c.a());
    }

    public d(String str, com.opos.videocache.c.b bVar) {
        this(str, bVar, new com.opos.videocache.b.a());
    }

    public d(String str, com.opos.videocache.c.b bVar, com.opos.videocache.b.b bVar2) {
        this.f8436a = (com.opos.videocache.c.b) f.a(bVar);
        this.b = (com.opos.videocache.b.b) f.a(bVar2);
        j jVarA = bVar.a(str);
        this.c = jVarA == null ? new j(str, -2147483648L, h.a(str)) : jVarA;
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

    private HttpURLConnection a(long j, int i) throws IOException, g {
        HttpURLConnection httpURLConnection;
        boolean z;
        String headerField = this.c.f8437a;
        int i2 = 0;
        do {
            com.opos.cmn.an.f.a.b("HttpUrlSource", "Open connection " + (j > 0 ? " with offset " + j : "") + " to " + headerField);
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
                throw new g("Too many redirects: " + i2);
            }
        } while (z);
        return httpURLConnection;
    }

    private void a(HttpURLConnection httpURLConnection, String str) {
        for (Map.Entry<String, String> entry : this.b.a(str).entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0088  */
    private void e() throws Throwable {
        HttpURLConnection httpURLConnectionA;
        com.opos.cmn.an.f.a.b("HttpUrlSource", "Read content info from " + this.c.f8437a);
        InputStream inputStream = null;
        try {
            httpURLConnectionA = a(0L, 10000);
            try {
                try {
                    long jA = a(httpURLConnectionA);
                    String contentType = httpURLConnectionA.getContentType();
                    inputStream = httpURLConnectionA.getInputStream();
                    j jVar = new j(this.c.f8437a, jA, contentType);
                    this.c = jVar;
                    this.f8436a.a(jVar.f8437a, this.c);
                    com.opos.cmn.an.f.a.b("HttpUrlSource", "Source info fetched: " + this.c);
                    h.a(inputStream);
                    if (httpURLConnectionA == null) {
                        return;
                    }
                } catch (IOException e) {
                    e = e;
                    com.opos.cmn.an.f.a.d("HttpUrlSource", "Error fetching info from " + this.c.f8437a, e);
                    h.a(inputStream);
                    if (httpURLConnectionA == null) {
                        return;
                    }
                }
            } catch (Throwable th) {
                th = th;
                h.a(inputStream);
                if (httpURLConnectionA != null) {
                    httpURLConnectionA.disconnect();
                }
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            httpURLConnectionA = null;
        } catch (Throwable th2) {
            th = th2;
            httpURLConnectionA = null;
            h.a(inputStream);
            if (httpURLConnectionA != null) {
                httpURLConnectionA.disconnect();
            }
            throw th;
        }
        httpURLConnectionA.disconnect();
    }

    @Override // com.opos.videocache.i
    public int a(byte[] bArr) throws g {
        InputStream inputStream = this.e;
        if (inputStream == null) {
            throw new g("Error reading data from " + this.c.f8437a + ": connection is absent!");
        }
        try {
            return inputStream.read(bArr, 0, bArr.length);
        } catch (InterruptedIOException e) {
            throw new e("Reading source " + this.c.f8437a + " is interrupted", e);
        } catch (IOException e2) {
            throw new g("Error reading data from " + this.c.f8437a, e2);
        }
    }

    @Override // com.opos.videocache.i
    public synchronized long a() {
        if (this.c.b == -2147483648L) {
            e();
        }
        return this.c.b;
    }

    @Override // com.opos.videocache.i
    public void a(long j) throws g {
        try {
            HttpURLConnection httpURLConnectionA = a(j, -1);
            this.d = httpURLConnectionA;
            String contentType = httpURLConnectionA.getContentType();
            this.e = new BufferedInputStream(this.d.getInputStream(), 8192);
            HttpURLConnection httpURLConnection = this.d;
            j jVar = new j(this.c.f8437a, a(httpURLConnection, j, httpURLConnection.getResponseCode()), contentType);
            this.c = jVar;
            this.f8436a.a(jVar.f8437a, this.c);
        } catch (IOException e) {
            throw new g("Error opening connection for " + this.c.f8437a + " with offset " + j, e);
        }
    }

    @Override // com.opos.videocache.i
    public void b() {
        HttpURLConnection httpURLConnection = this.d;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (ArrayIndexOutOfBoundsException e) {
                com.opos.cmn.an.f.a.d("HttpUrlSource", "Error closing connection correctly. Should happen only on Android L. If anybody know how to fix it, please visit. Until good solution is not know, just ignore this issue :(", e);
            } catch (IllegalArgumentException e2) {
                e = e2;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing .If you read it on your device log, please, notify me danikula@gmail.com or create issue here.", e);
            } catch (NullPointerException e3) {
                e = e3;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing .If you read it on your device log, please, notify me danikula@gmail.com or create issue here.", e);
            }
        }
    }

    public synchronized String c() {
        if (TextUtils.isEmpty(this.c.c)) {
            e();
        }
        return this.c.c;
    }

    public String d() {
        return this.c.f8437a;
    }

    public String toString() {
        return "HttpUrlSource{sourceInfo='" + this.c + com.alipay.sdk.util.i.d;
    }
}
