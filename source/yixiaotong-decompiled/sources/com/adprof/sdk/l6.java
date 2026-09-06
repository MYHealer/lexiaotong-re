package com.adprof.sdk;

import java.io.EOFException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class l6 implements n6, m6, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f1279a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public dl f436a;

    public byte a() {
        long j = this.f1279a;
        if (j == 0) {
            throw new IllegalStateException("size == 0");
        }
        dl dlVar = this.f436a;
        int i = dlVar.f1133a;
        int i2 = dlVar.b;
        int i3 = i + 1;
        byte b = dlVar.f226a[i];
        this.f1279a = j - 1;
        if (i3 == i2) {
            this.f436a = dlVar.a();
            el.a(dlVar);
        } else {
            dlVar.f1133a = i3;
        }
        return b;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public int m670a() {
        long j = this.f1279a;
        if (j < 4) {
            throw new IllegalStateException("size < 4: " + this.f1279a);
        }
        dl dlVar = this.f436a;
        int i = dlVar.f1133a;
        int i2 = dlVar.b;
        if (i2 - i < 4) {
            return ((a() & 255) << 24) | ((a() & 255) << 16) | ((a() & 255) << 8) | (a() & 255);
        }
        byte[] bArr = dlVar.f226a;
        int i3 = i + 3;
        int i4 = ((bArr[i + 1] & 255) << 16) | ((bArr[i] & 255) << 24) | ((bArr[i + 2] & 255) << 8);
        int i5 = i + 4;
        int i6 = (bArr[i3] & 255) | i4;
        this.f1279a = j - 4;
        if (i5 == i2) {
            this.f436a = dlVar.a();
            el.a(dlVar);
        } else {
            dlVar.f1133a = i5;
        }
        return i6;
    }

    public dl a(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException();
        }
        dl dlVar = this.f436a;
        if (dlVar != null) {
            dl dlVar2 = dlVar.f227b;
            return (dlVar2.b + i > 8192 || !dlVar2.f228b) ? dlVar2.a(el.a()) : dlVar2;
        }
        dl dlVarA = el.a();
        this.f436a = dlVarA;
        dlVarA.f227b = dlVarA;
        dlVarA.f224a = dlVarA;
        return dlVarA;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public l6 m671a(int i) {
        dl dlVarA = a(1);
        byte[] bArr = dlVarA.f226a;
        int i2 = dlVarA.b;
        dlVarA.b = i2 + 1;
        bArr[i2] = (byte) i;
        this.f1279a++;
        return this;
    }

    public l6 a(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = i2;
        eo.a(bArr.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            dl dlVarA = a(1);
            int iMin = Math.min(i3 - i, 8192 - dlVarA.b);
            System.arraycopy(bArr, i, dlVarA.f226a, dlVarA.b, iMin);
            i += iMin;
            dlVarA.b += iMin;
        }
        this.f1279a += j;
        return this;
    }

    public void a(long j) throws EOFException {
        if (this.f1279a < j) {
            throw new EOFException();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public byte[] m672a(long j) throws EOFException {
        int iMin;
        eo.a(this.f1279a, 0L, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        int i = (int) j;
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int i3 = i - i2;
            eo.a(i, i2, i3);
            dl dlVar = this.f436a;
            if (dlVar == null) {
                iMin = -1;
            } else {
                iMin = Math.min(i3, dlVar.b - dlVar.f1133a);
                System.arraycopy(dlVar.f226a, dlVar.f1133a, bArr, i2, iMin);
                int i4 = dlVar.f1133a + iMin;
                dlVar.f1133a = i4;
                this.f1279a -= (long) iMin;
                if (i4 == dlVar.b) {
                    this.f436a = dlVar.a();
                    el.a(dlVar);
                }
            }
            if (iMin == -1) {
                throw new EOFException();
            }
            i2 += iMin;
        }
        return bArr;
    }

    public Object clone() throws CloneNotSupportedException {
        l6 l6Var = new l6();
        if (this.f1279a != 0) {
            dl dlVar = this.f436a;
            dl dlVar2 = new dl(dlVar.f226a, dlVar.f1133a, dlVar.b);
            dlVar.f225a = true;
            l6Var.f436a = dlVar2;
            dlVar2.f227b = dlVar2;
            dlVar2.f224a = dlVar2;
            for (dl dlVar3 = this.f436a.f224a; dlVar3 != this.f436a; dlVar3 = dlVar3.f224a) {
                dl dlVar4 = l6Var.f436a.f227b;
                dl dlVar5 = new dl(dlVar3.f226a, dlVar3.f1133a, dlVar3.b);
                dlVar3.f225a = true;
                dlVar4.a(dlVar5);
            }
            l6Var.f1279a = this.f1279a;
        }
        return l6Var;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l6)) {
            return false;
        }
        l6 l6Var = (l6) obj;
        long j = this.f1279a;
        if (j != l6Var.f1279a) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        dl dlVar = this.f436a;
        dl dlVar2 = l6Var.f436a;
        int i = dlVar.f1133a;
        int i2 = dlVar2.f1133a;
        while (j2 < this.f1279a) {
            long jMin = Math.min(dlVar.b - i, dlVar2.b - i2);
            int i3 = 0;
            while (i3 < jMin) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (dlVar.f226a[i] != dlVar2.f226a[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == dlVar.b) {
                dlVar = dlVar.f224a;
                i = dlVar.f1133a;
            }
            if (i2 == dlVar2.b) {
                dlVar2 = dlVar2.f224a;
                i2 = dlVar2.f1133a;
            }
            j2 += jMin;
        }
        return true;
    }

    @Override // java.io.Flushable
    public void flush() {
    }

    public int hashCode() {
        dl dlVar = this.f436a;
        if (dlVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = dlVar.b;
            for (int i3 = dlVar.f1133a; i3 < i2; i3++) {
                i = (i * 31) + dlVar.f226a[i3];
            }
            dlVar = dlVar.f224a;
        } while (dlVar != this.f436a);
        return i;
    }

    public String toString() {
        long j = this.f1279a;
        if (j > 2147483647L) {
            throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f1279a);
        }
        int i = (int) j;
        return (i == 0 ? q6.f1379a : new fl(this, i)).toString();
    }
}
