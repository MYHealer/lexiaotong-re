package com.opos.exoplayer.core.c;

import com.opos.exoplayer.core.i.y;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class a implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6279a;
    public final int[] b;
    public final long[] c;
    public final long[] d;
    public final long[] e;
    private final long f;

    public a(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.b = iArr;
        this.c = jArr;
        this.d = jArr2;
        this.e = jArr3;
        int length = iArr.length;
        this.f6279a = length;
        if (length <= 0) {
            this.f = 0L;
        } else {
            int i = length - 1;
            this.f = jArr2[i] + jArr3[i];
        }
    }

    public int a(long j) {
        return y.a(this.e, j, true, true);
    }

    @Override // com.opos.exoplayer.core.c.l
    public boolean a() {
        return true;
    }

    @Override // com.opos.exoplayer.core.c.l
    public long b() {
        return this.f;
    }

    @Override // com.opos.exoplayer.core.c.l
    public l.a b(long j) {
        int iA = a(j);
        m mVar = new m(this.e[iA], this.c[iA]);
        if (mVar.b >= j || iA == this.f6279a - 1) {
            return new l.a(mVar);
        }
        int i = iA + 1;
        return new l.a(mVar, new m(this.e[i], this.c[i]));
    }
}
