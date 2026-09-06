package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.CancellationToken;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class c extends CancellationToken {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Runnable> f3766a = new ArrayList();
    public final Object b = new Object();
    public boolean c = false;

    @Override // com.huawei.hmf.tasks.CancellationToken
    public final boolean isCancellationRequested() {
        return this.c;
    }

    @Override // com.huawei.hmf.tasks.CancellationToken
    public final CancellationToken register(Runnable runnable) {
        synchronized (this.b) {
            if (this.c) {
                runnable.run();
            } else {
                this.f3766a.add(runnable);
            }
        }
        return this;
    }
}
