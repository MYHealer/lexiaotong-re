package com.opos.cmn.d;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.opos.cmn.i.j;
import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d {
    public static String a() {
        return com.opos.cmn.an.e.b.a.b() + File.separator + ".mob_ad" + File.separator + ".material" + File.separator + ".video";
    }

    public static String a(Context context, String str) {
        if (!com.opos.cmn.an.e.b.a.a()) {
            return "";
        }
        if (a(context)) {
            String strA = a(str);
            if (com.opos.cmn.an.e.b.a.a(strA)) {
                return strA;
            }
        }
        String strC = c(context, str);
        return com.opos.cmn.an.e.b.a.a(strC) ? strC : "";
    }

    public static String a(Context context, String str, String str2) {
        if (!com.opos.cmn.an.e.b.a.a()) {
            return "";
        }
        if (a(context)) {
            String strA = a(str);
            if (b.a(strA, str2)) {
                return strA;
            }
        }
        String strC = c(context, str);
        return b.a(strC, str2) ? strC : "";
    }

    private static String a(String str) {
        return !com.opos.cmn.an.d.a.a(str) ? com.opos.cmn.an.e.b.a.b() + File.separator + ".mob_ad" + File.separator + ".material" + File.separator + ".video" + File.separator + b.a(str) : "";
    }

    public static boolean a(Context context) {
        return j.a(context, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}) && Build.VERSION.SDK_INT < 33 && (Build.VERSION.SDK_INT < 29 || Environment.isExternalStorageLegacy());
    }

    public static String b(Context context) {
        return context.getExternalFilesDir(".mob_ad").getAbsolutePath() + File.separator + ".material" + File.separator + ".video";
    }

    public static String b(Context context, String str) {
        return (!com.opos.cmn.an.e.b.a.a() || com.opos.cmn.an.d.a.a(str)) ? "" : c(context, str);
    }

    private static String c(Context context, String str) {
        return !com.opos.cmn.an.d.a.a(str) ? context.getExternalFilesDir(".mob_ad").getAbsolutePath() + File.separator + ".material" + File.separator + ".video" + File.separator + b.a(str) : "";
    }
}
