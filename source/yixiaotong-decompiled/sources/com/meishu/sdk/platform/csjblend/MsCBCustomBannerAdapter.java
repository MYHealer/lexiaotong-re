package com.meishu.sdk.platform.csjblend;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.banner.MediationCustomBannerLoader;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig;
import com.meishu.sdk.activity.a;
import com.meishu.sdk.core.ad.MsAdSlot;
import com.meishu.sdk.core.ad.banner.BannerAdEventListener;
import com.meishu.sdk.core.ad.banner.BannerAdLoader;
import com.meishu.sdk.core.ad.banner.IBannerAd;
import com.meishu.sdk.core.loader.InteractionListener;
import com.meishu.sdk.core.utils.AdErrorInfo;
import com.meishu.sdk.core.utils.LogUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MsCBCustomBannerAdapter extends MediationCustomBannerLoader {
    private static final String TAG = "MsCBCustomBannerAdapter";
    private IBannerAd iBannerAd;
    private View mBannerView;
    private boolean calledLoadSuccess = false;
    private boolean calledExposure = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void removeFromParent(View view) {
        if (view != null) {
            try {
                ViewParent parent = view.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(view);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.banner.MediationCustomBannerLoader
    public View getAdView() {
        return this.mBannerView;
    }

    public boolean isClientBidding() {
        return getBiddingType() == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.banner.MediationCustomBannerLoader
    public MediationConstant.AdIsReadyStatus isReadyCondition() {
        IBannerAd iBannerAd = this.iBannerAd;
        return (iBannerAd == null || !iBannerAd.isAdValid()) ? MediationConstant.AdIsReadyStatus.AD_IS_EXPIRED : MediationConstant.AdIsReadyStatus.AD_IS_READY;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public void load(Context context, AdSlot adSlot, MediationCustomServiceConfig mediationCustomServiceConfig) {
        LogUtil.e(TAG, a.a("开始加载gromore自定义平台banner，pid=").append(mediationCustomServiceConfig.getADNNetworkSlotId()).toString());
        this.calledLoadSuccess = false;
        this.calledExposure = false;
        try {
            if (context instanceof Activity) {
                BannerAdLoader bannerAdLoader = new BannerAdLoader((Activity) context, new MsAdSlot.Builder().setPid(mediationCustomServiceConfig.getADNNetworkSlotId()).build(), new BannerAdEventListener() { // from class: com.meishu.sdk.platform.csjblend.MsCBCustomBannerAdapter.1
                    @Override // com.meishu.sdk.core.ad.IAdEventListener
                    public void onAdError(AdErrorInfo adErrorInfo) {
                        MsCBCustomBannerAdapter.this.callLoadFail(adErrorInfo.getCode(), adErrorInfo.getMessage());
                    }

                    @Override // com.meishu.sdk.core.ad.IAdEventListener
                    public void onAdReady(IBannerAd iBannerAd) {
                        double d;
                        if (iBannerAd != null) {
                            try {
                                MsCBCustomBannerAdapter.this.iBannerAd = iBannerAd;
                                iBannerAd.setInteractionListener(new InteractionListener() { // from class: com.meishu.sdk.platform.csjblend.MsCBCustomBannerAdapter.1.1
                                    @Override // com.meishu.sdk.core.loader.InteractionListener
                                    public void onAdClicked() {
                                        MsCBCustomBannerAdapter.this.callBannerAdClick();
                                    }

                                    @Override // com.meishu.sdk.core.loader.InteractionListener
                                    public void onAdClosed() {
                                        MsCBCustomBannerAdapter.this.callBannerAdClosed();
                                    }

                                    @Override // com.meishu.sdk.core.loader.InteractionListener
                                    public void onAdExposure() {
                                        if (MsCBCustomBannerAdapter.this.calledExposure) {
                                            return;
                                        }
                                        MsCBCustomBannerAdapter.this.calledExposure = true;
                                        MsCBCustomBannerAdapter.this.callBannerAdShow();
                                    }
                                });
                                if (MsCBCustomBannerAdapter.this.mBannerView instanceof FrameLayout) {
                                    View adView = iBannerAd.getAdView();
                                    MsCBCustomBannerAdapter.this.removeFromParent(adView);
                                    ((FrameLayout) MsCBCustomBannerAdapter.this.mBannerView).addView(adView, new ViewGroup.LayoutParams(-1, -1));
                                }
                                LogUtil.e(MsCBCustomBannerAdapter.TAG, "加载成功，onAdReady");
                                if (!MsCBCustomBannerAdapter.this.isClientBidding()) {
                                    if (MsCBCustomBannerAdapter.this.calledLoadSuccess) {
                                        return;
                                    }
                                    MsCBCustomBannerAdapter.this.calledLoadSuccess = true;
                                    MsCBCustomBannerAdapter.this.callLoadSuccess();
                                    return;
                                }
                                if (iBannerAd.getData() != null) {
                                    try {
                                        d = Double.parseDouble(iBannerAd.getData().getEcpm());
                                    } catch (NumberFormatException e) {
                                        e.printStackTrace();
                                        d = 0.0d;
                                    }
                                } else {
                                    d = 0.0d;
                                }
                                if (MsCBCustomBannerAdapter.this.calledLoadSuccess) {
                                    return;
                                }
                                MsCBCustomBannerAdapter.this.calledLoadSuccess = true;
                                MsCBCustomBannerAdapter.this.callLoadSuccess(d);
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    }
                });
                this.mBannerView = new FrameLayout(context);
                bannerAdLoader.loadAd();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
