package com.hihonor.adsdk.base.net;

import com.hihonor.adsdk.EnvInit;
import com.hihonor.adsdk.base.HnAds;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class m {
    private static final int hnadsb = 30;
    private static final int hnadsc = 10;
    private volatile com.hihonor.adsdk.base.api.a hnadsa;

    static /* synthetic */ class a {
    }

    private static final class b {
        static final m hnadsa = new m(null);

        private b() {
        }
    }

    /* synthetic */ m(a aVar) {
        this();
    }

    public static m hnadsb() {
        return b.hnadsa;
    }

    private HttpLoggingInterceptor hnadsd() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new k());
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    private HttpLoggingInterceptor.Level hnadse() {
        return HttpLoggingInterceptor.Level.NONE;
    }

    public <T> T hnadsa(Class<T> cls) {
        return (T) hnadsa(com.hihonor.adsdk.base.net.p.a.hnadsa(), cls);
    }

    private m() {
    }

    public com.hihonor.adsdk.base.api.a hnadsc() {
        if (this.hnadsa == null) {
            synchronized (m.class) {
                if (this.hnadsa == null) {
                    this.hnadsa = (com.hihonor.adsdk.base.api.a) hnadsa(com.hihonor.adsdk.base.api.a.class);
                }
            }
        }
        return this.hnadsa;
    }

    public <T> T hnadsa(String str, Class<T> cls) {
        return (T) new com.hihonor.adsdk.base.net.q.a.b(HnAds.get().getContext()).hnadsa(str).hnadsa(new com.hihonor.adsdk.base.net.n.a()).hnadsa(hnadsa()).hnadsa(com.hihonor.adsdk.base.net.b.hnadsa()).hnadsa(hnadse()).hnadsa().hnadsb().create(cls);
    }

    private OkHttpClient.Builder hnadsa() {
        OkHttpClient.Builder builderNewBuilder = new OkHttpClient().newBuilder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient.Builder builderEventListener = builderNewBuilder.readTimeout(30L, timeUnit).connectTimeout(10L, timeUnit).writeTimeout(30L, timeUnit).retryOnConnectionFailure(true).eventListener(new com.hihonor.adsdk.base.net.o.c());
        EnvInit.hnadsa(builderEventListener);
        return builderEventListener;
    }
}
