package com.fancy.adsdk.lib.interf;

import com.fancy.adsdk.lib.model.AdLocation;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public abstract class PtgCustomController {
    public String getAliBoot() {
        return "";
    }

    public String getAliUpdate() {
        return "";
    }

    public String getMediaAndroidId() {
        return "";
    }

    public String getMediaDeviceImei() {
        return "";
    }

    public String getMediaDeviceOaId() {
        return "";
    }

    public List<String> getMediaInstalledPackages() {
        return null;
    }

    public AdLocation getMediaLocation() {
        return null;
    }

    public String getMediaMacAddress() {
        return "";
    }

    public boolean isAllowHardDiskSizeKBytes() {
        return true;
    }

    public boolean isAllowSDKInstallList() {
        return true;
    }

    public boolean isAllowSDKObtainAndroidId() {
        return true;
    }

    public boolean isAllowSDKObtainLocation() {
        return false;
    }

    @Deprecated
    public boolean isAllowSDKObtainNetworkState() {
        return true;
    }

    public boolean isAllowSDKObtainOaId() {
        return true;
    }

    @Deprecated
    public boolean isAllowSDKObtainStoragePermission() {
        return true;
    }

    public boolean isAllowSDKObtainWifiState() {
        return true;
    }

    public boolean isAllowSDKObtainWriteExternal() {
        return true;
    }

    public boolean isCanUseCarrier() {
        return true;
    }
}
