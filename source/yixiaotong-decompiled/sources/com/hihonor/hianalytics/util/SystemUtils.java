package com.hihonor.hianalytics.util;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.Log;
import com.byazt.hv.TTDownloadField;
import com.hihonor.hianalytics.hnha.j2;
import com.hihonor.hianalytics.hnha.t3;
import com.stub.StubApp;
import com.yfanads.android.qapp.Val;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class SystemUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f3714a;
    private static Context b;
    private static Application c;
    private static final long d = SystemClock.elapsedRealtime();
    private static boolean e = true;
    private static boolean f = false;
    private static boolean g = false;

    static {
        new Thread(new Runnable() { // from class: com.hihonor.hianalytics.util.SystemUtils$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                SystemUtils.q();
            }
        }).start();
    }

    public static String a(String str) {
        return a(str, 0, 4);
    }

    public static String a(String str, int i, int i2) {
        int i3 = 0;
        int iMax = Math.max(0, i);
        int iMax2 = Math.max(i2, 4);
        int length = str == null ? 0 : str.length();
        if (length == 0 || j2.b()) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (length <= iMax2 + iMax) {
            while (i3 < length) {
                sb.append(i3 == length + (-1) ? str.charAt(i3) : '*');
                i3++;
            }
        } else {
            while (i3 < length) {
                sb.append((i3 < iMax || i3 > length - iMax2) ? str.charAt(i3) : '*');
                i3++;
            }
        }
        return sb.toString();
    }

    public static void a(Context context) {
        Context context2;
        if (context == null) {
            return;
        }
        if (context instanceof Application) {
            Application application = (Application) context;
            if (c == null) {
                c = application;
            }
            context2 = application;
            if (b != null) {
                return;
            }
        } else {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            if (origApplicationContext != null) {
                if ((origApplicationContext instanceof Application) && c == null) {
                    c = (Application) origApplicationContext;
                }
                if (b == null) {
                    b = origApplicationContext;
                    return;
                }
                return;
            }
            if (b != null) {
                context2 = context;
                return;
            }
        }
        context2 = context;
        b = context2;
    }

    public static void a(boolean z) {
        e = z;
    }

    public static boolean a() {
        return p() || l();
    }

    public static List<String> b() throws IllegalAccessException, InvocationTargetException {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        Context context = getContext();
        if (context == null) {
            j2.g("SystemUtils", "getAliveProcessList context null");
            return Collections.emptyList();
        }
        LinkedList linkedList = new LinkedList();
        try {
            Object systemService = context.getSystemService(TTDownloadField.TT_ACTIVITY);
            if ((systemService instanceof ActivityManager) && (runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses()) != null && !runningAppProcesses.isEmpty()) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (!linkedList.contains(runningAppProcessInfo.processName)) {
                        linkedList.add(runningAppProcessInfo.processName);
                    }
                }
                return linkedList;
            }
            return linkedList;
        } catch (Throwable th) {
            j2.g("SystemUtils", "getAliveProcessList size=" + linkedList.size() + ",failE=" + getDesensitizedException(th));
        }
    }

    public static boolean b(String str) throws IllegalAccessException, InvocationTargetException {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        StringBuilder sb;
        if (TextUtils.isEmpty(str)) {
            sb = new StringBuilder("isProcessAlive illegal processName=");
        } else {
            if (Objects.equals(str, getProcessName())) {
                return true;
            }
            Context context = getContext();
            if (context == null) {
                sb = new StringBuilder("isProcessAlive context null withName=");
            } else {
                try {
                    Object systemService = context.getSystemService(TTDownloadField.TT_ACTIVITY);
                    if ((systemService instanceof ActivityManager) && (runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses()) != null && !runningAppProcesses.isEmpty()) {
                        Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                        while (it.hasNext()) {
                            if (Objects.equals(it.next().processName, str)) {
                                return true;
                            }
                        }
                        return false;
                    }
                    return false;
                } catch (Throwable th) {
                    j2.g("SystemUtils", "isProcessAlive name=" + str + ",failE=" + getDesensitizedException(th));
                }
            }
        }
        j2.g("SystemUtils", sb.append(str).toString());
        return false;
    }

    private static void c() throws IllegalAccessException, InvocationTargetException {
        try {
            Class<?> cls = Class.forName(Val.AT);
            Object objInvoke = cls.getMethod("getApplication", new Class[0]).invoke(cls.getMethod(Val.CAT, new Class[0]).invoke(null, new Object[0]), new Object[0]);
            j2.a("SystemUtils", "getApplicationByReflect app=" + objInvoke);
            if (objInvoke instanceof Application) {
                Application application = (Application) objInvoke;
                if (c == null) {
                    c = application;
                }
                if (b == null) {
                    b = application;
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static String d() {
        return f3714a;
    }

    public static Context e() throws IllegalAccessException, InvocationTargetException {
        Context context = getContext();
        if (context == null) {
            return null;
        }
        return context.createDeviceProtectedStorageContext();
    }

    public static String f() {
        Context context = b;
        return context == null ? "" : context.getPackageName();
    }

    private static String g() {
        try {
            int iMyPid = Process.myPid();
            Object systemService = getContext().getSystemService(TTDownloadField.TT_ACTIVITY);
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = systemService instanceof ActivityManager ? ((ActivityManager) systemService).getRunningAppProcesses() : null;
            if (runningAppProcesses != null && !runningAppProcesses.isEmpty()) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo != null && runningAppProcessInfo.pid == iMyPid) {
                        return runningAppProcessInfo.processName;
                    }
                }
                return null;
            }
            return null;
        } catch (Throwable th) {
            Log.i("SystemUtils", "getProcessNameByAm exception,e=" + th);
        }
    }

    public static Application getApp() throws IllegalAccessException, InvocationTargetException {
        if (c == null) {
            c();
        }
        return c;
    }

    public static Context getContext() throws IllegalAccessException, InvocationTargetException {
        Context context = b;
        if (context != null) {
            return context;
        }
        Application application = c;
        if (application != null) {
            return application;
        }
        c();
        return b;
    }

    public static String getDesensitizedException(Throwable th) {
        if (th == null) {
            return "null Exception";
        }
        if (!(th instanceof IOException)) {
            String stackTraceString = Log.getStackTraceString(th);
            if (TextUtils.isEmpty(stackTraceString) || (!stackTraceString.contains("IOE") && !stackTraceString.contains("FileNotFound"))) {
                return stackTraceString;
            }
        }
        return th.getClass().getSimpleName();
    }

    public static String getProcessName() {
        StringBuilder sb;
        if (!TextUtils.isEmpty(f3714a)) {
            return f3714a;
        }
        String strH = h();
        if (strH == null || strH.trim().length() <= 0) {
            strH = g();
            if (strH == null || strH.trim().length() <= 0) {
                strH = i();
                if (strH == null || strH.trim().length() <= 0) {
                    return "";
                }
                f3714a = strH;
                sb = new StringBuilder("getProcessName thirdStepProcessName=");
            } else {
                f3714a = strH;
                sb = new StringBuilder("getProcessName secondStepProcessName=");
            }
        } else {
            f3714a = strH;
            sb = new StringBuilder("getProcessName firstStepProcessName=");
        }
        j2.c("SystemUtils", sb.append(strH).toString());
        return strH;
    }

    private static String h() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Application.getProcessName();
        }
        return null;
    }

    private static String i() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/cmdline"));
            try {
                String strTrim = bufferedReader.readLine().trim();
                k.a(bufferedReader);
                return strTrim;
            } catch (Throwable th) {
                th = th;
                try {
                    Log.i("SystemUtils", "getProcessNameByFile exception,e=" + getDesensitizedException(th));
                    return null;
                } finally {
                    k.a(bufferedReader);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
    }

    public static long j() {
        return SystemClock.elapsedRealtime() - d;
    }

    public static boolean k() {
        return e;
    }

    public static boolean l() throws IllegalAccessException, InvocationTargetException {
        if (g) {
            return true;
        }
        Context context = getContext();
        if (context == null) {
            j2.e("SystemUtils", "isDefaultToDeviceProtectedStorage context null");
            return false;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
            Method method = ApplicationInfo.class.getMethod("isDefaultToDeviceProtectedStorage", new Class[0]);
            method.setAccessible(true);
            Object objInvoke = method.invoke(applicationInfo, new Object[0]);
            boolean zBooleanValue = objInvoke instanceof Boolean ? ((Boolean) objInvoke).booleanValue() : false;
            j2.a("SystemUtils", "isDefaultToDeviceProtectedStorage object=" + objInvoke + ",isDefault=" + zBooleanValue);
            if (!zBooleanValue) {
                return g;
            }
            g = true;
            return true;
        } catch (Throwable th) {
            j2.c("SystemUtils", "isDefaultToDeviceProtectedStorage failEx=" + getDesensitizedException(th));
            try {
                Context contextE = e();
                if (contextE == null) {
                    j2.g("SystemUtils", "isDefaultToDeviceProtectedStorage protectedContext null");
                    return false;
                }
                String canonicalPath = context.getFilesDir().getCanonicalPath();
                String canonicalPath2 = contextE.getFilesDir().getCanonicalPath();
                j2.a("SystemUtils", "isDefaultToDeviceProtectedStorage filePath=" + canonicalPath + ",protectedFilePath=" + canonicalPath2);
                if (Objects.equals(canonicalPath, canonicalPath2)) {
                    g = true;
                    return true;
                }
                return g;
            } catch (Throwable th2) {
                j2.g("SystemUtils", "isDefaultToDeviceProtectedStorage failEx2=" + getDesensitizedException(th2));
            }
        }
    }

    public static boolean m() {
        return true;
    }

    public static boolean n() {
        return false;
    }

    public static boolean o() {
        return false;
    }

    public static boolean p() throws IllegalAccessException, InvocationTargetException {
        if (f) {
            return true;
        }
        Context context = getContext();
        if (context == null) {
            j2.e("SystemUtils", "isUserUnLock context null");
            return false;
        }
        try {
            UserManager userManager = (UserManager) context.getSystemService("user");
            if (userManager != null) {
                f = userManager.isUserUnlocked();
            } else {
                j2.e("SystemUtils", "isUserUnLock userManager null");
            }
        } catch (Throwable th) {
            j2.e("SystemUtils", "isUserUnLock failEx=" + getDesensitizedException(th));
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void q() {
        getProcessName();
        t3.d();
    }
}
