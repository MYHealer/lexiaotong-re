package com.hihonor.dlinstall.clone;

import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class AppInfo implements Serializable {
    private static final long serialVersionUID = 1;
    private String appName;
    private String appSize;
    private String companyName;
    private String iconUrl;
    private String pkgName;
    private int versionCode;
    private String versionName;

    public AppInfo(String str, String str2, String str3, String str4, int i, String str5, String str6) {
        this.pkgName = str;
        this.appName = str2;
        this.iconUrl = str3;
        this.appSize = str4;
        this.versionCode = i;
        this.versionName = str5;
        this.companyName = str6;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getAppSize() {
        return this.appSize;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getPkgName() {
        return this.pkgName;
    }

    public int getVersionCode() {
        return this.versionCode;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setAppSize(String str) {
        this.appSize = str;
    }

    public void setCompanyName(String str) {
        this.companyName = str;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setPkgName(String str) {
        this.pkgName = str;
    }

    public void setVersionCode(int i) {
        this.versionCode = i;
    }

    public void setVersionName(String str) {
        this.versionName = str;
    }

    public String toString() {
        return "package name: " + this.pkgName + ", app name:" + this.appName + ", icon Url:" + this.iconUrl + ", app size:" + this.appSize + ", versionCode:" + this.versionCode + ", versionName:" + this.versionName + ", companyName:" + this.companyName;
    }
}
