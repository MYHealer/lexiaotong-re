package com.hihonor.adsdk.reward;

import android.app.Activity;
import com.hihonor.adsdk.base.api.BaseExpressAdImpl;
import com.hihonor.adsdk.base.api.reward.RewardExpressAd;
import com.hihonor.adsdk.base.api.reward.RewardItem;
import com.hihonor.adsdk.base.bean.BaseAdInfo;
import com.hihonor.adsdk.base.callback.AdListener;
import com.hihonor.adsdk.base.widget.base.BaseAdView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class RewardExpressAdImpl extends BaseExpressAdImpl implements RewardExpressAd {
    private BaseAdInfo baseAdInfo;
    private AdListener hnadse;
    private RewardItem rewardItem;

    public RewardExpressAdImpl(BaseAdView baseAdView, BaseAdInfo baseAdInfo, double d, String str) {
        super(baseAdView, baseAdInfo);
        this.baseAdInfo = baseAdInfo;
        if (str == null || str.trim().isEmpty() || d <= 0.0d) {
            return;
        }
        this.rewardItem = new RewardItem(d, str);
    }

    private void a(String str) {
        new com.hihonor.adsdk.base.g.j.d.i1.a(str, com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.baseAdInfo)).hnadsa("type", "2").hnadsa(com.hihonor.adsdk.base.g.j.e.a.R0, "0").hnadse();
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAdImpl, com.hihonor.adsdk.base.api.BaseExpressAd
    public void release() {
        super.release();
    }

    @Override // com.hihonor.adsdk.base.api.reward.RewardExpressAd
    public void show(Activity activity) {
        show(activity, null);
    }

    @Override // com.hihonor.adsdk.base.api.reward.RewardExpressAd
    public void show(Activity activity, RewardExpressAd.RewardAdStatusListener rewardAdStatusListener) {
        a.a().a(getAdId(), rewardAdStatusListener);
        RewardActivity.a(getAdListener());
        BaseAdInfo baseAdInfo = this.baseAdInfo;
        a(baseAdInfo == null ? "" : baseAdInfo.getAdUnitId());
        RewardActivity.a(activity, this, this.rewardItem);
    }
}
