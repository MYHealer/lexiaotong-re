package com.hihonor.adsdk.reward.d;

import com.hihonor.adsdk.base.AdSlot;
import com.hihonor.adsdk.base.api.BaseAdImpl;
import com.hihonor.adsdk.base.api.reward.RewardAdLoadListener;
import com.hihonor.adsdk.base.api.reward.RewardExpressAd;
import com.hihonor.adsdk.base.bean.BaseAdInfo;
import com.hihonor.adsdk.base.bean.BaseAdInfoResp;
import com.hihonor.adsdk.base.bean.Video;
import com.hihonor.adsdk.base.g.j.d.j1.f;
import com.hihonor.adsdk.base.j.c;
import com.hihonor.adsdk.common.f.a0;
import com.hihonor.adsdk.reward.RewardExpressAdImpl;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a extends com.hihonor.adsdk.base.api.b<RewardAdLoadListener> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3560a = "RewardAdLoadImpl";

    private void a(final RewardExpressAd rewardExpressAd) {
        a0.hnadsc(new Runnable() { // from class: com.hihonor.adsdk.reward.d.a$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(rewardExpressAd);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(RewardExpressAd rewardExpressAd) {
        if (this.hnadsb != 0) {
            ((RewardAdLoadListener) this.hnadsb).onLoadSuccess(rewardExpressAd);
            this.hnadsb = null;
        }
    }

    @Override // com.hihonor.adsdk.base.api.b
    protected void hnadsa(int i, String str, BaseAdInfoResp baseAdInfoResp) {
        String rewardName;
        double rewardAmount;
        Video video;
        if (baseAdInfoResp == null || baseAdInfoResp.getList() == null || baseAdInfoResp.getList().size() < 1) {
            return;
        }
        BaseAdInfo baseAdInfoHnadsb = hnadsb(baseAdInfoResp);
        BaseAdImpl baseAdImpl = new BaseAdImpl(baseAdInfoHnadsb);
        if (baseAdImpl.getSubType() == 13 && (video = baseAdImpl.getVideo()) != null) {
            hnadsc(video.getVideoUrl());
        }
        ArrayList arrayList = new ArrayList();
        AdSlot adSlot = this.hnadsa;
        if (adSlot != null) {
            rewardName = adSlot.getRewardName();
            rewardAmount = this.hnadsa.getRewardAmount();
        } else {
            rewardName = "";
            rewardAmount = 0.0d;
        }
        a(new RewardExpressAdImpl(null, baseAdInfoHnadsb, rewardAmount, rewardName));
        arrayList.add(baseAdInfoHnadsb.getAdId());
        a(baseAdInfoResp, arrayList);
        hnadsn();
        AdSlot adSlot2 = this.hnadsa;
        hnadsa(baseAdInfoResp, adSlot2 != null ? adSlot2.getDataType() : 0);
    }

    @Override // com.hihonor.adsdk.base.api.b
    protected int hnadsb() {
        return 4;
    }

    @Override // com.hihonor.adsdk.base.api.b
    protected boolean hnadsk() {
        com.hihonor.adsdk.common.b.b.hnadsc(f3560a, "isSupportPreCache: false", new Object[0]);
        return false;
    }

    private void a(BaseAdInfoResp baseAdInfoResp, List<String> list) {
        String strHnadsa = c.hnadsa(baseAdInfoResp);
        String strHnadsb = c.hnadsb(baseAdInfoResp);
        com.hihonor.adsdk.base.bean.b bVarHnadsb = hnadsb(strHnadsa);
        new f(bVarHnadsb, list, strHnadsa, com.hihonor.adsdk.base.g.j.g.b.hnadsa(bVarHnadsb, strHnadsb)).hnadse();
    }
}
