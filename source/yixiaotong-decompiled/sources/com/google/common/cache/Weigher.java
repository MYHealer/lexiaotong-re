package com.google.common.cache;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
@ElementTypesAreNonnullByDefault
public interface Weigher<K, V> {
    int weigh(K k, V v);
}
