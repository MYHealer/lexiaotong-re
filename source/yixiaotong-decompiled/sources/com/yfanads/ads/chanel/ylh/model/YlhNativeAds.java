package com.yfanads.ads.chanel.ylh.model;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.util.AdError;
import com.stub.StubApp;
import com.yfanads.ads.chanel.ylh.R;
import com.yfanads.ads.chanel.ylh.utils.YlhUtil;
import com.yfanads.android.core.render.YFNativeAdView;
import com.yfanads.android.core.render.api.YFAdVideoPlayConfig;
import com.yfanads.android.core.render.api.YFAppDownloadListener;
import com.yfanads.android.core.render.api.YFNativeAd;
import com.yfanads.android.core.render.api.YFNativeCall;
import com.yfanads.android.core.render.impl.YFAbsNativeAd;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class YlhNativeAds extends YFAbsNativeAd {
    private Context context;
    private MediaView mediaView;
    private NativeUnifiedADData nativeAd;
    private NativeAdContainer nativeAdContainer;
    VideoOption videoOption;
    private YFNativeAd.VideoPlayListener videoPlayListener;

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getBrandName() {
        return "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getVideoHeight() {
        return 0;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getVideoWidth() {
        return 0;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public void setDownloadListener(YFAppDownloadListener yFAppDownloadListener) {
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public void setVideoPlayListener(YFNativeAd.VideoPlayListener videoPlayListener) {
        this.videoPlayListener = videoPlayListener;
    }

    public YlhNativeAds(Context context, NativeUnifiedADData nativeUnifiedADData, YFNativeCall yFNativeCall, int i) {
        super(yFNativeCall, i);
        this.context = context;
        this.nativeAd = nativeUnifiedADData;
        this.nativeAdContainer = new NativeAdContainer(context);
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAdDescription() {
        return this.nativeAd.getDesc();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAdTitle() {
        return this.nativeAd.getTitle();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getAdSourceLogo() {
        return R.mipmap.ad_log_ylh_v3;
    }

    public String getAdReqId() {
        NativeUnifiedADData nativeUnifiedADData = this.nativeAd;
        return nativeUnifiedADData != null ? YlhUtil.getReqId(nativeUnifiedADData.getExtraInfo()) : "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public List<String> getImageList() {
        NativeUnifiedADData nativeUnifiedADData = this.nativeAd;
        if (nativeUnifiedADData != null && !TextUtils.isEmpty(nativeUnifiedADData.getImgUrl())) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.nativeAd.getImgUrl());
            return arrayList;
        }
        return new ArrayList();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAppIconUrl() {
        return this.nativeAd.getIconUrl();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getCorporationName() {
        NativeUnifiedADAppMiitInfo appMiitInfo = this.nativeAd.getAppMiitInfo();
        if (appMiitInfo == null) {
            return "";
        }
        appMiitInfo.getAuthorName();
        return "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getPermissionInfoUrl() {
        NativeUnifiedADAppMiitInfo appMiitInfo = this.nativeAd.getAppMiitInfo();
        if (appMiitInfo == null) {
            return "";
        }
        appMiitInfo.getPermissionsUrl();
        return "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getIntroductionInfoUrl() {
        NativeUnifiedADAppMiitInfo appMiitInfo = this.nativeAd.getAppMiitInfo();
        if (appMiitInfo == null) {
            return "";
        }
        appMiitInfo.getDescriptionUrl();
        return "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAppPrivacyUrl() {
        NativeUnifiedADAppMiitInfo appMiitInfo = this.nativeAd.getAppMiitInfo();
        if (appMiitInfo == null) {
            return "";
        }
        appMiitInfo.getPrivacyAgreement();
        return "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAppName() {
        NativeUnifiedADAppMiitInfo appMiitInfo = this.nativeAd.getAppMiitInfo();
        if (appMiitInfo == null) {
            return "";
        }
        appMiitInfo.getAppName();
        return "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAppVersion() {
        NativeUnifiedADAppMiitInfo appMiitInfo = this.nativeAd.getAppMiitInfo();
        if (appMiitInfo == null) {
            return "";
        }
        appMiitInfo.getVersionName();
        return "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public View getVideoView(Context context, YFAdVideoPlayConfig yFAdVideoPlayConfig) {
        MediaView mediaView = new MediaView(context);
        this.mediaView = mediaView;
        mediaView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.videoOption = new VideoOption.Builder().setAutoPlayMuted(!yFAdVideoPlayConfig.isVideoSoundEnable()).setAutoPlayPolicy(1).setNeedCoverImage(true).build();
        return this.mediaView;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getVideoCoverImage() {
        return this.nativeAd.getImgUrl();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getActionDescription() {
        return this.nativeAd.getButtonText();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getMaterialType() {
        return this.nativeAd.getAdPatternType() == 2 ? 1 : 2;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getInteractionType() {
        return this.nativeAd.isAppAd() ? 1 : 0;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getECPM() {
        return this.nativeAd.getECPM();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public void setBidEcpm(long j) {
        try {
            this.nativeAd.setBidECPM((int) j);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendWinNotification(Map<String, Object> map) {
        try {
            this.nativeAd.sendWinNotification(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendLossNotification(Map<String, Object> map) {
        try {
            this.nativeAd.sendLossNotification(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public void registerViewForInteraction(Activity activity, ViewGroup viewGroup, Map<View, Integer> map, YFNativeAd.AdInteractionListener adInteractionListener) {
        YFLog.high("YlhNativeAds registerViewForInteraction " + hashCode() + "|size:" + (map != null ? map.size() : 0));
        if (YFListUtils.isMapEmpty(map)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (View view : map.keySet()) {
            Integer num = map.get(view);
            YFLog.debug("YlhNativeAds registerViewForInteraction view:" + view + "|" + num);
            if (num != null) {
                int iIntValue = num.intValue();
                if (iIntValue == 0) {
                    arrayList2.add(view);
                } else if (iIntValue == 1) {
                    arrayList.add(view);
                } else if (iIntValue == 2) {
                    handleClose(view, adInteractionListener);
                } else if (iIntValue == 3) {
                    onFeedBack(activity.getFragmentManager(), view);
                }
            }
        }
        registerYlhViewForInteraction(activity, arrayList2, arrayList, adInteractionListener);
    }

    private void registerYlhViewForInteraction(Activity activity, List<View> list, List<View> list2, final YFNativeAd.AdInteractionListener adInteractionListener) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(1, 1);
        layoutParams.gravity = 53;
        this.nativeAd.bindAdToView(StubApp.getOrigApplicationContext(activity.getApplicationContext()), this.nativeAdContainer, layoutParams, list, list2);
        this.nativeAd.setNativeAdEventListener(new NativeADEventListener() { // from class: com.yfanads.ads.chanel.ylh.model.YlhNativeAds.1
            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADError(AdError adError) {
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADStatusChanged() {
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADExposed() {
                YlhNativeAds.this.handleExposure(adInteractionListener);
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADClicked() {
                YlhNativeAds.this.handleClick(adInteractionListener);
            }
        });
        MediaView mediaView = this.mediaView;
        if (mediaView != null) {
            this.nativeAd.bindMediaView(mediaView, this.videoOption, new NativeADMediaListener() { // from class: com.yfanads.ads.chanel.ylh.model.YlhNativeAds.2
                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoClicked() {
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoInit() {
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoLoaded(int i) {
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoLoading() {
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoReady() {
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoStop() {
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoStart() {
                    if (YlhNativeAds.this.videoPlayListener != null) {
                        YlhNativeAds.this.videoPlayListener.onVideoPlayStart();
                    }
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoPause() {
                    if (YlhNativeAds.this.videoPlayListener != null) {
                        YlhNativeAds.this.videoPlayListener.onVideoPlayPause();
                    }
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoResume() {
                    if (YlhNativeAds.this.videoPlayListener != null) {
                        YlhNativeAds.this.videoPlayListener.onVideoPlayResume();
                    }
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoCompleted() {
                    if (YlhNativeAds.this.videoPlayListener != null) {
                        YlhNativeAds.this.videoPlayListener.onVideoPlayComplete();
                    }
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public void onVideoError(AdError adError) {
                    if (YlhNativeAds.this.videoPlayListener != null) {
                        YlhNativeAds.this.videoPlayListener.onVideoPlayError(adError.getErrorCode(), -1);
                    }
                }
            });
        }
    }

    @Override // com.yfanads.android.core.render.api.BaseKSAd
    public void onDestroy() {
        NativeUnifiedADData nativeUnifiedADData = this.nativeAd;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.destroy();
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
        this.nativeAdContainer.addView(view);
        yFNativeAdView.addView(this.nativeAdContainer);
    }
}
