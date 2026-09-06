package com.jd.ad.sdk.jad_zm;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_iv extends jad_an {
    public static String[] jad_cp = new String[0];
    public HttpsURLConnection jad_bo;

    @Override // com.jd.ad.sdk.jad_zm.jad_an
    public void jad_an() throws IOException {
        HttpsURLConnection httpsURLConnection = this.jad_bo;
        if (httpsURLConnection != null) {
            InputStream inputStream = httpsURLConnection.getInputStream();
            if (inputStream != null) {
                inputStream.close();
            }
            this.jad_bo.disconnect();
        }
    }

    @Override // com.jd.ad.sdk.jad_zm.jad_an
    public int jad_bo() {
        return this.jad_bo.getResponseCode();
    }

    @Override // com.jd.ad.sdk.jad_zm.jad_an
    public URLConnection jad_an(jad_ly jad_lyVar) {
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(jad_lyVar.jad_er).openConnection();
        this.jad_bo = httpsURLConnection;
        httpsURLConnection.setConnectTimeout(jad_lyVar.jad_cp);
        this.jad_bo.setReadTimeout(jad_lyVar.jad_dq);
        this.jad_bo.setInstanceFollowRedirects(jad_lyVar.jad_jt);
        int i = jad_lyVar.jad_an;
        this.jad_bo.setRequestMethod(jad_kx.jad_an(i));
        this.jad_bo.setDoInput(true);
        this.jad_bo.setDoOutput(com.jd.ad.sdk.jad_jt.jad_fs.jad_an(i, 2));
        this.jad_bo.setUseCaches(false);
        jad_fs jad_fsVar = jad_lyVar.jad_bo;
        if (jad_fsVar != null) {
            List<String> list = jad_fsVar.jad_an.get("Connection");
            if (list != null && !list.isEmpty()) {
                jad_fsVar.jad_bo("Connection", list.get(0));
            }
            for (Map.Entry entry : ((LinkedHashMap) jad_fs.jad_an(jad_fsVar)).entrySet()) {
                this.jad_bo.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
        this.jad_bo.setSSLSocketFactory(new jad_na(com.jd.ad.sdk.jad_fq.jad_cp.jad_an()));
        this.jad_bo.setHostnameVerifier(new jad_hu());
        this.jad_bo.connect();
        return this.jad_bo;
    }
}
