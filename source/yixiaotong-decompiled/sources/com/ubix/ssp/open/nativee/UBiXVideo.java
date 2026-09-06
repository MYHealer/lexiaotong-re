package com.ubix.ssp.open.nativee;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UBiXVideo {
    private int height;
    private int width;
    private String coverUrl = "";
    private String videoUrl = "";
    private String materialId = "";
    private long duration = 0;

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public long getDuration() {
        return this.duration;
    }

    public int getHeight() {
        return this.height;
    }

    public String getMaterialId() {
        return this.materialId;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public int getWidth() {
        return this.width;
    }

    public void setCoverUrl(String str) {
        this.coverUrl = str;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setMaterialId(String str) {
        this.materialId = str;
    }

    public void setVideoUrl(String str) {
        this.videoUrl = str;
    }

    public void setWidth(int i) {
        this.width = i;
    }
}
