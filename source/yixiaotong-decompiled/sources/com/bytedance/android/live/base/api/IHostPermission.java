package com.bytedance.android.live.base.api;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface IHostPermission {
    boolean alist();

    String getAndroidID();

    String getDevImei();

    String getDevOaid();

    String getMacAddress();

    LocationProvider getTTLocation();

    boolean isCanGetAndUseAndroidID();

    boolean isCanUseLocation();

    boolean isCanUsePhoneState();

    boolean isCanUseWifiState();

    boolean isCanUseWriteExternal();
}
