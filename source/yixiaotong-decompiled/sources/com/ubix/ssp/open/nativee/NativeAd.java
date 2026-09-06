package com.ubix.ssp.open.nativee;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import com.ubix.ssp.open.UBiXAdLossInfo;
import com.ubix.ssp.open.UBiXDownloadConfirmListener;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface NativeAd {

    public interface CustomReporter {
        void reportAdClick(InteractionType interactionType, View view, HashMap<String, String> map);
    }

    public interface CustomizeVideo {
        public static final int VIDEO_STATUS_PLAY_COMPLETE = 100;
        public static final int VIDEO_STATUS_PLAY_MIDDLE = 50;
        public static final int VIDEO_STATUS_PLAY_ONE_QUARTER = 25;
        public static final int VIDEO_STATUS_PLAY_START = 0;
        public static final int VIDEO_STATUS_PLAY_TERMINAL = 200;
        public static final int VIDEO_STATUS_PLAY_THREE_QUARTER = 75;

        String getCoverUrl();

        String getMaterialId();

        int getVideoHeight();

        String getVideoUrl();

        int getVideoWidth();

        void reportVideoComplete();

        void reportVideoError();

        void reportVideoPause();

        void reportVideoProgress(long j, long j2);

        void reportVideoResume();

        void reportVideoStart();
    }

    public interface ExtraConstant {
        public static final String CUSTOM_CLICK_DOWN_X = "CUSTOM_CLICK_DOWN_X";
        public static final String CUSTOM_CLICK_DOWN_Y = "CUSTOM_CLICK_DOWN_Y";
        public static final String CUSTOM_CLICK_RAW_DOWN_X = "CUSTOM_CLICK_RAW_DOWN_X";
        public static final String CUSTOM_CLICK_RAW_DOWN_Y = "CUSTOM_CLICK_RAW_DOWN_Y";
        public static final String CUSTOM_CLICK_RAW_UP_X = "CUSTOM_CLICK_RAW_UP_X";
        public static final String CUSTOM_CLICK_RAW_UP_Y = "CUSTOM_CLICK_RAW_UP_Y";
        public static final String CUSTOM_CLICK_UP_X = "CUSTOM_CLICK_UP_X";
        public static final String CUSTOM_CLICK_UP_Y = "CUSTOM_CLICK_UP_Y";
    }

    public enum InteractionType {
        INTERACTION_TYPE_CLICK(1),
        INTERACTION_TYPE_SHAKE(3),
        INTERACTION_TYPE_SLIDE(11);

        private final int value;

        InteractionType(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    void destroy();

    String getActionButtonText();

    Drawable getAdLogo();

    String getAdSource();

    long getAppDownloadSize();

    String getAppICPNumber();

    String getAppIcon();

    String getAppIntroduceLink();

    @Deprecated
    String getAppLCPNumber();

    String getAppName();

    String getAppPackageName();

    String getAppPermissionLink();

    String getAppPrivacyLink();

    String getAppPublisher();

    String getAppSuitableAge();

    String getAppVersion();

    String getCreativeId();

    int getCreativeType();

    CustomReporter getCustomReporter();

    CustomizeVideo getCustomizeVideo();

    String getDeeplinkUrl();

    String getDesc();

    int getDownloadAppStatus();

    int getDownloadProgress();

    String getDownloadUrl();

    HashMap<String, Object> getExtraInfo();

    List<UBiXImage> getImageList();

    String getImageUrl();

    String getLandingPageUrl();

    View getMediaView();

    long getPrice();

    String getTitle();

    long getVideoDuration();

    boolean isDownloadAd();

    boolean isShakeAd();

    boolean isSupportCustomShake();

    boolean isValid();

    boolean isVideoAd();

    void lossNotice(UBiXAdLossInfo uBiXAdLossInfo);

    void pauseVideo();

    void registerViews(ViewGroup viewGroup, List<View> list, View view, UBiXNativeInteractionListener uBiXNativeInteractionListener);

    void registerViews(ViewGroup viewGroup, List<View> list, List<View> list2, View view, UBiXNativeInteractionListener uBiXNativeInteractionListener);

    void setAutoPlay(boolean z);

    void setCustomDownloadConfirmListener(UBiXDownloadConfirmListener uBiXDownloadConfirmListener);

    void setDownloadListener(UBiXNativeAdDownloadListener uBiXNativeAdDownloadListener);

    void setVideoListener(UBiXNativeVideoListener uBiXNativeVideoListener);

    void setVideoMute(boolean z);

    void shakeOff();

    void shakeOn();

    void startVideo();

    void winNotice(long j);
}
