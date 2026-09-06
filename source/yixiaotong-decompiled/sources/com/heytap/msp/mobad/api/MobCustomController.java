package com.heytap.msp.mobad.api;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class MobCustomController {

    public interface LocationProvider {
        double getLatitude();

        double getLongitude();
    }

    public boolean alist() {
        return true;
    }

    public String getAndroidId() {
        return null;
    }

    public String getDevImei() {
        return null;
    }

    public LocationProvider getLocation() {
        return null;
    }

    public String getMacAddress() {
        return null;
    }

    public int getMinorsMode() {
        return 0;
    }

    public int getMinorsModeAgeRange() {
        return 0;
    }

    public int getMinorsModeEnable() {
        return 0;
    }

    public boolean isCanUseAndroidId() {
        return true;
    }

    public boolean isCanUseLocation() {
        return true;
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
}
