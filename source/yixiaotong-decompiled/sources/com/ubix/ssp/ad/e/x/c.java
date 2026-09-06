package com.ubix.ssp.ad.e.x;

import android.net.TrafficStats;
import android.text.TextUtils;
import android.util.Base64;
import com.loopj.android.http.AsyncHttpClient;
import com.ubix.ssp.ad.e.a0.u;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f8925a = 10000;

    private d a(HttpURLConnection httpURLConnection) {
        d dVar = new d();
        dVar.c = httpURLConnection.getResponseCode();
        dVar.d = httpURLConnection.getContentLength();
        dVar.f8926a = httpURLConnection.getInputStream();
        dVar.b = httpURLConnection.getErrorStream();
        String contentEncoding = httpURLConnection.getContentEncoding();
        dVar.g = contentEncoding;
        if (TextUtils.isEmpty(contentEncoding) || !dVar.g.toLowerCase().equals(AsyncHttpClient.ENCODING_GZIP)) {
            dVar.f = a(httpURLConnection.getInputStream());
        } else {
            GZIPInputStream gZIPInputStream = new GZIPInputStream(dVar.f8926a);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i = gZIPInputStream.read(bArr);
                if (i == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
            dVar.f = byteArrayOutputStream.toByteArray();
        }
        try {
            if (httpURLConnection.getInputStream() != null) {
                httpURLConnection.getInputStream().close();
            }
            if (httpURLConnection.getErrorStream() != null) {
                httpURLConnection.getErrorStream().close();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return dVar;
    }

    private d a(HttpURLConnection httpURLConnection, Exception exc) {
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        d dVar = new d();
        dVar.e = exc;
        return dVar;
    }

    public static HttpURLConnection a(String str) {
        return a(str, "GET", f8925a, null, true);
    }

    public static HttpURLConnection a(String str, String str2, int i, Map<String, String> map, boolean z) throws ProtocolException {
        URL url = new URL(str);
        try {
            if (TrafficStats.getThreadStatsTag() == -1) {
                TrafficStats.setThreadStatsTag(1);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (str.startsWith("https")) {
            try {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
                httpsURLConnection.setRequestProperty("User-Agent", com.ubix.ssp.ad.d.b.p);
                httpsURLConnection.setHostnameVerifier(new e());
                httpsURLConnection.setInstanceFollowRedirects(true);
                httpsURLConnection.setConnectTimeout(i);
                httpsURLConnection.setReadTimeout(i);
                httpsURLConnection.setRequestMethod(str2);
                if (str2 == "POST") {
                    httpsURLConnection.setDoOutput(true);
                    httpsURLConnection.setDoInput(true);
                    httpsURLConnection.setUseCaches(false);
                }
                if (map != null) {
                    for (String str3 : map.keySet()) {
                        httpsURLConnection.setRequestProperty(str3, map.get(str3));
                    }
                }
                return z ? (HttpsURLConnection) b(httpsURLConnection) : httpsURLConnection;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestProperty("User-Agent", com.ubix.ssp.ad.d.b.p);
        httpURLConnection.setConnectTimeout(i);
        httpURLConnection.setReadTimeout(i);
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setRequestMethod(str2);
        if (str2 == "POST") {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
        }
        if (map != null) {
            for (String str4 : map.keySet()) {
                httpURLConnection.setRequestProperty(str4, map.get(str4));
            }
        }
        return z ? b(httpURLConnection) : httpURLConnection;
    }

    public static HttpURLConnection a(String str, String str2, Map<String, String> map) {
        return a(str, str2, f8925a, map, true);
    }

    public static HttpURLConnection a(HttpURLConnection httpURLConnection, HashMap<String, String> map) {
        HttpURLConnection httpURLConnection2;
        Exception e;
        while (true) {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode < 300 || responseCode >= 400) {
                    return httpURLConnection;
                }
                httpURLConnection2 = (HttpURLConnection) new URL(httpURLConnection.getHeaderField("Location")).openConnection();
                if (map != null) {
                    try {
                        for (String str : map.keySet()) {
                            httpURLConnection2.setRequestProperty(str, map.get(str));
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                }
                httpURLConnection = httpURLConnection2;
            } catch (Exception e3) {
                httpURLConnection2 = httpURLConnection;
                e = e3;
            }
            e.printStackTrace();
            return httpURLConnection2;
        }
    }

    public static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int i = inputStream.read(bArr);
            if (-1 == i) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    public static HttpURLConnection b(String str, int i) {
        return a(str, "GET", i, null, true);
    }

    public static HttpURLConnection b(HttpURLConnection httpURLConnection) {
        return a(httpURLConnection, (HashMap<String, String>) null);
    }

    d a(String str, int i) {
        HttpURLConnection httpURLConnectionB = null;
        try {
            u.b("requestURL=" + str);
            httpURLConnectionB = b(str, i);
            return a(httpURLConnectionB);
        } catch (Exception e) {
            return a(httpURLConnectionB, e);
        }
    }

    d a(String str, Map<String, String> map) {
        HttpURLConnection httpURLConnectionA = null;
        try {
            u.b("requestURL=" + str);
            httpURLConnectionA = a(str, "GET", map);
            return a(httpURLConnectionA);
        } catch (Exception e) {
            return a(httpURLConnectionA, e);
        }
    }

    d a(String str, byte[] bArr, Map<String, String> map) {
        HttpURLConnection httpURLConnectionA = null;
        try {
            httpURLConnectionA = a(str, "POST", 10000, map, false);
            httpURLConnectionA.setRequestProperty("Content-Encoding", AsyncHttpClient.ENCODING_GZIP);
            httpURLConnectionA.setRequestProperty("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
            httpURLConnectionA.setRequestProperty("U-SEC-Encoding", "base64");
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(httpURLConnectionA.getOutputStream());
            try {
                gZIPOutputStream.write(Base64.encode(bArr, 0));
                gZIPOutputStream.flush();
                gZIPOutputStream.finish();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return a(httpURLConnectionA);
        } catch (Exception e) {
            e.printStackTrace();
            return a(httpURLConnectionA, e);
        }
    }
}
