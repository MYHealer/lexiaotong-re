package com.yfanads.android.utils;

import android.util.Log;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class YFPlayerLog {
    private static final String LOG = "YFPlayerLog";
    private static final String TRACE_TAG = "trace";
    public static boolean isDebug = true;

    private YFPlayerLog() {
    }

    public static void debug(String str) {
        if (isDebug()) {
            Log.d(LOG, str);
        }
    }

    public static void devDebug(String str) {
        if (isDebug()) {
            Log.d(LOG, "[dev] " + str);
        }
    }

    public static void error(String str) {
        if (isDebug()) {
            Log.e(LOG, str);
        }
    }

    public static void high(String str) {
        if (isDebug()) {
            Log.d(LOG, "[H] " + str);
        }
    }

    private static boolean isDebug() {
        return isDebug;
    }

    public static void max(String str) {
        if (isDebug()) {
            Log.d(LOG, "[A] " + str);
        }
    }

    public static void simple(String str) {
        if (isDebug()) {
            Log.d(LOG, "" + str);
        }
    }

    public static void traceDebug(String str) {
        debug("trace " + str);
    }

    public static void warn(String str) {
        if (isDebug()) {
            Log.w(LOG, str);
        }
    }
}
