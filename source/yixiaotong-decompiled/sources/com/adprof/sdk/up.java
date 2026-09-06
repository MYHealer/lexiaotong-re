package com.adprof.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class up {
    public static boolean a(Context context, String str) {
        String str2;
        PackageInfo packageInfo = null;
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    packageInfo = packageManager.getPackageInfo(str, 128);
                }
            } catch (PackageManager.NameNotFoundException unused) {
                str2 = "getPackageInfo NameNotFoundException";
                Log.w("ApkUtil", str2);
            } catch (Exception unused2) {
                str2 = "getPackageInfo Exception";
                Log.w("ApkUtil", str2);
            }
        }
        return packageInfo != null;
    }
}
