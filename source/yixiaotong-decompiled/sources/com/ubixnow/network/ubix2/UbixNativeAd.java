package com.ubixnow.network.ubix2;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.ubix.ssp.open.AdError;
import com.ubix.ssp.open.UBiXAdLossInfo;
import com.ubix.ssp.open.manager.UBiXAdManager;
import com.ubix.ssp.open.nativee.NativeAd;
import com.ubix.ssp.open.nativee.UBiXImage;
import com.ubix.ssp.open.nativee.UBiXNativeAdDownloadListener;
import com.ubix.ssp.open.nativee.UBiXNativeAdListener;
import com.ubix.ssp.open.nativee.UBiXNativeInteractionListener;
import com.ubix.ssp.open.nativee.UBiXNativeManager;
import com.ubix.ssp.open.nativee.UBiXNativeVideoListener;
import com.ubixnow.adtype.nativead.api.UMNNativeMaterial;
import com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd;
import com.ubixnow.core.api.UMNImageInfo;
import com.ubixnow.core.bean.UMNNativeExtraInfo;
import com.ubixnow.core.common.ui.UMNFrameLayout;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.oO00000o;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.oo000o;
import com.ubixnow.ooooo.ooooO000;
import com.ubixnow.utils.BaseUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UbixNativeAd extends UMNCustomNativeAd {
    private NativeAd OooO0OO;
    public final String OooO00o = InternalFrame.ID + getClass().getSimpleName();
    private UBiXNativeManager OooO0O0 = UBiXAdManager.createNativeAd();
    private View OooO0Oo = null;

    public UbixNativeAd(Context context) {
    }

    private void OooO00o() {
        try {
            if (this.OooO0O0 != null) {
                HashMap<String, String> map = new HashMap<>();
                map.put("sensor_disabled", oO00000o.o00O0O.OooOOOo ? "0" : "1");
                this.OooO0O0.setExtraInfo(map);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OooO00o(final NativeAd nativeAd) {
        setUserName(nativeAd.getAppName());
        setTitle(nativeAd.getTitle());
        setAdSource("UBiX广告");
        setAdFrom(nativeAd.getAdSource());
        try {
            setAdType(nativeAd.getCreativeType() == 3 ? "1" : "2");
        } catch (Exception unused) {
            setAdType("2");
        }
        try {
            setIconImageUrl(nativeAd.getAppIcon());
            setVideoDuration((int) nativeAd.getVideoDuration());
            setLandingPageUrl(nativeAd.getLandingPageUrl());
            setDownloadUrl(nativeAd.getDownloadUrl());
            setDeeplinkUrl(nativeAd.getDeeplinkUrl());
            setCreativeId(nativeAd.getCreativeId());
            setAppPackageName(nativeAd.getAppPackageName());
        } catch (Throwable unused2) {
        }
        setDescriptionText(nativeAd.getDesc());
        ArrayList arrayList = new ArrayList();
        setMainImageUrl(nativeAd.getImageUrl());
        if (nativeAd.getCustomizeVideo() != null) {
            setVideoUrl(nativeAd.getCustomizeVideo().getVideoUrl());
            setVideoCoverUrl(nativeAd.getCustomizeVideo().getCoverUrl());
            setVideoHeight(nativeAd.getCustomizeVideo().getVideoHeight());
            setVideoWidth(nativeAd.getCustomizeVideo().getVideoWidth());
        }
        setButtonText(nativeAd.getActionButtonText());
        if (nativeAd.getImageList() != null && !nativeAd.getImageList().isEmpty()) {
            for (UBiXImage uBiXImage : nativeAd.getImageList()) {
                arrayList.add(new UMNImageInfo(uBiXImage.getUrl(), uBiXImage.getWidth(), uBiXImage.getHeight()));
            }
            setMainImgHeight(nativeAd.getImageList().get(0).getHeight());
            setMainImgWidth(nativeAd.getImageList().get(0).getWidth());
            if (TextUtils.isEmpty(nativeAd.getImageUrl())) {
                setMainImageUrl(nativeAd.getImageList().get(0).getUrl());
            }
        }
        setImageInfoList(arrayList);
        if (nativeAd.getImageList() != null) {
            showLog(this.OooO00o, "------setAdData getImageList size" + nativeAd.getImageList().size());
        }
        showLog(this.OooO00o, "------setAdData " + nativeAd.getTitle() + "ImageUrl: " + nativeAd.getImageUrl());
        if (nativeAd.isDownloadAd()) {
            setNativeInteractionType(1);
        }
        this.downloadAppinfo = new UMNNativeMaterial.DownloadAppinfo() { // from class: com.ubixnow.network.ubix2.UbixNativeAd.5
            @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
            public String getAppName() {
                return nativeAd.getAppName();
            }

            @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
            public String getAppPublisher() {
                return nativeAd.getAppPublisher();
            }

            @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
            public long getAppSize() {
                try {
                    Method declaredMethod = NativeAd.class.getDeclaredMethod("getAppDownloadSize", new Class[0]);
                    declaredMethod.setAccessible(true);
                    return ((Long) declaredMethod.invoke(nativeAd, new Object[0])).longValue();
                } catch (Exception e) {
                    ooooO000.OooO00o(e);
                    return 0L;
                }
            }

            @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
            public String getAppVersionName() {
                return nativeAd.getAppVersion();
            }

            @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
            public String getFunctionUrl() {
                try {
                    Method declaredMethod = NativeAd.class.getDeclaredMethod("getAppIntroduceLink", new Class[0]);
                    declaredMethod.setAccessible(true);
                    return (String) declaredMethod.invoke(nativeAd, new Object[0]);
                } catch (Exception e) {
                    ooooO000.OooO00o(e);
                    return "";
                }
            }

            @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
            public String getPermissionUrl() {
                return nativeAd.getAppPermissionLink();
            }

            @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
            public String getPrivacyAgreementUrl() {
                return nativeAd.getAppPrivacyLink();
            }
        };
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public View getAdMediaView(Object... objArr) {
        try {
            if (this.OooO0Oo == null && this.OooO0OO.getCreativeType() == 3) {
                if (this.configInfo.getBaseAdConfig().OooOOO0 != null) {
                    this.OooO0OO.setVideoMute(this.configInfo.getBaseAdConfig().OooOOO0.Oooo0OO);
                }
                View mediaView = this.OooO0OO.getMediaView();
                this.OooO0Oo = mediaView;
                return mediaView;
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
        return this.OooO0Oo;
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd
    public int getDownloadAppStatus() {
        NativeAd nativeAd = this.OooO0OO;
        if (nativeAd != null) {
            return nativeAd.getDownloadAppStatus();
        }
        return 0;
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd
    public String getRewardTaskAction() {
        String str;
        try {
            NativeAd nativeAd = this.OooO0OO;
            if (nativeAd == null) {
                return "0";
            }
            Method declaredMethod = nativeAd.getClass().getDeclaredMethod("getExtraInfo", new Class[0]);
            declaredMethod.setAccessible(true);
            HashMap map = (HashMap) declaredMethod.invoke(this.OooO0OO, new Object[0]);
            return (map == null || (str = (String) map.get(ServerSideVerificationOptions.ACTION)) == null) ? "0" : str;
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
            return "0";
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public boolean isNativeExpress() {
        return false;
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd
    public boolean isValid() {
        try {
            if (this.OooO0OO == null) {
                ooooO000.OooO0OO(this.OooO00o, "isValid false");
                return false;
            }
            if (ooooO000.OooO00o) {
                ooooO000.OooO0OO(this.OooO00o, "isValid " + this.OooO0OO.isValid());
            }
            return this.OooO0OO.isValid();
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
            return true;
        }
    }

    public void loadAd(final oo000o oo000oVar, String str, final o00O00o0 o00o00o0) {
        showLog(this.OooO00o, "-----load " + str);
        this.loadListener = o00o00o0;
        this.configInfo = oo000oVar;
        this.OooO0O0.loadNativeAd(BaseUtils.getContext(), str, new UBiXNativeAdListener() { // from class: com.ubixnow.network.ubix2.UbixNativeAd.1
            @Override // com.ubix.ssp.open.nativee.UBiXNativeAdListener
            public void onAdLoadFailed(AdError adError) {
                UbixNativeAd ubixNativeAd = UbixNativeAd.this;
                ubixNativeAd.showLog(ubixNativeAd.OooO00o, "native onError code:" + adError.getErrorCode() + ",msg:" + adError.getErrorMessage());
                o00O00o0 o00o00o1 = o00o00o0;
                if (o00o00o1 != null) {
                    o00o00o1.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, adError.getErrorCode() + "", adError.getErrorMessage()).setInfo((Object) oo000oVar));
                }
            }

            @Override // com.ubix.ssp.open.nativee.UBiXNativeAdListener
            public void onAdLoadSucceed(List<NativeAd> list) {
                UbixNativeAd ubixNativeAd = UbixNativeAd.this;
                ubixNativeAd.showLog(ubixNativeAd.OooO00o, "onNativeAdLoad hashCode " + UbixNativeAd.this.configInfo.hashCode());
                if (list == null || list.size() == 0) {
                    o00O00o0 o00o00o1 = o00o00o0;
                    if (o00o00o1 != null) {
                        o00o00o1.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg).setInfo((Object) oo000oVar));
                        return;
                    }
                    return;
                }
                UbixNativeAd.this.OooO0OO = list.get(0);
                if (oo000oVar.getBaseAdConfig().OooO00o.OooOO0O == 1) {
                    UbixNativeAd ubixNativeAd2 = UbixNativeAd.this;
                    ubixNativeAd2.showLog(ubixNativeAd2.OooO00o, "price:" + UbixNativeAd.this.OooO0OO.getPrice());
                    oo000oVar.setBiddingEcpm((int) UbixNativeAd.this.OooO0OO.getPrice());
                }
                UbixNativeAd ubixNativeAd3 = UbixNativeAd.this;
                ubixNativeAd3.OooO00o(ubixNativeAd3.OooO0OO);
                ArrayList arrayList = new ArrayList();
                arrayList.add(UbixNativeAd.this);
                oo000o oo000oVar2 = oo000oVar;
                oo000oVar2.OooO00o = arrayList;
                oo000oVar2.getBaseAdConfig().OooOOo0 = UbixUtils.getPR(UbixNativeAd.this.OooO0OO);
                UbixNativeAd.this.onAdCacheSuccess(oo000oVar);
            }
        });
        OooO00o();
        this.OooO0O0.loadAd();
    }

    @Override // com.ubixnow.ooooo.o00oOoo
    public void notifyLoss(o00OO0OO o00oo0oo) {
        try {
            if (this.OooO0OO != null) {
                UBiXAdLossInfo failInfo = Ubix2BiddingUtils.getFailInfo(o00oo0oo);
                this.OooO0OO.lossNotice(failInfo);
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0OO(this.OooO00o, "竞价回传_notifyLoss:" + failInfo.getInfo().toString());
                }
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00oOoo
    public void notifyWin(o00OO0OO o00oo0oo) {
        try {
            NativeAd nativeAd = this.OooO0OO;
            if (nativeAd != null) {
                nativeAd.winNotice(Ubix2BiddingUtils.getSecondPrice(o00oo0oo));
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0OO(this.OooO00o, "竞价回传_notifyWin:" + Ubix2BiddingUtils.getSecondPrice(o00oo0oo));
                }
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public void pauseVideo() {
        showLog(this.OooO00o, "pauseVideo");
        try {
            NativeAd nativeAd = this.OooO0OO;
            if (nativeAd != null) {
                nativeAd.pauseVideo();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public void regist(ViewGroup viewGroup, UMNNativeExtraInfo uMNNativeExtraInfo) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (uMNNativeExtraInfo.getClickViewList() != null) {
            arrayList.addAll(uMNNativeExtraInfo.getClickViewList());
        }
        if (uMNNativeExtraInfo.getCloseView() != null) {
            arrayList2.add(uMNNativeExtraInfo.getCloseView());
        }
        if (viewGroup.getChildAt(0) instanceof UMNFrameLayout) {
            viewGroup = (UMNFrameLayout) viewGroup.getChildAt(0);
        }
        this.OooO0OO.registerViews(viewGroup, uMNNativeExtraInfo.getClickViewList(), uMNNativeExtraInfo.getCloseView(), new UBiXNativeInteractionListener() { // from class: com.ubixnow.network.ubix2.UbixNativeAd.2
            @Override // com.ubix.ssp.open.nativee.UBiXNativeInteractionListener
            public void onAdClicked(View view) {
                UbixNativeAd ubixNativeAd = UbixNativeAd.this;
                ubixNativeAd.showLog(ubixNativeAd.OooO00o, "click");
                UbixNativeAd.this.notifyAdClicked();
            }

            @Override // com.ubix.ssp.open.nativee.UBiXNativeInteractionListener
            public void onAdClosed() {
                UbixNativeAd ubixNativeAd = UbixNativeAd.this;
                ubixNativeAd.showLog(ubixNativeAd.OooO00o, "onAdClosed");
                UbixNativeAd.this.notifyAdDislikeClick();
            }

            @Override // com.ubix.ssp.open.nativee.UBiXNativeInteractionListener
            public void onAdExposeFailed(AdError adError) {
                UbixNativeAd ubixNativeAd = UbixNativeAd.this;
                ubixNativeAd.showLog(ubixNativeAd.OooO00o, "onAdExposeFailed:" + adError.getErrorMessage());
            }

            @Override // com.ubix.ssp.open.nativee.UBiXNativeInteractionListener
            public void onAdExposed() {
                UbixNativeAd ubixNativeAd = UbixNativeAd.this;
                ubixNativeAd.showLog(ubixNativeAd.OooO00o, "onAdExposed");
                UbixNativeAd.this.notifyAdExposure();
            }

            @Override // com.ubix.ssp.open.nativee.UBiXNativeInteractionListener
            public void onAdStatusChanged() {
                UbixNativeAd ubixNativeAd = UbixNativeAd.this;
                ubixNativeAd.showLog(ubixNativeAd.OooO00o, "onAdStatusChanged");
                UbixNativeAd.this.notifyAdStatusChanged();
            }
        });
        if (this.configInfo.getBaseAdConfig().OooOOO0.OoooO0 && this.configInfo.getBaseAdConfig().OooO00o.OooOOoo != null && this.configInfo.getBaseAdConfig().OooO00o.OooOOoo.OooO0OO) {
            this.OooO0OO.shakeOn();
        }
        try {
            this.OooO0OO.startVideo();
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
        this.OooO0OO.setDownloadListener(new UBiXNativeAdDownloadListener() { // from class: com.ubixnow.network.ubix2.UbixNativeAd.3
            @Override // com.ubix.ssp.open.nativee.UBiXNativeAdDownloadListener
            public void onDownloadFailed(AdError adError) {
                UbixNativeAd.this.apkDownloadFailed();
            }

            @Override // com.ubix.ssp.open.nativee.UBiXNativeAdDownloadListener
            public void onDownloadFinished(String str) {
                UbixNativeAd.this.apkDownloadFinished();
            }

            @Override // com.ubix.ssp.open.nativee.UBiXNativeAdDownloadListener
            public void onDownloadPaused(int i) {
                UbixNativeAd.this.apkDownloadPaused(i);
            }

            @Override // com.ubix.ssp.open.nativee.UBiXNativeAdDownloadListener
            public void onDownloadResume(int i) {
            }

            @Override // com.ubix.ssp.open.nativee.UBiXNativeAdDownloadListener
            public void onDownloadStarted() {
            }

            @Override // com.ubix.ssp.open.nativee.UBiXNativeAdDownloadListener
            public void onDownloading(int i) {
                UbixNativeAd.this.apkDownloadProgressUpdate(i);
            }
        });
        try {
            this.OooO0OO.setVideoListener(new UBiXNativeVideoListener() { // from class: com.ubixnow.network.ubix2.UbixNativeAd.4
                @Override // com.ubix.ssp.open.nativee.UBiXNativeVideoListener
                public void onVideoComplete() {
                    UbixNativeAd ubixNativeAd = UbixNativeAd.this;
                    ubixNativeAd.showLog(ubixNativeAd.OooO00o, "onVideoComplete");
                    UbixNativeAd.this.notifyAdVideoEnd();
                }

                @Override // com.ubix.ssp.open.nativee.UBiXNativeVideoListener
                public void onVideoError(AdError adError) {
                    UbixNativeAd ubixNativeAd = UbixNativeAd.this;
                    ubixNativeAd.showLog(ubixNativeAd.OooO00o, "onVideoError");
                    UbixNativeAd.this.notifyAdVideoError();
                }

                @Override // com.ubix.ssp.open.nativee.UBiXNativeVideoListener
                public void onVideoPause() {
                    UbixNativeAd ubixNativeAd = UbixNativeAd.this;
                    ubixNativeAd.showLog(ubixNativeAd.OooO00o, "onVideoPause");
                }

                @Override // com.ubix.ssp.open.nativee.UBiXNativeVideoListener
                public void onVideoProgressUpdate(long j, long j2) {
                }

                @Override // com.ubix.ssp.open.nativee.UBiXNativeVideoListener
                public void onVideoResume() {
                    UbixNativeAd ubixNativeAd = UbixNativeAd.this;
                    ubixNativeAd.showLog(ubixNativeAd.OooO00o, "onVideoResume");
                }

                @Override // com.ubix.ssp.open.nativee.UBiXNativeVideoListener
                public void onVideoStart() {
                    UbixNativeAd ubixNativeAd = UbixNativeAd.this;
                    ubixNativeAd.showLog(ubixNativeAd.OooO00o, "onVideoStart");
                    UbixNativeAd.this.notifyAdVideoStart();
                }
            });
        } catch (Throwable unused) {
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public void setVideoMute(boolean z) {
        try {
            NativeAd nativeAd = this.OooO0OO;
            if (nativeAd != null) {
                nativeAd.setVideoMute(z);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public void startVideo() {
        showLog(this.OooO00o, "startVideo");
        try {
            NativeAd nativeAd = this.OooO0OO;
            if (nativeAd != null) {
                nativeAd.startVideo();
            }
        } catch (Throwable unused) {
        }
    }
}
