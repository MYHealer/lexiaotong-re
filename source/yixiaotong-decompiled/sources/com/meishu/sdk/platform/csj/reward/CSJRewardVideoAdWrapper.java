package com.meishu.sdk.platform.csj.reward;

import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.ad.reward.RewardAdMediaListener;
import com.meishu.sdk.core.ad.reward.RewardVideoLoader;
import com.meishu.sdk.core.ad.reward.a;
import com.meishu.sdk.core.domain.MeishuAdInfo;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.platform.BasePlatformLoader;
import com.meishu.sdk.platform.csj.CSJAdConfig;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class CSJRewardVideoAdWrapper extends BasePlatformLoader<RewardVideoLoader, a> {
    private RewardAdMediaListener apiRewardAdMediaListener;
    private TTAdNative mTTAdNative;
    private MeishuAdInfo meishuAdInfo;

    public CSJRewardVideoAdWrapper(RewardVideoLoader rewardVideoLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        super(rewardVideoLoader, sdkAdInfo);
        this.mTTAdNative = CSJAdConfig.getTtAdManager().createAdNative(rewardVideoLoader.getContext());
        this.meishuAdInfo = meishuAdInfo;
    }

    public RewardAdMediaListener getApiRewardAdMediaListener() {
        return this.apiRewardAdMediaListener;
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        int width;
        int height;
        int i;
        try {
            ((WindowManager) ((RewardVideoLoader) this.adLoader).getContext().getSystemService("window")).getDefaultDisplay().getRotation();
            if (this.meishuAdInfo.getWidth() == 0 || this.meishuAdInfo.getHeight() == 0 || this.meishuAdInfo.getWidth() <= 0 || this.meishuAdInfo.getHeight() <= 0) {
                try {
                    DisplayMetrics displayMetrics = ((RewardVideoLoader) this.adLoader).getContext().getResources().getDisplayMetrics();
                    int i2 = displayMetrics.widthPixels;
                    if (i2 <= 0 || (i = displayMetrics.heightPixels) <= 0) {
                        width = 1080;
                        height = 1920;
                    } else {
                        height = i;
                        width = i2;
                    }
                } catch (Exception unused) {
                }
            } else {
                width = this.meishuAdInfo.getWidth();
                height = this.meishuAdInfo.getHeight();
            }
            AdSlot adSlotBuild = new AdSlot.Builder().setCodeId(this.sdkAdInfo.getPid()).setSupportDeepLink(true).setImageAcceptedSize(width, height).setExpressViewAcceptedSize(width, height).setUserID(AdSdk.adConfig().userId()).build();
            z.a(((RewardVideoLoader) this.adLoader).getContext(), h0.a(getSdkAdInfo().getReq()), new i());
            if (!CSJAdConfig.isInitSuccess()) {
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.mTTAdNative.loadRewardVideoAd(adSlotBuild, new RewardVideoListenerAdapter(this, (a) this.loadListener));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setApiRewardAdMediaListener(RewardAdMediaListener rewardAdMediaListener) {
        this.apiRewardAdMediaListener = rewardAdMediaListener;
    }
}
