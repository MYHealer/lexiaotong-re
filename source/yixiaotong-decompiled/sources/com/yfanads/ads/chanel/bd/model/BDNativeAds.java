package com.yfanads.ads.chanel.bd.model;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.BiddingListener;
import com.baidu.mobads.sdk.api.INativeVideoListener;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.XNativeView;
import com.yfanads.ads.chanel.bd.R;
import com.yfanads.ads.chanel.bd.utils.BDUtil;
import com.yfanads.android.core.render.YFNativeAdView;
import com.yfanads.android.core.render.api.YFAdVideoPlayConfig;
import com.yfanads.android.core.render.api.YFAppDownloadListener;
import com.yfanads.android.core.render.api.YFNativeAd;
import com.yfanads.android.core.render.api.YFNativeCall;
import com.yfanads.android.core.render.impl.YFAbsNativeAd;
import com.yfanads.android.model.TemplateConf;
import com.yfanads.android.model.template.BaseTemplateData;
import com.yfanads.android.utils.ScreenUtil;
import com.yfanads.android.utils.YFConfigUtils;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class BDNativeAds extends YFAbsNativeAd {
    private View actionView;
    Context context;
    private final boolean isShakeAction;
    NativeResponse nativeAd;
    private final int size;
    private YFNativeAd.VideoPlayListener videoPlayListener;
    XNativeView xNativeView;

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getActionDescription() {
        return null;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getVideoHeight() {
        return 0;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getVideoWidth() {
        return 0;
    }

    @Override // com.yfanads.android.core.render.api.BaseKSAd
    public void onDestroy() {
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public void setBidEcpm(long j) {
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public void setDownloadListener(YFAppDownloadListener yFAppDownloadListener) {
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public void setVideoPlayListener(YFNativeAd.VideoPlayListener videoPlayListener) {
        this.videoPlayListener = videoPlayListener;
    }

    public BDNativeAds(Context context, NativeResponse nativeResponse, TemplateConf templateConf, YFNativeCall yFNativeCall, int i) {
        super(yFNativeCall, i);
        this.context = context;
        this.nativeAd = nativeResponse;
        this.isShakeAction = templateConf.is == BaseTemplateData.InteractiveStyle.SHAKE.getValue();
        this.size = ScreenUtil.dip2px(context, 80.0f);
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
    public String getBrandName() {
        return this.nativeAd.getBrandName();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getAdSourceLogo() {
        return R.mipmap.ad_log_bd_v3;
    }

    public void biddingSuccess(LinkedHashMap<String, Object> linkedHashMap, BiddingListener biddingListener) {
        this.nativeAd.biddingSuccess(linkedHashMap, biddingListener);
    }

    public void biddingFail(LinkedHashMap<String, Object> linkedHashMap, BiddingListener biddingListener) {
        this.nativeAd.biddingFail(linkedHashMap, biddingListener);
    }

    public String getReqId() {
        NativeResponse nativeResponse = this.nativeAd;
        return nativeResponse != null ? BDUtil.getReqId(nativeResponse.getAdDataForKey("request_id")) : "";
    }

    public String getECPMLevel() {
        return this.nativeAd.getECPMLevel();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public List<String> getImageList() {
        NativeResponse nativeResponse = this.nativeAd;
        if (nativeResponse != null && !TextUtils.isEmpty(nativeResponse.getImageUrl())) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.nativeAd.getImageUrl());
            return arrayList;
        }
        return new ArrayList();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAppName() {
        return this.nativeAd.getTitle();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAppIconUrl() {
        return this.nativeAd.getIconUrl();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getCorporationName() {
        return this.nativeAd.getPublisher();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getPermissionInfoUrl() {
        return this.nativeAd.getAppPermissionLink();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getIntroductionInfoUrl() {
        return this.nativeAd.getAppFunctionLink();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAppPrivacyUrl() {
        return this.nativeAd.getAppPrivacyLink();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAppVersion() {
        return this.nativeAd.getAppVersion();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public View getVideoView(Context context, YFAdVideoPlayConfig yFAdVideoPlayConfig) {
        XNativeView xNativeView = new XNativeView(context);
        this.xNativeView = xNativeView;
        xNativeView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        this.xNativeView.setNativeItem(this.nativeAd);
        this.xNativeView.setUseDownloadFrame(true);
        this.xNativeView.setVideoMute(!yFAdVideoPlayConfig.isVideoSoundEnable());
        return this.xNativeView;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getVideoCoverImage() {
        return this.nativeAd.getImageUrl();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getMaterialType() {
        return this.nativeAd.getMaterialType() == NativeResponse.MaterialType.VIDEO ? 1 : 2;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getInteractionType() {
        return (this.nativeAd.getAdActionType() != 2 || TextUtils.isEmpty(this.nativeAd.getAppVersion()) || TextUtils.isEmpty(this.nativeAd.getPublisher()) || TextUtils.isEmpty(this.nativeAd.getAppPrivacyLink()) || TextUtils.isEmpty(this.nativeAd.getAppPermissionLink())) ? 0 : 1;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getECPM() {
        return YFUtil.toInt(this.nativeAd.getECPMLevel(), 0);
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public void registerViewForInteraction(Activity activity, ViewGroup viewGroup, Map<View, Integer> map, YFNativeAd.AdInteractionListener adInteractionListener) {
        YFLog.debug("BDNativeAds registerViewForInteraction " + hashCode() + "|size:" + (map != null ? map.size() : 0));
        if (YFListUtils.isMapEmpty(map)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (View view : map.keySet()) {
            Integer num = map.get(view);
            YFLog.debug("BDNativeAds registerViewForInteraction view:" + view + "|" + num);
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
        registerBDViewForInteraction(activity, viewGroup, arrayList, arrayList2, adInteractionListener);
    }

    private void registerBDViewForInteraction(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, final YFNativeAd.AdInteractionListener adInteractionListener) {
        View childAt = viewGroup.getChildCount() > 0 ? viewGroup.getChildAt(0) : null;
        boolean booleanValue = YFConfigUtils.getBooleanValue(YFConfigUtils.ConfigType.EXT, "is_shake_action", true);
        if ((childAt instanceof YFNativeAdView) && booleanValue && this.isShakeAction) {
            actionShakeToView(viewGroup);
        }
        this.nativeAd.registerViewForInteraction(viewGroup, list, list2, new NativeResponse.AdInteractionListener() { // from class: com.yfanads.ads.chanel.bd.model.BDNativeAds.1
            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void adActReward(int i) {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void adActRewardSuccess() {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADExposureFailed(int i) {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADStatusChanged() {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onAdUnionClick() {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onAdClick() {
                BDNativeAds.this.handleClick(adInteractionListener);
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADExposed() {
                BDNativeAds.this.handleExposure(adInteractionListener);
            }
        });
        XNativeView xNativeView = this.xNativeView;
        if (xNativeView != null) {
            xNativeView.setNativeVideoListener(new INativeVideoListener() { // from class: com.yfanads.ads.chanel.bd.model.BDNativeAds.2
                @Override // com.baidu.mobads.sdk.api.INativeVideoListener
                public void onRenderingStart() {
                    if (BDNativeAds.this.videoPlayListener != null) {
                        BDNativeAds.this.videoPlayListener.onVideoPlayStart();
                    }
                }

                @Override // com.baidu.mobads.sdk.api.INativeVideoListener
                public void onPause() {
                    if (BDNativeAds.this.videoPlayListener != null) {
                        BDNativeAds.this.videoPlayListener.onVideoPlayPause();
                    }
                }

                @Override // com.baidu.mobads.sdk.api.INativeVideoListener
                public void onResume() {
                    if (BDNativeAds.this.videoPlayListener != null) {
                        BDNativeAds.this.videoPlayListener.onVideoPlayResume();
                    }
                    BDNativeAds.this.xNativeView.render();
                }

                @Override // com.baidu.mobads.sdk.api.INativeVideoListener
                public void onCompletion() {
                    if (BDNativeAds.this.videoPlayListener != null) {
                        BDNativeAds.this.videoPlayListener.onVideoPlayComplete();
                    }
                }

                @Override // com.baidu.mobads.sdk.api.INativeVideoListener
                public void onError() {
                    if (BDNativeAds.this.videoPlayListener != null) {
                        BDNativeAds.this.videoPlayListener.onVideoPlayError(-1, -1);
                    }
                }
            });
            this.xNativeView.render();
        }
    }

    private void actionShakeToView(ViewGroup viewGroup) {
        View shakeView = getShakeView(this.nativeAd);
        this.actionView = shakeView;
        addToView(shakeView, viewGroup);
    }

    private View getShakeView(NativeResponse nativeResponse) {
        return nativeResponse.renderShakeView(80, 80, new NativeResponse.AdShakeViewListener() { // from class: com.yfanads.ads.chanel.bd.model.BDNativeAds$$ExternalSyntheticLambda0
            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdShakeViewListener
            public final void onDismiss() {
                this.f$0.m1077x74289e56();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$getShakeView$0$com-yfanads-ads-chanel-bd-model-BDNativeAds, reason: not valid java name */
    /* synthetic */ void m1077x74289e56() {
        this.actionView.setVisibility(8);
    }

    private void addToView(View view, ViewGroup viewGroup) {
        if (view == null) {
            return;
        }
        int i = this.size;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i);
        layoutParams.gravity = 17;
        view.setLayoutParams(layoutParams);
        viewGroup.addView(view);
    }
}
