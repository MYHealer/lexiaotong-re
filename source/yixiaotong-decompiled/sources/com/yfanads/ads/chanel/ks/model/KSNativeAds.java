package com.yfanads.ads.chanel.ks.model;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsApkDownloadListener;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.yfanads.ads.chanel.ks.R;
import com.yfanads.ads.chanel.ks.utils.KSUtil;
import com.yfanads.android.core.render.api.YFAdVideoPlayConfig;
import com.yfanads.android.core.render.api.YFAppDownloadListener;
import com.yfanads.android.core.render.api.YFNativeAd;
import com.yfanads.android.core.render.api.YFNativeCall;
import com.yfanads.android.core.render.impl.YFAbsNativeAd;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class KSNativeAds extends YFAbsNativeAd {
    private final KsNativeAd nativeAd;

    @Override // com.yfanads.android.core.render.api.BaseKSAd
    public void onDestroy() {
    }

    public KSNativeAds(KsNativeAd ksNativeAd, YFNativeCall yFNativeCall, int i) {
        super(yFNativeCall, i);
        this.nativeAd = ksNativeAd;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAdDescription() {
        return this.nativeAd.getAdDescription();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAdTitle() {
        return this.nativeAd.getProductName();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getBrandName() {
        return this.nativeAd.getAdSource();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getAdSourceLogo() {
        return R.mipmap.ad_log_ks_v3;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public List<String> getImageList() {
        List<KsImage> imageList = this.nativeAd.getImageList();
        if (!YFListUtils.isEmpty(imageList)) {
            ArrayList arrayList = new ArrayList(imageList.size());
            for (KsImage ksImage : imageList) {
                if (ksImage != null && !TextUtils.isEmpty(ksImage.getImageUrl()) && ksImage.isValid()) {
                    arrayList.add(ksImage.getImageUrl());
                }
            }
            return arrayList;
        }
        return new ArrayList();
    }

    public String getAdReqId() {
        KsNativeAd ksNativeAd = this.nativeAd;
        return ksNativeAd != null ? KSUtil.getReqId(ksNativeAd.getMediaExtraInfo()) : "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAppIconUrl() {
        return this.nativeAd.getAppIconUrl();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAppName() {
        return this.nativeAd.getAppName();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getCorporationName() {
        return this.nativeAd.getCorporationName();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getPermissionInfoUrl() {
        return this.nativeAd.getPermissionInfoUrl();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getIntroductionInfoUrl() {
        return this.nativeAd.getIntroductionInfoUrl();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAppPrivacyUrl() {
        return this.nativeAd.getAppPrivacyUrl();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAppVersion() {
        return this.nativeAd.getAppVersion();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public void setVideoPlayListener(final YFNativeAd.VideoPlayListener videoPlayListener) {
        this.nativeAd.setVideoPlayListener(new KsNativeAd.VideoPlayListener() { // from class: com.yfanads.ads.chanel.ks.model.KSNativeAds.1
            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayReady() {
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayStart() {
                YFNativeAd.VideoPlayListener videoPlayListener2 = videoPlayListener;
                if (videoPlayListener2 != null) {
                    videoPlayListener2.onVideoPlayStart();
                }
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayComplete() {
                YFNativeAd.VideoPlayListener videoPlayListener2 = videoPlayListener;
                if (videoPlayListener2 != null) {
                    videoPlayListener2.onVideoPlayComplete();
                }
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayError(int i, int i2) {
                YFNativeAd.VideoPlayListener videoPlayListener2 = videoPlayListener;
                if (videoPlayListener2 != null) {
                    videoPlayListener2.onVideoPlayError(i, i2);
                }
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayPause() {
                YFNativeAd.VideoPlayListener videoPlayListener2 = videoPlayListener;
                if (videoPlayListener2 != null) {
                    videoPlayListener2.onVideoPlayPause();
                }
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayResume() {
                YFNativeAd.VideoPlayListener videoPlayListener2 = videoPlayListener;
                if (videoPlayListener2 != null) {
                    videoPlayListener2.onVideoPlayResume();
                }
            }
        });
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public View getVideoView(Context context, YFAdVideoPlayConfig yFAdVideoPlayConfig) {
        return this.nativeAd.getVideoView(context, new KsAdVideoPlayConfig.Builder().videoAutoPlayType(1).videoSoundEnable(yFAdVideoPlayConfig.isVideoSoundEnable()).build());
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getVideoCoverImage() {
        KsImage videoCoverImage = this.nativeAd.getVideoCoverImage();
        if (videoCoverImage != null) {
            return videoCoverImage.getImageUrl();
        }
        return null;
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
        return this.nativeAd.getActionDescription();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getMaterialType() {
        return this.nativeAd.getMaterialType() == 1 ? 1 : 2;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getInteractionType() {
        return this.nativeAd.getInteractionType() == 1 ? 1 : 0;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getECPM() {
        return this.nativeAd.getECPM();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public void setBidEcpm(long j) {
        this.nativeAd.setBidEcpm(j, 0L);
    }

    public void setBidEcpm(long j, long j2) {
        this.nativeAd.setBidEcpm(j, j2);
    }

    public void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        this.nativeAd.reportAdExposureFailed(i, adExposureFailedReason);
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public void registerViewForInteraction(Activity activity, ViewGroup viewGroup, Map<View, Integer> map, YFNativeAd.AdInteractionListener adInteractionListener) {
        YFLog.high("KSNativeAds registerViewForInteraction " + hashCode() + "|size:" + (map != null ? map.size() : 0));
        if (YFListUtils.isMapEmpty(map)) {
            return;
        }
        HashMap map2 = new HashMap();
        for (View view : map.keySet()) {
            Integer num = map.get(view);
            YFLog.debug("KSNativeAds registerViewForInteraction view:" + view + "|" + num);
            if (num != null) {
                int iIntValue = num.intValue();
                if (iIntValue == 0) {
                    map2.put(view, 1);
                } else if (iIntValue == 1) {
                    map2.put(view, 2);
                } else if (iIntValue == 2) {
                    handleClose(view, adInteractionListener);
                } else if (iIntValue == 3) {
                    onFeedBack(activity.getFragmentManager(), view);
                }
            }
        }
        registerKSViewForInteraction(activity, viewGroup, map2, adInteractionListener);
    }

    private void registerKSViewForInteraction(Activity activity, ViewGroup viewGroup, Map<View, Integer> map, final YFNativeAd.AdInteractionListener adInteractionListener) {
        this.nativeAd.registerViewForInteraction(activity, viewGroup, map, new KsNativeAd.AdInteractionListener() { // from class: com.yfanads.ads.chanel.ks.model.KSNativeAds.2
            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                return false;
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onDownloadTipsDialogDismiss() {
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onDownloadTipsDialogShow() {
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onAdClicked(View view, KsNativeAd ksNativeAd) {
                KSNativeAds.this.handleClick(adInteractionListener);
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onAdShow(KsNativeAd ksNativeAd) {
                KSNativeAds.this.handleExposure(adInteractionListener);
            }
        });
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public void setDownloadListener(final YFAppDownloadListener yFAppDownloadListener) {
        this.nativeAd.setDownloadListener(new KsApkDownloadListener() { // from class: com.yfanads.ads.chanel.ks.model.KSNativeAds.3
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
            }

            @Override // com.kwad.sdk.api.KsApkDownloadListener
            public void onPaused(int i) {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadStarted() {
                YFAppDownloadListener yFAppDownloadListener2 = yFAppDownloadListener;
                if (yFAppDownloadListener2 != null) {
                    yFAppDownloadListener2.onDownloadStarted();
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i) {
                YFAppDownloadListener yFAppDownloadListener2 = yFAppDownloadListener;
                if (yFAppDownloadListener2 != null) {
                    yFAppDownloadListener2.onProgressUpdate(i);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                YFAppDownloadListener yFAppDownloadListener2 = yFAppDownloadListener;
                if (yFAppDownloadListener2 != null) {
                    yFAppDownloadListener2.onDownloadFinished();
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                YFAppDownloadListener yFAppDownloadListener2 = yFAppDownloadListener;
                if (yFAppDownloadListener2 != null) {
                    yFAppDownloadListener2.onDownloadFailed();
                }
            }
        });
    }
}
