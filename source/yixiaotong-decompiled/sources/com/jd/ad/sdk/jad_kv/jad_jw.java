package com.jd.ad.sdk.jad_kv;

import android.text.TextUtils;
import android.util.Log;
import com.jd.ad.sdk.logger.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_jw implements jad_dq<InputStream> {
    public static final jad_bo jad_fs = new jad_an();
    public final com.jd.ad.sdk.jad_qb.jad_jt jad_an;
    public final int jad_bo;
    public HttpURLConnection jad_cp;
    public InputStream jad_dq;
    public volatile boolean jad_er;

    public static class jad_an implements jad_bo {
    }

    public interface jad_bo {
    }

    public jad_jw(com.jd.ad.sdk.jad_qb.jad_jt jad_jtVar, int i, jad_bo jad_boVar) {
        this.jad_an = jad_jtVar;
        this.jad_bo = i;
    }

    public static int jad_an(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseCode();
        } catch (IOException e) {
            if (!Log.isLoggable("HttpUrlFetcher", 3)) {
                return -1;
            }
            Logger.d("HttpUrlFetcher", "Failed to get a response code", e);
            return -1;
        }
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_dq
    public Class<InputStream> jad_an() {
        return InputStream.class;
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_dq
    public void jad_an(com.jd.ad.sdk.jad_gr.jad_jt jad_jtVar, jad_dq.jad_an<? super InputStream> jad_anVar) {
        long jJad_an = com.jd.ad.sdk.jad_ir.jad_jt.jad_an();
        try {
            jad_anVar.jad_an(jad_an(this.jad_an.jad_bo(), 0, null, this.jad_an.jad_bo.jad_an()));
        } catch (IOException e) {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Logger.d("HttpUrlFetcher", "Failed to load data for url", e);
            }
            jad_anVar.jad_an((Exception) e);
        } finally {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                Logger.v("HttpUrlFetcher", com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Finished http url fetcher fetch in ").append(com.jd.ad.sdk.jad_ir.jad_jt.jad_an(jJad_an)).toString());
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_dq
    public void jad_bo() {
        InputStream inputStream = this.jad_dq;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.jad_cp;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.jad_cp = null;
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_dq
    public void jad_cp() {
        this.jad_er = true;
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_dq
    public com.jd.ad.sdk.jad_ju.jad_an jad_dq() {
        return com.jd.ad.sdk.jad_ju.jad_an.REMOTE;
    }

    public final InputStream jad_an(URL url, int i, URL url2, Map<String, String> map) throws com.jd.ad.sdk.jad_ju.jad_er {
        InputStream inputStream;
        if (i < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new com.jd.ad.sdk.jad_ju.jad_er("In re-direct loop", -1, null);
                    }
                } catch (URISyntaxException unused) {
                }
            }
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
                }
                httpURLConnection.setConnectTimeout(this.jad_bo);
                httpURLConnection.setReadTimeout(this.jad_bo);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setInstanceFollowRedirects(false);
                this.jad_cp = httpURLConnection;
                try {
                    httpURLConnection.connect();
                    this.jad_dq = this.jad_cp.getInputStream();
                    if (this.jad_er) {
                        return null;
                    }
                    int iJad_an = jad_an(this.jad_cp);
                    int i2 = iJad_an / 100;
                    if (i2 == 2) {
                        HttpURLConnection httpURLConnection2 = this.jad_cp;
                        try {
                            if (TextUtils.isEmpty(httpURLConnection2.getContentEncoding())) {
                                inputStream = new com.jd.ad.sdk.jad_ir.jad_cp(httpURLConnection2.getInputStream(), httpURLConnection2.getContentLength());
                            } else {
                                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                                    Logger.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection2.getContentEncoding());
                                }
                                inputStream = httpURLConnection2.getInputStream();
                            }
                            this.jad_dq = inputStream;
                            return inputStream;
                        } catch (IOException e) {
                            throw new com.jd.ad.sdk.jad_ju.jad_er("Failed to obtain InputStream", jad_an(httpURLConnection2), e);
                        }
                    }
                    if (i2 != 3) {
                        if (iJad_an == -1) {
                            throw new com.jd.ad.sdk.jad_ju.jad_er("Http request failed", iJad_an, null);
                        }
                        try {
                            throw new com.jd.ad.sdk.jad_ju.jad_er(this.jad_cp.getResponseMessage(), iJad_an, null);
                        } catch (IOException e2) {
                            throw new com.jd.ad.sdk.jad_ju.jad_er("Failed to get a response message", iJad_an, e2);
                        }
                    }
                    String headerField = this.jad_cp.getHeaderField("Location");
                    if (TextUtils.isEmpty(headerField)) {
                        throw new com.jd.ad.sdk.jad_ju.jad_er("Received empty or null redirect url", iJad_an, null);
                    }
                    try {
                        URL url3 = new URL(url, headerField);
                        jad_bo();
                        return jad_an(url3, i + 1, url, map);
                    } catch (MalformedURLException e3) {
                        throw new com.jd.ad.sdk.jad_ju.jad_er("Bad redirect url: " + headerField, iJad_an, e3);
                    }
                } catch (IOException e4) {
                    throw new com.jd.ad.sdk.jad_ju.jad_er("Failed to connect or obtain data", jad_an(this.jad_cp), e4);
                }
            } catch (IOException e5) {
                throw new com.jd.ad.sdk.jad_ju.jad_er("URL.openConnection threw", 0, e5);
            }
        }
        throw new com.jd.ad.sdk.jad_ju.jad_er("Too many (> 5) redirects!", -1, null);
    }
}
