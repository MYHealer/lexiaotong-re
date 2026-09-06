package com.hihonor.secure.android.common.ssl.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class h {
    private static final String TAG = "h";

    public static boolean g(String str) {
        Context contextK = c.k();
        if (contextK != null && str != null) {
            try {
                PackageInfo packageInfo = contextK.getPackageManager().getPackageInfo(str, 0);
                if (packageInfo != null) {
                    return TextUtils.equals(str, packageInfo.packageName);
                }
            } catch (PackageManager.NameNotFoundException unused) {
                g.e(TAG, "exception");
            }
        }
        return false;
    }

    public static String h(String str) {
        Context contextK = c.k();
        if (contextK == null) {
            return "";
        }
        try {
            return contextK.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            g.e(TAG, "getVersion NameNotFoundException : " + e.getMessage());
            return "";
        } catch (Exception e2) {
            g.e(TAG, "getVersion: " + e2.getMessage());
            return "";
        } catch (Throwable unused) {
            g.e(TAG, "throwable");
            return "";
        }
    }

    public static int i(String str) {
        Context contextK = c.k();
        if (contextK == null) {
            return 0;
        }
        try {
            return contextK.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            g.e(TAG, "getVersion NameNotFoundException");
            return 0;
        } catch (Exception e) {
            g.e(TAG, "getVersion: " + e.getMessage());
            return 0;
        }
    }
}
