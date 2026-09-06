package com.meishu.sdk.platform.tradplus.recycler;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.meishu.sdk.core.ad.recycler.RecyclerAdData;
import com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener;
import com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener;
import com.meishu.sdk.core.utils.LogUtil;
import com.tradplus.ads.base.adapter.nativead.TPNativeAdView;
import com.tradplus.ads.base.bean.TPBaseAd;
import com.tradplus.ads.base.common.TPError;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MsNativeAd extends TPBaseAd {
    private static final String TAG = "TradPlus_MsNativeAd";
    private RecyclerAdData adData;
    private TPNativeAdView tpNativeAdView;
    private FrameLayout videoViewGroup;

    public MsNativeAd(Context context, RecyclerAdData recyclerAdData) {
        this.adData = recyclerAdData;
        setAdData(context);
    }

    private long parseLong(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return 0L;
            }
            return Long.parseLong(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return 0L;
        }
    }

    private void setAdData(Context context) {
        try {
            TPNativeAdView tPNativeAdView = new TPNativeAdView();
            this.tpNativeAdView = tPNativeAdView;
            tPNativeAdView.setTitle(this.adData.getTitle());
            this.tpNativeAdView.setSubTitle(this.adData.getDesc());
            this.tpNativeAdView.setIconImageUrl(this.adData.getIconUrl());
            this.tpNativeAdView.setAdChoiceUrl(this.adData.getFromLogo());
            String[] imgUrls = this.adData.getImgUrls();
            if (imgUrls != null && imgUrls.length > 0) {
                String str = imgUrls[0];
                if (this.adData.getAdPatternType() == 2) {
                    this.tpNativeAdView.setVideoUrl(str);
                    if (context == null) {
                        context = this.adData.getAdView().getContext();
                    }
                    FrameLayout frameLayout = new FrameLayout(context);
                    this.videoViewGroup = frameLayout;
                    this.tpNativeAdView.setMediaView(frameLayout);
                } else {
                    this.tpNativeAdView.setMainImageUrl(str);
                    this.tpNativeAdView.setPicUrls(Arrays.asList(imgUrls));
                }
            }
            this.tpNativeAdView.setCallToAction(this.adData.getActionText());
            this.tpNativeAdView.setAppName(this.adData.getAppName());
            this.tpNativeAdView.setAuthorName(this.adData.getDeveloper());
            this.tpNativeAdView.setVersionName(this.adData.getAppVersion());
            this.tpNativeAdView.setPermissionsUrl(this.adData.getAppPremissionUrl());
            this.tpNativeAdView.setPrivacyAgreement(this.adData.getPrivacyAgreement());
            this.tpNativeAdView.setPackageSizeBytes(parseLong(this.adData.getAppSize()));
            if (this.adData.getInteractionType() == 1) {
                TPNativeAdView.AppNativeInfo appNativeInfo = new TPNativeAdView.AppNativeInfo();
                appNativeInfo.setAppName(this.adData.getAppName());
                appNativeInfo.setAuthorName(this.adData.getDeveloper());
                appNativeInfo.setAppVrsion(this.adData.getAppVersion());
                appNativeInfo.setAppDetailUrl(this.adData.getAppIntroUrl());
                appNativeInfo.setAppPrivacyUrl(this.adData.getPrivacyAgreement());
                appNativeInfo.setAppPermissionUrl(this.adData.getAppPremissionUrl());
                this.tpNativeAdView.setAppNativeInfo(appNativeInfo);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public ViewGroup getCustomAdContainer() {
        return null;
    }

    public List<View> getMediaViews() {
        return null;
    }

    public int getNativeAdType() {
        return 0;
    }

    public Object getNetworkObj() {
        return null;
    }

    public View getRenderView() {
        return null;
    }

    public TPNativeAdView getTPNativeView() {
        return this.tpNativeAdView;
    }

    public void registerClickView(ViewGroup viewGroup, ArrayList<View> arrayList) {
        LogUtil.d(TAG, "registerClickView");
        this.adData.bindAdToView(viewGroup.getContext(), viewGroup, arrayList, new RecylcerAdInteractionListener() { // from class: com.meishu.sdk.platform.tradplus.recycler.MsNativeAd.1
            @Override // com.meishu.sdk.core.loader.InteractionListener
            public void onAdClicked() {
                if (((TPBaseAd) MsNativeAd.this).mShowListener != null) {
                    ((TPBaseAd) MsNativeAd.this).mShowListener.onAdClicked();
                }
            }

            @Override // com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener, com.meishu.sdk.core.loader.InteractionListener
            public void onAdClosed() {
                if (((TPBaseAd) MsNativeAd.this).mShowListener != null) {
                    ((TPBaseAd) MsNativeAd.this).mShowListener.onAdClosed();
                }
            }

            @Override // com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener, com.meishu.sdk.core.loader.InteractionListener
            public void onAdExposure() {
                if (((TPBaseAd) MsNativeAd.this).mShowListener != null) {
                    ((TPBaseAd) MsNativeAd.this).mShowListener.onAdShown();
                }
            }

            @Override // com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener
            public void onAdRenderFailed() {
            }
        });
        FrameLayout frameLayout = this.videoViewGroup;
        if (frameLayout != null) {
            this.adData.bindMediaView(frameLayout, new RecyclerAdMediaListener() { // from class: com.meishu.sdk.platform.tradplus.recycler.MsNativeAd.2
                @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
                public void onVideoCompleted() {
                    if (((TPBaseAd) MsNativeAd.this).mShowListener != null) {
                        ((TPBaseAd) MsNativeAd.this).mShowListener.onAdVideoEnd();
                    }
                }

                @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
                public void onVideoError() {
                    if (((TPBaseAd) MsNativeAd.this).mShowListener != null) {
                        ((TPBaseAd) MsNativeAd.this).mShowListener.onAdVideoError(new TPError());
                    }
                }

                @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
                public void onVideoPause() {
                }

                @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
                public void onVideoResume() {
                }

                @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
                public void onVideoStart() {
                    if (((TPBaseAd) MsNativeAd.this).mShowListener != null) {
                        ((TPBaseAd) MsNativeAd.this).mShowListener.onAdVideoStart();
                    }
                }
            });
        }
    }

    public void clean() {
        RecyclerAdData recyclerAdData = this.adData;
        if (recyclerAdData != null) {
            recyclerAdData.destroy();
            this.adData = null;
        }
    }
}
