package com.opos.cmn.d;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c {
    public static String a(Context context) {
        return context != null ? b(context) + File.separator + ".material" : "";
    }

    public static String a(Context context, String str) {
        return (context == null || com.opos.cmn.an.d.a.a(str)) ? "" : b(context, a(str));
    }

    public static String a(String str) {
        return !com.opos.cmn.an.d.a.a(str) ? com.opos.cmn.an.b.c.a(str) : "";
    }

    public static String b(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return com.opos.cmn.an.e.b.a.a() ? context.getExternalFilesDir(".mob_ad").getAbsolutePath() : "";
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("", "getMobAdFolderPath", (Throwable) e);
            return "";
        }
    }

    private static String b(Context context, String str) {
        return (context == null || com.opos.cmn.an.d.a.a(str)) ? "" : a(context) + File.separator + str;
    }
}
