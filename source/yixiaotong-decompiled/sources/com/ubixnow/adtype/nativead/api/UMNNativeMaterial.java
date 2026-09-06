package com.ubixnow.adtype.nativead.api;

import android.view.View;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface UMNNativeMaterial {

    public interface DownloadAppinfo {
        String getAppName();

        String getAppPublisher();

        long getAppSize();

        String getAppVersionName();

        String getFunctionUrl();

        String getPermissionUrl();

        String getPrivacyAgreementUrl();
    }

    @Deprecated
    DownloadAppinfo downloadAppinfo();

    String getActionDescription();

    String getAdFrom();

    View getAdMediaView(Object... objArr);

    String getAdSource();

    String getAdType();

    UMNCustomVideoCallBack getCustomVideo();

    String getDescriptionText();

    DownloadAppinfo getDownloadAppinfo();

    String getIconImageUrl();

    List<String> getImageUrlList();

    int getMainImageHeight();

    String getMainImageUrl();

    int getMainImageWidth();

    int getNativeAdInteractionType();

    Map<String, Object> getNetworkInfoMap();

    String getTitle();

    int getVideoDuration();

    int getVideoHeight();

    String getVideoUrl();

    int getVideoWidth();

    boolean isShakeAd();
}
