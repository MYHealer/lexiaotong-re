package com.bytedance.pangle.log;

import android.text.TextUtils;
import com.byazt.bog.a;
import com.bytedance.pangle.GlobalParam;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class ZeusLogger {
    public static final String TAG = "Zeus_pangle";
    public static final String TAG_ACTIVITY = "Zeus/activity_pangle";
    public static final String TAG_DOWNLOAD = "Zeus/download_pangle";
    public static final String TAG_INIT = "Zeus/init_pangle";
    public static final String TAG_INSTALL = "Zeus/install_pangle";
    public static final String TAG_LOAD = "Zeus/load_pangle";
    public static final String TAG_PAM = "Zeus/pam_pangle";
    public static final String TAG_PPM = "Zeus/ppm_pangle";
    public static final String TAG_PROVIDER = "Zeus/provider_pangle";
    public static final String TAG_RECEIVER = "Zeus/receiver_pangle";
    public static final String TAG_REPORTER = "Zeus/reporter_pangle";
    public static final String TAG_RESOURCES = "Zeus/resources_pangle";
    public static final String TAG_SERVER = "Zeus/server_pangle";
    public static final String TAG_SERVICE = "Zeus/service_pangle";
    public static final String TAG_SO = "Zeus/so_pangle";
    public static boolean sDebug = true;
    public static boolean sEnableTrace;

    public static boolean isDebug() {
        return sDebug;
    }

    public static boolean isEnableTrace() {
        return sEnableTrace;
    }

    public static void setDebug(boolean z) {
        sDebug = z;
    }

    public static void setEnableTrace(boolean z) {
        sEnableTrace = z;
    }

    public static void v(String str) {
        v(null, str);
    }

    public static void v(String str, String str2) {
        String strPrefixTraceInfo = prefixTraceInfo(str2);
        GlobalParam.getInstance().getReporter().c(str, strPrefixTraceInfo);
        if (sDebug) {
            a.c(str, strPrefixTraceInfo);
        } else if (GlobalParam.getInstance().getLogger() != null) {
            GlobalParam.getInstance().getLogger().v(str, strPrefixTraceInfo);
        }
    }

    public static void d(String str) {
        d(null, str);
    }

    public static void d(String str, String str2) {
        i(str, str2);
    }

    public static void i(String str) {
        i(null, str);
    }

    public static void i(String str, String str2) {
        String strPrefixTraceInfo = prefixTraceInfo(str2);
        GlobalParam.getInstance().getReporter().c(str, strPrefixTraceInfo);
        if (sDebug) {
            a.ve(str, strPrefixTraceInfo);
        } else if (GlobalParam.getInstance().getLogger() != null) {
            GlobalParam.getInstance().getLogger().i(str, strPrefixTraceInfo);
        }
    }

    public static void w(String str) {
        w(null, str);
    }

    public static void w(String str, String str2) {
        String strPrefixTraceInfo = prefixTraceInfo(str2);
        GlobalParam.getInstance().getReporter().c(str, strPrefixTraceInfo);
        if (sDebug) {
            a.uj(str, strPrefixTraceInfo);
        } else if (GlobalParam.getInstance().getLogger() != null) {
            GlobalParam.getInstance().getLogger().w(str, strPrefixTraceInfo);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        String strPrefixTraceInfo = prefixTraceInfo(str2);
        GlobalParam.getInstance().getReporter().c(str, strPrefixTraceInfo + " ; " + th);
        if (sDebug) {
            a.uj(str, strPrefixTraceInfo, th);
        } else if (GlobalParam.getInstance().getLogger() != null) {
            GlobalParam.getInstance().getLogger().w(str, strPrefixTraceInfo, th);
        }
    }

    public static void errReport(String str, String str2) {
        RuntimeException runtimeException = new RuntimeException();
        StackTraceElement[] stackTrace = runtimeException.getStackTrace();
        runtimeException.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, 1, stackTrace.length - 1));
        errReport(str, str2, runtimeException, false);
    }

    public static void errReport(String str, String str2, Throwable th) {
        errReport(str, str2, th, true);
    }

    private static void errReport(String str, String str2, Throwable th, boolean z) {
        GlobalParam.getInstance().getReporter().c(str, str2 + " ; " + th);
        if (sDebug) {
            if (!z) {
                th = null;
            }
            a.n(str, str2, th);
        } else if (GlobalParam.getInstance().getLogger() != null) {
            IZeusLogger logger = GlobalParam.getInstance().getLogger();
            if (!z) {
                th = null;
            }
            logger.e(str, str2, th);
        }
    }

    private static String prefixTraceInfo(String str) {
        return sEnableTrace ? str + getTraceInfo() : str;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002a A[Catch: Exception -> 0x0044, TRY_LEAVE, TryCatch #0 {Exception -> 0x0044, blocks: (B:3:0x0002, B:4:0x000c, B:6:0x000f, B:8:0x0021, B:12:0x002a, B:9:0x0024), top: B:17:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:21:? A[RETURN, SYNTHETIC] */
    private static String getTraceInfo() {
        StackTraceElement stackTraceElement;
        try {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            for (int i = 1; i < stackTrace.length; i++) {
                if (!TextUtils.equals(stackTrace[i].getClassName(), ZeusLogger.class.getName())) {
                    stackTraceElement = stackTrace[i];
                    if (stackTraceElement != null) {
                        return "\t\t[" + stackTraceElement.toString() + "]";
                    }
                    return "\t\t[No Trace Info]";
                }
            }
            stackTraceElement = null;
            if (stackTraceElement != null) {
                return "\t\t[" + stackTraceElement.toString() + "]";
            }
            return "\t\t[No Trace Info]";
        } catch (Exception e) {
            a.c(e);
            return "\t\t[No Trace Info]";
        }
    }
}
