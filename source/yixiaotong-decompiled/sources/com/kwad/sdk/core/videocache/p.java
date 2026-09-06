package com.kwad.sdk.core.videocache;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class p implements m {
    protected volatile String baC;
    protected volatile int length = Integer.MIN_VALUE;
    protected String url;

    public abstract String Pf();

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "UrlSource{url='" + this.url + "', length=" + this.length + ", mime='" + this.baC + "'}";
    }
}
