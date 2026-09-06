package com.meishu.sdk.platform.csjblend;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.splash.MediationCustomSplashLoader;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig;
import com.meishu.sdk.activity.a;
import com.meishu.sdk.core.ad.MsAdSlot;
import com.meishu.sdk.core.ad.splash.ISplashAd;
import com.meishu.sdk.core.ad.splash.SplashAdEventListener;
import com.meishu.sdk.core.ad.splash.SplashAdLoader;
import com.meishu.sdk.core.loader.InteractionListener;
import com.meishu.sdk.core.utils.AdErrorInfo;
import com.meishu.sdk.core.utils.LogUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MsCBCustomSplashAdapter extends MediationCustomSplashLoader {
    private static final String TAG = "MsCBCustomSplashAdapter";
    private ISplashAd iSplashAd;
    private boolean calledLoadSuccess = false;
    private boolean calledExposure = false;

    public boolean isClientBidding() {
        return getBiddingType() == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.splash.MediationCustomSplashLoader
    public MediationConstant.AdIsReadyStatus isReadyCondition() {
        ISplashAd iSplashAd = this.iSplashAd;
        return (iSplashAd == null || !iSplashAd.isAdValid()) ? MediationConstant.AdIsReadyStatus.AD_IS_EXPIRED : MediationConstant.AdIsReadyStatus.AD_IS_READY;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public void load(Context context, AdSlot adSlot, MediationCustomServiceConfig mediationCustomServiceConfig) {
        LogUtil.e(TAG, a.a("开始加载gromore自定义平台开屏，pid=").append(mediationCustomServiceConfig.getADNNetworkSlotId()).toString());
        this.calledLoadSuccess = false;
        this.calledExposure = false;
        new SplashAdLoader(context, new MsAdSlot.Builder().setPid(mediationCustomServiceConfig.getADNNetworkSlotId()).setFetchCount(1).build(), new SplashAdEventListener() { // from class: com.meishu.sdk.platform.csjblend.MsCBCustomSplashAdapter.2
            @Override // com.meishu.sdk.core.ad.IAdEventListener
            public void onAdError(AdErrorInfo adErrorInfo) {
                MsCBCustomSplashAdapter.this.callLoadFail(-1, "loadAdError");
            }

            @Override // com.meishu.sdk.core.ad.splash.SplashAdEventListener
            public void onAdPresent(ISplashAd iSplashAd) {
            }

            @Override // com.meishu.sdk.core.ad.splash.SplashAdEventListener
            public void onAdSkip(ISplashAd iSplashAd) {
                MsCBCustomSplashAdapter.this.callSplashAdSkip();
            }

            @Override // com.meishu.sdk.core.ad.splash.SplashAdEventListener
            public void onAdTick(long j) {
            }

            @Override // com.meishu.sdk.core.ad.splash.SplashAdEventListener
            public void onAdTimeOver(ISplashAd iSplashAd) {
            }

            @Override // com.meishu.sdk.core.ad.IAdEventListener
            public void onAdReady(ISplashAd iSplashAd) {
                double d;
                try {
                    MsCBCustomSplashAdapter.this.iSplashAd = iSplashAd;
                    if (iSplashAd != null) {
                        iSplashAd.setInteractionListener(new InteractionListener() { // from class: com.meishu.sdk.platform.csjblend.MsCBCustomSplashAdapter.2.1
                            @Override // com.meishu.sdk.core.loader.InteractionListener
                            public void onAdClicked() {
                                MsCBCustomSplashAdapter.this.callSplashAdClicked();
                            }

                            @Override // com.meishu.sdk.core.loader.InteractionListener
                            public void onAdClosed() {
                                MsCBCustomSplashAdapter.this.callSplashAdDismiss();
                            }

                            @Override // com.meishu.sdk.core.loader.InteractionListener
                            public void onAdExposure() {
                                if (MsCBCustomSplashAdapter.this.calledExposure) {
                                    return;
                                }
                                MsCBCustomSplashAdapter.this.calledExposure = true;
                                MsCBCustomSplashAdapter.this.callSplashAdShow();
                            }
                        });
                        if (!MsCBCustomSplashAdapter.this.isClientBidding()) {
                            if (MsCBCustomSplashAdapter.this.calledLoadSuccess) {
                                return;
                            }
                            MsCBCustomSplashAdapter.this.calledLoadSuccess = true;
                            MsCBCustomSplashAdapter.this.callLoadSuccess();
                            return;
                        }
                        if (iSplashAd.getData() != null) {
                            try {
                                d = Double.parseDouble(iSplashAd.getData().getEcpm());
                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                                d = 0.0d;
                            }
                        } else {
                            d = 0.0d;
                        }
                        if (MsCBCustomSplashAdapter.this.calledLoadSuccess) {
                            return;
                        }
                        MsCBCustomSplashAdapter.this.calledLoadSuccess = true;
                        MsCBCustomSplashAdapter.this.callLoadSuccess(d);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }, 5000).loadAd();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.splash.MediationCustomSplashLoader
    public void showAd(final ViewGroup viewGroup) {
        if (viewGroup != null) {
            viewGroup.post(new Runnable() { // from class: com.meishu.sdk.platform.csjblend.MsCBCustomSplashAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    if (MsCBCustomSplashAdapter.this.iSplashAd != null) {
                        MsCBCustomSplashAdapter.this.iSplashAd.showAd(viewGroup);
                    }
                }
            });
        }
    }
}
