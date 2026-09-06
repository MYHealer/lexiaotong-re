package com.yfanads.android.model;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class AdInfo {
    private String adOwner;
    private String adRequestId;
    private String adTitle;

    public AdInfo(String str, String str2, String str3) {
        this.adTitle = str;
        this.adOwner = str2;
        this.adRequestId = str3;
    }

    public String getAdOwner() {
        return this.adOwner;
    }

    public String getAdRequestId() {
        return this.adRequestId;
    }

    public String getAdTitle() {
        return this.adTitle;
    }

    public void setAdOwner(String str) {
        this.adOwner = str;
    }

    public void setAdRequestId(String str) {
        this.adRequestId = str;
    }

    public void setAdTitle(String str) {
        this.adTitle = str;
    }

    public String toString() {
        return "|t_" + this.adTitle + "|n_" + this.adOwner + "|r_" + this.adRequestId;
    }
}
