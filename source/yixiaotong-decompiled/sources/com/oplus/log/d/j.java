package com.oplus.log.d;

import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f5823a = false;
    private static String b = "ReflectHelp";

    public static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable th) {
            if (f5823a) {
                Log.w(b, "reflect:" + th.getMessage());
            }
            return null;
        }
    }

    public static Object a(Class cls, String str, Class[] clsArr, Object[] objArr) {
        if (cls != null && !TextUtils.isEmpty(str)) {
            try {
                Method methodA = a(cls, str, clsArr);
                if (methodA != null) {
                    methodA.setAccessible(true);
                    return methodA.invoke(null, objArr);
                }
            } catch (Throwable th) {
                if (f5823a) {
                    Log.w(b, "reflect:" + th.getMessage());
                }
            }
        }
        return null;
    }

    private static Method a(Class cls, String str, Class[] clsArr) {
        if (cls != null && !TextUtils.isEmpty(str)) {
            try {
                try {
                    return cls.getDeclaredMethod(str, clsArr);
                } catch (Exception unused) {
                    return cls.getMethod(str, clsArr);
                }
            } catch (Exception unused2) {
                if (cls.getSuperclass() != null) {
                    return a(cls.getSuperclass(), str, clsArr);
                }
            }
        }
        return null;
    }
}
