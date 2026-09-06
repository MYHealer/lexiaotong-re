package com.meishu.sdk.platform.csjblend;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.draw.MediationCustomDrawLoader;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig;
import com.meishu.sdk.activity.a;
import com.meishu.sdk.core.ad.MsAdSlot;
import com.meishu.sdk.core.ad.draw.DrawAdEventListener;
import com.meishu.sdk.core.ad.draw.DrawAdLoader;
import com.meishu.sdk.core.ad.draw.IDrawAd;
import com.meishu.sdk.core.loader.InteractionListener;
import com.meishu.sdk.core.utils.AdErrorInfo;
import com.meishu.sdk.core.utils.LogUtil;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MsCBCustomDrawAdapter extends MediationCustomDrawLoader {
    private static final String TAG = "MsCBCCustomDrawAdapter";
    private MsCBDrawAd msgmDrawAd;
    private boolean calledLoadSuccess = false;
    private boolean calledExposure = false;

    public boolean isClientBidding() {
        return getBiddingType() == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public void load(Context context, AdSlot adSlot, MediationCustomServiceConfig mediationCustomServiceConfig) {
        LogUtil.e(TAG, a.a("开始加载gromore自定义平台draw，pid=").append(mediationCustomServiceConfig.getADNNetworkSlotId()).toString());
        this.calledLoadSuccess = false;
        this.calledExposure = false;
        try {
            new DrawAdLoader(context, new MsAdSlot.Builder().setPid(mediationCustomServiceConfig.getADNNetworkSlotId()).build(), new DrawAdEventListener() { // from class: com.meishu.sdk.platform.csjblend.MsCBCustomDrawAdapter.1
                @Override // com.meishu.sdk.core.ad.IAdEventListener
                public void onAdError(AdErrorInfo adErrorInfo) {
                    MsCBCustomDrawAdapter.this.callLoadFail(-1, "loadAdError");
                }

                @Override // com.meishu.sdk.core.ad.IAdEventListener
                public void onAdReady(IDrawAd iDrawAd) {
                    double d;
                    if (iDrawAd != null) {
                        iDrawAd.setInteractionListener(new InteractionListener() { // from class: com.meishu.sdk.platform.csjblend.MsCBCustomDrawAdapter.1.1
                            @Override // com.meishu.sdk.core.loader.InteractionListener
                            public void onAdClicked() {
                                if (MsCBCustomDrawAdapter.this.msgmDrawAd != null) {
                                    MsCBCustomDrawAdapter.this.msgmDrawAd.callAdClick();
                                }
                            }

                            @Override // com.meishu.sdk.core.loader.InteractionListener
                            public void onAdClosed() {
                            }

                            @Override // com.meishu.sdk.core.loader.InteractionListener
                            public void onAdExposure() {
                                if (MsCBCustomDrawAdapter.this.calledExposure) {
                                    return;
                                }
                                MsCBCustomDrawAdapter.this.calledExposure = true;
                                if (MsCBCustomDrawAdapter.this.msgmDrawAd != null) {
                                    MsCBCustomDrawAdapter.this.msgmDrawAd.callAdShow();
                                }
                            }
                        });
                        MsCBCustomDrawAdapter.this.msgmDrawAd = new MsCBDrawAd(iDrawAd);
                        if (MsCBCustomDrawAdapter.this.isClientBidding()) {
                            if (iDrawAd.getData() != null) {
                                try {
                                    d = Double.parseDouble(iDrawAd.getData().getEcpm());
                                } catch (NumberFormatException e) {
                                    e.printStackTrace();
                                    d = 0.0d;
                                }
                            } else {
                                d = 0.0d;
                            }
                            MsCBCustomDrawAdapter.this.msgmDrawAd.setBiddingPrice(d);
                        }
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(MsCBCustomDrawAdapter.this.msgmDrawAd);
                        if (MsCBCustomDrawAdapter.this.calledLoadSuccess) {
                            return;
                        }
                        MsCBCustomDrawAdapter.this.calledLoadSuccess = true;
                        MsCBCustomDrawAdapter.this.callLoadSuccess(arrayList);
                    }
                }
            }).loadAd();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
