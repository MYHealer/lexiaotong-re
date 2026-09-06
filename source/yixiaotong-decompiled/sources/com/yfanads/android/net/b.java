package com.yfanads.android.net;

import com.yfanads.android.utils.YFLog;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: compiled from: DomainMgr.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class b implements d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f9651a;
    public final /* synthetic */ d b;

    public b(d dVar, String str) {
        this.b = dVar;
        this.f9651a = str;
    }

    @Override // com.yfanads.android.net.d.a
    public final void a() {
        d dVar = this.b;
        dVar.f9653a = 3;
        dVar.b.set(0);
        ScheduledFuture<?> scheduledFuture = dVar.f;
        if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
            dVar.f.cancel(false);
            YFLog.high("Domain cancelApiRetrySchedule");
        }
        ScheduledFuture<?> scheduledFuture2 = dVar.h;
        if (scheduledFuture2 == null || scheduledFuture2.isCancelled()) {
            return;
        }
        dVar.h.cancel(false);
        YFLog.high("Domain cancelApiQuerySchedule success");
    }

    @Override // com.yfanads.android.net.d.a
    public final void b() {
        d dVar = this.b;
        ScheduledFuture<?> scheduledFuture = dVar.f;
        if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
            dVar.f.cancel(false);
            YFLog.high("Domain cancelApiRetrySchedule");
        }
        this.b.b(a.API, this.f9651a);
    }
}
