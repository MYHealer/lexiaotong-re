package com.adprof.sdk;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class na extends t5 {
    public na(ma maVar, SSLSocketFactory sSLSocketFactory) {
    }

    public static InputStream a(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    public static List a(Map map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getKey() != null) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    arrayList.add(new w9((String) entry.getKey(), (String) it.next()));
                }
            }
        }
        return arrayList;
    }

    @Override // com.adprof.sdk.t5
    public ia a(li liVar, Map map) throws Throwable {
        String strM674a = liVar.m674a();
        HashMap map2 = new HashMap();
        map2.putAll(map);
        map2.putAll(liVar.mo610a());
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(strM674a).openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        q7 q7Var = liVar.f445a;
        int i = q7Var.c;
        httpURLConnection.setConnectTimeout(q7Var.b);
        httpURLConnection.setReadTimeout(i);
        boolean z = false;
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        try {
            for (String str : map2.keySet()) {
                httpURLConnection.setRequestProperty(str, (String) map2.get(str));
            }
            a(httpURLConnection, liVar);
            int responseCode = httpURLConnection.getResponseCode();
            String responseMessage = httpURLConnection.getResponseMessage();
            if (responseCode == -1) {
                throw new IOException("Could not retrieve response code from HttpUrlConnection.  responseMsg = " + responseMessage + "   responseCode = " + responseCode);
            }
            if (liVar.f1289a == 4 || ((100 <= responseCode && responseCode < 200) || responseCode == 204 || responseCode == 304)) {
                ia iaVar = new ia(responseCode, a(httpURLConnection.getHeaderFields()), -1, null);
                httpURLConnection.disconnect();
                return iaVar;
            }
            try {
                return new ia(responseCode, a(httpURLConnection.getHeaderFields()), httpURLConnection.getContentLength(), new la(httpURLConnection));
            } catch (Throwable th) {
                th = th;
                z = true;
                if (!z) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void a(HttpURLConnection httpURLConnection, li liVar) throws w3, IOException {
        String str;
        switch (liVar.f1289a) {
            case -1:
                return;
            case 0:
                str = "GET";
                break;
            case 1:
                str = "POST";
                break;
            case 2:
                str = "PUT";
                break;
            case 3:
                str = "DELETE";
                break;
            case 4:
                str = "HEAD";
                break;
            case 5:
                str = "OPTIONS";
                break;
            case 6:
                str = "TRACE";
                break;
            case 7:
                str = "PATCH";
                break;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
        httpURLConnection.setRequestMethod(str);
    }
}
