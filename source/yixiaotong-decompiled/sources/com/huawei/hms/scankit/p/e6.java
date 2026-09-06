package com.huawei.hms.scankit.p;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

/* JADX INFO: compiled from: State.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
final class e6 {
    static final e6 e = new e6(k6.b, 0, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f4240a;
    private final k6 b;
    private final int c;
    private final int d;

    private e6(k6 k6Var, int i, int i2, int i3) {
        this.b = k6Var;
        this.f4240a = i;
        this.c = i2;
        this.d = i3;
    }

    int a() {
        return this.c;
    }

    int b() {
        return this.d;
    }

    int c() {
        return this.f4240a;
    }

    public String toString() {
        String[] strArr = l3.b;
        if (y6.a(strArr, this.f4240a)) {
            return String.format(Locale.ENGLISH, "%s bits=%d bytes=%d", strArr[this.f4240a], Integer.valueOf(this.d), Integer.valueOf(this.c));
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    e6 a(int i, int i2) {
        int i3 = this.d;
        k6 k6VarA = this.b;
        int i4 = this.f4240a;
        if (i != i4) {
            int i5 = l3.c[i4][i];
            int i6 = 65535 & i5;
            int i7 = i5 >> 16;
            k6VarA = k6VarA.a(i6, i7);
            i3 += i7;
        }
        int i8 = i == 2 ? 4 : 5;
        return new e6(k6VarA.a(i2, i8), i, 0, i3 + i8);
    }

    e6 b(int i, int i2) {
        k6 k6VarA = this.b;
        int i3 = this.f4240a;
        int i4 = i3 == 2 ? 4 : 5;
        if (i3 >= 0) {
            int[][] iArr = l3.e;
            if (i3 < iArr.length && i > 0) {
                int[] iArr2 = iArr[i3];
                if (i < iArr2.length) {
                    k6VarA = k6VarA.a(iArr2[i], i4);
                }
            }
        }
        return new e6(k6VarA.a(i2, 5), this.f4240a, 0, this.d + i4 + 5);
    }

    e6 b(int i) {
        int i2 = this.c;
        return i2 == 0 ? this : new e6(this.b.b(i - i2, i2), this.f4240a, 0, this.d);
    }

    e6 a(int i) {
        int i2;
        k6 k6VarA = this.b;
        int i3 = this.f4240a;
        int i4 = this.d;
        if (i3 == 4 || i3 == 2) {
            int i5 = l3.c[i3][0];
            int i6 = 65535 & i5;
            int i7 = i5 >> 16;
            k6VarA = k6VarA.a(i6, i7);
            i4 += i7;
            i3 = 0;
        }
        int i8 = this.c;
        if (i8 == 0 || i8 == 31) {
            i2 = 18;
        } else {
            i2 = i8 == 62 ? 9 : 8;
        }
        e6 e6Var = new e6(k6VarA, i3, i8 + 1, i4 + i2);
        return e6Var.c == 2078 ? e6Var.b(i + 1) : e6Var;
    }

    boolean a(e6 e6Var) {
        int i;
        int i2 = this.d + (l3.c[this.f4240a][e6Var.f4240a] >> 16);
        int i3 = e6Var.c;
        if (i3 > 0 && ((i = this.c) == 0 || i > i3)) {
            i2 += 10;
        }
        return i2 <= e6Var.d;
    }

    r a(byte[] bArr) {
        LinkedList linkedList = new LinkedList();
        for (k6 k6VarA = b(bArr.length).b; k6VarA != null; k6VarA = k6VarA.a()) {
            linkedList.addFirst(k6VarA);
        }
        r rVar = new r();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((k6) it.next()).a(rVar, bArr);
        }
        return rVar;
    }
}
