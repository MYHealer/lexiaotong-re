package com.yfanads.android.adx.newplayer.videocache;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class SourceInfo {
    public final long length;
    public final String mime;
    public final String url;

    public SourceInfo(String str, long j, String str2) {
        this.url = str;
        this.length = j;
        this.mime = str2;
    }

    public String toString() {
        return "SourceInfo{url='" + this.url + "', length=" + this.length + ", mime='" + this.mime + "'}";
    }
}
