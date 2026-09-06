package com.yfanads.android.net;

import com.yfanads.android.utils.YFLog;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: compiled from: DomainMgr.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class c implements d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f9652a;
    public final /* synthetic */ d b;

    public c(d dVar, String str) {
        this.b = dVar;
        this.f9652a = str;
    }

    @Override // com.yfanads.android.net.d.a
    public final void a() {
        d dVar = this.b;
        dVar.c = 3;
        dVar.d.set(0);
        ScheduledFuture<?> scheduledFuture = dVar.g;
        if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
            dVar.g.cancel(false);
            YFLog.high("Domain cancelTrackerRetrySchedule");
        }
        ScheduledFuture<?> scheduledFuture2 = dVar.i;
        if (scheduledFuture2 == null || scheduledFuture2.isCancelled()) {
            return;
        }
        dVar.i.cancel(false);
        YFLog.high("Domain cancelTrackerQuerySchedule");
    }

    @Override // com.yfanads.android.net.d.a
    public final void b() {
        d dVar = this.b;
        ScheduledFuture<?> scheduledFuture = dVar.g;
        if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
            dVar.g.cancel(false);
            YFLog.high("Domain cancelTrackerRetrySchedule");
        }
        this.b.b(a.TRACKER, this.f9652a);
    }
}
