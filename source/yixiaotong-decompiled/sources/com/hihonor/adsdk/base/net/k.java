package com.hihonor.adsdk.base.net;

import android.text.TextUtils;
import okhttp3.logging.HttpLoggingInterceptor;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class k implements HttpLoggingInterceptor.Logger {
    private static final String hnadsb = "XHttp";
    private final StringBuffer hnadsa = new StringBuffer();

    @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
    public void log(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.startsWith("--> POST") || str.startsWith("--> GET")) {
            this.hnadsa.append("<<<<<<<<<< Http log start >>>>>>>>>>");
            this.hnadsa.append(System.lineSeparator());
            this.hnadsa.append("=============================================================");
            this.hnadsa.append(System.lineSeparator());
        }
        if ((str.startsWith("{") && str.endsWith(com.alipay.sdk.util.i.d)) || (str.startsWith("[") && str.endsWith("]"))) {
            str = h.hnadsb(str);
        }
        this.hnadsa.append(str.concat(System.lineSeparator()));
        if (str.startsWith("--> END POST") || str.startsWith("--> END GET")) {
            this.hnadsa.append(" ┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄");
            this.hnadsa.append(System.lineSeparator());
        }
        if (str.startsWith("<-- END HTTP") || str.startsWith("<-- HTTP FAILED")) {
            this.hnadsa.append("=============================================================");
            com.hihonor.adsdk.common.b.b.hnadsa(hnadsb, (Object) this.hnadsa.toString());
            this.hnadsa.setLength(0);
        }
    }
}
