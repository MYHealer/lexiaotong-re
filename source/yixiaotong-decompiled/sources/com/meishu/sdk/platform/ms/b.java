package com.meishu.sdk.platform.ms;

import com.meishu.sdk.core.ad.AdSlot;

/* JADX INFO: compiled from: BaseMsAd.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b extends com.meishu.sdk.core.ad.a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AdSlot f5160a;

    public b(com.meishu.sdk.meishu_ad.banner.a aVar) {
        super(null, "MS");
        this.f5160a = aVar;
    }

    @Override // com.meishu.sdk.platform.ms.c
    public AdSlot a() {
        return this.f5160a;
    }

    @Override // com.meishu.sdk.platform.ms.c
    public int getInteractionType() {
        return this.f5160a.getInteractionType();
    }
}
