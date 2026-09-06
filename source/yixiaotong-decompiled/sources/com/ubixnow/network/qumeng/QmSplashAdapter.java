package com.ubixnow.network.qumeng;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import com.huawei.openalliance.ad.constant.br;
import com.qumeng.advlib.api.AiClkAdManager;
import com.qumeng.advlib.core.AdRequestParam;
import com.qumeng.advlib.core.IMultiAdObject;
import com.qumeng.advlib.core.IMultiAdRequest;
import com.ubixnow.adtype.splash.api.UMNSplashParams;
import com.ubixnow.adtype.splash.custom.UMNCustomSplashAdapter;
import com.ubixnow.core.api.UbixDefaultConstants;
import com.ubixnow.core.common.BaseDevConfig;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o000O0O0;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.ooooO000;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class QmSplashAdapter extends UMNCustomSplashAdapter {
    private final String OooO00o = this.customTag + QmInitManager.getInstance().getName();
    private IMultiAdObject OooO0O0;

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd(Context context) {
        int i;
        showLog(this.OooO00o, "start_loadAd");
        Bundle bundle = new Bundle();
        BaseDevConfig baseDevConfig = this.mBaseAdConfig.OooO0o0;
        if ((baseDevConfig instanceof UMNSplashParams) && (i = ((UMNSplashParams) baseDevConfig).skipTime) >= UbixDefaultConstants.splashSkipTime) {
            bundle.putInt("countdown_time", i);
        }
        AdRequestParam adRequestParamBuild = new AdRequestParam.Builder().adslotID(this.mBaseAdConfig.OooO00o.OooO0o0).adType(6).adLoadListener(new AdRequestParam.ADLoadListener() { // from class: com.ubixnow.network.qumeng.QmSplashAdapter.2
            public void onADLoaded(IMultiAdObject iMultiAdObject) {
                QmSplashAdapter qmSplashAdapter = QmSplashAdapter.this;
                qmSplashAdapter.showLog(qmSplashAdapter.OooO00o, "onADLoaded ");
                QmSplashAdapter qmSplashAdapter2 = QmSplashAdapter.this;
                if (qmSplashAdapter2.loadListener != null) {
                    if (iMultiAdObject != null) {
                        qmSplashAdapter2.OooO0O0 = iMultiAdObject;
                        QmSplashAdapter.this.splashInfo.material = QmUtils.getMaterialInfo(iMultiAdObject);
                        QmSplashAdapter qmSplashAdapter3 = QmSplashAdapter.this;
                        if (qmSplashAdapter3.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                            qmSplashAdapter3.showLog(qmSplashAdapter3.OooO00o, "price:" + iMultiAdObject.getECPM());
                            QmSplashAdapter.this.splashInfo.setBiddingEcpm(iMultiAdObject.getECPM());
                        }
                    } else {
                        qmSplashAdapter2.splashInfo.checkMaterialStatus = 7;
                    }
                    QmSplashAdapter qmSplashAdapter4 = QmSplashAdapter.this;
                    qmSplashAdapter4.loadListener.onAdCacheSuccess(qmSplashAdapter4.splashInfo);
                }
            }

            public void onAdFailed(String str) {
                QmSplashAdapter qmSplashAdapter = QmSplashAdapter.this;
                qmSplashAdapter.showLog(qmSplashAdapter.OooO00o, "onError: code msg:" + str);
                o00O00o0 o00o00o0 = QmSplashAdapter.this.loadListener;
                if (o00o00o0 != null) {
                    o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, oOO00O0.ubix_no_ad, str).setInfo((Object) QmSplashAdapter.this.splashInfo));
                }
            }
        }).extraBundle(bundle).build();
        IMultiAdRequest iMultiAdRequestCreateAdRequest = AiClkAdManager.getInstance().createAdRequest();
        if (iMultiAdRequestCreateAdRequest != null) {
            iMultiAdRequestCreateAdRequest.invokeADV(adRequestParamBuild);
        }
    }

    @Override // com.ubixnow.ooooo.o00OO00O, com.ubixnow.ooooo.o00O
    public void destory() {
        if (ooooO000.OooO00o) {
            showLog(this.OooO00o, "destory");
        }
        try {
            IMultiAdObject iMultiAdObject = this.OooO0O0;
            if (iMultiAdObject != null) {
                iMultiAdObject.destroy();
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00O
    public boolean isValid() {
        if (this.OooO0O0 == null) {
            ooooO000.OooO0OO(this.OooO00o, "multiAdObject == null ");
            return false;
        }
        try {
            if (ooooO000.OooO00o) {
                ooooO000.OooO0OO(this.OooO00o, "---isValid " + this.OooO0O0.isValid());
            }
            return this.OooO0O0.isValid();
        } catch (Throwable unused) {
            return true;
        }
    }

    @Override // com.ubixnow.ooooo.o00OO00O
    public void loadSplashAd(final Context context, o00O000 o00o000) {
        createSplashInfo(o00o000);
        QmInitManager.getInstance().initSDK(context, o00o000, new o00O0OO0() { // from class: com.ubixnow.network.qumeng.QmSplashAdapter.1
            @Override // com.ubixnow.ooooo.o00O0OO0
            public void onError(Throwable th) {
                o00O00o0 o00o00o0 = QmSplashAdapter.this.loadListener;
                if (o00o00o0 != null) {
                    o00o00o0.onNoAdError(QmInitManager.getErrorInfo(th.getMessage()).setInfo((Object) QmSplashAdapter.this.splashInfo));
                }
            }

            @Override // com.ubixnow.ooooo.o00O0OO0
            public void onSuccess() {
                QmSplashAdapter.this.loadAd(context);
            }
        });
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyLoss(o00OO0OO o00oo0oo) {
        try {
            if (this.OooO0O0 != null) {
                QmBiddingUtils.QmBiddingFeedbackBean failInfo = QmBiddingUtils.getFailInfo(o00oo0oo);
                this.OooO0O0.lossNotice(failInfo.OooO00o, failInfo.OooO0O0, failInfo.OooO0OO);
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0OO(this.OooO00o, "竞价回传_notifyLoss:胜出者价格:" + failInfo.OooO00o + "  竞价失败原因:" + failInfo.OooO0O0 + "  胜出者:" + failInfo.OooO0OO);
                }
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyWin(o00OO0OO o00oo0oo) {
        try {
            IMultiAdObject iMultiAdObject = this.OooO0O0;
            if (iMultiAdObject != null) {
                iMultiAdObject.winNotice(QmBiddingUtils.getSecondPrice(o00oo0oo));
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0OO(this.OooO00o, "竞价回传_notifyWin:" + QmBiddingUtils.getSecondPrice(o00oo0oo));
                }
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    @Override // com.ubixnow.ooooo.o00OO00O
    public void show(ViewGroup viewGroup) {
        showLog(this.OooO00o, "prepare show");
        if (this.OooO0O0 != null && viewGroup != null) {
            showLog(this.OooO00o, br.b.V);
            this.OooO0O0.showSplashView(viewGroup, new IMultiAdObject.SplashEventListener() { // from class: com.ubixnow.network.qumeng.QmSplashAdapter.3
                public void onObClicked() {
                    QmSplashAdapter qmSplashAdapter = QmSplashAdapter.this;
                    qmSplashAdapter.showLog(qmSplashAdapter.OooO00o, "onAdClicked");
                    if (QmSplashAdapter.this.eventListener != null) {
                        QmSplashAdapter.this.eventListener.onAdClick(QmSplashAdapter.this.splashInfo);
                    }
                }

                public void onObShow() {
                    QmSplashAdapter qmSplashAdapter = QmSplashAdapter.this;
                    qmSplashAdapter.showLog(qmSplashAdapter.OooO00o, "onObShow");
                    if (QmSplashAdapter.this.eventListener != null) {
                        QmSplashAdapter.this.eventListener.onAdShow(QmSplashAdapter.this.splashInfo);
                    }
                }

                public void onObSkip() {
                    QmSplashAdapter qmSplashAdapter = QmSplashAdapter.this;
                    qmSplashAdapter.showLog(qmSplashAdapter.OooO00o, "onObSkip");
                    if (QmSplashAdapter.this.eventListener != null) {
                        QmSplashAdapter qmSplashAdapter2 = QmSplashAdapter.this;
                        qmSplashAdapter2.splashInfo.OooO00o = true;
                        qmSplashAdapter2.eventListener.onAdDismiss(QmSplashAdapter.this.splashInfo);
                    }
                }

                public void onObTimeOver() {
                    QmSplashAdapter qmSplashAdapter = QmSplashAdapter.this;
                    qmSplashAdapter.showLog(qmSplashAdapter.OooO00o, "onObTimeOver");
                    if (QmSplashAdapter.this.eventListener != null) {
                        QmSplashAdapter qmSplashAdapter2 = QmSplashAdapter.this;
                        qmSplashAdapter2.splashInfo.OooO00o = false;
                        qmSplashAdapter2.eventListener.onAdDismiss(QmSplashAdapter.this.splashInfo);
                    }
                }
            });
            return;
        }
        showLog(this.OooO00o, "showError");
        o000O0O0 o000o0o0 = this.eventListener;
        if (o000o0o0 != null) {
            o000o0o0.onShowError(new ErrorInfo(oOO00O0.ubix_show_error, oOO00O0.ubix_show_error_msg, oOO00O0.ubix_show_error, oOO00O0.ubix_show_error_msg).setInfo((Object) this.splashInfo));
        }
    }
}
