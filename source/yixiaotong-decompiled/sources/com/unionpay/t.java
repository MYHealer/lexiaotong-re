package com.unionpay;

import com.unionpay.utils.UPUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class t implements aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UPPayWapActivity f9334a;

    t(UPPayWapActivity uPPayWapActivity) {
        this.f9334a = uPPayWapActivity;
    }

    @Override // com.unionpay.aa
    public final void a(String str, ab abVar) {
        UPUtils.b(this.f9334a, str);
        if (abVar != null) {
            abVar.a(UPPayWapActivity.b("0", "success", (String) null));
        }
    }
}
