package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class cq extends j {
    final /* synthetic */ cp b;

    cq(cp cpVar) {
        this.b = cpVar;
    }

    @Override // com.baidu.mobads.sdk.internal.j
    protected Object i() {
        try {
            String strA = this.b.a("key_crash_trace");
            String strA2 = this.b.a("key_crash_ad");
            if (TextUtils.isEmpty(strA)) {
                return null;
            }
            cm cmVarA = cm.a();
            cmVarA.a(this.b.n);
            cmVarA.a(this.b.a("key_crash_source"), strA, strA2);
            this.b.g();
            return null;
        } catch (Exception e) {
            bv.a().a(e);
            return null;
        }
    }
}
