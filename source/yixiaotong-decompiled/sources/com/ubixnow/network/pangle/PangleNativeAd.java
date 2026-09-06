package com.ubixnow.network.pangle;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.ComplianceInfo;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.cdo.oaps.ad.OapsKey;
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
public class PangleNativeAd extends UMNCustomNativeAd {
    private final String OooO00o = "-----PangleNativeAd";
    public AdSlot OooO0O0;
    public TTAdNative OooO0OO;
    public TTFeedAd OooO0Oo;
    public Activity OooO0o;
    private final WeakReference<Context> OooO0o0;

    public PangleNativeAd(Context context, UMNNativeParams uMNNativeParams, String str, oo000o oo000oVar) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void OooO00o(oo000o oo000oVar, TTFeedAd tTFeedAd) {
        try {
            if (oo000oVar.getBaseAdConfig().OooO00o.OooOO0O == 1) {
                Object obj = tTFeedAd.getMediaExtraInfo().get(OapsKey.KEY_PRICE);
                int iIntValue = obj instanceof Number ? ((Number) obj).intValue() : 0;
                showLog(this.OooO00o, "price:" + iIntValue);
                oo000oVar.setBiddingEcpm(iIntValue);
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00oOoo
    public void destroy() {
        showLog(this.OooO00o, "destroy");
        TTFeedAd tTFeedAd = this.OooO0Oo;
        if (tTFeedAd != null) {
            tTFeedAd.destroy();
            this.OooO0Oo.setVideoAdListener(null);
        }
        try {
            TTFeedAd tTFeedAd2 = this.OooO0Oo;
            if (tTFeedAd2 != null) {
                tTFeedAd2.setActivityForDownloadApp(null);
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
        this.OooO0Oo = null;
        this.OooO0o = null;
        WeakReference<Context> weakReference = this.OooO0o0;
        if (weakReference != null) {
            weakReference.clear();
        }
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
        return super.isNativeExpress();
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd
    public boolean isValid() {
        return this.OooO0Oo != null;
    }

    public void loadAd(String str, final oo000o oo000oVar, final o00O00o0 o00o00o0) {
        this.loadListener = o00o00o0;
        this.OooO0OO.loadFeedAd(this.OooO0O0, new TTAdNative.FeedAdListener() { // from class: com.ubixnow.network.pangle.PangleNativeAd.1
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener, com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onError(int i, String str2) {
                PangleNativeAd pangleNativeAd = PangleNativeAd.this;
                pangleNativeAd.showLog(pangleNativeAd.OooO00o, " onError " + str2);
                o00O00o0 o00o00o1 = o00o00o0;
                if (o00o00o1 != null) {
                    o00o00o1.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, i + "", str2).setInfo((Object) oo000oVar));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
            public void onFeedAdLoad(List<TTFeedAd> list) {
                try {
                    PangleNativeAd pangleNativeAd = PangleNativeAd.this;
                    pangleNativeAd.showLog(pangleNativeAd.OooO00o, "onFeedAdLoad");
                    if (list == null || list.isEmpty()) {
                        return;
                    }
                    PangleNativeAd.this.OooO0Oo = list.get(0);
                    PangleNativeAd pangleNativeAd2 = PangleNativeAd.this;
                    pangleNativeAd2.OooO00o(oo000oVar, pangleNativeAd2.OooO0Oo);
                    PangleNativeAd pangleNativeAd3 = PangleNativeAd.this;
                    pangleNativeAd3.setAdData(pangleNativeAd3.OooO0Oo);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(PangleNativeAd.this);
                    oo000o oo000oVar2 = oo000oVar;
                    oo000oVar2.OooO00o = arrayList;
                    PangleNativeAd.this.onAdCacheSuccess(oo000oVar2);
                } catch (Exception e) {
                    ooooO000.OooO00o(e);
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
            if (activity != null) {
                this.OooO0Oo.setActivityForDownloadApp(activity);
            }
            this.OooO0Oo.registerViewForInteraction((ViewGroup) viewGroup.getChildAt(0), uMNNativeExtraInfo.getClickViewList(), uMNNativeExtraInfo.getClickViewList(), uMNNativeExtraInfo.getCreativeClickViewList(), new ArrayList(), uMNNativeExtraInfo.getCloseView(), new TTNativeAd.AdInteractionListener() { // from class: com.ubixnow.network.pangle.PangleNativeAd.3
                @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
                public void onAdClicked(View view, TTNativeAd tTNativeAd) {
                    PangleNativeAd pangleNativeAd = PangleNativeAd.this;
                    pangleNativeAd.showLog(pangleNativeAd.OooO00o, "onAdClicked");
                    PangleNativeAd.this.notifyAdClicked();
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
                public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
                    PangleNativeAd pangleNativeAd = PangleNativeAd.this;
                    pangleNativeAd.showLog(pangleNativeAd.OooO00o, "onAdCreativeClick");
                    PangleNativeAd.this.notifyAdClicked();
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
                public void onAdShow(TTNativeAd tTNativeAd) {
                    PangleNativeAd pangleNativeAd = PangleNativeAd.this;
                    pangleNativeAd.showLog(pangleNativeAd.OooO00o, "onAdShow");
                    PangleNativeAd.this.notifyAdExposure();
                }
            });
            this.OooO0Oo.setVideoAdListener(new TTFeedAd.VideoAdListener() { // from class: com.ubixnow.network.pangle.PangleNativeAd.4
                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onProgressUpdate(long j, long j2) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onVideoAdComplete(TTFeedAd tTFeedAd) {
                    PangleNativeAd pangleNativeAd = PangleNativeAd.this;
                    pangleNativeAd.showLog(pangleNativeAd.OooO00o, "onVideoAdComplete");
                    PangleNativeAd.this.notifyAdVideoEnd();
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onVideoAdContinuePlay(TTFeedAd tTFeedAd) {
                    PangleNativeAd pangleNativeAd = PangleNativeAd.this;
                    pangleNativeAd.showLog(pangleNativeAd.OooO00o, "onVideoAdContinuePlay");
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onVideoAdPaused(TTFeedAd tTFeedAd) {
                    PangleNativeAd pangleNativeAd = PangleNativeAd.this;
                    pangleNativeAd.showLog(pangleNativeAd.OooO00o, "onVideoAdPaused");
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onVideoAdStartPlay(TTFeedAd tTFeedAd) {
                    PangleNativeAd pangleNativeAd = PangleNativeAd.this;
                    pangleNativeAd.showLog(pangleNativeAd.OooO00o, "onVideoAdStartPlay");
                    PangleNativeAd.this.notifyAdVideoStart();
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onVideoError(int i, int i2) {
                    PangleNativeAd pangleNativeAd = PangleNativeAd.this;
                    pangleNativeAd.showLog(pangleNativeAd.OooO00o, "onVideoError");
                    PangleNativeAd.this.notifyAdVideoError();
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public void onVideoLoad(TTFeedAd tTFeedAd) {
                    PangleNativeAd pangleNativeAd = PangleNativeAd.this;
                    pangleNativeAd.showLog(pangleNativeAd.OooO00o, "onVideoLoad");
                }
            });
            this.OooO0Oo.setDownloadListener(new TTAppDownloadListener() { // from class: com.ubixnow.network.pangle.PangleNativeAd.5
                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadActive(long j, long j2, String str, String str2) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadFailed(long j, long j2, String str, String str2) {
                    PangleNativeAd pangleNativeAd = PangleNativeAd.this;
                    pangleNativeAd.showLog(pangleNativeAd.OooO00o, "onDownloadFailed");
                    PangleNativeAd.this.apkDownloadFailed();
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadFinished(long j, String str, String str2) {
                    PangleNativeAd pangleNativeAd = PangleNativeAd.this;
                    pangleNativeAd.showLog(pangleNativeAd.OooO00o, "onDownloadFinished");
                    PangleNativeAd.this.apkDownloadFinished();
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadPaused(long j, long j2, String str, String str2) {
                    PangleNativeAd pangleNativeAd = PangleNativeAd.this;
                    pangleNativeAd.showLog(pangleNativeAd.OooO00o, "onDownloadPaused");
                    PangleNativeAd.this.apkDownloadPaused(0);
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onIdle() {
                    PangleNativeAd pangleNativeAd = PangleNativeAd.this;
                    pangleNativeAd.showLog(pangleNativeAd.OooO00o, "onIdle");
                    PangleNativeAd.this.apkDownloadIdle();
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onInstalled(String str, String str2) {
                    PangleNativeAd pangleNativeAd = PangleNativeAd.this;
                    pangleNativeAd.showLog(pangleNativeAd.OooO00o, "onInstalled");
                    PangleNativeAd.this.apkInstall();
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

    public void setAdData(final TTFeedAd tTFeedAd) {
        if (tTFeedAd == null) {
            return;
        }
        setUserName((tTFeedAd.getComplianceInfo() == null || TextUtils.isEmpty(tTFeedAd.getComplianceInfo().getAppName())) ? tTFeedAd.getSource() : tTFeedAd.getComplianceInfo().getAppName());
        setTitle(tTFeedAd.getTitle());
        setAdSource("穿山甲广告");
        setAdFrom(tTFeedAd.getSource());
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
        if (tTFeedAd.getVideoCoverImage() != null) {
            setVideoCoverUrl(tTFeedAd.getVideoCoverImage().getImageUrl());
        }
        setImageInfoList(arrayList);
        TTImage icon = tTFeedAd.getIcon();
        if (icon != null) {
            setIconImageUrl(icon.getImageUrl());
        }
        this.mAdSourceType = (tTFeedAd.getImageMode() == 5 || tTFeedAd.getImageMode() == 15) ? "1" : (tTFeedAd.getImageMode() == 3 || tTFeedAd.getImageMode() == 2 || tTFeedAd.getImageMode() == 4 || tTFeedAd.getImageMode() == 16) ? "2" : "0";
        setAdType(this.mAdSourceType);
        if (tTFeedAd.getInteractionType() == 4) {
            setNativeInteractionType(1);
        }
        if (tTFeedAd.getCustomVideo() != null) {
            setVideoUrl(tTFeedAd.getCustomVideo().getVideoUrl());
        }
        setButtonText(tTFeedAd.getButtonText());
        setVideoDuration(((int) tTFeedAd.getVideoDuration()) * 1000);
        final ComplianceInfo complianceInfo = tTFeedAd.getComplianceInfo();
        if (complianceInfo != null) {
            this.downloadAppinfo = new UMNNativeMaterial.DownloadAppinfo() { // from class: com.ubixnow.network.pangle.PangleNativeAd.2
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
                    return tTFeedAd.getAppSize();
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
