package com.meishu.sdk.platform.topon.splash;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingNotice;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATCustomLoadListener;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.splashad.unitgroup.api.CustomSplashAdapter;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.ad.MsAdSlot;
import com.meishu.sdk.core.ad.splash.ISplashAd;
import com.meishu.sdk.core.ad.splash.SplashAdEventListener;
import com.meishu.sdk.core.ad.splash.SplashAdLoader;
import com.meishu.sdk.core.loader.InteractionListener;
import com.meishu.sdk.core.utils.AdErrorInfo;
import com.meishu.sdk.platform.topon.TopOnInitManager;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MsSplashAdapter extends CustomSplashAdapter {
    private static final String TAG = "MsSplashAdapter";
    private String slotId;
    private ISplashAd splashAd;

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd(Context context, Map<String, Object> map, final ATBiddingListener aTBiddingListener) {
        if (map.containsKey("app_id") && map.containsKey("slot_id")) {
            this.slotId = (String) map.get("slot_id");
            context.getResources().getDisplayMetrics();
            new SplashAdLoader(context, new MsAdSlot.Builder().setPid(this.slotId).setFetchCount(1).build(), new SplashAdEventListener() { // from class: com.meishu.sdk.platform.topon.splash.MsSplashAdapter.3
                @Override // com.meishu.sdk.core.ad.splash.SplashAdEventListener
                public void onAdPresent(ISplashAd iSplashAd) {
                }

                @Override // com.meishu.sdk.core.ad.splash.SplashAdEventListener
                public void onAdSkip(ISplashAd iSplashAd) {
                    ((CustomSplashAdapter) MsSplashAdapter.this).mDismissType = 2;
                }

                @Override // com.meishu.sdk.core.ad.splash.SplashAdEventListener
                public void onAdTick(long j) {
                }

                @Override // com.meishu.sdk.core.ad.splash.SplashAdEventListener
                public void onAdTimeOver(ISplashAd iSplashAd) {
                    ((CustomSplashAdapter) MsSplashAdapter.this).mDismissType = 3;
                }

                @Override // com.meishu.sdk.core.ad.IAdEventListener
                public void onAdError(AdErrorInfo adErrorInfo) {
                    ATBiddingListener aTBiddingListener2 = aTBiddingListener;
                    if (aTBiddingListener2 != null) {
                        aTBiddingListener2.onC2SBiddingResultWithCache(ATBiddingResult.fail(adErrorInfo.getMessage()), (BaseAd) null);
                    }
                    if (((CustomSplashAdapter) MsSplashAdapter.this).mLoadListener != null) {
                        ((CustomSplashAdapter) MsSplashAdapter.this).mLoadListener.onAdLoadError(adErrorInfo.getCode() + "", adErrorInfo.getMessage());
                    }
                }

                /* JADX WARN: Code duplicated, block: B:14:0x0030 A[Catch: all -> 0x005c, TryCatch #1 {all -> 0x005c, blocks: (B:3:0x0002, B:5:0x0008, B:7:0x0016, B:12:0x002c, B:14:0x0030, B:10:0x0027, B:15:0x003a, B:17:0x004f), top: B:24:0x0002, inners: #0 }] */
                @Override // com.meishu.sdk.core.ad.IAdEventListener
                public void onAdReady(ISplashAd iSplashAd) {
                    double d;
                    ATBiddingListener aTBiddingListener2;
                    if (iSplashAd != null) {
                        try {
                            if (iSplashAd.getData() != null) {
                                String string = UUID.randomUUID().toString();
                                if (iSplashAd.getData() != null) {
                                    try {
                                        d = Double.parseDouble(iSplashAd.getData().getEcpm()) / 100.0d;
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
                            iSplashAd.setInteractionListener(new InteractionListener() { // from class: com.meishu.sdk.platform.topon.splash.MsSplashAdapter.3.1
                                @Override // com.meishu.sdk.core.loader.InteractionListener
                                public void onAdClicked() {
                                    if (((CustomSplashAdapter) MsSplashAdapter.this).mImpressionListener != null) {
                                        ((CustomSplashAdapter) MsSplashAdapter.this).mImpressionListener.onSplashAdClicked();
                                    }
                                }

                                @Override // com.meishu.sdk.core.loader.InteractionListener
                                public void onAdClosed() {
                                    if (((CustomSplashAdapter) MsSplashAdapter.this).mImpressionListener != null) {
                                        ((CustomSplashAdapter) MsSplashAdapter.this).mImpressionListener.onSplashAdDismiss();
                                    }
                                }

                                @Override // com.meishu.sdk.core.loader.InteractionListener
                                public void onAdExposure() {
                                    if (((CustomSplashAdapter) MsSplashAdapter.this).mImpressionListener != null) {
                                        ((CustomSplashAdapter) MsSplashAdapter.this).mImpressionListener.onSplashAdShow();
                                    }
                                }
                            });
                            MsSplashAdapter.this.splashAd = iSplashAd;
                            if (((CustomSplashAdapter) MsSplashAdapter.this).mLoadListener != null) {
                                ((CustomSplashAdapter) MsSplashAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            }, 5000).loadAd();
        } else {
            if (aTBiddingListener != null) {
                aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail("load error"), (BaseAd) null);
            }
            ATCustomLoadListener aTCustomLoadListener = ((CustomSplashAdapter) this).mLoadListener;
            if (aTCustomLoadListener != null) {
                aTCustomLoadListener.onAdLoadError("", "app_id or slot_id is empty!");
            }
        }
    }

    public void destory() {
        this.splashAd = null;
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
        ISplashAd iSplashAd = this.splashAd;
        return iSplashAd != null && iSplashAd.isAdValid();
    }

    public void loadCustomNetworkAd(final Context context, final Map<String, Object> map, Map<String, Object> map2) {
        TopOnInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.meishu.sdk.platform.topon.splash.MsSplashAdapter.1
            public void onFail(String str) {
            }

            public void onSuccess() {
                MsSplashAdapter.this.loadAd(context, map, null);
            }
        });
    }

    public boolean startBiddingRequest(final Context context, final Map<String, Object> map, Map<String, Object> map2, final ATBiddingListener aTBiddingListener) {
        TopOnInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.meishu.sdk.platform.topon.splash.MsSplashAdapter.2
            public void onSuccess() {
                MsSplashAdapter.this.loadAd(context, map, aTBiddingListener);
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

    public void show(Activity activity, ViewGroup viewGroup) {
        ISplashAd iSplashAd = this.splashAd;
        if (iSplashAd != null) {
            iSplashAd.showAd(viewGroup);
        }
    }
}
