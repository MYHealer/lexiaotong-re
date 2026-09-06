package com.huawei.hms.common.internal;

import com.huawei.hmf.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class TaskApiCallWrapper<TResult> extends BaseContentWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TaskApiCall<? extends AnyClient, TResult> f3984a;
    private final TaskCompletionSource<TResult> b;

    public TaskApiCallWrapper(TaskApiCall<? extends AnyClient, TResult> taskApiCall, TaskCompletionSource<TResult> taskCompletionSource) {
        super(1);
        this.f3984a = taskApiCall;
        this.b = taskCompletionSource;
    }

    public TaskApiCall<? extends AnyClient, TResult> getTaskApiCall() {
        return this.f3984a;
    }

    public TaskCompletionSource<TResult> getTaskCompletionSource() {
        return this.b;
    }
}
