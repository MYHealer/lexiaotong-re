package com.opos.exoplayer.core.i;

import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f6505a;
    private long[] b;

    public k() {
        this(32);
    }

    public k(int i) {
        this.b = new long[i];
    }

    public int a() {
        return this.f6505a;
    }

    public long a(int i) {
        if (i < 0 || i >= this.f6505a) {
            throw new IndexOutOfBoundsException("Invalid index " + i + ", size is " + this.f6505a);
        }
        return this.b[i];
    }

    public void a(long j) {
        int i = this.f6505a;
        long[] jArr = this.b;
        if (i == jArr.length) {
            this.b = Arrays.copyOf(jArr, i * 2);
        }
        long[] jArr2 = this.b;
        int i2 = this.f6505a;
        this.f6505a = i2 + 1;
        jArr2[i2] = j;
    }

    public long[] b() {
        return Arrays.copyOf(this.b, this.f6505a);
    }
}
