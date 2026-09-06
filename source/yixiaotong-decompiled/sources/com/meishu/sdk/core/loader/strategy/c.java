package com.meishu.sdk.core.loader.strategy;

import com.meishu.sdk.core.safe.l;

/* JADX INFO: compiled from: PriceFirstStrategy.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.meishu.sdk.core.loader.loadbean.a f4817a;
    public final /* synthetic */ e b;

    public c(e eVar, com.meishu.sdk.core.loader.loadbean.a aVar) {
        this.b = eVar;
        this.f4817a = aVar;
    }

    @Override // com.meishu.sdk.core.safe.l
    public void safeRun() {
        int i;
        com.meishu.sdk.core.loader.loadbean.a aVar = this.f4817a;
        if (aVar != null && ((i = aVar.c) == 1 || i == 4)) {
            synchronized (aVar) {
                aVar.c = 5;
            }
            this.f4817a.d = 2;
        }
        this.b.p.remove(this.f4817a);
        this.b.h();
    }
}
