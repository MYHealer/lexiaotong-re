package com.baidu.mobads.sdk.api;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public interface IPromoteInstallAdInfo {
    String getAppPublisher();

    String getAppVersion();

    String getBrandName();

    String getECPMLevel();

    String getFunctionUrl();

    String getIconUrl();

    String getPECPM();

    String getPermissionUrl();

    String getPrivacyUrl();

    String getUnionLogoUrl();

    void handleAdInstall();
}
