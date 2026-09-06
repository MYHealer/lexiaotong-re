package com.opos.exoplayer.core.c;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface l {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final m f6370a;
        public final m b;

        public a(m mVar) {
            this(mVar, mVar);
        }

        public a(m mVar, m mVar2) {
            this.f6370a = (m) com.opos.exoplayer.core.i.a.a(mVar);
            this.b = (m) com.opos.exoplayer.core.i.a.a(mVar2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f6370a.equals(aVar.f6370a) && this.b.equals(aVar.b);
        }

        public int hashCode() {
            return (this.f6370a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            return "[" + this.f6370a + (this.f6370a.equals(this.b) ? "" : ", " + this.b) + "]";
        }
    }

    public static final class b implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f6371a;
        private final a b;

        public b(long j) {
            this(j, 0L);
        }

        public b(long j, long j2) {
            this.f6371a = j;
            this.b = new a(j2 == 0 ? m.f6372a : new m(0L, j2));
        }

        @Override // com.opos.exoplayer.core.c.l
        public boolean a() {
            return false;
        }

        @Override // com.opos.exoplayer.core.c.l
        public long b() {
            return this.f6371a;
        }

        @Override // com.opos.exoplayer.core.c.l
        public a b(long j) {
            return this.b;
        }
    }

    boolean a();

    long b();

    a b(long j);
}
