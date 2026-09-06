package com.meishu.sdk.platform.sigmob.custom.feed;

import com.meishu.sdk.core.ad.recycler.RecyclerMixAdLoader;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.utils.t0;
import com.meishu.sdk.platform.custom.recycler.MsCustomRecyclerAdapter;
import com.meishu.sdk.platform.sigmob.custom.SigmobCustomInitManager;
import com.sigmob.windad.WindAdBiddingLossReason;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.natives.WindNativeAdData;
import com.sigmob.windad.natives.WindNativeAdRequest;
import com.sigmob.windad.natives.WindNativeUnifiedAd;
import com.unionpay.tsmservice.data.Constant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class SigmobCustomFeedAdapter extends MsCustomRecyclerAdapter {
    private SigmobCustomNativeAd sigmobCustomFeedAd;
    private WindNativeUnifiedAd windNativeUnifiedAd;

    public SigmobCustomFeedAdapter(RecyclerMixAdLoader recyclerMixAdLoader, SdkAdInfo sdkAdInfo) {
        super(recyclerMixAdLoader, sdkAdInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAdWithCallback(String str) {
        WindNativeUnifiedAd windNativeUnifiedAd = new WindNativeUnifiedAd(new WindNativeAdRequest(str, (String) null, 1, (Map) null));
        this.windNativeUnifiedAd = windNativeUnifiedAd;
        windNativeUnifiedAd.setNativeAdLoadListener(new WindNativeUnifiedAd.WindNativeAdLoadListener() { // from class: com.meishu.sdk.platform.sigmob.custom.feed.SigmobCustomFeedAdapter.2
            public void onAdError(WindAdError windAdError, String str2) {
                SigmobCustomFeedAdapter.this.onRenderFail(-1, "加载失败");
            }

            public void onAdLoad(List<WindNativeAdData> list, String str2) {
                if (list == null || list.isEmpty()) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                WindNativeAdData windNativeAdData = list.get(0);
                if (SigmobCustomFeedAdapter.this.windNativeUnifiedAd != null) {
                    String ecpm = SigmobCustomFeedAdapter.this.windNativeUnifiedAd.getEcpm();
                    if (SigmobCustomFeedAdapter.this.getSdkAdInfo() != null) {
                        SigmobCustomFeedAdapter.this.getSdkAdInfo().setEcpm(ecpm);
                    }
                }
                SigmobCustomFeedAdapter sigmobCustomFeedAdapter = SigmobCustomFeedAdapter.this;
                sigmobCustomFeedAdapter.sigmobCustomFeedAd = new SigmobCustomNativeAd(sigmobCustomFeedAdapter, windNativeAdData);
                arrayList.add(SigmobCustomFeedAdapter.this.sigmobCustomFeedAd);
                SigmobCustomFeedAdapter.this.onFeedAdLoad(arrayList);
            }
        });
        this.windNativeUnifiedAd.loadAd();
    }

    @Override // com.meishu.sdk.platform.custom.recycler.MsCustomRecyclerAdapter
    public void loadCustomAd(String str, String str2, final String str3, String str4) {
        SigmobCustomInitManager.getInstance().initSdk(this.context, str, str2, new SigmobCustomInitManager.InitCallback() { // from class: com.meishu.sdk.platform.sigmob.custom.feed.SigmobCustomFeedAdapter.1
            @Override // com.meishu.sdk.platform.sigmob.custom.SigmobCustomInitManager.InitCallback
            public void onError(int i, String str5) {
            }

            @Override // com.meishu.sdk.platform.sigmob.custom.SigmobCustomInitManager.InitCallback
            public void onSuccess() {
                SigmobCustomFeedAdapter.this.loadAdWithCallback(str3);
            }
        });
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader
    public void sendGdtWinResult(boolean z, int i) {
        try {
            if (this.windNativeUnifiedAd != null) {
                if (z) {
                    HashMap map = new HashMap();
                    map.put("AUCTION_PRICE", Integer.valueOf(Integer.parseInt(this.windNativeUnifiedAd.getEcpm())));
                    map.put("HIGHEST_LOSS_PRICE", Integer.valueOf(t0.a(Integer.parseInt(this.windNativeUnifiedAd.getEcpm()), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice())));
                    map.put("CURRENCY", Constant.KEY_CURRENCYTYPE_CNY);
                    this.windNativeUnifiedAd.sendWinNotificationWithInfo(map);
                } else {
                    HashMap map2 = new HashMap();
                    map2.put("AUCTION_PRICE", Integer.valueOf(i));
                    map2.put("CURRENCY", Constant.KEY_CURRENCYTYPE_CNY);
                    map2.put("LOSS_REASON", Integer.valueOf(WindAdBiddingLossReason.LOSS_REASON_LOW_PRICE.getCode()));
                    this.windNativeUnifiedAd.sendLossNotificationWithInfo(map2);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
