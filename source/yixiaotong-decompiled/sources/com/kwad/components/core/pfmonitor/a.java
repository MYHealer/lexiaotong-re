package com.kwad.components.core.pfmonitor;

import com.kwad.components.core.pfmonitor.model.e;
import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
final class a implements b.InterfaceC0687b, Runnable {
    private e aig;
    private com.kwad.components.core.pfmonitor.model.c aih;
    private int aii = 0;
    private final int aij;

    public final int getStatus() {
        return this.aii;
    }

    public final com.kwad.components.core.pfmonitor.model.c vr() {
        if (this.aii == 2) {
            return this.aih;
        }
        return null;
    }

    public a(e eVar, int i) {
        this.aij = i;
        this.aig = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.aii = 1;
        try {
            com.kwad.components.core.pfmonitor.model.c cVarA = b.a(new File(this.aig.vv()), null, this.aij, this);
            this.aih = cVarA;
            cVarA.a(this.aig);
            this.aii = 2;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            this.aii = 3;
        }
        if (this.aih == null) {
            this.aii = 3;
        }
    }
}
