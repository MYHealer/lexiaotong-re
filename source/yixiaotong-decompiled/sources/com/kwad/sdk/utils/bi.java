package com.kwad.sdk.utils;

import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class bi implements Runnable {
    private boolean needReport;

    public abstract void doTask();

    public bi() {
        this.needReport = true;
    }

    public bi(boolean z) {
        this.needReport = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.kwad.sdk.service.a.e eVar;
        try {
            doTask();
        } catch (Throwable th) {
            if (!this.needReport || (eVar = (com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)) == null) {
                return;
            }
            eVar.gatherException(th);
        }
    }
}
