package com.meishu.sdk.platform.csj.reward;

import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.meishu.sdk.core.ad.reward.a;
import com.meishu.sdk.core.safe.l;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.SdkHandler;
import com.meishu.sdk.platform.csj.CSJPlatformError;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class RewardVideoListenerAdapter implements TTAdNative.RewardVideoAdListener {
    private static final String TAG = "RewardVideoListenerAdapter";
    private CSJRewardVideoAdWrapper adWrapper;
    private a apiAdListener;
    private RewardVideoAdAdapter rewardVideoAdAdapter;

    public RewardVideoListenerAdapter(CSJRewardVideoAdWrapper cSJRewardVideoAdWrapper, a aVar) {
        this.adWrapper = cSJRewardVideoAdWrapper;
        this.apiAdListener = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
    public void onError(int i, String str) {
        try {
            LogUtil.e(TAG, "onError, code: " + i + ", msg: " + str);
            new CSJPlatformError(str, Integer.valueOf(i), this.adWrapper.getSdkAdInfo()).post(this.apiAdListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
    public void onRewardVideoAdLoad(final TTRewardVideoAd tTRewardVideoAd) {
        SdkHandler.getInstance().runOnUiThread(new l() { // from class: com.meishu.sdk.platform.csj.reward.RewardVideoListenerAdapter.1
            @Override // com.meishu.sdk.core.safe.l
            public void safeRun() {
                try {
                    RewardVideoListenerAdapter rewardVideoListenerAdapter = RewardVideoListenerAdapter.this;
                    rewardVideoListenerAdapter.rewardVideoAdAdapter = new RewardVideoAdAdapter(rewardVideoListenerAdapter.adWrapper, tTRewardVideoAd);
                    tTRewardVideoAd.setRewardAdInteractionListener(new CSJInteractionListener(RewardVideoListenerAdapter.this.adWrapper, RewardVideoListenerAdapter.this.rewardVideoAdAdapter, tTRewardVideoAd));
                    if (RewardVideoListenerAdapter.this.apiAdListener != null) {
                        RewardVideoListenerAdapter.this.apiAdListener.onAdLoaded(RewardVideoListenerAdapter.this.rewardVideoAdAdapter);
                        RewardVideoListenerAdapter.this.apiAdListener.onAdReady(RewardVideoListenerAdapter.this.rewardVideoAdAdapter);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
    public void onRewardVideoCached(TTRewardVideoAd tTRewardVideoAd) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
    public void onRewardVideoCached() {
        a aVar = this.apiAdListener;
        if (aVar != null) {
            aVar.onVideoCached(this.rewardVideoAdAdapter);
        }
    }
}
