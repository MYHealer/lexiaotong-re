package com.hihonor.hianalytics.support;

import android.app.Application;
import android.content.Context;
import com.hihonor.hianalytics.util.SystemUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class HaHelpUtils {
    public static boolean canDirectAccessStorage() {
        return SystemUtils.a();
    }

    public static Application getApp() {
        return SystemUtils.getApp();
    }

    public static Context getContext() {
        return SystemUtils.getContext();
    }

    public static String getDesensitizedException(Throwable th) {
        return SystemUtils.getDesensitizedException(th);
    }

    public static Context getDeviceProtectedContext() {
        return SystemUtils.e();
    }

    public static String getProcessName() {
        return SystemUtils.getProcessName();
    }

    public static boolean isBackground() {
        return SystemUtils.k();
    }
}
