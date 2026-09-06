package com.huawei.secure.android.common.util;

import android.util.Log;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class SafeString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4570a = "SafeString";
    private static final String b = "";

    public static String replace(String str, CharSequence charSequence, CharSequence charSequence2) {
        if (str != null && charSequence != null && charSequence2 != null) {
            try {
                return str.replace(charSequence, charSequence2);
            } catch (Exception e) {
                Log.e(f4570a, "replace: " + e.getMessage());
            }
        }
        return str;
    }

    public static String substring(String str, int i) {
        if (str != null && str.length() >= i && i >= 0) {
            try {
                return str.substring(i);
            } catch (Exception e) {
                Log.e(f4570a, "substring exception: " + e.getMessage());
            }
        }
        return "";
    }

    public static String substring(String str, int i, int i2) {
        if (str != null && i >= 0 && i2 <= str.length() && i2 >= i) {
            try {
                return str.substring(i, i2);
            } catch (Exception e) {
                Log.e(f4570a, "substring: " + e.getMessage());
            }
        }
        return "";
    }
}
