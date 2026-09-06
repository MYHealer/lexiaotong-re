package com.jd.ad.sdk.fdt.utils;

import android.text.TextUtils;
import android.util.Log;
import com.alipay.sdk.util.i;
import com.jd.ad.sdk.jad_fq.jad_jw;
import com.jd.ad.sdk.logger.Logger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ANE {
    public static final /* synthetic */ int jad_an = 0;

    static {
        try {
            System.loadLibrary("ane");
        } catch (Throwable th) {
            Logger.d(Log.getStackTraceString(th));
        }
    }

    private static native String a(String str);

    private static native String b(String str);

    private static native String c(String str);

    private static native String d(String str);

    public static synchronized String jad_an(String str) {
        if (!jad_jw.jad_an(str)) {
            return "";
        }
        String strB = "";
        try {
            strB = b(str);
        } catch (Throwable th) {
            Logger.d(Log.getStackTraceString(th));
        }
        if (TextUtils.isEmpty(strB)) {
            strB = "";
        }
        return strB;
    }

    public static synchronized String jad_bo(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String strTrim = str.trim();
        if (strTrim.startsWith("{") && strTrim.endsWith(i.d)) {
            return strTrim;
        }
        String str2 = "";
        try {
            synchronized (ANE.class) {
                if (jad_jw.jad_an(strTrim)) {
                    String strD = "";
                    try {
                        strD = d(strTrim);
                    } catch (Throwable th) {
                        Logger.d(Log.getStackTraceString(th));
                    }
                    if (TextUtils.isEmpty(strD)) {
                        strD = "";
                    }
                    str2 = strD;
                } else {
                    str2 = "";
                }
                return (str2.startsWith("{") && str2.endsWith(i.d)) ? str2 : "";
            }
        } catch (Throwable th2) {
            Logger.d(Log.getStackTraceString(th2));
        }
    }

    public static synchronized String jad_cp(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String strA = "";
        try {
            strA = a(str);
        } catch (Throwable th) {
            Logger.d(Log.getStackTraceString(th));
        }
        if (TextUtils.isEmpty(strA)) {
            strA = "";
        }
        return strA;
    }

    public static synchronized String jad_dq(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String strC = "";
        try {
            strC = c(str);
        } catch (Throwable th) {
            Logger.d(Log.getStackTraceString(th));
        }
        if (TextUtils.isEmpty(strC)) {
            strC = "";
        }
        return strC;
    }
}
