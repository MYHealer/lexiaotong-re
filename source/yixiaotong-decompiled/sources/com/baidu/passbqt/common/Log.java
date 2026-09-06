package com.baidu.passbqt.common;

import com.baidu.passbqt.NoProguard;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class Log implements NoProguard {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1920a = "PASSPORT";
    public static boolean b;

    public static void a(boolean z) {
        b = z;
    }

    private Log() {
    }

    public static void a(String str, Object... objArr) {
        if (b) {
            android.util.Log.d(str, e(str, objArr));
        }
    }

    public static void a(Object... objArr) {
        a(f1920a, objArr);
    }

    public static void b(String str, Object... objArr) {
        if (b) {
            android.util.Log.i(str, e(str, objArr));
        }
    }

    public static void b(Object... objArr) {
        b(f1920a, objArr);
    }

    public static void c(String str, Object... objArr) {
        if (b) {
            android.util.Log.w(str, e(str, objArr));
        }
    }

    public static void c(Object... objArr) {
        c(f1920a, objArr);
    }

    public static void a(Throwable th) {
        a(f1920a, th);
    }

    public static void a(String str, Throwable th) {
        d(str, th);
    }

    public static void d(String str, Object... objArr) {
        if (b) {
            android.util.Log.e(str, e(str, objArr));
        }
    }

    private static String e(String str, Object[] objArr) {
        if (objArr == null) {
            return "";
        }
        try {
            if (objArr.length == 0) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            int length = objArr.length;
            for (int i = 0; i < length; i++) {
                Object obj = objArr[i];
                if (obj != null) {
                    if (i != 0) {
                        stringBuffer.append("|");
                    }
                    try {
                        if (obj instanceof Throwable) {
                            stringBuffer.append(android.util.Log.getStackTraceString((Throwable) obj));
                        } else {
                            stringBuffer.append(obj.toString());
                        }
                    } catch (Exception unused) {
                    }
                }
            }
            str = stringBuffer.toString();
            return str;
        } catch (Throwable th) {
            android.util.Log.e(str, "converArrayToString t: " + th.toString());
            return "converArrayToString null";
        }
    }
}
