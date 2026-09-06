package com.meishu.sdk.platform.oppo.reward;

import android.text.TextUtils;
import com.heytap.msp.mobad.api.ad.RewardVideoAd;
import com.heytap.msp.mobad.api.listener.IRewardVideoAdListener;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.meishu.sdk.core.ad.reward.RewardVideoLoader;
import com.meishu.sdk.core.ad.reward.a;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.platform.BasePlatformLoader;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class OPPORewardAdLoader extends BasePlatformLoader<RewardVideoLoader, a> {
    private static final String TAG = "OPPORewardAdLoader";
    private ArrayList<RewardVideoAd> rewardVideoAdList;

    public OPPORewardAdLoader(RewardVideoLoader rewardVideoLoader, SdkAdInfo sdkAdInfo) {
        super(rewardVideoLoader, sdkAdInfo);
        this.rewardVideoAdList = new ArrayList<>();
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader, com.meishu.sdk.core.loader.IAdLoader
    public void destroy() {
        super.destroy();
        Iterator<RewardVideoAd> it = this.rewardVideoAdList.iterator();
        while (it.hasNext()) {
            it.next().destroyAd();
        }
        this.rewardVideoAdList.clear();
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        z.a(((RewardVideoLoader) this.adLoader).getContext(), h0.a(getSdkAdInfo().getReq()), new i());
        final OPPORewardAd oPPORewardAd = new OPPORewardAd(this);
        RewardVideoAd rewardVideoAd = new RewardVideoAd(getContext(), getSdkAdInfo().getPid(), new IRewardVideoAdListener() { // from class: com.meishu.sdk.platform.oppo.reward.OPPORewardAdLoader.1
            @Override // com.heytap.msp.mobad.api.listener.IRewardVideoAdListener
            public void onAdClick(long j) {
                if (OPPORewardAdLoader.this.getSdkAdInfo() != null && !TextUtils.isEmpty(OPPORewardAdLoader.this.getSdkAdInfo().getClk())) {
                    LogUtil.d(OPPORewardAdLoader.TAG, "send onAdClick");
                    com.meishu.sdk.core.loader.a.a(OPPORewardAdLoader.this.getContext(), f.a(OPPORewardAdLoader.this.getSdkAdInfo().getClk(), oPPORewardAd));
                }
                if (oPPORewardAd.getInteractionListener() != null) {
                    oPPORewardAd.getInteractionListener().onAdClicked();
                }
            }

            @Override // com.heytap.msp.mobad.api.listener.IRewardVideoAdListener
            public void onAdFailed(int i, String str) {
                LogUtil.e(OPPORewardAdLoader.TAG, "onAdFailed " + str + PPSLabelView.Code + i);
                z.a(OPPORewardAdLoader.this.getSdkAdInfo().getErr(), Integer.valueOf(i), str);
                if (OPPORewardAdLoader.this.getLoaderListener() != null) {
                    OPPORewardAdLoader.this.getLoaderListener().onAdError();
                }
            }

            @Override // com.heytap.msp.mobad.api.listener.IRewardVideoAdListener
            @Deprecated
            public void onAdFailed(String str) {
            }

            @Override // com.heytap.msp.mobad.api.listener.IRewardVideoAdListener
            public void onAdSuccess() {
                if (OPPORewardAdLoader.this.getLoaderListener() != null) {
                    OPPORewardAdLoader.this.getLoaderListener().onAdLoaded(oPPORewardAd);
                }
            }

            @Override // com.heytap.msp.mobad.api.listener.IRewardVideoAdListener
            public void onLandingPageClose() {
            }

            @Override // com.heytap.msp.mobad.api.listener.IRewardVideoAdListener
            public void onLandingPageOpen() {
            }

            @Override // com.heytap.msp.mobad.api.listener.IRewardListener
            public void onReward(Object... objArr) {
                if (OPPORewardAdLoader.this.getLoaderListener() != null) {
                    OPPORewardAdLoader.this.getLoaderListener().onReward(null);
                }
            }

            @Override // com.heytap.msp.mobad.api.listener.IRewardVideoAdListener
            public void onVideoPlayClose(long j) {
                if (OPPORewardAdLoader.this.getLoaderListener() != null) {
                    OPPORewardAdLoader.this.getLoaderListener().onAdClosed();
                }
            }

            @Override // com.heytap.msp.mobad.api.listener.IRewardVideoAdListener
            public void onVideoPlayComplete() {
                if (oPPORewardAd.getRewardAdMediaListener() != null) {
                    oPPORewardAd.getRewardAdMediaListener().onVideoCompleted();
                }
            }

            @Override // com.heytap.msp.mobad.api.listener.IRewardVideoAdListener
            public void onVideoPlayError(String str) {
                LogUtil.e(OPPORewardAdLoader.TAG, "onVideoPlayError " + str);
                if (OPPORewardAdLoader.this.getLoaderListener() != null) {
                    OPPORewardAdLoader.this.getLoaderListener().onAdError();
                }
            }

            @Override // com.heytap.msp.mobad.api.listener.IRewardVideoAdListener
            public void onVideoPlayStart() {
                if (OPPORewardAdLoader.this.getLoaderListener() != null) {
                    OPPORewardAdLoader.this.getLoaderListener().onAdExposure();
                }
            }
        });
        oPPORewardAd.setRewardAd(rewardVideoAd);
        rewardVideoAd.loadAd();
    }
}
