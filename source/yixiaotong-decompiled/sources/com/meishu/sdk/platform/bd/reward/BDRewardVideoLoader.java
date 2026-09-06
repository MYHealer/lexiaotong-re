package com.meishu.sdk.platform.bd.reward;

import com.baidu.mobads.sdk.api.BiddingListener;
import com.baidu.mobads.sdk.api.RewardVideoAd;
import com.baidu.mobads.sdk.api.SplashAd;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.ad.reward.RewardVideoLoader;
import com.meishu.sdk.core.ad.reward.a;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.t0;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.platform.BasePlatformLoader;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class BDRewardVideoLoader extends BasePlatformLoader<RewardVideoLoader, a> {
    private static final String TAG = "BDRewardVideoLoader";
    private RewardVideoAd mRewardVideoAd;

    public BDRewardVideoLoader(RewardVideoLoader rewardVideoLoader, SdkAdInfo sdkAdInfo) {
        super(rewardVideoLoader, sdkAdInfo);
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader, com.meishu.sdk.core.loader.IAdLoader
    public void destroy() {
        if (this.mRewardVideoAd != null) {
            this.mRewardVideoAd = null;
        }
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        try {
            String pid = getSdkAdInfo().getPid();
            z.a(((RewardVideoLoader) this.adLoader).getContext(), h0.a(getSdkAdInfo().getReq()), new i());
            BDRewardVideoListener bDRewardVideoListener = new BDRewardVideoListener((a) this.loadListener, getAdLoader(), getSdkAdInfo(), this);
            RewardVideoAd rewardVideoAd = new RewardVideoAd(((RewardVideoLoader) this.adLoader).getContext(), pid, bDRewardVideoListener, false);
            this.mRewardVideoAd = rewardVideoAd;
            rewardVideoAd.setAppSid(this.sdkAdInfo.getApp_id());
            this.mRewardVideoAd.setUserId(AdSdk.adConfig().userId());
            bDRewardVideoListener.setRewardVideoAd(this.mRewardVideoAd);
            if (AdSdk.adConfig().downloadConfirm() != 2) {
                this.mRewardVideoAd.setDownloadAppConfirmPolicy(1);
            } else {
                this.mRewardVideoAd.setDownloadAppConfirmPolicy(3);
            }
            this.mRewardVideoAd.load();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader
    public void sendGdtWinResult(boolean z, int i) {
        int i2 = 1;
        try {
            Class<?> cls = Class.forName("com.baidu.mobads.sdk.api.RewardVideoAd");
            if (z) {
                Method declaredMethod = cls.getDeclaredMethod("biddingSuccess", String.class);
                RewardVideoAd rewardVideoAd = this.mRewardVideoAd;
                declaredMethod.invoke(rewardVideoAd, String.valueOf(t0.a(Integer.parseInt(rewardVideoAd.getECPMLevel()), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice())));
            } else {
                cls.getDeclaredMethod("biddingFail", String.class).invoke(this.mRewardVideoAd, "203");
            }
        } catch (Throwable unused) {
            try {
                if (z) {
                    LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
                    linkedHashMap.put("ecpm", Integer.valueOf(t0.a(Integer.parseInt(this.mRewardVideoAd.getECPMLevel()), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice())));
                    linkedHashMap.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                    linkedHashMap.put("bid_t", 1);
                    this.mRewardVideoAd.biddingSuccess(linkedHashMap, new BiddingListener() { // from class: com.meishu.sdk.platform.bd.reward.BDRewardVideoLoader.1
                        @Override // com.baidu.mobads.sdk.api.BiddingListener
                        public void onBiddingResult(boolean z2, String str, HashMap<String, Object> map) {
                        }
                    });
                } else {
                    LinkedHashMap<String, Object> linkedHashMap2 = new LinkedHashMap<>();
                    linkedHashMap2.put("ecpm", Integer.valueOf(i));
                    int iNextInt = new Random().nextInt(10);
                    if (iNextInt != 0) {
                        i2 = iNextInt;
                    }
                    linkedHashMap2.put(SplashAd.KEY_BIDFAIL_ADN, Integer.valueOf(i2));
                    linkedHashMap2.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                    linkedHashMap2.put("bid_t", 3);
                    linkedHashMap2.put("reason", "203");
                    this.mRewardVideoAd.biddingFail(linkedHashMap2, new BiddingListener() { // from class: com.meishu.sdk.platform.bd.reward.BDRewardVideoLoader.2
                        @Override // com.baidu.mobads.sdk.api.BiddingListener
                        public void onBiddingResult(boolean z2, String str, HashMap<String, Object> map) {
                        }
                    });
                }
            } catch (Throwable unused2) {
            }
        }
    }
}
