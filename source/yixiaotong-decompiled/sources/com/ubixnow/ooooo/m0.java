package com.ubixnow.ooooo;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class m0 {
    public static String OooO00o(Context context) {
        if (OooO00o(context, "com.huawei.hwid")) {
            return "com.huawei.hwid";
        }
        if (OooO00o(context, "com.huawei.hms")) {
            return "com.huawei.hms";
        }
        return OooO00o(context, "com.huawei.hwid.tv") ? "com.huawei.hwid.tv" : "com.huawei.hwid";
    }

    public static boolean OooO00o(Context context, String str) {
        return OooO0O0(context, str) != null;
    }

    public static PackageInfo OooO0O0(Context context, String str) {
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
