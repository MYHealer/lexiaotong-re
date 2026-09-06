package com.huawei.openalliance.ad.constant;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public enum cf {
    HTTP("http://"),
    HTTPS("https://"),
    FILE("file://"),
    CONTENT("content://"),
    ASSET("asset://"),
    RES("res://");

    String S;

    cf(String str) {
        this.S = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.S;
    }
}
