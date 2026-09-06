package com.kwad.components.core.pfmonitor.model;

import android.content.Context;
import android.os.Environment;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class e {
    private String aix;
    private String aiy;
    private String aiz;

    public final String vv() {
        return this.aiz;
    }

    public final String vw() {
        return this.aiy;
    }

    private e(String str, String str2, String str3) {
        this.aix = str;
        this.aiy = str2;
        this.aiz = str3;
    }

    public static e j(Context context, String str) {
        if (str.startsWith("/appInner/")) {
            return new e("/appInner/", str, aK(context) + str.substring(9));
        }
        if (str.startsWith("/appInnerFiles/")) {
            try {
                return new e("/appInnerFiles/", str, context.getFilesDir().getAbsolutePath() + str.substring(14));
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                return null;
            }
        }
        if (str.startsWith("/appInnerCache/")) {
            try {
                return new e("/appInnerCache/", str, context.getCacheDir().getAbsolutePath() + str.substring(14));
            } catch (Exception e2) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e2);
                return null;
            }
        }
        if (str.startsWith("/appExternal/")) {
            String strSubstring = str.substring(12);
            String strAH = aH(context);
            if (strAH != null) {
                return new e("/appExternal/", str, strAH + strSubstring);
            }
            return null;
        }
        if (str.startsWith("/appExternalFiles/")) {
            return new e("/appExternalFiles/", str, aI(context) + str.substring(17));
        }
        if (str.startsWith("/appExternalCache/")) {
            return new e("/appExternalCache/", str, aJ(context) + str.substring(17));
        }
        if (!str.startsWith("/sdcard/")) {
            return null;
        }
        return new e("/sdcard/", str, Environment.getExternalStorageDirectory().getAbsolutePath() + str.substring(7));
    }

    private static String aH(Context context) {
        try {
            return context.getExternalFilesDir(null).getParent();
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return null;
        }
    }

    private static String aI(Context context) {
        try {
            return context.getExternalFilesDir(null).getAbsolutePath();
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return null;
        }
    }

    private static String aJ(Context context) {
        try {
            return context.getExternalFilesDir(null).getAbsolutePath();
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return null;
        }
    }

    private static String aK(Context context) {
        return context.getDataDir().getAbsolutePath();
    }
}
