package com.huawei.hms.scankit.p;

/* JADX INFO: compiled from: Codeword.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
final class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f4349a;
    private final int b;
    private final int c;
    private final int d;
    private int e = -1;

    u0(int i, int i2, int i3, int i4) {
        this.f4349a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    int a() {
        return this.c;
    }

    boolean a(int i) {
        return i != -1 && this.c == (i % 3) * 3;
    }

    int b() {
        return this.b;
    }

    void b(int i) {
        this.e = i;
    }

    int c() {
        return this.e;
    }

    int d() {
        return this.f4349a;
    }

    int e() {
        return this.d;
    }

    int f() {
        return this.b - this.f4349a;
    }

    boolean g() {
        return a(this.e);
    }

    void h() {
        this.e = ((this.d / 30) * 3) + (this.c / 3);
    }

    public String toString() {
        return this.e + "|" + this.d;
    }
}
