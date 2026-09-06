package com.opos.cmn.func.a.b;

import android.content.Context;
import android.net.SSLSessionCache;
import android.text.TextUtils;
import com.heytap.baselib.cloudctrl.database.AreaCode;
import com.heytap.common.LogLevel;
import com.heytap.common.iinterface.IAccountCallback;
import com.heytap.httpdns.env.ApiEnv;
import com.heytap.httpdns.env.HttpDnsConfig;
import com.heytap.nearx.okhttp.extension.HeyConfig;
import com.heytap.nearx.okhttp.extension.api.IPv6Config;
import com.heytap.nearx.okhttp3.Call;
import com.heytap.nearx.okhttp3.Callback;
import com.heytap.nearx.okhttp3.Headers;
import com.heytap.nearx.okhttp3.MediaType;
import com.heytap.nearx.okhttp3.OkHttpClient;
import com.heytap.nearx.okhttp3.Request;
import com.heytap.nearx.okhttp3.RequestBody;
import com.heytap.nearx.okhttp3.Response;
import com.heytap.nearx.taphttp.statitics.HttpStatConfig;
import com.heytap.nearx.taphttp.statitics.StatisticCallback;
import com.heytap.trace.AppTraceConfig;
import com.opos.cmn.func.a.a.a.g;
import com.stub.StubApp;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b implements com.opos.cmn.func.a.b.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static OkHttpClient f6084a;
    private volatile OkHttpClient b;
    private HashMap<Long, Call> c = new HashMap<>();
    private Object d = new Object();
    private Object e = new Object();

    class a implements Callback {
    }

    /* JADX INFO: renamed from: com.opos.cmn.func.a.b.b$b, reason: collision with other inner class name */
    static class C0888b implements StatisticCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.opos.cmn.func.a.a.a.e.a f6085a;

        C0888b(com.opos.cmn.func.a.a.a.e.a aVar) {
            this.f6085a = aVar;
        }
    }

    static class c implements IAccountCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.opos.cmn.func.a.a.a.c f6086a;

        c(com.opos.cmn.func.a.a.a.c cVar) {
            this.f6086a = cVar;
        }
    }

    static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6087a;

        static {
            int[] iArr = new int[com.opos.cmn.func.a.a.a.b.a.values().length];
            f6087a = iArr;
            try {
                iArr[com.opos.cmn.func.a.a.a.b.a.CN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6087a[com.opos.cmn.func.a.a.a.b.a.EU.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6087a[com.opos.cmn.func.a.a.a.b.a.SA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6087a[com.opos.cmn.func.a.a.a.b.a.SEA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private static class e<K, V> extends HashMap<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Headers f6088a;

        private e() {
        }

        /* synthetic */ e(a aVar) {
            this();
        }

        public void a(Headers headers) {
            this.f6088a = headers;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            if (obj == null) {
                return null;
            }
            String str = (String) obj;
            Headers headers = this.f6088a;
            if (headers == null) {
                return (V) super.get(obj);
            }
            V v = (V) headers.get(str);
            if (v != null) {
                return v;
            }
            return null;
        }
    }

    private static class f implements com.opos.cmn.func.a.a.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Headers f6089a;
        private Map<String, String> b;

        public f(Headers headers) {
            this.b = null;
            this.f6089a = headers;
            if (headers != null) {
                try {
                    this.b = new HashMap();
                    for (String str : this.f6089a.names()) {
                        if (str != null) {
                            this.b.put(str, this.f6089a.get(str));
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }

        @Override // com.opos.cmn.func.a.a.a
        public String a(String str) {
            Headers headers = this.f6089a;
            if (headers == null || str == null) {
                return null;
            }
            return headers.get(str);
        }
    }

    private static AreaCode a(com.opos.cmn.func.a.a.a.b.a aVar, Context context) {
        if (aVar == null) {
            aVar = com.opos.cmn.func.a.b.a.c.e(context);
        }
        int i = d.f6087a[aVar.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return AreaCode.EU;
            }
            if (i == 3) {
                return AreaCode.SA;
            }
            if (i == 4) {
                return AreaCode.SEA;
            }
        }
        return AreaCode.CN;
    }

    private static HttpDnsConfig a(com.opos.cmn.func.a.a.a.c cVar, Context context) {
        if (cVar == null) {
            return null;
        }
        String strD = cVar.b;
        String strC = cVar.c;
        if (TextUtils.isEmpty(strD)) {
            strD = com.opos.cmn.func.a.b.a.c.d(context);
        }
        if (TextUtils.isEmpty(strC)) {
            strC = com.opos.cmn.func.a.b.a.c.c(context);
        }
        HttpDnsConfig httpDnsConfig = new HttpDnsConfig(cVar.f6065a, strD, strC, cVar.d);
        List<String> list = cVar.e;
        if (list != null && !list.isEmpty()) {
            httpDnsConfig.setInnerWhiteList(cVar.e);
        }
        if (cVar.f != null) {
            httpDnsConfig.setSsoCallback(new c(cVar));
        }
        return httpDnsConfig;
    }

    public static HeyConfig.Builder a(com.opos.cmn.func.a.a.a.d dVar, Context context) {
        IPv6Config iPv6ConfigA;
        AppTraceConfig appTraceConfigA;
        com.opos.cmn.func.a.a.a.e.a aVar;
        HttpDnsConfig httpDnsConfigA;
        if (dVar == null) {
            dVar = new com.opos.cmn.func.a.a.a.d.a().a();
        }
        HeyConfig.Builder builder = new HeyConfig.Builder();
        try {
            builder.allUseGlsbKey(true);
        } catch (Throwable unused) {
        }
        builder.defaultUserAgent(com.opos.cmn.func.a.b.a.f.a());
        ApiEnv apiEnvB = b();
        com.opos.cmn.an.f.a.a("HttpTapExternalHttpImpl", "config set ApiEnv " + apiEnvB);
        builder.setEnv(apiEnvB);
        com.opos.cmn.func.a.a.a.c cVar = dVar.b;
        if (cVar != null && (httpDnsConfigA = a(cVar, context)) != null) {
            builder.useHttpDns(httpDnsConfigA);
        }
        builder.setLogLevel(dVar.f ? LogLevel.LEVEL_NONE : LogLevel.LEVEL_VERBOSE);
        com.opos.cmn.func.a.a.a.e eVar = dVar.e;
        if (eVar != null && (aVar = eVar.f6069a) != null) {
            builder.useHttpStat(new HttpStatConfig(true, new C0888b(aVar), dVar.e.b));
        }
        com.opos.cmn.func.a.a.a.b bVar = dVar.f6067a;
        if (bVar != null) {
            if (!bVar.f6062a) {
                return builder;
            }
            builder.setCloudConfig(dVar.f6067a.b, a(bVar.c, context));
        }
        com.opos.cmn.func.a.a.a.a aVar2 = dVar.c;
        if (aVar2 != null && (appTraceConfigA = a(aVar2)) != null) {
            builder.useAppTrace(appTraceConfigA);
        }
        com.opos.cmn.func.a.a.a.f fVar = dVar.d;
        if (fVar != null && (iPv6ConfigA = a(fVar)) != null) {
            builder.useIPv6Switch(iPv6ConfigA);
        }
        try {
            builder.setSSLSessionCache(new SSLSessionCache(context.getDir("ads_ssl_session", 0)));
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("HttpTapExternalHttpImpl", "", e2);
        }
        return builder;
    }

    private static IPv6Config a(com.opos.cmn.func.a.a.a.f fVar) {
        if (fVar == null) {
            return null;
        }
        return new IPv6Config(fVar.f6070a, fVar.b, fVar.c, fVar.d);
    }

    private Call a(long j) {
        try {
            synchronized (this.d) {
                Call call = this.c.get(Long.valueOf(j));
                if (call == null) {
                    return null;
                }
                this.c.remove(Long.valueOf(j));
                return call;
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("HttpTapExternalHttpImpl", "removeRequestFromMap fail", e2);
            return null;
        }
    }

    private static OkHttpClient.Builder a() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(30000L, TimeUnit.MILLISECONDS);
        builder.connectTimeout(30000L, TimeUnit.MILLISECONDS);
        return builder;
    }

    private static OkHttpClient.Builder a(Context context, OkHttpClient.Builder builder, g gVar) {
        com.opos.cmn.an.f.a.a("HttpTapExternalHttpImpl", "setOkHttpClientParams initParameter:" + gVar);
        if (gVar != null) {
            SSLSocketFactory sSLSocketFactory = gVar.c;
            if (sSLSocketFactory != null) {
                X509TrustManager x509TrustManager = gVar.e;
                if (x509TrustManager != null) {
                    builder.sslSocketFactory(sSLSocketFactory, x509TrustManager);
                } else {
                    builder.sslSocketFactory(sSLSocketFactory);
                }
            }
            HostnameVerifier hostnameVerifier = gVar.d;
            if (hostnameVerifier != null) {
                builder.hostnameVerifier(hostnameVerifier);
            }
            builder.readTimeout(gVar.b, TimeUnit.MILLISECONDS).connectTimeout(gVar.f6072a, TimeUnit.MILLISECONDS);
            HeyConfig.Builder builderA = a(gVar.f, context);
            if (builderA != null) {
                builder.config(builderA.build(context));
            }
        }
        return builder;
    }

    private static AppTraceConfig a(com.opos.cmn.func.a.a.a.a aVar) {
        if (aVar == null) {
            return null;
        }
        return new AppTraceConfig(aVar.f6060a, aVar.b);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0039  */
    private com.opos.cmn.func.a.a.e a(Response response) {
        long j;
        if (response == null) {
            return null;
        }
        int iCode = response.code();
        String strMessage = response.message();
        InputStream inputStreamByteStream = response.body() != null ? response.body().byteStream() : null;
        Headers headersBuild = response.headers().newBuilder().build();
        if (headersBuild != null) {
            String str = headersBuild.get("Content-Length");
            if (TextUtils.isEmpty(str)) {
                j = -1;
            } else {
                try {
                    j = Long.parseLong(str);
                } catch (Exception unused) {
                    j = -1;
                }
            }
        } else {
            j = -1;
        }
        return new com.opos.cmn.func.a.a.e.a().a(iCode).a(strMessage).a(j).a(a(headersBuild)).a(new f(headersBuild)).a(inputStreamByteStream).a();
    }

    private Map<String, String> a(Headers headers) {
        a aVar = null;
        if (headers == null) {
            return null;
        }
        try {
            e eVar = new e(aVar);
            eVar.a(headers);
            for (String str : headers.names()) {
                if (str != null) {
                    eVar.put(str, headers.get(str));
                }
            }
            return eVar;
        } catch (Exception unused) {
            return null;
        }
    }

    private void a(long j, Call call) {
        if (call != null) {
            synchronized (this.d) {
                this.c.put(Long.valueOf(j), call);
            }
        }
    }

    private void a(Context context, g gVar) {
        if (this.b == null) {
            synchronized (this.e) {
                if (this.b == null) {
                    Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    this.b = b(origApplicationContext, gVar);
                    com.opos.cmn.an.f.a.a("HttpTapExternalHttpImpl", "getOkHttpClient cost time:" + (System.currentTimeMillis() - jCurrentTimeMillis));
                }
            }
        }
    }

    private static ApiEnv b() {
        return com.opos.cmn.func.a.b.a.a.a() ? ApiEnv.TEST : ApiEnv.RELEASE;
    }

    private static OkHttpClient b(Context context) {
        OkHttpClient okHttpClient;
        OkHttpClient okHttpClient2 = f6084a;
        if (okHttpClient2 != null) {
            return okHttpClient2;
        }
        synchronized (b.class) {
            if (f6084a == null) {
                try {
                    g gVarB = com.opos.cmn.func.a.b.a.c.b(context);
                    OkHttpClient.Builder builderA = a();
                    a(context, builderA, gVarB);
                    f6084a = builderA.build();
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.c("HttpTapExternalHttpImpl", "init fail", e2);
                }
                okHttpClient = f6084a;
            } else {
                okHttpClient = f6084a;
            }
            throw th;
        }
        return okHttpClient;
    }

    private static OkHttpClient b(Context context, g gVar) {
        try {
            OkHttpClient okHttpClientB = b(context);
            if (gVar == null) {
                return okHttpClientB;
            }
            if (okHttpClientB == null) {
                return null;
            }
            OkHttpClient.Builder builderNewBuilder = okHttpClientB.newBuilder();
            a(context, builderNewBuilder, gVar);
            return builderNewBuilder.build();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("HttpTapExternalHttpImpl", "getOkHttpClient", e2);
            return null;
        }
    }

    private Request b(Context context, com.opos.cmn.func.a.a.d dVar) {
        Request.Builder builderUrl;
        if (dVar == null) {
            return null;
        }
        com.opos.cmn.func.a.a.d dVarA = com.opos.cmn.func.a.b.a.c.a(context, dVar);
        Request.Builder builder = new Request.Builder();
        Map<String, String> map = dVarA.c;
        if (map != null) {
            for (String str : map.keySet()) {
                builder.addHeader(str, dVarA.c.get(str));
            }
        }
        String str2 = dVarA.f6075a;
        if (str2 == "GET") {
            builderUrl = builder.url(dVarA.b).get();
        } else {
            if (str2 == "POST") {
                byte[] bArr = dVarA.d;
                builder.post(bArr != null ? RequestBody.create((MediaType) null, bArr) : RequestBody.create((MediaType) null, new byte[0]));
            }
            builderUrl = builder.url(dVarA.b);
        }
        return builderUrl.build();
    }

    @Override // com.opos.cmn.func.a.b.e
    public com.opos.cmn.func.a.a.e a(Context context, com.opos.cmn.func.a.a.d dVar) {
        Request requestB;
        if (dVar == null || context == null) {
            return null;
        }
        try {
            try {
                Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                a(origApplicationContext, (g) null);
                com.opos.cmn.an.f.a.a("HttpTapExternalHttpImpl", dVar.toString());
                if (this.b != null && (requestB = b(origApplicationContext, dVar)) != null) {
                    Call callNewCall = this.b.newCall(requestB);
                    a(dVar.e, callNewCall);
                    com.opos.cmn.func.a.a.e eVarA = a(callNewCall.execute());
                    com.opos.cmn.an.f.a.a("HttpTapExternalHttpImpl", "onResponse," + (eVarA == null ? "null" : eVarA.toString()));
                    return eVarA;
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("HttpTapExternalHttpImpl", "execSync fail", e2);
            }
            return null;
        } finally {
            a(dVar.e);
        }
    }

    @Override // com.opos.cmn.func.a.b.d
    public void a(Context context) {
        a(context, (g) null);
    }
}
