package com.hihonor.adsdk.common.video;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class AdVideoSize {
    private int height;
    private int width;

    public interface a {
        public static final int hnadsa = 1;
        public static final int hnadsb = 2;
    }

    public AdVideoSize() {
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public AdVideoSize(int i, int i2) {
        this.width = i;
        this.height = i2;
    }
}
