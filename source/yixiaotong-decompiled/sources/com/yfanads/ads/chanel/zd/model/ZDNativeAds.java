package com.yfanads.ads.chanel.zd.model;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.meishu.sdk.core.ad.recycler.RecyclerAdData;
import com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener;
import com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener;
import com.yfanads.ads.chanel.zd.R;
import com.yfanads.android.core.render.YFNativeAdView;
import com.yfanads.android.core.render.api.YFAdVideoPlayConfig;
import com.yfanads.android.core.render.api.YFAppDownloadListener;
import com.yfanads.android.core.render.api.YFNativeAd;
import com.yfanads.android.core.render.api.YFNativeCall;
import com.yfanads.android.core.render.impl.YFAbsNativeAd;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class ZDNativeAds extends YFAbsNativeAd implements RecyclerAdMediaListener {
    private FrameLayout adVideoContainer;
    private RecyclerAdData nativeAdBean;
    private YFNativeAd.VideoPlayListener videoPlayListener;

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAppIconUrl() {
        return "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getBrandName() {
        return "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getVideoCoverImage() {
        return "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public View getVideoView(Context context, YFAdVideoPlayConfig yFAdVideoPlayConfig) {
        return this.adVideoContainer;
    }

    @Override // com.yfanads.android.core.render.impl.YFAbsNativeAd, com.yfanads.android.core.render.api.YFNativeAd
    public void renderAdContainer(YFNativeAdView yFNativeAdView, View view) {
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public void setBidEcpm(long j) {
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public void setDownloadListener(YFAppDownloadListener yFAppDownloadListener) {
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public void setVideoPlayListener(YFNativeAd.VideoPlayListener videoPlayListener) {
        this.videoPlayListener = videoPlayListener;
    }

    public ZDNativeAds(Context context, RecyclerAdData recyclerAdData, YFNativeCall yFNativeCall) {
        super(yFNativeCall, 0);
        this.nativeAdBean = recyclerAdData;
        FrameLayout frameLayout = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        frameLayout.setLayoutParams(layoutParams);
        this.adVideoContainer = frameLayout;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAdDescription() {
        RecyclerAdData recyclerAdData = this.nativeAdBean;
        return recyclerAdData != null ? recyclerAdData.getDesc() : "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAdTitle() {
        RecyclerAdData recyclerAdData = this.nativeAdBean;
        return recyclerAdData != null ? recyclerAdData.getTitle() : "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getAdSourceLogo() {
        return R.mipmap.ad_logo_zd_v1;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public List<String> getImageList() {
        RecyclerAdData recyclerAdData = this.nativeAdBean;
        if (recyclerAdData != null && recyclerAdData.getImgUrls().length > 0) {
            return Arrays.asList(this.nativeAdBean.getImgUrls());
        }
        return new ArrayList();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getCorporationName() {
        RecyclerAdData recyclerAdData = this.nativeAdBean;
        return recyclerAdData != null ? recyclerAdData.getDeveloper() : "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getPermissionInfoUrl() {
        RecyclerAdData recyclerAdData = this.nativeAdBean;
        return recyclerAdData != null ? recyclerAdData.getAppPremissionUrl() : "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getIntroductionInfoUrl() {
        RecyclerAdData recyclerAdData = this.nativeAdBean;
        return recyclerAdData != null ? recyclerAdData.getAppIntroUrl() : "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAppPrivacyUrl() {
        RecyclerAdData recyclerAdData = this.nativeAdBean;
        return recyclerAdData != null ? recyclerAdData.getPrivacyAgreement() : "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAppName() {
        RecyclerAdData recyclerAdData = this.nativeAdBean;
        return recyclerAdData != null ? recyclerAdData.getAppName() : "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAppVersion() {
        RecyclerAdData recyclerAdData = this.nativeAdBean;
        return recyclerAdData != null ? recyclerAdData.getAppVersion() : "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getVideoWidth() {
        RecyclerAdData recyclerAdData = this.nativeAdBean;
        if (recyclerAdData != null) {
            return recyclerAdData.getWidth();
        }
        return 0;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getVideoHeight() {
        RecyclerAdData recyclerAdData = this.nativeAdBean;
        if (recyclerAdData != null) {
            return recyclerAdData.getHeight();
        }
        return 0;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getActionDescription() {
        RecyclerAdData recyclerAdData = this.nativeAdBean;
        return recyclerAdData != null ? recyclerAdData.getActionText() : "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getMaterialType() {
        RecyclerAdData recyclerAdData = this.nativeAdBean;
        return (recyclerAdData == null || recyclerAdData.getAdPatternType() != 2) ? 2 : 1;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getInteractionType() {
        RecyclerAdData recyclerAdData = this.nativeAdBean;
        return (recyclerAdData == null || recyclerAdData.getInteractionType() != 1) ? 0 : 1;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getECPM() {
        RecyclerAdData recyclerAdData = this.nativeAdBean;
        if (recyclerAdData == null || recyclerAdData.getData() == null) {
            return 0;
        }
        return YFUtil.toInt(this.nativeAdBean.getData().getEcpm(), 0);
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public void registerViewForInteraction(Activity activity, ViewGroup viewGroup, Map<View, Integer> map, final YFNativeAd.AdInteractionListener adInteractionListener) {
        YFLog.high("ZDNativeAds registerViewForInteraction " + hashCode() + "|size:" + (map != null ? map.size() : 0));
        if (YFListUtils.isMapEmpty(map)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (View view : map.keySet()) {
            Integer num = map.get(view);
            YFLog.debug("ZDNativeAds registerViewForInteraction view:" + view + "|" + num);
            if (num != null) {
                int iIntValue = num.intValue();
                if (iIntValue == 0 || iIntValue == 1) {
                    arrayList.add(view);
                } else if (iIntValue == 2) {
                    handleClose(view, adInteractionListener);
                } else if (iIntValue == 3) {
                    onFeedBack(activity.getFragmentManager(), view);
                }
            }
        }
        RecyclerAdData recyclerAdData = this.nativeAdBean;
        if (recyclerAdData != null) {
            recyclerAdData.bindAdToView(activity, viewGroup, arrayList, new RecylcerAdInteractionListener() { // from class: com.yfanads.ads.chanel.zd.model.ZDNativeAds.1
                @Override // com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener, com.meishu.sdk.core.loader.InteractionListener
                public void onAdClosed() {
                    ZDNativeAds.this.handleClose(adInteractionListener);
                }

                @Override // com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener
                public void onAdRenderFailed() {
                    YFLog.debug("onAdRenderFailed");
                }

                @Override // com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener, com.meishu.sdk.core.loader.InteractionListener
                public void onAdExposure() {
                    ZDNativeAds.this.handleExposure(adInteractionListener);
                }

                @Override // com.meishu.sdk.core.loader.InteractionListener
                public void onAdClicked() {
                    ZDNativeAds.this.handleClick(adInteractionListener);
                }
            });
            if (getMaterialType() == 1) {
                this.nativeAdBean.bindMediaView(this.adVideoContainer, this);
            }
        }
    }

    public String getAdReqId() {
        RecyclerAdData recyclerAdData = this.nativeAdBean;
        return (recyclerAdData == null || recyclerAdData.getData() == null) ? "" : this.nativeAdBean.getData().getReqId();
    }

    public boolean isReady() {
        RecyclerAdData recyclerAdData = this.nativeAdBean;
        return recyclerAdData != null && recyclerAdData.isAdValid();
    }

    public void sendSucBiddingResult(Map<String, Object> map) {
        RecyclerAdData recyclerAdData = this.nativeAdBean;
        if (recyclerAdData != null) {
            recyclerAdData.sendWinNotification(map);
        }
    }

    public void sendLossBiddingResult(Map<String, Object> map) {
        RecyclerAdData recyclerAdData = this.nativeAdBean;
        if (recyclerAdData != null) {
            recyclerAdData.sendLossNotification(map);
        }
    }

    @Override // com.yfanads.android.core.render.api.BaseKSAd
    public void onDestroy() {
        RecyclerAdData recyclerAdData = this.nativeAdBean;
        if (recyclerAdData != null) {
            recyclerAdData.destroy();
            this.nativeAdBean = null;
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
    public void onVideoStart() {
        YFNativeAd.VideoPlayListener videoPlayListener = this.videoPlayListener;
        if (videoPlayListener != null) {
            videoPlayListener.onVideoPlayStart();
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
    public void onVideoPause() {
        YFNativeAd.VideoPlayListener videoPlayListener = this.videoPlayListener;
        if (videoPlayListener != null) {
            videoPlayListener.onVideoPlayPause();
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
    public void onVideoCompleted() {
        YFNativeAd.VideoPlayListener videoPlayListener = this.videoPlayListener;
        if (videoPlayListener != null) {
            videoPlayListener.onVideoPlayComplete();
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
    public void onVideoError() {
        YFNativeAd.VideoPlayListener videoPlayListener = this.videoPlayListener;
        if (videoPlayListener != null) {
            videoPlayListener.onVideoPlayError(9901, 10001);
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener
    public void onVideoResume() {
        YFNativeAd.VideoPlayListener videoPlayListener = this.videoPlayListener;
        if (videoPlayListener != null) {
            videoPlayListener.onVideoPlayResume();
        }
    }
}
