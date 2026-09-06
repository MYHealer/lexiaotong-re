package com.ubixnow.network.gdt;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.util.AdError;
import com.stub.StubApp;
import com.ubixnow.adtype.nativead.api.UMNNativeMaterial;
import com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd;
import com.ubixnow.adtype.splash.api.UMNSplashParams;
import com.ubixnow.core.bean.UMNNativeExtraInfo;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.oo000o;
import com.ubixnow.ooooo.ooooO000;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class GdtNativeAd extends UMNCustomNativeAd {
    private static final String OooO00o = "----GdtNativeAd";
    public WeakReference<Context> OooO0O0;
    public Context OooO0OO;
    public NativeUnifiedAD OooO0Oo;
    public MediaView OooO0o;
    public NativeUnifiedADData OooO0o0;
    public o00O00o0 OooO0oO;
    public NativeAdContainer OooO0oo;

    public GdtNativeAd(Context context, String str, String str2, final oo000o oo000oVar) {
        this.OooO0OO = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.OooO0O0 = new WeakReference<>(context);
        this.configInfo = oo000oVar;
        this.OooO0Oo = new NativeUnifiedAD(this.OooO0O0.get(), str2, new NativeADUnifiedListener() { // from class: com.ubixnow.network.gdt.GdtNativeAd.1
            @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
            public void onADLoaded(List<NativeUnifiedADData> list) {
                if (list != null) {
                    try {
                        if (list.size() > 0) {
                            GdtNativeAd.this.OooO00o(list.get(0));
                            if (oo000oVar.getBaseAdConfig().OooO00o.OooOO0O == 1) {
                                GdtNativeAd.this.showLog(GdtNativeAd.OooO00o, "price:" + list.get(0).getECPM());
                                oo000oVar.setBiddingEcpm(list.get(0).getECPM());
                            }
                            GdtNativeAd.this.showLog(GdtNativeAd.OooO00o, "onADLoaded info hashcode " + oo000oVar.hashCode());
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(GdtNativeAd.this);
                            oo000o oo000oVar2 = oo000oVar;
                            oo000oVar2.OooO00o = arrayList;
                            GdtNativeAd.this.onAdCacheSuccess(oo000oVar2);
                        }
                    } catch (Exception e) {
                        ooooO000.OooO00o(e);
                    }
                }
            }

            @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
            public void onNoAD(AdError adError) {
                GdtNativeAd.this.showLog(GdtNativeAd.OooO00o, " onError " + adError.getErrorMsg());
                o00O00o0 o00o00o0 = GdtNativeAd.this.OooO0oO;
                if (o00o00o0 != null) {
                    o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, adError.getErrorCode() + "", adError.getErrorMsg()).setInfo((Object) oo000oVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OooO00o(final NativeUnifiedADData nativeUnifiedADData) {
        String str;
        this.OooO0o0 = nativeUnifiedADData;
        if (nativeUnifiedADData.getAppMiitInfo() != null) {
            setUserName(nativeUnifiedADData.getAppMiitInfo().getAppName());
        }
        setTitle(nativeUnifiedADData.getTitle());
        setAdSource("优量汇广告");
        setDescriptionText(nativeUnifiedADData.getDesc());
        setMainImageUrl(nativeUnifiedADData.getImgUrl());
        setMainImgHeight(nativeUnifiedADData.getPictureHeight());
        setMainImgWidth(nativeUnifiedADData.getPictureWidth());
        setImageList4Url(nativeUnifiedADData.getImgList());
        if (TextUtils.isEmpty(nativeUnifiedADData.getImgUrl()) && nativeUnifiedADData.getImgList() != null && nativeUnifiedADData.getImgList().size() > 0) {
            setMainImageUrl(nativeUnifiedADData.getImgList().get(0));
        }
        setVideoDuration(nativeUnifiedADData.getVideoDuration());
        if (nativeUnifiedADData.getCustomizeVideo() != null) {
            setVideoUrl(nativeUnifiedADData.getCustomizeVideo().getVideoUrl());
        }
        setButtonText(nativeUnifiedADData.getButtonText());
        setIconImageUrl(nativeUnifiedADData.getIconUrl());
        if (nativeUnifiedADData.isAppAd()) {
            setNativeInteractionType(1);
        }
        if (nativeUnifiedADData.getAdPatternType() == 2) {
            showLog(OooO00o, "-----Video");
            str = "1";
        } else {
            showLog(OooO00o, "-----IMAGE_TYPE");
            str = "2";
        }
        this.mAdSourceType = str;
        setAdType(this.mAdSourceType);
        if (nativeUnifiedADData.getAppMiitInfo() != null) {
            this.downloadAppinfo = new UMNNativeMaterial.DownloadAppinfo() { // from class: com.ubixnow.network.gdt.GdtNativeAd.2
                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                public String getAppName() {
                    return nativeUnifiedADData.getAppMiitInfo().getAppName();
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                public String getAppPublisher() {
                    return nativeUnifiedADData.getAppMiitInfo().getAuthorName();
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                public long getAppSize() {
                    return nativeUnifiedADData.getAppMiitInfo().getPackageSizeBytes();
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                public String getAppVersionName() {
                    return nativeUnifiedADData.getAppMiitInfo().getVersionName();
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                public String getFunctionUrl() {
                    try {
                        Method declaredMethod = nativeUnifiedADData.getAppMiitInfo().getClass().getDeclaredMethod("getDescriptionUrl", new Class[0]);
                        declaredMethod.setAccessible(true);
                        return (String) declaredMethod.invoke(nativeUnifiedADData.getAppMiitInfo(), new Object[0]);
                    } catch (Exception unused) {
                        return "";
                    }
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                public String getPermissionUrl() {
                    return nativeUnifiedADData.getAppMiitInfo().getPermissionsUrl();
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                public String getPrivacyAgreementUrl() {
                    return nativeUnifiedADData.getAppMiitInfo().getPrivacyAgreement();
                }
            };
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public void clear(View view) {
        super.clear(view);
        onPause();
        this.OooO0o = null;
        this.OooO0oo = null;
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00oOoo
    public void destroy() {
        super.destroy();
        showLog(OooO00o, "destroy");
        NativeUnifiedADData nativeUnifiedADData = this.OooO0o0;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.setNativeAdEventListener(null);
            this.OooO0o0.destroy();
            this.OooO0Oo = null;
        }
        this.OooO0o = null;
        this.OooO0OO = null;
        WeakReference<Context> weakReference = this.OooO0O0;
        if (weakReference != null) {
            weakReference.clear();
            this.OooO0O0 = null;
        }
        NativeAdContainer nativeAdContainer = this.OooO0oo;
        if (nativeAdContainer != null) {
            nativeAdContainer.removeAllViews();
            this.OooO0oo = null;
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public View getAdMediaView(Object... objArr) {
        NativeUnifiedADData nativeUnifiedADData = this.OooO0o0;
        if (nativeUnifiedADData != null && nativeUnifiedADData.getAdPatternType() == 2) {
            MediaView mediaView = new MediaView(this.OooO0OO);
            this.OooO0o = mediaView;
            mediaView.setBackgroundColor(-16777216);
            ViewGroup.LayoutParams layoutParams = this.OooO0o.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -2);
            }
            this.OooO0o.setLayoutParams(layoutParams);
            return this.OooO0o;
        }
        return super.getAdMediaView(objArr);
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public ViewGroup getCustomAdContainer() {
        if (this.OooO0Oo != null) {
            this.OooO0oo = new NativeAdContainer(this.OooO0OO);
        }
        return this.OooO0oo;
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd
    public View getShakeView(View view) {
        return getNativeShakeView(this.OooO0OO);
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public boolean isNativeExpress() {
        return false;
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd
    public boolean isValid() {
        NativeUnifiedADData nativeUnifiedADData = this.OooO0o0;
        if (nativeUnifiedADData != null) {
            return nativeUnifiedADData.isValid();
        }
        return false;
    }

    public void loadNativeAd(o00O00o0 o00o00o0) {
        this.loadListener = o00o00o0;
        this.OooO0Oo.loadData(1);
        this.OooO0oO = o00o00o0;
    }

    @Override // com.ubixnow.ooooo.o00oOoo
    public void notifyLoss(o00OO0OO o00oo0oo) {
        try {
            NativeUnifiedADData nativeUnifiedADData = this.OooO0o0;
            if (nativeUnifiedADData != null) {
                nativeUnifiedADData.sendLossNotification(GdtBiddingUtils.getFailInfo(o00oo0oo));
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0OO(OooO00o, "竞价回传_notifyLoss:" + GdtBiddingUtils.getFailInfo(o00oo0oo));
                }
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00oOoo
    public void notifyWin(o00OO0OO o00oo0oo) {
        try {
            NativeUnifiedADData nativeUnifiedADData = this.OooO0o0;
            if (nativeUnifiedADData != null) {
                nativeUnifiedADData.sendWinNotification(GdtBiddingUtils.getSuccMap(o00oo0oo));
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0OO(OooO00o, "竞价回传_notifyWin:" + GdtBiddingUtils.getSuccMap(o00oo0oo));
                }
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public void onResume() {
        try {
            if (this.OooO0o0 != null) {
                showLog(OooO00o, "onResume");
                this.OooO0o0.resume();
                this.OooO0o0.resumeVideo();
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public void pauseVideo() {
        NativeUnifiedADData nativeUnifiedADData = this.OooO0o0;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.pauseVideo();
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public void regist(ViewGroup viewGroup, UMNNativeExtraInfo uMNNativeExtraInfo) {
        boolean z;
        int i;
        NativeUnifiedADData nativeUnifiedADData = this.OooO0o0;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.bindAdToView(viewGroup.getContext(), this.OooO0oo, uMNNativeExtraInfo.getChoiceViewLayoutParams(), uMNNativeExtraInfo.getClickViewList(), uMNNativeExtraInfo.getCreativeClickViewList());
            if (this.OooO0o != null) {
                oo000o oo000oVar = this.configInfo;
                String str = "";
                if ((oo000oVar != null && oo000oVar.isMuteIndependent) || oo000oVar == null || oo000oVar.getBaseAdConfig() == null || this.configInfo.getBaseAdConfig().OooOOO0 == null) {
                    z = true;
                } else {
                    z = this.configInfo.getBaseAdConfig().OooOOO0.Oooo0OO;
                    str = this.configInfo.getBaseAdConfig().OooOOO0.Oooo0;
                }
                str.hashCode();
                if (str.equals("2")) {
                    i = 0;
                } else {
                    i = !str.equals("3") ? 1 : 2;
                }
                oo000o oo000oVar2 = this.configInfo;
                this.OooO0o0.bindMediaView(this.OooO0o, new VideoOption.Builder().setAutoPlayMuted(z).setAutoPlayPolicy((oo000oVar2 == null || !oo000oVar2.isAutoPlayIndependent) ? i : 1).build(), new NativeADMediaListener() { // from class: com.ubixnow.network.gdt.GdtNativeAd.3
                    @Override // com.qq.e.ads.nativ.NativeADMediaListener
                    public void onVideoClicked() {
                        GdtNativeAd.this.showLog(GdtNativeAd.OooO00o, "onVideoClicked");
                    }

                    @Override // com.qq.e.ads.nativ.NativeADMediaListener
                    public void onVideoCompleted() {
                        GdtNativeAd.this.showLog(GdtNativeAd.OooO00o, "onVideoCompleted");
                        GdtNativeAd.this.notifyAdVideoEnd();
                    }

                    @Override // com.qq.e.ads.nativ.NativeADMediaListener
                    public void onVideoError(AdError adError) {
                        GdtNativeAd.this.showLog(GdtNativeAd.OooO00o, "onVideoError" + adError.getErrorMsg());
                        GdtNativeAd.this.notifyAdVideoError();
                    }

                    @Override // com.qq.e.ads.nativ.NativeADMediaListener
                    public void onVideoInit() {
                        GdtNativeAd.this.showLog(GdtNativeAd.OooO00o, "onVideoInit");
                    }

                    @Override // com.qq.e.ads.nativ.NativeADMediaListener
                    public void onVideoLoaded(int i2) {
                        GdtNativeAd.this.showLog(GdtNativeAd.OooO00o, "onVideoLoaded");
                    }

                    @Override // com.qq.e.ads.nativ.NativeADMediaListener
                    public void onVideoLoading() {
                        GdtNativeAd.this.showLog(GdtNativeAd.OooO00o, "onVideoLoading");
                    }

                    @Override // com.qq.e.ads.nativ.NativeADMediaListener
                    public void onVideoPause() {
                        GdtNativeAd.this.showLog(GdtNativeAd.OooO00o, "onVideoPause");
                    }

                    @Override // com.qq.e.ads.nativ.NativeADMediaListener
                    public void onVideoReady() {
                        GdtNativeAd.this.showLog(GdtNativeAd.OooO00o, "onVideoReady");
                    }

                    @Override // com.qq.e.ads.nativ.NativeADMediaListener
                    public void onVideoResume() {
                        GdtNativeAd.this.showLog(GdtNativeAd.OooO00o, "onVideoResume");
                    }

                    @Override // com.qq.e.ads.nativ.NativeADMediaListener
                    public void onVideoStart() {
                        GdtNativeAd.this.showLog(GdtNativeAd.OooO00o, "onVideoStart");
                        GdtNativeAd.this.notifyAdVideoStart();
                    }

                    @Override // com.qq.e.ads.nativ.NativeADMediaListener
                    public void onVideoStop() {
                        GdtNativeAd.this.showLog(GdtNativeAd.OooO00o, "onVideoStop");
                    }
                });
                if (this.configInfo.getBaseAdConfig().OooO0o0 instanceof UMNSplashParams) {
                    ((FrameLayout.LayoutParams) this.OooO0o.getLayoutParams()).gravity = 17;
                }
            }
            this.OooO0o0.setNativeAdEventListener(new NativeADEventListener() { // from class: com.ubixnow.network.gdt.GdtNativeAd.4
                @Override // com.qq.e.ads.nativ.NativeADEventListener
                public void onADClicked() {
                    GdtNativeAd.this.showLog(GdtNativeAd.OooO00o, "onAdClicked");
                    GdtNativeAd.this.notifyAdClicked();
                }

                @Override // com.qq.e.ads.nativ.NativeADEventListener
                public void onADError(AdError adError) {
                    GdtNativeAd.this.showLog(GdtNativeAd.OooO00o, "onAdError code:" + adError.getErrorCode() + ",msg:" + adError.getErrorMsg());
                }

                @Override // com.qq.e.ads.nativ.NativeADEventListener
                public void onADExposed() {
                    GdtNativeAd.this.showLog(GdtNativeAd.OooO00o, "onAdShow");
                    GdtNativeAd.this.notifyAdExposure();
                }

                @Override // com.qq.e.ads.nativ.NativeADEventListener
                public void onADStatusChanged() {
                    GdtNativeAd.this.showLog(GdtNativeAd.OooO00o, "onAdStatusChanged");
                }
            });
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public void resumeVideo() {
        NativeUnifiedADData nativeUnifiedADData = this.OooO0o0;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.resumeVideo();
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public void setVideoMute(boolean z) {
        NativeUnifiedADData nativeUnifiedADData = this.OooO0o0;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.setVideoMute(z);
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public void startVideo() {
        NativeUnifiedADData nativeUnifiedADData = this.OooO0o0;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.startVideo();
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public void stopVideo() {
        NativeUnifiedADData nativeUnifiedADData = this.OooO0o0;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.stopVideo();
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd
    public void transferContainer(ViewGroup viewGroup) {
        if (viewGroup != null) {
            this.OooO0oo = (NativeAdContainer) viewGroup;
        }
    }
}
