package com.meishu.sdk.platform.topon.recycler;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingNotice;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATCustomLoadListener;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.nativead.unitgroup.api.CustomNativeAdapter;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.ad.MsAdSlot;
import com.meishu.sdk.core.ad.recycler.RecyclerAdData;
import com.meishu.sdk.core.ad.recycler.RecyclerAdEventListener;
import com.meishu.sdk.core.ad.recycler.RecyclerMixAdLoader;
import com.meishu.sdk.core.utils.AdErrorInfo;
import com.meishu.sdk.platform.topon.TopOnInitManager;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MsRecyclerAdapter extends CustomNativeAdapter {
    private RecyclerAdData adData;
    private MsExpressAd hrExpressAd;
    private MsNativeAd hrNativeAd;
    private RecyclerMixAdLoader recyclerMixAdLoader;
    private String slotId;

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd(Context context, Map<String, Object> map, final ATBiddingListener aTBiddingListener) {
        String str = (String) map.get("app_id");
        this.slotId = (String) map.get("slot_id");
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.slotId)) {
            RecyclerMixAdLoader recyclerMixAdLoader = new RecyclerMixAdLoader(context, new MsAdSlot.Builder().setPid(this.slotId).build(), new RecyclerAdEventListener() { // from class: com.meishu.sdk.platform.topon.recycler.MsRecyclerAdapter.3
                @Override // com.meishu.sdk.core.ad.IAdEventListener
                public void onAdError(AdErrorInfo adErrorInfo) {
                    ATBiddingListener aTBiddingListener2 = aTBiddingListener;
                    if (aTBiddingListener2 != null) {
                        aTBiddingListener2.onC2SBiddingResultWithCache(ATBiddingResult.fail("load error"), (BaseAd) null);
                    }
                    if (((CustomNativeAdapter) MsRecyclerAdapter.this).mLoadListener != null) {
                        ((CustomNativeAdapter) MsRecyclerAdapter.this).mLoadListener.onAdLoadError("-1", "加载失败");
                    }
                }

                @Override // com.meishu.sdk.core.ad.IAdEventListener
                public void onAdReady(List<RecyclerAdData> list) {
                    if (list != null) {
                        try {
                            if (list.size() > 0) {
                                MsRecyclerAdapter.this.adData = list.get(0);
                                double d = 0.0d;
                                if (MsRecyclerAdapter.this.adData.isNativeExpress()) {
                                    MsRecyclerAdapter.this.hrExpressAd = new MsExpressAd(MsRecyclerAdapter.this.adData);
                                    if (MsRecyclerAdapter.this.adData.getData() != null) {
                                        String string = UUID.randomUUID().toString();
                                        if (MsRecyclerAdapter.this.adData.getData() != null) {
                                            try {
                                                d = Double.parseDouble(MsRecyclerAdapter.this.adData.getData().getEcpm()) / 100.0d;
                                            } catch (NumberFormatException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                        if (((CustomNativeAdapter) MsRecyclerAdapter.this).mLoadListener != null) {
                                            ((CustomNativeAdapter) MsRecyclerAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[]{MsRecyclerAdapter.this.hrExpressAd});
                                        }
                                        ATBiddingListener aTBiddingListener2 = aTBiddingListener;
                                        if (aTBiddingListener2 != null) {
                                            aTBiddingListener2.onC2SBiddingResultWithCache(ATBiddingResult.success(d, string, (ATBiddingNotice) null, ATAdConst.CURRENCY.RMB), MsRecyclerAdapter.this.hrExpressAd);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                MsRecyclerAdapter.this.hrNativeAd = new MsNativeAd(MsRecyclerAdapter.this.adData);
                                if (MsRecyclerAdapter.this.adData.getData() != null) {
                                    String string2 = UUID.randomUUID().toString();
                                    if (MsRecyclerAdapter.this.adData.getData() != null) {
                                        try {
                                            d = Double.parseDouble(MsRecyclerAdapter.this.adData.getData().getEcpm()) / 100.0d;
                                        } catch (NumberFormatException e2) {
                                            e2.printStackTrace();
                                        }
                                    }
                                    if (((CustomNativeAdapter) MsRecyclerAdapter.this).mLoadListener != null) {
                                        ((CustomNativeAdapter) MsRecyclerAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[]{MsRecyclerAdapter.this.hrNativeAd});
                                    }
                                    ATBiddingListener aTBiddingListener3 = aTBiddingListener;
                                    if (aTBiddingListener3 != null) {
                                        aTBiddingListener3.onC2SBiddingResultWithCache(ATBiddingResult.success(d, string2, (ATBiddingNotice) null, ATAdConst.CURRENCY.RMB), MsRecyclerAdapter.this.hrNativeAd);
                                        return;
                                    }
                                    return;
                                }
                                return;
                                th.printStackTrace();
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            });
            this.recyclerMixAdLoader = recyclerMixAdLoader;
            recyclerMixAdLoader.loadAd();
        } else {
            if (aTBiddingListener != null) {
                aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail("load error"), (BaseAd) null);
            }
            ATCustomLoadListener aTCustomLoadListener = ((CustomNativeAdapter) this).mLoadListener;
            if (aTCustomLoadListener != null) {
                aTCustomLoadListener.onAdLoadError("", " app_id or slot_id is empty!");
            }
        }
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

    public void loadCustomNetworkAd(final Context context, final Map<String, Object> map, Map<String, Object> map2) {
        TopOnInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.meishu.sdk.platform.topon.recycler.MsRecyclerAdapter.1
            public void onFail(String str) {
            }

            public void onSuccess() {
                MsRecyclerAdapter.this.loadAd(context, map, null);
            }
        });
    }

    public boolean startBiddingRequest(final Context context, final Map<String, Object> map, Map<String, Object> map2, final ATBiddingListener aTBiddingListener) {
        TopOnInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.meishu.sdk.platform.topon.recycler.MsRecyclerAdapter.2
            public void onSuccess() {
                MsRecyclerAdapter.this.loadAd(context, map, aTBiddingListener);
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
        RecyclerMixAdLoader recyclerMixAdLoader = this.recyclerMixAdLoader;
        if (recyclerMixAdLoader != null) {
            recyclerMixAdLoader.destroy();
        }
    }
}
