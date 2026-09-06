package com.qq.e.comm.managers.plugin;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f8505a;
    private static boolean b;

    private static void a(Throwable th) throws Throwable {
        if (b) {
            return;
        }
        if (f8505a == null) {
            Method declaredMethod = Class.forName("com.tencent.bugly.crashreport.CrashReport").getDeclaredMethod("postCatchedException", Throwable.class);
            f8505a = declaredMethod;
            declaredMethod.setAccessible(true);
        }
        f8505a.invoke(null, th);
    }

    public static void a(Throwable th, String str) {
        try {
            a(new Exception("插件错误：" + str, th));
        } catch (Throwable unused) {
            b = true;
        }
    }
}
