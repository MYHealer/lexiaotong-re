package com.kwad.components.core.proxy.a;

import android.os.SystemClock;
import com.kwad.components.core.proxy.PageCreateStage;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a {
    private String ajo;
    private long ajp;
    private long ajq;
    private long ajr;
    private boolean ajs;
    private c ajt;

    public final void bg(String str) {
        this.ajo = str;
    }

    public a(c cVar) {
        this.ajt = cVar;
    }

    public final void R(long j) {
        this.ajp = j;
        this.ajq = SystemClock.uptimeMillis();
    }

    public final void vK() {
        if (this.ajs) {
            return;
        }
        this.ajs = true;
        by.runOnUiThread(new bi() { // from class: com.kwad.components.core.proxy.a.a.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                a.this.ajr = SystemClock.uptimeMillis();
                a.this.report();
            }
        });
    }

    public final void a(PageCreateStage pageCreateStage) {
        c cVar = this.ajt;
        if (cVar != null) {
            cVar.onCreateStageChange(pageCreateStage);
        }
    }

    public final void report() {
        b bVar = new b();
        bVar.ajo = this.ajo;
        long j = this.ajp;
        bVar.ajw = j != 0 ? this.ajq - j : 0L;
        long j2 = this.ajq;
        bVar.ajx = j2 != 0 ? this.ajr - j2 : 0L;
        long j3 = this.ajp;
        bVar.ajv = j3 != 0 ? this.ajr - j3 : 0L;
        com.kwad.components.core.p.a.vL().a(bVar);
        com.kwad.sdk.core.d.c.d("PageMonitor", bVar.toString());
    }
}
