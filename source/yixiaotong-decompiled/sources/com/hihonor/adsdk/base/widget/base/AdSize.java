package com.hihonor.adsdk.base.widget.base;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class AdSize {
    public static final int AUTO_HEIGHT = -2;
    public static final int FULL_WIDTH = -1;
    protected final int mHeight;
    protected final int mWidth;

    public AdSize(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }
}
