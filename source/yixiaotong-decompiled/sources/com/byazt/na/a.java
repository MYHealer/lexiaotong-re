package com.byazt.na;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 662, 34})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f2489a;
    public final byte[] c;
    public boolean n;
    public a sp;
    public int tt;
    public boolean uj;
    public int ve;

    public a() {
        this.c = new byte[8192];
        this.n = true;
        this.uj = false;
    }

    public a(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.c = bArr;
        this.tt = i;
        this.ve = i2;
        this.uj = z;
        this.n = z2;
    }

    public final a c() {
        this.uj = true;
        return new a(this.c, this.tt, this.ve, true, false);
    }

    public final a tt() {
        a aVar = this.f2489a;
        a aVar2 = aVar != this ? aVar : null;
        a aVar3 = this.sp;
        if (aVar3 != null) {
            aVar3.f2489a = aVar;
        }
        a aVar4 = this.f2489a;
        if (aVar4 != null) {
            aVar4.sp = aVar3;
        }
        this.f2489a = null;
        this.sp = null;
        return aVar2;
    }

    public final a c(a aVar) {
        aVar.sp = this;
        aVar.f2489a = this.f2489a;
        this.f2489a.sp = aVar;
        this.f2489a = aVar;
        return aVar;
    }
}
