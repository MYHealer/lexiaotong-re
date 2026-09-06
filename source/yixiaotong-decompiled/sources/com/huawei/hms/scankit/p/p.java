package com.huawei.hms.scankit.p;

/* JADX INFO: compiled from: BinaryBitmap.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o f4321a;
    private s b;

    public p(o oVar) {
        if (oVar == null) {
            throw new IllegalArgumentException("Binarizer must be non-null.");
        }
        this.f4321a = oVar;
    }

    public o a() {
        return this.f4321a;
    }

    public r a(int i, int i2) throws a {
        int i3;
        int iE = e();
        if (iE < 45) {
            throw a.a();
        }
        r rVar = new r(iE);
        byte[] bArr = new byte[iE];
        a().c().a(i, bArr);
        int[] iArr = new int[iE];
        int[] iArr2 = new int[iE];
        int i4 = bArr[0] & 255;
        iArr[0] = i4;
        iArr2[0] = i4 * i4;
        for (int i5 = 1; i5 < iE; i5++) {
            iArr[i5] = iArr[i5 - 1] + (bArr[i5] & 255);
        }
        if (i2 != 0) {
            return a(45, iE, iArr, iArr2, bArr, 22);
        }
        int i6 = 23;
        while (true) {
            i3 = iE - 22;
            if (i6 >= i3) {
                break;
            }
            if ((bArr[i6] & 255) + 5 < (iArr[i6 + 22] - iArr[i6 - 23]) / 45) {
                rVar.g(i6);
            }
            i6++;
        }
        if (rVar.b(23)) {
            rVar.c(0, 23);
        }
        if (rVar.b(iE - 23)) {
            rVar.c(i3, iE);
        }
        return rVar;
    }

    public void a(s sVar) {
        this.b = sVar;
    }

    public int c() {
        return this.f4321a.b();
    }

    public byte[] d() {
        return this.f4321a.c().b();
    }

    public int e() {
        return this.f4321a.d();
    }

    public s b() throws a {
        if (this.b == null) {
            this.b = this.f4321a.a();
        }
        return this.b;
    }

    private r a(int i, int i2, int[] iArr, int[] iArr2, byte[] bArr, int i3) {
        int i4;
        r rVar = new r(i2);
        for (int i5 = 1; i5 < i2; i5++) {
            int i6 = iArr2[i5 - 1];
            byte b = bArr[i5];
            iArr2[i5] = i6 + ((b & 255) * (b & 255));
        }
        int i7 = i3 + 1;
        int i8 = i7;
        while (true) {
            i4 = i2 - i3;
            if (i8 >= i4) {
                break;
            }
            int i9 = i8 + i3;
            int i10 = (i8 - i3) - 1;
            double d = iArr[i9] - iArr[i10];
            double d2 = i;
            if ((bArr[i8] & 255) <= (d / d2) * ((((double) 0.5f) * (Math.sqrt((((double) (iArr2[i9] - iArr2[i10])) - ((d * d) / d2)) / ((double) (i - 1))) / ((double) 127))) + 1.0d)) {
                rVar.g(i8);
            }
            i8++;
        }
        if (rVar.b(i7)) {
            rVar.c(0, i7);
        }
        if (rVar.b(i4 - 1)) {
            rVar.c(i4, i2);
        }
        return rVar;
    }

    public r a(int i, r rVar) throws a {
        return this.f4321a.a(i, rVar);
    }

    public p a(int i, int i2, int i3, int i4) {
        return new p(this.f4321a.a(this.f4321a.c().a(i, i2, i3, i4)));
    }
}
