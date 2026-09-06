package com.oplus.log.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static SimpleDateFormat f5814a = new SimpleDateFormat("yyyy-MM-dd");

    public static long a() {
        try {
            return f5814a.parse(f5814a.format(new Date(System.currentTimeMillis()))).getTime();
        } catch (Exception e) {
            if (com.oplus.log.b.c()) {
                e.printStackTrace();
            }
            return 0L;
        }
    }

    public static boolean a(String str, Class cls) {
        try {
            ClassLoader classLoader = cls.getClassLoader();
            Method declaredMethod = Runtime.getRuntime().getClass().getDeclaredMethod("loadLibrary0", ClassLoader.class, String.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(Runtime.getRuntime(), classLoader, str);
            return true;
        } catch (IllegalAccessException e) {
            if (!com.oplus.log.b.c()) {
                return false;
            }
            e.printStackTrace();
            return false;
        } catch (NoSuchMethodException e2) {
            if (!com.oplus.log.b.c()) {
                return false;
            }
            e2.printStackTrace();
            return false;
        } catch (InvocationTargetException e3) {
            if (!com.oplus.log.b.c()) {
                return false;
            }
            e3.printStackTrace();
            return false;
        } catch (Throwable th) {
            if (!com.oplus.log.b.c()) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }
}
