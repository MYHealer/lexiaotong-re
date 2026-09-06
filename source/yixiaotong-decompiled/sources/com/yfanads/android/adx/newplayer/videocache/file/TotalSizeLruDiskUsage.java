package com.yfanads.android.adx.newplayer.videocache.file;

import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class TotalSizeLruDiskUsage extends LruDiskUsage {
    private final long maxSize;

    public TotalSizeLruDiskUsage(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("Max size must be positive number!");
        }
        this.maxSize = j;
    }

    @Override // com.yfanads.android.adx.newplayer.videocache.file.LruDiskUsage
    public boolean accept(File file, long j, int i) {
        return j <= this.maxSize;
    }
}
