package com.hihonor.adsdk.base.net.request;

import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class AdUnit {
    private int adType;
    private String adUnitId;
    private List<String> excludeIds;
    private int height;
    private List<String> industryIds;
    private int renderMode;
    private int width;

    public int getAdType() {
        return this.adType;
    }

    public String getAdUnitId() {
        return this.adUnitId;
    }

    public List<String> getExcludeIds() {
        return this.excludeIds;
    }

    public int getHeight() {
        return this.height;
    }

    public List<String> getIndustryIds() {
        return this.industryIds;
    }

    public int getRenderMode() {
        return this.renderMode;
    }

    public int getWidth() {
        return this.width;
    }

    public void setAdType(int i) {
        this.adType = i;
    }

    public void setAdUnitId(String str) {
        this.adUnitId = str;
    }

    public void setExcludeIds(List<String> list) {
        this.excludeIds = list;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setIndustryIds(List<String> list) {
        this.industryIds = list;
    }

    public void setRenderMode(int i) {
        this.renderMode = i;
    }

    public void setWidth(int i) {
        this.width = i;
    }
}
