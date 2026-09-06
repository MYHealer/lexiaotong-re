package com.meishu.sdk.core.loader.concurrent;

import com.meishu.sdk.core.safe.l;

/* JADX INFO: compiled from: ConCurrentManager.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class d extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f4811a;
    public final /* synthetic */ e b;

    public d(e eVar, Object obj) {
        this.b = eVar;
        this.f4811a = obj;
    }

    @Override // com.meishu.sdk.core.safe.l
    public void safeRun() {
        e.a(this.b, this.f4811a);
    }
}
