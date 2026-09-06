package com.ubix.ssp.ad.e.b0.h.s;

import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class g extends e {
    private final long b;

    public g(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("Max size must be positive number!");
        }
        this.b = j;
    }

    @Override // com.ubix.ssp.ad.e.b0.h.s.e
    protected boolean a(File file, long j, int i) {
        return j <= this.b;
    }
}
