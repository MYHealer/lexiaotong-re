package com.byazt.yj;

import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface tt {
    File getCacheDir();

    long getFileCacheSize();

    int getMemoryCacheSize();

    int getRawMemoryCacheSize();

    boolean isDiskCache();

    boolean isMemoryCache();

    boolean isQueryAll();

    boolean isRawMemoryCache();
}
