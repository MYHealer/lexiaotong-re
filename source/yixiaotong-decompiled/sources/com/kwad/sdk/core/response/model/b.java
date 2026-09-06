package com.kwad.sdk.core.response.model;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class b {
    private boolean aXL;
    private boolean anr = true;
    private int mHeight;
    private String mUrl;
    private int mWidth;

    public final int getHeight() {
        return this.mHeight;
    }

    public final String getUrl() {
        return this.mUrl;
    }

    public final int getWidth() {
        return this.mWidth;
    }

    public b(String str, int i, int i2, boolean z, boolean z2) {
        this.mUrl = str;
        this.mWidth = i;
        this.mHeight = i2;
        this.aXL = z2;
    }
}
