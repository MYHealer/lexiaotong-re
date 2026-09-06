package com.meishu.sdk.core.utils;

import java.util.List;

/* JADX INFO: compiled from: VideoLoadManager.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class p1 extends com.meishu.sdk.core.safe.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f4931a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;

    public p1(VideoLoadManager videoLoadManager, List list, int i, String str) {
        this.f4931a = list;
        this.b = i;
        this.c = str;
    }

    @Override // com.meishu.sdk.core.safe.l
    public void safeRun() {
        for (com.meishu.sdk.core.bquery.h hVar : this.f4931a) {
            if (hVar != null) {
                hVar.onFail(this.b, this.c);
            }
        }
    }
}
