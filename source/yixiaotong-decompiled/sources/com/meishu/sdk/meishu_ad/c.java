package com.meishu.sdk.meishu_ad;

import java.util.List;

/* JADX INFO: compiled from: AdNative.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c implements com.meishu.sdk.meishu_ad.nativ.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f5005a;

    public c(e eVar) {
        this.f5005a = eVar;
    }

    @Override // com.meishu.sdk.meishu_ad.m0
    public void onADExposure() {
    }

    @Override // com.meishu.sdk.meishu_ad.m0
    public /* bridge */ /* synthetic */ void onADLoaded(List<com.meishu.sdk.meishu_ad.nativ.b> list) {
    }

    @Override // com.meishu.sdk.meishu_ad.m0
    public void onAdRenderFail(String str, int i) {
        e eVar = this.f5005a;
        eVar.f.a(eVar.f5010a, str, Integer.valueOf(i));
    }
}
