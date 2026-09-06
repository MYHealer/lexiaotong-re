package com.qihoo.jiagu;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\93504.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f8455a = 2;

    public static void a(String str, String str2) {
        try {
            Class.forName("android.util.Log").getDeclaredMethod("e", String.class, String.class).invoke(null, str, str2);
        } catch (Throwable th) {
        }
    }
}
