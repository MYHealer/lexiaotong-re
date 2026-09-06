package com.facebook.cache.common;

import com.facebook.common.internal.Preconditions;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class SimpleCacheKey implements CacheKey {
    final String mKey;

    @Override // com.facebook.cache.common.CacheKey
    public String toString() {
        return this.mKey;
    }

    public SimpleCacheKey(String str) {
        this.mKey = (String) Preconditions.checkNotNull(str);
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SimpleCacheKey) {
            return this.mKey.equals(((SimpleCacheKey) obj).mKey);
        }
        return false;
    }

    @Override // com.facebook.cache.common.CacheKey
    public int hashCode() {
        return this.mKey.hashCode();
    }
}
