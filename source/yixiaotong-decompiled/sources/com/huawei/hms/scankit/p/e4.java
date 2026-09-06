package com.huawei.hms.scankit.p;

/* JADX INFO: compiled from: ModulusGF.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class e4 {
    public static final e4 f = new e4(929, 3);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f4238a;
    private final int[] b;
    private final f4 c;
    private final f4 d;
    private final int e;

    private e4(int i, int i2) {
        this.e = i;
        this.f4238a = new int[i];
        this.b = new int[i];
        int i3 = 1;
        for (int i4 = 0; i4 < i; i4++) {
            this.f4238a[i4] = i3;
            i3 = (i3 * i2) % i;
        }
        for (int i5 = 0; i5 < i - 1; i5++) {
            this.b[this.f4238a[i5]] = i5;
        }
        this.c = new f4(this, new int[]{0});
        this.d = new f4(this, new int[]{1});
    }

    f4 a() {
        return this.d;
    }

    int b() {
        return this.e;
    }

    f4 c() {
        return this.c;
    }

    int d(int i, int i2) {
        int i3 = this.e;
        return ((i + i3) - i2) % i3;
    }

    int a(int i, int i2) {
        return (i + i2) % this.e;
    }

    int c(int i) {
        if (i != 0) {
            return this.b[i];
        }
        throw new IllegalArgumentException();
    }

    int a(int i) {
        return this.f4238a[i];
    }

    f4 b(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.c;
        }
        int[] iArr = new int[i + 1];
        iArr[0] = i2;
        return new f4(this, iArr);
    }

    int c(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return 0;
        }
        int[] iArr = this.f4238a;
        int[] iArr2 = this.b;
        return iArr[(iArr2[i] + iArr2[i2]) % (this.e - 1)];
    }

    int b(int i) {
        if (i != 0) {
            return this.f4238a[(this.e - this.b[i]) - 1];
        }
        throw new ArithmeticException();
    }
}
