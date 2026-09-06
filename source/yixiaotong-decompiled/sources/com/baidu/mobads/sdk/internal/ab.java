package com.baidu.mobads.sdk.internal;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class ab implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ aa f1711a;

    ab(aa aaVar) {
        this.f1711a = aaVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1711a.a("加载dex超过5秒");
    }
}
