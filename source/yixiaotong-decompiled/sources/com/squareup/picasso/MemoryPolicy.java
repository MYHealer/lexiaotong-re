package com.squareup.picasso;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public enum MemoryPolicy {
    NO_CACHE(1),
    NO_STORE(2);

    final int index;

    static boolean shouldReadFromMemoryCache(int i) {
        return (i & NO_CACHE.index) == 0;
    }

    static boolean shouldWriteToMemoryCache(int i) {
        return (i & NO_STORE.index) == 0;
    }

    MemoryPolicy(int i) {
        this.index = i;
    }
}
