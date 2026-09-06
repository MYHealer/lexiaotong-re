package com.yfanads.android.utils.log;

import com.google.android.exoplayer2.upstream.cache.CacheDataSink;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class DefaultsLogFactory {
    public static FileNameGenerator createFileNameGenerator() {
        return new DateFileNameGenerator();
    }

    public static LogContentGenerator createLogContentGenerator() {
        return new DateLogContentGenerator();
    }

    public static LogLevelInterceptInterface createLogLevel() {
        return new LogLevelInterceptImpl(2);
    }

    public static long createLogMaxSize() {
        return CacheDataSink.DEFAULT_FRAGMENT_SIZE;
    }

    public static int createLogUploadIntervalTime() {
        return 60000;
    }
}
