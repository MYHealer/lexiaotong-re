package com.meishu.sdk.meishu_ad;

import com.meishu.sdk.meishu_ad.nativ.NormalMediaView;
import java.util.List;

/* JADX INFO: compiled from: AdNative.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class i0 implements n0.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.meishu.sdk.meishu_ad.nativ.f f5020a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ List c;
    public final /* synthetic */ com.meishu.sdk.meishu_ad.nativ.a d;

    public i0(com.meishu.sdk.meishu_ad.nativ.f fVar, boolean z, List list, com.meishu.sdk.meishu_ad.nativ.a aVar) {
        this.f5020a = fVar;
        this.b = z;
        this.c = list;
        this.d = aVar;
    }

    @Override // com.meishu.sdk.meishu_ad.n0.c
    public void onLoaded(n0 n0Var) {
        com.meishu.sdk.meishu_ad.nativ.d dVar = new com.meishu.sdk.meishu_ad.nativ.d(this.f5020a);
        com.meishu.sdk.meishu_ad.nativ.f fVar = this.f5020a;
        dVar.e = fVar.title;
        fVar.getCid();
        com.meishu.sdk.meishu_ad.nativ.f fVar2 = this.f5020a;
        dVar.f = fVar2.desc;
        dVar.b = fVar2.getAdPatternType();
        com.meishu.sdk.meishu_ad.nativ.f fVar3 = this.f5020a;
        dVar.c = fVar3.iconUrl;
        dVar.d = fVar3.getImageUrls();
        dVar.h = n0Var;
        dVar.g = this.b;
        this.c.add(dVar);
        ((NormalMediaView) n0Var).setMsAd(dVar);
        com.meishu.sdk.meishu_ad.nativ.a aVar = this.d;
        if (aVar != null) {
            aVar.onADLoaded(this.c);
        }
    }
}
