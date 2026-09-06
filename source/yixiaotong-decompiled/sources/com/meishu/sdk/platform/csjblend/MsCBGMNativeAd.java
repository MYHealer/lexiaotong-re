package com.meishu.sdk.platform.csjblend;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationViewBinder;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad.MediationCustomNativeAd;
import com.meishu.sdk.core.ad.recycler.RecyclerAdData;
import com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener;
import com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MsCBGMNativeAd extends MediationCustomNativeAd {
    private RecyclerAdData adData;
    private boolean calledExposure = false;

    public MsCBGMNativeAd(RecyclerAdData recyclerAdData) {
        this.adData = recyclerAdData;
        try {
            setActionText(recyclerAdData.getActionText());
            setDescription(recyclerAdData.getDesc());
            setIconUrl(recyclerAdData.getIconUrl());
            setSource(recyclerAdData.getAppName());
            setTitle(recyclerAdData.getTitle());
            setExpressAd(false);
            if (recyclerAdData.getInteractionType() == 1) {
                setInteractionType(4);
            } else {
                setInteractionType(3);
            }
            String[] imgUrls = recyclerAdData.getImgUrls();
            if (imgUrls != null && imgUrls.length > 0) {
                if (recyclerAdData.getAdPatternType() == 12 || recyclerAdData.getAdPatternType() == 1 || recyclerAdData.getAdPatternType() == 11) {
                    setImageUrl(imgUrls[0]);
                } else if (recyclerAdData.getAdPatternType() == 13) {
                    setImageList(Arrays.asList(imgUrls));
                }
            }
            setAdImageMode(getAdImageMode());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int getAdImageMode() {
        int adPatternType = this.adData.getAdPatternType();
        if (adPatternType == 2) {
            return 5;
        }
        if (adPatternType != 11) {
            return adPatternType != 13 ? 3 : 4;
        }
        return 2;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad.MediationCustomNativeAd, com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public boolean isClientBidding() {
        return getBiddingType() == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad.MediationCustomNativeAd, com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public MediationConstant.AdIsReadyStatus isReadyCondition() {
        RecyclerAdData recyclerAdData = this.adData;
        return (recyclerAdData == null || !recyclerAdData.isAdValid()) ? MediationConstant.AdIsReadyStatus.AD_IS_EXPIRED : MediationConstant.AdIsReadyStatus.AD_IS_READY;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad.MediationCustomNativeAd, com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void registerView(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, MediationViewBinder mediationViewBinder) {
        RecyclerAdData recyclerAdData = this.adData;
        if (recyclerAdData != null) {
            recyclerAdData.bindAdToView(activity, viewGroup, list, new RecylcerAdInteractionListener() { // from class: com.meishu.sdk.platform.csjblend.MsCBGMNativeAd.1
                @Override // com.meishu.sdk.core.loader.InteractionListener
                public void onAdClicked() {
                    MsCBGMNativeAd.this.callAdClick();
                }

                @Override // com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener, com.meishu.sdk.core.loader.InteractionListener
                public void onAdClosed() {
                }

                @Override // com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener, com.meishu.sdk.core.loader.InteractionListener
                public void onAdExposure() {
                    if (MsCBGMNativeAd.this.calledExposure) {
                        return;
                    }
                    MsCBGMNativeAd.this.calledExposure = true;
                    MsCBGMNativeAd.this.callAdShow();
                }

                @Override // com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener
                public void onAdRenderFailed() {
                }
            });
            if (viewGroup == null || mediationViewBinder == null) {
                return;
            }
            try {
                View viewFindViewById = viewGroup.findViewById(mediationViewBinder.mediaViewId);
                if (viewFindViewById instanceof ViewGroup) {
                    this.adData.bindMediaView((ViewGroup) viewFindViewById, new RecyclerAdMediaListener() { // from class: com.meishu.sdk.platform.csjblend.MsCBGMNativeAd.2
                        @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
                        public void onVideoCompleted() {
                        }

                        @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
                        public void onVideoError() {
                        }

                        @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
                        public void onVideoLoaded() {
                        }

                        @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
                        public void onVideoPause() {
                        }

                        @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
                        public void onVideoResume() {
                        }

                        @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
                        public void onVideoStart() {
                        }
                    });
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
