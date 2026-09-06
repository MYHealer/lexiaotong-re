package com.byazt.vgp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public enum c {
    USE_KWS(0),
    USE_ALOG(1),
    USE_PITAYA(2),
    USE_OTHER(3);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f2813a;
    public long n;

    public long c() {
        return this.n;
    }

    c(int i) {
        if (i < 0 || i > 63) {
            throw new IllegalArgumentException("bit argument illegal exception,range [0,63]");
        }
        this.n = 1 << i;
        this.f2813a = i;
    }
}
