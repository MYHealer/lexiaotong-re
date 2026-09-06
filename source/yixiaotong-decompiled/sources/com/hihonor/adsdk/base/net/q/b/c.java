package com.hihonor.adsdk.base.net.q.b;

import android.content.Context;
import okhttp3.logging.HttpLoggingInterceptor;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c {
    private String hnadsa = "";
    private String hnadsb;
    private long hnadsc;
    private HttpLoggingInterceptor.Level hnadsd;
    private Context hnadse;

    public String hnadsa() {
        return this.hnadsa;
    }

    public void hnadsa(long j) {
        this.hnadsc = j;
    }

    public void hnadsa(Context context) {
        this.hnadse = context;
    }

    public void hnadsa(HttpLoggingInterceptor.Level level) {
        this.hnadsd = level;
    }

    public Context hnadsb() {
        return this.hnadse;
    }

    public void hnadsb(String str) {
        this.hnadsb = str;
    }

    public HttpLoggingInterceptor.Level hnadsc() {
        return this.hnadsd;
    }

    public long hnadsd() {
        return this.hnadsc;
    }

    public String hnadse() {
        return this.hnadsb;
    }

    public void hnadsa(String str) {
        if (this.hnadsa.equalsIgnoreCase(str)) {
            return;
        }
        this.hnadsa = str;
    }
}
