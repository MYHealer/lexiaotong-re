package com.yfanads.android.upload;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.yfanads.android.YFAdsManager;
import com.yfanads.android.libs.utils.DeviceUtils;
import com.yfanads.android.libs.utils.Util;
import com.yfanads.android.model.YFAdsPhone;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: YFCrashHandler.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class f implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Thread.UncaughtExceptionHandler f9689a;
    public static volatile boolean b;
    public static String c;
    public static String d;
    public static boolean e;

    public f() {
        a();
    }

    public static void a() {
        try {
            Context context = YFAdsManager.getInstance().getContext();
            c = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
            d = TextUtils.isEmpty(DeviceUtils.getCacheOAID()) ? DeviceUtils.getClientId() : DeviceUtils.getCacheOAID();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) throws Throwable {
        PrintWriter printWriter;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        String message;
        try {
            boolean z = b.e;
            b.a.f9685a.a(YFAdsConst.ReportETypeValue.APP_CRASH.getValue(), "");
        } catch (Exception e2) {
            com.yfanads.android.core.f.a(e2, new StringBuilder("report crash "));
        }
        PrintWriter printWriter2 = null;
        try {
            try {
                Context context = YFAdsManager.getInstance().getContext();
                File file = new File(context.getCacheDir(), "yfcrash_info");
                if (!file.exists()) {
                    file.mkdirs();
                }
                printWriter = new PrintWriter(new FileWriter(new File(file, a(a(th)))));
                try {
                    printWriter.println("time: " + System.currentTimeMillis());
                    printWriter.println("thread: " + thread.getName());
                    th.printStackTrace(printWriter);
                    printWriter.println(a(context));
                    printWriter.flush();
                    Util.closeIO(printWriter);
                } catch (Exception e3) {
                    e = e3;
                    printWriter2 = printWriter;
                    YFLog.error("uncaughtException " + e.getMessage());
                    if (printWriter2 != null) {
                        Util.closeIO(printWriter2);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (printWriter != null) {
                        Util.closeIO(printWriter);
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
            }
            try {
                if (((th instanceof InternalError) && (message = th.getMessage()) != null && message.contains("Thread starting during runtime shutdown")) || (uncaughtExceptionHandler = f9689a) == null) {
                    return;
                }
                uncaughtExceptionHandler.uncaughtException(thread, th);
            } catch (Exception e5) {
                com.yfanads.android.core.f.a(e5, new StringBuilder("default uncaught system "));
            }
        } catch (Throwable th3) {
            th = th3;
            printWriter = printWriter2;
        }
    }

    public static boolean a(Throwable th) {
        if (th == null) {
            return false;
        }
        if (th.toString().contains("yfanads") || th.getClass().getName().contains("yfanads")) {
            return true;
        }
        if (th.getMessage() != null && th.getMessage().contains("yfanads")) {
            return true;
        }
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            if (stackTraceElement.getClassName().contains("yfanads")) {
                return true;
            }
        }
        return th.getCause() != null && a(th.getCause());
    }

    public static String a(boolean z) {
        return c + "_" + d + "_" + new SimpleDateFormat("MM-dd HH_mm_ss", Locale.getDefault()).format(new Date()) + "_crash.log" + (z ? ".yf" : ".app");
    }

    public static String a(Context context) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 1);
        StringBuilder sb = new StringBuilder("SDK Version: ");
        sb.append(YFAdsPhone.getInstance().getSDKVersion()).append("\nApp Version: ");
        sb.append(packageInfo.versionName);
        sb.append("_");
        sb.append(packageInfo.versionCode).append("\nOS Version: ");
        sb.append(Build.VERSION.RELEASE);
        sb.append("_");
        sb.append(Build.VERSION.SDK_INT).append("\nVendor: ");
        sb.append(Build.MANUFACTURER).append("\nModel: ");
        sb.append(Build.MODEL).append(IOUtils.LINE_SEPARATOR_UNIX);
        return sb.toString();
    }
}
