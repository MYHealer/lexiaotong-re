package com.opos.cmn.func.dl.base.e;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6131a;
    public long b;
    public long c;
    public volatile long d;

    public c(int i, long j, long j2, long j3) {
        this.f6131a = i;
        this.b = j;
        this.c = j3;
        this.d = j2;
    }

    public final String toString() {
        return "ThreadInfo{index=" + this.f6131a + ", startPos=" + this.b + ", contentLen=" + this.c + ", downloadedLen=" + this.d + '}';
    }
}
