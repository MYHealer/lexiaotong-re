package com.ubixnow.network.youshi;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.insightvision.openadsdk.api.AdSlot;
import com.insightvision.openadsdk.api.FanTiAdSdk;
import com.insightvision.openadsdk.api.IAdLoader;
import com.insightvision.openadsdk.api.listener.ISplashInteractionListener;
import com.insightvision.openadsdk.common.AdError;
import com.insightvision.openadsdk.template.rendering.splash.SplashExpressAd;
import com.stub.StubApp;
import com.ubixnow.adtype.splash.custom.UMNCustomSplashAdapter;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o000O0O0;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.o00OO0O0;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.ooooO000;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class YouShiSplashAdapter extends UMNCustomSplashAdapter {
    private SplashExpressAd OooO00o;

    /* JADX INFO: Access modifiers changed from: private */
    public void OooO00o() {
        this.OooO00o.setInteractionListener(new ISplashInteractionListener() { // from class: com.ubixnow.network.youshi.YouShiSplashAdapter.3
            public void onAdClicked(View view) {
                YouShiSplashAdapter.this.showLog(o00OO0O0.TAG, "onAdClicked");
                if (YouShiSplashAdapter.this.eventListener != null) {
                    YouShiSplashAdapter.this.eventListener.onAdClick(YouShiSplashAdapter.this.splashInfo);
                }
            }

            public void onAdClosed() {
                YouShiSplashAdapter.this.showLog(o00OO0O0.TAG, "onAdClosed");
                if (YouShiSplashAdapter.this.eventListener != null) {
                    YouShiSplashAdapter.this.eventListener.onAdDismiss(YouShiSplashAdapter.this.splashInfo);
                }
            }

            public void onAdFinished() {
                YouShiSplashAdapter.this.showLog(o00OO0O0.TAG, "onAdFinished");
                if (YouShiSplashAdapter.this.eventListener != null) {
                    YouShiSplashAdapter youShiSplashAdapter = YouShiSplashAdapter.this;
                    youShiSplashAdapter.splashInfo.OooO00o = false;
                    youShiSplashAdapter.eventListener.onAdDismiss(YouShiSplashAdapter.this.splashInfo);
                }
            }

            public void onAdRenderFail(AdError adError) {
                YouShiSplashAdapter.this.showLog(o00OO0O0.TAG, "onAdRenderFail");
                o00O00o0 o00o00o0 = YouShiSplashAdapter.this.loadListener;
                if (o00o00o0 != null) {
                    oOO00O0.OooO00o oooO00o = oOO00O0.OooO00o.RENDER_FAIL;
                    o00o00o0.onAdRenderFail(new ErrorInfo(oooO00o.OooO00o(), oooO00o.OooO0O0(), adError.getErrorCode() + "", adError.getErrorMessage()).setInfo((Object) YouShiSplashAdapter.this.splashInfo));
                }
            }

            public void onAdRenderSuccess() {
                YouShiSplashAdapter.this.showLog(o00OO0O0.TAG, "onAdRenderSuccess");
                YouShiSplashAdapter youShiSplashAdapter = YouShiSplashAdapter.this;
                o00O00o0 o00o00o0 = youShiSplashAdapter.loadListener;
                if (o00o00o0 != null) {
                    o00o00o0.onAdCacheSuccess(youShiSplashAdapter.splashInfo);
                }
            }

            public void onAdShake() {
                YouShiSplashAdapter.this.showLog(o00OO0O0.TAG, "onAdShake");
                if (YouShiSplashAdapter.this.eventListener != null) {
                    YouShiSplashAdapter.this.eventListener.onAdClick(YouShiSplashAdapter.this.splashInfo);
                }
            }

            public void onAdShow(View view) {
                YouShiSplashAdapter.this.showLog(o00OO0O0.TAG, "onAdShow");
                if (YouShiSplashAdapter.this.eventListener != null) {
                    YouShiSplashAdapter.this.eventListener.onAdShow(YouShiSplashAdapter.this.splashInfo);
                }
            }

            public void onAdSkipped() {
                YouShiSplashAdapter.this.showLog(o00OO0O0.TAG, "onAdSkipped");
                if (YouShiSplashAdapter.this.eventListener != null) {
                    YouShiSplashAdapter youShiSplashAdapter = YouShiSplashAdapter.this;
                    youShiSplashAdapter.splashInfo.OooO00o = true;
                    youShiSplashAdapter.eventListener.onAdDismiss(YouShiSplashAdapter.this.splashInfo);
                }
            }
        });
        this.OooO00o.startRender();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd(Context context) {
        showLog(o00OO0O0.TAG, "loadAd：" + this.mBaseAdConfig.OooO00o.OooO0o0);
        IAdLoader iAdLoaderCreateAdLoader = FanTiAdSdk.getAdManager().createAdLoader(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        AdSlot.Builder builder = new AdSlot.Builder();
        builder.slotId(this.mBaseAdConfig.OooO00o.OooO0o0);
        iAdLoaderCreateAdLoader.loadSplashAd(builder.build(), new IAdLoader.OnTemplateAdLoadListener<SplashExpressAd>() { // from class: com.ubixnow.network.youshi.YouShiSplashAdapter.2
            public void onAdLoadErr(int i, String str) {
                YouShiSplashAdapter.this.showLog(o00OO0O0.TAG, "onError: code:" + i + " msg:" + str);
                o00O00o0 o00o00o0 = YouShiSplashAdapter.this.loadListener;
                if (o00o00o0 != null) {
                    o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, i + "", str + "").setInfo((Object) YouShiSplashAdapter.this.splashInfo));
                }
            }

            public void onAdLoaded(List<SplashExpressAd> list) {
                YouShiSplashAdapter.this.showLog(o00OO0O0.TAG, "onAdLoaded ... size = " + (list != null ? list.size() : 0));
                if (list != null && !list.isEmpty()) {
                    YouShiSplashAdapter youShiSplashAdapter = YouShiSplashAdapter.this;
                    if (youShiSplashAdapter.loadListener != null) {
                        youShiSplashAdapter.OooO00o = list.get(0);
                        YouShiSplashAdapter youShiSplashAdapter2 = YouShiSplashAdapter.this;
                        if (youShiSplashAdapter2.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                            youShiSplashAdapter2.showLog(o00OO0O0.TAG, "price:" + YouShiSplashAdapter.this.OooO00o.getPrice());
                            YouShiSplashAdapter youShiSplashAdapter3 = YouShiSplashAdapter.this;
                            youShiSplashAdapter3.splashInfo.setBiddingEcpm((int) youShiSplashAdapter3.OooO00o.getPrice());
                        }
                        YouShiSplashAdapter.this.OooO00o();
                        YouShiSplashAdapter youShiSplashAdapter4 = YouShiSplashAdapter.this;
                        youShiSplashAdapter4.loadListener.onAdDataLoaded(youShiSplashAdapter4.splashInfo);
                        return;
                    }
                }
                o00O00o0 o00o00o0 = YouShiSplashAdapter.this.loadListener;
                if (o00o00o0 != null) {
                    o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, oOO00O0.ubix_no_ad, "list is null").setInfo((Object) YouShiSplashAdapter.this.splashInfo));
                }
            }
        });
    }

    @Override // com.ubixnow.ooooo.o00OO00O, com.ubixnow.ooooo.o00O
    public void destory() {
        if (ooooO000.OooO00o) {
            showLog(o00OO0O0.TAG, "destroy");
        }
        SplashExpressAd splashExpressAd = this.OooO00o;
        if (splashExpressAd != null) {
            splashExpressAd.destroy();
        }
    }

    @Override // com.ubixnow.ooooo.o00O
    public boolean isValid() {
        return super.isValid();
    }

    @Override // com.ubixnow.ooooo.o00OO00O
    public void loadSplashAd(final Context context, o00O000 o00o000) {
        o00OO0O0.TAG = this.customTag + getClass().getSimpleName();
        createSplashInfo(o00o000);
        YouShiInitManager.getInstance().initSDK(context, o00o000, new o00O0OO0() { // from class: com.ubixnow.network.youshi.YouShiSplashAdapter.1
            @Override // com.ubixnow.ooooo.o00O0OO0
            public void onError(Throwable th) {
                o00O00o0 o00o00o0 = YouShiSplashAdapter.this.loadListener;
                if (o00o00o0 != null) {
                    o00o00o0.onNoAdError(YouShiInitManager.getErrorInfo(th.getMessage()).setInfo((Object) YouShiSplashAdapter.this.splashInfo));
                }
            }

            @Override // com.ubixnow.ooooo.o00O0OO0
            public void onSuccess() {
                YouShiSplashAdapter.this.loadAd(context);
            }
        });
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyLoss(o00OO0OO o00oo0oo) {
        try {
            if (this.OooO00o != null) {
                YouShiBiddingUtils.YouShiBiddingFeedbackBean failInfo = YouShiBiddingUtils.getFailInfo(o00oo0oo);
                this.OooO00o.loss(Double.valueOf(failInfo.OooO00o), failInfo.OooO0O0);
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0OO(o00OO0O0.TAG, "竞价回传_notifyLoss:胜出者价格:" + failInfo.OooO00o);
                }
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyWin(o00OO0OO o00oo0oo) {
        try {
            SplashExpressAd splashExpressAd = this.OooO00o;
            if (splashExpressAd != null) {
                splashExpressAd.win(Double.valueOf(YouShiBiddingUtils.getSecondPrice(o00oo0oo)));
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0OO(o00OO0O0.TAG, "竞价回传_notifyWin:" + YouShiBiddingUtils.getSecondPrice(o00oo0oo));
                }
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    @Override // com.ubixnow.ooooo.o00OO00O
    public void show(ViewGroup viewGroup) {
        showLog(o00OO0O0.TAG, "prepare show");
        if (this.OooO00o != null && viewGroup != null) {
            showLog(o00OO0O0.TAG, "show ");
            this.OooO00o.showAd(viewGroup, viewGroup.getContext());
            return;
        }
        showLog(o00OO0O0.TAG, "showError");
        o000O0O0 o000o0o0 = this.eventListener;
        if (o000o0o0 != null) {
            o000o0o0.onShowError(new ErrorInfo(oOO00O0.ubix_show_error, oOO00O0.ubix_show_error_msg, oOO00O0.ubix_show_error, oOO00O0.ubix_show_error_msg).setInfo((Object) this.splashInfo));
        }
    }
}
