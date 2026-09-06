package com.yfanads.android.adx.newplayer.videocache.file;

import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class TotalCountLruDiskUsage extends LruDiskUsage {
    private final int maxCount;

    public TotalCountLruDiskUsage(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Max count must be positive number!");
        }
        this.maxCount = i;
    }

    @Override // com.yfanads.android.adx.newplayer.videocache.file.LruDiskUsage
    public boolean accept(File file, long j, int i) {
        return i <= this.maxCount;
    }
}
