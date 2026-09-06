package com.opos.cmn.an.f;

import android.content.Context;
import com.opos.cmn.an.f.b.b;
import com.opos.cmn.an.f.b.c;
import com.opos.cmn.an.f.b.f;
import com.opos.cmn.an.f.b.g;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f5885a;
    private static final byte[] b = new byte[0];

    public static void a() {
        c.a();
    }

    public static void a(Context context, boolean z) {
        g.a(context, z);
    }

    public static void a(com.opos.cmn.an.f.a.b bVar) {
        if (bVar == null) {
            throw new NullPointerException("initParams is null.");
        }
        if (f5885a == null) {
            synchronized (b) {
                if (f5885a == null) {
                    f5885a = new f();
                    f5885a.a(bVar);
                }
            }
        }
    }

    public static void a(com.opos.cmn.an.f.a.c cVar, com.opos.cmn.an.f.a.a aVar) {
        if (f5885a != null) {
            f5885a.a(cVar, aVar);
        }
    }

    public static void a(String str, Object obj) {
        if (f5885a != null) {
            f5885a.a(str, obj);
        }
    }

    public static void a(String str, Object obj, Throwable th) {
        if (f5885a != null) {
            f5885a.a(str, obj, th);
        }
    }

    public static void a(String str, String str2) {
        if (f5885a != null) {
            f5885a.a(str, str2);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (f5885a != null) {
            f5885a.a(str, str2, th);
        }
    }

    public static void a(String str, Object... objArr) {
        if (f5885a != null) {
            f5885a.a(str, objArr);
        }
    }

    public static void a(boolean z) {
        com.opos.cmn.an.f.b.a.a(z);
    }

    public static boolean a(Context context) {
        return com.opos.cmn.an.f.b.a.a(context);
    }

    public static void b() {
        if (f5885a != null) {
            f5885a.a();
        }
    }

    public static void b(String str, Object obj) {
        if (f5885a != null) {
            f5885a.b(str, obj);
        }
    }

    public static void b(String str, String str2) {
        if (f5885a != null) {
            f5885a.b(str, str2);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        if (f5885a != null) {
            f5885a.b(str, str2, th);
        }
    }

    public static void b(String str, Object... objArr) {
        if (f5885a != null) {
            f5885a.b(str, objArr);
        }
    }

    public static synchronized boolean b(Context context) {
        return g.a(context);
    }

    public static void c(String str, String str2) {
        if (f5885a != null) {
            f5885a.c(str, str2);
        }
    }

    public static void c(String str, String str2, Throwable th) {
        if (f5885a != null) {
            f5885a.c(str, str2, th);
        }
    }

    public static void c(String str, Object... objArr) {
        if (f5885a != null) {
            f5885a.c(str, objArr);
        }
    }

    public static void d(String str, String str2) {
        if (f5885a != null) {
            f5885a.d(str, str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (f5885a != null) {
            f5885a.d(str, str2, th);
        }
    }

    public static void d(String str, Object... objArr) {
        if (f5885a != null) {
            f5885a.d(str, objArr);
        }
    }
}
