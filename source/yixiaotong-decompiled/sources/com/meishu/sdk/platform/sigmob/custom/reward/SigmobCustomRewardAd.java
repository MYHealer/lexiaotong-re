package com.meishu.sdk.platform.sigmob.custom.reward;

import android.app.Activity;
import com.meishu.sdk.core.utils.o1;
import com.meishu.sdk.platform.custom.reward.MsCustomRewardAd;
import com.meishu.sdk.platform.custom.reward.MsCustomRewardAdapter;
import com.sigmob.windad.rewardVideo.WindRewardVideoAd;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class SigmobCustomRewardAd extends MsCustomRewardAd {
    private MsCustomRewardAdapter adWrapper;
    private WindRewardVideoAd windRewardVideoAd;

    public SigmobCustomRewardAd(MsCustomRewardAdapter msCustomRewardAdapter, WindRewardVideoAd windRewardVideoAd) {
        super(msCustomRewardAdapter);
        this.adWrapper = msCustomRewardAdapter;
        this.windRewardVideoAd = windRewardVideoAd;
    }

    @Override // com.meishu.sdk.platform.custom.reward.MsCustomRewardAd, com.meishu.sdk.core.ad.reward.RewardVideoAd
    public void showAd() {
        WindRewardVideoAd windRewardVideoAd = this.windRewardVideoAd;
        if (windRewardVideoAd == null || !windRewardVideoAd.isReady()) {
            return;
        }
        try {
            MsCustomRewardAdapter msCustomRewardAdapter = this.adWrapper;
            if (msCustomRewardAdapter != null && msCustomRewardAdapter.getSdkAdInfo() != null && "bidding".equals(this.adWrapper.getSdkAdInfo().getOtype())) {
                WindRewardVideoAd windRewardVideoAd2 = this.windRewardVideoAd;
                windRewardVideoAd2.setBidEcpm(Integer.parseInt(windRewardVideoAd2.getEcpm()));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.windRewardVideoAd.show((HashMap) null);
        MsCustomRewardAdapter msCustomRewardAdapter2 = this.adWrapper;
        if (msCustomRewardAdapter2 == null || msCustomRewardAdapter2.getSdkAdInfo() == null) {
            return;
        }
        o1.b(this.adWrapper.getSdkAdInfo().getEventUrl());
    }

    @Override // com.meishu.sdk.core.ad.reward.RewardVideoAd
    public void destroy() {
        WindRewardVideoAd windRewardVideoAd = this.windRewardVideoAd;
        if (windRewardVideoAd != null) {
            windRewardVideoAd.destroy();
        }
    }

    @Override // com.meishu.sdk.core.ad.reward.RewardVideoAd
    public void showAd(Activity activity) {
        WindRewardVideoAd windRewardVideoAd = this.windRewardVideoAd;
        if (windRewardVideoAd == null || !windRewardVideoAd.isReady()) {
            return;
        }
        try {
            MsCustomRewardAdapter msCustomRewardAdapter = this.adWrapper;
            if (msCustomRewardAdapter != null && msCustomRewardAdapter.getSdkAdInfo() != null && "bidding".equals(this.adWrapper.getSdkAdInfo().getOtype())) {
                WindRewardVideoAd windRewardVideoAd2 = this.windRewardVideoAd;
                windRewardVideoAd2.setBidEcpm(Integer.parseInt(windRewardVideoAd2.getEcpm()));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.windRewardVideoAd.show((HashMap) null);
        MsCustomRewardAdapter msCustomRewardAdapter2 = this.adWrapper;
        if (msCustomRewardAdapter2 == null || msCustomRewardAdapter2.getSdkAdInfo() == null) {
            return;
        }
        o1.b(this.adWrapper.getSdkAdInfo().getEventUrl());
    }
}
