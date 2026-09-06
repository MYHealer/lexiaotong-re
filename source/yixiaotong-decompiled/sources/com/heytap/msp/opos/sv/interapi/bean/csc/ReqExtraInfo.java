package com.heytap.msp.opos.sv.interapi.bean.csc;

import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class ReqExtraInfo implements Serializable {
    private static final long serialVersionUID = 2780095893812869123L;
    private String appVersion;
    private Map<String, String> others;
    private String pkgName;
    private String sdkVersion;

    public String getAppVersion() {
        return this.appVersion;
    }

    public Map<String, String> getOthers() {
        return this.others;
    }

    public String getPkgName() {
        return this.pkgName;
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public void setOthers(Map<String, String> map) {
        this.others = map;
    }

    public void setPkgName(String str) {
        this.pkgName = str;
    }

    public void setSdkVersion(String str) {
        this.sdkVersion = str;
    }

    public String toString() {
        return "ReqExtraInfo{pkgName='" + this.pkgName + "', appVersion='" + this.appVersion + "', sdkVersion='" + this.sdkVersion + "', others=" + this.others + '}';
    }
}
