package com.yfanads.ads.chanel.ry.model;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.hihonor.adsdk.base.api.AdVideo;
import com.hihonor.adsdk.base.api.feed.PictureTextExpressAd;
import com.hihonor.adsdk.base.callback.AdListener;
import com.hihonor.adsdk.common.video.AdVideoSize;
import com.hihonor.adsdk.common.video.OnVideoPlayListener;
import com.hihonor.adsdk.picturetextad.PictureTextAdRootView;
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
public class RYNativeAds extends YFAbsNativeAd {
    AdVideo adVideo;
    Context context;
    boolean isMuted;
    PictureTextExpressAd nativeAd;
    private final PictureTextAdRootView nativeAdContainer;
    View videoView;

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getAdSourceLogo() {
        return 0;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public void setBidEcpm(long j) {
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public void setDownloadListener(YFAppDownloadListener yFAppDownloadListener) {
    }

    public RYNativeAds(Context context, PictureTextExpressAd pictureTextExpressAd, YFNativeCall yFNativeCall) {
        super(yFNativeCall);
        this.context = context;
        this.nativeAd = pictureTextExpressAd;
        this.nativeAdContainer = new PictureTextAdRootView(context);
        if (pictureTextExpressAd == null || pictureTextExpressAd.getAdVideo() == null) {
            return;
        }
        AdVideo adVideo = pictureTextExpressAd.getAdVideo();
        this.adVideo = adVideo;
        this.videoView = adVideo.getVideoView();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAdDescription() {
        return this.nativeAd.getTitle();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAdTitle() {
        return this.nativeAd.getTitle();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getBrandName() {
        return this.nativeAd.getBrand();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public List<String> getImageList() {
        return this.nativeAd.getImages();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAppName() {
        return this.nativeAd.getBrand();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAppIconUrl() {
        return this.nativeAd.getLogo();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getCorporationName() {
        return this.nativeAd.getDeveloperName();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getPermissionInfoUrl() {
        return this.nativeAd.getPermissionsUrl();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getIntroductionInfoUrl() {
        return this.nativeAd.getIntroUrl();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAppPrivacyUrl() {
        return this.nativeAd.getPrivacyAgreementUrl();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAppVersion() {
        return this.nativeAd.getAppVersion();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public void setVideoPlayListener(YFNativeAd.VideoPlayListener videoPlayListener) {
        if (this.nativeAd == null || this.adVideo == null) {
            return;
        }
        setVideoAdListener(videoPlayListener);
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public View getVideoView(Context context, YFAdVideoPlayConfig yFAdVideoPlayConfig) {
        this.isMuted = !yFAdVideoPlayConfig.isVideoSoundEnable();
        if (this.videoView != null) {
            AdVideo adVideo = this.adVideo;
            if (adVideo != null) {
                adVideo.setMuted(!yFAdVideoPlayConfig.isVideoSoundEnable());
            }
            return this.videoView;
        }
        AdVideo adVideo2 = this.adVideo;
        if (adVideo2 == null) {
            return null;
        }
        adVideo2.setMuted(!yFAdVideoPlayConfig.isVideoSoundEnable());
        return this.adVideo.getVideoView();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getVideoCoverImage() {
        return this.nativeAd.getCoverUrl() != null ? this.nativeAd.getCoverUrl() : "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getVideoWidth() {
        return this.nativeAd.getVideoWidth();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getVideoHeight() {
        return this.nativeAd.getVideoHeight();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getActionDescription() {
        return this.nativeAd.getButtonText();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getMaterialType() {
        return this.nativeAd.hasVideo() ? 1 : 2;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getInteractionType() {
        return this.nativeAd.getPromotionPurpose() == 0 ? 1 : 0;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getECPM() {
        return YFUtil.toInt(this.nativeAd.getEcpm() + "", 0);
    }

    public void sendWinNotification(long j) {
        try {
            this.nativeAd.sendWinNotification(j);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendLossNotification(long j, int i, String str) {
        try {
            this.nativeAd.sendLossNotification(j, i, str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public void registerViewForInteraction(Activity activity, ViewGroup viewGroup, Map<View, Integer> map, YFNativeAd.AdInteractionListener adInteractionListener) {
        YFLog.high("RYNativeAds registerViewForInteraction " + hashCode() + "|size:" + (map != null ? map.size() : 0));
        if (YFListUtils.isMapEmpty(map)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (View view : map.keySet()) {
            Integer num = map.get(view);
            YFLog.debug("RYNativeAds registerViewForInteraction view:" + view + "|" + num);
            if (num != null) {
                int iIntValue = num.intValue();
                if (iIntValue == 0) {
                    arrayList.add(view);
                } else if (iIntValue == 1) {
                    arrayList2.add(view);
                } else if (iIntValue == 2) {
                    handleClose(view, adInteractionListener);
                } else if (iIntValue == 3) {
                    onFeedBack(activity.getFragmentManager(), view);
                }
            }
        }
        registerRYViewForInteraction(arrayList, adInteractionListener);
    }

    private void registerRYViewForInteraction(List<View> list, final YFNativeAd.AdInteractionListener adInteractionListener) {
        this.nativeAd.setAdListener(new AdListener() { // from class: com.yfanads.ads.chanel.ry.model.RYNativeAds.1
            @Override // com.hihonor.adsdk.base.callback.AdListener
            public void onAdClosed() {
                super.onAdClosed();
                RYNativeAds.this.handleClose(adInteractionListener);
            }

            @Override // com.hihonor.adsdk.base.callback.AdListener
            public void onAdSkip(int i) {
                super.onAdSkip(i);
                RYNativeAds.this.handleClose(adInteractionListener);
            }

            @Override // com.hihonor.adsdk.base.callback.AdListener
            public void onAdClicked() {
                super.onAdClicked();
                RYNativeAds.this.handleClick(adInteractionListener);
            }

            @Override // com.hihonor.adsdk.base.callback.AdListener
            public void onAdImpression() {
                super.onAdImpression();
                RYNativeAds.this.handleExposure(adInteractionListener);
            }

            @Override // com.hihonor.adsdk.base.callback.AdListener
            public void onAdImpressionFailed(int i, String str) {
                super.onAdImpressionFailed(i, str);
            }

            @Override // com.hihonor.adsdk.base.callback.AdListener
            public void onMiniAppStarted() {
                super.onMiniAppStarted();
            }
        });
        this.nativeAdContainer.setAd(this.nativeAd);
        this.nativeAdContainer.registerViewForInteraction(list);
    }

    private void setVideoAdListener(final YFNativeAd.VideoPlayListener videoPlayListener) {
        this.adVideo.setVideoListener(new OnVideoPlayListener() { // from class: com.yfanads.ads.chanel.ry.model.RYNativeAds.2
            @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
            public void onProgressUpdate(long j, long j2, long j3) {
            }

            @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
            public void onVideoPrepare() {
                YFLog.debug("onVideoPrepare isMuted: " + RYNativeAds.this.isMuted);
                RYNativeAds.this.adVideo.setMuted(RYNativeAds.this.isMuted);
            }

            @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
            public void onVideoStart() {
                YFLog.debug("onVideoStart: ");
                YFNativeAd.VideoPlayListener videoPlayListener2 = videoPlayListener;
                if (videoPlayListener2 != null) {
                    videoPlayListener2.onVideoPlayStart();
                }
            }

            @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
            public void onVideoPause() {
                YFLog.debug("onVideoPause: ");
                YFNativeAd.VideoPlayListener videoPlayListener2 = videoPlayListener;
                if (videoPlayListener2 != null) {
                    videoPlayListener2.onVideoPlayPause();
                }
            }

            @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
            public void onVideoBuffering(boolean z) {
                YFLog.debug("onVideoBuffering: ");
            }

            @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
            public void onVideoResume() {
                YFLog.debug("onVideoResume: ");
                YFNativeAd.VideoPlayListener videoPlayListener2 = videoPlayListener;
                if (videoPlayListener2 != null) {
                    videoPlayListener2.onVideoPlayResume();
                }
            }

            @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
            public void onVideoEnd() {
                YFLog.debug("onVideoEnd: ");
                videoPlayListener.onVideoPlayComplete();
            }

            @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
            public void onVideoError(int i, String str) {
                YFLog.debug("onVideoError: " + i + "," + str);
                YFNativeAd.VideoPlayListener videoPlayListener2 = videoPlayListener;
                if (videoPlayListener2 != null) {
                    videoPlayListener2.onVideoPlayError(i, -1);
                }
            }

            @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
            public void onVideoMute(boolean z) {
                YFLog.debug("onVideoMute: " + z);
            }

            @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
            public void onVideoSizeChange(AdVideoSize adVideoSize) {
                YFLog.debug("onVideoSizeChange: " + adVideoSize.getWidth() + "," + adVideoSize.getHeight());
            }

            @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
            public void onVideoPrepared() {
                YFLog.debug("onVideoPrepared: ");
            }
        });
    }

    @Override // com.yfanads.android.core.render.api.BaseKSAd
    public void onDestroy() {
        PictureTextExpressAd pictureTextExpressAd = this.nativeAd;
        if (pictureTextExpressAd != null) {
            pictureTextExpressAd.release();
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
