package com.alipay.apmobilesecuritysdk.c;

import android.content.Context;
import android.os.Build;
import com.alipay.security.mobile.module.d.d;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class a {
    public static synchronized void a(Context context, String str, String str2, String str3) {
        d.a(context.getFilesDir().getAbsolutePath() + "/log/ap", new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime()) + ".log", b(context, str, str2, str3).toString());
    }

    public static synchronized void a(String str) {
        d.a(str);
    }

    public static synchronized void a(Throwable th) {
        d.a(th);
    }

    private static com.alipay.security.mobile.module.d.a b(Context context, String str, String str2, String str3) {
        String packageName;
        try {
            packageName = context.getPackageName();
        } catch (Throwable unused) {
            packageName = "";
        }
        return new com.alipay.security.mobile.module.d.a(Build.MODEL, packageName, "APPSecuritySDK-ALIPAYSDK", "3.4.0.201910161639", str, str2, str3);
    }
}
