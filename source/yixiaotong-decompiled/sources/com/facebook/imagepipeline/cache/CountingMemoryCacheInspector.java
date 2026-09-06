package com.facebook.imagepipeline.cache;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class CountingMemoryCacheInspector<K, V> {
    private final CountingMemoryCache<K, V> mCountingBitmapCache;

    public static class DumpInfoEntry<K, V> {
        public final K key;
        public final CloseableReference<V> value;

        public DumpInfoEntry(K k, CloseableReference<V> closeableReference) {
            this.key = (K) Preconditions.checkNotNull(k);
            this.value = CloseableReference.cloneOrNull(closeableReference);
        }

        public void release() {
            CloseableReference.closeSafely((CloseableReference<?>) this.value);
        }
    }

    public static class DumpInfo<K, V> {
        public final int lruSize;
        public final int maxEntriesCount;
        public final int maxEntrySize;
        public final int maxSize;
        public final int size;
        public final List<DumpInfoEntry<K, V>> lruEntries = new ArrayList();
        public final List<DumpInfoEntry<K, V>> sharedEntries = new ArrayList();

        public DumpInfo(int i, int i2, MemoryCacheParams memoryCacheParams) {
            this.maxSize = memoryCacheParams.maxCacheSize;
            this.maxEntriesCount = memoryCacheParams.maxCacheEntries;
            this.maxEntrySize = memoryCacheParams.maxCacheEntrySize;
            this.size = i;
            this.lruSize = i2;
        }

        public void release() {
            Iterator<DumpInfoEntry<K, V>> it = this.lruEntries.iterator();
            while (it.hasNext()) {
                it.next().release();
            }
            Iterator<DumpInfoEntry<K, V>> it2 = this.sharedEntries.iterator();
            while (it2.hasNext()) {
                it2.next().release();
            }
        }
    }

    public CountingMemoryCacheInspector(CountingMemoryCache<K, V> countingMemoryCache) {
        this.mCountingBitmapCache = countingMemoryCache;
    }

    public DumpInfo dumpCacheContent() {
        DumpInfo dumpInfo;
        synchronized (this.mCountingBitmapCache) {
            dumpInfo = new DumpInfo(this.mCountingBitmapCache.getSizeInBytes(), this.mCountingBitmapCache.getEvictionQueueSizeInBytes(), this.mCountingBitmapCache.mMemoryCacheParams);
            Iterator<Map.Entry<K, CountingMemoryCache.Entry<K, V>>> it = this.mCountingBitmapCache.mCachedEntries.getMatchingEntries(null).iterator();
            while (it.hasNext()) {
                CountingMemoryCache.Entry<K, V> value = it.next().getValue();
                DumpInfoEntry<K, V> dumpInfoEntry = new DumpInfoEntry<>(value.key, value.valueRef);
                if (value.clientCount > 0) {
                    dumpInfo.sharedEntries.add(dumpInfoEntry);
                } else {
                    dumpInfo.lruEntries.add(dumpInfoEntry);
                }
            }
        }
        return dumpInfo;
    }
}
