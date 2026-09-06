package com.meishu.sdk.core.loader.concurrent;

import com.meishu.sdk.core.safe.l;

/* JADX INFO: compiled from: ConCurrentManager.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f4810a;

    public c(e eVar) {
        this.f4810a = eVar;
    }

    @Override // com.meishu.sdk.core.safe.l
    public void safeRun() {
        try {
            this.f4810a.a(true);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
