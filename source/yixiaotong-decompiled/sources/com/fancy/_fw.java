package com.fancy;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _fw {
    public static String _a(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        String strSubstring = (iLastIndexOf == -1 || iLastIndexOf <= str.lastIndexOf(47) || iLastIndexOf + 6 <= str.length()) ? "" : str.substring(iLastIndexOf + 1, str.length());
        String str_a = _i4._a(str);
        return TextUtils.isEmpty(strSubstring) ? str_a : str_a + "." + strSubstring;
    }
}
