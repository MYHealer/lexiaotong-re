package com.hihonor.adsdk.base.api.feed;

import com.hihonor.adsdk.base.api.AdVideo;
import com.hihonor.adsdk.base.api.BaseExpressAd;
import com.hihonor.adsdk.base.api.CustomVideo;
import com.hihonor.adsdk.base.download.OnDownloadStatusChangedListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public interface PictureTextExpressAd extends BaseExpressAd {
    AdDislike getAdDislike();

    AdVideo getAdVideo();

    String getCoverUrl();

    CustomVideo getCustomVideo();

    long getVideoDuration();

    int getVideoHeight();

    int getVideoWidth();

    boolean hasVideo();

    void setDownloadStatusChange(OnDownloadStatusChangedListener onDownloadStatusChangedListener);
}
