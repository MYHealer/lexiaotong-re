package com.ubixnow.network.qumeng;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.huawei.openalliance.ad.constant.h;
import com.qumeng.advlib.api.AiClkAdManager;
import com.qumeng.advlib.core.AdRequestParam;
import com.qumeng.advlib.core.IMultiAdObject;
import com.qumeng.advlib.core.IMultiAdRequest;
import com.ubixnow.adtype.interstital.api.UMNInterstitalParams;
import com.ubixnow.adtype.interstital.custom.UMNCustomInterstitalAdapter;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.ooooO000;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class QmInterstitalAdapter extends UMNCustomInterstitalAdapter {
    private final String OooO00o = this.customTag + getClass().getSimpleName();
    private IMultiAdObject OooO0O0;
    private o00O000 OooO0OO;

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd() {
        showLog(this.OooO00o, h.Code);
        AdRequestParam adRequestParamBuild = new AdRequestParam.Builder().adslotID(this.adsSlotid).adType(2).adLoadListener(new AdRequestParam.ADLoadListener() { // from class: com.ubixnow.network.qumeng.QmInterstitalAdapter.2
            public void onADLoaded(IMultiAdObject iMultiAdObject) {
                QmInterstitalAdapter qmInterstitalAdapter = QmInterstitalAdapter.this;
                qmInterstitalAdapter.showLog(qmInterstitalAdapter.OooO00o, "onADLoaded: ");
                QmInterstitalAdapter qmInterstitalAdapter2 = QmInterstitalAdapter.this;
                if (qmInterstitalAdapter2.loadListener != null) {
                    if (iMultiAdObject != null) {
                        qmInterstitalAdapter2.OooO0O0 = iMultiAdObject;
                        QmInterstitalAdapter.this.absUbixInfo.material = QmUtils.getMaterialInfo(iMultiAdObject);
                        QmInterstitalAdapter qmInterstitalAdapter3 = QmInterstitalAdapter.this;
                        if (qmInterstitalAdapter3.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                            qmInterstitalAdapter3.showLog(qmInterstitalAdapter3.OooO00o, "price:" + QmInterstitalAdapter.this.OooO0O0.getECPM());
                            QmInterstitalAdapter qmInterstitalAdapter4 = QmInterstitalAdapter.this;
                            qmInterstitalAdapter4.absUbixInfo.setBiddingEcpm(qmInterstitalAdapter4.OooO0O0.getECPM());
                        }
                    } else {
                        qmInterstitalAdapter2.absUbixInfo.checkMaterialStatus = 7;
                    }
                    QmInterstitalAdapter qmInterstitalAdapter5 = QmInterstitalAdapter.this;
                    qmInterstitalAdapter5.loadListener.onAdCacheSuccess(qmInterstitalAdapter5.absUbixInfo);
                }
            }

            public void onAdFailed(String str) {
                QmInterstitalAdapter qmInterstitalAdapter = QmInterstitalAdapter.this;
                qmInterstitalAdapter.showLog(qmInterstitalAdapter.OooO00o, "onError: code msg:" + str);
                o00O00o0 o00o00o0 = QmInterstitalAdapter.this.loadListener;
                if (o00o00o0 != null) {
                    o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, "-1", str).setInfo((Object) QmInterstitalAdapter.this.absUbixInfo));
                }
            }
        }).build();
        IMultiAdRequest iMultiAdRequestCreateAdRequest = AiClkAdManager.getInstance().createAdRequest();
        if (iMultiAdRequestCreateAdRequest != null) {
            iMultiAdRequestCreateAdRequest.invokeADV(adRequestParamBuild);
        }
    }

    @Override // com.ubixnow.ooooo.o00O
    public void destory() {
        try {
            showLog(this.OooO00o, "--destory: ");
            IMultiAdObject iMultiAdObject = this.OooO0O0;
            if (iMultiAdObject != null) {
                iMultiAdObject.destroy();
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    @Override // com.ubixnow.ooooo.o00O
    public boolean isValid() {
        if (this.OooO0O0 == null) {
            ooooO000.OooO0OO(this.OooO00o, "adObj == null ");
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

    @Override // com.ubixnow.adtype.interstital.custom.UMNCustomInterstitalAdapter
    public void loadInterstitalAd(Context context, o00O000 o00o000) {
        this.OooO0OO = o00o000;
        createADInfo(o00o000);
        QmInitManager.getInstance().initSDK(context, o00o000, new o00O0OO0() { // from class: com.ubixnow.network.qumeng.QmInterstitalAdapter.1
            @Override // com.ubixnow.ooooo.o00O0OO0
            public void onError(Throwable th) {
                o00O00o0 o00o00o0 = QmInterstitalAdapter.this.loadListener;
                if (o00o00o0 != null) {
                    o00o00o0.onNoAdError(QmInitManager.getErrorInfo(th.getMessage()).setInfo((Object) QmInterstitalAdapter.this.absUbixInfo));
                }
            }

            @Override // com.ubixnow.ooooo.o00O0OO0
            public void onSuccess() {
                QmInterstitalAdapter.this.loadAd();
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

    @Override // com.ubixnow.adtype.interstital.custom.UMNCustomInterstitalAdapter
    public void show(Activity activity) {
        IMultiAdObject iMultiAdObject = this.OooO0O0;
        if (iMultiAdObject != null) {
            iMultiAdObject.showInteractionAd(activity, new AdRequestParam.ADInteractionListener() { // from class: com.ubixnow.network.qumeng.QmInterstitalAdapter.3
                public void onADExposed() {
                    QmInterstitalAdapter qmInterstitalAdapter = QmInterstitalAdapter.this;
                    qmInterstitalAdapter.showLog(qmInterstitalAdapter.OooO00o, "--onADExposed: ");
                    if (QmInterstitalAdapter.this.eventListener != null) {
                        QmInterstitalAdapter.this.eventListener.onAdShow(QmInterstitalAdapter.this.absUbixInfo);
                    }
                }

                public void onAdClick() {
                    QmInterstitalAdapter qmInterstitalAdapter = QmInterstitalAdapter.this;
                    qmInterstitalAdapter.showLog(qmInterstitalAdapter.OooO00o, "--onAdClick: ");
                    if (QmInterstitalAdapter.this.eventListener != null) {
                        QmInterstitalAdapter.this.eventListener.onAdClick(QmInterstitalAdapter.this.absUbixInfo);
                    }
                    if ((QmInterstitalAdapter.this.OooO0OO.OooO0o0 instanceof UMNInterstitalParams) && ((UMNInterstitalParams) QmInterstitalAdapter.this.OooO0OO.OooO0o0).closeAfterClick) {
                        AiClkAdManager.getInstance().closeInteractionAd(QmInterstitalAdapter.this.OooO0O0);
                    }
                }

                public void onAdClose(Bundle bundle) {
                    QmInterstitalAdapter qmInterstitalAdapter = QmInterstitalAdapter.this;
                    qmInterstitalAdapter.showLog(qmInterstitalAdapter.OooO00o, "--onAdDismiss: ");
                    if (QmInterstitalAdapter.this.eventListener != null) {
                        QmInterstitalAdapter.this.eventListener.onAdDismiss(QmInterstitalAdapter.this.absUbixInfo);
                    }
                }

                public void onAdFailed(String str) {
                    QmInterstitalAdapter qmInterstitalAdapter = QmInterstitalAdapter.this;
                    qmInterstitalAdapter.showLog(qmInterstitalAdapter.OooO00o, "--onShowError: " + str);
                    if (QmInterstitalAdapter.this.eventListener != null) {
                        QmInterstitalAdapter.this.eventListener.onShowError(new ErrorInfo("-1", str).setInfo((Object) QmInterstitalAdapter.this.absUbixInfo));
                    }
                }
            });
        }
    }
}
