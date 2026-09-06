package com.baidu.mobads.sdk.internal;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class ac implements cb.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ aa f1712a;

    ac(aa aaVar) {
        this.f1712a = aaVar;
    }

    @Override // com.baidu.mobads.sdk.internal.cb.c
    public void a(boolean z) {
        if (z) {
            try {
                if (h.f1813a != null) {
                    this.f1712a.b = h.f1813a.i();
                    if (this.f1712a.b != null) {
                        this.f1712a.k();
                        return;
                    }
                }
            } catch (Exception unused) {
                this.f1712a.a("加载dex异常");
                return;
            }
        }
        h.f1813a = null;
        this.f1712a.a("加载dex失败");
    }
}
