package com.kuaishou.weapon.p0;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ao {
    public boolean a() {
        try {
            Field declaredField = ClassLoader.getSystemClassLoader().loadClass(an.b).getDeclaredField("disableHooks");
            declaredField.setAccessible(true);
            declaredField.set(null, Boolean.TRUE);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean b() {
        try {
            throw new Exception("");
        } catch (Exception e) {
            for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                if (stackTraceElement.getClassName().contains(an.b)) {
                    return true;
                }
            }
            return false;
        }
    }

    public boolean c() {
        return a(an.c);
    }

    private boolean a(String str) {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        if (systemClassLoader != null) {
            try {
                systemClassLoader.loadClass(str).newInstance();
            } catch (ClassNotFoundException unused) {
                return false;
            } catch (IllegalAccessException | InstantiationException unused2) {
            }
        }
        return true;
    }

    public boolean d() {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        if (systemClassLoader != null) {
            try {
                systemClassLoader.loadClass(an.f4626a).newInstance();
            } catch (ClassNotFoundException unused) {
                return false;
            } catch (IllegalAccessException | InstantiationException unused2) {
                return true;
            }
        }
        if (systemClassLoader != null) {
            try {
                systemClassLoader.loadClass(an.b).newInstance();
            } catch (ClassNotFoundException unused3) {
                return false;
            } catch (IllegalAccessException | InstantiationException unused4) {
            }
        }
        return true;
    }

    public String e() {
        try {
            return System.getProperty("vxp");
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean f() {
        try {
            String str = System.getenv("CLASSPATH");
            return !TextUtils.isEmpty(str) && str.contains("XposedBridge");
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean g() {
        try {
            return Modifier.isNative(Throwable.class.getDeclaredMethod("getStackTrace", new Class[0]).getModifiers());
        } catch (NoSuchMethodException unused) {
            return false;
        }
    }
}
