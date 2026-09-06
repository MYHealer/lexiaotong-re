package com.unionpay;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
final class u implements aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UPPayWapActivity f9361a;

    u(UPPayWapActivity uPPayWapActivity) {
        this.f9361a = uPPayWapActivity;
    }

    @Override // com.unionpay.aa
    public final void a(String str, ab abVar) {
        UPPayWapActivity.a(this.f9361a, Boolean.parseBoolean(str));
        if (abVar != null) {
            abVar.a(UPPayWapActivity.b("0", "success", (String) null));
        }
    }
}
