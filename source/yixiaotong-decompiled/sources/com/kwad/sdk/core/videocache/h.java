package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.x;
import com.kwad.sdk.core.network.r;
import com.kwad.sdk.utils.az;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class h extends p {
    private final com.kwad.sdk.core.videocache.d.c aZN;
    private final com.kwad.sdk.core.videocache.b.b aZO;
    private n bal;
    private HttpURLConnection bam;
    private InputStream ban;

    public h(String str, com.kwad.sdk.core.videocache.d.c cVar, com.kwad.sdk.core.videocache.b.b bVar) {
        this.aZN = (com.kwad.sdk.core.videocache.d.c) az.checkNotNull(cVar);
        this.aZO = (com.kwad.sdk.core.videocache.b.b) az.checkNotNull(bVar);
        n nVarFG = cVar.fG(str);
        this.bal = nVarFG == null ? new n(str, -2147483648L, l.fE(str)) : nVarFG;
    }

    public h(h hVar) {
        this.bal = hVar.bal;
        this.aZN = hVar.aZN;
        this.aZO = hVar.aZO;
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final synchronized long length() {
        if (this.bal.baB == -2147483648L) {
            Pg();
        }
        if (this.bal.baB == -2147483648L) {
            Pe();
        }
        return this.bal.baB;
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final void aP(long j) throws ProxyCacheException {
        try {
            HttpURLConnection httpURLConnectionE = e(j, -1);
            this.bam = httpURLConnectionE;
            String contentType = httpURLConnectionE.getContentType();
            this.ban = new BufferedInputStream(this.bam.getInputStream(), 1024);
            HttpURLConnection httpURLConnection = this.bam;
            n nVar = new n(this.bal.url, a(httpURLConnection, j, httpURLConnection.getResponseCode()), contentType);
            this.bal = nVar;
            this.aZN.a(nVar.url, this.bal);
        } catch (IOException e) {
            throw new ProxyCacheException("Error opening connection for " + this.bal.url + " with offset " + j, e);
        }
    }

    private long a(HttpURLConnection httpURLConnection, long j, int i) {
        long jD = d(httpURLConnection);
        if (i == 200) {
            return jD;
        }
        return i == 206 ? jD + j : this.bal.baB;
    }

    private static long d(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (headerField == null) {
            return -1L;
        }
        return Long.parseLong(headerField);
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final void close() {
        HttpURLConnection httpURLConnection = this.bam;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (ArrayIndexOutOfBoundsException unused) {
                com.kwad.sdk.core.d.c.e("HttpUrlSource", "Error closing connection correctly. Should happen only on Android L. If anybody know how to fix it, please visit https://github.com/danikula/AndroidVideoCache/issues/88. Until good solution is not know, just ignore this issue.");
            } catch (IllegalArgumentException e) {
                e = e;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            } catch (NullPointerException e2) {
                e = e2;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            }
        }
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final int read(byte[] bArr) throws ProxyCacheException {
        InputStream inputStream = this.ban;
        if (inputStream == null) {
            throw new ProxyCacheException("Error reading data from " + this.bal.url + ": connection is absent!");
        }
        try {
            return inputStream.read(bArr, 0, 1024);
        } catch (InterruptedIOException e) {
            throw new InterruptedProxyCacheException("Reading source " + this.bal.url + " is interrupted", e);
        } catch (IOException e2) {
            throw new ProxyCacheException("Error reading data from " + this.bal.url, e2);
        }
    }

    private void Pe() throws Throwable {
        HttpURLConnection httpURLConnectionE;
        com.kwad.sdk.core.d.c.d("HttpUrlSource", "Read content info from " + this.bal.url);
        InputStream inputStream = null;
        try {
            httpURLConnectionE = e(0L, 10000);
            try {
                try {
                    long jD = d(httpURLConnectionE);
                    String contentType = httpURLConnectionE.getContentType();
                    inputStream = httpURLConnectionE.getInputStream();
                    n nVar = new n(this.bal.url, jD, contentType);
                    this.bal = nVar;
                    this.aZN.a(nVar.url, this.bal);
                    com.kwad.sdk.core.d.c.d("HttpUrlSource", "Source info fetched: " + this.bal);
                } catch (IOException unused) {
                    com.kwad.sdk.core.d.c.e("HttpUrlSource", "Error fetching info from " + this.bal.url);
                }
            } catch (Throwable th) {
                th = th;
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnectionE);
                throw th;
            }
        } catch (IOException unused2) {
            httpURLConnectionE = null;
        } catch (Throwable th2) {
            th = th2;
            httpURLConnectionE = null;
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnectionE);
            throw th;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
        com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnectionE);
    }

    private HttpURLConnection e(long j, int i) throws IOException, ProxyCacheException {
        HttpURLConnection httpURLConnection;
        boolean z;
        String headerField = this.bal.url;
        int i2 = 0;
        do {
            com.kwad.sdk.core.d.c.d("HttpUrlSource", "Open connection " + (j > 0 ? " with offset " + j : "") + " to " + headerField);
            httpURLConnection = (HttpURLConnection) new URL(headerField).openConnection();
            r.wrapHttpURLConnection(httpURLConnection);
            a(httpURLConnection, headerField);
            if (j > 0) {
                httpURLConnection.setRequestProperty("Range", "bytes=" + j + x.A);
            }
            if (i > 0) {
                httpURLConnection.setConnectTimeout(i);
                httpURLConnection.setReadTimeout(i);
            }
            com.kwad.sdk.core.network.p.b(httpURLConnection);
            int responseCode = httpURLConnection.getResponseCode();
            z = responseCode == 301 || responseCode == 302 || responseCode == 303;
            if (z) {
                headerField = httpURLConnection.getHeaderField("Location");
                i2++;
                httpURLConnection.disconnect();
            }
            if (i2 > 5) {
                throw new ProxyCacheException("Too many redirects: " + i2);
            }
        } while (z);
        return httpURLConnection;
    }

    private void a(HttpURLConnection httpURLConnection, String str) {
        for (Map.Entry<String, String> entry : this.aZO.Pn().entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.kwad.sdk.core.videocache.p
    public final synchronized String Pf() {
        if (TextUtils.isEmpty(this.bal.baC)) {
            Pg();
        }
        if (TextUtils.isEmpty(this.bal.baC)) {
            Pe();
        }
        return this.bal.baC;
    }

    @Override // com.kwad.sdk.core.videocache.p
    public final String getUrl() {
        return this.bal.url;
    }

    private void Pg() {
        n nVarFG;
        com.kwad.sdk.core.videocache.d.c cVar = this.aZN;
        if (cVar == null || !(cVar instanceof com.kwad.sdk.core.videocache.d.b) || (nVarFG = cVar.fG(getUrl())) == null || TextUtils.isEmpty(nVarFG.baC) || nVarFG.baB == -2147483648L) {
            return;
        }
        this.bal = nVarFG;
    }

    @Override // com.kwad.sdk.core.videocache.p
    public final String toString() {
        return "HttpUrlSource{sourceInfo='" + this.bal + com.alipay.sdk.util.i.d;
    }
}
