package com.fancy.adsdk.lib.model;

import com.fancy._ie;
import com.fancy._j;
import com.fancy._pd;
import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class AppInfo implements Serializable {
    public String appVersion;
    public String developers;
    public String functionDescUrl;
    private String icon_url;
    private String name;
    private String package_name;
    public String permissionProtocolUrl;
    public String privacyProtocolUrl;
    private _pd wechatExt;

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getDevelopers() {
        return this.developers;
    }

    public String getFunctionDescUrl() {
        return this.functionDescUrl;
    }

    public String getIcon_url() {
        return this.icon_url;
    }

    public String getName() {
        return this.name;
    }

    public String getPackage_name() {
        return this.package_name;
    }

    public String getPermissionProtocolUrl() {
        return this.permissionProtocolUrl;
    }

    public String getPrivacyProtocolUrl() {
        return this.privacyProtocolUrl;
    }

    public _pd getWechatExt() {
        return this.wechatExt;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public void setDevelopers(String str) {
        this.developers = str;
    }

    public void setFunctionDescUrl(String str) {
        this.functionDescUrl = str;
    }

    public void setIcon_url(String str) {
        this.icon_url = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPackage_name(String str) {
        this.package_name = str;
    }

    public void setPermissionProtocolUrl(String str) {
        this.permissionProtocolUrl = str;
    }

    public void setPrivacyProtocolUrl(String str) {
        this.privacyProtocolUrl = str;
    }

    public void setWechatExt(_pd _pdVar) {
        this.wechatExt = _pdVar;
    }

    public String toString() {
        return _j._a(_j._a(_j._a(_j._a(_j._a(_j._a(_j._a(_ie._a("AppInfo{icon_url='"), this.icon_url, '\'', ", name='"), this.name, '\'', ", package_name='"), this.package_name, '\'', ", appVersion='"), this.appVersion, '\'', ", developers='"), this.developers, '\'', ", privacyProtocolUrl='"), this.privacyProtocolUrl, '\'', ", permissionProtocolUrl='"), this.permissionProtocolUrl, '\'', ", functionDescUrl='").append(this.functionDescUrl).append('\'').append('}').toString();
    }
}
