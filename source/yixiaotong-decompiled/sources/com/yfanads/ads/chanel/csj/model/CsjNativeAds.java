package com.yfanads.ads.chanel.csj.model;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.ComplianceInfo;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.cdo.oaps.ad.OapsKey;
import com.yfanads.ads.chanel.csj.R;
import com.yfanads.ads.chanel.csj.utils.CsjUtil;
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
public class CsjNativeAds extends YFAbsNativeAd {
    Context context;
    TTFeedAd nativeAd;

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public void setBidEcpm(long j) {
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public void setDownloadListener(YFAppDownloadListener yFAppDownloadListener) {
    }

    public CsjNativeAds(Context context, TTFeedAd tTFeedAd, YFNativeCall yFNativeCall, int i) {
        super(yFNativeCall, i);
        this.context = context;
        this.nativeAd = tTFeedAd;
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
        return this.nativeAd.getSource();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getAdSourceLogo() {
        return R.mipmap.ad_log_csj_v3;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public List<String> getImageList() {
        List<TTImage> imageList = this.nativeAd.getImageList();
        if (!YFListUtils.isEmpty(imageList)) {
            ArrayList arrayList = new ArrayList(imageList.size());
            for (TTImage tTImage : this.nativeAd.getImageList()) {
                if (tTImage != null && !TextUtils.isEmpty(tTImage.getImageUrl())) {
                    arrayList.add(tTImage.getImageUrl());
                }
            }
            return arrayList;
        }
        return new ArrayList();
    }

    public String getAdReqId() {
        TTFeedAd tTFeedAd = this.nativeAd;
        return tTFeedAd != null ? CsjUtil.getReqId(tTFeedAd.getMediaExtraInfo()) : "";
    }

    public String getMAdReqId() {
        TTFeedAd tTFeedAd = this.nativeAd;
        return tTFeedAd != null ? CsjUtil.getMReqId(tTFeedAd.getMediationManager().getBestEcpm()) : "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAppName() {
        return this.nativeAd.getTitle();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAppIconUrl() {
        TTImage icon = this.nativeAd.getIcon();
        return icon != null ? icon.getImageUrl() : "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getCorporationName() {
        ComplianceInfo complianceInfo = this.nativeAd.getComplianceInfo();
        return complianceInfo != null ? complianceInfo.getDeveloperName() : "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getPermissionInfoUrl() {
        ComplianceInfo complianceInfo = this.nativeAd.getComplianceInfo();
        return complianceInfo != null ? complianceInfo.getPermissionUrl() : "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getIntroductionInfoUrl() {
        ComplianceInfo complianceInfo = this.nativeAd.getComplianceInfo();
        return complianceInfo != null ? complianceInfo.getFunctionDescUrl() : "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAppPrivacyUrl() {
        ComplianceInfo complianceInfo = this.nativeAd.getComplianceInfo();
        return complianceInfo != null ? complianceInfo.getPrivacyUrl() : "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAppVersion() {
        ComplianceInfo complianceInfo = this.nativeAd.getComplianceInfo();
        return complianceInfo != null ? complianceInfo.getAppVersion() : "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public void setVideoPlayListener(final YFNativeAd.VideoPlayListener videoPlayListener) {
        this.nativeAd.setVideoAdListener(new TTFeedAd.VideoAdListener() { // from class: com.yfanads.ads.chanel.csj.model.CsjNativeAds.1
            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onProgressUpdate(long j, long j2) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onVideoLoad(TTFeedAd tTFeedAd) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onVideoError(int i, int i2) {
                YFNativeAd.VideoPlayListener videoPlayListener2 = videoPlayListener;
                if (videoPlayListener2 != null) {
                    videoPlayListener2.onVideoPlayError(i, i2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onVideoAdStartPlay(TTFeedAd tTFeedAd) {
                YFNativeAd.VideoPlayListener videoPlayListener2 = videoPlayListener;
                if (videoPlayListener2 != null) {
                    videoPlayListener2.onVideoPlayStart();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onVideoAdPaused(TTFeedAd tTFeedAd) {
                YFNativeAd.VideoPlayListener videoPlayListener2 = videoPlayListener;
                if (videoPlayListener2 != null) {
                    videoPlayListener2.onVideoPlayPause();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onVideoAdContinuePlay(TTFeedAd tTFeedAd) {
                YFNativeAd.VideoPlayListener videoPlayListener2 = videoPlayListener;
                if (videoPlayListener2 != null) {
                    videoPlayListener2.onVideoPlayResume();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onVideoAdComplete(TTFeedAd tTFeedAd) {
                YFNativeAd.VideoPlayListener videoPlayListener2 = videoPlayListener;
                if (videoPlayListener2 != null) {
                    videoPlayListener2.onVideoPlayComplete();
                }
            }
        });
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public View getVideoView(Context context, YFAdVideoPlayConfig yFAdVideoPlayConfig) {
        return this.nativeAd.getAdView();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getVideoCoverImage() {
        return this.nativeAd.getVideoCoverImage() != null ? this.nativeAd.getVideoCoverImage().getImageUrl() : "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getVideoWidth() {
        return this.nativeAd.getAdViewWidth();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getVideoHeight() {
        return this.nativeAd.getAdViewHeight();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getActionDescription() {
        return this.nativeAd.getButtonText();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getMaterialType() {
        return (this.nativeAd.getImageMode() == 5 || this.nativeAd.getImageMode() == 15) ? 1 : 2;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getInteractionType() {
        return this.nativeAd.getInteractionType() == 4 ? 1 : 0;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getECPM() {
        TTFeedAd tTFeedAd = this.nativeAd;
        if (tTFeedAd == null || tTFeedAd.getMediaExtraInfo() == null) {
            return 0;
        }
        Object obj = this.nativeAd.getMediaExtraInfo().get(OapsKey.KEY_PRICE);
        if (obj == null) {
            obj = "0";
        }
        return YFUtil.toInt(String.valueOf(obj), 0);
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public void registerViewForInteraction(Activity activity, ViewGroup viewGroup, Map<View, Integer> map, YFNativeAd.AdInteractionListener adInteractionListener) {
        YFLog.high("CsjNativeAds registerViewForInteraction " + hashCode() + "|size:" + (map != null ? map.size() : 0));
        if (YFListUtils.isMapEmpty(map)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (View view : map.keySet()) {
            Integer num = map.get(view);
            YFLog.debug("CsjNativeAds registerViewForInteraction view:" + view + "|" + num);
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
        registerCsjViewForInteraction(viewGroup, arrayList, arrayList2, adInteractionListener);
    }

    private void registerCsjViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, final YFNativeAd.AdInteractionListener adInteractionListener) {
        this.nativeAd.registerViewForInteraction(viewGroup, list, list2, null, new TTNativeAd.AdInteractionListener() { // from class: com.yfanads.ads.chanel.csj.model.CsjNativeAds.2
            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            public void onAdClicked(View view, TTNativeAd tTNativeAd) {
                CsjNativeAds.this.handleClick(adInteractionListener);
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
                CsjNativeAds.this.handleClick(adInteractionListener);
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            public void onAdShow(TTNativeAd tTNativeAd) {
                CsjNativeAds.this.handleExposure(adInteractionListener);
            }
        });
    }

    @Override // com.yfanads.android.core.render.api.BaseKSAd
    public void onDestroy() {
        TTFeedAd tTFeedAd = this.nativeAd;
        if (tTFeedAd != null) {
            tTFeedAd.destroy();
        }
    }

    public void loss(double d, String str, String str2) {
        TTFeedAd tTFeedAd = this.nativeAd;
        if (tTFeedAd != null) {
            tTFeedAd.loss(Double.valueOf(d), str, str2);
        }
    }

    public void win(double d) {
        TTFeedAd tTFeedAd = this.nativeAd;
        if (tTFeedAd != null) {
            tTFeedAd.win(Double.valueOf(d));
        }
    }

    public void setPrice(double d) {
        TTFeedAd tTFeedAd = this.nativeAd;
        if (tTFeedAd != null) {
            tTFeedAd.setPrice(Double.valueOf(d));
        }
    }
}
