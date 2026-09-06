package com.baidu.oauth.sdkbqt.a;

import android.util.Log;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1860a = "oauth_";
    public static boolean b;

    public static void a(boolean z) {
        b = z;
    }

    private d() {
    }

    public static void a(String str, Object... objArr) {
        if (b) {
            Log.d(f1860a + str, e(str, objArr));
        }
    }

    public static void a(Object... objArr) {
        a(f1860a, objArr);
    }

    public static void b(String str, Object... objArr) {
        if (b) {
            Log.i(f1860a + str, e(str, objArr));
        }
    }

    public static void b(Object... objArr) {
        b(f1860a, objArr);
    }

    public static void c(String str, Object... objArr) {
        if (b) {
            Log.w(f1860a + str, e(str, objArr));
        }
    }

    public static void c(Object... objArr) {
        c(f1860a, objArr);
    }

    public static void a(Throwable th) {
        a(f1860a, th);
    }

    public static void a(String str, Throwable th) {
        d(str, th);
    }

    public static void d(String str, Object... objArr) {
        if (b) {
            Log.e(f1860a + str, e(str, objArr));
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
                            stringBuffer.append(Log.getStackTraceString((Throwable) obj));
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
            Log.e(str, "converArrayToString t: " + th.toString());
            return "converArrayToString null";
        }
    }
}
