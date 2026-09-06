package com.yfanads.android.core.render.api;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.yfanads.android.core.render.YFNativeAdView;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface YFNativeAd extends BaseKSAd {

    public interface AdInteractionListener {
        void onAdClicked(YFNativeAd yFNativeAd);

        void onAdClose(YFNativeAd yFNativeAd);

        void onAdShow(YFNativeAd yFNativeAd);
    }

    public interface VideoPlayListener {
        void onVideoPlayComplete();

        void onVideoPlayError(int i, int i2);

        void onVideoPlayPause();

        void onVideoPlayResume();

        void onVideoPlayStart();
    }

    String getActionDescription();

    String getAdDescription();

    int getAdSourceLogo();

    String getAdTitle();

    String getAppIconUrl();

    String getAppName();

    String getAppPrivacyUrl();

    String getAppVersion();

    String getBrandName();

    String getCorporationName();

    int getECPM();

    List<String> getImageList();

    int getInteractionType();

    String getIntroductionInfoUrl();

    int getMaterialType();

    String getPermissionInfoUrl();

    String getVideoCoverImage();

    int getVideoHeight();

    View getVideoView(Context context, YFAdVideoPlayConfig yFAdVideoPlayConfig);

    int getVideoWidth();

    void registerViewForInteraction(Activity activity, ViewGroup viewGroup, Map<View, Integer> map, AdInteractionListener adInteractionListener);

    void renderAdContainer(YFNativeAdView yFNativeAdView, View view);

    void setBidEcpm(long j);

    void setDownloadListener(YFAppDownloadListener yFAppDownloadListener);

    void setVideoPlayListener(VideoPlayListener videoPlayListener);
}
