package com.opos.videocache;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class f {
    public static <T> T a(T t) {
        t.getClass();
        return t;
    }

    public static <T> T a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    static void a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    static void a(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void a(Object... objArr) {
        for (Object obj : objArr) {
            obj.getClass();
        }
    }
}
