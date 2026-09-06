package com.ubix.ssp.ad.core.util.myoaid.impl.huawei;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d {
    public static String a(Context context) {
        if (a(context, "com.huawei.hwid")) {
            return "com.huawei.hwid";
        }
        if (a(context, "com.huawei.hms")) {
            return "com.huawei.hms";
        }
        return a(context, "com.huawei.hwid.tv") ? "com.huawei.hwid.tv" : "com.huawei.hwid";
    }

    public static boolean a(Context context, String str) {
        return b(context, str) != null;
    }

    public static PackageInfo b(Context context, String str) {
        String str2;
        if (TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return packageManager.getPackageInfo(str, 128);
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            str2 = "getPackageInfo NameNotFoundException";
            Log.w("ApkUtil", str2);
            return null;
        } catch (Exception unused2) {
            str2 = "getPackageInfo Exception";
            Log.w("ApkUtil", str2);
            return null;
        }
    }
}
