package com.unionpay.a;

import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.unionpay.utils.j;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f9306a = null;
    private InputStream b = null;
    private d c;
    private String d;

    public c(d dVar, String str) {
        this.c = dVar;
        this.d = str;
    }

    public final int a() {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        j.a("uppay", "HttpConn.connect() +++");
        d dVar = this.c;
        int i = 1;
        try {
            try {
                if (dVar == null) {
                    j.c("uppay", "params==null!!!");
                    return 1;
                }
                try {
                    try {
                        try {
                            URL urlA = dVar.a();
                            if ("https".equals(urlA.getProtocol().toLowerCase())) {
                                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) urlA.openConnection();
                                httpsURLConnection.setSSLSocketFactory(new a(this.d).a().getSocketFactory());
                                httpURLConnection = httpsURLConnection;
                            } else {
                                httpURLConnection = (HttpURLConnection) urlA.openConnection();
                            }
                            httpURLConnection.setRequestMethod(this.c.b());
                            httpURLConnection.setReadTimeout(60000);
                            httpURLConnection.setConnectTimeout(KSImageLoader.InnerImageLoadingListener.MAX_DURATION);
                            httpURLConnection.setInstanceFollowRedirects(true);
                            httpURLConnection.setUseCaches(false);
                            HashMap mapD = this.c.d();
                            if (mapD != null) {
                                for (String str : mapD.keySet()) {
                                    httpURLConnection.setRequestProperty(str, (String) mapD.get(str));
                                }
                            }
                            String strB = this.c.b();
                            int iHashCode = strB.hashCode();
                            if (iHashCode == 70454) {
                                strB.equals("GET");
                            } else if (iHashCode == 2461856 && strB.equals("POST")) {
                                httpURLConnection.setDoOutput(true);
                                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8");
                                outputStreamWriter.write(this.c.c());
                                outputStreamWriter.flush();
                                outputStreamWriter.close();
                            }
                            httpURLConnection.connect();
                            if (httpURLConnection.getResponseCode() == 200) {
                                InputStream inputStream2 = httpURLConnection.getInputStream();
                                this.b = inputStream2;
                                if (inputStream2 != null) {
                                    this.f9306a = com.unionpay.utils.b.a(inputStream2, "UTF-8");
                                    i = 0;
                                }
                            } else if (httpURLConnection.getResponseCode() == 401) {
                                i = 8;
                            } else {
                                j.c("uppay", "http status code:" + httpURLConnection.getResponseCode());
                            }
                            inputStream = this.b;
                            if (inputStream != null) {
                                inputStream.close();
                            }
                        } catch (IllegalStateException e) {
                            e.printStackTrace();
                            inputStream = this.b;
                            if (inputStream != null) {
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        inputStream = this.b;
                        if (inputStream != null) {
                        }
                    }
                } catch (SSLHandshakeException e3) {
                    e3.printStackTrace();
                    try {
                        InputStream inputStream3 = this.b;
                        if (inputStream3 != null) {
                            inputStream3.close();
                        }
                    } catch (Exception unused) {
                    }
                    i = 4;
                } catch (IOException e4) {
                    e4.printStackTrace();
                    inputStream = this.b;
                    if (inputStream != null) {
                    }
                }
            } catch (Exception unused2) {
            }
            j.a("uppay", "HttpConn.connect() ---");
            return i;
        } catch (Throwable th) {
            try {
                InputStream inputStream4 = this.b;
                if (inputStream4 != null) {
                    inputStream4.close();
                }
            } catch (Exception unused3) {
            }
            throw th;
        }
    }

    public final String b() {
        return this.f9306a;
    }
}
