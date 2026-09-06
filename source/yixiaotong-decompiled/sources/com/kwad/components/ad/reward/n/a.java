package com.kwad.components.ad.reward.n;

import android.content.Context;
import client.android.yixiaotong.v3.comman.AppTypeIdUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class a implements b {
    private Context mContext;
    private com.kwad.components.ad.reward.g uj;

    public a(Context context, com.kwad.components.ad.reward.g gVar) {
        this.uj = gVar;
        this.mContext = context;
    }

    @Override // com.kwad.components.ad.reward.n.b
    /* JADX INFO: renamed from: if, reason: not valid java name */
    public final void mo981if() {
        this.uj.a(1, this.mContext, 1, 1);
    }

    @Override // com.kwad.components.ad.reward.n.b
    public void jE() {
        this.uj.a(1, this.mContext, 13, 2);
    }

    @Override // com.kwad.components.ad.reward.n.b
    public void jF() {
        this.uj.a(1, this.mContext, AppTypeIdUtil.Drink4GCostControl_1, 2);
    }
}
