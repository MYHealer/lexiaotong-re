package com.opos.cmn.func.dl.base.b;

import com.kwad.sdk.core.imageloader.KSImageLoader;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6113a = 1;

    @Override // com.opos.cmn.func.dl.base.b.d
    public final Executor a() {
        return new b();
    }

    @Override // com.opos.cmn.func.dl.base.b.d
    public final ThreadPoolExecutor b() {
        if (this.f6113a <= 0) {
            this.f6113a = 1;
        }
        int i = this.f6113a;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 30000L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new com.opos.cmn.func.dl.base.h.b("task_tp_thread"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    @Override // com.opos.cmn.func.dl.base.b.d
    public final ThreadPoolExecutor c() {
        return new com.opos.cmn.an.j.a.C0869a().b(Integer.MAX_VALUE).a(0).a("cache_tp_thread").c(KSImageLoader.InnerImageLoadingListener.MAX_DURATION).a(new SynchronousQueue()).a();
    }

    @Override // com.opos.cmn.func.dl.base.b.d
    public final ThreadPoolExecutor d() {
        return com.opos.cmn.an.j.b.b();
    }
}
