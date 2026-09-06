package com.yfanads.ads.chanel.jd.model;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.jd.ad.sdk.dl.addata.JADMaterialData;
import com.jd.ad.sdk.nativead.JADNative;
import com.jd.ad.sdk.nativead.JADNativeInteractionListener;
import com.yfanads.ads.chanel.jd.R;
import com.yfanads.android.adx.newplayer.VideoPlayerImp;
import com.yfanads.android.adx.player.yfplayer.IPlayVideo;
import com.yfanads.android.adx.player.yfplayer.IVideoPlayListener;
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

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class JDNativeAds extends YFAbsNativeAd implements IVideoPlayListener {
    Context context;
    JADNative jdNative;
    YFNativeAd.VideoPlayListener mVideoPlayListener;
    JADMaterialData nativeAd;
    IPlayVideo playVideo;

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAppIconUrl() {
        return "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAppPrivacyUrl() {
        return "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAppVersion() {
        return "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getCorporationName() {
        return "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getECPM() {
        return 0;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getInteractionType() {
        return 0;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getIntroductionInfoUrl() {
        return "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getPermissionInfoUrl() {
        return "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getVideoCoverImage() {
        return "";
    }

    @Override // com.yfanads.android.adx.player.yfplayer.IVideoPlayListener
    public void onAdClicked(View view) {
    }

    @Override // com.yfanads.android.adx.player.yfplayer.IVideoPlayListener
    public void onAdShow() {
    }

    @Override // com.yfanads.android.core.render.api.BaseKSAd
    public void onDestroy() {
    }

    @Override // com.yfanads.android.adx.player.yfplayer.IVideoPlayListener
    public void onVideoProgress(int i) {
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public void setBidEcpm(long j) {
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public void setDownloadListener(YFAppDownloadListener yFAppDownloadListener) {
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public void setVideoPlayListener(YFNativeAd.VideoPlayListener videoPlayListener) {
        this.mVideoPlayListener = videoPlayListener;
    }

    public JDNativeAds(Context context, JADNative jADNative, JADMaterialData jADMaterialData, YFNativeCall yFNativeCall) {
        super(yFNativeCall);
        this.jdNative = jADNative;
        this.context = context;
        this.nativeAd = jADMaterialData;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAdDescription() {
        return this.nativeAd.getDescription();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAdTitle() {
        return this.nativeAd.getTitle();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getBrandName() {
        return this.nativeAd.getResource();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getAdSourceLogo() {
        return R.mipmap.ad_log_jd_v3;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public List<String> getImageList() {
        List<String> imageUrls = this.nativeAd.getImageUrls();
        return !YFListUtils.isEmpty(imageUrls) ? imageUrls : new ArrayList();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAppName() {
        return this.nativeAd.getTitle();
    }

    private String getVideoUrl() {
        JADMaterialData jADMaterialData = this.nativeAd;
        return jADMaterialData != null ? jADMaterialData.getVideoUrl() : "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public View getVideoView(Context context, YFAdVideoPlayConfig yFAdVideoPlayConfig) {
        if (context == null) {
            return null;
        }
        VideoPlayerImp videoPlayerImp = new VideoPlayerImp(context, getVideoUrl(), !yFAdVideoPlayConfig.isVideoSoundEnable(), this);
        this.playVideo = videoPlayerImp;
        return videoPlayerImp.getView();
    }

    public int getCurrentTime() {
        IPlayVideo iPlayVideo = this.playVideo;
        if (iPlayVideo != null) {
            return iPlayVideo.getCurrentTime();
        }
        return 0;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getVideoWidth() {
        return this.nativeAd.getVideoResolutionWidth();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getVideoHeight() {
        return this.nativeAd.getVideoResolutionHeight();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getActionDescription() {
        return this.context.getString(R.string.yf_default_download_text);
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getMaterialType() {
        JADMaterialData jADMaterialData = this.nativeAd;
        return (jADMaterialData == null || TextUtils.isEmpty(jADMaterialData.getVideoUrl())) ? 2 : 1;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public void registerViewForInteraction(Activity activity, ViewGroup viewGroup, Map<View, Integer> map, YFNativeAd.AdInteractionListener adInteractionListener) {
        YFLog.high("JDNativeAds registerViewForInteraction " + hashCode() + "|size:" + (map != null ? map.size() : 0));
        if (YFListUtils.isMapEmpty(map)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (View view : map.keySet()) {
            Integer num = map.get(view);
            YFLog.debug("JDNativeAds registerViewForInteraction view:" + view + "|" + num);
            if (num != null) {
                int iIntValue = num.intValue();
                if (iIntValue == 0 || iIntValue == 1) {
                    arrayList.add(view);
                } else if (iIntValue == 2) {
                    arrayList2.add(view);
                } else if (iIntValue == 3) {
                    onFeedBack(activity.getFragmentManager(), view);
                }
            }
        }
        registerJDViewForInteraction(activity, viewGroup, arrayList, arrayList2, adInteractionListener);
    }

    private void registerJDViewForInteraction(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, final YFNativeAd.AdInteractionListener adInteractionListener) {
        this.jdNative.registerNativeView(activity, viewGroup, list, list2, new JADNativeInteractionListener() { // from class: com.yfanads.ads.chanel.jd.model.JDNativeAds.1
            @Override // com.jd.ad.sdk.nativead.JADNativeInteractionListener
            public void onExposure() {
                JDNativeAds.this.handleExposure(adInteractionListener);
            }

            @Override // com.jd.ad.sdk.nativead.JADNativeInteractionListener
            public void onClick(View view) {
                JDNativeAds.this.handleClick(adInteractionListener);
            }

            @Override // com.jd.ad.sdk.nativead.JADNativeInteractionListener
            public void onClose(View view) {
                JDNativeAds.this.handleClose(adInteractionListener);
            }
        });
    }

    public void onVideoPlayReady() {
        YFNativeAd.VideoPlayListener videoPlayListener = this.mVideoPlayListener;
        if (videoPlayListener == null || !(videoPlayListener instanceof JDVideoPlayListener)) {
            return;
        }
        ((JDVideoPlayListener) videoPlayListener).onVideoPlayReady();
    }

    @Override // com.yfanads.android.adx.player.yfplayer.IVideoPlayListener
    public void onVideoPlayStart() {
        YFNativeAd.VideoPlayListener videoPlayListener = this.mVideoPlayListener;
        if (videoPlayListener != null) {
            videoPlayListener.onVideoPlayStart();
        }
    }

    @Override // com.yfanads.android.adx.player.yfplayer.IVideoPlayListener
    public void onVideoPlayComplete() {
        YFNativeAd.VideoPlayListener videoPlayListener = this.mVideoPlayListener;
        if (videoPlayListener != null) {
            videoPlayListener.onVideoPlayComplete();
        }
    }

    @Override // com.yfanads.android.adx.player.yfplayer.IVideoPlayListener
    public void onVideoPlayError(int i, int i2) {
        YFNativeAd.VideoPlayListener videoPlayListener = this.mVideoPlayListener;
        if (videoPlayListener != null) {
            videoPlayListener.onVideoPlayError(i, i2);
        }
    }

    public void onVideoPlayPause() {
        YFNativeAd.VideoPlayListener videoPlayListener = this.mVideoPlayListener;
        if (videoPlayListener != null) {
            videoPlayListener.onVideoPlayPause();
        }
    }

    public void onVideoPlayResume() {
        YFNativeAd.VideoPlayListener videoPlayListener = this.mVideoPlayListener;
        if (videoPlayListener != null) {
            videoPlayListener.onVideoPlayResume();
        }
    }
}
