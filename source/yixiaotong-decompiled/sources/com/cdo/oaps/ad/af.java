package com.cdo.oaps.ad;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class af {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f3115a = 5100;
    public static final int b = 4600;
    public static final int c = 4550;
    public static final int d = 390;
    public static final String e = "com.heytap.market";
    public static final String[] f = {Launcher.Path.DETAIL, Launcher.Path.DETAIL_DOWN, Launcher.Path.SEARCH, Launcher.Path.SEARCH_DOWN, Launcher.Path.HOME};
    public static final String[] g = {Launcher.Path.DETAIL, Launcher.Path.DETAIL_DOWN, Launcher.Path.SEARCH, Launcher.Path.SEARCH_DOWN, Launcher.Path.HOME, Launcher.Path.PREDOWN};
    public static final String[] h = {Launcher.Path.DETAIL, Launcher.Path.DETAIL_DOWN, Launcher.Path.SEARCH, Launcher.Path.SEARCH_DOWN, Launcher.Path.HOME, Launcher.Path.PREDOWN, Launcher.Path.WEB};

    public static int a(Context context) {
        int i;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(a.b(), 0);
            if (packageInfo == null) {
                return 0;
            }
            i = packageInfo.versionCode;
        } catch (Exception e2) {
            if (!(e2 instanceof PackageManager.NameNotFoundException)) {
                return 0;
            }
            try {
                PackageInfo packageInfo2 = context.getPackageManager().getPackageInfo(e, 0);
                if (packageInfo2 == null) {
                    return 0;
                }
                i = packageInfo2.versionCode;
            } catch (Exception unused) {
                return 0;
            }
        }
        return i;
    }

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

    public static boolean a(Context context, int i) {
        int iA = a(context);
        return iA != 0 && iA >= i;
    }

    public static boolean a(Context context, String str, int i) {
        int iA = a(context, str);
        return iA != 0 && iA >= i;
    }

    public static String b(Context context) {
        if (b(context, e)) {
            return e;
        }
        if (b(context, a.b())) {
            return a.b();
        }
        return null;
    }

    public static boolean b(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 8192) != null;
        } catch (Exception unused) {
            return false;
        }
    }
}
