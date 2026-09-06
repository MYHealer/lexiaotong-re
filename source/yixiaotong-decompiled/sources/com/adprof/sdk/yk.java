package com.adprof.sdk;

import android.text.TextUtils;
import com.loopj.android.http.AsyncHttpClient;
import com.masget.base.AppConfig;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class yk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f1540a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public uk f877a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f878a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public byte[] f881a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f883b;
    public String c;
    public String b = "POST";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map f879a = new LinkedHashMap();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Map f882b = new LinkedHashMap();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f880a = true;
    public String d = "";

    public yk(String str) {
        this.f878a = str;
    }

    public static final boolean a(String str, SSLSession sSLSession) {
        return true;
    }

    public final String a() {
        if (Intrinsics.areEqual(this.b, "POST") || Intrinsics.areEqual(this.b, "PUT")) {
            return this.f878a;
        }
        if (this.f879a.isEmpty()) {
            return this.f878a;
        }
        return this.f878a + '?' + a(this.f879a);
    }

    public final String a(Map map) {
        if (map.isEmpty()) {
            return "";
        }
        if (Intrinsics.areEqual(this.d, AppConfig.FORMAT)) {
            return new JSONObject(map).toString();
        }
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            arrayList.add(URLEncoder.encode((String) entry.getKey(), "UTF-8") + '=' + URLEncoder.encode((String) entry.getValue(), "UTF-8"));
        }
        return CollectionsKt.joinToString$default(arrayList, "&", null, null, 0, null, null, 62, null);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final HttpURLConnection m732a() throws NoSuchAlgorithmException, IOException, KeyManagementException {
        URL url = new URL(a());
        boolean zAreEqual = Intrinsics.areEqual(url.getProtocol(), "https");
        URLConnection uRLConnectionOpenConnection = url.openConnection();
        if (!zAreEqual) {
            Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            return (HttpURLConnection) uRLConnectionOpenConnection;
        }
        Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) uRLConnectionOpenConnection;
        if (!this.f880a) {
            return httpsURLConnection;
        }
        a(httpsURLConnection);
        return httpsURLConnection;
    }

    public final void a(final uk ukVar) {
        this.f877a = ukVar;
        Runnable runnable = new Runnable() { // from class: com.adprof.sdk.yk$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                yk.a(this.f$0, ukVar);
            }
        };
        ra raVar = fn.f297a;
        try {
            t3.a(runnable);
            gn.f1196a.submit(runnable);
        } catch (Throwable th) {
            pk.a(th);
            oh.b(th);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final void m733a(HttpURLConnection httpURLConnection) {
        String strA;
        Closeable closeable;
        if (Intrinsics.areEqual(this.b, "POST") || Intrinsics.areEqual(this.b, "PUT")) {
            byte[] bytes = this.f881a;
            if (bytes != null) {
                Intrinsics.checkNotNull(bytes);
            } else {
                if (TextUtils.isEmpty(this.c)) {
                    strA = a(this.f879a);
                } else {
                    strA = this.c;
                    Intrinsics.checkNotNull(strA);
                }
                bytes = strA.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            }
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                if (this.f883b) {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                    try {
                        gZIPOutputStream.write(bytes);
                        gZIPOutputStream.flush();
                        Unit unit = Unit.INSTANCE;
                        closeable = gZIPOutputStream;
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(gZIPOutputStream, th);
                            throw th2;
                        }
                    }
                } else {
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
                    try {
                        bufferedOutputStream.write(bytes);
                        bufferedOutputStream.flush();
                        Unit unit2 = Unit.INSTANCE;
                        closeable = bufferedOutputStream;
                    } catch (Throwable th3) {
                        try {
                            throw th3;
                        } catch (Throwable th4) {
                            CloseableKt.closeFinally(bufferedOutputStream, th3);
                            throw th4;
                        }
                    }
                }
                CloseableKt.closeFinally(closeable, null);
                Unit unit3 = Unit.INSTANCE;
                CloseableKt.closeFinally(outputStream, null);
            } catch (Throwable th5) {
                try {
                    throw th5;
                } catch (Throwable th6) {
                    CloseableKt.closeFinally(outputStream, th5);
                    throw th6;
                }
            }
        }
    }

    public final void a(HttpsURLConnection httpsURLConnection) throws NoSuchAlgorithmException, KeyManagementException {
        TrustManager[] trustManagerArr = {new xk()};
        SSLContext sSLContext = SSLContext.getInstance("SSL");
        sSLContext.init(null, trustManagerArr, new SecureRandom());
        httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
        httpsURLConnection.setHostnameVerifier(new HostnameVerifier() { // from class: com.adprof.sdk.yk$$ExternalSyntheticLambda0
            @Override // javax.net.ssl.HostnameVerifier
            public final boolean verify(String str, SSLSession sSLSession) {
                return yk.a(str, sSLSession);
            }
        });
    }

    public final void b(HttpURLConnection httpURLConnection) throws ProtocolException {
        int i = y6.a().c;
        if (i <= 0) {
            i = 10000;
        }
        if (pk.f594a) {
            pk.c("timeoutMs === " + i);
        }
        httpURLConnection.setRequestMethod(this.b);
        httpURLConnection.setConnectTimeout(i);
        httpURLConnection.setReadTimeout(i);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true ^ Intrinsics.areEqual(this.b, "GET"));
        for (Map.Entry entry : this.f882b.entrySet()) {
            httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
    }

    public static final void a(yk ykVar, uk ukVar) {
        try {
            ykVar.f1540a = System.currentTimeMillis();
            if (pk.f594a) {
                pk.a("HttpRequest", "-->" + ykVar.b + " url=" + ykVar.a());
            }
            HttpURLConnection httpURLConnectionM732a = ykVar.m732a();
            ykVar.b(httpURLConnectionM732a);
            ykVar.m733a(httpURLConnectionM732a);
            fn.a(new vk(ukVar, ykVar.a(httpURLConnectionM732a)));
        } catch (Throwable th) {
            ykVar.a(th);
            fn.a(new wk(ukVar, new al(0, null, null, th, null, false, 54)));
        }
    }

    public al a(HttpURLConnection httpURLConnection) {
        al alVar;
        InputStream errorStream;
        boolean z;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            int responseCode = httpURLConnection.getResponseCode();
            if (200 > responseCode || responseCode >= 300) {
                errorStream = httpURLConnection.getErrorStream();
                z = true;
            } else {
                errorStream = httpURLConnection.getInputStream();
                z = false;
            }
            try {
                long contentLengthLong = httpURLConnection.getContentLengthLong();
                uk ukVar = this.f877a;
                if (ukVar != null) {
                    ukVar.a(httpURLConnection.getResponseCode(), contentLengthLong);
                }
                String contentEncoding = httpURLConnection.getContentEncoding();
                if (contentEncoding == null) {
                    contentEncoding = "";
                }
                InputStream gZIPInputStream = (!Intrinsics.areEqual(AsyncHttpClient.ENCODING_GZIP, contentEncoding) || z) ? errorStream : new GZIPInputStream(errorStream);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = gZIPInputStream.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                    try {
                        a(th);
                        alVar = new al(httpURLConnection.getResponseCode(), null, null, th, null, false, 54);
                        return alVar;
                    } finally {
                        httpURLConnection.disconnect();
                    }
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                String str = new String(byteArray, Charsets.UTF_8);
                if (pk.f594a) {
                    pk.a("HttpRequest", "<-- " + httpURLConnection.getResponseCode() + ' ' + a() + " (" + (jCurrentTimeMillis - this.f1540a) + "ms)");
                    pk.a("HttpRequest", str);
                    pk.a("HttpRequest", "<-- END HTTP (" + byteArray.length + "-byte body)");
                }
                alVar = new al(httpURLConnection.getResponseCode(), str, byteArray, null, null, TextUtils.equals(httpURLConnection.getHeaderField("X-Ads-Enc"), "1"), 24);
                CloseableKt.closeFinally(errorStream, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(errorStream, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            a(th3);
            alVar = new al(httpURLConnection.getResponseCode(), null, null, th3, null, false, 54);
        }
        return alVar;
    }

    public final void a(Throwable th) {
        if (pk.f594a) {
            pk.a("HttpRequest", "<-- 请求失败 " + a() + " (" + (System.currentTimeMillis() - this.f1540a) + "ms)");
            pk.a("HttpRequest", ExceptionsKt.stackTraceToString(th));
            pk.a("HttpRequest", "<-- END HTTP (0-byte body)");
        }
    }
}
