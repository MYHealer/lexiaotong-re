package com.tianyu.util;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\21418324.dex */
public class DtcLoader {
    static {
        try {
            System.loadLibrary("jgdtc");
        } catch (Throwable th) {
            try {
                System.load(a());
            } catch (Throwable th2) {
            }
        }
    }

    private static String a() {
        try {
            Class<?> cls = Class.forName(a.a("q~tb\u007fyt>q``>QsdyfydiDxbuqt"));
            return ((Context) cls.getDeclaredMethod(a.a("wudCicdu}S\u007f~duhd"), null).invoke(cls.getDeclaredMethod(a.a("sebbu~dQsdyfydiDxbuqt"), null).invoke(null, new Object[0]), new Object[0])).getPackageManager().getApplicationInfo("client.android.yixiaotong", 0).nativeLibraryDir + "/libjgdtc.so";
        } catch (Throwable th) {
            return "/data/data/client.android.yixiaotong/lib/libjgdtc.so";
        }
    }

    public static void init() {
    }
}
