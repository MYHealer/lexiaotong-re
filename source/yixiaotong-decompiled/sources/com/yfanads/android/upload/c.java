package com.yfanads.android.upload;

import com.yfanads.android.libs.net.NetCallBack;
import com.yfanads.android.model.EventData;
import com.yfanads.android.utils.YFLog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ScheduledTask.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class c extends NetCallBack.NetCallBackString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f9686a;
    public final /* synthetic */ d b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d dVar, boolean z, ArrayList arrayList) {
        super(false, z);
        this.b = dVar;
        this.f9686a = arrayList;
    }

    @Override // com.yfanads.android.libs.net.NetCallBack
    /* JADX INFO: renamed from: onFailure */
    public final void m1259lambda$onError$0$comyfanadsandroidlibsnetNetCallBack(int i, String str) {
        YFLog.high("ScheduledTask upload fail " + i);
        d dVar = this.b;
        synchronized (dVar) {
            dVar.b = false;
        }
        if (i == 99500) {
            com.yfanads.android.net.d.b.f9654a.a(com.yfanads.android.net.a.TRACKER, false);
        }
    }

    @Override // com.yfanads.android.libs.net.NetCallBack
    /* JADX INFO: renamed from: onResponse */
    public final void m1262lambda$onSuccess$3$comyfanadsandroidlibsnetNetCallBack(String str) {
        YFLog.high("ScheduledTask upload success " + Thread.currentThread().getName());
        d dVar = this.b;
        List<EventData> list = this.f9686a;
        dVar.getClass();
        try {
            int iA = com.yfanads.android.db.dao.b.a.f9645a.a(list);
            if (iA > -1) {
                YFLog.high("ScheduledTask deleteAndQueryData success, has " + iA + " data ");
                dVar.f9687a.set(iA);
            } else {
                YFLog.high("ScheduledTask deleteAndQueryData fail");
            }
        } catch (Exception e) {
            YFLog.high("ScheduledTask doSuccess error: " + e.getMessage());
        }
        d dVar2 = this.b;
        synchronized (dVar2) {
            dVar2.b = false;
        }
        com.yfanads.android.net.d.b.f9654a.a(com.yfanads.android.net.a.TRACKER, true);
    }
}
