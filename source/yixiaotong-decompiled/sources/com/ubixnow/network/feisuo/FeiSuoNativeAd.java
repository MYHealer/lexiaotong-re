package com.ubixnow.network.feisuo;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.ubixnow.adtype.nativead.api.UMNNativeAdView;
import com.ubixnow.adtype.nativead.api.UMNNativeMaterial;
import com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd;
import com.ubixnow.core.bean.UMNNativeExtraInfo;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.oo000o;
import com.ubixnow.ooooo.ooooO000;
import com.ubixnow.utils.BaseUtils;
import com.zm.fissionsdk.api.FissionSdk;
import com.zm.fissionsdk.api.FissionSlot;
import com.zm.fissionsdk.api.FissionVideoOption;
import com.zm.fissionsdk.api.interfaces.IFission;
import com.zm.fissionsdk.api.interfaces.IFissionLoadManager;
import com.zm.fissionsdk.api.interfaces.IFissionNative;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class FeiSuoNativeAd extends UMNCustomNativeAd {
    private final String OooO00o = "-----" + getClass().getSimpleName();
    private final WeakReference<Context> OooO0O0;
    private final o00O000 OooO0OO;
    private IFissionNative OooO0Oo;
    private int OooO0o0;

    public FeiSuoNativeAd(WeakReference<Context> weakReference, o00O000 o00o000, oo000o oo000oVar) {
        this.OooO0O0 = weakReference;
        this.OooO0OO = o00o000;
        this.configInfo = oo000oVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:23:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:25:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:27:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:30:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:23:0x00c9, please report this as an issue */
    public void OooO00o() {
        String str;
        int i;
        IFissionNative iFissionNative = this.OooO0Oo;
        if (iFissionNative != null) {
            setTitle(iFissionNative.getTitle());
            setUserName(this.OooO0Oo.getAppName());
            setAdSource("飞梭广告");
            setDescriptionText(this.OooO0Oo.getDesc());
            if (FeiSuoUtils.isImg(this.OooO0Oo) && this.OooO0Oo.getImageList() != null && !this.OooO0Oo.getImageList().isEmpty()) {
                setMainImageUrl((String) this.OooO0Oo.getImageList().get(0));
                setMainImgWidth(this.OooO0Oo.getMaterialWidth());
                setMainImgHeight(this.OooO0Oo.getMaterialHeight());
            } else if (FeiSuoUtils.isVideo(this.OooO0Oo)) {
                setVideoHeight(this.OooO0Oo.getMaterialHeight());
                setVideoWidth(this.OooO0Oo.getMaterialWidth());
            }
            setImageList4Url(this.OooO0Oo.getImageList());
            setCreativeId(this.OooO0Oo.getSid());
            setButtonText(this.OooO0Oo.getBtnText());
            setIconImageUrl(this.OooO0Oo.getAppIcon());
            setAppPackageName(this.OooO0Oo.getPackageName());
            if (this.OooO0Oo.getInteractionType() != 4) {
                i = this.OooO0Oo.getInteractionType() == 3 ? 2 : 1;
                if (FeiSuoUtils.isVideo(this.OooO0Oo)) {
                    str = FeiSuoUtils.isImg(this.OooO0Oo) ? "2" : "1";
                    if (this.OooO0Oo.getInteractionType() == 4) {
                        this.downloadAppinfo = new UMNNativeMaterial.DownloadAppinfo() { // from class: com.ubixnow.network.feisuo.FeiSuoNativeAd.2
                            @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                            public String getAppName() {
                                return FeiSuoNativeAd.this.OooO0Oo.getAppName();
                            }

                            @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                            public String getAppPublisher() {
                                return FeiSuoNativeAd.this.OooO0Oo.getDeveloperName();
                            }

                            @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                            public long getAppSize() {
                                return 0L;
                            }

                            @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                            public String getAppVersionName() {
                                return FeiSuoNativeAd.this.OooO0Oo.getAppVersion();
                            }

                            @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                            public String getFunctionUrl() {
                                return FeiSuoNativeAd.this.OooO0Oo.getFunctionDescUrl();
                            }

                            @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                            public String getPermissionUrl() {
                                return FeiSuoNativeAd.this.OooO0Oo.getPermissionUrl();
                            }

                            @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                            public String getPrivacyAgreementUrl() {
                                return FeiSuoNativeAd.this.OooO0Oo.getPrivacyUrl();
                            }
                        };
                    }
                }
                setAdType(str);
                if (this.OooO0Oo.getInteractionType() == 4) {
                    this.downloadAppinfo = new UMNNativeMaterial.DownloadAppinfo() { // from class: com.ubixnow.network.feisuo.FeiSuoNativeAd.2
                        @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                        public String getAppName() {
                            return FeiSuoNativeAd.this.OooO0Oo.getAppName();
                        }

                        @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                        public String getAppPublisher() {
                            return FeiSuoNativeAd.this.OooO0Oo.getDeveloperName();
                        }

                        @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                        public long getAppSize() {
                            return 0L;
                        }

                        @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                        public String getAppVersionName() {
                            return FeiSuoNativeAd.this.OooO0Oo.getAppVersion();
                        }

                        @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                        public String getFunctionUrl() {
                            return FeiSuoNativeAd.this.OooO0Oo.getFunctionDescUrl();
                        }

                        @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                        public String getPermissionUrl() {
                            return FeiSuoNativeAd.this.OooO0Oo.getPermissionUrl();
                        }

                        @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                        public String getPrivacyAgreementUrl() {
                            return FeiSuoNativeAd.this.OooO0Oo.getPrivacyUrl();
                        }
                    };
                }
            }
            setNativeInteractionType(i);
            if (FeiSuoUtils.isVideo(this.OooO0Oo)) {
                if (FeiSuoUtils.isImg(this.OooO0Oo)) {
                }
                if (this.OooO0Oo.getInteractionType() == 4) {
                    this.downloadAppinfo = new UMNNativeMaterial.DownloadAppinfo() { // from class: com.ubixnow.network.feisuo.FeiSuoNativeAd.2
                        @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                        public String getAppName() {
                            return FeiSuoNativeAd.this.OooO0Oo.getAppName();
                        }

                        @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                        public String getAppPublisher() {
                            return FeiSuoNativeAd.this.OooO0Oo.getDeveloperName();
                        }

                        @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                        public long getAppSize() {
                            return 0L;
                        }

                        @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                        public String getAppVersionName() {
                            return FeiSuoNativeAd.this.OooO0Oo.getAppVersion();
                        }

                        @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                        public String getFunctionUrl() {
                            return FeiSuoNativeAd.this.OooO0Oo.getFunctionDescUrl();
                        }

                        @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                        public String getPermissionUrl() {
                            return FeiSuoNativeAd.this.OooO0Oo.getPermissionUrl();
                        }

                        @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                        public String getPrivacyAgreementUrl() {
                            return FeiSuoNativeAd.this.OooO0Oo.getPrivacyUrl();
                        }
                    };
                }
            }
            setAdType(str);
            if (this.OooO0Oo.getInteractionType() == 4) {
                this.downloadAppinfo = new UMNNativeMaterial.DownloadAppinfo() { // from class: com.ubixnow.network.feisuo.FeiSuoNativeAd.2
                    @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                    public String getAppName() {
                        return FeiSuoNativeAd.this.OooO0Oo.getAppName();
                    }

                    @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                    public String getAppPublisher() {
                        return FeiSuoNativeAd.this.OooO0Oo.getDeveloperName();
                    }

                    @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                    public long getAppSize() {
                        return 0L;
                    }

                    @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                    public String getAppVersionName() {
                        return FeiSuoNativeAd.this.OooO0Oo.getAppVersion();
                    }

                    @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                    public String getFunctionUrl() {
                        return FeiSuoNativeAd.this.OooO0Oo.getFunctionDescUrl();
                    }

                    @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                    public String getPermissionUrl() {
                        return FeiSuoNativeAd.this.OooO0Oo.getPermissionUrl();
                    }

                    @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                    public String getPrivacyAgreementUrl() {
                        return FeiSuoNativeAd.this.OooO0Oo.getPrivacyUrl();
                    }
                };
            }
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00oOoo
    public void destroy() {
        showLog(this.OooO00o, "destroy");
        IFissionNative iFissionNative = this.OooO0Oo;
        if (iFissionNative != null) {
            iFissionNative.destroy();
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0063  */
    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public View getAdMediaView(Object... objArr) {
        byte b;
        try {
            if (getAdType().equals("1")) {
                FissionVideoOption.Builder builder = new FissionVideoOption.Builder();
                if (this.OooO0Oo != null) {
                    oo000o oo000oVar = this.configInfo;
                    if (oo000oVar != null && oo000oVar.getBaseAdConfig() != null && this.configInfo.getBaseAdConfig().OooOOO0 != null) {
                        builder.setVideoMute(this.configInfo.getBaseAdConfig().OooOOO0.Oooo0OO);
                        String str = this.configInfo.getBaseAdConfig().OooOOO0.Oooo0;
                        int iHashCode = str.hashCode();
                        int i = 1;
                        if (iHashCode != 50) {
                            if (iHashCode == 51 && str.equals("3")) {
                                b = 1;
                            } else {
                                b = -1;
                            }
                        } else if (str.equals("2")) {
                            b = 0;
                        } else {
                            b = -1;
                        }
                        if (b == 0) {
                            i = 3;
                        } else if (b == 1) {
                            i = 2;
                        }
                        builder.setAutoPlayPolicy(i);
                        builder.setShowEndCard(false);
                    }
                    if (objArr != null && objArr.length > 0) {
                        Object obj = objArr[0];
                        if (obj instanceof UMNNativeAdView) {
                            UMNNativeAdView uMNNativeAdView = (UMNNativeAdView) obj;
                            if (uMNNativeAdView.getContext() != null && (uMNNativeAdView.getContext() instanceof Activity)) {
                                return this.OooO0Oo.getVideoView(uMNNativeAdView.getContext(), builder.build());
                            }
                            WeakReference<Context> weakReference = this.OooO0O0;
                            if (weakReference != null && weakReference.get() != null) {
                                return this.OooO0Oo.getVideoView(this.OooO0O0.get(), builder.build());
                            }
                        }
                    }
                    return this.OooO0Oo.getVideoView(BaseUtils.getContext(), builder.build());
                }
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
        return super.getAdMediaView(objArr);
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd
    public View getShakeView(View view) {
        try {
            IFissionNative iFissionNative = this.OooO0Oo;
            if (iFissionNative != null) {
                return iFissionNative.renderShakeView(BaseUtils.getContext(), -1, -1, new IFissionNative.ShakeListener() { // from class: com.ubixnow.network.feisuo.FeiSuoNativeAd.7
                    public void onShake() {
                        ooooO000.OooO0O0(FeiSuoNativeAd.this.OooO00o, "onShake");
                    }
                });
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public boolean isNativeExpress() {
        return false;
    }

    public void loadAd(o00O00o0 o00o00o0) {
        try {
            this.loadListener = o00o00o0;
            ooooO000.OooO0O0(this.OooO00o, "load ad");
            FissionSdk.getLoadManager().loadNative(new FissionSlot.Builder().setContext(this.OooO0O0.get()).setRequestId(this.OooO0OO.OooO0oO).setSlotType(1).setSlotId(this.OooO0OO.OooO00o.OooO0o0).setCount(1).build(), new IFissionLoadManager.AsyncNativeLoadListener() { // from class: com.ubixnow.network.feisuo.FeiSuoNativeAd.1
                public void onError(int i, String str) {
                    FeiSuoNativeAd feiSuoNativeAd = FeiSuoNativeAd.this;
                    feiSuoNativeAd.showLog(feiSuoNativeAd.OooO00o, "onError code" + i + " msg:" + str);
                    if (FeiSuoNativeAd.this.loadListener != null) {
                        FeiSuoNativeAd.this.loadListener.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, i + "", str).setInfo((Object) FeiSuoNativeAd.this.configInfo));
                    }
                }

                public void onLoad(List<IFissionNative> list) {
                    try {
                        FeiSuoNativeAd feiSuoNativeAd = FeiSuoNativeAd.this;
                        feiSuoNativeAd.showLog(feiSuoNativeAd.OooO00o, "onLoad");
                        FeiSuoNativeAd.this.OooO0Oo = list.get(0);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(FeiSuoNativeAd.this);
                        FeiSuoNativeAd.this.configInfo.OooO00o = arrayList;
                        FeiSuoNativeAd.this.OooO00o();
                        if (FeiSuoNativeAd.this.OooO0OO.OooO00o.OooOO0O == 1) {
                            FeiSuoNativeAd feiSuoNativeAd2 = FeiSuoNativeAd.this;
                            feiSuoNativeAd2.showLog(feiSuoNativeAd2.OooO00o, "price:" + FeiSuoNativeAd.this.OooO0Oo.getECpm());
                            FeiSuoNativeAd feiSuoNativeAd3 = FeiSuoNativeAd.this;
                            feiSuoNativeAd3.OooO0o0 = feiSuoNativeAd3.OooO0Oo.getECpm();
                            FeiSuoNativeAd.this.configInfo.setBiddingEcpm(FeiSuoNativeAd.this.OooO0Oo.getECpm());
                        }
                        FeiSuoNativeAd feiSuoNativeAd4 = FeiSuoNativeAd.this;
                        feiSuoNativeAd4.onAdCacheSuccess(feiSuoNativeAd4.configInfo);
                    } catch (Exception e) {
                        ooooO000.OooO00o(e);
                    }
                }
            });
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00oOoo
    public void notifyLoss(o00OO0OO o00oo0oo) {
        try {
            IFissionNative iFissionNative = this.OooO0Oo;
            if (iFissionNative != null) {
                iFissionNative.onBidFail(FeiSuoUtils.getFailInfo(o00oo0oo), "");
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0OO(this.OooO00o, "竞价回传_notifyLoss:" + FeiSuoUtils.getFailInfo(o00oo0oo));
                }
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00oOoo
    public void notifyWin(o00OO0OO o00oo0oo) {
        try {
            IFissionNative iFissionNative = this.OooO0Oo;
            if (iFissionNative != null) {
                iFissionNative.onBidSuccess(this.OooO0o0 + "");
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0OO(this.OooO00o, "竞价回传_notifyWin:" + this.OooO0o0);
                }
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public void onPause() {
        super.onPause();
        IFissionNative iFissionNative = this.OooO0Oo;
        if (iFissionNative != null) {
            iFissionNative.pause();
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public void onResume() {
        super.onResume();
        IFissionNative iFissionNative = this.OooO0Oo;
        if (iFissionNative != null) {
            iFissionNative.resume();
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public void regist(ViewGroup viewGroup, UMNNativeExtraInfo uMNNativeExtraInfo) {
        IFissionNative iFissionNative = this.OooO0Oo;
        if (iFissionNative != null) {
            iFissionNative.setNativeInteractionListener(viewGroup, uMNNativeExtraInfo.getClickViewList(), uMNNativeExtraInfo.getCreativeClickViewList(), (List) null, uMNNativeExtraInfo.getCloseView(), new IFissionNative.NativeInteractionListener() { // from class: com.ubixnow.network.feisuo.FeiSuoNativeAd.3
                public void onClick(View view) {
                    FeiSuoNativeAd feiSuoNativeAd = FeiSuoNativeAd.this;
                    feiSuoNativeAd.showLog(feiSuoNativeAd.OooO00o, "onAdClicked");
                    FeiSuoNativeAd.this.notifyAdClicked();
                }

                public void onCreativeClick(View view) {
                    FeiSuoNativeAd feiSuoNativeAd = FeiSuoNativeAd.this;
                    feiSuoNativeAd.showLog(feiSuoNativeAd.OooO00o, "onCreativeClick");
                    FeiSuoNativeAd.this.notifyAdClicked();
                }

                public void onShow() {
                    FeiSuoNativeAd feiSuoNativeAd = FeiSuoNativeAd.this;
                    feiSuoNativeAd.showLog(feiSuoNativeAd.OooO00o, "onAdShow");
                    FeiSuoNativeAd.this.notifyAdExposure();
                }

                public void onShowFailed(int i, String str) {
                    FeiSuoNativeAd feiSuoNativeAd = FeiSuoNativeAd.this;
                    feiSuoNativeAd.showLog(feiSuoNativeAd.OooO00o, "onShowFailed");
                }
            });
            this.OooO0Oo.setDownloadListener(new IFission.AppDownloadListener() { // from class: com.ubixnow.network.feisuo.FeiSuoNativeAd.4
                public void onDownloadActive(long j, long j2) {
                    FeiSuoNativeAd feiSuoNativeAd = FeiSuoNativeAd.this;
                    feiSuoNativeAd.showLog(feiSuoNativeAd.OooO00o, "onDownloadActive");
                    if (j2 > 0) {
                        try {
                            FeiSuoNativeAd.this.apkDownloadProgressUpdate((int) ((j * 100) / j2));
                        } catch (Throwable th) {
                            ooooO000.OooO00o(th);
                        }
                    }
                }

                public void onDownloadFail(int i, String str) {
                    FeiSuoNativeAd feiSuoNativeAd = FeiSuoNativeAd.this;
                    feiSuoNativeAd.showLog(feiSuoNativeAd.OooO00o, "onDownloadFail");
                    FeiSuoNativeAd.this.apkDownloadFailed();
                }

                public void onDownloadFinish() {
                    FeiSuoNativeAd feiSuoNativeAd = FeiSuoNativeAd.this;
                    feiSuoNativeAd.showLog(feiSuoNativeAd.OooO00o, "onDownloadFinish");
                    FeiSuoNativeAd.this.apkDownloadFinished();
                }

                public void onDownloadPause(long j, long j2) {
                    FeiSuoNativeAd feiSuoNativeAd = FeiSuoNativeAd.this;
                    feiSuoNativeAd.showLog(feiSuoNativeAd.OooO00o, "onDownloadPause");
                    FeiSuoNativeAd.this.apkDownloadPaused(0);
                }

                public void onDownloadStart() {
                    FeiSuoNativeAd feiSuoNativeAd = FeiSuoNativeAd.this;
                    feiSuoNativeAd.showLog(feiSuoNativeAd.OooO00o, "onDownloadStart");
                }

                public void onInstall() {
                    FeiSuoNativeAd feiSuoNativeAd = FeiSuoNativeAd.this;
                    feiSuoNativeAd.showLog(feiSuoNativeAd.OooO00o, "onInstall");
                    FeiSuoNativeAd.this.apkInstall();
                }
            });
            this.OooO0Oo.setDislikeListener(new IFissionNative.DislikeListener() { // from class: com.ubixnow.network.feisuo.FeiSuoNativeAd.5
                public void onDislike(int i, String str) {
                    FeiSuoNativeAd feiSuoNativeAd = FeiSuoNativeAd.this;
                    feiSuoNativeAd.showLog(feiSuoNativeAd.OooO00o, "onDislike");
                    FeiSuoNativeAd.this.notifyAdDislikeClick();
                }
            });
            this.OooO0Oo.setVideoListener(new IFission.VideoListener() { // from class: com.ubixnow.network.feisuo.FeiSuoNativeAd.6
                public void onVideoComplete() {
                    FeiSuoNativeAd feiSuoNativeAd = FeiSuoNativeAd.this;
                    feiSuoNativeAd.showLog(feiSuoNativeAd.OooO00o, "onVideoComplete");
                    FeiSuoNativeAd.this.notifyAdVideoEnd();
                }

                public void onVideoContinuePlay() {
                }

                public void onVideoError(int i, String str) {
                    FeiSuoNativeAd feiSuoNativeAd = FeiSuoNativeAd.this;
                    feiSuoNativeAd.showLog(feiSuoNativeAd.OooO00o, "onVideoError code:" + i + "  msg:" + str);
                    FeiSuoNativeAd.this.notifyAdVideoError();
                }

                public void onVideoPause() {
                }

                public void onVideoPlay() {
                    FeiSuoNativeAd feiSuoNativeAd = FeiSuoNativeAd.this;
                    feiSuoNativeAd.showLog(feiSuoNativeAd.OooO00o, "onVideoPlay");
                    FeiSuoNativeAd.this.notifyAdVideoStart();
                }
            });
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public void setVideoMute(boolean z) {
        IFissionNative iFissionNative = this.OooO0Oo;
        if (iFissionNative != null) {
            iFissionNative.setVideoMute(z);
        }
    }
}
