package com.kwad.sdk.crash.utils;

import client.android.yixiaotong.util.TimeUtils;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class i {
    private static SimpleDateFormat bgs = new SimpleDateFormat(TimeUtils.FORMATDATETIME);

    public static String aT(long j) {
        return j <= 0 ? "unknown" : bgs.format(new Date(j));
    }
}
