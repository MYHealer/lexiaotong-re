package com.kwad.sdk.utils;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class LruHashMap<K, V> extends LinkedHashMap<K, V> {
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private final long maxSize;

    public long getMaxSize() {
        return this.maxSize;
    }

    public LruHashMap(long j) {
        super(((int) Math.ceil(j / 0.75f)) + 1, 0.75f, true);
        this.maxSize = j;
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
        return ((long) size()) > this.maxSize;
    }
}
