package com.ubix.ssp.ad.e.y.c;

import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected volatile int f8939a = -1;

    public static final <T extends f> T a(T t, byte[] bArr) {
        return (T) a(t, bArr, 0, bArr.length);
    }

    public static final <T extends f> T a(T t, byte[] bArr, int i, int i2) throws d {
        try {
            a aVarA = a.a(bArr, i, i2);
            t.a(aVarA);
            aVarA.a(0);
            return t;
        } catch (d e) {
            throw e;
        } catch (IOException unused) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public static final byte[] a(f fVar) {
        int iD = fVar.d();
        byte[] bArr = new byte[iD];
        b(fVar, bArr, 0, iD);
        return bArr;
    }

    public static final void b(f fVar, byte[] bArr, int i, int i2) {
        try {
            b bVarA = b.a(bArr, i, i2);
            fVar.a(bVarA);
            bVarA.a();
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public f clone() {
        return (f) super.clone();
    }

    public abstract f a(a aVar);

    public void a(b bVar) {
    }

    protected int b() {
        return 0;
    }

    public int c() {
        if (this.f8939a < 0) {
            d();
        }
        return this.f8939a;
    }

    public int d() {
        int iB = b();
        this.f8939a = iB;
        return iB;
    }

    public String toString() {
        return g.a(this);
    }
}
