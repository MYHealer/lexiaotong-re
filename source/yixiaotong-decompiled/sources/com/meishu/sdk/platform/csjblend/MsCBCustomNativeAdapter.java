package com.meishu.sdk.platform.csjblend;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad.MediationCustomNativeLoader;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig;
import com.meishu.sdk.activity.a;
import com.meishu.sdk.core.ad.MsAdSlot;
import com.meishu.sdk.core.ad.recycler.RecyclerAdData;
import com.meishu.sdk.core.ad.recycler.RecyclerAdEventListener;
import com.meishu.sdk.core.ad.recycler.RecyclerMixAdLoader;
import com.meishu.sdk.core.utils.AdErrorInfo;
import com.meishu.sdk.core.utils.LogUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MsCBCustomNativeAdapter extends MediationCustomNativeLoader {
    private static final String TAG = "MsCBCustomNativeAdapter";
    private RecyclerAdData adData;
    private boolean calledLoadSuccess = false;
    private MsCBGMExpressAd hygmExpressAd;
    private MsCBGMNativeAd hygmNativeAd;

    public boolean isClientBidding() {
        return getBiddingType() == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public void load(final Context context, AdSlot adSlot, MediationCustomServiceConfig mediationCustomServiceConfig) {
        LogUtil.d(TAG, a.a("开始加载gromore自定义平台信息流，pid=").append(mediationCustomServiceConfig.getADNNetworkSlotId()).toString());
        this.calledLoadSuccess = false;
        new RecyclerMixAdLoader(context, new MsAdSlot.Builder().setPid(mediationCustomServiceConfig.getADNNetworkSlotId()).build(), new RecyclerAdEventListener() { // from class: com.meishu.sdk.platform.csjblend.MsCBCustomNativeAdapter.1
            @Override // com.meishu.sdk.core.ad.IAdEventListener
            public void onAdError(AdErrorInfo adErrorInfo) {
                MsCBCustomNativeAdapter.this.callLoadFail(-1, "loadAdError");
            }

            @Override // com.meishu.sdk.core.ad.IAdEventListener
            public void onAdReady(List<RecyclerAdData> list) {
                if (list != null) {
                    try {
                        if (list.size() > 0) {
                            MsCBCustomNativeAdapter.this.adData = list.get(0);
                            if (MsCBCustomNativeAdapter.this.adData == null) {
                                MsCBCustomNativeAdapter.this.callLoadFail(-1, "加载失败");
                                return;
                            }
                            ArrayList arrayList = new ArrayList();
                            double d = 0.0d;
                            if (MsCBCustomNativeAdapter.this.adData.isNativeExpress()) {
                                MsCBCustomNativeAdapter.this.hygmExpressAd = new MsCBGMExpressAd(context, MsCBCustomNativeAdapter.this.adData);
                                try {
                                    MsCBCustomNativeAdapter.this.hygmExpressAd.setExpressAd(true);
                                    if (MsCBCustomNativeAdapter.this.isClientBidding()) {
                                        if (MsCBCustomNativeAdapter.this.adData.getData() != null) {
                                            try {
                                                d = Double.parseDouble(MsCBCustomNativeAdapter.this.adData.getData().getEcpm());
                                            } catch (NumberFormatException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                        MsCBCustomNativeAdapter.this.hygmExpressAd.setBiddingPrice(d);
                                    }
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                                arrayList.add(MsCBCustomNativeAdapter.this.hygmExpressAd);
                            } else {
                                MsCBCustomNativeAdapter.this.hygmNativeAd = new MsCBGMNativeAd(MsCBCustomNativeAdapter.this.adData);
                                if (MsCBCustomNativeAdapter.this.isClientBidding()) {
                                    if (MsCBCustomNativeAdapter.this.adData.getData() != null) {
                                        try {
                                            d = Double.parseDouble(MsCBCustomNativeAdapter.this.adData.getData().getEcpm());
                                        } catch (NumberFormatException e2) {
                                            e2.printStackTrace();
                                        }
                                    }
                                    MsCBCustomNativeAdapter.this.hygmNativeAd.setBiddingPrice(d);
                                }
                                arrayList.add(MsCBCustomNativeAdapter.this.hygmNativeAd);
                            }
                            if (MsCBCustomNativeAdapter.this.calledLoadSuccess) {
                                return;
                            }
                            MsCBCustomNativeAdapter.this.calledLoadSuccess = true;
                            MsCBCustomNativeAdapter.this.callLoadSuccess(arrayList);
                        }
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
            }
        }).loadAd();
    }
}
