package com.huawei.hms.ads;

import com.huawei.hms.ads.reward.Reward;
import com.huawei.openalliance.ad.inter.data.RewardItem;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class ci implements Reward {
    private String Code;
    private int V;

    public ci() {
    }

    public ci(RewardItem rewardItem) {
        if (rewardItem != null) {
            this.Code = rewardItem.Code();
            this.V = rewardItem.V();
        }
    }

    @Override // com.huawei.hms.ads.reward.Reward
    public int getAmount() {
        return this.V;
    }

    @Override // com.huawei.hms.ads.reward.Reward
    public String getName() {
        return this.Code;
    }
}
