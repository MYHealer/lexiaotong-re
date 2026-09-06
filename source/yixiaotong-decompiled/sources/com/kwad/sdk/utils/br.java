package com.kwad.sdk.utils;

import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class br {
    private static final SimpleDateFormat bqA = new SimpleDateFormat("MM/dd", Locale.US);
    private static final SimpleDateFormat bqB = new SimpleDateFormat("yyyy/MM/dd", Locale.US);
    private static final SimpleDateFormat bqC = new SimpleDateFormat("MM月dd日", Locale.US);
    private static final SimpleDateFormat bqD = new SimpleDateFormat("yyyy年MM月dd日", Locale.US);
    private static final SimpleDateFormat bqE = new SimpleDateFormat("HH:mm", Locale.US);
    private static final SimpleDateFormat bqF = new SimpleDateFormat("MM-dd", Locale.US);
    private static final SimpleDateFormat bqG = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

    public static boolean isNullString(String str) {
        return TextUtils.isEmpty(str) || "null".equalsIgnoreCase(str);
    }

    public static boolean ig(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches(".*\\.kpg.*");
    }

    public static boolean isEquals(String str, String str2) {
        return !TextUtils.isEmpty(str) && str.equals(str2);
    }
}
