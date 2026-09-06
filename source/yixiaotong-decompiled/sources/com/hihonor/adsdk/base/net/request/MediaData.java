package com.hihonor.adsdk.base.net.request;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class MediaData {
    private String allianceChannelInfo;
    private String appVersion;
    private String mediaId;
    private String mediaPackage;
    private String sdkVersion;
    private int wechatOpenSdkVersion;
    private int wechatVersion;

    public String getAllianceChannelInfo() {
        return this.allianceChannelInfo;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getMediaId() {
        return this.mediaId;
    }

    public String getMediaPackage() {
        return this.mediaPackage;
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public int getWechatOpenSdkVersion() {
        return this.wechatOpenSdkVersion;
    }

    public int getWechatVersion() {
        return this.wechatVersion;
    }

    public void setAllianceChannelInfo(String str) {
        this.allianceChannelInfo = str;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public void setMediaId(String str) {
        this.mediaId = str;
    }

    public void setMediaPackage(String str) {
        this.mediaPackage = str;
    }

    public void setSdkVersion(String str) {
        this.sdkVersion = str;
    }

    public void setWechatOpenSdkVersion(int i) {
        this.wechatOpenSdkVersion = i;
    }

    public void setWechatVersion(int i) {
        this.wechatVersion = i;
    }
}
