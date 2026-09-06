package com.ubixnow.network.baidu;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.mobads.sdk.api.SplashInteractionListener;
import com.bytedance.msdk.adapter.baidu.BaiduAdapterUtil;
import com.huawei.hms.ads.ez;
import com.huawei.openalliance.ad.constant.br;
import com.ubixnow.adtype.splash.custom.UMNCustomSplashAdapter;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o000O0O0;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.oO0000O;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.ooooO000;
import com.ubixnow.utils.BaseUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class BdSplashAdapter extends UMNCustomSplashAdapter {
    private final String OooO00o = this.customTag + "BdSplashAdapter";
    private SplashAd OooO0O0;
    private boolean OooO0OO;
    private long OooO0Oo;

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd(Context context) {
        showLog(this.OooO00o, "start loadAd");
        SplashInteractionListener splashInteractionListener = new SplashInteractionListener() { // from class: com.ubixnow.network.baidu.BdSplashAdapter.2
            @Override // com.baidu.mobads.sdk.api.SplashAdListener
            public void onADLoaded() {
                BdSplashAdapter.this.OooO0OO = true;
                BdSplashAdapter bdSplashAdapter = BdSplashAdapter.this;
                if (bdSplashAdapter.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                    try {
                        bdSplashAdapter.OooO0Oo = bdSplashAdapter.getIntegerValue(bdSplashAdapter.OooO0O0.getECPMLevel());
                        BdSplashAdapter bdSplashAdapter2 = BdSplashAdapter.this;
                        bdSplashAdapter2.showLog(bdSplashAdapter2.OooO00o, "price:" + BdSplashAdapter.this.OooO0Oo);
                        BdSplashAdapter bdSplashAdapter3 = BdSplashAdapter.this;
                        bdSplashAdapter3.splashInfo.setBiddingEcpm((int) bdSplashAdapter3.OooO0Oo);
                    } catch (Exception e) {
                        ooooO000.OooO00o(e);
                    }
                }
                BdSplashAdapter.this.onAdDataLoaded();
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdCacheFailed() {
                BdSplashAdapter bdSplashAdapter = BdSplashAdapter.this;
                bdSplashAdapter.showLog(bdSplashAdapter.OooO00o, "onAdCacheFailed");
                BdSplashAdapter bdSplashAdapter2 = BdSplashAdapter.this;
                oOO00O0.OooO00o oooO00o = oOO00O0.OooO00o.RENDER_FAIL;
                bdSplashAdapter2.onRenderFail(Integer.parseInt(oooO00o.OooO00o()), oooO00o.OooO0O0());
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdCacheSuccess() {
                BdSplashAdapter bdSplashAdapter = BdSplashAdapter.this;
                bdSplashAdapter.showLog(bdSplashAdapter.OooO00o, "onAdCacheSuccess " + BdSplashAdapter.this.isValid());
                BdSplashAdapter bdSplashAdapter2 = BdSplashAdapter.this;
                if (bdSplashAdapter2.loadListener != null) {
                    if (bdSplashAdapter2.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                        try {
                            bdSplashAdapter2.OooO0Oo = bdSplashAdapter2.getIntegerValue(bdSplashAdapter2.OooO0O0.getECPMLevel());
                            BdSplashAdapter bdSplashAdapter3 = BdSplashAdapter.this;
                            bdSplashAdapter3.showLog(bdSplashAdapter3.OooO00o, "price:" + BdSplashAdapter.this.OooO0Oo);
                            BdSplashAdapter bdSplashAdapter4 = BdSplashAdapter.this;
                            bdSplashAdapter4.splashInfo.setBiddingEcpm((int) bdSplashAdapter4.OooO0Oo);
                        } catch (Exception e) {
                            ooooO000.OooO00o(e);
                        }
                    }
                    BdSplashAdapter bdSplashAdapter5 = BdSplashAdapter.this;
                    bdSplashAdapter5.loadListener.onAdCacheSuccess(bdSplashAdapter5.splashInfo);
                }
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdClick() {
                BdSplashAdapter bdSplashAdapter = BdSplashAdapter.this;
                bdSplashAdapter.showLog(bdSplashAdapter.OooO00o, IAdInterListener.AdCommandType.AD_CLICK);
                if (BdSplashAdapter.this.eventListener != null) {
                    BdSplashAdapter.this.eventListener.onAdClick(BdSplashAdapter.this.splashInfo);
                }
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdDismissed() {
                BdSplashAdapter bdSplashAdapter = BdSplashAdapter.this;
                bdSplashAdapter.showLog(bdSplashAdapter.OooO00o, "onAdDismissed");
                if (BdSplashAdapter.this.eventListener != null) {
                    BdSplashAdapter.this.eventListener.onAdDismiss(BdSplashAdapter.this.splashInfo);
                }
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdExposed() {
                BdSplashAdapter bdSplashAdapter = BdSplashAdapter.this;
                bdSplashAdapter.showLog(bdSplashAdapter.OooO00o, "onAdExposed");
                if (oO0000O.OooO00o(BdInitManager.getInstance().getVersion(), BaiduAdapterUtil.VERSION_9_35) < 0 || BdSplashAdapter.this.eventListener == null) {
                    return;
                }
                BdSplashAdapter.this.eventListener.onAdShow(BdSplashAdapter.this.splashInfo);
            }

            @Override // com.baidu.mobads.sdk.api.SplashAdListener
            public void onAdFailed(String str) {
                BdSplashAdapter bdSplashAdapter = BdSplashAdapter.this;
                bdSplashAdapter.showLog(bdSplashAdapter.OooO00o, "onAdFailed: " + str);
                BdSplashAdapter bdSplashAdapter2 = BdSplashAdapter.this;
                if (bdSplashAdapter2.loadListener != null) {
                    if (!bdSplashAdapter2.OooO0OO) {
                        BdSplashAdapter.this.onAdDataLoadFailed(oOO00O0.OooO00o.DATA_FAIL.OooO00o(), str);
                    } else if (BdSplashAdapter.this.eventListener != null) {
                        BdSplashAdapter.this.eventListener.onShowError(new ErrorInfo(oOO00O0.ubix_show_error, oOO00O0.ubix_show_error_msg, oOO00O0.ubix_show_error, str).setInfo((Object) BdSplashAdapter.this.splashInfo));
                    }
                }
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdPresent() {
                BdSplashAdapter bdSplashAdapter = BdSplashAdapter.this;
                bdSplashAdapter.showLog(bdSplashAdapter.OooO00o, "onAdPresent");
                if (oO0000O.OooO00o(BdInitManager.getInstance().getVersion(), BaiduAdapterUtil.VERSION_9_35) >= 0 || BdSplashAdapter.this.eventListener == null) {
                    return;
                }
                BdSplashAdapter.this.eventListener.onAdShow(BdSplashAdapter.this.splashInfo);
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdSkip() {
                BdSplashAdapter bdSplashAdapter = BdSplashAdapter.this;
                bdSplashAdapter.showLog(bdSplashAdapter.OooO00o, "onAdSkip");
                if (BdSplashAdapter.this.eventListener != null) {
                    BdSplashAdapter bdSplashAdapter2 = BdSplashAdapter.this;
                    bdSplashAdapter2.splashInfo.OooO00o = true;
                    bdSplashAdapter2.eventListener.onAdDismiss(BdSplashAdapter.this.splashInfo);
                }
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onLpClosed() {
                BdSplashAdapter bdSplashAdapter = BdSplashAdapter.this;
                bdSplashAdapter.showLog(bdSplashAdapter.OooO00o, "onLpClosed");
            }
        };
        try {
            SplashAd splashAd = new SplashAd(context, this.mBaseAdConfig.OooO00o.OooO0o0, new RequestParameters.Builder().addExtra(SplashAd.KEY_POPDIALOG_DOWNLOAD, ez.Code).build(), splashInteractionListener);
            this.OooO0O0 = splashAd;
            splashAd.setAppSid(this.mBaseAdConfig.OooO00o.OooO0Oo);
            o00O000 o00o000 = this.mBaseAdConfig;
            if (o00o000.OooO00o.OooOO0O == 1) {
                this.OooO0O0.setBidFloor((int) o00o000.OooO);
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
        this.OooO0O0.load();
    }

    @Override // com.ubixnow.ooooo.o00OO00O, com.ubixnow.ooooo.o00O
    public void destory() {
        ooooO000.OooO0OO(this.OooO00o, "destory");
        SplashAd splashAd = this.OooO0O0;
        if (splashAd != null) {
            splashAd.destroy();
        }
    }

    @Override // com.ubixnow.ooooo.o00O
    public boolean isValid() {
        if (this.OooO0O0 == null) {
            ooooO000.OooO0OO(this.OooO00o, "mSplashAd == null ");
            return false;
        }
        if (ooooO000.OooO00o) {
            ooooO000.OooO0OO(this.OooO00o, "---isValid " + this.OooO0O0.isReady());
        }
        return this.OooO0O0.isReady();
    }

    @Override // com.ubixnow.ooooo.o00OO00O
    public void loadSplashAd(Context context, o00O000 o00o000) {
        createSplashInfo(o00o000);
        if (!TextUtils.isEmpty(o00o000.OooO00o.OooO0Oo) && !TextUtils.isEmpty(o00o000.OooO00o.OooO0o0)) {
            BdInitManager.getInstance().initSDK(BaseUtils.getContext(), o00o000, new o00O0OO0() { // from class: com.ubixnow.network.baidu.BdSplashAdapter.1
                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onError(Throwable th) {
                    ooooO000.OooO0OO(BdSplashAdapter.this.OooO00o, "initSDK error");
                    o00O00o0 o00o00o0 = BdSplashAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        o00o00o0.onNoAdError(new ErrorInfo("500041", BdInitManager.getInstance().getName() + oOO00O0.ubix_initError_msg + th.getMessage()).setInfo((Object) BdSplashAdapter.this.splashInfo));
                    }
                }

                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onSuccess() {
                    ooooO000.OooO0OO(BdSplashAdapter.this.OooO00o, "initSDK success");
                    BdSplashAdapter.this.loadAd(BaseUtils.getContext());
                }
            });
            return;
        }
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_appIdorPlaceIdNull, BdInitManager.getInstance().getName() + oOO00O0.ubix_appIdorPlaceIdNull_msg).setInfo((Object) this.splashInfo));
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyLoss(o00OO0OO o00oo0oo) {
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyWin(o00OO0OO o00oo0oo) {
    }

    @Override // com.ubixnow.ooooo.o00OO00O
    public void show(ViewGroup viewGroup) {
        showLog(this.OooO00o, "prepare showgroup != null:" + (viewGroup != null) + " mSplashAd.isReady():" + this.OooO0O0.isReady() + " checkReady:" + isValid());
        if (this.OooO0O0 != null && viewGroup != null && isValid()) {
            showLog(this.OooO00o, br.b.V);
            this.OooO0O0.show(viewGroup);
            return;
        }
        showLog(this.OooO00o, "showError mSplashAd != null && group != null");
        o000O0O0 o000o0o0 = this.eventListener;
        if (o000o0o0 != null) {
            o000o0o0.onShowError(new ErrorInfo(oOO00O0.ubix_show_error, oOO00O0.ubix_show_error_msg, oOO00O0.ubix_show_error, "展示失败 group:" + (viewGroup == null)).setInfo((Object) this.splashInfo));
        }
    }
}
