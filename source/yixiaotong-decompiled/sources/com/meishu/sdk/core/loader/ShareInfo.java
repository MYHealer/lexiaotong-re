package com.meishu.sdk.core.loader;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class ShareInfo {
    private String currentUrl;
    private String shareInfo;

    public ShareInfo(String str, String str2) {
        this.shareInfo = str;
        this.currentUrl = str2;
    }

    public String getCurrentUrl() {
        return this.currentUrl;
    }

    public String getShareInfo() {
        return this.shareInfo;
    }

    public void setCurrentUrl(String str) {
        this.currentUrl = str;
    }

    public void setShareInfo(String str) {
        this.shareInfo = str;
    }

    public String toString() {
        return com.meishu.sdk.activity.a.a("ShareInfo{shareInfo='").append(this.shareInfo).append('\'').append(", currentUrl='").append(this.currentUrl).append('\'').append('}').toString();
    }
}
