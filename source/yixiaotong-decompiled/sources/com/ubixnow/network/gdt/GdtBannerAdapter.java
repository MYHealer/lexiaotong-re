package com.ubixnow.network.gdt;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.huawei.openalliance.ad.constant.br;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.comm.util.AdError;
import com.ubixnow.adtype.banner.custom.UMNCustomBannerAdapter;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.OooO0o;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.ooooO000;
import com.ubixnow.utils.BaseUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class GdtBannerAdapter extends UMNCustomBannerAdapter {
    private final String OooO00o = this.customTag + GdtInitManager.getInstance().getName();
    public WeakReference<Context> OooO0O0;
    private UnifiedBannerView OooO0OO;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:12:0x003e A[PHI: r2
  0x003e: PHI (r2v5 int) = (r2v3 int), (r2v4 int) binds: [B:11:0x003c, B:14:0x0043] A[DONT_GENERATE, DONT_INLINE]] */
    public void loadAd() {
        this.absUbixInfo.bannerAdapterHashCode = hashCode();
        WeakReference<Context> weakReference = this.OooO0O0;
        if (weakReference == null || weakReference.get() == null || !(this.OooO0O0.get() instanceof Activity)) {
            return;
        }
        UnifiedBannerView unifiedBannerView = new UnifiedBannerView((Activity) this.OooO0O0.get(), this.mBaseAdConfig.OooO00o.OooO0o0, new UnifiedBannerADListener() { // from class: com.ubixnow.network.gdt.GdtBannerAdapter.2
            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onADClicked() {
                GdtBannerAdapter gdtBannerAdapter = GdtBannerAdapter.this;
                gdtBannerAdapter.showLog(gdtBannerAdapter.OooO00o, IAdInterListener.AdCommandType.AD_CLICK);
                if (GdtBannerAdapter.this.eventListener != null) {
                    GdtBannerAdapter.this.eventListener.onAdClick(GdtBannerAdapter.this.absUbixInfo);
                }
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onADClosed() {
                GdtBannerAdapter gdtBannerAdapter = GdtBannerAdapter.this;
                gdtBannerAdapter.showLog(gdtBannerAdapter.OooO00o, "onADClosed");
                if (GdtBannerAdapter.this.eventListener != null) {
                    GdtBannerAdapter.this.eventListener.onAdDismiss(GdtBannerAdapter.this.absUbixInfo);
                }
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onADExposure() {
                GdtBannerAdapter gdtBannerAdapter = GdtBannerAdapter.this;
                gdtBannerAdapter.showLog(gdtBannerAdapter.OooO00o, "onADExposure");
                if (GdtBannerAdapter.this.eventListener != null) {
                    GdtBannerAdapter.this.eventListener.onAdShow(GdtBannerAdapter.this.absUbixInfo);
                }
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onADLeftApplication() {
                GdtBannerAdapter gdtBannerAdapter = GdtBannerAdapter.this;
                gdtBannerAdapter.showLog(gdtBannerAdapter.OooO00o, "onADLeftApplication");
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onADReceive() {
                GdtBannerAdapter gdtBannerAdapter = GdtBannerAdapter.this;
                gdtBannerAdapter.showLog(gdtBannerAdapter.OooO00o, "onADReceive");
                GdtBannerAdapter gdtBannerAdapter2 = GdtBannerAdapter.this;
                gdtBannerAdapter2.hasCallBack = true;
                if (gdtBannerAdapter2.loadListener != null) {
                    if (gdtBannerAdapter2.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                        gdtBannerAdapter2.showLog(gdtBannerAdapter2.OooO00o, "price:" + GdtBannerAdapter.this.OooO0OO.getECPM());
                        GdtBannerAdapter gdtBannerAdapter3 = GdtBannerAdapter.this;
                        gdtBannerAdapter3.absUbixInfo.setBiddingEcpm(gdtBannerAdapter3.OooO0OO.getECPM());
                    }
                    GdtBannerAdapter gdtBannerAdapter4 = GdtBannerAdapter.this;
                    gdtBannerAdapter4.absUbixInfo.bannerAdapterHashCode = gdtBannerAdapter4.hashCode();
                    GdtBannerAdapter gdtBannerAdapter5 = GdtBannerAdapter.this;
                    gdtBannerAdapter5.loadListener.onAdCacheSuccess(gdtBannerAdapter5.absUbixInfo);
                }
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onNoAD(AdError adError) {
                GdtBannerAdapter gdtBannerAdapter = GdtBannerAdapter.this;
                if (!gdtBannerAdapter.hasCallBack) {
                    gdtBannerAdapter.OooO0OO.setRefresh(0);
                    GdtBannerAdapter.this.OooO0OO.destroy();
                }
                GdtBannerAdapter gdtBannerAdapter2 = GdtBannerAdapter.this;
                gdtBannerAdapter2.showLog(gdtBannerAdapter2.OooO00o, "onNoAD: " + adError.getErrorMsg());
                o00O00o0 o00o00o0 = GdtBannerAdapter.this.loadListener;
                if (o00o00o0 != null) {
                    o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, adError.getErrorCode() + "", adError.getErrorMsg()).setInfo((Object) GdtBannerAdapter.this.absUbixInfo));
                }
            }
        });
        this.OooO0OO = unifiedBannerView;
        int i = this.bannerRefreshTime;
        if (i > 0) {
            int i2 = 30;
            if (i < 30) {
                this.bannerRefreshTime = i2;
            } else {
                i2 = 120;
                if (i > 120) {
                    this.bannerRefreshTime = i2;
                }
            }
            unifiedBannerView.setRefresh(this.bannerRefreshTime);
        }
        this.OooO0OO.loadAD();
    }

    @Override // com.ubixnow.ooooo.o00O
    public void destory() {
        try {
            UnifiedBannerView unifiedBannerView = this.OooO0OO;
            if (unifiedBannerView != null) {
                unifiedBannerView.destroy();
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    @Override // com.ubixnow.adtype.banner.custom.UMNCustomBannerAdapter
    public View getView() {
        return this.OooO0OO;
    }

    @Override // com.ubixnow.ooooo.o00O
    public boolean isValid() {
        UnifiedBannerView unifiedBannerView = this.OooO0OO;
        if (unifiedBannerView != null) {
            return unifiedBannerView.isValid();
        }
        return false;
    }

    @Override // com.ubixnow.adtype.banner.custom.UMNCustomBannerAdapter
    public void loadBannerAd(Context context, o00O000 o00o000) {
        createADInfo(o00o000);
        this.OooO0O0 = new WeakReference<>(context);
        if (!TextUtils.isEmpty(o00o000.OooO00o.OooO0Oo) && !TextUtils.isEmpty(o00o000.OooO00o.OooO0o0)) {
            GdtInitManager.getInstance().initSDK(BaseUtils.getContext(), o00o000, new o00O0OO0() { // from class: com.ubixnow.network.gdt.GdtBannerAdapter.1
                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onError(Throwable th) {
                    o00O00o0 o00o00o0 = GdtBannerAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        o00o00o0.onNoAdError(new ErrorInfo("500041", th.getMessage()).setInfo((Object) GdtBannerAdapter.this.absUbixInfo));
                    }
                }

                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onSuccess() {
                    GdtBannerAdapter.this.loadAd();
                }
            });
            return;
        }
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_appIdorPlaceIdNull, oOO00O0.ubix_appIdorPlaceIdNull_msg).setInfo((Object) this.absUbixInfo));
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyLoss(o00OO0OO o00oo0oo) {
        try {
            UnifiedBannerView unifiedBannerView = this.OooO0OO;
            if (unifiedBannerView != null) {
                unifiedBannerView.sendLossNotification(GdtBiddingUtils.getFailInfo(o00oo0oo));
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0OO(this.OooO00o, "竞价回传_notifyLoss:" + GdtBiddingUtils.getFailInfo(o00oo0oo));
                }
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyWin(o00OO0OO o00oo0oo) {
        try {
            UnifiedBannerView unifiedBannerView = this.OooO0OO;
            if (unifiedBannerView != null) {
                unifiedBannerView.sendWinNotification(GdtBiddingUtils.getSuccMap(o00oo0oo));
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0OO(this.OooO00o, "竞价回传_notifyWin:" + GdtBiddingUtils.getSuccMap(o00oo0oo));
                }
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    @Override // com.ubixnow.adtype.banner.custom.UMNCustomBannerAdapter
    public void show(ViewGroup viewGroup) {
        showLog(this.OooO00o, "prepare show");
        UnifiedBannerView unifiedBannerView = this.OooO0OO;
        if (unifiedBannerView != null && viewGroup != null && unifiedBannerView.isValid()) {
            showLog(this.OooO00o, br.b.V);
            viewGroup.addView(this.OooO0OO, new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        showLog(this.OooO00o, "showError");
        OooO0o oooO0o = this.eventListener;
        if (oooO0o != null) {
            oooO0o.onShowError(new ErrorInfo(oOO00O0.ubix_show_error, oOO00O0.ubix_show_error_msg, oOO00O0.ubix_show_error, oOO00O0.ubix_show_error_msg).setInfo((Object) this.absUbixInfo));
        }
    }
}
