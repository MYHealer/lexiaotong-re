package com.opos.videocache.a;

import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class g extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f8430a;

    public g(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("Max size must be positive number!");
        }
        this.f8430a = j;
    }

    @Override // com.opos.videocache.a.d
    protected boolean a(File file, long j, int i) {
        return j <= this.f8430a;
    }
}
