package com.ubixnow.network.csj;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.ComplianceInfo;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationViewBinder;
import com.stub.StubApp;
import com.ubixnow.adtype.nativead.api.UMNNativeMaterial;
import com.ubixnow.adtype.nativead.api.UMNNativeParams;
import com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd;
import com.ubixnow.core.api.UMNImageInfo;
import com.ubixnow.core.bean.UMNNativeExtraInfo;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.oo000o;
import com.ubixnow.ooooo.ooooO000;
import com.ubixnow.utils.BaseUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class CsjNativeAd extends UMNCustomNativeAd {
    private final String OooO00o = "-----CsjNativeAd";
    public AdSlot OooO0O0;
    public TTAdNative OooO0OO;
    public TTFeedAd OooO0Oo;
    public Activity OooO0o;
    private WeakReference<Context> OooO0o0;

    public CsjNativeAd(Context context, UMNNativeParams uMNNativeParams, String str, oo000o oo000oVar) {
        this.OooO0o0 = new WeakReference<>(context);
        if (!uMNNativeParams.cacheAd && (context instanceof Activity)) {
            this.OooO0o = (Activity) context;
        }
        this.configInfo = oo000oVar;
        int i = uMNNativeParams.width;
        i = i <= 0 ? -1 : i;
        int i2 = uMNNativeParams.height;
        i2 = i2 <= 0 ? -2 : i2;
        if (i <= 0 || i2 <= 0) {
            i = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK;
            i2 = MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME;
        }
        this.OooO0OO = TTAdSdk.getAdManager().createAdNative(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        this.OooO0O0 = new AdSlot.Builder().setCodeId(str).setAdCount(1).setImageAcceptedSize(i, i2).build();
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00oOoo
    public void destroy() {
        showLog(this.OooO00o, "destroy");
        TTFeedAd tTFeedAd = this.OooO0Oo;
        if (tTFeedAd != null) {
            tTFeedAd.destroy();
        }
        this.OooO0o0.clear();
        this.OooO0o = null;
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public View getAdMediaView(Object... objArr) {
        try {
            return this.OooO0Oo.getAdView();
        } catch (Exception e) {
            ooooO000.OooO00o(e);
            return null;
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd
    public View getShakeView(View view) {
        return getNativeShakeView(BaseUtils.getContext());
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public boolean isNativeExpress() {
        return false;
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd
    public boolean isValid() {
        TTFeedAd tTFeedAd = this.OooO0Oo;
        if (tTFeedAd == null || tTFeedAd.getMediationManager() == null) {
            return false;
        }
        return this.OooO0Oo.getMediationManager().isReady();
    }

    public void loadAd(String str, final oo000o oo000oVar, final o00O00o0 o00o00o0) {
        this.loadListener = o00o00o0;
        this.OooO0OO.loadFeedAd(this.OooO0O0, new TTAdNative.FeedAdListener() { // from class: com.ubixnow.network.csj.CsjNativeAd.1
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener, com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onError(int i, String str2) {
                CsjNativeAd csjNativeAd = CsjNativeAd.this;
                csjNativeAd.showLog(csjNativeAd.OooO00o, " onError " + str2);
                o00O00o0 o00o00o1 = o00o00o0;
                if (o00o00o1 != null) {
                    o00o00o1.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, i + "", str2).setInfo((Object) oo000oVar));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
            public void onFeedAdLoad(List<TTFeedAd> list) {
                if (list != null) {
                    try {
                        if (list.size() > 0) {
                            CsjNativeAd.this.OooO0Oo = list.get(0);
                            try {
                                if (oo000oVar.getBaseAdConfig().OooO00o.OooOO0O == 1) {
                                    oo000oVar.csjPriceMethod = "1";
                                    int integerValue = CsjNativeAd.this.getIntegerValue(list.get(0).getMediationManager().getBestEcpm().getEcpm());
                                    CsjNativeAd csjNativeAd = CsjNativeAd.this;
                                    csjNativeAd.showLog(csjNativeAd.OooO00o, "price:" + integerValue);
                                    if (integerValue <= 0) {
                                        integerValue = (int) CsjUtils.getBestPriceInCacheNew(CsjNativeAd.this.OooO0Oo, oo000oVar);
                                        CsjNativeAd csjNativeAd2 = CsjNativeAd.this;
                                        csjNativeAd2.showLog(csjNativeAd2.OooO00o, "price1:" + integerValue);
                                    }
                                    oo000oVar.setBiddingEcpm(integerValue);
                                }
                            } catch (Exception e) {
                                ooooO000.OooO00o(e);
                            }
                            CsjNativeAd csjNativeAd3 = CsjNativeAd.this;
                            csjNativeAd3.showLog(csjNativeAd3.OooO00o, "onFeedAdLoad");
                            if (CsjNativeAd.this.OooO0Oo.getMediationManager().isExpress()) {
                                if (CsjNativeAd.this.loadListener != null) {
                                    oo000o oo000oVar2 = oo000oVar;
                                    oo000oVar2.checkMaterialStatus = 10;
                                    CsjNativeAd.this.onAdCacheSuccess(oo000oVar2);
                                    return;
                                }
                                return;
                            }
                            CsjNativeAd csjNativeAd4 = CsjNativeAd.this;
                            csjNativeAd4.setAdData(csjNativeAd4.OooO0Oo);
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(CsjNativeAd.this);
                            oo000o oo000oVar3 = oo000oVar;
                            oo000oVar3.OooO00o = arrayList;
                            CsjNativeAd.this.onAdCacheSuccess(oo000oVar3);
                        }
                    } catch (Exception e2) {
                        ooooO000.OooO00o(e2);
                    }
                }
            }
        });
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public void regist(ViewGroup viewGroup, UMNNativeExtraInfo uMNNativeExtraInfo) {
        Activity activity;
        Context context;
        if (viewGroup == null || viewGroup.getContext() == null || !(viewGroup.getContext() instanceof Activity)) {
            WeakReference<Context> weakReference = this.OooO0o0;
            if (weakReference == null || weakReference.get() == null || !(this.OooO0o0.get() instanceof Activity)) {
                activity = this.OooO0o;
                if (activity == null) {
                    activity = null;
                }
            } else {
                context = this.OooO0o0.get();
            }
            if (this.OooO0Oo != null || uMNNativeExtraInfo.getClickViewList() == null) {
                showLog(this.OooO00o, "getClickViewList 为null");
            }
            this.OooO0Oo.registerViewForInteraction(activity, (ViewGroup) viewGroup.getChildAt(0), uMNNativeExtraInfo.getClickViewList(), uMNNativeExtraInfo.getCreativeClickViewList(), (List<View>) null, new TTNativeAd.AdInteractionListener() { // from class: com.ubixnow.network.csj.CsjNativeAd.3
                @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
                public void onAdClicked(View view, TTNativeAd tTNativeAd) {
                    CsjNativeAd csjNativeAd = CsjNativeAd.this;
                    csjNativeAd.showLog(csjNativeAd.OooO00o, "onAdClicked");
                    CsjNativeAd.this.notifyAdClicked();
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
                public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
                    CsjNativeAd csjNativeAd = CsjNativeAd.this;
                    csjNativeAd.showLog(csjNativeAd.OooO00o, "onAdCreativeClick");
                    CsjNativeAd.this.notifyAdClicked();
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
                public void onAdShow(TTNativeAd tTNativeAd) {
                    CsjNativeAd csjNativeAd = CsjNativeAd.this;
                    csjNativeAd.showLog(csjNativeAd.OooO00o, "onAdShow");
                    TTFeedAd tTFeedAd = CsjNativeAd.this.OooO0Oo;
                    if (tTFeedAd != null && tTFeedAd.getMediationManager() != null && CsjNativeAd.this.OooO0Oo.getMediationManager().getShowEcpm() != null) {
                        CsjNativeAd csjNativeAd2 = CsjNativeAd.this;
                        csjNativeAd2.showLog(csjNativeAd2.OooO00o, "show price:" + CsjNativeAd.this.OooO0Oo.getMediationManager().getShowEcpm().getEcpm());
                    }
                    CsjNativeAd.this.notifyAdExposure();
                }
            }, new MediationViewBinder.Builder(1).build());
            this.OooO0Oo.setVideoAdListener(new TTFeedAd.VideoAdListener() { // from class: com.ubixnow.network.csj.CsjNativeAd.4
                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onProgressUpdate(long j, long j2) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onVideoAdComplete(TTFeedAd tTFeedAd) {
                    CsjNativeAd csjNativeAd = CsjNativeAd.this;
                    csjNativeAd.showLog(csjNativeAd.OooO00o, "onVideoAdComplete");
                    CsjNativeAd.this.notifyAdVideoEnd();
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onVideoAdContinuePlay(TTFeedAd tTFeedAd) {
                    CsjNativeAd csjNativeAd = CsjNativeAd.this;
                    csjNativeAd.showLog(csjNativeAd.OooO00o, "onVideoAdContinuePlay");
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onVideoAdPaused(TTFeedAd tTFeedAd) {
                    CsjNativeAd csjNativeAd = CsjNativeAd.this;
                    csjNativeAd.showLog(csjNativeAd.OooO00o, "onVideoAdPaused");
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onVideoAdStartPlay(TTFeedAd tTFeedAd) {
                    CsjNativeAd csjNativeAd = CsjNativeAd.this;
                    csjNativeAd.showLog(csjNativeAd.OooO00o, "onVideoAdStartPlay");
                    CsjNativeAd.this.notifyAdVideoStart();
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onVideoError(int i, int i2) {
                    CsjNativeAd csjNativeAd = CsjNativeAd.this;
                    csjNativeAd.showLog(csjNativeAd.OooO00o, "onVideoError");
                    CsjNativeAd.this.notifyAdVideoError();
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onVideoLoad(TTFeedAd tTFeedAd) {
                    CsjNativeAd csjNativeAd = CsjNativeAd.this;
                    csjNativeAd.showLog(csjNativeAd.OooO00o, "onVideoLoad");
                }
            });
            this.OooO0Oo.setDislikeCallback(activity, new TTAdDislike.DislikeInteractionCallback() { // from class: com.ubixnow.network.csj.CsjNativeAd.5
                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onCancel() {
                    CsjNativeAd csjNativeAd = CsjNativeAd.this;
                    csjNativeAd.showLog(csjNativeAd.OooO00o, "onCancel");
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onSelected(int i, String str, boolean z) {
                    CsjNativeAd csjNativeAd = CsjNativeAd.this;
                    csjNativeAd.showLog(csjNativeAd.OooO00o, "onDislikeClicked");
                    CsjNativeAd.this.notifyAdDislikeClick();
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onShow() {
                    CsjNativeAd csjNativeAd = CsjNativeAd.this;
                    csjNativeAd.showLog(csjNativeAd.OooO00o, "onShow");
                }
            });
            this.OooO0Oo.setDownloadListener(new TTAppDownloadListener() { // from class: com.ubixnow.network.csj.CsjNativeAd.6
                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadActive(long j, long j2, String str, String str2) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadFailed(long j, long j2, String str, String str2) {
                    CsjNativeAd csjNativeAd = CsjNativeAd.this;
                    csjNativeAd.showLog(csjNativeAd.OooO00o, "onDownloadFailed");
                    CsjNativeAd.this.apkDownloadFailed();
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadFinished(long j, String str, String str2) {
                    CsjNativeAd csjNativeAd = CsjNativeAd.this;
                    csjNativeAd.showLog(csjNativeAd.OooO00o, "onDownloadFinished");
                    CsjNativeAd.this.apkDownloadFinished();
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadPaused(long j, long j2, String str, String str2) {
                    CsjNativeAd csjNativeAd = CsjNativeAd.this;
                    csjNativeAd.showLog(csjNativeAd.OooO00o, "onDownloadPaused");
                    CsjNativeAd.this.apkDownloadPaused(0);
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onIdle() {
                    CsjNativeAd csjNativeAd = CsjNativeAd.this;
                    csjNativeAd.showLog(csjNativeAd.OooO00o, "onIdle");
                    CsjNativeAd.this.apkDownloadIdle();
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onInstalled(String str, String str2) {
                    CsjNativeAd csjNativeAd = CsjNativeAd.this;
                    csjNativeAd.showLog(csjNativeAd.OooO00o, "onInstalled");
                    CsjNativeAd.this.apkInstall();
                }
            });
            return;
        }
        context = viewGroup.getContext();
        activity = (Activity) context;
        if (this.OooO0Oo != null) {
        }
        showLog(this.OooO00o, "getClickViewList 为null");
    }

    public void setAdData(TTFeedAd tTFeedAd) {
        setUserName((tTFeedAd.getComplianceInfo() == null || TextUtils.isEmpty(tTFeedAd.getComplianceInfo().getAppName())) ? tTFeedAd.getSource() : tTFeedAd.getComplianceInfo().getAppName());
        setTitle(tTFeedAd.getTitle());
        setAdSource("穿山甲广告");
        setDescriptionText(tTFeedAd.getDescription());
        List<TTImage> imageList = tTFeedAd.getImageList();
        ArrayList arrayList = new ArrayList();
        if (imageList != null && !imageList.isEmpty()) {
            for (TTImage tTImage : imageList) {
                arrayList.add(new UMNImageInfo(tTImage.getImageUrl(), tTImage.getWidth(), tTImage.getHeight()));
            }
            setMainImageUrl(imageList.get(0).getImageUrl());
            setMainImgHeight(imageList.get(0).getHeight());
            setMainImgWidth(imageList.get(0).getWidth());
        }
        setImageInfoList(arrayList);
        setIconImageUrl(tTFeedAd.getIcon().getImageUrl());
        this.mAdSourceType = (tTFeedAd.getImageMode() == 5 || tTFeedAd.getImageMode() == 15) ? "1" : "2";
        setAdType(this.mAdSourceType);
        if (tTFeedAd.getInteractionType() == 4) {
            setNativeInteractionType(1);
        }
        if (tTFeedAd.getCustomVideo() != null) {
            setVideoUrl(tTFeedAd.getCustomVideo().getVideoUrl());
        }
        setButtonText(tTFeedAd.getButtonText());
        if (tTFeedAd.getVideoCoverImage() != null) {
            setVideoCoverUrl(tTFeedAd.getVideoCoverImage().getImageUrl());
        }
        setVideoDuration(((int) tTFeedAd.getVideoDuration()) * 1000);
        if (tTFeedAd.getComplianceInfo() != null) {
            final ComplianceInfo complianceInfo = tTFeedAd.getComplianceInfo();
            this.downloadAppinfo = new UMNNativeMaterial.DownloadAppinfo() { // from class: com.ubixnow.network.csj.CsjNativeAd.2
                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                public String getAppName() {
                    return complianceInfo.getAppName();
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                public String getAppPublisher() {
                    return complianceInfo.getDeveloperName();
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                public long getAppSize() {
                    return 0L;
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                public String getAppVersionName() {
                    return complianceInfo.getAppVersion();
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                public String getFunctionUrl() {
                    try {
                        String functionDescUrl = complianceInfo.getFunctionDescUrl();
                        return functionDescUrl == null ? "" : functionDescUrl;
                    } catch (Exception unused) {
                        return "";
                    }
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                public String getPermissionUrl() {
                    try {
                        return complianceInfo.getPermissionUrl();
                    } catch (Throwable unused) {
                        return "";
                    }
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                public String getPrivacyAgreementUrl() {
                    return complianceInfo.getPrivacyUrl();
                }
            };
        }
    }
}
