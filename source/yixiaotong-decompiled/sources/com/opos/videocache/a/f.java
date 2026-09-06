package com.opos.videocache.a;

import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class f extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f8429a;

    public f(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Max count must be positive number!");
        }
        this.f8429a = i;
    }

    @Override // com.opos.videocache.a.d
    protected boolean a(File file, long j, int i) {
        return i <= this.f8429a;
    }
}
