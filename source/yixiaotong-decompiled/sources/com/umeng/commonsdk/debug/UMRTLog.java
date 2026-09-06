package com.umeng.commonsdk.debug;

import android.util.Log;
import com.huawei.openalliance.ad.constant.x;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.umeng.commonsdk.utils.UMUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UMRTLog {
    private static final String RTLOG_ENABLE = "1";
    private static final String RTLOG_PROP = "debug.umeng.rtlog";
    public static final String RTLOG_TAG = "MobclickRT";

    private UMRTLog() {
    }

    private static boolean shouldOutput() {
        return "1".equals(UMUtils.getSystemProperty(RTLOG_PROP, "0"));
    }

    public static void e(String str, String str2) {
        if (shouldOutput()) {
            Log.e(str, warpperMsg(str2, false));
        }
    }

    public static void w(String str, String str2) {
        if (shouldOutput()) {
            Log.w(str, warpperMsg(str2, false));
        }
    }

    public static void i(String str, String str2) {
        if (shouldOutput()) {
            Log.i(str, warpperMsg(str2, false));
        }
    }

    public static void d(String str, String str2) {
        if (shouldOutput()) {
            Log.d(str, warpperMsg(str2, false));
        }
    }

    public static void v(String str, String str2) {
        if (shouldOutput()) {
            Log.v(str, warpperMsg(str2, false));
        }
    }

    public static void se(String str, String str2) {
        if (shouldOutput()) {
            Log.e(str, warpperMsg(str2, true));
        }
    }

    public static void sw(String str, String str2) {
        if (shouldOutput()) {
            Log.w(str, warpperMsg(str2, true));
        }
    }

    public static void si(String str, String str2) {
        if (shouldOutput()) {
            Log.i(str, warpperMsg(str2, true));
        }
    }

    public static void sd(String str, String str2) {
        if (shouldOutput()) {
            Log.d(str, warpperMsg(str2, true));
        }
    }

    public static void sv(String str, String str2) {
        if (shouldOutput()) {
            Log.v(str, warpperMsg(str2, true));
        }
    }

    private static String warpperMsg(String str, boolean z) {
        StringBuffer stringBuffer;
        if (!z) {
            return str;
        }
        try {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            if (stackTrace.length >= 3) {
                String fileName = stackTrace[2].getFileName();
                String methodName = stackTrace[2].getMethodName();
                int lineNumber = stackTrace[2].getLineNumber();
                stringBuffer = new StringBuffer();
                stringBuffer.append(SimpleComparison.LESS_THAN_OPERATION);
                stringBuffer.append(fileName);
                stringBuffer.append(x.bQ);
                stringBuffer.append(methodName);
                stringBuffer.append(x.bQ);
                stringBuffer.append(lineNumber);
                stringBuffer.append("> ");
                stringBuffer.append(str);
            } else {
                stringBuffer = null;
            }
            return stringBuffer.toString();
        } catch (Throwable unused) {
            return str;
        }
    }
}
