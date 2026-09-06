package com.unionpay;

import com.unionpay.utils.UPUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class s implements aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UPPayWapActivity f9333a;

    s(UPPayWapActivity uPPayWapActivity) {
        this.f9333a = uPPayWapActivity;
    }

    @Override // com.unionpay.aa
    public final void a(String str, ab abVar) {
        String strA = UPUtils.a(this.f9333a, str);
        if (abVar != null) {
            abVar.a(UPPayWapActivity.b("0", "success", strA));
        }
    }
}
