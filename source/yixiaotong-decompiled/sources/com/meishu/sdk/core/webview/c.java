package com.meishu.sdk.core.webview;

/* JADX INFO: compiled from: DisplayTimeOutMonitor.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c extends com.meishu.sdk.core.safe.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f4977a;
    public final /* synthetic */ int b;
    public final /* synthetic */ b c;

    public c(b bVar, boolean z, int i) {
        this.c = bVar;
        this.f4977a = z;
        this.b = i;
    }

    @Override // com.meishu.sdk.core.safe.l
    public void safeRun() {
        b.a(this.c, this.f4977a, this.b);
    }
}
