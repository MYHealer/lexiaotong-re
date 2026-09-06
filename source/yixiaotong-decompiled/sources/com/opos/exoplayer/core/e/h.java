package com.opos.exoplayer.core.e;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.i.p;
import java.io.EOFException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class h implements com.opos.exoplayer.core.c.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.opos.exoplayer.core.h.b f6400a;
    private final int b;
    private final g c;
    private final g.a d;
    private final p e;
    private b f;
    private b g;
    private b h;
    private Format i;
    private boolean j;
    private Format k;
    private long l;
    private long m;
    private boolean n;
    private a o;

    public interface a {
        void a(Format format);
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f6401a;
        public final long b;
        public boolean c;
        public com.opos.exoplayer.core.h.a d;
        public b e;

        public b(long j, int i) {
            this.f6401a = j;
            this.b = j + ((long) i);
        }

        public int a(long j) {
            return ((int) (j - this.f6401a)) + this.d.b;
        }

        public b a() {
            this.d = null;
            b bVar = this.e;
            this.e = null;
            return bVar;
        }

        public void a(com.opos.exoplayer.core.h.a aVar, b bVar) {
            this.d = aVar;
            this.e = bVar;
            this.c = true;
        }
    }

    public h(com.opos.exoplayer.core.h.b bVar) {
        this.f6400a = bVar;
        int iC = bVar.c();
        this.b = iC;
        this.c = new g();
        this.d = new g.a();
        this.e = new p(32);
        b bVar2 = new b(0L, iC);
        this.f = bVar2;
        this.g = bVar2;
        this.h = bVar2;
    }

    private int a(int i) {
        b bVar = this.h;
        if (!bVar.c) {
            bVar.a(this.f6400a.a(), new b(this.h.b, this.b));
        }
        return Math.min(i, (int) (this.h.b - this.m));
    }

    private static Format a(Format format, long j) {
        if (format == null) {
            return null;
        }
        if (j == 0) {
            return format;
        }
        long j2 = format.w;
        return j2 != Long.MAX_VALUE ? format.a(j2 + j) : format;
    }

    private void a(long j) {
        while (true) {
            b bVar = this.g;
            if (j < bVar.b) {
                return;
            } else {
                this.g = bVar.e;
            }
        }
    }

    private void a(long j, ByteBuffer byteBuffer, int i) {
        a(j);
        while (i > 0) {
            int iMin = Math.min(i, (int) (this.g.b - j));
            b bVar = this.g;
            byteBuffer.put(bVar.d.f6478a, bVar.a(j), iMin);
            i -= iMin;
            j += (long) iMin;
            b bVar2 = this.g;
            if (j == bVar2.b) {
                this.g = bVar2.e;
            }
        }
    }

    private void a(long j, byte[] bArr, int i) {
        a(j);
        int i2 = i;
        while (i2 > 0) {
            int iMin = Math.min(i2, (int) (this.g.b - j));
            b bVar = this.g;
            System.arraycopy(bVar.d.f6478a, bVar.a(j), bArr, i - i2, iMin);
            i2 -= iMin;
            j += (long) iMin;
            b bVar2 = this.g;
            if (j == bVar2.b) {
                this.g = bVar2.e;
            }
        }
    }

    private void a(com.opos.exoplayer.core.b.e eVar, g.a aVar) {
        long j = aVar.b;
        int iH = 1;
        this.e.a(1);
        a(j, this.e.f6510a, 1);
        long j2 = j + 1;
        byte b2 = this.e.f6510a[0];
        boolean z = (b2 & 128) != 0;
        int i = b2 & 127;
        com.opos.exoplayer.core.b.b bVar = eVar.f6275a;
        if (bVar.f6272a == null) {
            bVar.f6272a = new byte[16];
        }
        a(j2, eVar.f6275a.f6272a, i);
        long j3 = j2 + ((long) i);
        if (z) {
            this.e.a(2);
            a(j3, this.e.f6510a, 2);
            j3 += 2;
            iH = this.e.h();
        }
        int i2 = iH;
        int[] iArr = eVar.f6275a.d;
        if (iArr == null || iArr.length < i2) {
            iArr = new int[i2];
        }
        int[] iArr2 = iArr;
        int[] iArr3 = eVar.f6275a.e;
        if (iArr3 == null || iArr3.length < i2) {
            iArr3 = new int[i2];
        }
        int[] iArr4 = iArr3;
        if (z) {
            int i3 = i2 * 6;
            this.e.a(i3);
            a(j3, this.e.f6510a, i3);
            j3 += (long) i3;
            this.e.c(0);
            for (int i4 = 0; i4 < i2; i4++) {
                iArr2[i4] = this.e.h();
                iArr4[i4] = this.e.u();
            }
        } else {
            iArr2[0] = 0;
            iArr4[0] = aVar.f6399a - ((int) (j3 - aVar.b));
        }
        com.opos.exoplayer.core.c.n.a aVar2 = aVar.c;
        com.opos.exoplayer.core.b.b bVar2 = eVar.f6275a;
        bVar2.a(i2, iArr2, iArr4, aVar2.b, bVar2.f6272a, aVar2.f6373a, aVar2.c, aVar2.d);
        long j4 = aVar.b;
        int i5 = (int) (j3 - j4);
        aVar.b = j4 + ((long) i5);
        aVar.f6399a -= i5;
    }

    private void a(b bVar) {
        if (bVar.c) {
            b bVar2 = this.h;
            boolean z = bVar2.c;
            int i = (z ? 1 : 0) + (((int) (bVar2.f6401a - bVar.f6401a)) / this.b);
            com.opos.exoplayer.core.h.a[] aVarArr = new com.opos.exoplayer.core.h.a[i];
            for (int i2 = 0; i2 < i; i2++) {
                aVarArr[i2] = bVar.d;
                bVar = bVar.a();
            }
            this.f6400a.a(aVarArr);
        }
    }

    private void b(int i) {
        long j = this.m + ((long) i);
        this.m = j;
        b bVar = this.h;
        if (j == bVar.b) {
            this.h = bVar.e;
        }
    }

    private void b(long j) {
        b bVar;
        if (j == -1) {
            return;
        }
        while (true) {
            bVar = this.f;
            if (j < bVar.b) {
                break;
            }
            this.f6400a.a(bVar.d);
            this.f = this.f.a();
        }
        if (this.g.f6401a < bVar.f6401a) {
            this.g = bVar;
        }
    }

    @Override // com.opos.exoplayer.core.c.n
    public int a(com.opos.exoplayer.core.c.f fVar, int i, boolean z) throws EOFException {
        int iA = a(i);
        b bVar = this.h;
        int iA2 = fVar.a(bVar.d.f6478a, bVar.a(this.m), iA);
        if (iA2 != -1) {
            b(iA2);
            return iA2;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    public int a(com.opos.exoplayer.core.l lVar, com.opos.exoplayer.core.b.e eVar, boolean z, boolean z2, long j) {
        int iA = this.c.a(lVar, eVar, z, z2, this.i, this.d);
        if (iA == -5) {
            this.i = lVar.f6520a;
            return -5;
        }
        if (iA != -4) {
            if (iA == -3) {
                return -3;
            }
            throw new IllegalStateException();
        }
        if (!eVar.c()) {
            if (eVar.c < j) {
                eVar.b(Integer.MIN_VALUE);
            }
            if (eVar.g()) {
                a(eVar, this.d);
            }
            eVar.e(this.d.f6399a);
            g.a aVar = this.d;
            a(aVar.b, eVar.b, aVar.f6399a);
        }
        return -4;
    }

    public void a() {
        a(false);
    }

    @Override // com.opos.exoplayer.core.c.n
    public void a(long j, int i, int i2, int i3, com.opos.exoplayer.core.c.n.a aVar) {
        if (this.j) {
            a(this.k);
        }
        if (this.n) {
            if ((i & 1) == 0 || !this.c.b(j)) {
                return;
            } else {
                this.n = false;
            }
        }
        this.c.a(j + this.l, i, (this.m - ((long) i2)) - ((long) i3), i2, aVar);
    }

    public void a(long j, boolean z, boolean z2) {
        b(this.c.b(j, z, z2));
    }

    @Override // com.opos.exoplayer.core.c.n
    public void a(Format format) {
        Format formatA = a(format, this.l);
        boolean zA = this.c.a(formatA);
        this.k = format;
        this.j = false;
        a aVar = this.o;
        if (aVar == null || !zA) {
            return;
        }
        aVar.a(formatA);
    }

    public void a(a aVar) {
        this.o = aVar;
    }

    @Override // com.opos.exoplayer.core.c.n
    public void a(p pVar, int i) {
        while (i > 0) {
            int iA = a(i);
            b bVar = this.h;
            pVar.a(bVar.d.f6478a, bVar.a(this.m), iA);
            i -= iA;
            b(iA);
        }
    }

    public void a(boolean z) {
        this.c.a(z);
        a(this.f);
        b bVar = new b(0L, this.b);
        this.f = bVar;
        this.g = bVar;
        this.h = bVar;
        this.m = 0L;
        this.f6400a.b();
    }

    public int b() {
        return this.c.a();
    }

    public int b(long j, boolean z, boolean z2) {
        return this.c.a(j, z, z2);
    }

    public boolean c() {
        return this.c.c();
    }

    public int d() {
        return this.c.b();
    }

    public Format e() {
        return this.c.d();
    }

    public long f() {
        return this.c.e();
    }

    public void g() {
        this.c.f();
        this.g = this.f;
    }

    public void h() {
        b(this.c.h());
    }

    public int i() {
        return this.c.g();
    }
}
