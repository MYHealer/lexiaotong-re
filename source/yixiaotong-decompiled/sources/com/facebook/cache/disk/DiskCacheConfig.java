package com.facebook.cache.disk;

import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.cache.common.NoOpCacheErrorLogger;
import com.facebook.cache.common.NoOpCacheEventListener;
import com.facebook.common.disk.DiskTrimmableRegistry;
import com.facebook.common.disk.NoOpDiskTrimmableRegistry;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.Suppliers;
import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class DiskCacheConfig {
    private final String mBaseDirectoryName;
    private final Supplier<File> mBaseDirectoryPathSupplier;
    private final CacheErrorLogger mCacheErrorLogger;
    private final CacheEventListener mCacheEventListener;
    private final long mDefaultSizeLimit;
    private final DiskTrimmableRegistry mDiskTrimmableRegistry;
    private final long mLowDiskSpaceSizeLimit;
    private final long mMinimumSizeLimit;
    private final int mVersion;

    /* JADX INFO: renamed from: com.facebook.cache.disk.DiskCacheConfig$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public String getBaseDirectoryName() {
        return this.mBaseDirectoryName;
    }

    public Supplier<File> getBaseDirectoryPathSupplier() {
        return this.mBaseDirectoryPathSupplier;
    }

    public CacheErrorLogger getCacheErrorLogger() {
        return this.mCacheErrorLogger;
    }

    public CacheEventListener getCacheEventListener() {
        return this.mCacheEventListener;
    }

    public long getDefaultSizeLimit() {
        return this.mDefaultSizeLimit;
    }

    public DiskTrimmableRegistry getDiskTrimmableRegistry() {
        return this.mDiskTrimmableRegistry;
    }

    public long getLowDiskSpaceSizeLimit() {
        return this.mLowDiskSpaceSizeLimit;
    }

    public long getMinimumSizeLimit() {
        return this.mMinimumSizeLimit;
    }

    public int getVersion() {
        return this.mVersion;
    }

    /* synthetic */ DiskCacheConfig(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private DiskCacheConfig(Builder builder) {
        this.mVersion = builder.mVersion;
        this.mBaseDirectoryName = (String) Preconditions.checkNotNull(builder.mBaseDirectoryName);
        this.mBaseDirectoryPathSupplier = (Supplier) Preconditions.checkNotNull(builder.mBaseDirectoryPathSupplier);
        this.mDefaultSizeLimit = builder.mMaxCacheSize;
        this.mLowDiskSpaceSizeLimit = builder.mMaxCacheSizeOnLowDiskSpace;
        this.mMinimumSizeLimit = builder.mMaxCacheSizeOnVeryLowDiskSpace;
        this.mCacheErrorLogger = builder.mCacheErrorLogger == null ? NoOpCacheErrorLogger.getInstance() : builder.mCacheErrorLogger;
        this.mCacheEventListener = builder.mCacheEventListener == null ? NoOpCacheEventListener.getInstance() : builder.mCacheEventListener;
        this.mDiskTrimmableRegistry = builder.mDiskTrimmableRegistry == null ? NoOpDiskTrimmableRegistry.getInstance() : builder.mDiskTrimmableRegistry;
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public static class Builder {
        public String mBaseDirectoryName;
        public Supplier<File> mBaseDirectoryPathSupplier;
        public CacheErrorLogger mCacheErrorLogger;
        public CacheEventListener mCacheEventListener;
        public DiskTrimmableRegistry mDiskTrimmableRegistry;
        public long mMaxCacheSize;
        public long mMaxCacheSizeOnLowDiskSpace;
        public long mMaxCacheSizeOnVeryLowDiskSpace;
        public int mVersion;

        public Builder setBaseDirectoryName(String str) {
            this.mBaseDirectoryName = str;
            return this;
        }

        public Builder setBaseDirectoryPathSupplier(Supplier<File> supplier) {
            this.mBaseDirectoryPathSupplier = supplier;
            return this;
        }

        public Builder setCacheErrorLogger(CacheErrorLogger cacheErrorLogger) {
            this.mCacheErrorLogger = cacheErrorLogger;
            return this;
        }

        public Builder setCacheEventListener(CacheEventListener cacheEventListener) {
            this.mCacheEventListener = cacheEventListener;
            return this;
        }

        public Builder setDiskTrimmableRegistry(DiskTrimmableRegistry diskTrimmableRegistry) {
            this.mDiskTrimmableRegistry = diskTrimmableRegistry;
            return this;
        }

        public Builder setMaxCacheSize(long j) {
            this.mMaxCacheSize = j;
            return this;
        }

        public Builder setMaxCacheSizeOnLowDiskSpace(long j) {
            this.mMaxCacheSizeOnLowDiskSpace = j;
            return this;
        }

        public Builder setMaxCacheSizeOnVeryLowDiskSpace(long j) {
            this.mMaxCacheSizeOnVeryLowDiskSpace = j;
            return this;
        }

        public Builder setVersion(int i) {
            this.mVersion = i;
            return this;
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            this.mVersion = 1;
        }

        public Builder setBaseDirectoryPath(File file) {
            this.mBaseDirectoryPathSupplier = Suppliers.of(file);
            return this;
        }

        public DiskCacheConfig build() {
            return new DiskCacheConfig(this, null);
        }
    }
}
