package com.opos.exoplayer.core.c.d;

import com.opos.exoplayer.core.i.y;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6316a;
    public final long[] b;
    public final int[] c;
    public final int d;
    public final long[] e;
    public final int[] f;
    public final long g;

    public m(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2, long j) {
        com.opos.exoplayer.core.i.a.a(iArr.length == jArr2.length);
        com.opos.exoplayer.core.i.a.a(jArr.length == jArr2.length);
        com.opos.exoplayer.core.i.a.a(iArr2.length == jArr2.length);
        this.b = jArr;
        this.c = iArr;
        this.d = i;
        this.e = jArr2;
        this.f = iArr2;
        this.g = j;
        this.f6316a = jArr.length;
    }

    public int a(long j) {
        for (int iA = y.a(this.e, j, true, false); iA >= 0; iA--) {
            if ((this.f[iA] & 1) != 0) {
                return iA;
            }
        }
        return -1;
    }

    public int b(long j) {
        for (int iB = y.b(this.e, j, true, false); iB < this.e.length; iB++) {
            if ((this.f[iB] & 1) != 0) {
                return iB;
            }
        }
        return -1;
    }
}
