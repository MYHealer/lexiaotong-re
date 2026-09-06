package com.kwad.sdk.core.network.a;

import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.huawei.openalliance.ad.utils.bg;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.export.proxy.AdHttpBodyBuilder;
import com.kwad.sdk.export.proxy.AdHttpFormDataBuilder;
import com.kwad.sdk.export.proxy.AdHttpResponseHelper;
import com.kwad.sdk.export.proxy.AdHttpResponseListener;
import com.kwad.sdk.utils.by;
import com.loopj.android.http.AsyncHttpClient;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import okhttp3.ConnectionSpec;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class c {
    private static final Pattern aUb = Pattern.compile("Unexpected response code for CONNECT: ([0-9]+)", 2);
    public static String aUc = "UTF-8";
    private static OkHttpClient aUd = null;
    public static OkHttpClient aUe = Mn();

    public static OkHttpClient Mm() {
        if (!com.kwad.framework.a.a.pe.booleanValue()) {
            return aUe;
        }
        if (aUd == null) {
            aUd = aUe.newBuilder().build();
        }
        return aUd;
    }

    private static OkHttpClient Mn() {
        if (aUe == null) {
            OkHttpClient.Builder builderConnectionSpecs = new OkHttpClient.Builder().connectTimeout(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS, TimeUnit.MILLISECONDS).readTimeout(6000L, TimeUnit.MILLISECONDS).connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT));
            try {
                builderConnectionSpecs.dns(new d());
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTrace(th);
            }
            aUe = builderConnectionSpecs.build();
        }
        return aUe;
    }

    public static com.kwad.sdk.core.network.c doGet(String str, Map<String, String> map) {
        return a(str, map, true, true);
    }

    public static com.kwad.sdk.core.network.c a(String str, Map<String, String> map, boolean z, boolean z2) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        try {
            Request.Builder builderUrl = new Request.Builder().url(str);
            if (z2) {
                a(builderUrl);
            }
            a(builderUrl, map);
            Response responseExecute = Mm().newCall(builderUrl.build()).execute();
            cVar.code = responseExecute.code();
            cVar.aSW = cVar.code;
            cVar.aSY = z ? a(responseExecute) : "";
        } catch (Exception e) {
            a(cVar, e);
        }
        return cVar;
    }

    private static void a(Request.Builder builder) {
        builder.addHeader("User-Agent", p.getUserAgent());
        builder.addHeader("BrowserUa", p.Mi());
        builder.addHeader("SystemUa", p.Mh());
    }

    public static com.kwad.sdk.core.network.c doPost(String str, Map<String, String> map, JSONObject jSONObject) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        try {
            Request.Builder builderUrl = new Request.Builder().url(str);
            a(builderUrl);
            a(builderUrl, map);
            a(builderUrl, jSONObject);
            Response responseExecute = Mm().newCall(builderUrl.build()).execute();
            cVar.code = responseExecute.code();
            cVar.aSW = cVar.code;
            cVar.aSY = a(responseExecute);
        } catch (Exception e) {
            a(cVar, e);
        }
        return cVar;
    }

    public static com.kwad.sdk.core.network.c doPost(String str, Map<String, String> map, Map<String, String> map2) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        try {
            Request.Builder builderUrl = new Request.Builder().url(str);
            a(builderUrl);
            a(builderUrl, map);
            b(builderUrl, map2);
            Response responseExecute = Mm().newCall(builderUrl.build()).execute();
            cVar.code = responseExecute.code();
            cVar.aSW = cVar.code;
            cVar.aSY = a(responseExecute);
        } catch (Exception e) {
            a(cVar, e);
        }
        return cVar;
    }

    public static com.kwad.sdk.core.network.c doPost(String str, Map<String, String> map, AdHttpBodyBuilder adHttpBodyBuilder) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        try {
            final MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
            if (adHttpBodyBuilder != null) {
                adHttpBodyBuilder.buildFormData(new AdHttpFormDataBuilder() { // from class: com.kwad.sdk.core.network.a.c.1
                    @Override // com.kwad.sdk.export.proxy.AdHttpFormDataBuilder
                    public final void addFormDataPart(String str2, String str3) {
                        type.addFormDataPart(str2, str3);
                    }

                    @Override // com.kwad.sdk.export.proxy.AdHttpFormDataBuilder
                    public final void addFormDataPart(String str2, String str3, String str4, byte[] bArr) {
                        type.addFormDataPart(str2, str3, RequestBody.create(MediaType.parse(str4), bArr));
                    }
                });
            }
            Request.Builder builderPost = new Request.Builder().url(str).post(type.build());
            a(builderPost, map);
            Response responseExecute = Mm().newCall(builderPost.build()).execute();
            cVar.code = responseExecute.code();
            cVar.aSW = cVar.code;
            cVar.aSY = a(responseExecute);
        } catch (Exception e) {
            a(cVar, e);
        }
        return cVar;
    }

    public static boolean downloadUrlToStream(String str, OutputStream outputStream, long j, boolean z, AdHttpResponseListener adHttpResponseListener) throws Throwable {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        Request.Builder builderUrl = new Request.Builder().url(str);
        HashMap map = new HashMap();
        map.put("Accept-Language", bg.Code);
        if (z) {
            map.put("Connection", "keep-alive");
        } else {
            map.put("Connection", "close");
        }
        map.put("Charset", "UTF-8");
        a(builderUrl);
        a(builderUrl, map);
        Response responseExecute = Mm().newCall(builderUrl.build()).execute();
        cVar.code = responseExecute.code();
        cVar.aSW = cVar.code;
        if (responseExecute.code() != 200) {
            throw new FileNotFoundException(str);
        }
        a(responseExecute, outputStream, j, adHttpResponseListener);
        return true;
    }

    private static void a(com.kwad.sdk.core.network.c cVar, Exception exc) {
        String message;
        cVar.aSX = exc;
        if (cVar.aSW == -1 && (exc instanceof IOException) && (message = exc.getMessage()) != null) {
            Matcher matcher = aUb.matcher(message);
            if (matcher.find()) {
                try {
                    cVar.aSW = Integer.parseInt(matcher.group(1));
                } catch (Exception unused) {
                }
            }
        }
        if (exc instanceof SocketTimeoutException) {
            cVar.code = e.aSZ.errorCode;
            cVar.aSY = e.aSZ.msg;
        } else {
            cVar.code = e.aTa.errorCode;
            cVar.aSY = e.aTa.msg + "/" + by.y(exc);
        }
        if (com.kwad.framework.a.a.pe.booleanValue()) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(exc);
        }
    }

    private static void a(Request.Builder builder, Map<String, String> map) {
        if (builder == null || map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null) {
                try {
                    builder.removeHeader(entry.getKey());
                    builder.addHeader(entry.getKey(), entry.getValue());
                } catch (Exception unused) {
                }
            }
        }
    }

    private static void a(Request.Builder builder, JSONObject jSONObject) {
        builder.post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jSONObject.toString()));
    }

    private static void b(Request.Builder builder, Map<String, String> map) {
        FormBody formBodyBuild;
        if (map == null || map.isEmpty()) {
            formBodyBuild = null;
        } else {
            FormBody.Builder builder2 = new FormBody.Builder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null) {
                    try {
                        builder2.addEncoded(entry.getKey(), encode(entry.getValue()));
                    } catch (Exception unused) {
                    }
                }
            }
            formBodyBuild = builder2.build();
        }
        if (builder == null || formBodyBuild == null) {
            return;
        }
        builder.post(formBodyBuild);
    }

    private static String encode(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            return "";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.Closeable, java.io.InputStreamReader, java.io.Reader] */
    private static String a(Response response) throws Throwable {
        InputStream inputStreamByteStream;
        InputStream inputStream;
        ?? inputStreamReader;
        InputStream gZIPInputStream;
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            inputStreamByteStream = response.body().byteStream();
            try {
                List<String> listHeaders = response.headers("Content-Encoding");
                if (listHeaders == null) {
                    inputStream = null;
                    gZIPInputStream = inputStreamByteStream;
                    break;
                }
                Iterator<String> it = listHeaders.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        inputStream = null;
                        gZIPInputStream = inputStreamByteStream;
                        break;
                    }
                    if (AsyncHttpClient.ENCODING_GZIP.equalsIgnoreCase(it.next())) {
                        gZIPInputStream = new GZIPInputStream(inputStreamByteStream);
                        inputStream = gZIPInputStream;
                        break;
                    }
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                    com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) inputStreamReader);
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamByteStream);
                    throw th;
                }
                try {
                    inputStreamReader = new InputStreamReader(gZIPInputStream, aUc);
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader, 8);
                        while (true) {
                            try {
                                String line = bufferedReader2.readLine();
                                if (line != null) {
                                    sb.append(line);
                                } else {
                                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                                    com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) inputStreamReader);
                                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamByteStream);
                                    return sb.toString();
                                }
                            } catch (Throwable th) {
                                bufferedReader = bufferedReader2;
                                th = th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStreamReader = 0;
                }
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
                inputStreamReader = inputStream;
            }
        } catch (Throwable th5) {
            th = th5;
            inputStreamByteStream = null;
            inputStream = null;
        }
    }

    private static boolean a(Response response, OutputStream outputStream, long j, AdHttpResponseListener adHttpResponseListener) throws Throwable {
        Throwable th;
        Closeable closeable;
        InputStream inputStreamByteStream;
        InputStream inputStream;
        InputStream gZIPInputStream;
        BufferedInputStream bufferedInputStream = null;
        bufferedOutputStream = null;
        bufferedOutputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        bufferedInputStream = null;
        bufferedInputStream = null;
        try {
            AdHttpResponseHelper.notifyResponseStart(adHttpResponseListener);
            inputStreamByteStream = response.body().byteStream();
            try {
                List<String> listHeaders = response.headers("Content-Encoding");
                long jB = b(response);
                if (listHeaders == null) {
                    inputStream = null;
                    gZIPInputStream = inputStreamByteStream;
                    break;
                }
                Iterator<String> it = listHeaders.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        inputStream = null;
                        gZIPInputStream = inputStreamByteStream;
                        break;
                    }
                    if (AsyncHttpClient.ENCODING_GZIP.equalsIgnoreCase(it.next())) {
                        gZIPInputStream = new GZIPInputStream(inputStreamByteStream);
                        inputStream = gZIPInputStream;
                        break;
                    }
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                    com.kwad.sdk.crash.utils.b.closeQuietly(closeable);
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamByteStream);
                    throw th;
                }
                try {
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(gZIPInputStream);
                    try {
                        byte[] bArr = new byte[1024];
                        long j2 = 0;
                        if (j > 0) {
                            do {
                                int i = bufferedInputStream2.read(bArr);
                                if (i == -1) {
                                    break;
                                }
                                j2 += (long) i;
                                AdHttpResponseHelper.notifyResponseProgress(adHttpResponseListener, j2, jB);
                            } while (j2 <= j);
                        } else if (j < 0) {
                            bufferedOutputStream = outputStream != null ? new BufferedOutputStream(outputStream) : null;
                            do {
                                int i2 = bufferedInputStream2.read(bArr);
                                if (i2 == -1) {
                                    break;
                                }
                                if (bufferedOutputStream != null) {
                                    bufferedOutputStream.write(bArr, 0, i2);
                                }
                                j2 += (long) i2;
                            } while (!AdHttpResponseHelper.notifyResponseProgress(adHttpResponseListener, j2, jB));
                            if (bufferedOutputStream != null) {
                                bufferedOutputStream.flush();
                            }
                        }
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream2);
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedOutputStream);
                        com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                        com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamByteStream);
                        return true;
                    } catch (Throwable th2) {
                        th = th2;
                        closeable = null;
                        bufferedInputStream = bufferedInputStream2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    closeable = null;
                }
            } catch (Throwable th4) {
                th = th4;
                closeable = null;
                inputStream = null;
            }
        } catch (Throwable th5) {
            th = th5;
            closeable = null;
            inputStreamByteStream = null;
            inputStream = null;
        }
    }

    private static long b(Response response) {
        try {
            return Long.parseLong(response.header("content-length"));
        } catch (Throwable unused) {
            return -1L;
        }
    }
}
