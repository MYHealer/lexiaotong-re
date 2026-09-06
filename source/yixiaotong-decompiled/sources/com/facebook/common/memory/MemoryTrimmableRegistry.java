package com.facebook.common.memory;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface MemoryTrimmableRegistry {
    void registerMemoryTrimmable(MemoryTrimmable memoryTrimmable);

    void unregisterMemoryTrimmable(MemoryTrimmable memoryTrimmable);
}
