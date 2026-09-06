package com.hihonor.adsdk.base.net.request;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class TrackAdReqBase<T> {
    private T data;
    private String mediaId;
    private String requestId;
    private String scene;
    private String sdkVersion;

    public T getData() {
        return this.data;
    }

    public String getMediaId() {
        return this.mediaId;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public String getScene() {
        return this.scene;
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public void setData(T t) {
        this.data = t;
    }

    public void setMediaId(String str) {
        this.mediaId = str;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public void setScene(String str) {
        this.scene = str;
    }

    public void setSdkVersion(String str) {
        this.sdkVersion = str;
    }
}
