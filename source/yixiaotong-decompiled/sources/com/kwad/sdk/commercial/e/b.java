package com.kwad.sdk.commercial.e;

import java.net.URL;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public String aJY;
    public String aKf;
    public int status;
    public String url;

    public final b dB(int i) {
        this.status = i;
        return this;
    }

    public static b It() {
        return new b();
    }

    public final b dA(String str) {
        this.url = str;
        try {
            URL url = new URL(str);
            this.aJY = url.getHost();
            this.aKf = url.getPath();
        } catch (Throwable unused) {
        }
        return this;
    }
}
