package com.adprof.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public enum f8 {
    UNKNOWN(0),
    ETHERNET(-1),
    WIFI(1),
    MOBILE(6),
    MOBILE_2G(2),
    MOBILE_3G(3),
    MOBILE_4G(4),
    MOBILE_5G(5);


    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f288a;

    f8(int i) {
        this.f288a = i;
    }

    @Override // java.lang.Enum
    public String toString() {
        return Integer.toString(this.f288a);
    }
}
