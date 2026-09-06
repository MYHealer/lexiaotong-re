package com.ubixnow.network.wangmai;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.ubix.wm.appsdkdex.ads.WMAdNativePot;
import com.ubix.wm.common.Ilistener.IWMAppDownloadListener;
import com.ubix.wm.common.Ilistener.XAdNativePotListener;
import com.ubix.wm.common.bean.WMAdSlot;
import com.ubix.wm.common.nativepot.AdBaseInfo;
import com.ubix.wm.common.nativepot.NativeWMResponse;
import com.ubix.wm.common.nativepot.WMVideoBean;
import com.ubix.wm.common.nativepot.WMVideoControl;
import com.ubix.wm.common.nativepot.WMVideoListener;
import com.ubix.wm.common.nativepot.WMVideoOption;
import com.ubixnow.adtype.nativead.api.UMNNativeMaterial;
import com.ubixnow.adtype.nativead.api.UMNNativeParams;
import com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd;
import com.ubixnow.core.bean.UMNNativeExtraInfo;
import com.ubixnow.core.common.ui.UMNFrameLayout;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.oO;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.oo000o;
import com.ubixnow.ooooo.ooooO000;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class WangMaiNativeAd extends UMNCustomNativeAd {
    private final String OooO00o = "-----WangMaiNativeAd";
    private WMAdNativePot OooO0O0;
    private NativeWMResponse OooO0OO;
    private final String OooO0Oo;
    private String OooO0o;
    private int OooO0o0;
    private boolean OooO0oO;
    public WMVideoControl OooO0oo;

    /* JADX INFO: renamed from: com.ubixnow.network.wangmai.WangMaiNativeAd$5, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass5 {
        public static final /* synthetic */ int[] OooO00o;

        static {
            int[] iArr = new int[AdBaseInfo.MaterialType.values().length];
            OooO00o = iArr;
            try {
                iArr[AdBaseInfo.MaterialType.VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                OooO00o[AdBaseInfo.MaterialType.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                OooO00o[AdBaseInfo.MaterialType.HTML.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public WangMaiNativeAd(Context context, UMNNativeParams uMNNativeParams, String str, oo000o oo000oVar) {
        this.OooO0Oo = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OooO00o(oo000o oo000oVar, NativeWMResponse nativeWMResponse) {
        AdBaseInfo baseInfo = nativeWMResponse.getBaseInfo();
        if (baseInfo == null || baseInfo.getMaterialType() == AdBaseInfo.MaterialType.VIDEO || baseInfo.getMaterialType() == AdBaseInfo.MaterialType.NORMAL) {
            return;
        }
        oo000oVar.checkMaterialStatus = 7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OooO0O0(NativeWMResponse nativeWMResponse) {
        List imageUrls;
        AdBaseInfo baseInfo = nativeWMResponse.getBaseInfo();
        if (baseInfo == null) {
            return;
        }
        if (baseInfo.getDownloadAppInfo() != null) {
            setUserName(baseInfo.getDownloadAppInfo().getAppName());
        }
        setTitle(baseInfo.getTitle());
        setAdSource("旺脉广告");
        setDescriptionText(baseInfo.getDesc());
        ArrayList arrayList = new ArrayList();
        String imageUrl = baseInfo.getImageUrl();
        if (TextUtils.isEmpty(imageUrl) && (imageUrls = baseInfo.getImageUrls()) != null && !imageUrls.isEmpty()) {
            imageUrl = (String) imageUrls.get(0);
        }
        if (baseInfo.getImageUrls() != null) {
            for (String str : baseInfo.getImageUrls()) {
                if (!TextUtils.isEmpty(str)) {
                    arrayList.add(str);
                }
            }
        }
        setMainImageUrl(imageUrl);
        setImageList4Url(arrayList);
        setIconImageUrl(baseInfo.getIconURL());
        int i = AnonymousClass5.OooO00o[baseInfo.getMaterialType().ordinal()];
        this.mAdSourceType = i != 1 ? i != 2 ? "0" : "2" : "1";
        setAdType(this.mAdSourceType);
        if (baseInfo.getInteractionType() == AdBaseInfo.InteractionType.DOWNLOAD) {
            OooO00o(nativeWMResponse);
            setNativeInteractionType(1);
        }
        setVideoHeight(baseInfo.getVideoHeight());
        setMainImgWidth(baseInfo.getPictureWidth());
        setMainImgHeight(baseInfo.getPictureHeight());
        try {
            setVideoUrl(baseInfo.getVideoUrl());
            setVideoWidth(baseInfo.getVideoWidth());
            setCreativeId(baseInfo.getCrid());
        } catch (Throwable unused) {
        }
        final AdBaseInfo.WMDownloadAppInfo downloadAppInfo = baseInfo.getDownloadAppInfo();
        if (downloadAppInfo != null) {
            this.downloadAppinfo = new UMNNativeMaterial.DownloadAppinfo() { // from class: com.ubixnow.network.wangmai.WangMaiNativeAd.2
                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                public String getAppName() {
                    return downloadAppInfo.getAppName();
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                public String getAppPublisher() {
                    return downloadAppInfo.getAppDeveloper();
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                public long getAppSize() {
                    return downloadAppInfo.getAppSize() * 1024;
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                public String getAppVersionName() {
                    return downloadAppInfo.getAppVersion();
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                public String getFunctionUrl() {
                    return downloadAppInfo.getAppDescUrl();
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                public String getPermissionUrl() {
                    return downloadAppInfo.getPermissionUrl();
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                public String getPrivacyAgreementUrl() {
                    return downloadAppInfo.getPrivacyUrl();
                }
            };
        }
    }

    public void OooO00o(NativeWMResponse nativeWMResponse) {
        nativeWMResponse.setAppDownloadListener(new IWMAppDownloadListener() { // from class: com.ubixnow.network.wangmai.WangMaiNativeAd.4
            public void handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                WangMaiNativeAd wangMaiNativeAd = WangMaiNativeAd.this;
                wangMaiNativeAd.showLog(wangMaiNativeAd.OooO00o, "handleDownloadDialog");
            }

            public void onDownloadDialogDismiss() {
                WangMaiNativeAd wangMaiNativeAd = WangMaiNativeAd.this;
                wangMaiNativeAd.showLog(wangMaiNativeAd.OooO00o, "onDownloadDialogDismiss");
            }

            public void onDownloadDialogShow() {
                WangMaiNativeAd wangMaiNativeAd = WangMaiNativeAd.this;
                wangMaiNativeAd.showLog(wangMaiNativeAd.OooO00o, "onDownloadDialogShow");
            }

            public void onDownloadFailed() {
                WangMaiNativeAd wangMaiNativeAd = WangMaiNativeAd.this;
                wangMaiNativeAd.showLog(wangMaiNativeAd.OooO00o, "onDownloadFailed");
                WangMaiNativeAd.this.apkDownloadFailed();
            }

            public void onDownloadFinished() {
                WangMaiNativeAd wangMaiNativeAd = WangMaiNativeAd.this;
                wangMaiNativeAd.showLog(wangMaiNativeAd.OooO00o, "onDownloadFinished");
                WangMaiNativeAd.this.apkDownloadFinished();
            }

            public void onDownloadPaused() {
                WangMaiNativeAd wangMaiNativeAd = WangMaiNativeAd.this;
                wangMaiNativeAd.showLog(wangMaiNativeAd.OooO00o, "onDownloadPaused");
                WangMaiNativeAd.this.apkDownloadPaused(0);
            }

            public void onDownloadResumed() {
                WangMaiNativeAd wangMaiNativeAd = WangMaiNativeAd.this;
                wangMaiNativeAd.showLog(wangMaiNativeAd.OooO00o, "onDownloadResumed");
            }

            public void onDownloadStarted() {
                WangMaiNativeAd wangMaiNativeAd = WangMaiNativeAd.this;
                wangMaiNativeAd.showLog(wangMaiNativeAd.OooO00o, "onDownloadStarted");
            }

            public void onProgressUpdate(int i) {
                WangMaiNativeAd wangMaiNativeAd = WangMaiNativeAd.this;
                wangMaiNativeAd.showLog(wangMaiNativeAd.OooO00o, "onProgressUpdate: " + i);
                WangMaiNativeAd.this.apkDownloadProgressUpdate(i);
            }
        });
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00oOoo
    public void destroy() {
        showLog(this.OooO00o, "destroy");
        try {
            WMAdNativePot wMAdNativePot = this.OooO0O0;
            if (wMAdNativePot != null) {
                wMAdNativePot.destroy();
            }
            NativeWMResponse nativeWMResponse = this.OooO0OO;
            if (nativeWMResponse != null) {
                nativeWMResponse.setAppDownloadListener((IWMAppDownloadListener) null);
            }
            WMVideoControl wMVideoControl = this.OooO0oo;
            if (wMVideoControl != null) {
                wMVideoControl.stop();
            }
        } catch (Exception e) {
            showLog(this.OooO00o, "destroy error：" + e.getMessage());
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public View getAdMediaView(Object... objArr) {
        AdBaseInfo baseInfo;
        View videoView = null;
        try {
            NativeWMResponse nativeWMResponse = this.OooO0OO;
            if (nativeWMResponse == null || (baseInfo = nativeWMResponse.getBaseInfo()) == null || baseInfo.getMaterialType() != AdBaseInfo.MaterialType.VIDEO) {
                return null;
            }
            WMVideoOption wMVideoOption = new WMVideoOption();
            wMVideoOption.setSilence(this.OooO0oO);
            wMVideoOption.setAutoPlay(TextUtils.isEmpty(this.OooO0o) || !"3".equals(this.OooO0o));
            WMVideoBean wMVideoBeanBuildVideoView = this.OooO0OO.buildVideoView(wMVideoOption, new WMVideoListener() { // from class: com.ubixnow.network.wangmai.WangMaiNativeAd.3
                public void onComplete() {
                    WangMaiNativeAd wangMaiNativeAd = WangMaiNativeAd.this;
                    wangMaiNativeAd.showLog(wangMaiNativeAd.OooO00o, "onComplete");
                    WangMaiNativeAd.this.notifyAdVideoEnd();
                }

                public void onError(String str) {
                    WangMaiNativeAd wangMaiNativeAd = WangMaiNativeAd.this;
                    wangMaiNativeAd.showLog(wangMaiNativeAd.OooO00o, "onError -> " + str);
                    WangMaiNativeAd.this.notifyAdVideoError();
                }

                public void onStart() {
                    WangMaiNativeAd wangMaiNativeAd = WangMaiNativeAd.this;
                    wangMaiNativeAd.showLog(wangMaiNativeAd.OooO00o, "onStart");
                    WangMaiNativeAd.this.notifyAdVideoStart();
                }

                public void onStop() {
                    WangMaiNativeAd wangMaiNativeAd = WangMaiNativeAd.this;
                    wangMaiNativeAd.showLog(wangMaiNativeAd.OooO00o, "onStop");
                }
            });
            videoView = wMVideoBeanBuildVideoView.getVideoView();
            this.OooO0oo = wMVideoBeanBuildVideoView.getVideoControl();
            return videoView;
        } catch (Exception e) {
            ooooO000.OooO00o(e);
            return videoView;
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public boolean isNativeExpress() {
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x001c  */
    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd
    public boolean isValid() {
        WMAdNativePot wMAdNativePot = this.OooO0O0;
        boolean z = true;
        boolean z2 = (wMAdNativePot == null || this.OooO0OO == null) ? false : true;
        if (z2) {
            try {
                if (!wMAdNativePot.isReady()) {
                    z = false;
                }
            } catch (Throwable th) {
                ooooO000.OooO00o(th);
                z = z2;
            }
        } else {
            z = false;
        }
        if (ooooO000.OooO00o) {
            ooooO000.OooO0OO(this.OooO00o, "---isValid " + z);
        }
        return z;
    }

    public void loadAd(String str, final oo000o oo000oVar, o00O00o0 o00o00o0) {
        this.loadListener = o00o00o0;
        this.configInfo = oo000oVar;
        parseConfig();
        this.OooO0O0 = new WMAdNativePot(new WMAdSlot.Builder().setSlotId(this.OooO0Oo).builder(), new XAdNativePotListener() { // from class: com.ubixnow.network.wangmai.WangMaiNativeAd.1
            public void onAdRequest() {
                WangMaiNativeAd wangMaiNativeAd = WangMaiNativeAd.this;
                wangMaiNativeAd.showLog(wangMaiNativeAd.OooO00o, "onAdRequest");
                try {
                    WangMaiNativeAd.this.OooO0o0 = oO.LOAD_SUCC.OooO00o();
                    if (oo000oVar.getBaseAdConfig().OooO00o.OooOO0O == 1) {
                        int ecpm = WangMaiNativeAd.this.OooO0O0.getECPM();
                        WangMaiNativeAd wangMaiNativeAd2 = WangMaiNativeAd.this;
                        wangMaiNativeAd2.showLog(wangMaiNativeAd2.OooO00o, "ecpm:" + ecpm + "分");
                        oo000oVar.setBiddingEcpm(ecpm);
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(WangMaiNativeAd.this);
                    oo000o oo000oVar2 = oo000oVar;
                    oo000oVar2.OooO00o = arrayList;
                    WangMaiNativeAd.this.onAdDataLoaded(oo000oVar2);
                } catch (Exception e) {
                    ooooO000.OooO00o(e);
                }
            }

            public void onClick() {
                WangMaiNativeAd wangMaiNativeAd = WangMaiNativeAd.this;
                wangMaiNativeAd.showLog(wangMaiNativeAd.OooO00o, "onClick");
                WangMaiNativeAd.this.notifyAdClicked();
            }

            public void onExposure() {
                WangMaiNativeAd wangMaiNativeAd = WangMaiNativeAd.this;
                wangMaiNativeAd.showLog(wangMaiNativeAd.OooO00o, "onAdShow");
                WangMaiNativeAd.this.notifyAdExposure();
            }

            public void onNativePresent(NativeWMResponse nativeWMResponse) {
                WangMaiNativeAd wangMaiNativeAd = WangMaiNativeAd.this;
                wangMaiNativeAd.showLog(wangMaiNativeAd.OooO00o, "onNativePresent");
                if (nativeWMResponse == null) {
                    WangMaiNativeAd wangMaiNativeAd2 = WangMaiNativeAd.this;
                    oOO00O0.OooO00o oooO00o = oOO00O0.OooO00o.RENDER_FAIL;
                    wangMaiNativeAd2.onADRenderFail(oooO00o.OooO00o(), oooO00o.OooO0O0(), oo000oVar);
                } else {
                    WangMaiNativeAd.this.OooO0OO = nativeWMResponse;
                    WangMaiNativeAd.this.OooO0O0(nativeWMResponse);
                    WangMaiNativeAd wangMaiNativeAd3 = WangMaiNativeAd.this;
                    wangMaiNativeAd3.OooO00o(wangMaiNativeAd3.configInfo, nativeWMResponse);
                    WangMaiNativeAd.this.onAdCacheSuccess(oo000oVar);
                }
            }

            public void onNoAd(String str2) {
                WangMaiNativeAd wangMaiNativeAd = WangMaiNativeAd.this;
                wangMaiNativeAd.showLog(wangMaiNativeAd.OooO00o, "onNoAd -> " + str2);
                if (WangMaiNativeAd.this.OooO0o0 != oO.LOAD_SUCC.OooO00o()) {
                    if (WangMaiNativeAd.this.loadListener != null) {
                        WangMaiNativeAd.this.loadListener.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, oOO00O0.ubix_no_ad, str2).setInfo((Object) oo000oVar));
                    }
                } else {
                    if (WangMaiNativeAd.this.OooO0OO == null || WangMaiNativeAd.this.OooO0OO.getBaseInfo() == null || WangMaiNativeAd.this.OooO0OO.getBaseInfo().getMaterialType() != AdBaseInfo.MaterialType.VIDEO) {
                        return;
                    }
                    WangMaiNativeAd.this.notifyAdVideoError();
                }
            }
        });
    }

    @Override // com.ubixnow.ooooo.o00oOoo
    public void notifyWin(o00OO0OO o00oo0oo) {
        try {
            WMAdNativePot wMAdNativePot = this.OooO0O0;
            if (wMAdNativePot != null) {
                wMAdNativePot.sendWinNotificationWithInfo((Bundle) null);
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public void onPause() {
        WMVideoControl wMVideoControl = this.OooO0oo;
        if (wMVideoControl != null) {
            wMVideoControl.pause();
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public void onResume() {
        WMVideoControl wMVideoControl = this.OooO0oo;
        if (wMVideoControl != null) {
            wMVideoControl.resume();
        }
    }

    public void parseConfig() {
        oo000o oo000oVar = this.configInfo;
        if (oo000oVar == null || oo000oVar.getBaseAdConfig() == null || this.configInfo.getBaseAdConfig().OooOOO0 == null) {
            return;
        }
        this.OooO0oO = this.configInfo.getBaseAdConfig().OooOOO0.Oooo0OO;
        this.OooO0o = this.configInfo.getBaseAdConfig().OooOOO0.Oooo0;
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public void pauseVideo() {
        WMVideoControl wMVideoControl = this.OooO0oo;
        if (wMVideoControl != null) {
            wMVideoControl.pause();
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public void regist(ViewGroup viewGroup, UMNNativeExtraInfo uMNNativeExtraInfo) {
        showLog(this.OooO00o, "regist");
        if (this.OooO0OO == null || uMNNativeExtraInfo.getClickViewList() == null) {
            return;
        }
        try {
            ViewGroup viewGroupBuildContainer = this.OooO0OO.buildContainer();
            this.OooO0OO.bindToAdContainer(viewGroupBuildContainer, (UMNFrameLayout) viewGroup.getChildAt(0));
            viewGroup.addView(viewGroupBuildContainer, new RelativeLayout.LayoutParams(-1, -1));
            this.OooO0OO.registerClickableViews(uMNNativeExtraInfo.getClickViewList());
            this.OooO0OO.notifyAdViewShow();
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public void resumeVideo() {
        WMVideoControl wMVideoControl = this.OooO0oo;
        if (wMVideoControl != null) {
            wMVideoControl.resume();
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public void setVideoMute(boolean z) {
        WMVideoControl wMVideoControl = this.OooO0oo;
        if (wMVideoControl != null) {
            wMVideoControl.setSilence(z);
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public void startVideo() {
        WMVideoControl wMVideoControl = this.OooO0oo;
        if (wMVideoControl != null) {
            wMVideoControl.start();
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public void stopVideo() {
        WMVideoControl wMVideoControl = this.OooO0oo;
        if (wMVideoControl != null) {
            wMVideoControl.stop();
        }
    }
}
