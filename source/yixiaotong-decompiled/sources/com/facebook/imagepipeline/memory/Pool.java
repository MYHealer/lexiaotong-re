package com.facebook.imagepipeline.memory;

import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.references.ResourceReleaser;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface Pool<V> extends ResourceReleaser<V>, MemoryTrimmable {
    V get(int i);

    @Override // com.facebook.common.references.ResourceReleaser
    void release(V v);
}
