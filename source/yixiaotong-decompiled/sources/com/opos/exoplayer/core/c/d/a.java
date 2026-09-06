package com.opos.exoplayer.core.c.d;

import com.opos.exoplayer.core.i.y;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class a {

    /* JADX INFO: renamed from: com.opos.exoplayer.core.c.d.a$a, reason: collision with other inner class name */
    public static final class C0909a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long[] f6296a;
        public final int[] b;
        public final int c;
        public final long[] d;
        public final int[] e;
        public final long f;

        private C0909a(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2, long j) {
            this.f6296a = jArr;
            this.b = iArr;
            this.c = i;
            this.d = jArr2;
            this.e = iArr2;
            this.f = j;
        }

        /* synthetic */ C0909a(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2, long j, b bVar) {
            this(jArr, iArr, i, jArr2, iArr2, j);
        }
    }

    static /* synthetic */ class b {
    }

    public static C0909a a(int i, long[] jArr, int[] iArr, long j) {
        int i2 = 8192 / i;
        int iA = 0;
        for (int i3 : iArr) {
            iA += y.a(i3, i2);
        }
        long[] jArr2 = new long[iA];
        int[] iArr2 = new int[iA];
        long[] jArr3 = new long[iA];
        int[] iArr3 = new int[iA];
        int i4 = 0;
        int i5 = 0;
        int iMax = 0;
        for (int i6 = 0; i6 < iArr.length; i6++) {
            int i7 = iArr[i6];
            long j2 = jArr[i6];
            while (i7 > 0) {
                int iMin = Math.min(i2, i7);
                jArr2[i5] = j2;
                int i8 = i * iMin;
                iArr2[i5] = i8;
                iMax = Math.max(iMax, i8);
                jArr3[i5] = ((long) i4) * j;
                iArr3[i5] = 1;
                j2 += (long) iArr2[i5];
                i4 += iMin;
                i7 -= iMin;
                i5++;
            }
        }
        return new C0909a(jArr2, iArr2, iMax, jArr3, iArr3, j * ((long) i4), null);
    }
}
