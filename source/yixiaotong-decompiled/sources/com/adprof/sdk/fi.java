package com.adprof.sdk;

import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class fi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m6 f1174a;

    public fi(m6 m6Var) {
        this.f1174a = m6Var;
    }

    public static int a(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int a(long j) {
        if (((-128) & j) == 0) {
            return 1;
        }
        if (((-16384) & j) == 0) {
            return 2;
        }
        if (((-2097152) & j) == 0) {
            return 3;
        }
        if (((-268435456) & j) == 0) {
            return 4;
        }
        if (((-34359738368L) & j) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public void a(q6 q6Var) throws IOException {
        l6 l6Var = (l6) this.f1174a;
        l6Var.getClass();
        if (q6Var == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        q6Var.a(l6Var);
    }

    public void b(int i) throws IOException {
        while ((i & (-128)) != 0) {
            ((l6) this.f1174a).m671a((i & 127) | 128);
            i >>>= 7;
        }
        ((l6) this.f1174a).m671a(i);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m623a(int i) throws IOException {
        l6 l6Var = (l6) this.f1174a;
        l6Var.getClass();
        int iA = eo.a(i);
        dl dlVarA = l6Var.a(4);
        byte[] bArr = dlVarA.f226a;
        int i2 = dlVarA.b;
        bArr[i2] = (byte) ((iA >>> 24) & 255);
        bArr[i2 + 1] = (byte) ((iA >>> 16) & 255);
        bArr[i2 + 2] = (byte) ((iA >>> 8) & 255);
        bArr[i2 + 3] = (byte) (iA & 255);
        dlVarA.b = i2 + 4;
        l6Var.f1279a += 4;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m624a(long j) throws IOException {
        l6 l6Var = (l6) this.f1174a;
        l6Var.getClass();
        long jA = eo.a(j);
        dl dlVarA = l6Var.a(8);
        byte[] bArr = dlVarA.f226a;
        int i = dlVarA.b;
        bArr[i] = (byte) ((jA >>> 56) & 255);
        bArr[i + 1] = (byte) ((jA >>> 48) & 255);
        bArr[i + 2] = (byte) ((jA >>> 40) & 255);
        bArr[i + 3] = (byte) ((jA >>> 32) & 255);
        bArr[i + 4] = (byte) ((jA >>> 24) & 255);
        bArr[i + 5] = (byte) ((jA >>> 16) & 255);
        bArr[i + 6] = (byte) ((jA >>> 8) & 255);
        bArr[i + 7] = (byte) (jA & 255);
        dlVarA.b = i + 8;
        l6Var.f1279a += 8;
    }

    public void b(long j) throws IOException {
        while (((-128) & j) != 0) {
            ((l6) this.f1174a).m671a((((int) j) & 127) | 128);
            j >>>= 7;
        }
        ((l6) this.f1174a).m671a((int) j);
    }
}
