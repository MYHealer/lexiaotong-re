package com.ubixnow.network.qumeng;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.qumeng.advlib.api.AiClkAdManager;
import com.qumeng.advlib.core.AdRequestParam;
import com.qumeng.advlib.core.IMultiAdObject;
import com.qumeng.advlib.core.IMultiAdRequest;
import com.ubixnow.adtype.reward.custom.UMNCustomRewardAdapter;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.ooooO000;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class QmRewardAdapter extends UMNCustomRewardAdapter {
    private final String OooO00o = this.customTag + getClass().getSimpleName();
    private IMultiAdObject OooO0O0;

    @Override // com.ubixnow.ooooo.o00O
    public void destory() {
        try {
            showLog(this.OooO00o, "destory");
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

    public void loadAd() {
        showLog(this.OooO00o, "start_loadAd");
        AdRequestParam adRequestParamBuild = new AdRequestParam.Builder().adslotID(this.adsSlotid).adType(4).adLoadListener(new AdRequestParam.ADLoadListener() { // from class: com.ubixnow.network.qumeng.QmRewardAdapter.2
            public void onADLoaded(IMultiAdObject iMultiAdObject) {
                QmRewardAdapter qmRewardAdapter = QmRewardAdapter.this;
                qmRewardAdapter.showLog(qmRewardAdapter.OooO00o, "onADLoaded");
                QmRewardAdapter qmRewardAdapter2 = QmRewardAdapter.this;
                if (qmRewardAdapter2.loadListener != null) {
                    if (iMultiAdObject != null) {
                        qmRewardAdapter2.OooO0O0 = iMultiAdObject;
                        QmRewardAdapter.this.absUbixInfo.material = QmUtils.getMaterialInfo(iMultiAdObject);
                        QmRewardAdapter qmRewardAdapter3 = QmRewardAdapter.this;
                        if (qmRewardAdapter3.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                            qmRewardAdapter3.showLog(qmRewardAdapter3.OooO00o, "price:" + QmRewardAdapter.this.OooO0O0.getECPM());
                            QmRewardAdapter qmRewardAdapter4 = QmRewardAdapter.this;
                            qmRewardAdapter4.absUbixInfo.setBiddingEcpm(qmRewardAdapter4.OooO0O0.getECPM());
                        }
                    } else {
                        qmRewardAdapter2.absUbixInfo.checkMaterialStatus = 7;
                    }
                    QmRewardAdapter qmRewardAdapter5 = QmRewardAdapter.this;
                    qmRewardAdapter5.loadListener.onAdCacheSuccess(qmRewardAdapter5.absUbixInfo);
                }
            }

            public void onAdFailed(String str) {
                QmRewardAdapter qmRewardAdapter = QmRewardAdapter.this;
                qmRewardAdapter.showLog(qmRewardAdapter.OooO00o, "onError msg:" + str);
                o00O00o0 o00o00o0 = QmRewardAdapter.this.loadListener;
                if (o00o00o0 != null) {
                    o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, "-1", str).setInfo((Object) QmRewardAdapter.this.absUbixInfo));
                }
            }
        }).build();
        IMultiAdRequest iMultiAdRequestCreateAdRequest = AiClkAdManager.getInstance().createAdRequest();
        if (iMultiAdRequestCreateAdRequest != null) {
            iMultiAdRequestCreateAdRequest.invokeADV(adRequestParamBuild);
        }
    }

    @Override // com.ubixnow.adtype.reward.custom.UMNCustomRewardAdapter
    public void loadRewardAd(Context context, o00O000 o00o000) {
        createADInfo(o00o000);
        QmInitManager.getInstance().initSDK(context, o00o000, new o00O0OO0() { // from class: com.ubixnow.network.qumeng.QmRewardAdapter.1
            @Override // com.ubixnow.ooooo.o00O0OO0
            public void onError(Throwable th) {
                o00O00o0 o00o00o0 = QmRewardAdapter.this.loadListener;
                if (o00o00o0 != null) {
                    o00o00o0.onNoAdError(QmInitManager.getErrorInfo(th.getMessage()).setInfo((Object) QmRewardAdapter.this.absUbixInfo));
                }
            }

            @Override // com.ubixnow.ooooo.o00O0OO0
            public void onSuccess() {
                QmRewardAdapter.this.loadAd();
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

    @Override // com.ubixnow.adtype.reward.custom.UMNCustomRewardAdapter
    public void show(Activity activity) {
        showLog(this.OooO00o, "show ");
        this.OooO0O0.showRewardVideo(activity, new AdRequestParam.ADRewardVideoListener() { // from class: com.ubixnow.network.qumeng.QmRewardAdapter.3
            public void onAdClick(Bundle bundle) {
                QmRewardAdapter qmRewardAdapter = QmRewardAdapter.this;
                qmRewardAdapter.showLog(qmRewardAdapter.OooO00o, "--onAdClick: ");
                if (QmRewardAdapter.this.eventListener != null) {
                    QmRewardAdapter.this.eventListener.onAdClick(QmRewardAdapter.this.absUbixInfo);
                }
            }

            public void onAdClose(Bundle bundle) {
                QmRewardAdapter qmRewardAdapter = QmRewardAdapter.this;
                qmRewardAdapter.showLog(qmRewardAdapter.OooO00o, "--onAdDismiss: ");
                if (QmRewardAdapter.this.eventListener != null) {
                    QmRewardAdapter.this.eventListener.onAdDismiss(QmRewardAdapter.this.absUbixInfo);
                }
            }

            public void onAdShow(Bundle bundle) {
                QmRewardAdapter qmRewardAdapter = QmRewardAdapter.this;
                qmRewardAdapter.showLog(qmRewardAdapter.OooO00o, "--onVideoPlayStart: ");
                if (QmRewardAdapter.this.eventListener != null) {
                    QmRewardAdapter.this.eventListener.onAdShow(QmRewardAdapter.this.absUbixInfo);
                    QmRewardAdapter.this.eventListener.onVideoPlayStart(QmRewardAdapter.this.absUbixInfo);
                }
            }

            public void onReward(Bundle bundle) {
                QmRewardAdapter qmRewardAdapter = QmRewardAdapter.this;
                qmRewardAdapter.showLog(qmRewardAdapter.OooO00o, "--onRewardVerify: ");
                if (QmRewardAdapter.this.eventListener != null) {
                    QmRewardAdapter.this.eventListener.onRewardVerify(QmRewardAdapter.this.absUbixInfo);
                }
            }

            public void onSkippedVideo(Bundle bundle) {
                QmRewardAdapter qmRewardAdapter = QmRewardAdapter.this;
                qmRewardAdapter.showLog(qmRewardAdapter.OooO00o, "--onSkippedVideo: ");
                if (QmRewardAdapter.this.eventListener != null) {
                    QmRewardAdapter.this.eventListener.onVideoSkip(QmRewardAdapter.this.absUbixInfo);
                }
            }

            public void onVideoComplete(Bundle bundle) {
                QmRewardAdapter qmRewardAdapter = QmRewardAdapter.this;
                qmRewardAdapter.showLog(qmRewardAdapter.OooO00o, "--onVideoPlayComplete: ");
                if (QmRewardAdapter.this.eventListener != null) {
                    QmRewardAdapter.this.eventListener.onVideoPlayComplete(QmRewardAdapter.this.absUbixInfo);
                }
            }

            public void onVideoError(Bundle bundle) {
                QmRewardAdapter qmRewardAdapter = QmRewardAdapter.this;
                qmRewardAdapter.showLog(qmRewardAdapter.OooO00o, "--onShowError: ");
                if (QmRewardAdapter.this.eventListener != null) {
                    QmRewardAdapter.this.eventListener.onShowError(new ErrorInfo(oOO00O0.ubix_show_error, oOO00O0.ubix_videoshow_error_msg, "-1", "").setInfo((Object) QmRewardAdapter.this.absUbixInfo));
                }
            }
        });
    }
}
