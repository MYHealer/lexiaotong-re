package com.kuaishou.weapon.p0;

import android.os.Build;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class co {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static co f4677a;
    static co b;
    static co c;
    private long d;
    private a e;

    public long a() {
        return this.d;
    }

    public void a(long j) {
        this.d = j;
    }

    public void a(a aVar) {
        this.e = aVar;
    }

    public a b() {
        return this.e;
    }

    static {
        c();
    }

    enum a {
        DWORD(4),
        QWORD(8);

        int c;

        a(int i) {
            this.c = i;
        }
    }

    private static void c() {
        f4677a = new co();
        b = new co();
        c = new co();
        b.a(a.DWORD);
        int i = Build.VERSION.SDK_INT;
        if (cp.a()) {
            f4677a.a(a.QWORD);
            c.a(a.QWORD);
            switch (i) {
                case 26:
                case 27:
                    f4677a.a(40L);
                    c.a(32L);
                    b.a(4L);
                    return;
                case 28:
                case 29:
                    f4677a.a(32L);
                    c.a(24L);
                    b.a(4L);
                    return;
                default:
                    throw new RuntimeException("API LEVEL: " + i + " is not supported now : (");
            }
        }
        f4677a.a(a.DWORD);
        c.a(a.DWORD);
        switch (i) {
            case 26:
            case 27:
                f4677a.a(28L);
                c.a(24L);
                b.a(4L);
                return;
            case 28:
            case 29:
                f4677a.a(24L);
                c.a(20L);
                b.a(4L);
                return;
            default:
                throw new RuntimeException("API LEVEL: " + i + " is not supported now : (");
        }
    }
}
