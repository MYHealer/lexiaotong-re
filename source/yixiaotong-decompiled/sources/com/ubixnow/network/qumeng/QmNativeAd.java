package com.ubixnow.network.qumeng;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.qumeng.advlib.api.AiClkAdManager;
import com.qumeng.advlib.core.AdRequestParam;
import com.qumeng.advlib.core.IMultiAdObject;
import com.qumeng.advlib.core.IMultiAdRequest;
import com.ubixnow.adtype.nativead.api.UMNNativeMaterial;
import com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd;
import com.ubixnow.core.bean.UMNNativeExtraInfo;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.oo000o;
import com.ubixnow.ooooo.ooooO000;
import com.ubixnow.utils.BaseUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class QmNativeAd extends UMNCustomNativeAd {
    private static final String OooO00o = "----QmNativeAd";
    public WeakReference<Context> OooO0O0;
    public AdRequestParam OooO0OO;
    public IMultiAdRequest OooO0Oo;
    public IMultiAdObject OooO0o0;

    public QmNativeAd(Context context, String str, String str2, final oo000o oo000oVar) {
        this.OooO0O0 = new WeakReference<>(context);
        this.configInfo = oo000oVar;
        showLog(OooO00o, "---slotId: " + str2);
        this.OooO0Oo = AiClkAdManager.getInstance().createAdRequest();
        this.OooO0OO = new AdRequestParam.Builder().adslotID(str2).adCount(1).adType(3).adLoadListener(new AdRequestParam.ADLoadListener() { // from class: com.ubixnow.network.qumeng.QmNativeAd.1
            public void onADLoaded(IMultiAdObject iMultiAdObject) {
                QmNativeAd.this.showLog(QmNativeAd.OooO00o, "---onADLoaded: ");
                if (iMultiAdObject != null) {
                    QmNativeAd qmNativeAd = QmNativeAd.this;
                    qmNativeAd.OooO0o0 = iMultiAdObject;
                    qmNativeAd.OooO0O0();
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(QmNativeAd.this);
                    oo000o oo000oVar2 = oo000oVar;
                    oo000oVar2.OooO00o = arrayList;
                    if (oo000oVar2.getBaseAdConfig().OooO00o.OooOO0O == 1) {
                        QmNativeAd.this.showLog(QmNativeAd.OooO00o, "price:" + iMultiAdObject.getECPM());
                        oo000oVar.setBiddingEcpm(iMultiAdObject.getECPM());
                    }
                } else {
                    oo000oVar.checkMaterialStatus = 7;
                }
                QmNativeAd.this.onAdCacheSuccess(oo000oVar);
            }

            public void onAdFailed(String str3) {
                QmNativeAd.this.showLog(QmNativeAd.OooO00o, "---onAdFailed: " + str3);
                if (QmNativeAd.this.loadListener != null) {
                    QmNativeAd.this.loadListener.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, "-1", str3).setInfo((Object) oo000oVar));
                }
            }
        }).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OooO0O0() {
        setUserName(this.OooO0o0.getAppName());
        setTitle(this.OooO0o0.getTitle());
        setAdSource("趣盟广告");
        setDescriptionText(this.OooO0o0.getDesc());
        setImageList4Url(this.OooO0o0.getImageUrls());
        setVideoUrl(this.OooO0o0.getVideoUrl());
        if (this.OooO0o0.getImageUrls() != null && this.OooO0o0.getImageUrls().size() > 0) {
            setMainImageUrl((String) this.OooO0o0.getImageUrls().get(0));
        }
        setVideoDuration(this.OooO0o0.getVideoDuration() * 1000);
        setIconImageUrl(this.OooO0o0.getAppLogoUrl());
        setDownloadUrl(this.OooO0o0.getDownloadUrl());
        setLandingPageUrl(this.OooO0o0.getLandingPageUrl());
        if (this.OooO0o0.getInteractionType() == 2) {
            setNativeInteractionType(1);
        }
        if (this.OooO0o0.getMaterialType() == 4 || this.OooO0o0.getMaterialType() == 9) {
            showLog(OooO00o, "-----Video");
            this.mAdSourceType = "1";
            if (this.OooO0o0.getMediaSize() != null) {
                setVideoWidth(((Integer) this.OooO0o0.getMediaSize().first).intValue());
                setVideoHeight(((Integer) this.OooO0o0.getMediaSize().second).intValue());
            }
        } else {
            showLog(OooO00o, "-----IMAGE_TYPE");
            this.mAdSourceType = "2";
            if (this.OooO0o0.getMediaSize() != null) {
                setMainImgWidth(((Integer) this.OooO0o0.getMediaSize().first).intValue());
                setMainImgHeight(((Integer) this.OooO0o0.getMediaSize().second).intValue());
            }
        }
        setVideoCoverUrl(this.OooO0o0.getVideoCoverImage());
        setAppPackageName(this.OooO0o0.getAppPackageName());
        setAdType(this.mAdSourceType);
        if (this.OooO0o0.getAppInformation() != null) {
            this.downloadAppinfo = new UMNNativeMaterial.DownloadAppinfo() { // from class: com.ubixnow.network.qumeng.QmNativeAd.2
                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                public String getAppName() {
                    return QmNativeAd.this.OooO0o0.getAppName();
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                public String getAppPublisher() {
                    return QmNativeAd.this.OooO0o0.getAppInformation().getDevelopers();
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                public long getAppSize() {
                    return 0L;
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                public String getAppVersionName() {
                    return QmNativeAd.this.OooO0o0.getAppInformation().getAppVersion();
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                public String getFunctionUrl() {
                    return QmNativeAd.this.OooO0o0.getAppInformation().getFunctionDescUrl();
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                public String getPermissionUrl() {
                    return QmNativeAd.this.OooO0o0.getAppInformation().getPermissionProtocolUrl();
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
                public String getPrivacyAgreementUrl() {
                    return QmNativeAd.this.OooO0o0.getAppInformation().getPrivacyProtocolUrl();
                }
            };
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public void clear(View view) {
        super.clear(view);
        onPause();
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00oOoo
    public void destroy() {
        super.destroy();
        showLog(OooO00o, "destroy");
        WeakReference<Context> weakReference = this.OooO0O0;
        if (weakReference != null) {
            weakReference.clear();
        }
        IMultiAdObject iMultiAdObject = this.OooO0o0;
        if (iMultiAdObject != null) {
            iMultiAdObject.destroy();
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public View getAdMediaView(Object... objArr) {
        IMultiAdObject iMultiAdObject;
        Context context;
        IMultiAdObject iMultiAdObject2 = this.OooO0o0;
        if (iMultiAdObject2 == null || !(iMultiAdObject2.getMaterialType() == 4 || this.OooO0o0.getMaterialType() == 9)) {
            return super.getAdMediaView(objArr);
        }
        WeakReference<Context> weakReference = this.OooO0O0;
        if (weakReference == null || weakReference.get() == null) {
            iMultiAdObject = this.OooO0o0;
            context = BaseUtils.getContext();
        } else {
            iMultiAdObject = this.OooO0o0;
            context = this.OooO0O0.get();
        }
        return iMultiAdObject.getVideoView(context);
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd
    public View getShakeView(View view) {
        try {
            Method declaredMethod = IMultiAdObject.class.getDeclaredMethod("getTwistView", Context.class);
            declaredMethod.setAccessible(true);
            View view2 = (View) declaredMethod.invoke(this.OooO0o0, BaseUtils.getContext());
            if (view2 == null) {
                return null;
            }
            view2.setAlpha(0.0f);
            ViewGroup viewGroup = (ViewGroup) getNativeShakeView(BaseUtils.getContext());
            viewGroup.addView(view2);
            return viewGroup;
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
            return null;
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public boolean isNativeExpress() {
        return false;
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd
    public boolean isValid() {
        if (this.OooO0o0 == null) {
            ooooO000.OooO0OO(OooO00o, "multiAdObject == null ");
            return false;
        }
        try {
            if (ooooO000.OooO00o) {
                ooooO000.OooO0OO(OooO00o, "---isValid " + this.OooO0o0.isValid());
            }
            return this.OooO0o0.isValid();
        } catch (Throwable unused) {
            return true;
        }
    }

    public void loadNativeAd(o00O00o0 o00o00o0) {
        AdRequestParam adRequestParam;
        this.loadListener = o00o00o0;
        showLog(OooO00o, "loadAd " + (this.OooO0Oo != null));
        IMultiAdRequest iMultiAdRequest = this.OooO0Oo;
        if (iMultiAdRequest == null || (adRequestParam = this.OooO0OO) == null) {
            return;
        }
        iMultiAdRequest.invokeADV(adRequestParam);
    }

    @Override // com.ubixnow.ooooo.o00oOoo
    public void notifyLoss(o00OO0OO o00oo0oo) {
        try {
            if (this.OooO0o0 != null) {
                QmBiddingUtils.QmBiddingFeedbackBean failInfo = QmBiddingUtils.getFailInfo(o00oo0oo);
                this.OooO0o0.lossNotice(failInfo.OooO00o, failInfo.OooO0O0, failInfo.OooO0OO);
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0OO(OooO00o, "竞价回传_notifyLoss:胜出者价格:" + failInfo.OooO00o + "  竞价失败原因:" + failInfo.OooO0O0 + "  胜出者:" + failInfo.OooO0OO);
                }
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00oOoo
    public void notifyWin(o00OO0OO o00oo0oo) {
        try {
            IMultiAdObject iMultiAdObject = this.OooO0o0;
            if (iMultiAdObject != null) {
                iMultiAdObject.winNotice(QmBiddingUtils.getSecondPrice(o00oo0oo));
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0OO(OooO00o, "竞价回传_notifyWin:" + QmBiddingUtils.getSecondPrice(o00oo0oo));
                }
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public void regist(ViewGroup viewGroup, UMNNativeExtraInfo uMNNativeExtraInfo) {
        IMultiAdObject iMultiAdObject = this.OooO0o0;
        if (iMultiAdObject != null) {
            iMultiAdObject.bindEvent(viewGroup, uMNNativeExtraInfo.getClickViewList(), new IMultiAdObject.ADEventListener() { // from class: com.ubixnow.network.qumeng.QmNativeAd.3
                public void onADExposed() {
                    QmNativeAd.this.notifyAdExposure();
                }

                public void onAdClick() {
                    QmNativeAd.this.notifyAdClicked();
                }

                public void onAdFailed(String str) {
                }
            });
            this.OooO0o0.setOnMediaStateListener(new IMultiAdObject.MediaStateListener() { // from class: com.ubixnow.network.qumeng.QmNativeAd.4
                public void onVideoCompleted() {
                    QmNativeAd.this.showLog(QmNativeAd.OooO00o, "onVideoCompleted");
                    QmNativeAd.this.notifyAdVideoEnd();
                }

                public void onVideoPause() {
                    QmNativeAd.this.showLog(QmNativeAd.OooO00o, "onVideoPause");
                }

                public void onVideoReady() {
                    QmNativeAd.this.showLog(QmNativeAd.OooO00o, "onVideoReady");
                }

                public void onVideoResume() {
                    QmNativeAd.this.showLog(QmNativeAd.OooO00o, "onVideoResume");
                }

                public void onVideoStart() {
                    QmNativeAd.this.showLog(QmNativeAd.OooO00o, "onVideoStart");
                    QmNativeAd.this.notifyAdVideoStart();
                }

                public void onVideoStop() {
                    QmNativeAd.this.showLog(QmNativeAd.OooO00o, "onVideoStop");
                }
            });
        }
    }
}
