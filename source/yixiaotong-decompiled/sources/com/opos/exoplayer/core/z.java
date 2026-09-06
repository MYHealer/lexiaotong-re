package com.opos.exoplayer.core;

import android.util.Pair;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f6569a = new c();

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6570a;
        public Object b;
        public int c;
        public long d;
        private long e;
        private com.opos.exoplayer.core.e.a.a f;

        public int a(int i, int i2) {
            return this.f.d[i].a(i2);
        }

        public int a(long j) {
            return this.f.a(j);
        }

        public long a() {
            return this.d;
        }

        public long a(int i) {
            return this.f.c[i];
        }

        public a a(Object obj, Object obj2, int i, long j, long j2) {
            return a(obj, obj2, i, j, j2, com.opos.exoplayer.core.e.a.a.f6387a);
        }

        public a a(Object obj, Object obj2, int i, long j, long j2, com.opos.exoplayer.core.e.a.a aVar) {
            this.f6570a = obj;
            this.b = obj2;
            this.c = i;
            this.d = j;
            this.e = j2;
            this.f = aVar;
            return this;
        }

        public int b(int i) {
            return this.f.d[i].a();
        }

        public int b(long j) {
            return this.f.b(j);
        }

        public long b() {
            return com.opos.exoplayer.core.b.a(this.e);
        }

        public boolean b(int i, int i2) {
            com.opos.exoplayer.core.e.a.a.C0918a c0918a = this.f.d[i];
            return (c0918a.f6388a == -1 || c0918a.c[i2] == 0) ? false : true;
        }

        public long c() {
            return this.e;
        }

        public long c(int i, int i2) {
            com.opos.exoplayer.core.e.a.a.C0918a c0918a = this.f.d[i];
            if (c0918a.f6388a != -1) {
                return c0918a.d[i2];
            }
            return -9223372036854775807L;
        }

        public boolean c(int i) {
            return !this.f.d[i].b();
        }

        public int d() {
            return this.f.b;
        }

        public int d(int i) {
            return this.f.d[i].f6388a;
        }

        public long e() {
            return this.f.e;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6571a;
        public long b;
        public long c;
        public boolean d;
        public boolean e;
        public int f;
        public int g;
        public long h;
        public long i;
        public long j;

        public long a() {
            return this.h;
        }

        public b a(Object obj, long j, long j2, boolean z, boolean z2, long j3, long j4, int i, int i2, long j5) {
            this.f6571a = obj;
            this.b = j;
            this.c = j2;
            this.d = z;
            this.e = z2;
            this.h = j3;
            this.i = j4;
            this.f = i;
            this.g = i2;
            this.j = j5;
            return this;
        }

        public long b() {
            return com.opos.exoplayer.core.b.a(this.i);
        }

        public long c() {
            return this.j;
        }
    }

    static class c extends z {
        c() {
        }

        @Override // com.opos.exoplayer.core.z
        public int a(Object obj) {
            return -1;
        }

        @Override // com.opos.exoplayer.core.z
        public a a(int i, a aVar, boolean z) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.opos.exoplayer.core.z
        public b a(int i, b bVar, boolean z, long j) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.opos.exoplayer.core.z
        public int b() {
            return 0;
        }

        @Override // com.opos.exoplayer.core.z
        public int c() {
            return 0;
        }
    }

    public int a(int i, int i2, boolean z) {
        if (i2 == 0) {
            if (i == a(z)) {
                return -1;
            }
            return i + 1;
        }
        if (i2 == 1) {
            return i;
        }
        if (i2 == 2) {
            return i == a(z) ? b(z) : i + 1;
        }
        throw new IllegalStateException();
    }

    public final int a(int i, a aVar, b bVar, int i2, boolean z) {
        int i3 = a(i, aVar).c;
        if (a(i3, bVar).g != i) {
            return i + 1;
        }
        int iA = a(i3, i2, z);
        if (iA == -1) {
            return -1;
        }
        return a(iA, bVar).f;
    }

    public abstract int a(Object obj);

    public int a(boolean z) {
        if (a()) {
            return -1;
        }
        return b() - 1;
    }

    public final Pair<Integer, Long> a(b bVar, a aVar, int i, long j) {
        return a(bVar, aVar, i, j, 0L);
    }

    public final Pair<Integer, Long> a(b bVar, a aVar, int i, long j, long j2) {
        com.opos.exoplayer.core.i.a.a(i, 0, b());
        a(i, bVar, false, j2);
        if (j == -9223372036854775807L) {
            j = bVar.a();
            if (j == -9223372036854775807L) {
                return null;
            }
        }
        int i2 = bVar.f;
        long jC = bVar.c() + j;
        while (true) {
            long jA = a(i2, aVar).a();
            if (jA == -9223372036854775807L || jC < jA || i2 >= bVar.g) {
                break;
            }
            jC -= jA;
            i2++;
        }
        return Pair.create(Integer.valueOf(i2), Long.valueOf(jC));
    }

    public final a a(int i, a aVar) {
        return a(i, aVar, false);
    }

    public abstract a a(int i, a aVar, boolean z);

    public final b a(int i, b bVar) {
        return a(i, bVar, false);
    }

    public final b a(int i, b bVar, boolean z) {
        return a(i, bVar, z, 0L);
    }

    public abstract b a(int i, b bVar, boolean z, long j);

    public final boolean a() {
        return b() == 0;
    }

    public abstract int b();

    public int b(int i, int i2, boolean z) {
        if (i2 == 0) {
            if (i == b(z)) {
                return -1;
            }
            return i - 1;
        }
        if (i2 == 1) {
            return i;
        }
        if (i2 == 2) {
            return i == b(z) ? a(z) : i - 1;
        }
        throw new IllegalStateException();
    }

    public int b(boolean z) {
        return a() ? -1 : 0;
    }

    public final boolean b(int i, a aVar, b bVar, int i2, boolean z) {
        return a(i, aVar, bVar, i2, z) == -1;
    }

    public abstract int c();
}
