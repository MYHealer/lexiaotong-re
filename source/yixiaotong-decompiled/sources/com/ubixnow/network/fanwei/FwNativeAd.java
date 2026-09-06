package com.ubixnow.network.fanwei;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.ptg.adsdk.lib.PtgAdSdk;
import com.ptg.adsdk.lib.interf.NativeAdvertData;
import com.ptg.adsdk.lib.interf.PtgAppDownloadListener;
import com.ptg.adsdk.lib.interf.PtgNativeExpressAd;
import com.ptg.adsdk.lib.interf.PtgVideoAdListener;
import com.ptg.adsdk.lib.model.AdError;
import com.ptg.adsdk.lib.model.AdSlot;
import com.ptg.adsdk.lib.model.AppInfo;
import com.ptg.adsdk.lib.model.PtgImageInfo;
import com.ptg.adsdk.lib.provider.PtgAdNative;
import com.ubixnow.adtype.nativead.api.UMNNativeMaterial;
import com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd;
import com.ubixnow.core.api.UMNImageInfo;
import com.ubixnow.core.bean.UMNNativeExtraInfo;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.oo000o;
import com.ubixnow.ooooo.ooooO000;
import com.ubixnow.utils.BaseUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class FwNativeAd extends UMNCustomNativeAd {
    private static final String OooO00o = "----FwNativeAd";
    private AdSlot OooO0O0;
    private PtgNativeExpressAd OooO0OO;
    private NativeAdvertData OooO0Oo;

    public FwNativeAd(String str, oo000o oo000oVar) {
        String str2;
        boolean z;
        AdSlot.Builder builder = new AdSlot.Builder();
        this.configInfo = oo000oVar;
        if (oo000oVar.getBaseAdConfig().OooOOO0 != null) {
            z = oo000oVar.getBaseAdConfig().OooOOO0.Oooo0OO;
            str2 = oo000oVar.getBaseAdConfig().OooOOO0.Oooo0;
        } else {
            str2 = "";
            z = true;
        }
        if ("3".equals(str2)) {
            builder.setIsAutoPlay(false);
        } else {
            builder.setIsAutoPlay(true);
        }
        builder.setPlayMuted(z);
        this.OooO0O0 = builder.setPtgSlotId(str).setSelfRender(true).build();
    }

    private boolean OooO0O0() {
        PtgNativeExpressAd ptgNativeExpressAd = this.OooO0OO;
        if (ptgNativeExpressAd != null) {
            return ptgNativeExpressAd.isVideo();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OooO0OO() {
        setUserName((this.OooO0Oo.getApp() == null || TextUtils.isEmpty(this.OooO0Oo.getApp().getName())) ? this.OooO0Oo.getBrand() : this.OooO0Oo.getApp().getName());
        setLandingPageUrl(this.OooO0Oo.getLandUrl());
        setTitle(this.OooO0Oo.getTitle());
        setCreativeId(this.OooO0Oo.getAid() + "");
        setAdSource("Fancy广告");
        setDescriptionText(this.OooO0Oo.getDesc());
        setButtonText(this.OooO0Oo.getButtonText());
        List<PtgImageInfo> imageList = this.OooO0Oo.getImageList();
        ArrayList arrayList = new ArrayList();
        if (imageList != null && !imageList.isEmpty()) {
            for (PtgImageInfo ptgImageInfo : imageList) {
                arrayList.add(new UMNImageInfo(ptgImageInfo.getImageUrl(), ptgImageInfo.getWidth(), ptgImageInfo.getHeight()));
            }
            setMainImageUrl(((UMNImageInfo) arrayList.get(0)).url);
        }
        setVideoUrl(this.OooO0Oo.getVideoUrl());
        setVideoCoverUrl(this.OooO0Oo.getVideoCover());
        setVideoDuration((int) (this.OooO0Oo.getDuration() * 1000));
        setVideoHeight(this.OooO0Oo.getHeight());
        setVideoWidth(this.OooO0Oo.getWidth());
        if (this.OooO0OO.getCustomizeVideo() != null) {
            setVideoUrl(this.OooO0OO.getCustomizeVideo().getVideoUrl());
            setVideoCoverUrl(this.OooO0OO.getCustomizeVideo().getCoverUrl());
        }
        setImageInfoList(arrayList);
        setAdType(this.OooO0Oo.getType() == 2 ? "1" : this.OooO0Oo.getType() == 1 ? "2" : "0");
        if (this.OooO0Oo.getAction() != 0) {
            if (this.OooO0Oo.getAction() == 1) {
                setNativeInteractionType(2);
                return;
            } else {
                setNativeInteractionType(0);
                return;
            }
        }
        setNativeInteractionType(1);
        final AppInfo app = this.OooO0Oo.getApp();
        if (app != null) {
            this.downloadAppinfo = new UMNNativeMaterial.DownloadAppinfo() { // from class: com.ubixnow.network.fanwei.FwNativeAd.2
                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                public String getAppName() {
                    return app.getName();
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                public String getAppPublisher() {
                    return app.getDevelopers();
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                public long getAppSize() {
                    return 0L;
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                public String getAppVersionName() {
                    return app.getAppVersion();
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                public String getFunctionUrl() {
                    return app.getFunctionDescUrl();
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                public String getPermissionUrl() {
                    return app.getPermissionProtocolUrl();
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                public String getPrivacyAgreementUrl() {
                    return app.getPrivacyProtocolUrl();
                }
            };
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00oOoo
    public void destroy() {
        super.destroy();
        PtgNativeExpressAd ptgNativeExpressAd = this.OooO0OO;
        if (ptgNativeExpressAd != null) {
            ptgNativeExpressAd.destroy();
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public View getAdMediaView(Object... objArr) {
        try {
            return this.OooO0OO.getMediaView();
        } catch (Exception e) {
            ooooO000.OooO00o(e);
            return null;
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public boolean isNativeExpress() {
        super.isNativeExpress();
        return false;
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd
    public boolean isValid() {
        try {
            PtgNativeExpressAd ptgNativeExpressAd = this.OooO0OO;
            return ptgNativeExpressAd != null && ptgNativeExpressAd.isReady();
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
            return super.isValid();
        }
    }

    public void loadAd(String str, final oo000o oo000oVar, final o00O00o0 o00o00o0) {
        this.loadListener = o00o00o0;
        PtgAdSdk.get().loadNativeExpressAd(BaseUtils.getContext(), this.OooO0O0, new PtgAdNative.NativeExpressAdListener() { // from class: com.ubixnow.network.fanwei.FwNativeAd.1
            public void onError(AdError adError) {
                FwNativeAd.this.showLog(FwNativeAd.OooO00o, " onError: code:" + adError.getErrorCode() + " msg:" + adError.getMessage());
                o00O00o0 o00o00o1 = o00o00o0;
                if (o00o00o1 != null) {
                    o00o00o1.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, adError.getErrorCode() + "", adError.getMessage()).setInfo((Object) oo000oVar));
                }
            }

            public void onNativeExpressAdLoad(PtgNativeExpressAd ptgNativeExpressAd) {
                FwNativeAd.this.showLog(FwNativeAd.OooO00o, "onNativeExpressAdLoad");
                FwNativeAd.this.OooO0OO = ptgNativeExpressAd;
                FwNativeAd fwNativeAd = FwNativeAd.this;
                fwNativeAd.OooO0Oo = fwNativeAd.OooO0OO.getAdvertData();
                FwNativeAd.this.OooO0OO();
                if (oo000oVar.getBaseAdConfig().OooO00o.OooOO0O == 1 && ptgNativeExpressAd.getAdvertData() != null) {
                    try {
                        oo000oVar.setBiddingEcpm((int) ptgNativeExpressAd.getEcpm());
                        FwNativeAd.this.showLog(FwNativeAd.OooO00o, "price:" + ptgNativeExpressAd.getEcpm());
                    } catch (Exception e) {
                        ooooO000.OooO00o(e);
                    }
                }
                FwNativeAd.this.setListener();
                ArrayList arrayList = new ArrayList();
                arrayList.add(FwNativeAd.this);
                oo000o oo000oVar2 = oo000oVar;
                oo000oVar2.OooO00o = arrayList;
                FwNativeAd.this.onAdCacheSuccess(oo000oVar2);
            }
        });
    }

    @Override // com.ubixnow.ooooo.o00oOoo
    public void notifyLoss(o00OO0OO o00oo0oo) {
        try {
            PtgNativeExpressAd ptgNativeExpressAd = this.OooO0OO;
            if (ptgNativeExpressAd != null) {
                ptgNativeExpressAd.notifyBidLoss(FwUtils.getFailInfo(o00oo0oo));
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0OO(OooO00o, "竞价回传_notifyLoss:" + FwUtils.getFailInfo(o00oo0oo).getReason());
                }
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00oOoo
    public void notifyWin(o00OO0OO o00oo0oo) {
        try {
            if (this.OooO0OO != null) {
                double[] succMap = FwUtils.getSuccMap(o00oo0oo);
                this.OooO0OO.notifyBidWin(succMap[0], succMap[1]);
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0OO(OooO00o, "竞价回传_notifyWin: costPrice" + succMap[0] + " second price:" + succMap[1]);
                }
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public void pauseVideo() {
        PtgNativeExpressAd ptgNativeExpressAd = this.OooO0OO;
        if (ptgNativeExpressAd != null) {
            ptgNativeExpressAd.pauseVideo();
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public void regist(ViewGroup viewGroup, UMNNativeExtraInfo uMNNativeExtraInfo) {
        PtgNativeExpressAd ptgNativeExpressAd = this.OooO0OO;
        if (ptgNativeExpressAd != null) {
            ptgNativeExpressAd.registerAdvertViews((ViewGroup) viewGroup.getChildAt(0), uMNNativeExtraInfo.getClickViewList(), uMNNativeExtraInfo.getCreativeClickViewList(), uMNNativeExtraInfo.getCloseView());
            this.OooO0OO.render();
        }
    }

    public void setListener() {
        this.OooO0OO.setDownloadListener(new PtgAppDownloadListener() { // from class: com.ubixnow.network.fanwei.FwNativeAd.3
            public void onDownloadActive(long j, long j2, String str) {
                FwNativeAd.this.showLog(FwNativeAd.OooO00o, "onDownloadActive");
            }

            public void onDownloadCancel() {
                FwNativeAd.this.showLog(FwNativeAd.OooO00o, "onDownloadCancel");
            }

            public void onDownloadFailed(String str) {
                FwNativeAd.this.showLog(FwNativeAd.OooO00o, "onDownloadFailed");
                FwNativeAd.this.apkDownloadFailed();
            }

            public void onDownloadFinished(String str) {
                FwNativeAd.this.showLog(FwNativeAd.OooO00o, "onDownloadFinished");
                FwNativeAd.this.apkDownloadFinished();
            }

            public void onDownloadPaused(long j, long j2, String str) {
                FwNativeAd.this.showLog(FwNativeAd.OooO00o, "onDownloadPaused");
                FwNativeAd.this.apkDownloadPaused(0);
            }

            public void onIdle() {
                FwNativeAd.this.showLog(FwNativeAd.OooO00o, "onIdle");
                FwNativeAd.this.apkDownloadIdle();
            }

            public void onInstalled(String str) {
                FwNativeAd.this.showLog(FwNativeAd.OooO00o, "onInstalled");
                FwNativeAd.this.apkInstall();
            }
        });
        this.OooO0OO.setVideoAdListener(new PtgVideoAdListener() { // from class: com.ubixnow.network.fanwei.FwNativeAd.4
            public void onVideoComplete() {
                FwNativeAd.this.showLog(FwNativeAd.OooO00o, "onVideoComplete");
                FwNativeAd.this.notifyAdVideoEnd();
            }

            public void onVideoError(int i, String str) {
                FwNativeAd.this.showLog(FwNativeAd.OooO00o, "onVideoError: code:" + i + " msg:" + str);
                FwNativeAd.this.notifyAdVideoError();
            }

            public void onVideoPause() {
                FwNativeAd.this.showLog(FwNativeAd.OooO00o, "onVideoPause");
            }

            public void onVideoProgressUpdate(long j, long j2) {
                FwNativeAd.this.showLog(FwNativeAd.OooO00o, "onVideoProgressUpdate");
            }

            public void onVideoResume() {
                FwNativeAd.this.showLog(FwNativeAd.OooO00o, "onVideoResume");
            }

            public void onVideoStart() {
                FwNativeAd.this.showLog(FwNativeAd.OooO00o, "onVideoStart");
                FwNativeAd.this.notifyAdVideoStart();
            }
        });
        this.OooO0OO.setExpressInteractionListener(new PtgNativeExpressAd.AdInteractionListener() { // from class: com.ubixnow.network.fanwei.FwNativeAd.5
            public void onAdClicked() {
                FwNativeAd.this.showLog(FwNativeAd.OooO00o, "onAdClicked");
                FwNativeAd.this.notifyAdClicked();
            }

            public void onAdDismiss() {
                FwNativeAd.this.showLog(FwNativeAd.OooO00o, "onAdDismiss");
                FwNativeAd.this.notifyAdDislikeClick();
            }

            public void onAdShow() {
                FwNativeAd.this.showLog(FwNativeAd.OooO00o, "onAdShow");
                FwNativeAd.this.notifyAdExposure();
            }

            public void onRenderFail(AdError adError) {
                FwNativeAd.this.showLog(FwNativeAd.OooO00o, "onRenderFail: code:" + adError.getErrorCode() + " msg:" + adError.getMessage());
            }

            public void onRenderSuccess(View view) {
                FwNativeAd.this.showLog(FwNativeAd.OooO00o, "onRenderSuccess");
            }
        });
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public void startVideo() {
        PtgNativeExpressAd ptgNativeExpressAd = this.OooO0OO;
        if (ptgNativeExpressAd != null) {
            ptgNativeExpressAd.startVideo();
        }
    }
}
