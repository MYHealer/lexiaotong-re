package com.ubixnow.network.kuaishou;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsApkDownloadListener;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.api.model.NativeAdExtraData;
import com.ubixnow.adtype.nativead.api.UMNNativeMaterial;
import com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd;
import com.ubixnow.core.api.UMNImageInfo;
import com.ubixnow.core.bean.UMNNativeExtraInfo;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.oO0O0OoO;
import com.ubixnow.ooooo.oOO00O;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.oo000o;
import com.ubixnow.ooooo.ooooO000;
import com.ubixnow.utils.BaseUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class KsNativeAd extends UMNCustomNativeAd {
    public View OooO0O0;
    public WeakReference<Context> OooO0Oo;
    public KsScene OooO0o;
    public com.kwad.sdk.api.KsNativeAd OooO0o0;
    private AdExposureFailedReason OooO0oO;
    private String OooO0oo;
    public final String OooO00o = "----KsNativeAd";
    public String OooO0OO = "0";

    public KsNativeAd(Context context, String str, String str2, oOO00O ooo00o, oO0O0OoO oo0o0ooo) {
        this.OooO0Oo = new WeakReference<>(context);
        this.OooO0oo = str;
        showLog("----KsNativeAd", "slotId: " + str);
        KsScene.Builder builderAdNum = new KsScene.Builder(KsInitManager.getKSLongValue(str)).adNum(1);
        if (!TextUtils.isEmpty(str2)) {
            builderAdNum.setBidResponseV2(str2);
        }
        try {
            NativeAdExtraData nativeAdExtraData = new NativeAdExtraData();
            nativeAdExtraData.setShowLiveStatus(ooo00o.Oooo);
            nativeAdExtraData.setShowLiveStyle(ooo00o.OoooO00);
            builderAdNum.setNativeAdExtraData(nativeAdExtraData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        oO0O0OoO.OooO00o oooO00o = oo0o0ooo.OooOOoo;
        if (oooO00o != null && oooO00o.OooO0OO) {
            NativeAdExtraData nativeAdExtraData2 = new NativeAdExtraData();
            nativeAdExtraData2.setEnableShake(true);
            builderAdNum.setNativeAdExtraData(nativeAdExtraData2);
        }
        this.OooO0o = builderAdNum.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OooO00o() {
        setUserName(!TextUtils.isEmpty(this.OooO0o0.getAppName()) ? this.OooO0o0.getAppName() : this.OooO0o0.getProductName());
        setTitle(this.OooO0o0.getAppName());
        setAdSource("快手广告");
        setIconImageUrl(this.OooO0o0.getAppIconUrl());
        setAdFrom(this.OooO0o0.getAdSource());
        this.OooO0OO = (this.OooO0o0.getMaterialType() == 1 || this.OooO0o0.getMaterialType() == 8) ? "1" : "2";
        setAdType(this.OooO0OO);
        setVideoDuration(this.OooO0o0.getVideoDuration() * 1000);
        setDescriptionText(this.OooO0o0.getAdDescription());
        List<KsImage> imageList = this.OooO0o0.getImageList();
        ArrayList arrayList = new ArrayList();
        if (imageList != null && imageList.size() > 0) {
            for (KsImage ksImage : imageList) {
                arrayList.add(new UMNImageInfo(ksImage.getImageUrl(), ksImage.getWidth(), ksImage.getHeight()));
            }
            setMainImageUrl(imageList.get(0).getImageUrl());
            setMainImgHeight(imageList.get(0).getHeight());
            setMainImgWidth(imageList.get(0).getWidth());
        }
        setImageInfoList(arrayList);
        setVideoUrl(this.OooO0o0.getVideoUrl());
        setVideoHeight(this.OooO0o0.getVideoHeight());
        setAppPackageName(this.OooO0o0.getAppPackageName());
        setVideoWidth(this.OooO0o0.getVideoWidth());
        if (this.OooO0o0.getVideoCoverImage() != null) {
            setVideoCoverUrl(this.OooO0o0.getVideoCoverImage().getImageUrl());
        }
        setButtonText(this.OooO0o0.getActionDescription());
        if (this.OooO0o0.getInteractionType() == 1) {
            setNativeInteractionType(1);
        }
        this.downloadAppinfo = new UMNNativeMaterial.DownloadAppinfo() { // from class: com.ubixnow.network.kuaishou.KsNativeAd.6
            @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
            public String getAppName() {
                return KsNativeAd.this.OooO0o0.getAppName();
            }

            @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
            public String getAppPublisher() {
                return KsNativeAd.this.OooO0o0.getCorporationName();
            }

            @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
            public long getAppSize() {
                return KsNativeAd.this.OooO0o0.getAppPackageSize();
            }

            @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
            public String getAppVersionName() {
                return KsNativeAd.this.OooO0o0.getAppVersion();
            }

            @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
            public String getFunctionUrl() {
                try {
                    KsNativeAd ksNativeAd = KsNativeAd.this;
                    ksNativeAd.showLog(ksNativeAd.OooO00o, "getDescriptionUrl:" + KsNativeAd.this.OooO0o0.getIntroductionInfoUrl());
                    Method declaredMethod = com.kwad.sdk.api.KsNativeAd.class.getDeclaredMethod("getIntroductionInfoUrl", new Class[0]);
                    declaredMethod.setAccessible(true);
                    return (String) declaredMethod.invoke(KsNativeAd.this.OooO0o0, new Object[0]);
                } catch (Exception e) {
                    ooooO000.OooO00o(e);
                    return "";
                }
            }

            @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
            public String getPermissionUrl() {
                return KsNativeAd.this.OooO0o0.getPermissionInfoUrl();
            }

            @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
            public String getPrivacyAgreementUrl() {
                return KsNativeAd.this.OooO0o0.getAppPrivacyUrl();
            }
        };
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public View getAdMediaView(Object... objArr) {
        boolean z;
        try {
            oo000o oo000oVar = this.configInfo;
            boolean z2 = true;
            if (oo000oVar == null || !oo000oVar.isMuteIndependent) {
                z = (oo000oVar.getBaseAdConfig() == null || this.configInfo.getBaseAdConfig().OooOOO0 == null) ? false : this.configInfo.getBaseAdConfig().OooOOO0.Oooo0OO;
            } else {
                z = true;
            }
            KsAdVideoPlayConfig.Builder builderVideoSoundEnable = new KsAdVideoPlayConfig.Builder().videoSoundEnable(!z);
            oo000o oo000oVar2 = this.configInfo;
            if (oo000oVar2 != null && oo000oVar2.isAutoPlayIndependent) {
                builderVideoSoundEnable.videoAutoPlayType(1);
            }
            this.OooO0O0 = this.OooO0o0.getVideoView(BaseUtils.getContext(), builderVideoSoundEnable.build());
            String str = this.OooO00o;
            StringBuilder sb = new StringBuilder("-----getAdMediaView ");
            if (this.OooO0O0 == null) {
                z2 = false;
            }
            showLog(str, sb.append(z2).toString());
            return this.OooO0O0;
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
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

    public void loadAd(String str, final oo000o oo000oVar, final o00O00o0 o00o00o0) {
        this.loadListener = o00o00o0;
        this.configInfo = oo000oVar;
        KsAdSDK.getLoadManager().loadNativeAd(this.OooO0o, new KsLoadManager.NativeAdListener() { // from class: com.ubixnow.network.kuaishou.KsNativeAd.1
            @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
            public void onError(int i, String str2) {
                KsNativeAd ksNativeAd = KsNativeAd.this;
                ksNativeAd.showLog(ksNativeAd.OooO00o, "native onError code:" + i + ",msg:" + str2);
                o00O00o0 o00o00o1 = o00o00o0;
                if (o00o00o1 != null) {
                    o00o00o1.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, i + "", str2).setInfo((Object) oo000oVar));
                }
            }

            @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
            public void onNativeAdLoad(List<com.kwad.sdk.api.KsNativeAd> list) {
                KsNativeAd ksNativeAd = KsNativeAd.this;
                ksNativeAd.showLog(ksNativeAd.OooO00o, "onNativeAdLoad hashCode " + KsNativeAd.this.configInfo.hashCode());
                if (list == null || list.size() == 0) {
                    o00O00o0 o00o00o1 = o00o00o0;
                    if (o00o00o1 != null) {
                        o00o00o1.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg).setInfo((Object) oo000oVar));
                        return;
                    }
                    return;
                }
                KsNativeAd.this.OooO0o0 = list.get(0);
                if (oo000oVar.getBaseAdConfig().OooO00o.OooOO0O == 1) {
                    KsNativeAd ksNativeAd2 = KsNativeAd.this;
                    ksNativeAd2.showLog(ksNativeAd2.OooO00o, "price:" + KsNativeAd.this.OooO0o0.getECPM());
                    oo000oVar.setBiddingEcpm(KsNativeAd.this.OooO0o0.getECPM());
                }
                KsNativeAd.this.OooO00o();
                oo000o oo000oVar2 = oo000oVar;
                KsNativeAd ksNativeAd3 = KsNativeAd.this;
                oo000oVar2.material = KsUtils.getMaterialInfo(ksNativeAd3.OooO0o0, ksNativeAd3);
                ArrayList arrayList = new ArrayList();
                arrayList.add(KsNativeAd.this);
                oo000o oo000oVar3 = oo000oVar;
                oo000oVar3.OooO00o = arrayList;
                KsNativeAd.this.onAdCacheSuccess(oo000oVar3);
            }
        });
    }

    @Override // com.ubixnow.ooooo.o00oOoo
    public void notifyClick() {
        try {
            KsBiddingUtils.notifyClick(this.OooO0oo, this.OooO0oO, this.OooO0o0);
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00oOoo
    public void notifyLoss(o00OO0OO o00oo0oo) {
        try {
            this.OooO0oO = KsBiddingUtils.notifyLoss(this.OooO0oo, o00oo0oo, this.OooO0o0);
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00oOoo
    public void notifyShow() {
        try {
            KsBiddingUtils.notifyShow(this.OooO0oo, this.OooO0oO, this.OooO0o0);
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00oOoo
    public void notifyWin(o00OO0OO o00oo0oo) {
        try {
            KsBiddingUtils.notifyWin(o00oo0oo, this.OooO0o0);
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public void pauseVideo() {
        try {
            showLog(this.OooO00o, "pauseVideo");
            com.kwad.sdk.api.KsNativeAd ksNativeAd = this.OooO0o0;
            if (ksNativeAd != null) {
                ksNativeAd.pauseVideo();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0054  */
    /* JADX WARN: Code duplicated, block: B:23:0x005a  */
    /* JADX WARN: Code duplicated, block: B:24:0x0069  */
    /* JADX WARN: Code duplicated, block: B:27:0x007d  */
    /* JADX WARN: Code duplicated, block: B:28:0x007f  */
    /* JADX WARN: Code duplicated, block: B:31:0x008f  */
    /* JADX WARN: Code duplicated, block: B:33:? A[RETURN, SYNTHETIC] */
    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public void regist(ViewGroup viewGroup, UMNNativeExtraInfo uMNNativeExtraInfo) {
        Activity activity;
        Context context;
        boolean z;
        com.kwad.sdk.api.KsNativeAd ksNativeAd;
        if (viewGroup == null || viewGroup.getContext() == null || !(viewGroup.getContext() instanceof Activity)) {
            WeakReference<Context> weakReference = this.OooO0Oo;
            if (weakReference == null || weakReference.get() == null || !(this.OooO0Oo.get() instanceof Activity)) {
                activity = null;
            } else {
                context = this.OooO0Oo.get();
            }
            if (uMNNativeExtraInfo.getClickViewList() == null && activity != null) {
                this.OooO0o0.registerViewForInteraction(activity, viewGroup, uMNNativeExtraInfo.getClickViewList(), new com.kwad.sdk.api.KsNativeAd.AdInteractionListener() { // from class: com.ubixnow.network.kuaishou.KsNativeAd.2
                    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                    public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                        return false;
                    }

                    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                    public void onAdClicked(View view, com.kwad.sdk.api.KsNativeAd ksNativeAd2) {
                        KsNativeAd ksNativeAd3 = KsNativeAd.this;
                        ksNativeAd3.showLog(ksNativeAd3.OooO00o, "onAdClicked");
                        KsNativeAd.this.notifyAdClicked();
                    }

                    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                    public void onAdShow(com.kwad.sdk.api.KsNativeAd ksNativeAd2) {
                        KsNativeAd ksNativeAd3 = KsNativeAd.this;
                        ksNativeAd3.showLog(ksNativeAd3.OooO00o, "onAdShow");
                        KsNativeAd.this.notifyAdExposure();
                    }

                    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                    public void onDownloadTipsDialogDismiss() {
                    }

                    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                    public void onDownloadTipsDialogShow() {
                    }
                });
                this.OooO0o0.setVideoPlayListener(new com.kwad.sdk.api.KsNativeAd.VideoPlayListener() { // from class: com.ubixnow.network.kuaishou.KsNativeAd.3
                    @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
                    public void onVideoPlayComplete() {
                        KsNativeAd ksNativeAd2 = KsNativeAd.this;
                        ksNativeAd2.showLog(ksNativeAd2.OooO00o, "onVideoPlayComplete");
                        KsNativeAd.this.notifyAdVideoEnd();
                    }

                    @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
                    public void onVideoPlayError(int i, int i2) {
                        KsNativeAd ksNativeAd2 = KsNativeAd.this;
                        ksNativeAd2.showLog(ksNativeAd2.OooO00o, "onVideoPlayError");
                        KsNativeAd.this.notifyAdVideoError();
                    }

                    @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
                    public void onVideoPlayPause() {
                        KsNativeAd ksNativeAd2 = KsNativeAd.this;
                        ksNativeAd2.showLog(ksNativeAd2.OooO00o, "onVideoPlayPause");
                    }

                    @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
                    public void onVideoPlayReady() {
                        KsNativeAd ksNativeAd2 = KsNativeAd.this;
                        ksNativeAd2.showLog(ksNativeAd2.OooO00o, "onVideoPlayReady");
                    }

                    @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
                    public void onVideoPlayResume() {
                        KsNativeAd ksNativeAd2 = KsNativeAd.this;
                        ksNativeAd2.showLog(ksNativeAd2.OooO00o, "onVideoPlayResume");
                    }

                    @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
                    public void onVideoPlayStart() {
                        KsNativeAd ksNativeAd2 = KsNativeAd.this;
                        ksNativeAd2.showLog(ksNativeAd2.OooO00o, "onVideoPlayStart");
                        KsNativeAd.this.notifyAdVideoStart();
                    }
                });
            } else if (uMNNativeExtraInfo.getClickViewList() != null) {
                this.OooO0o0.registerViewForInteraction(viewGroup, uMNNativeExtraInfo.getClickViewList(), new com.kwad.sdk.api.KsNativeAd.AdInteractionListener() { // from class: com.ubixnow.network.kuaishou.KsNativeAd.4
                    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                    public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                        return false;
                    }

                    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                    public void onAdClicked(View view, com.kwad.sdk.api.KsNativeAd ksNativeAd2) {
                        KsNativeAd ksNativeAd3 = KsNativeAd.this;
                        ksNativeAd3.showLog(ksNativeAd3.OooO00o, "onAdClicked");
                        KsNativeAd.this.notifyAdClicked();
                    }

                    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                    public void onAdShow(com.kwad.sdk.api.KsNativeAd ksNativeAd2) {
                        KsNativeAd ksNativeAd3 = KsNativeAd.this;
                        ksNativeAd3.showLog(ksNativeAd3.OooO00o, "onAdShow");
                        KsNativeAd.this.notifyAdExposure();
                    }

                    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                    public void onDownloadTipsDialogDismiss() {
                    }

                    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                    public void onDownloadTipsDialogShow() {
                    }
                });
            } else {
                showLog(this.OooO00o, "clickView is null");
            }
            String str = this.OooO00o;
            StringBuilder sb = new StringBuilder("ksNativeAd is null");
            if (this.OooO0o0 != null) {
                z = true;
            } else {
                z = false;
            }
            showLog(str, sb.append(z).toString());
            ksNativeAd = this.OooO0o0;
            if (ksNativeAd != null) {
                ksNativeAd.setDownloadListener(new KsApkDownloadListener() { // from class: com.ubixnow.network.kuaishou.KsNativeAd.5
                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onDownloadFailed() {
                        KsNativeAd.this.apkDownloadFailed();
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onDownloadFinished() {
                        KsNativeAd.this.apkDownloadFinished();
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onDownloadStarted() {
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onIdle() {
                        KsNativeAd ksNativeAd2 = KsNativeAd.this;
                        ksNativeAd2.showLog(ksNativeAd2.OooO00o, "onIdle");
                        KsNativeAd.this.apkDownloadIdle();
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onInstalled() {
                        KsNativeAd.this.apkInstall();
                    }

                    @Override // com.kwad.sdk.api.KsApkDownloadListener
                    public void onPaused(int i) {
                        KsNativeAd ksNativeAd2 = KsNativeAd.this;
                        ksNativeAd2.showLog(ksNativeAd2.OooO00o, "onPaused");
                        KsNativeAd.this.apkDownloadPaused(i);
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onProgressUpdate(int i) {
                        KsNativeAd ksNativeAd2 = KsNativeAd.this;
                        ksNativeAd2.showLog(ksNativeAd2.OooO00o, "----onProgressUpdate " + i);
                        KsNativeAd.this.apkDownloadProgressUpdate(i);
                    }
                });
            }
        }
        context = viewGroup.getContext();
        activity = (Activity) context;
        if (uMNNativeExtraInfo.getClickViewList() == null) {
            if (uMNNativeExtraInfo.getClickViewList() != null) {
                this.OooO0o0.registerViewForInteraction(viewGroup, uMNNativeExtraInfo.getClickViewList(), new com.kwad.sdk.api.KsNativeAd.AdInteractionListener() { // from class: com.ubixnow.network.kuaishou.KsNativeAd.4
                    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                    public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                        return false;
                    }

                    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                    public void onAdClicked(View view, com.kwad.sdk.api.KsNativeAd ksNativeAd2) {
                        KsNativeAd ksNativeAd3 = KsNativeAd.this;
                        ksNativeAd3.showLog(ksNativeAd3.OooO00o, "onAdClicked");
                        KsNativeAd.this.notifyAdClicked();
                    }

                    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                    public void onAdShow(com.kwad.sdk.api.KsNativeAd ksNativeAd2) {
                        KsNativeAd ksNativeAd3 = KsNativeAd.this;
                        ksNativeAd3.showLog(ksNativeAd3.OooO00o, "onAdShow");
                        KsNativeAd.this.notifyAdExposure();
                    }

                    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                    public void onDownloadTipsDialogDismiss() {
                    }

                    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                    public void onDownloadTipsDialogShow() {
                    }
                });
            } else {
                showLog(this.OooO00o, "clickView is null");
            }
        } else if (uMNNativeExtraInfo.getClickViewList() != null) {
            this.OooO0o0.registerViewForInteraction(viewGroup, uMNNativeExtraInfo.getClickViewList(), new com.kwad.sdk.api.KsNativeAd.AdInteractionListener() { // from class: com.ubixnow.network.kuaishou.KsNativeAd.4
                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                    return false;
                }

                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public void onAdClicked(View view, com.kwad.sdk.api.KsNativeAd ksNativeAd2) {
                    KsNativeAd ksNativeAd3 = KsNativeAd.this;
                    ksNativeAd3.showLog(ksNativeAd3.OooO00o, "onAdClicked");
                    KsNativeAd.this.notifyAdClicked();
                }

                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public void onAdShow(com.kwad.sdk.api.KsNativeAd ksNativeAd2) {
                    KsNativeAd ksNativeAd3 = KsNativeAd.this;
                    ksNativeAd3.showLog(ksNativeAd3.OooO00o, "onAdShow");
                    KsNativeAd.this.notifyAdExposure();
                }

                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public void onDownloadTipsDialogDismiss() {
                }

                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public void onDownloadTipsDialogShow() {
                }
            });
        } else {
            showLog(this.OooO00o, "clickView is null");
        }
        String str2 = this.OooO00o;
        StringBuilder sb2 = new StringBuilder("ksNativeAd is null");
        if (this.OooO0o0 != null) {
            z = true;
        } else {
            z = false;
        }
        showLog(str2, sb2.append(z).toString());
        ksNativeAd = this.OooO0o0;
        if (ksNativeAd != null) {
            ksNativeAd.setDownloadListener(new KsApkDownloadListener() { // from class: com.ubixnow.network.kuaishou.KsNativeAd.5
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    KsNativeAd.this.apkDownloadFailed();
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    KsNativeAd.this.apkDownloadFinished();
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadStarted() {
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    KsNativeAd ksNativeAd2 = KsNativeAd.this;
                    ksNativeAd2.showLog(ksNativeAd2.OooO00o, "onIdle");
                    KsNativeAd.this.apkDownloadIdle();
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    KsNativeAd.this.apkInstall();
                }

                @Override // com.kwad.sdk.api.KsApkDownloadListener
                public void onPaused(int i) {
                    KsNativeAd ksNativeAd2 = KsNativeAd.this;
                    ksNativeAd2.showLog(ksNativeAd2.OooO00o, "onPaused");
                    KsNativeAd.this.apkDownloadPaused(i);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i) {
                    KsNativeAd ksNativeAd2 = KsNativeAd.this;
                    ksNativeAd2.showLog(ksNativeAd2.OooO00o, "----onProgressUpdate " + i);
                    KsNativeAd.this.apkDownloadProgressUpdate(i);
                }
            });
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public void startVideo() {
        try {
            showLog(this.OooO00o, "startVideo");
            com.kwad.sdk.api.KsNativeAd ksNativeAd = this.OooO0o0;
            if (ksNativeAd != null) {
                ksNativeAd.startVideo();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public void stopVideo() {
        try {
            showLog(this.OooO00o, "stopVideo");
            com.kwad.sdk.api.KsNativeAd ksNativeAd = this.OooO0o0;
            if (ksNativeAd != null) {
                ksNativeAd.stopVideo();
            }
        } catch (Throwable unused) {
        }
    }
}
