package com.kuaishou.weapon.p0;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class bv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f4656a = c.b("Y29tLmt3YWkud2VhcG9uLmNvbmp1cmU=\n", 2);
    private static String b = c.b(b, 2);
    private static String b = c.b(b, 2);

    public static String a(Context context) {
        String str = TextUtils.isEmpty(d(context)) ? "0" : "1";
        String strC = c(context);
        if (TextUtils.isEmpty(strC)) {
            return "0".concat(str);
        }
        String strConcat = "1".concat(str);
        b(context, strC);
        return strConcat;
    }

    public static String b(Context context) {
        String strC = c(context);
        String strD = d(context);
        if (!TextUtils.isEmpty(strC) && TextUtils.equals(strC, strD)) {
            return strC;
        }
        if (!TextUtils.isEmpty(strC)) {
            b(context, strC);
            return strC;
        }
        if (TextUtils.isEmpty(strD)) {
            return "";
        }
        a(context, strD);
        return strD;
    }

    public static String c(Context context) {
        try {
            return Settings.System.getString(context.getContentResolver(), f4656a);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String d(Context context) {
        try {
            return dd.a(context).e();
        } catch (Exception unused) {
            return "";
        }
    }

    public static void a(Context context, String str) {
        try {
            if (Settings.System.canWrite(StubApp.getOrigApplicationContext(context.getApplicationContext()))) {
                Settings.System.putString(context.getContentResolver(), f4656a, str);
            }
        } catch (Exception unused) {
        }
    }

    public static void b(Context context, String str) {
        dd.a(context).d(str);
    }
}
