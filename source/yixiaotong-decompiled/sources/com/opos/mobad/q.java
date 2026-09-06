package com.opos.mobad;

import android.content.Context;
import com.opos.mobad.activity.AdActivity;
import com.opos.mobad.ad.privacy.ComplianceInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class q implements com.opos.mobad.cmn.a.b {
    @Override // com.opos.mobad.cmn.a.b
    public boolean a(Context context, ComplianceInfo complianceInfo, com.opos.mobad.t.a.AbstractBinderC0999a abstractBinderC0999a) {
        return AdActivity.b(context, complianceInfo, abstractBinderC0999a);
    }

    @Override // com.opos.mobad.cmn.a.b
    public boolean b(Context context, ComplianceInfo complianceInfo, com.opos.mobad.t.a.AbstractBinderC0999a abstractBinderC0999a) {
        return AdActivity.a(context, complianceInfo, abstractBinderC0999a);
    }

    @Override // com.opos.mobad.cmn.a.b
    public boolean c(Context context, ComplianceInfo complianceInfo, com.opos.mobad.t.a.AbstractBinderC0999a abstractBinderC0999a) {
        return AdActivity.c(context, complianceInfo, abstractBinderC0999a);
    }
}
