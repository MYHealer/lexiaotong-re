package com.adprof.sdk.api;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AFImage {
    public int height;
    public String imageUrl;
    public int width;

    public AFImage(String str, int i, int i2) {
        this.imageUrl = str;
        this.width = i;
        this.height = i2;
    }

    public int getHeight() {
        return this.height;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public int getWidth() {
        return this.width;
    }

    public String toString() {
        return "AFImage{imageUrl='" + this.imageUrl + "', width=" + this.width + ", height=" + this.height + '}';
    }
}
