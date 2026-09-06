package com.meishu.sdk.core.utils;

/* JADX INFO: compiled from: VideoLoadManager.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class r1 extends com.meishu.sdk.core.safe.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.meishu.sdk.core.bquery.h f4940a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;

    public r1(VideoLoadManager videoLoadManager, com.meishu.sdk.core.bquery.h hVar, int i, String str) {
        this.f4940a = hVar;
        this.b = i;
        this.c = str;
    }

    @Override // com.meishu.sdk.core.safe.l
    public void safeRun() {
        this.f4940a.onFail(this.b, this.c);
    }
}
