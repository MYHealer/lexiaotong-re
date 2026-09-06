package com.hihonor.adsdk.base.j;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.g.j.d.x;
import java.lang.reflect.UndeclaredThrowableException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a implements Thread.UncaughtExceptionHandler {
    public static final String hnadsc = "CrashHandler";
    private static final String hnadsd = "com.hihonor.adsdk";
    private Thread.UncaughtExceptionHandler hnadsa;
    private String hnadsb;

    /* JADX INFO: renamed from: com.hihonor.adsdk.base.j.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0441a {
    }

    private static class b {
        private static final a hnadsa = new a(null);

        private b() {
        }
    }

    /* synthetic */ a(C0441a c0441a) {
        this();
    }

    private boolean hnadsa(Thread thread) {
        com.hihonor.adsdk.common.b.b.hnadse(hnadsc, "Java Crash Happen cause by %s(%d)", thread.getName(), Long.valueOf(thread.getId()));
        String str = thread.getName() + thread.getId();
        String str2 = this.hnadsb;
        if (str2 != null && TextUtils.equals(str2, str)) {
            return true;
        }
        this.hnadsb = str;
        return false;
    }

    public static a hnadsb() {
        return b.hnadsa;
    }

    public void hnadsc() {
        try {
            if (!(Thread.getDefaultUncaughtExceptionHandler() instanceof a)) {
                this.hnadsa = Thread.getDefaultUncaughtExceptionHandler();
            }
            Thread.setDefaultUncaughtExceptionHandler(this);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsc, "init has Exception " + e.getMessage(), new Object[0]);
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            if (th instanceof UndeclaredThrowableException) {
                com.hihonor.adsdk.common.b.b.hnadse(hnadsc, "throwable is not UndeclaredThrowableException", new Object[0]);
                return;
            }
            if (hnadsa(thread)) {
                hnadsa();
                return;
            }
            hnadsb(th);
            if (this.hnadsa == null) {
                com.hihonor.adsdk.common.b.b.hnadse(hnadsc, "mDefaultHandler is null", new Object[0]);
                return;
            }
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsc, "thread: " + thread.getName(), new Object[0]);
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.hnadsa;
            if (uncaughtExceptionHandler == this || (uncaughtExceptionHandler instanceof a)) {
                return;
            }
            if (hnadsa(uncaughtExceptionHandler)) {
                hnadsa();
            } else {
                this.hnadsa.uncaughtException(thread, th);
            }
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsc, "uncaughtException has exception: " + e.getMessage(), new Object[0]);
        }
    }

    private a() {
    }

    private void hnadsb(Throwable th) {
        if (!HnAds.get().isInitialized()) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsc, "uploadExceptionToServer error sdk has not init", new Object[0]);
            return;
        }
        String strHnadsa = hnadsa(th);
        if (!hnadsa(strHnadsa)) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsc, "do not shouldReport.", new Object[0]);
        } else {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsc, "do report.", new Object[0]);
            new x("", com.hihonor.adsdk.base.g.j.g.b.hnadsb(), ErrorCode.AD_CRASH_CODE, strHnadsa).hnadse();
        }
    }

    private void hnadsa() {
        com.hihonor.adsdk.common.b.b.hnadsb(hnadsc, "current process die", new Object[0]);
        Process.killProcess(Process.myPid());
        System.exit(1);
    }

    private boolean hnadsa(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        if (uncaughtExceptionHandler == null) {
            return true;
        }
        String name = uncaughtExceptionHandler.getClass().getName();
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            if (name.equals(className) && "uncaughtException".equals(methodName)) {
                com.hihonor.adsdk.common.b.b.hnadse(hnadsc, name + " has invoke uncaughtException() method", new Object[0]);
                return true;
            }
        }
        return false;
    }

    private String hnadsa(Throwable th) {
        return Log.getStackTraceString(th);
    }

    private boolean hnadsa(String str) {
        com.hihonor.adsdk.common.b.b.hnadse(hnadsc, "stackTrackInfo=" + str, new Object[0]);
        if (!TextUtils.isEmpty(str) && str.contains(hnadsd)) {
            try {
                return Integer.parseInt("300") >= 300;
            } catch (Exception e) {
                com.hihonor.adsdk.common.b.b.hnadse(hnadsc, "shouldReport() error : " + e.getMessage(), new Object[0]);
            }
        } else {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsc, "stackTrackInfo is null or don't have adsdk package.", new Object[0]);
            return false;
        }
    }
}
