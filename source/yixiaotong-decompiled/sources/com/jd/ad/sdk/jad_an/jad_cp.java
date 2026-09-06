package com.jd.ad.sdk.jad_an;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.jd.android.sdk.coreinfo.util.Logger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_cp {
    public static String jad_an = "";
    public static String jad_bo = "";
    public static String jad_cp = "";
    public static int jad_dq;
    public static long jad_er;
    public static long jad_fs;
    public static long jad_jt;

    public static PackageInfo jad_an(Context context, int i) {
        try {
            return context.getPackageManager().getPackageInfo(jad_an(context), i);
        } catch (Exception e) {
            Logger.e("AppInfo", "An exception happends when call getPackageInfo().", e);
            return null;
        }
    }

    public static String jad_an(Context context) {
        if (TextUtils.isEmpty(jad_bo)) {
            if (context == null) {
                Logger.w("AppInfo", "context is null");
                return "";
            }
            jad_bo = context.getPackageName();
        }
        return jad_bo;
    }

    public static long jad_bo(Context context) {
        String str;
        if (jad_jt <= 0) {
            if (context == null) {
                str = "context is null";
            } else {
                PackageInfo packageInfoJad_an = jad_an(context, 64);
                if (packageInfoJad_an == null) {
                    str = "packageInfo is null";
                } else {
                    jad_jt = packageInfoJad_an.signatures[0].hashCode();
                }
            }
            Logger.w("AppInfo", str);
            return 0L;
        }
        return jad_jt;
    }
}
