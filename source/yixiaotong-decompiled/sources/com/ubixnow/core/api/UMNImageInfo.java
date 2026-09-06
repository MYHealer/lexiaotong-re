package com.ubixnow.core.api;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UMNImageInfo {
    public int height;
    public String url;
    public int width;

    public UMNImageInfo() {
    }

    public UMNImageInfo(String str) {
        this.url = str;
    }

    public UMNImageInfo(String str, int i, int i2) {
        this.url = str;
        this.width = i;
        this.height = i2;
    }
}
