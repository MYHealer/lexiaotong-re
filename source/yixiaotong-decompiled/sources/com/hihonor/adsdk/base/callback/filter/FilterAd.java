package com.hihonor.adsdk.base.callback.filter;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class FilterAd {
    private String adId;
    private int code;
    private String packName;
    private int promotionPurpose;

    public FilterAd() {
    }

    public String getAdId() {
        return this.adId;
    }

    public int getCode() {
        return this.code;
    }

    public String getPackName() {
        return this.packName;
    }

    public int getPromotionPurpose() {
        return this.promotionPurpose;
    }

    public void setAdId(String str) {
        this.adId = str;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setPackName(String str) {
        this.packName = str;
    }

    public void setPromotionPurpose(int i) {
        this.promotionPurpose = i;
    }

    public FilterAd(int i, String str, String str2, int i2) {
        this.code = i;
        this.packName = str2;
        this.adId = str;
        this.promotionPurpose = i2;
    }
}
