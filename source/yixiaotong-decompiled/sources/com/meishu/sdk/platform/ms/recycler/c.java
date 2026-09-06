package com.meishu.sdk.platform.ms.recycler;

import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.ad.recycler.RecyclerMixAdLoader;
import com.meishu.sdk.meishu_ad.v;

/* JADX INFO: compiled from: MeishuAdNativeWrapper.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c extends com.meishu.sdk.platform.ms.g<com.meishu.sdk.meishu_ad.nativ.f, RecyclerMixAdLoader, com.meishu.sdk.core.ad.recycler.a> {
    public v b;
    public a c;

    public c(RecyclerMixAdLoader recyclerMixAdLoader, com.meishu.sdk.meishu_ad.nativ.f fVar) {
        super(recyclerMixAdLoader, fVar);
        this.b = new v(recyclerMixAdLoader.getContext());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        try {
            if (getLoaderListener() != 0) {
                ((com.meishu.sdk.core.ad.recycler.a) getLoaderListener()).onAdLoaded(null);
            }
            this.c = new a(this, (com.meishu.sdk.core.ad.recycler.a) getLoaderListener());
            boolean isVideoAutoPlay = ((RecyclerMixAdLoader) getAdLoader()).getIsVideoAutoPlay();
            if (AdSdk.isTestMode) {
                isVideoAutoPlay = ((com.meishu.sdk.meishu_ad.nativ.f) this.f5177a).z;
            }
            boolean z = isVideoAutoPlay;
            v vVar = this.b;
            com.meishu.sdk.meishu_ad.nativ.f fVar = (com.meishu.sdk.meishu_ad.nativ.f) this.f5177a;
            a aVar = this.c;
            boolean zIsShowDetail = ((RecyclerMixAdLoader) getAdLoader()).isShowDetail();
            float fB = com.meishu.sdk.core.utils.m.b(getContext(), ((RecyclerMixAdLoader) getAdLoader()).getAccept_ad_width().intValue());
            float fB2 = com.meishu.sdk.core.utils.m.b(getContext(), ((RecyclerMixAdLoader) getAdLoader()).getAccept_ad_height().intValue());
            vVar.getClass();
            try {
                vVar.d = fVar.getEventUrl();
            } catch (Exception e) {
                e.printStackTrace();
            }
            vVar.a(fVar, (com.meishu.sdk.meishu_ad.nativ.a) aVar, true, zIsShowDetail, z, fB, fB2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
