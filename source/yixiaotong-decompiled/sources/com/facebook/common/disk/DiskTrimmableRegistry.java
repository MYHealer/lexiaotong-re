package com.facebook.common.disk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface DiskTrimmableRegistry {
    void registerDiskTrimmable(DiskTrimmable diskTrimmable);

    void unregisterDiskTrimmable(DiskTrimmable diskTrimmable);
}
