package com.umeng.analytics.pro;

/* JADX INFO: compiled from: TMemoryInputTransport.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class ch extends ci {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f9140a;
    private int b;
    private int c;

    @Override // com.umeng.analytics.pro.ci
    public void a(int i) {
        this.b += i;
    }

    @Override // com.umeng.analytics.pro.ci
    public boolean a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.ci
    public void b() throws cj {
    }

    @Override // com.umeng.analytics.pro.ci
    public void c() {
    }

    public void c(byte[] bArr, int i, int i2) {
        this.f9140a = bArr;
        this.b = i;
        this.c = i + i2;
    }

    public void e() {
        this.f9140a = null;
    }

    @Override // com.umeng.analytics.pro.ci
    public byte[] f() {
        return this.f9140a;
    }

    @Override // com.umeng.analytics.pro.ci
    public int g() {
        return this.b;
    }

    @Override // com.umeng.analytics.pro.ci
    public int h() {
        return this.c - this.b;
    }

    public ch() {
    }

    public ch(byte[] bArr) {
        a(bArr);
    }

    public ch(byte[] bArr, int i, int i2) {
        c(bArr, i, i2);
    }

    public void a(byte[] bArr) {
        c(bArr, 0, bArr.length);
    }

    @Override // com.umeng.analytics.pro.ci
    public int a(byte[] bArr, int i, int i2) throws cj {
        int iH = h();
        if (i2 > iH) {
            i2 = iH;
        }
        if (i2 > 0) {
            System.arraycopy(this.f9140a, this.b, bArr, i, i2);
            a(i2);
        }
        return i2;
    }

    @Override // com.umeng.analytics.pro.ci
    public void b(byte[] bArr, int i, int i2) throws cj {
        throw new UnsupportedOperationException("No writing allowed!");
    }
}
