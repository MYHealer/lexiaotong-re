package com.meishu.sdk.platform.gdt.reward;

import android.app.Activity;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.ad.reward.RewardAdMediaListener;
import com.meishu.sdk.core.ad.reward.RewardVideoLoader;
import com.meishu.sdk.core.ad.reward.a;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.loader.InteractionListener;
import com.meishu.sdk.core.loader.serverbidding.S2sbResultBean;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.t0;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.platform.BasePlatformLoader;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class GDTRewardVideoAdWrapper extends BasePlatformLoader<RewardVideoLoader, a> {
    private static final String TAG = "GDTRewardVideoAdWrapper";
    private final RewardVideoAdListenerAdapter RewardAdapter;
    private InteractionListener apiInteractionListener;
    private RewardAdMediaListener apiRewardAdMediaListener;
    private RewardVideoAD rewardVideoAd;

    public GDTRewardVideoAdWrapper(RewardVideoLoader rewardVideoLoader, SdkAdInfo sdkAdInfo) {
        super(rewardVideoLoader, sdkAdInfo);
        RewardVideoAdListenerAdapter rewardVideoAdListenerAdapter = new RewardVideoAdListenerAdapter(this, (a) this.loadListener);
        this.RewardAdapter = rewardVideoAdListenerAdapter;
        try {
            try {
                if (!TextUtils.isEmpty(sdkAdInfo.getS2sb())) {
                    this.rewardVideoAd = new RewardVideoAD(rewardVideoLoader.getContext(), sdkAdInfo.getPid(), rewardVideoAdListenerAdapter, !rewardVideoLoader.getVideoIsMute(), ((S2sbResultBean) new Gson().fromJson(sdkAdInfo.getS2sb(), S2sbResultBean.class)).getToken());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.rewardVideoAd == null) {
                this.rewardVideoAd = new RewardVideoAD(rewardVideoLoader.getContext(), sdkAdInfo.getPid(), this.RewardAdapter, !rewardVideoLoader.getVideoIsMute());
            }
            this.rewardVideoAd.setServerSideVerificationOptions(new ServerSideVerificationOptions.Builder().setUserId(AdSdk.adConfig().userId()).build());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader, com.meishu.sdk.core.loader.IAdLoader
    public void destroy() {
    }

    public InteractionListener getApiInteractionListener() {
        return this.apiInteractionListener;
    }

    public RewardAdMediaListener getApiRewardAdMediaListener() {
        return this.apiRewardAdMediaListener;
    }

    public RewardVideoAD getRewardVideoAd() {
        return this.rewardVideoAd;
    }

    public boolean isValid() {
        return this.rewardVideoAd.isValid();
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        try {
            z.a(((RewardVideoLoader) this.adLoader).getContext(), h0.a(getSdkAdInfo().getReq()), new i());
            this.rewardVideoAd.loadAD();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setApiInteractionListener(InteractionListener interactionListener) {
        this.apiInteractionListener = interactionListener;
    }

    public void setApiRewardAdMediaListener(RewardAdMediaListener rewardAdMediaListener) {
        this.apiRewardAdMediaListener = rewardAdMediaListener;
    }

    public void setEcpm() {
        RewardVideoAD rewardVideoAD = this.rewardVideoAd;
        if (rewardVideoAD != null) {
            this.sdkAdInfo.setEcpm(String.valueOf(rewardVideoAD.getECPM()));
        }
    }

    public void showAd() {
        RewardVideoAD rewardVideoAD = this.rewardVideoAd;
        if (rewardVideoAD != null) {
            rewardVideoAD.showAD();
        }
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader
    public void sendGdtWinResult(boolean z, int i) {
        try {
            if (this.rewardVideoAd != null) {
                if (z) {
                    HashMap map = new HashMap();
                    map.put("expectCostPrice", Integer.valueOf(this.rewardVideoAd.getECPM()));
                    map.put("highestLossPrice", Integer.valueOf(t0.a(this.rewardVideoAd.getECPM(), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice())));
                    this.rewardVideoAd.sendWinNotification(map);
                } else {
                    HashMap map2 = new HashMap();
                    map2.put("winPrice", Integer.valueOf(i));
                    map2.put("lossReason", 1);
                    map2.put("adnId", "2");
                    this.rewardVideoAd.sendLossNotification(map2);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void showAd(Activity activity) {
        RewardVideoAD rewardVideoAD = this.rewardVideoAd;
        if (rewardVideoAD != null) {
            rewardVideoAD.showAD(activity);
        }
    }
}
