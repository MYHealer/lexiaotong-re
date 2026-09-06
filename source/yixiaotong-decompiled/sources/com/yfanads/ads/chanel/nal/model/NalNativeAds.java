package com.yfanads.ads.chanel.nal.model;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.adprof.sdk.api.AFImage;
import com.adprof.sdk.api.AdAppInfo;
import com.adprof.sdk.api.AdError;
import com.adprof.sdk.api.NativeAd;
import com.adprof.sdk.api.NativeAdAllEventListener;
import com.adprof.sdk.api.NativeAdData;
import com.yfanads.ads.chanel.nal.R;
import com.yfanads.android.core.render.YFNativeAdView;
import com.yfanads.android.core.render.api.YFAdVideoPlayConfig;
import com.yfanads.android.core.render.api.YFAppDownloadListener;
import com.yfanads.android.core.render.api.YFNativeAd;
import com.yfanads.android.core.render.api.YFNativeCall;
import com.yfanads.android.core.render.impl.YFAbsNativeAd;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class NalNativeAds extends YFAbsNativeAd {
    private final FrameLayout adVideoContainer;
    private NativeAdData nativeAdBean;
    private NativeAd nativeExpressAd;

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getBrandName() {
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

    public NalNativeAds(Context context, NativeAd nativeAd, NativeAdData nativeAdData, YFNativeCall yFNativeCall) {
        super(yFNativeCall, 0);
        this.nativeExpressAd = nativeAd;
        this.nativeAdBean = nativeAdData;
        FrameLayout frameLayout = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        frameLayout.setLayoutParams(layoutParams);
        this.adVideoContainer = frameLayout;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAdDescription() {
        NativeAdData nativeAdData = this.nativeAdBean;
        return nativeAdData != null ? nativeAdData.getDesc() : "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAdTitle() {
        NativeAdData nativeAdData = this.nativeAdBean;
        return nativeAdData != null ? nativeAdData.getTitle() : "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getAdSourceLogo() {
        return R.mipmap.ad_logo_nal_v1;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public List<String> getImageList() {
        NativeAdData nativeAdData = this.nativeAdBean;
        if (nativeAdData != null && !YFListUtils.isEmpty(nativeAdData.getImageList())) {
            ArrayList arrayList = new ArrayList();
            Iterator<AFImage> it = this.nativeAdBean.getImageList().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().imageUrl);
            }
            return arrayList;
        }
        return new ArrayList();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAppIconUrl() {
        NativeAdData nativeAdData = this.nativeAdBean;
        return nativeAdData != null ? nativeAdData.getIconUrl() : "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getCorporationName() {
        AdAppInfo adAppInfo = this.nativeAdBean.getAdAppInfo();
        if (adAppInfo == null) {
            return "";
        }
        adAppInfo.getDeveloper();
        return "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getPermissionInfoUrl() {
        AdAppInfo adAppInfo = this.nativeAdBean.getAdAppInfo();
        if (adAppInfo == null) {
            return "";
        }
        adAppInfo.getPermissionsUrl();
        return "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getIntroductionInfoUrl() {
        AdAppInfo adAppInfo = this.nativeAdBean.getAdAppInfo();
        if (adAppInfo == null) {
            return "";
        }
        adAppInfo.getAppDescriptionUrl();
        return "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAppPrivacyUrl() {
        AdAppInfo adAppInfo = this.nativeAdBean.getAdAppInfo();
        if (adAppInfo == null) {
            return "";
        }
        adAppInfo.getPrivacyUrl();
        return "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAppName() {
        AdAppInfo adAppInfo = this.nativeAdBean.getAdAppInfo();
        return adAppInfo != null ? adAppInfo.getAppName() : "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAppVersion() {
        AdAppInfo adAppInfo = this.nativeAdBean.getAdAppInfo();
        return adAppInfo != null ? String.valueOf(adAppInfo.getVersionName()) : "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public void setVideoPlayListener(final YFNativeAd.VideoPlayListener videoPlayListener) {
        if (videoPlayListener == null) {
            return;
        }
        this.nativeAdBean.setNativeAdMediaListener(new NativeAdData.NativeAdMediaListener() { // from class: com.yfanads.ads.chanel.nal.model.NalNativeAds.1
            @Override // com.adprof.sdk.api.NativeAdData.NativeAdMediaListener
            public void onVideoLoad() {
            }

            @Override // com.adprof.sdk.api.NativeAdData.NativeAdMediaListener
            public void onVideoError(AdError adError) {
                videoPlayListener.onVideoPlayError(9901, -1);
            }

            @Override // com.adprof.sdk.api.NativeAdData.NativeAdMediaListener
            public void onVideoStart() {
                videoPlayListener.onVideoPlayStart();
            }

            @Override // com.adprof.sdk.api.NativeAdData.NativeAdMediaListener
            public void onVideoPause() {
                videoPlayListener.onVideoPlayPause();
            }

            @Override // com.adprof.sdk.api.NativeAdData.NativeAdMediaListener
            public void onVideoResume() {
                videoPlayListener.onVideoPlayResume();
            }

            @Override // com.adprof.sdk.api.NativeAdData.NativeAdMediaListener
            public void onVideoCompleted() {
                videoPlayListener.onVideoPlayComplete();
            }
        });
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getVideoCoverImage() {
        NativeAdData nativeAdData = this.nativeAdBean;
        return (nativeAdData == null || YFListUtils.isEmpty(nativeAdData.getImageList())) ? "" : this.nativeAdBean.getImageList().get(0).imageUrl;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getVideoWidth() {
        NativeAdData nativeAdData = this.nativeAdBean;
        if (nativeAdData != null) {
            return nativeAdData.getVideoWidth();
        }
        return 0;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getVideoHeight() {
        NativeAdData nativeAdData = this.nativeAdBean;
        if (nativeAdData != null) {
            return nativeAdData.getVideoHeight();
        }
        return 0;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getActionDescription() {
        NativeAdData nativeAdData = this.nativeAdBean;
        return nativeAdData != null ? nativeAdData.getCTAText() : "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getMaterialType() {
        NativeAdData nativeAdData = this.nativeAdBean;
        return (nativeAdData != null && nativeAdData.getAdPatternType() == 2) ? 1 : 2;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getInteractionType() {
        NativeAdData nativeAdData = this.nativeAdBean;
        return (nativeAdData != null && nativeAdData.getAdInteractiveType() == 3) ? 1 : 0;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getECPM() {
        NativeAd nativeAd = this.nativeExpressAd;
        if (nativeAd != null) {
            return nativeAd.getBidPrice();
        }
        return 0;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public void registerViewForInteraction(Activity activity, ViewGroup viewGroup, Map<View, Integer> map, YFNativeAd.AdInteractionListener adInteractionListener) {
        YFLog.high("NalNativeAds registerViewForInteraction " + hashCode() + "|size:" + (map != null ? map.size() : 0));
        if (YFListUtils.isMapEmpty(map)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        View view = null;
        for (View view2 : map.keySet()) {
            Integer num = map.get(view2);
            YFLog.debug("NalNativeAds registerViewForInteraction view:" + view2 + "|" + num);
            if (num != null) {
                int iIntValue = num.intValue();
                if (iIntValue == 0 || iIntValue == 1) {
                    arrayList.add(view2);
                } else if (iIntValue == 2) {
                    handleClose(view2, adInteractionListener);
                    view = view2;
                } else if (iIntValue == 3) {
                    onFeedBack(activity.getFragmentManager(), view2);
                }
            }
        }
        registerViewForInteraction(viewGroup, arrayList, view, adInteractionListener);
    }

    private void registerViewForInteraction(ViewGroup viewGroup, List<View> list, View view, final YFNativeAd.AdInteractionListener adInteractionListener) {
        this.nativeAdBean.showCloseView(false);
        this.nativeAdBean.bindViewForInteraction(viewGroup, list, new NativeAdAllEventListener() { // from class: com.yfanads.ads.chanel.nal.model.NalNativeAds.2
            @Override // com.adprof.sdk.api.NativeAdAllEventListener
            public void onAdClose(View view2) {
                YFLog.debug("nal native onAdClose");
                NalNativeAds.this.handleClose(adInteractionListener);
            }

            @Override // com.adprof.sdk.api.NativeAdEventListener
            public void onAdExposed() {
                YFLog.debug("nal native onAdExposed");
                NalNativeAds.this.handleExposure(adInteractionListener);
            }

            @Override // com.adprof.sdk.api.NativeAdEventListener
            public void onAdClicked() {
                YFLog.debug("nal native onAdClicked");
                NalNativeAds.this.handleClick(adInteractionListener);
            }

            @Override // com.adprof.sdk.api.NativeAdEventListener
            public void onAdRenderFail(AdError adError) {
                YFLog.debug("xu native onAdRenderFail");
            }
        });
        if (getMaterialType() == 1) {
            this.nativeAdBean.bindMediaView(this.adVideoContainer, new NativeAdData.NativeAdMediaListener() { // from class: com.yfanads.ads.chanel.nal.model.NalNativeAds.3
                @Override // com.adprof.sdk.api.NativeAdData.NativeAdMediaListener
                public void onVideoCompleted() {
                }

                @Override // com.adprof.sdk.api.NativeAdData.NativeAdMediaListener
                public void onVideoError(AdError adError) {
                }

                @Override // com.adprof.sdk.api.NativeAdData.NativeAdMediaListener
                public void onVideoLoad() {
                }

                @Override // com.adprof.sdk.api.NativeAdData.NativeAdMediaListener
                public void onVideoPause() {
                }

                @Override // com.adprof.sdk.api.NativeAdData.NativeAdMediaListener
                public void onVideoResume() {
                }

                @Override // com.adprof.sdk.api.NativeAdData.NativeAdMediaListener
                public void onVideoStart() {
                }
            });
        }
    }

    @Override // com.yfanads.android.core.render.api.BaseKSAd
    public void onDestroy() {
        NativeAdData nativeAdData = this.nativeAdBean;
        if (nativeAdData != null) {
            nativeAdData.destroy();
            this.nativeAdBean = null;
        }
        NativeAd nativeAd = this.nativeExpressAd;
        if (nativeAd != null) {
            nativeAd.destroyAd();
            this.nativeExpressAd = null;
        }
    }
}
