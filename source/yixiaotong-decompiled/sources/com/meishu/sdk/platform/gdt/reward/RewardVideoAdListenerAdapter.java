package com.meishu.sdk.platform.gdt.reward;

import android.text.TextUtils;
import com.meishu.sdk.core.ad.reward.a;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.platform.gdt.GDTPlatformError;
import com.qq.e.ads.rewardvideo.RewardVideoADListener;
import com.qq.e.comm.util.AdError;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class RewardVideoAdListenerAdapter implements RewardVideoADListener {
    private static final String TAG = "RewardVideoAdListenerAd";
    private GDTRewardVideoAdWrapper adWrapper;
    private a apiAdListener;
    private boolean isAdLoaded;
    private RewardVideoAdAdapter rewardVideoAdAdapter;

    public RewardVideoAdListenerAdapter(GDTRewardVideoAdWrapper gDTRewardVideoAdWrapper, a aVar) {
        this.adWrapper = gDTRewardVideoAdWrapper;
        this.apiAdListener = aVar;
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onADClick() {
        try {
            if (this.adWrapper.getSdkAdInfo() != null && !TextUtils.isEmpty(this.adWrapper.getSdkAdInfo().getClk())) {
                LogUtil.d(TAG, "send onADClick");
                z.a(this.adWrapper.getContext(), f.a(this.adWrapper.getSdkAdInfo().getClk(), this.rewardVideoAdAdapter), new i());
                this.adWrapper.getSdkAdInfo().getMsLoadedTime();
                this.adWrapper.getAdLoader().getPosId();
            }
            if (this.adWrapper.getApiInteractionListener() != null) {
                this.adWrapper.getApiInteractionListener().onAdClicked();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onADLoad() {
        try {
            this.rewardVideoAdAdapter = new RewardVideoAdAdapter(this.adWrapper);
            if (this.apiAdListener != null) {
                this.adWrapper.setEcpm();
                this.apiAdListener.onAdLoaded(this.rewardVideoAdAdapter);
                this.apiAdListener.onAdReady(this.rewardVideoAdAdapter);
                this.isAdLoaded = true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onADShow() {
        LogUtil.d(TAG, "onADShow: ");
        if (this.adWrapper.getApiRewardAdMediaListener() != null) {
            this.adWrapper.getApiRewardAdMediaListener().onVideoStart();
        }
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onError(AdError adError) {
        try {
            LogUtil.e(TAG, "onError, code: " + adError.getErrorCode() + ", msg: " + adError.getErrorMsg());
            if (adError.getErrorCode() == 4015) {
                return;
            }
            if (!this.isAdLoaded) {
                if (this.adWrapper.getApiRewardAdMediaListener() != null) {
                    this.adWrapper.getApiRewardAdMediaListener().onVideoError();
                }
                new GDTPlatformError(adError, this.adWrapper.getSdkAdInfo()).post(this.apiAdListener);
            } else {
                a aVar = this.apiAdListener;
                if (aVar != null) {
                    aVar.onAdRenderFail(adError.getErrorMsg(), adError.getErrorCode());
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onVideoComplete() {
        if (this.adWrapper.getApiRewardAdMediaListener() != null) {
            this.adWrapper.getApiRewardAdMediaListener().onVideoCompleted();
        }
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onADClose() {
        try {
            a aVar = this.apiAdListener;
            if (aVar != null) {
                aVar.onAdClosed();
            }
            if (this.adWrapper.getApiInteractionListener() != null) {
                this.adWrapper.getApiInteractionListener().onAdClosed();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onADExpose() {
        a aVar = this.apiAdListener;
        if (aVar != null) {
            aVar.onAdExposure();
        }
        if (this.adWrapper.getApiInteractionListener() != null) {
            this.adWrapper.getApiInteractionListener().onAdExposure();
        }
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onReward(Map<String, Object> map) {
        a aVar = this.apiAdListener;
        if (aVar != null) {
            aVar.onReward(map);
        }
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onVideoCached() {
        a aVar = this.apiAdListener;
        if (aVar != null) {
            aVar.onVideoCached(this.rewardVideoAdAdapter);
        }
    }

    public void onReward() {
        a aVar = this.apiAdListener;
        if (aVar != null) {
            aVar.onReward(null);
        }
    }
}
