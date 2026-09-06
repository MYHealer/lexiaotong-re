package com.alipay.sdk.util;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f1662a;

    public static boolean a(Context context, String str) {
        try {
            return PreferenceManager.getDefaultSharedPreferences(context).contains(str);
        } catch (Throwable th) {
            c.a(th);
            return false;
        }
    }

    public static void b(Context context, String str) {
        try {
            PreferenceManager.getDefaultSharedPreferences(context).edit().remove(str).commit();
        } catch (Throwable th) {
            c.a(th);
        }
    }

    public static void a(Context context, String str, String str2) {
        try {
            String strA = com.alipay.sdk.encrypt.f.a(a(context), str2, str);
            if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(strA)) {
                com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.c, com.alipay.sdk.app.statistic.c.z, String.format("%s,%s", str, str2));
            }
            PreferenceManager.getDefaultSharedPreferences(context).edit().putString(str, strA).commit();
        } catch (Throwable th) {
            c.a(th);
        }
    }

    public static String b(Context context, String str, String str2) {
        String strB = null;
        try {
            String string = PreferenceManager.getDefaultSharedPreferences(context).getString(str, str2);
            strB = TextUtils.isEmpty(string) ? null : com.alipay.sdk.encrypt.f.b(a(context), string, str);
            if (!TextUtils.isEmpty(string) && TextUtils.isEmpty(strB)) {
                com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.c, com.alipay.sdk.app.statistic.c.y, String.format("%s,%s", str, string));
            }
        } catch (Exception e) {
            c.a(e);
        }
        return strB;
    }

    private static String a(Context context) {
        String packageName;
        if (TextUtils.isEmpty(f1662a)) {
            try {
                packageName = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName();
            } catch (Throwable th) {
                c.a(th);
                packageName = "";
            }
            f1662a = (packageName + "0000000000000000000000000000").substring(0, 24);
        }
        return f1662a;
    }
}
