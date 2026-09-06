package com.kwad.sdk.core.videocache.a;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class g extends e {
    private final long maxSize;

    @Override // com.kwad.sdk.core.videocache.a.e
    protected final boolean aQ(long j) {
        return j <= this.maxSize;
    }

    public g(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("Max size must be positive number!");
        }
        this.maxSize = j;
    }
}
