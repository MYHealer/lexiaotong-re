package com.yfanads.android.utils.log;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class LogLevelInterceptImpl implements LogLevelInterceptInterface {
    private final int level;

    public LogLevelInterceptImpl(int i) {
        this.level = i;
    }

    @Override // com.yfanads.android.utils.log.LogLevelInterceptInterface
    public int logLevelIntercept() {
        return this.level;
    }
}
