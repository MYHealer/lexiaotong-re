package com.kuaishou.weapon.p0;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.stub.StubApp;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class bq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f4653a = "weapon.set";
    private static String e;
    private static String b = c.b("Y29tLmt3YWkud2VhcG9u", 2);
    private static String c = c.b(c, 2);
    private static String c = c.b(c, 2);
    private static String d = c.b(d, 2);
    private static String d = c.b(d, 2);

    private bq() {
    }

    public static synchronized String a(Context context) {
        if (!TextUtils.isEmpty(e)) {
            return e;
        }
        String strC = c(context);
        e = strC;
        return strC;
    }

    private static String c(Context context) {
        String strE = e(context);
        if (!TextUtils.isEmpty(strE)) {
            return strE;
        }
        String strD = d(context);
        if (!TextUtils.isEmpty(strD)) {
            b(context, strD);
        }
        return strD;
    }

    private static String d(Context context) {
        try {
            h hVarA = h.a(context, "re_po_rt");
            boolean zE = hVarA.e("a1_p_s_p_s");
            boolean zE2 = hVarA.e("a1_p_s_p_s_c_b");
            String strF = (zE || zE2) ? bf.f(context) : "";
            if (TextUtils.isEmpty(strF)) {
                strF = UUID.randomUUID().toString();
            }
            String str = strF + b;
            String strC = (zE || zE2) ? bf.c(context) : "";
            if (TextUtils.isEmpty(strC) || strC.startsWith("RISK")) {
                strC = "0";
            }
            return new bl(context).a(f.a(str).toUpperCase() + "|" + new StringBuffer(strC).reverse().toString().toUpperCase(), bg.u);
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String e(Context context) {
        String strA = a(context, c);
        String strF = f(context);
        if (!TextUtils.isEmpty(strA) && TextUtils.equals(strA, strF)) {
            return strA;
        }
        if (!TextUtils.isEmpty(strA)) {
            d(context, strA);
            return strA;
        }
        if (TextUtils.isEmpty(strF)) {
            return "";
        }
        c(context, strF);
        return strF;
    }

    public static String a(Context context, String str) {
        try {
            return Settings.System.getString(context.getContentResolver(), str);
        } catch (Exception unused) {
            return "";
        }
    }

    private static String f(Context context) {
        try {
            return dd.a(context).d();
        } catch (Exception unused) {
            return "";
        }
    }

    private static void b(Context context, String str) {
        c(context, str);
        d(context, str);
    }

    public static boolean b(Context context) {
        return Settings.System.canWrite(StubApp.getOrigApplicationContext(context.getApplicationContext()));
    }

    private static void c(Context context, String str) {
        try {
            if (b(context)) {
                ContentResolver contentResolver = context.getContentResolver();
                Settings.System.putString(contentResolver, c, str);
                Settings.System.putString(contentResolver, f4653a, new StringBuilder().append(System.currentTimeMillis()).toString());
            }
        } catch (Exception unused) {
        }
    }

    private static void d(Context context, String str) {
        dd.a(context).c(str);
    }
}
