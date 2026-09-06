package com.fancy;

import android.content.pm.PackageInfo;
import com.fancy.adsdk.lib.PtgAdSdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ht {
    public static String _a(String str) {
        try {
            PackageInfo packageInfo = PtgAdSdk.getContext().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return null;
            }
            return String.valueOf(packageInfo.versionCode);
        } catch (Exception unused) {
            return null;
        }
    }
}
