package com.facebook.cache.disk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class DiskCacheFactory {
    public static DiskStorageCache newDiskStorageCache(DiskCacheConfig diskCacheConfig) {
        return new DiskStorageCache(newDiskStorageSupplier(diskCacheConfig), new DiskStorageCache.Params(diskCacheConfig.getMinimumSizeLimit(), diskCacheConfig.getLowDiskSpaceSizeLimit(), diskCacheConfig.getDefaultSizeLimit()), diskCacheConfig.getCacheEventListener(), diskCacheConfig.getCacheErrorLogger(), diskCacheConfig.getDiskTrimmableRegistry());
    }

    private static DiskStorageSupplier newDiskStorageSupplier(DiskCacheConfig diskCacheConfig) {
        return new DefaultDiskStorageSupplier(diskCacheConfig.getVersion(), diskCacheConfig.getBaseDirectoryPathSupplier(), diskCacheConfig.getBaseDirectoryName(), diskCacheConfig.getCacheErrorLogger());
    }
}
