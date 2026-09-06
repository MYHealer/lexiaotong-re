package com.hihonor.adsdk.common.video.g.i;

import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class g extends e {
    private final long hnadsc;
    private final int hnadsd;

    public g(int i, long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("Max size must be positive number!");
        }
        this.hnadsc = j;
        if (i <= 0) {
            throw new IllegalArgumentException("Max count must be positive number!");
        }
        this.hnadsd = i;
    }

    @Override // com.hihonor.adsdk.common.video.g.i.e
    protected boolean hnadsa(File file, long j, int i) {
        return j <= this.hnadsc && i <= this.hnadsd;
    }
}
