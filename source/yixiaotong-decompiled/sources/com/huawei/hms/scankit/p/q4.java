package com.huawei.hms.scankit.p;

import android.view.animation.Interpolator;

/* JADX INFO: compiled from: OpacityAnimator.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class q4 implements o3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f4329a;
    private final int b;
    private final long c;
    private final long d;
    private final float e;
    private final Interpolator f;

    public q4(int i, int i2, long j, long j2, Interpolator interpolator) {
        this.f4329a = i;
        this.b = i2;
        this.c = j;
        this.d = j2;
        this.e = j2 - j;
        this.f = interpolator;
    }

    private int a(b5 b5Var) {
        int i = this.b;
        return i == -1 ? b5Var.e() : i;
    }

    private int b(b5 b5Var) {
        int i = this.f4329a;
        return i == -1 ? b5Var.a() : i;
    }

    private int c(b5 b5Var) {
        return a(b5Var) - b(b5Var);
    }

    @Override // com.huawei.hms.scankit.p.o3
    public void a(b5 b5Var, long j) {
        if (j < this.c || j > this.d || Float.compare(this.e, 0.0f) == 0) {
            return;
        }
        b5Var.a((int) (b(b5Var) + (c(b5Var) * this.f.getInterpolation((j - this.c) / this.e))));
    }
}
