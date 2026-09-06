package com.cdo.oaps.ad;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f3127a = 2000000;
    public static final int b = 1;
    public static final String[] c = {Launcher.Path.DETAIL, Launcher.Path.DETAIL_DOWN, Launcher.Path.SEARCH, Launcher.Path.SEARCH_DOWN, Launcher.Path.HOME};

    public static int a(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return 0;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    public static boolean a(Context context, String str, int i) {
        int iA = a(context, str);
        return iA != 0 && iA >= i;
    }
}
