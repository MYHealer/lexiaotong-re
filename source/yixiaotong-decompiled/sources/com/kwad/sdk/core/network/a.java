package com.kwad.sdk.core.network;

import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.bi;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class a<R extends f> {
    private static final ExecutorService sExecutors = GlobalThreadPools.Od();
    private Future<?> mTask;

    protected abstract R createRequest();

    protected abstract void fetchImpl();

    protected ExecutorService getExecutor() {
        return sExecutors;
    }

    protected abstract void onResponse(R r, c cVar);

    protected void fetch() {
        this.mTask = getExecutor().submit(new bi() { // from class: com.kwad.sdk.core.network.a.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                a.this.fetchImpl();
            }
        });
    }

    protected void cancel() {
        Future<?> future = this.mTask;
        if (future != null) {
            future.cancel(true);
        }
    }
}
