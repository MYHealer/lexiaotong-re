package com.kuaishou.weapon.p0;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class cp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f4679a = false;
    private static volatile boolean b = true;

    public static boolean a() {
        return f4679a;
    }

    public static boolean b() {
        return b;
    }

    static {
        try {
            f4679a = ((Boolean) Class.forName("dalvik.system.VMRuntime").getDeclaredMethod("is64Bit", new Class[0]).invoke(Class.forName("dalvik.system.VMRuntime").getDeclaredMethod("getRuntime", new Class[0]).invoke(null, new Object[0]), new Object[0])).booleanValue();
        } catch (Exception unused) {
            f4679a = false;
        }
        b = System.getProperty("java.vm.version").startsWith("2");
    }
}
