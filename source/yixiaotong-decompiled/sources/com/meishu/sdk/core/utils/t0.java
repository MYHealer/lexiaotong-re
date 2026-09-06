package com.meishu.sdk.core.utils;

/* JADX INFO: compiled from: PriceUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class t0 {
    public static int a(int i, int i2, int i3, int i4) {
        if (i3 < 0) {
            i3 = 0;
        }
        if (i3 > 100) {
            i3 = 100;
        }
        int iMax = Math.max(i2, i4);
        return iMax >= i ? i : Math.round(((i - iMax) * i3) / 100.0f) + iMax;
    }
}
