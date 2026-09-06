package com.adprof.sdk.api;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public interface NativeAdData extends IBiddingNotify {

    public interface NativeAdMediaListener {
        void onVideoCompleted();

        void onVideoError(AdError adError);

        void onVideoLoad();

        void onVideoPause();

        void onVideoResume();

        void onVideoStart();
    }

    void bindMediaView(ViewGroup viewGroup, NativeAdMediaListener nativeAdMediaListener);

    void bindViewForInteraction(View view, List<View> list, NativeAdEventListener nativeAdEventListener);

    void destroy();

    AdAppInfo getAdAppInfo();

    int getAdInteractiveType();

    Bitmap getAdLogoBitmap();

    Drawable getAdLogoDrawable();

    int getAdPatternType();

    int getBidPrice();

    String getCTAText();

    String getDesc();

    View getFeedView();

    String getIconUrl();

    List<AFImage> getImageList();

    View getMediaView(Context context);

    String getTitle();

    double getVideoDuration();

    int getVideoHeight();

    int getVideoWidth();

    View getWidgetView(int i, int i2);

    boolean isExpressAd();

    void pauseVideo();

    void resumeVideo();

    void setMediaListener(NativeAdMediaListener nativeAdMediaListener);

    void setNativeAdEventListener(NativeAdEventListener nativeAdEventListener);

    void setNativeAdMediaListener(NativeAdMediaListener nativeAdMediaListener);

    void setVideoMute(boolean z);

    void showCloseView(boolean z);

    void startVideo();

    void stopVideo();
}
