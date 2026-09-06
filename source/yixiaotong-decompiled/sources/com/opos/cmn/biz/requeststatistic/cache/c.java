package com.opos.cmn.biz.requeststatistic.cache;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile long f6011a;
    public final String b;
    public final long c;

    public c(long j, String str, long j2) {
        this.f6011a = -1L;
        this.f6011a = j;
        this.b = str;
        this.c = j2;
    }

    public c(String str, long j) {
        this.f6011a = -1L;
        this.b = str;
        this.c = j;
    }

    public long a() {
        return this.f6011a;
    }

    public void a(long j) {
        this.f6011a = j;
    }
}
