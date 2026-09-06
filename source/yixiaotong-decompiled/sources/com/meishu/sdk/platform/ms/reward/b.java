package com.meishu.sdk.platform.ms.reward;

import com.meishu.sdk.core.ad.reward.RewardVideoLoader;
import com.meishu.sdk.core.loader.IAdLoadListener;
import com.meishu.sdk.meishu_ad.nativ.f;
import com.meishu.sdk.meishu_ad.v;
import com.meishu.sdk.platform.ms.g;

/* JADX INFO: compiled from: MeishuRewardVideoAdWrapper.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b extends g<f, RewardVideoLoader, com.meishu.sdk.core.ad.reward.a> {
    public v b;

    /* JADX INFO: compiled from: MeishuRewardVideoAdWrapper.java */
    public class a extends com.meishu.sdk.platform.ms.reward.a {
        public a(b bVar, g gVar, IAdLoadListener iAdLoadListener, f fVar) {
            super(gVar, iAdLoadListener, fVar);
        }
    }

    public b(RewardVideoLoader rewardVideoLoader, f fVar) {
        super(rewardVideoLoader, fVar);
        this.b = new v(rewardVideoLoader.getContext());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.meishu.sdk.core.loader.IAdLoadListener] */
    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        try {
            if (getLoaderListener() != 0) {
                ((com.meishu.sdk.core.ad.reward.a) getLoaderListener()).onAdLoaded(null);
            }
            ?? loaderListener = getLoaderListener();
            T t = this.f5177a;
            this.b.a((f) t, new a(this, this, loaderListener, (f) t), (com.meishu.sdk.core.ad.b) getAdLoader());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
