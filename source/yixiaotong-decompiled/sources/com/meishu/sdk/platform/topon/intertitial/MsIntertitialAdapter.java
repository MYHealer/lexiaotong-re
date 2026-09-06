package com.meishu.sdk.platform.topon.intertitial;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingNotice;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATCustomLoadListener;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.ad.MsAdSlot;
import com.meishu.sdk.core.ad.interstitial.InterstitialAd;
import com.meishu.sdk.core.ad.interstitial.InterstitialAdEventListener;
import com.meishu.sdk.core.ad.interstitial.InterstitialAdLoader;
import com.meishu.sdk.core.loader.InteractionListener;
import com.meishu.sdk.core.utils.AdErrorInfo;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.platform.topon.TopOnInitManager;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MsIntertitialAdapter extends CustomInterstitialAdapter {
    private InterstitialAd interstitialAd;
    private String slotId;

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd(Context context, Map<String, Object> map, final ATBiddingListener aTBiddingListener) {
        String str = (String) map.get("app_id");
        this.slotId = (String) map.get("slot_id");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.slotId)) {
            if (aTBiddingListener != null) {
                aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail("load error"), (BaseAd) null);
            }
            ATCustomLoadListener aTCustomLoadListener = ((CustomInterstitialAdapter) this).mLoadListener;
            if (aTCustomLoadListener != null) {
                aTCustomLoadListener.onAdLoadError("", "app_id or slot_id is empty!");
                return;
            }
            return;
        }
        if (context instanceof Activity) {
            new InterstitialAdLoader((Activity) context, new MsAdSlot.Builder().setPid(this.slotId).setIsClickToClose(false).build(), new InterstitialAdEventListener() { // from class: com.meishu.sdk.platform.topon.intertitial.MsIntertitialAdapter.3
                @Override // com.meishu.sdk.core.ad.IAdEventListener
                public void onAdError(AdErrorInfo adErrorInfo) {
                    ATBiddingListener aTBiddingListener2 = aTBiddingListener;
                    if (aTBiddingListener2 != null) {
                        aTBiddingListener2.onC2SBiddingResultWithCache(ATBiddingResult.fail("load error"), (BaseAd) null);
                    }
                    if (((CustomInterstitialAdapter) MsIntertitialAdapter.this).mLoadListener != null) {
                        ((CustomInterstitialAdapter) MsIntertitialAdapter.this).mLoadListener.onAdLoadError("-1", "加载错误");
                    }
                }

                @Override // com.meishu.sdk.core.ad.IAdEventListener
                public void onAdReady(InterstitialAd interstitialAd) {
                    try {
                        MsIntertitialAdapter.this.interstitialAd = interstitialAd;
                        if (interstitialAd != null) {
                            if (interstitialAd.getData() != null) {
                                String string = UUID.randomUUID().toString();
                                double d = 0.0d;
                                if (interstitialAd.getData() != null) {
                                    try {
                                        d = Double.parseDouble(interstitialAd.getData().getEcpm()) / 100.0d;
                                        LogUtil.d("hrsdk", "price=" + d);
                                    } catch (NumberFormatException e) {
                                        e.printStackTrace();
                                    }
                                }
                                ATBiddingListener aTBiddingListener2 = aTBiddingListener;
                                if (aTBiddingListener2 != null) {
                                    aTBiddingListener2.onC2SBiddingResultWithCache(ATBiddingResult.success(d, string, (ATBiddingNotice) null, ATAdConst.CURRENCY.RMB), (BaseAd) null);
                                }
                            }
                            interstitialAd.setInteractionListener(new InteractionListener() { // from class: com.meishu.sdk.platform.topon.intertitial.MsIntertitialAdapter.3.1
                                @Override // com.meishu.sdk.core.loader.InteractionListener
                                public void onAdClicked() {
                                    if (((CustomInterstitialAdapter) MsIntertitialAdapter.this).mImpressListener != null) {
                                        ((CustomInterstitialAdapter) MsIntertitialAdapter.this).mImpressListener.onInterstitialAdClicked();
                                    }
                                }

                                @Override // com.meishu.sdk.core.loader.InteractionListener
                                public void onAdClosed() {
                                    if (((CustomInterstitialAdapter) MsIntertitialAdapter.this).mImpressListener != null) {
                                        ((CustomInterstitialAdapter) MsIntertitialAdapter.this).mImpressListener.onInterstitialAdClose();
                                    }
                                }

                                @Override // com.meishu.sdk.core.loader.InteractionListener
                                public void onAdExposure() {
                                    if (((CustomInterstitialAdapter) MsIntertitialAdapter.this).mImpressListener != null) {
                                        ((CustomInterstitialAdapter) MsIntertitialAdapter.this).mImpressListener.onInterstitialAdShow();
                                    }
                                }
                            });
                            if (((CustomInterstitialAdapter) MsIntertitialAdapter.this).mLoadListener != null) {
                                ((CustomInterstitialAdapter) MsIntertitialAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                            }
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }).loadAd();
            return;
        }
        if (aTBiddingListener != null) {
            aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail("load error"), (BaseAd) null);
        }
        ATCustomLoadListener aTCustomLoadListener2 = ((CustomInterstitialAdapter) this).mLoadListener;
        if (aTCustomLoadListener2 != null) {
            aTCustomLoadListener2.onAdLoadError("", "app_id or slot_id is empty!");
        }
    }

    public void destory() {
        this.interstitialAd = null;
    }

    public String getNetworkName() {
        return TopOnInitManager.getInstance().getNetworkName();
    }

    public String getNetworkPlacementId() {
        return this.slotId;
    }

    public String getNetworkSDKVersion() {
        return AdSdk.getVersionName();
    }

    public boolean isAdReady() {
        InterstitialAd interstitialAd = this.interstitialAd;
        return interstitialAd != null && interstitialAd.isAdValid();
    }

    public void loadCustomNetworkAd(final Context context, final Map<String, Object> map, Map<String, Object> map2) {
        TopOnInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.meishu.sdk.platform.topon.intertitial.MsIntertitialAdapter.1
            public void onFail(String str) {
            }

            public void onSuccess() {
                MsIntertitialAdapter.this.loadAd(context, map, null);
            }
        });
    }

    public boolean startBiddingRequest(final Context context, final Map<String, Object> map, Map<String, Object> map2, final ATBiddingListener aTBiddingListener) {
        TopOnInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.meishu.sdk.platform.topon.intertitial.MsIntertitialAdapter.2
            public void onSuccess() {
                MsIntertitialAdapter.this.loadAd(context, map, aTBiddingListener);
            }

            public void onFail(String str) {
                ATBiddingListener aTBiddingListener2 = aTBiddingListener;
                if (aTBiddingListener2 != null) {
                    aTBiddingListener2.onC2SBiddingResultWithCache(ATBiddingResult.fail(str), (BaseAd) null);
                }
            }
        });
        return true;
    }

    public void show(Activity activity) {
        InterstitialAd interstitialAd = this.interstitialAd;
        if (interstitialAd != null) {
            interstitialAd.showAd(activity);
        }
    }
}
