package com.unionpay;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class q implements aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UPPayWapActivity f9331a;

    q(UPPayWapActivity uPPayWapActivity) {
        this.f9331a = uPPayWapActivity;
    }

    @Override // com.unionpay.aa
    public final void a(String str, ab abVar) {
        String strA = UPPayAssistEx.a(this.f9331a);
        if (abVar != null) {
            abVar.a(UPPayWapActivity.b("0", "success", strA));
        }
    }
}
