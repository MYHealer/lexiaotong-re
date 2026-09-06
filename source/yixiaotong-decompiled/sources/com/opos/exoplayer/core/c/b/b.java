package com.opos.exoplayer.core.c.b;

import com.opos.exoplayer.core.o;
import java.util.Stack;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f6287a = new byte[8];
    private final Stack<C0907b> b = new Stack<>();
    private final f c = new f();
    private d d;
    private int e;
    private int f;
    private long g;

    static /* synthetic */ class a {
    }

    /* JADX INFO: renamed from: com.opos.exoplayer.core.c.b.b$b, reason: collision with other inner class name */
    private static final class C0907b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f6288a;
        private final long b;

        private C0907b(int i, long j) {
            this.f6288a = i;
            this.b = j;
        }

        /* synthetic */ C0907b(int i, long j, a aVar) {
            this(i, j);
        }
    }

    b() {
    }

    private long a(com.opos.exoplayer.core.c.f fVar, int i) {
        fVar.b(this.f6287a, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | ((long) (this.f6287a[i2] & 255));
        }
        return j;
    }

    private double b(com.opos.exoplayer.core.c.f fVar, int i) {
        long jA = a(fVar, i);
        return i == 4 ? Float.intBitsToFloat((int) jA) : Double.longBitsToDouble(jA);
    }

    private long b(com.opos.exoplayer.core.c.f fVar) {
        fVar.a();
        while (true) {
            fVar.c(this.f6287a, 0, 4);
            int iA = f.a(this.f6287a[0]);
            if (iA != -1 && iA <= 4) {
                int iA2 = (int) f.a(this.f6287a, iA, false);
                if (this.d.b(iA2)) {
                    fVar.b(iA);
                    return iA2;
                }
            }
            fVar.b(1);
        }
    }

    private String c(com.opos.exoplayer.core.c.f fVar, int i) {
        if (i == 0) {
            return "";
        }
        byte[] bArr = new byte[i];
        fVar.b(bArr, 0, i);
        while (i > 0 && bArr[i - 1] == 0) {
            i--;
        }
        return new String(bArr, 0, i);
    }

    @Override // com.opos.exoplayer.core.c.b.c
    public void a() {
        this.e = 0;
        this.b.clear();
        this.c.a();
    }

    @Override // com.opos.exoplayer.core.c.b.c
    public void a(d dVar) {
        this.d = dVar;
    }

    @Override // com.opos.exoplayer.core.c.b.c
    public boolean a(com.opos.exoplayer.core.c.f fVar) throws o {
        com.opos.exoplayer.core.i.a.b(this.d != null);
        while (true) {
            if (!this.b.isEmpty() && fVar.c() >= this.b.peek().b) {
                this.d.c(this.b.pop().f6288a);
                return true;
            }
            if (this.e == 0) {
                long jA = this.c.a(fVar, true, false, 4);
                if (jA == -2) {
                    jA = b(fVar);
                }
                if (jA == -1) {
                    return false;
                }
                this.f = (int) jA;
                this.e = 1;
            }
            if (this.e == 1) {
                this.g = this.c.a(fVar, false, true, 8);
                this.e = 2;
            }
            int iA = this.d.a(this.f);
            if (iA != 0) {
                if (iA == 1) {
                    long jC = fVar.c();
                    this.b.add(new C0907b(this.f, this.g + jC, null));
                    this.d.a(this.f, jC, this.g);
                    this.e = 0;
                    return true;
                }
                if (iA == 2) {
                    long j = this.g;
                    if (j > 8) {
                        throw new o("Invalid integer size: " + this.g);
                    }
                    this.d.a(this.f, a(fVar, (int) j));
                    this.e = 0;
                    return true;
                }
                if (iA == 3) {
                    long j2 = this.g;
                    if (j2 > 2147483647L) {
                        throw new o("String element size: " + this.g);
                    }
                    this.d.a(this.f, c(fVar, (int) j2));
                    this.e = 0;
                    return true;
                }
                if (iA == 4) {
                    this.d.a(this.f, (int) this.g, fVar);
                    this.e = 0;
                    return true;
                }
                if (iA != 5) {
                    throw new o("Invalid element type " + iA);
                }
                long j3 = this.g;
                if (j3 != 4 && j3 != 8) {
                    throw new o("Invalid float size: " + this.g);
                }
                this.d.a(this.f, b(fVar, (int) j3));
                this.e = 0;
                return true;
            }
            fVar.b((int) this.g);
            this.e = 0;
        }
    }
}
