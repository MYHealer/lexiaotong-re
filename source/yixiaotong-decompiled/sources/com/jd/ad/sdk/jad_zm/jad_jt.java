package com.jd.ad.sdk.jad_zm;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_jt extends jad_an {
    public HttpURLConnection jad_bo;

    @Override // com.jd.ad.sdk.jad_zm.jad_an
    public void jad_an() throws IOException {
        HttpURLConnection httpURLConnection = this.jad_bo;
        if (httpURLConnection != null) {
            InputStream inputStream = httpURLConnection.getInputStream();
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
    public URLConnection jad_an(jad_ly jad_lyVar) throws ProtocolException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(jad_lyVar.jad_er).openConnection();
        this.jad_bo = httpURLConnection;
        httpURLConnection.setConnectTimeout(jad_lyVar.jad_cp);
        this.jad_bo.setReadTimeout(jad_lyVar.jad_dq);
        this.jad_bo.setInstanceFollowRedirects(jad_lyVar.jad_jt);
        int i = jad_lyVar.jad_an;
        this.jad_bo.setRequestMethod(jad_kx.jad_an(i));
        this.jad_bo.setDoInput(true);
        this.jad_bo.setDoOutput(com.jd.ad.sdk.jad_jt.jad_fs.jad_an(i, 2));
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
        this.jad_bo.connect();
        return this.jad_bo;
    }
}
