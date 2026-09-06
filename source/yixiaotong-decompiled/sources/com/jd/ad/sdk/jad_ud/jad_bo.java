package com.jd.ad.sdk.jad_ud;

import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_bo {
    public jad_an jad_an(String str) {
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
        httpsURLConnection.setRequestMethod("GET");
        httpsURLConnection.connect();
        return new jad_an(httpsURLConnection);
    }
}
