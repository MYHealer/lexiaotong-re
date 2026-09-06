package com.hihonor.adsdk.common.video.g.i;

import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class h extends e {
    private final int hnadsc;

    public h(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Max count must be positive number!");
        }
        this.hnadsc = i;
    }

    @Override // com.hihonor.adsdk.common.video.g.i.e
    protected boolean hnadsa(File file, long j, int i) {
        return i <= this.hnadsc;
    }
}
