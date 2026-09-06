package com.jd.android.sdk.coreinfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ScreenSize {
    public int heightPixels;
    public int widthPixels;

    public ScreenSize(int i, int i2) {
        this.widthPixels = i;
        this.heightPixels = i2;
    }

    public String toString() {
        return this.widthPixels + "," + this.heightPixels;
    }
}
