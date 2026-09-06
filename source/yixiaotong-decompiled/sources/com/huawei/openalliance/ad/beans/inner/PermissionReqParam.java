package com.huawei.openalliance.ad.beans.inner;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class PermissionReqParam {
    private String appCountry;
    private String appLanguage;
    private String packageName;

    public PermissionReqParam() {
    }

    public PermissionReqParam(String str, String str2, String str3) {
        this.packageName = str;
        this.appLanguage = str2;
        this.appCountry = str3;
    }

    public String Code() {
        return this.packageName;
    }

    public void Code(String str) {
        this.packageName = str;
    }

    public String I() {
        return this.appCountry;
    }

    public void I(String str) {
        this.appCountry = str;
    }

    public String V() {
        return this.appLanguage;
    }

    public void V(String str) {
        this.appLanguage = str;
    }
}
