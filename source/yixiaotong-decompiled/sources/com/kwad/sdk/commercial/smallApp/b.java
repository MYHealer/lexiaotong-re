package com.kwad.sdk.commercial.smallApp;

import java.net.URL;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public String aJY;
    public String aKD;
    public String aKE;
    public String aKF;
    public String aKf;
    public int status;
    public String url;

    public final b dE(int i) {
        this.status = i;
        return this;
    }

    public final b dI(String str) {
        this.aKD = str;
        return this;
    }

    public final b dJ(String str) {
        this.aKE = str;
        return this;
    }

    public static b a(JumpFrom jumpFrom) {
        return new b(jumpFrom);
    }

    private b(JumpFrom jumpFrom) {
        if (jumpFrom != null) {
            this.aKF = jumpFrom.getValue();
        }
    }

    public final b dH(String str) {
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
