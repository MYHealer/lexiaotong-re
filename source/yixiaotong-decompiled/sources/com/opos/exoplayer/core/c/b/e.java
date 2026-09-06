package com.opos.exoplayer.core.c.b;

import com.opos.exoplayer.core.i.p;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p f6289a = new p(8);
    private int b;

    private long b(com.opos.exoplayer.core.c.f fVar) {
        int i = 0;
        fVar.c(this.f6289a.f6510a, 0, 1);
        int i2 = this.f6289a.f6510a[0] & 255;
        if (i2 == 0) {
            return Long.MIN_VALUE;
        }
        int i3 = 128;
        int i4 = 0;
        while ((i2 & i3) == 0) {
            i3 >>= 1;
            i4++;
        }
        int i5 = i2 & (~i3);
        fVar.c(this.f6289a.f6510a, 1, i4);
        while (i < i4) {
            i++;
            i5 = (this.f6289a.f6510a[i] & 255) + (i5 << 8);
        }
        this.b += i4 + 1;
        return i5;
    }

    public boolean a(com.opos.exoplayer.core.c.f fVar) {
        long jD = fVar.d();
        long j = 1024;
        if (jD != -1 && jD <= 1024) {
            j = jD;
        }
        int i = (int) j;
        fVar.c(this.f6289a.f6510a, 0, 4);
        long jM = this.f6289a.m();
        this.b = 4;
        while (jM != 440786851) {
            int i2 = this.b + 1;
            this.b = i2;
            if (i2 == i) {
                return false;
            }
            fVar.c(this.f6289a.f6510a, 0, 1);
            jM = ((jM << 8) & (-256)) | ((long) (this.f6289a.f6510a[0] & 255));
        }
        long jB = b(fVar);
        long j2 = this.b;
        if (jB == Long.MIN_VALUE) {
            return false;
        }
        if (jD != -1 && j2 + jB >= jD) {
            return false;
        }
        while (true) {
            long j3 = this.b;
            long j4 = j2 + jB;
            if (j3 >= j4) {
                return j3 == j4;
            }
            if (b(fVar) == Long.MIN_VALUE) {
                return false;
            }
            long jB2 = b(fVar);
            if (jB2 < 0 || jB2 > 2147483647L) {
                return false;
            }
            if (jB2 != 0) {
                fVar.c((int) jB2);
                this.b = (int) (((long) this.b) + jB2);
            }
        }
    }
}
