package com.opos.exoplayer.core.e;

import com.opos.exoplayer.core.z;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface e {

    public interface a {
        void a(e eVar, z zVar, Object obj);
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6391a;
        public final int b;
        public final int c;
        public final long d;

        public b(int i) {
            this(i, -1L);
        }

        public b(int i, int i2, int i3, long j) {
            this.f6391a = i;
            this.b = i2;
            this.c = i3;
            this.d = j;
        }

        public b(int i, long j) {
            this(i, -1, -1, j);
        }

        public b a(int i) {
            return this.f6391a == i ? this : new b(i, this.b, this.c, this.d);
        }

        public boolean a() {
            return this.b != -1;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.f6391a == bVar.f6391a && this.b == bVar.b && this.c == bVar.c && this.d == bVar.d;
        }

        public int hashCode() {
            return ((((((this.f6391a + 527) * 31) + this.b) * 31) + this.c) * 31) + ((int) this.d);
        }
    }

    d a(b bVar, com.opos.exoplayer.core.h.b bVar2);

    void a();

    void a(d dVar);

    void a(com.opos.exoplayer.core.i iVar, boolean z, a aVar);

    void b();
}
