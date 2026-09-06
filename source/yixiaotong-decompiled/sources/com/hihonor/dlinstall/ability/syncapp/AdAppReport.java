package com.hihonor.dlinstall.ability.syncapp;

import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class AdAppReport implements Serializable {
    private String adId;
    private String adRequestId;
    private String adType;
    private String adUnitId;
    private String channelInfo;
    private String extraJson;
    private String mediaId;
    private String mediaRequestId;

    public String getAdId() {
        return this.adId;
    }

    public String getAdRequestId() {
        return this.adRequestId;
    }

    public String getAdType() {
        return this.adType;
    }

    public String getAdUnitId() {
        return this.adUnitId;
    }

    public String getChannelInfo() {
        return this.channelInfo;
    }

    public String getExtraJson() {
        return this.extraJson;
    }

    public String getMediaId() {
        return this.mediaId;
    }

    public String getMediaRequestId() {
        return this.mediaRequestId;
    }

    public void setAdId(String str) {
        this.adId = str;
    }

    public void setAdRequestId(String str) {
        this.adRequestId = str;
    }

    public void setAdType(String str) {
        this.adType = str;
    }

    public void setAdUnitId(String str) {
        this.adUnitId = str;
    }

    public void setChannelInfo(String str) {
        this.channelInfo = str;
    }

    public void setExtraJson(String str) {
        this.extraJson = str;
    }

    public void setMediaId(String str) {
        this.mediaId = str;
    }

    public void setMediaRequestId(String str) {
        this.mediaRequestId = str;
    }

    public String toString() {
        return "AdAppReport{adId='" + this.adId + "', mediaId='" + this.mediaId + "', adUnitId='" + this.adUnitId + "', adType='" + this.adType + "', adRequestId='" + this.adRequestId + "', mediaRequestId='" + this.mediaRequestId + "', channelInfo='" + this.channelInfo + "', extraJson='" + this.extraJson + "'}";
    }
}
