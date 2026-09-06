package com.yfanads.ads.chanel.in.model;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ubixnow.adtype.nativead.api.UMNNativeAd;
import com.ubixnow.adtype.nativead.api.UMNNativeAdBean;
import com.ubixnow.adtype.nativead.api.UMNNativeAdView;
import com.ubixnow.adtype.nativead.api.UMNNativeEventListener;
import com.ubixnow.adtype.nativead.api.UMNNativeMaterial;
import com.ubixnow.adtype.nativead.api.UMNNativeMediaListener;
import com.ubixnow.core.bean.UMNNativeExtraInfo;
import com.yfanads.ads.chanel.in.R;
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
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class INNativeAds extends YFAbsNativeAd {
    private UMNNativeAdBean nativeAdBean;
    private final UMNNativeAdView nativeAdContainer;
    private UMNNativeAd nativeExpressAd;

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getBrandName() {
        return "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getVideoCoverImage() {
        return "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public void setBidEcpm(long j) {
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public void setDownloadListener(YFAppDownloadListener yFAppDownloadListener) {
    }

    public INNativeAds(Context context, UMNNativeAd uMNNativeAd, UMNNativeAdBean uMNNativeAdBean, YFNativeCall yFNativeCall) {
        super(yFNativeCall, 0);
        this.nativeExpressAd = uMNNativeAd;
        this.nativeAdBean = uMNNativeAdBean;
        this.nativeAdContainer = new UMNNativeAdView(context);
    }

    private UMNNativeMaterial getAdResponse() {
        UMNNativeAdBean uMNNativeAdBean = this.nativeAdBean;
        if (uMNNativeAdBean != null) {
            return uMNNativeAdBean.getMaterial();
        }
        return null;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAdDescription() {
        return getAdResponse() != null ? getAdResponse().getDescriptionText() : "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAdTitle() {
        return getAdResponse() != null ? getAdResponse().getTitle() : "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getAdSourceLogo() {
        return R.mipmap.ad_logo_in_v1;
    }

    public String getAdReqId() {
        return this.nativeExpressAd.getRequestId();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public List<String> getImageList() {
        if (getAdResponse() != null && !TextUtils.isEmpty(getAdResponse().getMainImageUrl())) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(getAdResponse().getMainImageUrl());
            return arrayList;
        }
        return new ArrayList();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAppIconUrl() {
        return getAdResponse() != null ? getAdResponse().getIconImageUrl() : "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getCorporationName() {
        UMNNativeMaterial.DownloadAppinfo downloadAppinfo = getAdResponse() != null ? getAdResponse().getDownloadAppinfo() : null;
        return downloadAppinfo != null ? downloadAppinfo.getAppPublisher() : "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getPermissionInfoUrl() {
        UMNNativeMaterial.DownloadAppinfo downloadAppinfo = getAdResponse() != null ? getAdResponse().getDownloadAppinfo() : null;
        return downloadAppinfo != null ? downloadAppinfo.getPermissionUrl() : "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getIntroductionInfoUrl() {
        UMNNativeMaterial.DownloadAppinfo downloadAppinfo = getAdResponse() != null ? getAdResponse().getDownloadAppinfo() : null;
        return downloadAppinfo != null ? downloadAppinfo.getFunctionUrl() : "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAppPrivacyUrl() {
        UMNNativeMaterial.DownloadAppinfo downloadAppinfo = getAdResponse() != null ? getAdResponse().getDownloadAppinfo() : null;
        return downloadAppinfo != null ? downloadAppinfo.getPrivacyAgreementUrl() : "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAppName() {
        UMNNativeMaterial.DownloadAppinfo downloadAppinfo = getAdResponse() != null ? getAdResponse().getDownloadAppinfo() : null;
        return downloadAppinfo != null ? downloadAppinfo.getAppName() : "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAppVersion() {
        UMNNativeMaterial.DownloadAppinfo downloadAppinfo = getAdResponse() != null ? getAdResponse().getDownloadAppinfo() : null;
        return downloadAppinfo != null ? downloadAppinfo.getAppVersionName() : "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public void setVideoPlayListener(final YFNativeAd.VideoPlayListener videoPlayListener) {
        if (videoPlayListener == null) {
            return;
        }
        this.nativeAdBean.setNativeMediaListener(new UMNNativeMediaListener() { // from class: com.yfanads.ads.chanel.in.model.INNativeAds.1
            @Override // com.ubixnow.adtype.nativead.api.UMNNativeMediaListener
            public void onVideoStart() {
                videoPlayListener.onVideoPlayStart();
            }

            @Override // com.ubixnow.adtype.nativead.api.UMNNativeMediaListener
            public void onVideoEnd() {
                videoPlayListener.onVideoPlayComplete();
            }

            @Override // com.ubixnow.adtype.nativead.api.UMNNativeMediaListener
            public void onVideoError() {
                videoPlayListener.onVideoPlayError(9901, -1);
            }
        });
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public View getVideoView(Context context, YFAdVideoPlayConfig yFAdVideoPlayConfig) {
        if (getAdResponse() == null) {
            return null;
        }
        FrameLayout frameLayout = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        frameLayout.setLayoutParams(layoutParams);
        return getAdResponse().getAdMediaView(frameLayout);
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getVideoWidth() {
        if (getAdResponse() != null) {
            return getAdResponse().getVideoWidth();
        }
        return 0;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getVideoHeight() {
        if (getAdResponse() != null) {
            return getAdResponse().getVideoHeight();
        }
        return 0;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getActionDescription() {
        return getAdResponse() != null ? getAdResponse().getActionDescription() : "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getMaterialType() {
        return (getAdResponse() != null && getAdResponse().getAdType().equals("1")) ? 1 : 2;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getInteractionType() {
        return (getAdResponse() == null || getAdResponse().getNativeAdInteractionType() != 1 || getAdResponse().getDownloadAppinfo() == null) ? 0 : 1;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getECPM() {
        if (this.nativeExpressAd.getEcpmInfo() == null || TextUtils.isEmpty(this.nativeExpressAd.getEcpmInfo().getEcpm())) {
            return 0;
        }
        return YFUtil.toInt(this.nativeExpressAd.getEcpmInfo().getEcpm(), 0);
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public void registerViewForInteraction(Activity activity, ViewGroup viewGroup, Map<View, Integer> map, final YFNativeAd.AdInteractionListener adInteractionListener) {
        YFLog.high("INNativeAds registerViewForInteraction " + hashCode() + "|size:" + (map != null ? map.size() : 0));
        if (YFListUtils.isMapEmpty(map)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        View view = null;
        for (View view2 : map.keySet()) {
            Integer num = map.get(view2);
            YFLog.debug("INNativeAds registerViewForInteraction view:" + view2 + "|" + num);
            if (num != null) {
                int iIntValue = num.intValue();
                if (iIntValue == 0 || iIntValue == 1) {
                    arrayList.add(view2);
                } else if (iIntValue == 2) {
                    view = view2;
                } else if (iIntValue == 3) {
                    onFeedBack(activity.getFragmentManager(), view2);
                }
            }
        }
        this.nativeAdBean.setNativeEventListener(new UMNNativeEventListener() { // from class: com.yfanads.ads.chanel.in.model.INNativeAds.2
            @Override // com.ubixnow.adtype.nativead.api.UMNNativeEventListener
            public void onAdExposure() {
                YFLog.debug("in native onAdShow");
                INNativeAds.this.handleExposure(adInteractionListener);
            }

            @Override // com.ubixnow.adtype.nativead.api.UMNNativeEventListener
            public void onAdClicked() {
                YFLog.debug("in native onAdClicked");
                INNativeAds.this.handleClick(adInteractionListener);
            }

            @Override // com.ubixnow.adtype.nativead.api.UMNNativeEventListener
            public void onAdClose() {
                YFLog.debug("in native onAdDismiss");
                if (INNativeAds.this.nativeAdContainer != null) {
                    INNativeAds.this.nativeAdContainer.removeAllViews();
                }
                INNativeAds.this.handleClose(adInteractionListener);
            }
        });
        UMNNativeExtraInfo uMNNativeExtraInfo = new UMNNativeExtraInfo();
        uMNNativeExtraInfo.setClickViewList(arrayList);
        uMNNativeExtraInfo.setCloseView(view);
        this.nativeAdBean.register(this.nativeAdContainer, uMNNativeExtraInfo);
    }

    @Override // com.yfanads.android.core.render.api.BaseKSAd
    public void onDestroy() {
        UMNNativeAdBean uMNNativeAdBean = this.nativeAdBean;
        if (uMNNativeAdBean != null) {
            uMNNativeAdBean.destory();
            this.nativeAdBean = null;
        }
        UMNNativeAd uMNNativeAd = this.nativeExpressAd;
        if (uMNNativeAd != null) {
            uMNNativeAd.destroy();
            this.nativeExpressAd = null;
        }
    }

    @Override // com.yfanads.android.core.render.impl.YFAbsNativeAd, com.yfanads.android.core.render.api.YFNativeAd
    public void renderAdContainer(YFNativeAdView yFNativeAdView, View view) {
        if (yFNativeAdView == null || view == null) {
            return;
        }
        yFNativeAdView.removeAllViews();
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        if (this.nativeAdContainer.getParent() != null) {
            ((ViewGroup) this.nativeAdContainer.getParent()).removeView(this.nativeAdContainer);
        }
        this.nativeAdBean.renderView(this.nativeAdContainer, view);
        yFNativeAdView.addView(this.nativeAdContainer);
    }
}
