package com.opos.exoplayer.core;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f6566a;
    public static final x b;
    public static final x c;
    public static final x d;
    public static final x e;
    public final long f;
    public final long g;

    static {
        x xVar = new x(0L, 0L);
        f6566a = xVar;
        b = new x(Long.MAX_VALUE, Long.MAX_VALUE);
        c = new x(Long.MAX_VALUE, 0L);
        d = new x(0L, Long.MAX_VALUE);
        e = xVar;
    }

    public x(long j, long j2) {
        com.opos.exoplayer.core.i.a.a(j >= 0);
        com.opos.exoplayer.core.i.a.a(j2 >= 0);
        this.f = j;
        this.g = j2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || x.class != obj.getClass()) {
            return false;
        }
        x xVar = (x) obj;
        return this.f == xVar.f && this.g == xVar.g;
    }

    public int hashCode() {
        return (((int) this.f) * 31) + ((int) this.g);
    }
}
