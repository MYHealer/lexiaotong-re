package com.opos.cmn.an.g.a.a;

import android.content.Context;
import android.net.Proxy;
import com.opos.cmn.an.g.f;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.security.GeneralSecurityException;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f5920a;
    protected f b;
    protected HttpURLConnection c = a();

    public a(Context context, f fVar) {
        this.f5920a = context;
        this.b = fVar;
    }

    private HttpURLConnection a() {
        c();
        HttpURLConnection httpURLConnection = null;
        if (com.opos.cmn.an.d.a.a(this.b.c)) {
            return null;
        }
        try {
            URL url = new URL(this.b.c);
            URLConnection uRLConnectionOpenConnection = (!com.opos.cmn.an.h.c.a.c(this.f5920a) || com.opos.cmn.an.d.a.a(Proxy.getDefaultHost())) ? url.openConnection() : url.openConnection(b());
            httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
            c(httpURLConnection);
            a(httpURLConnection);
            b(httpURLConnection);
            return httpURLConnection;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("HttpURLBaseTask", "", e);
            return httpURLConnection;
        }
    }

    private void a(HttpURLConnection httpURLConnection) throws ProtocolException {
        if (httpURLConnection != null) {
            httpURLConnection.setConnectTimeout(this.b.e);
            httpURLConnection.setReadTimeout(this.b.f);
            httpURLConnection.setDoInput(true);
            if ("GET".equals(this.b.b)) {
                httpURLConnection.setUseCaches(true);
            } else if ("POST".equals(this.b.b)) {
                httpURLConnection.setDoOutput(true);
            }
            httpURLConnection.setRequestMethod(this.b.b);
        }
    }

    private java.net.Proxy b() {
        return new java.net.Proxy(java.net.Proxy.Type.HTTP, new InetSocketAddress(Proxy.getDefaultHost(), Proxy.getDefaultPort()));
    }

    private void b(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null || this.b.d == null || this.b.d.size() <= 0) {
            return;
        }
        for (Map.Entry<String, String> entry : this.b.d.entrySet()) {
            if (entry != null) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    private void c() {
    }

    private void c(HttpURLConnection httpURLConnection) {
        if (httpURLConnection instanceof HttpsURLConnection) {
            try {
                if (this.b.h != null) {
                    ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(this.b.h);
                } else {
                    System.currentTimeMillis();
                    SSLSocketFactory sSLSocketFactoryD = d();
                    if (sSLSocketFactoryD != null) {
                        ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactoryD);
                    }
                }
                if (this.b.i != null) {
                    ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(this.b.i);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("HttpURLBaseTask", "setHttpsPropertyIfNeed", e);
            }
        }
    }

    private static SSLSocketFactory d() {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, null, null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }
}
