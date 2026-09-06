package com.facebook.datasource;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface DataSource<T> {
    boolean close();

    @Nullable
    Throwable getFailureCause();

    float getProgress();

    @Nullable
    T getResult();

    boolean hasFailed();

    boolean hasResult();

    boolean isClosed();

    boolean isFinished();

    void subscribe(DataSubscriber<T> dataSubscriber, Executor executor);
}
