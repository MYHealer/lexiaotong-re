package com.meishu.sdk.platform.topon.banner;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.anythink.banner.unitgroup.api.CustomBannerAdapter;
import com.anythink.banner.unitgroup.api.CustomBannerEventListener;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingNotice;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATCustomLoadListener;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.ad.MsAdSlot;
import com.meishu.sdk.core.ad.banner.BannerAdEventListener;
import com.meishu.sdk.core.ad.banner.BannerAdLoader;
import com.meishu.sdk.core.ad.banner.IBannerAd;
import com.meishu.sdk.core.loader.InteractionListener;
import com.meishu.sdk.core.utils.AdErrorInfo;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.platform.topon.TopOnInitManager;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MsBannerAdapter extends CustomBannerAdapter {
    private static final String TAG = "MsBannerAdapter";
    private BannerAdLoader bannerAdLoader;
    private IBannerAd iBannerAd;
    private View mBannerView;
    private String slotId;

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd(Context context, Map<String, Object> map, final ATBiddingListener aTBiddingListener) {
        String str = (String) map.get("app_id");
        this.slotId = (String) map.get("slot_id");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.slotId)) {
            if (aTBiddingListener != null) {
                aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail("load error"), (BaseAd) null);
            }
            ATCustomLoadListener aTCustomLoadListener = ((CustomBannerAdapter) this).mLoadListener;
            if (aTCustomLoadListener != null) {
                aTCustomLoadListener.onAdLoadError("", "app_id or slot_id is empty!");
                return;
            }
            return;
        }
        if (context instanceof Activity) {
            BannerAdLoader bannerAdLoader = new BannerAdLoader((Activity) context, new MsAdSlot.Builder().setPid(this.slotId).build(), new BannerAdEventListener() { // from class: com.meishu.sdk.platform.topon.banner.MsBannerAdapter.3
                @Override // com.meishu.sdk.core.ad.IAdEventListener
                public void onAdError(AdErrorInfo adErrorInfo) {
                    ATBiddingListener aTBiddingListener2 = aTBiddingListener;
                    if (aTBiddingListener2 != null) {
                        aTBiddingListener2.onC2SBiddingResultWithCache(ATBiddingResult.fail("load error"), (BaseAd) null);
                    }
                    if (((CustomBannerAdapter) MsBannerAdapter.this).mLoadListener != null) {
                        ((CustomBannerAdapter) MsBannerAdapter.this).mLoadListener.onAdLoadError("-1", "加载失败");
                    }
                }

                /* JADX WARN: Code duplicated, block: B:15:0x0035 A[Catch: all -> 0x0065, TryCatch #0 {all -> 0x0065, blocks: (B:2:0x0000, B:4:0x0007, B:6:0x000d, B:8:0x001b, B:13:0x0031, B:15:0x0035, B:11:0x002c, B:16:0x003f, B:18:0x0050, B:19:0x005c), top: B:24:0x0000, inners: #1 }] */
                @Override // com.meishu.sdk.core.ad.IAdEventListener
                public void onAdReady(IBannerAd iBannerAd) {
                    double d;
                    ATBiddingListener aTBiddingListener2;
                    try {
                        MsBannerAdapter.this.iBannerAd = iBannerAd;
                        if (iBannerAd != null) {
                            if (iBannerAd.getData() != null) {
                                String string = UUID.randomUUID().toString();
                                if (iBannerAd.getData() != null) {
                                    try {
                                        d = Double.parseDouble(iBannerAd.getData().getEcpm()) / 100.0d;
                                    } catch (NumberFormatException e) {
                                        e.printStackTrace();
                                        d = 0.0d;
                                    }
                                    aTBiddingListener2 = aTBiddingListener;
                                    if (aTBiddingListener2 != null) {
                                        aTBiddingListener2.onC2SBiddingResultWithCache(ATBiddingResult.success(d, string, (ATBiddingNotice) null, ATAdConst.CURRENCY.RMB), (BaseAd) null);
                                    }
                                } else {
                                    d = 0.0d;
                                    aTBiddingListener2 = aTBiddingListener;
                                    if (aTBiddingListener2 != null) {
                                        aTBiddingListener2.onC2SBiddingResultWithCache(ATBiddingResult.success(d, string, (ATBiddingNotice) null, ATAdConst.CURRENCY.RMB), (BaseAd) null);
                                    }
                                }
                            }
                            MsBannerAdapter.this.mBannerView = iBannerAd.getAdView();
                            if (((CustomBannerAdapter) MsBannerAdapter.this).mLoadListener != null) {
                                ((CustomBannerAdapter) MsBannerAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                            }
                            iBannerAd.setInteractionListener(new InteractionListener() { // from class: com.meishu.sdk.platform.topon.banner.MsBannerAdapter.3.1
                                @Override // com.meishu.sdk.core.loader.InteractionListener
                                public void onAdClicked() {
                                    CustomBannerEventListener customBannerEventListener = ((CustomBannerAdapter) MsBannerAdapter.this).mImpressionEventListener;
                                    if (customBannerEventListener != null) {
                                        customBannerEventListener.onBannerAdClicked();
                                    }
                                }

                                @Override // com.meishu.sdk.core.loader.InteractionListener
                                public void onAdClosed() {
                                    CustomBannerEventListener customBannerEventListener = ((CustomBannerAdapter) MsBannerAdapter.this).mImpressionEventListener;
                                    if (customBannerEventListener != null) {
                                        customBannerEventListener.onBannerAdClose();
                                    }
                                }

                                @Override // com.meishu.sdk.core.loader.InteractionListener
                                public void onAdExposure() {
                                    CustomBannerEventListener customBannerEventListener = ((CustomBannerAdapter) MsBannerAdapter.this).mImpressionEventListener;
                                    if (customBannerEventListener != null) {
                                        customBannerEventListener.onBannerAdShow();
                                    }
                                }
                            });
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            this.bannerAdLoader = bannerAdLoader;
            bannerAdLoader.loadAd();
            return;
        }
        if (aTBiddingListener != null) {
            aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail("load error"), (BaseAd) null);
        }
        ATCustomLoadListener aTCustomLoadListener2 = ((CustomBannerAdapter) this).mLoadListener;
        if (aTCustomLoadListener2 != null) {
            aTCustomLoadListener2.onAdLoadError("", "Context must be activity.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startBid(Context context, Map<String, Object> map, ATBiddingListener aTBiddingListener) {
        LogUtil.d(TAG, "startBid");
        loadAd(context, map, aTBiddingListener);
    }

    public View getBannerView() {
        return this.mBannerView;
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
        IBannerAd iBannerAd = this.iBannerAd;
        return iBannerAd != null && iBannerAd.isAdValid();
    }

    public void loadCustomNetworkAd(final Context context, final Map<String, Object> map, Map<String, Object> map2) {
        TopOnInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.meishu.sdk.platform.topon.banner.MsBannerAdapter.1
            public void onFail(String str) {
            }

            public void onSuccess() {
                MsBannerAdapter.this.loadAd(context, map, null);
            }
        });
    }

    public boolean startBiddingRequest(final Context context, final Map<String, Object> map, Map<String, Object> map2, final ATBiddingListener aTBiddingListener) {
        TopOnInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.meishu.sdk.platform.topon.banner.MsBannerAdapter.2
            public void onSuccess() {
                MsBannerAdapter.this.startBid(context, map, aTBiddingListener);
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

    public void destory() {
        this.mBannerView = null;
        BannerAdLoader bannerAdLoader = this.bannerAdLoader;
        if (bannerAdLoader != null) {
            bannerAdLoader.destroy();
            this.iBannerAd = null;
        }
    }
}
