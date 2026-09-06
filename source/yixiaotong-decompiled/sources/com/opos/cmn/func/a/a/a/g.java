package com.opos.cmn.func.a.a.a;

import com.kwad.sdk.core.imageloader.KSImageLoader;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6072a;
    public final int b;
    public final SSLSocketFactory c;
    public final HostnameVerifier d;
    public final X509TrustManager e;
    public final d f;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f6073a = KSImageLoader.InnerImageLoadingListener.MAX_DURATION;
        private int b = KSImageLoader.InnerImageLoadingListener.MAX_DURATION;
        private SSLSocketFactory c;
        private HostnameVerifier d;
        private d e;
        private X509TrustManager f;

        public a a(SSLSocketFactory sSLSocketFactory) {
            this.c = sSLSocketFactory;
            return this;
        }

        public g a() {
            if (this.e == null) {
                this.e = new d.a().a();
            }
            return new g(this, null);
        }
    }

    static /* synthetic */ class b {
    }

    private g(a aVar) {
        this.f6072a = aVar.f6073a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.f;
        this.f = aVar.e;
    }

    /* synthetic */ g(a aVar, b bVar) {
        this(aVar);
    }

    public String toString() {
        return "InitParameter{, connectTimeout=" + this.f6072a + ", readTimeout=" + this.b + ", sslSocketFactory=" + this.c + ", hostnameVerifier=" + this.d + ", x509TrustManager=" + this.e + ", httpExtConfig=" + this.f + '}';
    }
}
