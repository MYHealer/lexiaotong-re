package com.opos.exoplayer.core.c.d;

import com.opos.exoplayer.core.Format;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6303a;
    public final int b;
    public final long c;
    public final long d;
    public final long e;
    public final Format f;
    public final int g;
    public final long[] h;
    public final long[] i;
    public final int j;
    private final f[] k;

    public e(int i, int i2, long j, long j2, long j3, Format format, int i3, f[] fVarArr, int i4, long[] jArr, long[] jArr2) {
        this.f6303a = i;
        this.b = i2;
        this.c = j;
        this.d = j2;
        this.e = j3;
        this.f = format;
        this.g = i3;
        this.k = fVarArr;
        this.j = i4;
        this.h = jArr;
        this.i = jArr2;
    }

    public f a(int i) {
        f[] fVarArr = this.k;
        if (fVarArr == null) {
            return null;
        }
        return fVarArr[i];
    }
}
