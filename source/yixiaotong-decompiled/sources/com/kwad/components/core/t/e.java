package com.kwad.components.core.t;

import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class e {
    public static String a(long j, boolean z) {
        String[] strArr = {" B", " KB", " MB", " GB", " TB", " PB", " EB", " ZB", " YB"};
        if (j <= 1) {
            return j + "B";
        }
        double d = j;
        int iLog = (int) (Math.log(d) / Math.log(1024.0d));
        return String.format(Locale.ENGLISH, "%.1f%s", Double.valueOf(j > 1024 ? d / Math.pow(1024.0d, iLog) : d / 1024.0d), strArr[iLog]);
    }
}
