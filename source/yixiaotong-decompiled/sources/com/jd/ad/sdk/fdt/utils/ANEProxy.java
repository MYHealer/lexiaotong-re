package com.jd.ad.sdk.fdt.utils;

import android.text.TextUtils;
import android.util.Log;
import com.alipay.sdk.util.i;
import com.jd.ad.sdk.logger.Logger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ANEProxy {
    public static synchronized String ja(String str) {
        return ANE.jad_cp(str);
    }

    public static synchronized String jb(String str) {
        return ANE.jad_an(str);
    }

    public static synchronized String jc(String str) {
        String strTrim;
        synchronized (ANE.class) {
            try {
                int i = ANE.jad_an;
                if (!TextUtils.isEmpty(str)) {
                    strTrim = str.trim();
                    if (!strTrim.startsWith("{") || !strTrim.endsWith(i.d)) {
                        try {
                            strTrim = ANE.jad_an(strTrim);
                        } catch (Throwable th) {
                            Logger.d(Log.getStackTraceString(th));
                            strTrim = "";
                        }
                        if (!strTrim.startsWith("{") || !strTrim.endsWith(i.d)) {
                        }
                    }
                }
                strTrim = "";
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return strTrim;
    }

    public static synchronized String jd(String str) {
        return ANE.jad_dq(str);
    }

    public static synchronized String je(String str) {
        return ANE.jad_bo(str);
    }
}
