package com.yfanads.android.model;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class InitBean {
    public String addKey;
    public String appId;
    public String appSecret;
    public String appToken;
    public String wxAppId;

    public InitBean() {
    }

    public String toString() {
        return "InitBean{appId='" + this.appId + "', addKey='" + this.addKey + "', wxAppId='" + this.wxAppId + "', appSecret='" + this.appSecret + "'}";
    }

    public InitBean(String str, String str2, String str3, String str4, String str5) {
        this.appId = str;
        this.addKey = str2;
        this.wxAppId = str3;
        this.appSecret = str4;
        this.appToken = str5;
    }
}
