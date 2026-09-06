package com.kwad.sdk.pngencrypt;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
final class p {
    public final e bjO;
    int bkA;
    public final k bkK;
    int bku;
    int bkx;
    int bky;
    int bkz;
    public final boolean blm;
    int bln;
    int blo;
    int blp;
    int blq;
    int blr;
    int bls;
    int blt;
    byte[] buf;

    final void h(byte[] bArr, int i) {
        this.buf = bArr;
        this.blt = i;
    }

    public p(k kVar, e eVar) {
        this.bkK = kVar;
        this.bjO = eVar;
        this.blm = eVar != null;
    }

    final void update(int i) {
        this.bln = i;
        if (this.blm) {
            this.bku = this.bjO.SX();
            this.bky = this.bjO.bky;
            this.bkx = this.bjO.bkx;
            this.bkA = this.bjO.bkA;
            this.bkz = this.bjO.bkz;
            this.blo = this.bjO.SW();
            this.blp = this.bjO.SV();
            this.blq = this.bjO.SY();
            this.blr = this.bjO.SZ();
            this.bls = ((this.bkK.bkU * this.blr) + 7) / 8;
            return;
        }
        this.bku = 1;
        this.bkx = 1;
        this.bky = 1;
        this.bkz = 0;
        this.bkA = 0;
        this.blp = i;
        this.blo = i;
        this.blq = this.bkK.bkv;
        this.blr = this.bkK.bkw;
        this.bls = this.bkK.bkW;
    }
}
