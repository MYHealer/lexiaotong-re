package com.bumptech.glide.util;

import com.bumptech.glide.ListPreloader;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class FixedPreloadSizeProvider<T> implements ListPreloader.PreloadSizeProvider<T> {
    private final int[] size;

    @Override // com.bumptech.glide.ListPreloader.PreloadSizeProvider
    public int[] getPreloadSize(T t, int i, int i2) {
        return this.size;
    }

    public FixedPreloadSizeProvider(int i, int i2) {
        this.size = new int[]{i, i2};
    }
}
