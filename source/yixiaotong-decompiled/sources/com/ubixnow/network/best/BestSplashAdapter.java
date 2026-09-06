package com.ubixnow.network.best;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.my.adpoymer.R;
import com.my.adpoymer.interfaces.SpreadListener;
import com.my.adpoymer.manager.SpreadAd;
import com.ubixnow.adtype.splash.custom.UMNCustomSplashAdapter;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o000O0O0;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.o00OO0O0;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.ooooO000;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class BestSplashAdapter extends UMNCustomSplashAdapter {
    public static String OooO00o = "com.yoosee";
    private ViewGroup OooO0O0;
    private SpreadAd OooO0OO;
    private boolean OooO0Oo = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd(final Context context) {
        showLog(o00OO0O0.TAG, "start_loadAd，默认超时5s " + this.mBaseAdConfig.OooO00o.OooO0o0);
        this.OooO0O0 = new FrameLayout(context);
        this.OooO0OO = new SpreadAd(context, this.mBaseAdConfig.OooO00o.OooO0o0, this.OooO0O0, new SpreadListener() { // from class: com.ubixnow.network.best.BestSplashAdapter.2
            public void isSupportSplashClickEye(boolean z) {
            }

            public void onADTick(long j) {
            }

            public void onAdClick() {
                BestSplashAdapter.this.showLog(o00OO0O0.TAG, IAdInterListener.AdCommandType.AD_CLICK);
                if (BestSplashAdapter.this.eventListener != null) {
                    BestSplashAdapter.this.eventListener.onAdClick(BestSplashAdapter.this.splashInfo);
                }
            }

            public void onAdClose(String str) {
                BestSplashAdapter.this.showLog(o00OO0O0.TAG, "onAdClose " + str);
                if (BestSplashAdapter.this.eventListener != null) {
                    BestSplashAdapter.this.eventListener.onAdDismiss(BestSplashAdapter.this.splashInfo);
                }
            }

            public void onAdDisplay(String str) {
                BestSplashAdapter.this.showLog(o00OO0O0.TAG, "onAdDisplay ");
                if (BestSplashAdapter.this.eventListener != null) {
                    BestSplashAdapter.this.eventListener.onAdShow(BestSplashAdapter.this.splashInfo);
                }
                try {
                    if (context.getPackageName() == null || !context.getPackageName().toLowerCase().equals(BestSplashAdapter.OooO00o)) {
                        return;
                    }
                    BestSplashAdapter.this.OooO0O0.post(new Runnable() { // from class: com.ubixnow.network.best.BestSplashAdapter.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                TextView textView = (TextView) BestSplashAdapter.this.OooO0O0.findViewById(R.id.mob_txt_logo);
                                if (textView != null) {
                                    textView.setText("UBiX 广告");
                                }
                            } catch (Exception e) {
                                ooooO000.OooO00o(e);
                            }
                            try {
                                ImageView imageView = (ImageView) BestSplashAdapter.this.OooO0O0.findViewById(R.id.my_img_logo);
                                if (imageView != null) {
                                    imageView.setImageResource(com.ubixnow.core.R.drawable.ubixnow_logo);
                                }
                            } catch (Exception e2) {
                                ooooO000.OooO00o(e2);
                            }
                        }
                    });
                } catch (Exception e) {
                    ooooO000.OooO00o(e);
                }
            }

            public void onAdFailed(String str) {
                BestSplashAdapter.this.showLog(o00OO0O0.TAG, "onAdFailed " + str);
                if (BestSplashAdapter.this.OooO0Oo) {
                    BestSplashAdapter.this.eventListener.onShowError(new ErrorInfo(oOO00O0.ubix_show_error, oOO00O0.ubix_show_error_msg, oOO00O0.ubix_show_error, str).setInfo((Object) BestSplashAdapter.this.splashInfo));
                } else {
                    BestSplashAdapter.this.loadListener.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, oOO00O0.ubix_no_ad, str).setInfo((Object) BestSplashAdapter.this.splashInfo));
                }
            }

            public void onAdReceived(String str) {
                BestSplashAdapter bestSplashAdapter = BestSplashAdapter.this;
                if (bestSplashAdapter.mBaseAdConfig.OooO00o.OooOO0O != 1) {
                    bestSplashAdapter.onAdDataLoaded();
                }
            }

            public void onRenderSuccess() {
                BestSplashAdapter bestSplashAdapter = BestSplashAdapter.this;
                if (bestSplashAdapter.loadListener != null) {
                    bestSplashAdapter.OooO0Oo = true;
                    BestSplashAdapter bestSplashAdapter2 = BestSplashAdapter.this;
                    if (bestSplashAdapter2.mBaseAdConfig.OooO00o.OooOO0O == 1 && bestSplashAdapter2.OooO0OO != null) {
                        BestSplashAdapter.this.showLog(o00OO0O0.TAG, "onRenderSuccess 价格  " + BestSplashAdapter.this.OooO0OO.getEcpm());
                        BestSplashAdapter bestSplashAdapter3 = BestSplashAdapter.this;
                        bestSplashAdapter3.splashInfo.setBiddingEcpm(bestSplashAdapter3.OooO0OO.getEcpm());
                        BestSplashAdapter.this.onAdDataLoaded();
                    }
                    BestSplashAdapter bestSplashAdapter4 = BestSplashAdapter.this;
                    bestSplashAdapter4.loadListener.onAdCacheSuccess(bestSplashAdapter4.splashInfo);
                }
            }

            public void onSplashClickEyeAnimationFinish() {
            }
        }, 5000, 1);
    }

    @Override // com.ubixnow.ooooo.o00OO00O, com.ubixnow.ooooo.o00O
    public void destory() {
        if (ooooO000.OooO00o) {
            showLog(o00OO0O0.TAG, "destory");
        }
    }

    @Override // com.ubixnow.ooooo.o00O
    public boolean isValid() {
        SpreadAd spreadAd = this.OooO0OO;
        if (spreadAd != null) {
            return spreadAd.isReady();
        }
        return true;
    }

    @Override // com.ubixnow.ooooo.o00OO00O
    public void loadSplashAd(final Context context, o00O000 o00o000) {
        o00OO0O0.TAG = this.customTag + getClass().getSimpleName();
        createSplashInfo(o00o000);
        BestInitManager.getInstance().initSDK(context, o00o000, new o00O0OO0() { // from class: com.ubixnow.network.best.BestSplashAdapter.1
            @Override // com.ubixnow.ooooo.o00O0OO0
            public void onError(Throwable th) {
                o00O00o0 o00o00o0 = BestSplashAdapter.this.loadListener;
                if (o00o00o0 != null) {
                    o00o00o0.onNoAdError(BestInitManager.getErrorInfo(th.getMessage()).setInfo((Object) BestSplashAdapter.this.splashInfo));
                }
            }

            @Override // com.ubixnow.ooooo.o00O0OO0
            public void onSuccess() {
                BestSplashAdapter.this.loadAd(context);
            }
        });
    }

    @Override // com.ubixnow.ooooo.o00OO00O
    public void show(ViewGroup viewGroup) {
        showLog(o00OO0O0.TAG, "prepare show");
        if (this.OooO0OO != null && viewGroup != null && this.OooO0O0 != null) {
            showLog(o00OO0O0.TAG, "show ");
            viewGroup.addView(this.OooO0O0);
            this.OooO0OO.showSplash(this.OooO0O0);
        } else {
            showLog(o00OO0O0.TAG, "showError");
            o000O0O0 o000o0o0 = this.eventListener;
            if (o000o0o0 != null) {
                o000o0o0.onShowError(new ErrorInfo(oOO00O0.ubix_show_error, oOO00O0.ubix_show_error_msg, oOO00O0.ubix_show_error, oOO00O0.ubix_show_error_msg).setInfo((Object) this.splashInfo));
            }
        }
    }
}
