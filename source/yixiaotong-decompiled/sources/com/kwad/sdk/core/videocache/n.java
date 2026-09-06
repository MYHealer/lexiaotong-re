package com.kwad.sdk.core.videocache;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class n {
    public final long baB;
    public final String baC;
    public final String url;

    public n(String str, long j, String str2) {
        this.url = str;
        this.baB = j;
        this.baC = str2;
    }

    public final String toString() {
        return "SourceInfo{url='" + this.url + "', length=" + this.baB + ", mime='" + this.baC + "'}";
    }
}
