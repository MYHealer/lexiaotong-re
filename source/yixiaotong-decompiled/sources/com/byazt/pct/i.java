package com.byazt.pct;

import android.util.Log;
import client.android.yixiaotong.v3.comman.AppTypeIdUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, AppTypeIdUtil.NewDevice4GDrinkOTA_1, 42})
public final class i {
    public static boolean c;

    public static void c(boolean z) {
        c = z;
    }

    public static void c(String str) {
        if (c) {
            com.byazt.nr.m.c("JsBridge2", str);
        }
    }

    public static void tt(String str) {
        if (c) {
            com.byazt.nr.m.tt("JsBridge2", str);
        }
    }

    public static void c(String str, Throwable th) {
        if (c) {
            com.byazt.nr.m.tt("JsBridge2", str, th);
            com.byazt.nr.m.tt("JsBridge2", "Stacktrace: " + Log.getStackTraceString(th));
        }
    }

    public static void tt(String str, Throwable th) {
        if (c) {
            com.byazt.nr.m.ve("JsBridge2", str, th);
            com.byazt.nr.m.uj("JsBridge2", "Stacktrace: " + Log.getStackTraceString(th));
        }
    }

    public static void c(RuntimeException runtimeException) {
        if (c) {
            throw runtimeException;
        }
    }
}
