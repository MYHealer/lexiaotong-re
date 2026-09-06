package com.meishu.sdk.core.loader.concurrent;

import com.meishu.sdk.core.safe.l;

/* JADX INFO: compiled from: ConCurrentManager.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f4809a;
    public final /* synthetic */ e b;

    public b(e eVar, Object obj) {
        this.b = eVar;
        this.f4809a = obj;
    }

    @Override // com.meishu.sdk.core.safe.l
    public void safeRun() {
        e.a(this.b, this.f4809a);
    }
}
