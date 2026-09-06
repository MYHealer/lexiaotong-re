package com.adprof.sdk.api;

import android.location.Location;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class CustomController {
    public boolean canReadDiskSpace() {
        return true;
    }

    public boolean canReadLocation() {
        return true;
    }

    public boolean canUseAndroidId() {
        return true;
    }

    public boolean canUseCarrier() {
        return true;
    }

    public boolean canUseImei() {
        return true;
    }

    public boolean canUseMac() {
        return true;
    }

    public boolean canUsePhoneState() {
        return true;
    }

    public boolean canUseSensor() {
        return true;
    }

    public boolean canUseWifiState() {
        return true;
    }

    public String getAndroidId() {
        return "";
    }

    public long getDiskTotalBytes() {
        return 0L;
    }

    public String getImei() {
        return "";
    }

    public Location getLocation() {
        return null;
    }

    public String getMacAddress() {
        return "";
    }

    public String getOaid() {
        return "";
    }
}
