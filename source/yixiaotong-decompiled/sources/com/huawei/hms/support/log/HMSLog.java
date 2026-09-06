package com.huawei.hms.support.log;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.huawei.hms.base.log.a;
import com.huawei.hms.base.log.d;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class HMSLog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f4402a = new a();

    public static String a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 16384);
                return "HMS-" + packageInfo.versionName + "(" + packageInfo.versionCode + ")";
            } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            }
        }
        return "HMS-[unknown-version]";
    }

    public static void d(String str, String str2) {
        f4402a.a(3, str, str2);
    }

    public static void e(String str, String str2) {
        f4402a.a(6, str, str2);
    }

    public static void i(String str, String str2) {
        f4402a.a(4, str, str2);
    }

    public static void init(Context context, int i, String str) {
        a aVar = f4402a;
        aVar.a(context, i, str);
        StringBuilder sb = new StringBuilder("============================================================================\n====== ");
        sb.append(a(context)).append("\n============================================================================");
        aVar.a(str, sb.toString());
    }

    public static boolean isErrorEnable() {
        return f4402a.a(6);
    }

    public static boolean isInfoEnable() {
        return f4402a.a(4);
    }

    public static boolean isWarnEnable() {
        return f4402a.a(5);
    }

    public static void setExtLogger(HMSExtLogger hMSExtLogger, boolean z) throws IllegalArgumentException {
        if (hMSExtLogger == null) {
            throw new IllegalArgumentException("extLogger is not able to be null");
        }
        d dVar = new d(hMSExtLogger);
        if (z) {
            f4402a.a(dVar);
        } else {
            f4402a.a().a(dVar);
        }
    }

    public static void w(String str, String str2) {
        f4402a.a(5, str, str2);
    }

    public static void e(String str, String str2, Throwable th) {
        f4402a.b(6, str, str2, th);
    }

    public static void e(String str, long j, String str2) {
        f4402a.a(6, str, "[" + j + "] " + str2);
    }

    public static void e(String str, long j, String str2, Throwable th) {
        f4402a.b(6, str, "[" + j + "] " + str2, th);
    }
}
