package com.miui.zeus.utils.network;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public enum AdNetType {
    NETWORK_WIFI(1),
    NETWORK_2G(2),
    NETWORK_3G(4),
    NETWORK_4G(8),
    NETWORK_MOBILE(-2),
    NETWORK_ALL(-1);

    private int mValue;

    AdNetType(int i) {
        this.mValue = i;
    }

    public static boolean is2GAllowed(int i) {
        return (i & NETWORK_2G.value()) != 0;
    }

    public static boolean is3GAllowed(int i) {
        return (i & NETWORK_3G.value()) != 0;
    }

    public static boolean is4GAllowed(int i) {
        return (i & NETWORK_4G.value()) != 0;
    }

    public static boolean isMobileAllowed(int i) {
        return (i & NETWORK_MOBILE.value()) != 0;
    }

    public static boolean isWifiAllowed(int i) {
        return (i & NETWORK_WIFI.value()) != 0;
    }

    public static AdNetType valueOf(int i) {
        AdNetType[] adNetTypeArrValues = values();
        for (int i2 = 0; i2 < 6; i2++) {
            AdNetType adNetType = adNetTypeArrValues[i2];
            if (i == adNetType.mValue) {
                return adNetType;
            }
        }
        return NETWORK_ALL;
    }

    public int value() {
        return this.mValue;
    }
}
