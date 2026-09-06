package com.adprof.sdk;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class s9 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public r9 f718a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ByteBuffer f719a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final byte[] f720a = new byte[256];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1416a = 0;

    public final int a() {
        try {
            return this.f719a.get() & 255;
        } catch (Throwable unused) {
            this.f718a.g = 1;
            return 0;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final void m716a() {
        int iA;
        do {
            try {
                iA = a();
                ByteBuffer byteBuffer = this.f719a;
                byteBuffer.position(byteBuffer.position() + iA);
            } catch (IllegalArgumentException unused) {
                return;
            } catch (Throwable th) {
                pk.a("Error skip Block", th);
                return;
            }
        } while (iA > 0);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final boolean m717a() {
        return this.f718a.g != 0;
    }

    public final int[] a(int i) {
        byte[] bArr = new byte[i * 3];
        int[] iArr = null;
        try {
            this.f719a.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = bArr[i3] & 255;
                int i5 = i3 + 2;
                int i6 = bArr[i3 + 1] & 255;
                i3 += 3;
                int i7 = i2 + 1;
                iArr[i2] = (i6 << 8) | (i4 << 16) | (-16777216) | (bArr[i5] & 255);
                i2 = i7;
            }
        } catch (BufferUnderflowException e) {
            pk.a("Format Error Reading Color Table", e);
            this.f718a.g = 1;
        }
        return iArr;
    }

    public final int b() {
        int iA = a();
        this.f1416a = iA;
        int i = 0;
        if (iA > 0) {
            int i2 = 0;
            while (true) {
                try {
                    int i3 = this.f1416a;
                    if (i >= i3) {
                        break;
                    }
                    i2 = i3 - i;
                    this.f719a.get(this.f720a, i, i2);
                    i += i2;
                } catch (Throwable th) {
                    pk.a("Error Reading Block n: " + i + " count: " + i2 + " blockSize: " + this.f1416a, th);
                    this.f718a.g = 1;
                }
            }
        }
        return i;
    }
}
