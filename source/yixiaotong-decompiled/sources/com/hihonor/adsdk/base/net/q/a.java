package com.hihonor.adsdk.base.net.q;

import android.content.Context;
import com.hihonor.adsdk.base.j.g;
import com.hihonor.adsdk.base.net.q.b.c;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class a {
    private static final String hnadsh = "XHttp";
    private Retrofit hnadsa;
    private final Context hnadsb;
    private final List<Interceptor> hnadsc;
    private final List<Converter.Factory> hnadsd;
    private final List<CallAdapter.Factory> hnadse;
    private final HttpLoggingInterceptor.Level hnadsf;
    private final c hnadsg;

    /* JADX INFO: renamed from: com.hihonor.adsdk.base.net.q.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0448a {
    }

    /* synthetic */ a(b bVar, C0448a c0448a) {
        this(bVar);
    }

    public Context hnadsa() {
        return this.hnadsb;
    }

    public Retrofit hnadsb() {
        return this.hnadsa;
    }

    private a(b bVar) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(bVar.hnadsa.getApplicationContext());
        this.hnadsb = origApplicationContext;
        c cVar = new c();
        this.hnadsg = cVar;
        cVar.hnadsa(origApplicationContext);
        cVar.hnadsa(bVar.hnadse);
        cVar.hnadsb(bVar.hnadsc);
        cVar.hnadsa(bVar.hnadsi);
        this.hnadsc = bVar.hnadsf;
        List<Converter.Factory> list = bVar.hnadsg;
        this.hnadsd = list;
        this.hnadse = bVar.hnadsh;
        this.hnadsf = bVar.hnadsi;
        OkHttpClient okHttpClientHnadsa = hnadsa(bVar);
        Retrofit.Builder builder = new Retrofit.Builder();
        String str = bVar.hnadsb;
        builder.baseUrl(str);
        cVar.hnadsa(str);
        builder.client(okHttpClientHnadsa);
        if (list != null && !list.isEmpty()) {
            for (Converter.Factory factory : list) {
                if (!(factory instanceof GsonConverterFactory)) {
                    builder.addConverterFactory(factory);
                }
            }
        }
        List<CallAdapter.Factory> list2 = this.hnadse;
        if (list2 != null && !list2.isEmpty()) {
            Iterator<CallAdapter.Factory> it = this.hnadse.iterator();
            while (it.hasNext()) {
                builder.addCallAdapterFactory(it.next());
            }
        }
        builder.addConverterFactory(GsonConverterFactory.create(g.hnadsa()));
        this.hnadsa = builder.build();
    }

    private OkHttpClient hnadsa(b bVar) {
        OkHttpClient.Builder builder = bVar.hnadsj;
        if (builder == null) {
            builder = new OkHttpClient.Builder();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            builder.connectTimeout(10L, timeUnit).readTimeout(10L, timeUnit).writeTimeout(10L, timeUnit).retryOnConnectionFailure(true);
        }
        List<Interceptor> list = this.hnadsc;
        if (list != null && !list.isEmpty()) {
            Iterator<Interceptor> it = this.hnadsc.iterator();
            while (it.hasNext()) {
                builder.addInterceptor(it.next());
            }
        }
        return builder.build();
    }

    private boolean hnadsc() {
        HttpLoggingInterceptor.Level level = this.hnadsf;
        return level != null && level == HttpLoggingInterceptor.Level.BODY;
    }

    public static class b {
        private Context hnadsa;
        private String hnadsb;
        private String hnadsc;
        private long hnadse;
        private List<Interceptor> hnadsf;
        private List<Converter.Factory> hnadsg;
        private List<CallAdapter.Factory> hnadsh;
        private OkHttpClient.Builder hnadsj;
        private HttpLoggingInterceptor.Level hnadsi = HttpLoggingInterceptor.Level.NONE;
        private int hnadsd = 0;

        public b(Context context) {
            this.hnadsa = context;
        }

        public b hnadsa(int i) {
            this.hnadsd = i;
            return this;
        }

        public b hnadsa(long j) {
            this.hnadse = j;
            return this;
        }

        public b hnadsa(String str) {
            this.hnadsb = str;
            return this;
        }

        public b hnadsa(OkHttpClient.Builder builder) {
            this.hnadsj = builder;
            return this;
        }

        public b hnadsa(HttpLoggingInterceptor.Level level) {
            this.hnadsi = level;
            return this;
        }

        public b hnadsb(String str) {
            this.hnadsc = str;
            return this;
        }

        public b hnadsa(Interceptor interceptor) {
            if (this.hnadsf == null) {
                this.hnadsf = new ArrayList();
            }
            this.hnadsf.add(interceptor);
            return this;
        }

        public b hnadsa(Converter.Factory factory) {
            if (this.hnadsg == null) {
                this.hnadsg = new ArrayList();
            }
            this.hnadsg.add(factory);
            return this;
        }

        public b hnadsa(CallAdapter.Factory factory) {
            if (this.hnadsh == null) {
                this.hnadsh = new ArrayList();
            }
            this.hnadsh.add(factory);
            return this;
        }

        public a hnadsa() {
            return new a(this, null);
        }
    }
}
