package com.opos.exoplayer.core.c.b;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long[] f6290a = {128, 64, 32, 16, 8, 4, 2, 1};
    private final byte[] b = new byte[8];
    private int c;
    private int d;

    public static int a(int i) {
        long j;
        int i2 = 0;
        do {
            long[] jArr = f6290a;
            if (i2 >= jArr.length) {
                return -1;
            }
            j = jArr[i2] & ((long) i);
            i2++;
        } while (j == 0);
        return i2;
    }

    public static long a(byte[] bArr, int i, boolean z) {
        long j = ((long) bArr[0]) & 255;
        if (z) {
            j &= ~f6290a[i - 1];
        }
        for (int i2 = 1; i2 < i; i2++) {
            j = (j << 8) | (((long) bArr[i2]) & 255);
        }
        return j;
    }

    public long a(com.opos.exoplayer.core.c.f fVar, boolean z, boolean z2, int i) {
        if (this.c == 0) {
            if (!fVar.a(this.b, 0, 1, z)) {
                return -1L;
            }
            int iA = a(this.b[0] & 255);
            this.d = iA;
            if (iA == -1) {
                throw new IllegalStateException("No valid varint length mask found");
            }
            this.c = 1;
        }
        int i2 = this.d;
        if (i2 > i) {
            this.c = 0;
            return -2L;
        }
        if (i2 != 1) {
            fVar.b(this.b, 1, i2 - 1);
        }
        this.c = 0;
        return a(this.b, this.d, z2);
    }

    public void a() {
        this.c = 0;
        this.d = 0;
    }

    public int b() {
        return this.d;
    }
}
