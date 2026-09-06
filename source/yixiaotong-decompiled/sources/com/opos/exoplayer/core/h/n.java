package com.opos.exoplayer.core.h;

import android.net.Uri;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.x;
import com.opos.exoplayer.core.i.y;
import cz.msebera.android.httpclient.protocol.HTTP;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class n implements q {
    private static final Pattern b = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> c = new AtomicReference<>();
    private final boolean d;
    private final int e;
    private final int f;
    private final String g;
    private final com.opos.exoplayer.core.i.r<String> h;
    private final q.f i;
    private final q.f j = new q.f();
    private final t<? super n> k;
    private i l;
    private HttpURLConnection m;
    private InputStream n;
    private boolean o;
    private long p;
    private long q;
    private long r;
    private long s;

    public n(String str, com.opos.exoplayer.core.i.r<String> rVar, t<? super n> tVar, int i, int i2, boolean z, q.f fVar) {
        this.g = com.opos.exoplayer.core.i.a.a(str);
        this.h = rVar;
        this.k = tVar;
        this.e = i;
        this.f = i2;
        this.d = z;
        this.i = fVar;
    }

    private static long a(HttpURLConnection httpURLConnection) {
        long j;
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (TextUtils.isEmpty(headerField)) {
            j = -1;
        } else {
            try {
                j = Long.parseLong(headerField);
            } catch (NumberFormatException unused) {
                com.opos.cmn.an.f.a.d("DefaultHttpDataSource", "Unexpected Content-Length [" + headerField + "]");
                j = -1;
            }
        }
        String headerField2 = httpURLConnection.getHeaderField("Content-Range");
        if (TextUtils.isEmpty(headerField2)) {
            return j;
        }
        Matcher matcher = b.matcher(headerField2);
        if (!matcher.find()) {
            return j;
        }
        try {
            long j2 = (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
            if (j < 0) {
                return j2;
            }
            if (j == j2) {
                return j;
            }
            com.opos.cmn.an.f.a.c("DefaultHttpDataSource", "Inconsistent headers [" + headerField + "] [" + headerField2 + "]");
            return Math.max(j, j2);
        } catch (NumberFormatException unused2) {
            com.opos.cmn.an.f.a.d("DefaultHttpDataSource", "Unexpected Content-Range [" + headerField2 + "]");
            return j;
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00dd  */
    private HttpURLConnection a(URL url, byte[] bArr, long j, long j2, boolean z, boolean z2) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.e);
        httpURLConnection.setReadTimeout(this.f);
        q.f fVar = this.i;
        if (fVar != null) {
            for (Map.Entry<String, String> entry : fVar.a().entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry<String, String> entry2 : this.j.a().entrySet()) {
            httpURLConnection.setRequestProperty(entry2.getKey(), entry2.getValue());
        }
        if (j != 0 || j2 != -1) {
            String str = "bytes=" + j + x.A;
            if (j2 != -1) {
                str = str + ((j + j2) - 1);
            }
            httpURLConnection.setRequestProperty("Range", str);
        }
        httpURLConnection.setRequestProperty("User-Agent", this.g);
        if (!z) {
            httpURLConnection.setRequestProperty("Accept-Encoding", HTTP.IDENTITY_CODING);
        }
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(bArr != null);
        if (bArr != null) {
            httpURLConnection.setRequestMethod("POST");
            if (bArr.length == 0) {
                httpURLConnection.connect();
            } else {
                httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                httpURLConnection.connect();
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.close();
            }
        } else {
            httpURLConnection.connect();
        }
        return httpURLConnection;
    }

    private static URL a(URL url, String str) throws ProtocolException {
        if (str == null) {
            throw new ProtocolException("Null location redirect");
        }
        URL url2 = new URL(url, str);
        String protocol = url2.getProtocol();
        if ("https".equals(protocol) || "http".equals(protocol)) {
            return url2;
        }
        throw new ProtocolException("Unsupported protocol redirect: " + protocol);
    }

    private static void a(HttpURLConnection httpURLConnection, long j) {
        int i = y.f6517a;
        if (i == 19 || i == 20) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (j == -1) {
                    if (inputStream.read() == -1) {
                        return;
                    }
                } else if (j <= 2048) {
                    return;
                }
                String name = inputStream.getClass().getName();
                if (name.equals("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream") || name.equals("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream")) {
                    Method declaredMethod = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(inputStream, new Object[0]);
                }
            } catch (Exception unused) {
            }
        }
    }

    private int b(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.q;
        if (j != -1) {
            long j2 = j - this.s;
            if (j2 == 0) {
                return -1;
            }
            i2 = (int) Math.min(i2, j2);
        }
        int i3 = this.n.read(bArr, i, i2);
        if (i3 == -1) {
            if (this.q == -1) {
                return -1;
            }
            throw new EOFException();
        }
        this.s += (long) i3;
        t<? super n> tVar = this.k;
        if (tVar != null) {
            tVar.a(this, i3);
        }
        return i3;
    }

    private HttpURLConnection b(i iVar) throws IOException {
        URL url = new URL(iVar.f6483a.toString());
        byte[] bArr = iVar.b;
        long j = iVar.d;
        long j2 = iVar.e;
        boolean zA = iVar.a(1);
        if (!this.d) {
            return a(url, bArr, j, j2, zA, true);
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i > 20) {
                throw new NoRouteToHostException("Too many redirects: " + i2);
            }
            long j3 = j;
            HttpURLConnection httpURLConnectionA = a(url, bArr, j, j2, zA, false);
            int responseCode = httpURLConnectionA.getResponseCode();
            if (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303 && (bArr != null || (responseCode != 307 && responseCode != 308))) {
                return httpURLConnectionA;
            }
            String headerField = httpURLConnectionA.getHeaderField("Location");
            httpURLConnectionA.disconnect();
            url = a(url, headerField);
            bArr = null;
            i = i2;
            j = j3;
        }
    }

    private void d() throws IOException {
        if (this.r == this.p) {
            return;
        }
        byte[] andSet = c.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[4096];
        }
        while (true) {
            long j = this.r;
            long j2 = this.p;
            if (j == j2) {
                c.set(andSet);
                return;
            }
            int i = this.n.read(andSet, 0, (int) Math.min(j2 - j, andSet.length));
            if (Thread.interrupted()) {
                throw new InterruptedIOException();
            }
            if (i == -1) {
                throw new EOFException();
            }
            this.r += (long) i;
            t<? super n> tVar = this.k;
            if (tVar != null) {
                tVar.a(this, i);
            }
        }
    }

    private void e() {
        HttpURLConnection httpURLConnection = this.m;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.d("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.m = null;
        }
    }

    @Override // com.opos.exoplayer.core.h.g
    public int a(byte[] bArr, int i, int i2) throws q.c {
        try {
            d();
            return b(bArr, i, i2);
        } catch (IOException e) {
            throw new q.c(e, this.l, 2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0075  */
    @Override // com.opos.exoplayer.core.h.g
    public long a(i iVar) throws q.c {
        long j;
        t<? super n> tVar;
        this.l = iVar;
        long j2 = 0;
        this.s = 0L;
        this.r = 0L;
        try {
            HttpURLConnection httpURLConnectionB = b(iVar);
            this.m = httpURLConnectionB;
            try {
                int responseCode = httpURLConnectionB.getResponseCode();
                if (responseCode < 200 || responseCode > 299) {
                    Map<String, List<String>> headerFields = this.m.getHeaderFields();
                    e();
                    q.e eVar = new q.e(responseCode, headerFields, iVar);
                    if (responseCode != 416) {
                        throw eVar;
                    }
                    eVar.initCause(new h(0));
                    throw eVar;
                }
                String contentType = this.m.getContentType();
                com.opos.exoplayer.core.i.r<String> rVar = this.h;
                if (rVar != null && !rVar.a(contentType)) {
                    e();
                    throw new q.d(contentType, iVar);
                }
                if (responseCode == 200) {
                    long j3 = iVar.d;
                    if (j3 != 0) {
                        j2 = j3;
                    }
                }
                this.p = j2;
                try {
                    if (!iVar.a(1)) {
                        j = iVar.e;
                        if (j == -1) {
                            long jA = a(this.m);
                            this.q = jA != -1 ? jA - this.p : -1L;
                        }
                        this.n = this.m.getInputStream();
                        this.o = true;
                        tVar = this.k;
                        if (tVar != null) {
                            tVar.a(this, iVar);
                        }
                        return this.q;
                    }
                    j = iVar.e;
                    this.n = this.m.getInputStream();
                    this.o = true;
                    tVar = this.k;
                    if (tVar != null) {
                        tVar.a(this, iVar);
                    }
                    return this.q;
                } catch (IOException e) {
                    e();
                    throw new q.c(e, iVar, 1);
                }
                this.q = j;
            } catch (IOException e2) {
                e();
                throw new q.c("Unable to connect to " + iVar.f6483a.toString(), e2, iVar, 1);
            }
        } catch (IOException e3) {
            throw new q.c("Unable to connect to " + iVar.f6483a.toString(), e3, iVar, 1);
        }
    }

    @Override // com.opos.exoplayer.core.h.g
    public Uri a() {
        HttpURLConnection httpURLConnection = this.m;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // com.opos.exoplayer.core.h.g
    public void b() {
        try {
            if (this.n != null) {
                a(this.m, c());
                try {
                    this.n.close();
                } catch (IOException e) {
                    throw new q.c(e, this.l, 3);
                }
            }
            this.n = null;
            e();
            if (this.o) {
                this.o = false;
                t<? super n> tVar = this.k;
                if (tVar != null) {
                    tVar.a(this);
                }
            }
        } catch (Throwable th) {
            this.n = null;
            e();
            if (this.o) {
                this.o = false;
                t<? super n> tVar2 = this.k;
                if (tVar2 != null) {
                    tVar2.a(this);
                }
            }
            throw th;
        }
    }

    protected final long c() {
        long j = this.q;
        return j == -1 ? j : j - this.s;
    }
}
