package com.unionpay.a;

import java.io.IOException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SSLContext f9304a = null;
    private String b;

    public a(String str) {
        this.b = str;
    }

    private static SSLContext a(String str) throws IOException {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{new b(str)}, null);
            return sSLContext;
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }

    public final SSLContext a() {
        if (this.f9304a == null) {
            this.f9304a = a(this.b);
        }
        return this.f9304a;
    }

    public boolean equals(Object obj) {
        return obj != null && obj.getClass().equals(a.class);
    }

    public int hashCode() {
        return a.class.hashCode();
    }
}
