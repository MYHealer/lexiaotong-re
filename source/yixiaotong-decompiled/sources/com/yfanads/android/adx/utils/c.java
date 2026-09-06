package com.yfanads.android.adx.utils;

import android.telephony.TelephonyManager;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: ReflectionUtils.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Method f9623a;
    public static final Method b;
    public static final Method c;

    static {
        try {
            f9623a = Class.class.getDeclaredMethod("forName", String.class);
            b = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            c = Class.class.getDeclaredMethod("getDeclaredField", String.class);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean a() {
        return (f9623a == null || b == null || c == null) ? false : true;
    }

    public static Object a(TelephonyManager telephonyManager, Class[] clsArr, Object... objArr) {
        Method method;
        try {
            if (a()) {
                try {
                    method = (Method) b.invoke((Class) f9623a.invoke(null, "android.telephony.TelephonyManager"), "getServiceStateForSubscriber", clsArr);
                    try {
                        method.setAccessible(true);
                    } catch (Throwable th) {
                        th = th;
                        th.printStackTrace();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    method = null;
                }
            } else {
                method = null;
            }
            if (method != null) {
                return method.invoke(telephonyManager, objArr);
            }
            return null;
        } catch (Throwable th3) {
            th3.printStackTrace();
            return null;
        }
    }
}
