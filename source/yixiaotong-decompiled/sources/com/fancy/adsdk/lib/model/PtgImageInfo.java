package com.fancy.adsdk.lib.model;

import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class PtgImageInfo implements Serializable {
    private int height;
    private String imageUrl;
    private String mimeType;
    private int width;

    public int getHeight() {
        return this.height;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public int getWidth() {
        return this.width;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setMimeType(String str) {
        this.mimeType = str;
    }

    public void setWidth(int i) {
        this.width = i;
    }
}
