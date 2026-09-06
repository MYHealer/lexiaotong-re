package com.kwad.sdk.crash.utils;

import com.huawei.openalliance.ad.constant.x;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class j {
    public static String aU(long j) {
        long j2 = j / 60000;
        long j3 = (j - (60000 * j2)) / 1000;
        return (j2 < 10 ? "0" + j2 : String.valueOf(j2)) + x.bQ + (j3 < 10 ? "0" + j3 : String.valueOf(j3));
    }
}
