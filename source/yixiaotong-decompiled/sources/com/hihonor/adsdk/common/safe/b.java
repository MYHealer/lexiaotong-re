package com.hihonor.adsdk.common.safe;

import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b {
    private static final String hnadsa = "SafeDateFormatUtil";

    public static SimpleDateFormat hnadsa(String str) {
        try {
            return new SimpleDateFormat(str);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "safeGetSimpleDateFormat, Exception: " + e.getMessage(), new Object[0]);
            return null;
        }
    }

    public static SimpleDateFormat hnadsa(String str, Locale locale) {
        try {
            return new SimpleDateFormat(str, locale);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "safeGetSimpleDateFormat, Exception: " + e.getMessage(), new Object[0]);
            return null;
        }
    }
}
