package com.baidu.mobads.sdk.internal;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class by implements ck.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ bx f1761a;

    by(bx bxVar) {
        this.f1761a = bxVar;
    }

    @Override // com.baidu.mobads.sdk.internal.ck.a
    public void a(bz bzVar) {
        this.f1761a.a("OK", bzVar, "download apk successfully, downloader exit");
        bx unused = bx.h = null;
    }

    @Override // com.baidu.mobads.sdk.internal.ck.a
    public void b(bz bzVar) {
        this.f1761a.a(cb.l, bzVar, "downloadApk failed");
    }
}
