package com.ubixnow.network.baidu;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.INativeVideoListener;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.XNativeView;
import com.stub.StubApp;
import com.ubixnow.adtype.nativead.api.UMNNativeMaterial;
import com.ubixnow.adtype.nativead.api.UMNNativeParams;
import com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd;
import com.ubixnow.core.bean.UMNNativeExtraInfo;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.oo000o;
import com.ubixnow.ooooo.ooooO000;
import com.ubixnow.utils.BaseUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class BdNativeAd extends UMNCustomNativeAd {
    private final String OooO00o = "-----BdNativeAd";
    public BaiduNativeManager OooO0O0;
    public NativeResponse OooO0OO;
    public XNativeView OooO0Oo;
    private long OooO0o0;

    public BdNativeAd(Context context, UMNNativeParams uMNNativeParams, String str, oo000o oo000oVar) {
        this.configInfo = oo000oVar;
        this.OooO0O0 = new BaiduNativeManager(StubApp.getOrigApplicationContext(context.getApplicationContext()), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OooO00o(final NativeResponse nativeResponse) {
        String str;
        setUserName(nativeResponse.getBrandName());
        setTitle(nativeResponse.getTitle());
        setAdSource("百度广告");
        setDescriptionText(nativeResponse.getDesc());
        setMainImageUrl(nativeResponse.getImageUrl());
        setImageList4Url(nativeResponse.getMultiPicUrls());
        if (TextUtils.isEmpty(nativeResponse.getImageUrl()) && nativeResponse.getMultiPicUrls() != null && !nativeResponse.getMultiPicUrls().isEmpty()) {
            setMainImageUrl(nativeResponse.getMultiPicUrls().get(0));
        }
        setMainImgHeight(nativeResponse.getMainPicHeight());
        setMainImgWidth(nativeResponse.getMainPicWidth());
        setIconImageUrl(nativeResponse.getIconUrl());
        setVideoUrl(nativeResponse.getVideoUrl());
        setButtonText(nativeResponse.getActButtonString());
        setAppPackageName(nativeResponse.getAppPackage());
        if (nativeResponse.getMaterialType() == NativeResponse.MaterialType.VIDEO) {
            showLog(this.OooO00o, "-----Video");
            str = "1";
        } else {
            showLog(this.OooO00o, "-----Image");
            str = "2";
        }
        this.mAdSourceType = str;
        if (nativeResponse.getAdActionType() == 2) {
            setNativeInteractionType(1);
        } else if (nativeResponse.getAdActionType() == 1) {
            setNativeInteractionType(2);
        }
        setAdType(this.mAdSourceType);
        this.downloadAppinfo = new UMNNativeMaterial.DownloadAppinfo() { // from class: com.ubixnow.network.baidu.BdNativeAd.3
            @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
            public String getAppName() {
                return nativeResponse.getBrandName();
            }

            @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
            public String getAppPublisher() {
                return nativeResponse.getPublisher();
            }

            @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
            public long getAppSize() {
                return nativeResponse.getAppSize();
            }

            @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
            public String getAppVersionName() {
                return nativeResponse.getAppVersion();
            }

            @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
            public String getFunctionUrl() {
                try {
                    Method declaredMethod = NativeResponse.class.getDeclaredMethod("getAppFunctionLink", new Class[0]);
                    declaredMethod.setAccessible(true);
                    return (String) declaredMethod.invoke(nativeResponse, new Object[0]);
                } catch (Exception e) {
                    ooooO000.OooO00o(e);
                    return "";
                }
            }

            @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
            public String getPermissionUrl() {
                return nativeResponse.getAppPermissionLink();
            }

            @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial.DownloadAppinfo
            public String getPrivacyAgreementUrl() {
                return nativeResponse.getAppPrivacyLink();
            }
        };
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public View getAdMediaView(Object... objArr) {
        Context context = BaseUtils.getContext();
        if (!this.mAdSourceType.equals("1")) {
            return super.getAdMediaView(objArr);
        }
        XNativeView xNativeView = new XNativeView(context);
        this.OooO0Oo = xNativeView;
        oo000o oo000oVar = this.configInfo;
        if (oo000oVar != null && oo000oVar.isMuteIndependent) {
            xNativeView.setVideoMute(oo000oVar.getBaseAdConfig().OooOOO0.Oooo0OO);
        } else if (oo000oVar != null && oo000oVar.getBaseAdConfig() != null && this.configInfo.getBaseAdConfig().OooOOO0 != null) {
            showLog(this.OooO00o, "---isMute " + this.configInfo.getBaseAdConfig().OooOOO0.Oooo0OO);
            xNativeView = this.OooO0Oo;
            oo000oVar = this.configInfo;
            xNativeView.setVideoMute(oo000oVar.getBaseAdConfig().OooOOO0.Oooo0OO);
        }
        setVideoDuration(this.OooO0OO.getDuration() * 1000);
        this.OooO0Oo.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.OooO0Oo.setNativeItem(this.OooO0OO);
        this.OooO0Oo.render();
        setVideoWidth(this.OooO0Oo.getWidth());
        setVideoHeight(this.OooO0Oo.getHeight());
        showLog(this.OooO00o, "video width:" + this.OooO0Oo.getWidth() + "  video height:" + this.OooO0Oo.getHeight());
        this.OooO0Oo.setNativeVideoListener(new INativeVideoListener() { // from class: com.ubixnow.network.baidu.BdNativeAd.4
            @Override // com.baidu.mobads.sdk.api.INativeVideoListener
            public void onCompletion() {
                BdNativeAd bdNativeAd = BdNativeAd.this;
                bdNativeAd.showLog(bdNativeAd.OooO00o, "onCompletion");
                BdNativeAd.this.notifyAdVideoEnd();
            }

            @Override // com.baidu.mobads.sdk.api.INativeVideoListener
            public void onError() {
                BdNativeAd bdNativeAd = BdNativeAd.this;
                bdNativeAd.showLog(bdNativeAd.OooO00o, "onVideoError");
                BdNativeAd.this.notifyAdVideoError();
            }

            @Override // com.baidu.mobads.sdk.api.INativeVideoListener
            public void onPause() {
                BdNativeAd bdNativeAd = BdNativeAd.this;
                bdNativeAd.showLog(bdNativeAd.OooO00o, "onPause");
            }

            @Override // com.baidu.mobads.sdk.api.INativeVideoListener
            public void onRenderingStart() {
                BdNativeAd bdNativeAd = BdNativeAd.this;
                bdNativeAd.showLog(bdNativeAd.OooO00o, "onRenderingStart");
                BdNativeAd.this.notifyAdVideoStart();
            }

            @Override // com.baidu.mobads.sdk.api.INativeVideoListener
            public void onResume() {
                BdNativeAd bdNativeAd = BdNativeAd.this;
                bdNativeAd.showLog(bdNativeAd.OooO00o, "onResume");
            }
        });
        return this.OooO0Oo;
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd
    public View getShakeView(View view) {
        try {
            NativeResponse nativeResponse = this.OooO0OO;
            if (nativeResponse != null) {
                return nativeResponse.renderShakeView(80, 80, new NativeResponse.AdShakeViewListener() { // from class: com.ubixnow.network.baidu.BdNativeAd.2
                    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdShakeViewListener
                    public void onDismiss() {
                        BdNativeAd bdNativeAd = BdNativeAd.this;
                        bdNativeAd.showLog(bdNativeAd.OooO00o, "shake view dismiss!");
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

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd
    public boolean isValid() {
        NativeResponse nativeResponse = this.OooO0OO;
        if (nativeResponse != null) {
            return nativeResponse.isReady(BaseUtils.getContext());
        }
        return false;
    }

    public void loadAd(String str, final o00O00o0 o00o00o0, final oo000o oo000oVar) {
        this.loadListener = o00o00o0;
        BaiduNativeManager.FeedAdListener feedAdListener = new BaiduNativeManager.FeedAdListener() { // from class: com.ubixnow.network.baidu.BdNativeAd.1
            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onLpClosed() {
            }

            public void onNativeFail(int i, String str2) {
                BdNativeAd bdNativeAd = BdNativeAd.this;
                bdNativeAd.showLog(bdNativeAd.OooO00o, " onError " + str2);
                o00O00o0 o00o00o1 = o00o00o0;
                if (o00o00o1 != null) {
                    o00o00o1.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, i + "", str2).setInfo((Object) oo000oVar));
                }
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onNativeFail(int i, String str2, NativeResponse nativeResponse) {
                BdNativeAd bdNativeAd = BdNativeAd.this;
                bdNativeAd.showLog(bdNativeAd.OooO00o, " onError " + str2);
                o00O00o0 o00o00o1 = o00o00o0;
                if (o00o00o1 != null) {
                    o00o00o1.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, i + "", str2).setInfo((Object) oo000oVar));
                }
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onNativeLoad(List<NativeResponse> list) {
                if (list == null || list.isEmpty()) {
                    return;
                }
                BdNativeAd.this.OooO0OO = list.get(0);
                BdNativeAd bdNativeAd = BdNativeAd.this;
                bdNativeAd.OooO00o(bdNativeAd.OooO0OO);
                BdNativeAd bdNativeAd2 = BdNativeAd.this;
                bdNativeAd2.showLog(bdNativeAd2.OooO00o, "onADLoaded nativeInfo " + oo000oVar.hashCode());
                try {
                    if (oo000oVar.getBaseAdConfig().OooO00o.OooOO0O == 1) {
                        BdNativeAd bdNativeAd3 = BdNativeAd.this;
                        bdNativeAd3.OooO0o0 = bdNativeAd3.getIntegerValue(bdNativeAd3.OooO0OO.getECPMLevel());
                        BdNativeAd bdNativeAd4 = BdNativeAd.this;
                        bdNativeAd4.showLog(bdNativeAd4.OooO00o, "price:" + BdNativeAd.this.OooO0o0);
                        oo000oVar.setBiddingEcpm((int) BdNativeAd.this.OooO0o0);
                    }
                } catch (Exception e) {
                    ooooO000.OooO00o(e);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(BdNativeAd.this);
                oo000o oo000oVar2 = oo000oVar;
                oo000oVar2.OooO00o = arrayList;
                BdNativeAd.this.onAdCacheSuccess(oo000oVar2);
            }

            public void onNoAd(int i, String str2) {
                BdNativeAd bdNativeAd = BdNativeAd.this;
                bdNativeAd.showLog(bdNativeAd.OooO00o, " onError " + str2);
                o00O00o0 o00o00o1 = o00o00o0;
                if (o00o00o1 != null) {
                    o00o00o1.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, i + "", str2).setInfo((Object) oo000oVar));
                }
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onNoAd(int i, String str2, NativeResponse nativeResponse) {
                BdNativeAd bdNativeAd = BdNativeAd.this;
                bdNativeAd.showLog(bdNativeAd.OooO00o, " onError " + str2);
                o00O00o0 o00o00o1 = o00o00o0;
                if (o00o00o1 != null) {
                    o00o00o1.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, i + "", str2).setInfo((Object) oo000oVar));
                }
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onVideoDownloadFailed() {
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onVideoDownloadSuccess() {
            }
        };
        try {
            this.OooO0O0.setAppSid(oo000oVar.getBaseAdConfig().OooO00o.OooO0Oo);
            if (oo000oVar.getBaseAdConfig().OooO00o.OooOO0O == 1) {
                this.OooO0O0.setBidFloor((int) oo000oVar.getBaseAdConfig().OooO);
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
        this.OooO0O0.loadFeedAd(null, feedAdListener);
    }

    @Override // com.ubixnow.ooooo.o00oOoo
    public void notifyLoss(o00OO0OO o00oo0oo) {
    }

    @Override // com.ubixnow.ooooo.o00oOoo
    public void notifyWin(o00OO0OO o00oo0oo) {
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public void onPause() {
        showLog(this.OooO00o, "onPause");
        XNativeView xNativeView = this.OooO0Oo;
        if (xNativeView != null) {
            xNativeView.pause();
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public void onResume() {
        if (this.OooO0Oo != null) {
            showLog(this.OooO00o, "onResume");
            this.OooO0Oo.resume();
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public void pauseVideo() {
        showLog(this.OooO00o, "pauseVideo");
        try {
            XNativeView xNativeView = this.OooO0Oo;
            if (xNativeView != null) {
                xNativeView.pause();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public void regist(ViewGroup viewGroup, UMNNativeExtraInfo uMNNativeExtraInfo) {
        NativeResponse nativeResponse = this.OooO0OO;
        if (nativeResponse != null) {
            nativeResponse.registerViewForInteraction(viewGroup, uMNNativeExtraInfo.getClickViewList(), uMNNativeExtraInfo.getCreativeClickViewList(), new NativeResponse.AdInteractionListener() { // from class: com.ubixnow.network.baidu.BdNativeAd.5
                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                public void adActReward(int i) {
                    BdNativeAd bdNativeAd = BdNativeAd.this;
                    bdNativeAd.showLog(bdNativeAd.OooO00o, "adActReward");
                }

                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                public void adActRewardSuccess() {
                    BdNativeAd bdNativeAd = BdNativeAd.this;
                    bdNativeAd.showLog(bdNativeAd.OooO00o, "adActRewardSuccess");
                }

                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                public void onADExposed() {
                    BdNativeAd bdNativeAd = BdNativeAd.this;
                    bdNativeAd.showLog(bdNativeAd.OooO00o, "onAdShow");
                    BdNativeAd.this.notifyAdExposure();
                }

                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                public void onADExposureFailed(int i) {
                    BdNativeAd bdNativeAd = BdNativeAd.this;
                    bdNativeAd.showLog(bdNativeAd.OooO00o, "onADExposureFailed");
                }

                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                public void onADStatusChanged() {
                    BdNativeAd bdNativeAd = BdNativeAd.this;
                    bdNativeAd.showLog(bdNativeAd.OooO00o, "onADStatusChanged");
                }

                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                public void onAdClick() {
                    BdNativeAd bdNativeAd = BdNativeAd.this;
                    bdNativeAd.showLog(bdNativeAd.OooO00o, "onAdClicked");
                    BdNativeAd.this.notifyAdClicked();
                }

                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                public void onAdUnionClick() {
                    BdNativeAd bdNativeAd = BdNativeAd.this;
                    bdNativeAd.showLog(bdNativeAd.OooO00o, "onAdUnionClick");
                }
            });
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public void resumeVideo() {
        showLog(this.OooO00o, "resumeVideo");
        try {
            XNativeView xNativeView = this.OooO0Oo;
            if (xNativeView != null) {
                xNativeView.resume();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public void setVideoMute(boolean z) {
        showLog(this.OooO00o, "setVideoMute:" + z);
        try {
            XNativeView xNativeView = this.OooO0Oo;
            if (xNativeView != null) {
                xNativeView.setVideoMute(z);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public void startVideo() {
        showLog(this.OooO00o, "startVideo");
        try {
            XNativeView xNativeView = this.OooO0Oo;
            if (xNativeView != null) {
                Method declaredMethod = xNativeView.getClass().getDeclaredMethod("play", new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(this.OooO0Oo, new Object[0]);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd, com.ubixnow.ooooo.o00Ooo
    public void stopVideo() {
        showLog(this.OooO00o, "stopVideo");
        try {
            XNativeView xNativeView = this.OooO0Oo;
            if (xNativeView != null) {
                xNativeView.stop();
            }
        } catch (Throwable unused) {
        }
    }
}
