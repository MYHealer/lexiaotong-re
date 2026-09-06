package com.meishu.sdk.core.utils;

import java.io.File;

/* JADX INFO: compiled from: VideoLoadManager.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class q1 extends com.meishu.sdk.core.safe.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.meishu.sdk.core.bquery.h f4936a;
    public final /* synthetic */ String b;
    public final /* synthetic */ File c;
    public final /* synthetic */ boolean d;

    public q1(VideoLoadManager videoLoadManager, com.meishu.sdk.core.bquery.h hVar, String str, File file, boolean z) {
        this.f4936a = hVar;
        this.b = str;
        this.c = file;
        this.d = z;
    }

    @Override // com.meishu.sdk.core.safe.l
    public void safeRun() {
        this.f4936a.a(this.b, this.c, this.d);
    }
}
