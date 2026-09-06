package com.adprof.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class q7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1380a;
    public final int b;
    public int c;
    public int d;

    public q7() {
        this(5000, 2, 0.0f);
    }

    public q7(int i, int i2, float f) {
        this.b = i;
        this.c = i;
        this.f1380a = i2;
    }

    public q7(int i, int i2, int i3, float f) {
        this.b = i;
        this.c = i2;
        this.f1380a = i3;
    }

    public void a(jp jpVar) throws jp {
        int i = this.d + 1;
        this.d = i;
        int i2 = this.c;
        this.c = i2 + ((int) (i2 * 0.0f));
        if (i > this.f1380a) {
            throw jpVar;
        }
    }
}
