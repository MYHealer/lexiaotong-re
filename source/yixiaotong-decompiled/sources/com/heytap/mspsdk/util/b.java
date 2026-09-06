package com.heytap.mspsdk.util;

import android.os.Build;
import com.heytap.mspsdk.log.MspLog;
import com.huawei.openalliance.ad.constant.x;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile int f3477a = -1;

    public static boolean a() {
        return Build.VERSION.SDK_INT >= 30;
    }

    public static boolean b() {
        return c() >= 34;
    }

    public static int c() {
        if (f3477a != -1) {
            return f3477a;
        }
        int iIntValue = 0;
        try {
            Class<?> cls = Class.forName(d());
            if (cls == null) {
                return 0;
            }
            iIntValue = ((Integer) cls.getDeclaredMethod(e(), new Class[0]).invoke(cls, new Object[0])).intValue();
        } catch (Exception e) {
            MspLog.e("ColorOSVersionUtils", e);
        }
        MspLog.e("ColorOSVersionUtils", d() + "#" + e() + x.bQ + iIntValue);
        f3477a = iIntValue;
        return iIntValue;
    }

    private static String d() {
        return a() ? "com.oplus.os.OplusBuild" : "com.color.os.ColorBuild";
    }

    private static String e() {
        return a() ? "getOplusOSVERSION" : "getColorOSVERSION";
    }
}
