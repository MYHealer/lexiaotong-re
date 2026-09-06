package com.hihonor.adsdk.base.init;

import android.location.Location;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class HnCustomController {
    public boolean alist() {
        return true;
    }

    public String getDevImei() {
        return null;
    }

    public String getDevOaid() {
        return null;
    }

    public Location getLocation() {
        return null;
    }

    public boolean isCanGetAllPackages() {
        return false;
    }

    public boolean isCanUseAndroidId() {
        return true;
    }

    public boolean isCanUseLocation() {
        return false;
    }

    public boolean isCanUsePhoneState() {
        return true;
    }

    public boolean isCanUseWifiState() {
        return true;
    }

    public boolean isCanUseWriteExternal() {
        return true;
    }

    public boolean isCanUseWriteLogToDisk() {
        return false;
    }

    public boolean isRecordTrackReq() {
        return false;
    }
}
