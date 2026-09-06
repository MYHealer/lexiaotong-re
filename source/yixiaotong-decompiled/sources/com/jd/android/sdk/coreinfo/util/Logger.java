package com.jd.android.sdk.coreinfo.util;

import android.util.Log;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class Logger {
    public static boolean D;
    public static boolean E;
    public static boolean I;
    public static boolean W;
    public static boolean printStack;

    public static void d(String str, String str2) {
        if (D) {
            Log.d(str, str2);
        }
    }

    public static void debugWithStackTrace(String str, String str2) {
        if (D) {
            Log.d(str, str2);
            if (printStack) {
                Log.d(str, getStackTrace());
            }
        }
    }

    public static void e(String str, String str2) {
        if (E) {
            Log.e(str, str2);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (E) {
            Log.e(str, str2, th);
        }
    }

    public static void enableLogger(boolean z) {
        E = z;
        W = z;
        I = z;
        D = z;
    }

    public static void errorWithStackTrace(String str, String str2) {
        if (E) {
            Log.e(str, str2);
            if (printStack) {
                Log.e(str, getStackTrace());
            }
        }
    }

    public static String getStackTrace() {
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            StringBuilder sb = new StringBuilder("stacktrace: \n");
            for (StackTraceElement stackTraceElement : stackTrace) {
                sb.append(stackTraceElement.toString()).append(IOUtils.LINE_SEPARATOR_UNIX);
            }
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void i(String str, String str2) {
        if (I) {
            Log.i(str, str2);
        }
    }

    public static void infoWithStackTrace(String str, String str2) {
        if (I) {
            Log.i(str, str2);
            if (printStack) {
                Log.i(str, getStackTrace());
            }
        }
    }

    public static void w(String str, String str2) {
        if (W) {
            Log.w(str, str2);
        }
    }

    public static void warnWithStackTrace(String str, String str2) {
        if (W) {
            Log.w(str, str2);
            if (printStack) {
                Log.w(str, getStackTrace());
            }
        }
    }
}
