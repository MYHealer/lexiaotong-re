package com.huawei.hms.scankit.p;

import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: compiled from: ByteMatrix.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[][] f4210a;
    private final int b;
    private final int c;

    public a0(int i, int i2) {
        this.f4210a = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i2, i);
        this.b = i;
        this.c = i2;
    }

    public byte a(int i, int i2) {
        if (y6.a(this.f4210a, i2) && y6.a(this.f4210a[i2], i)) {
            return this.f4210a[i2][i];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public byte[][] a() {
        return this.f4210a;
    }

    public int b() {
        return this.c;
    }

    public int c() {
        return this.b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.b * 2 * this.c) + 2);
        for (int i = 0; i < this.c; i++) {
            byte[] bArr = this.f4210a[i];
            for (int i2 = 0; i2 < this.b; i2++) {
                byte b = bArr[i2];
                if (b == 0) {
                    sb.append(" 0");
                } else if (b != 1) {
                    sb.append("  ");
                } else {
                    sb.append(" 1");
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public void a(int i, int i2, int i3) {
        if (y6.a(this.f4210a, i2) && y6.a(this.f4210a[i2], i)) {
            this.f4210a[i2][i] = (byte) i3;
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void a(int i, int i2, boolean z) {
        if (y6.a(this.f4210a, i2) && y6.a(this.f4210a[i2], i)) {
            this.f4210a[i2][i] = z ? (byte) 1 : (byte) 0;
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void a(byte b) {
        for (byte[] bArr : this.f4210a) {
            Arrays.fill(bArr, b);
        }
    }
}
