package com.byazt.uq;

import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1759, 42})
public class i {
    public static boolean a() {
        return false;
    }

    public static boolean c() {
        return true;
    }

    public static boolean da() {
        return true;
    }

    public static boolean i() {
        return true;
    }

    public static boolean m() {
        return Build.VERSION.SDK_INT == 29;
    }

    public static boolean n() {
        return false;
    }

    public static boolean sl() {
        return false;
    }

    public static boolean sp() {
        return Build.VERSION.SDK_INT <= 28;
    }

    public static boolean t() {
        return Build.VERSION.SDK_INT <= 28;
    }

    public static boolean tt() {
        return true;
    }

    public static boolean u() {
        return true;
    }

    public static boolean uj() {
        return false;
    }

    public static boolean ve() {
        return Build.VERSION.SDK_INT <= 28;
    }

    public static boolean x() {
        return Build.VERSION.SDK_INT >= 29 && Build.VERSION.SDK_INT <= 30;
    }

    public static boolean yp() {
        if (Build.VERSION.SDK_INT < 28) {
            return Build.VERSION.SDK_INT == 27 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }

    public static boolean z() {
        if (Build.VERSION.SDK_INT < 29) {
            return Build.VERSION.SDK_INT == 28 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }

    public static boolean nu() {
        if (Build.VERSION.SDK_INT < 30) {
            return Build.VERSION.SDK_INT == 29 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }

    public static boolean rh() {
        if (Build.VERSION.SDK_INT < 31) {
            return Build.VERSION.SDK_INT == 30 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }

    public static boolean my() {
        return TextUtils.equals(Build.BRAND.toLowerCase(), "huawei");
    }

    public static boolean gt() {
        return TextUtils.equals(Build.BRAND.toLowerCase(), "samsung");
    }
}
