package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.NoOpMemoryTrimmableRegistry;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class PoolConfig {
    private final PoolParams mBitmapPoolParams;
    private final PoolStatsTracker mBitmapPoolStatsTracker;
    private final PoolParams mFlexByteArrayPoolParams;
    private final MemoryTrimmableRegistry mMemoryTrimmableRegistry;
    private final PoolParams mNativeMemoryChunkPoolParams;
    private final PoolStatsTracker mNativeMemoryChunkPoolStatsTracker;
    private final PoolParams mSmallByteArrayPoolParams;
    private final PoolStatsTracker mSmallByteArrayPoolStatsTracker;

    /* JADX INFO: renamed from: com.facebook.imagepipeline.memory.PoolConfig$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public PoolParams getBitmapPoolParams() {
        return this.mBitmapPoolParams;
    }

    public PoolStatsTracker getBitmapPoolStatsTracker() {
        return this.mBitmapPoolStatsTracker;
    }

    public PoolParams getFlexByteArrayPoolParams() {
        return this.mFlexByteArrayPoolParams;
    }

    public MemoryTrimmableRegistry getMemoryTrimmableRegistry() {
        return this.mMemoryTrimmableRegistry;
    }

    public PoolParams getNativeMemoryChunkPoolParams() {
        return this.mNativeMemoryChunkPoolParams;
    }

    public PoolStatsTracker getNativeMemoryChunkPoolStatsTracker() {
        return this.mNativeMemoryChunkPoolStatsTracker;
    }

    public PoolParams getSmallByteArrayPoolParams() {
        return this.mSmallByteArrayPoolParams;
    }

    public PoolStatsTracker getSmallByteArrayPoolStatsTracker() {
        return this.mSmallByteArrayPoolStatsTracker;
    }

    /* synthetic */ PoolConfig(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private PoolConfig(Builder builder) {
        this.mBitmapPoolParams = builder.mBitmapPoolParams == null ? DefaultBitmapPoolParams.get() : builder.mBitmapPoolParams;
        this.mBitmapPoolStatsTracker = builder.mBitmapPoolStatsTracker == null ? NoOpPoolStatsTracker.getInstance() : builder.mBitmapPoolStatsTracker;
        this.mFlexByteArrayPoolParams = builder.mFlexByteArrayPoolParams == null ? DefaultFlexByteArrayPoolParams.get() : builder.mFlexByteArrayPoolParams;
        this.mMemoryTrimmableRegistry = builder.mMemoryTrimmableRegistry == null ? NoOpMemoryTrimmableRegistry.getInstance() : builder.mMemoryTrimmableRegistry;
        this.mNativeMemoryChunkPoolParams = builder.mNativeMemoryChunkPoolParams == null ? DefaultNativeMemoryChunkPoolParams.get() : builder.mNativeMemoryChunkPoolParams;
        this.mNativeMemoryChunkPoolStatsTracker = builder.mNativeMemoryChunkPoolStatsTracker == null ? NoOpPoolStatsTracker.getInstance() : builder.mNativeMemoryChunkPoolStatsTracker;
        this.mSmallByteArrayPoolParams = builder.mSmallByteArrayPoolParams == null ? DefaultByteArrayPoolParams.get() : builder.mSmallByteArrayPoolParams;
        this.mSmallByteArrayPoolStatsTracker = builder.mSmallByteArrayPoolStatsTracker == null ? NoOpPoolStatsTracker.getInstance() : builder.mSmallByteArrayPoolStatsTracker;
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public static class Builder {
        private PoolParams mBitmapPoolParams;
        private PoolStatsTracker mBitmapPoolStatsTracker;
        private PoolParams mFlexByteArrayPoolParams;
        private MemoryTrimmableRegistry mMemoryTrimmableRegistry;
        private PoolParams mNativeMemoryChunkPoolParams;
        private PoolStatsTracker mNativeMemoryChunkPoolStatsTracker;
        private PoolParams mSmallByteArrayPoolParams;
        private PoolStatsTracker mSmallByteArrayPoolStatsTracker;

        public Builder setFlexByteArrayPoolParams(PoolParams poolParams) {
            this.mFlexByteArrayPoolParams = poolParams;
            return this;
        }

        public Builder setMemoryTrimmableRegistry(MemoryTrimmableRegistry memoryTrimmableRegistry) {
            this.mMemoryTrimmableRegistry = memoryTrimmableRegistry;
            return this;
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
        }

        public Builder setBitmapPoolParams(PoolParams poolParams) {
            this.mBitmapPoolParams = (PoolParams) Preconditions.checkNotNull(poolParams);
            return this;
        }

        public Builder setBitmapPoolStatsTracker(PoolStatsTracker poolStatsTracker) {
            this.mBitmapPoolStatsTracker = (PoolStatsTracker) Preconditions.checkNotNull(poolStatsTracker);
            return this;
        }

        public Builder setNativeMemoryChunkPoolParams(PoolParams poolParams) {
            this.mNativeMemoryChunkPoolParams = (PoolParams) Preconditions.checkNotNull(poolParams);
            return this;
        }

        public Builder setNativeMemoryChunkPoolStatsTracker(PoolStatsTracker poolStatsTracker) {
            this.mNativeMemoryChunkPoolStatsTracker = (PoolStatsTracker) Preconditions.checkNotNull(poolStatsTracker);
            return this;
        }

        public Builder setSmallByteArrayPoolParams(PoolParams poolParams) {
            this.mSmallByteArrayPoolParams = (PoolParams) Preconditions.checkNotNull(poolParams);
            return this;
        }

        public Builder setSmallByteArrayPoolStatsTracker(PoolStatsTracker poolStatsTracker) {
            this.mSmallByteArrayPoolStatsTracker = (PoolStatsTracker) Preconditions.checkNotNull(poolStatsTracker);
            return this;
        }

        public PoolConfig build() {
            return new PoolConfig(this, null);
        }
    }
}
