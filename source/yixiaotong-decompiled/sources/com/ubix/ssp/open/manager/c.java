package com.ubix.ssp.open.manager;

import android.app.Activity;
import android.content.Context;
import com.huawei.openalliance.ad.constant.h;
import com.ubix.ssp.ad.e.a0.u;
import com.ubix.ssp.open.AdError;
import com.ubix.ssp.open.ParamsReview;
import com.ubix.ssp.open.UBiXAdLossInfo;
import com.ubix.ssp.open.interstitial.UBiXInterstitialAdListener;
import com.ubix.ssp.open.interstitial.UBiXInterstitialManager;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c implements UBiXInterstitialManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9060a = "c";
    private transient com.ubix.ssp.ad.h.b b;

    class a implements com.ubix.ssp.ad.g.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ UBiXInterstitialAdListener f9061a;

        a(UBiXInterstitialAdListener uBiXInterstitialAdListener) {
            this.f9061a = uBiXInterstitialAdListener;
        }

        @Override // com.ubix.ssp.ad.g.e
        public void onAdClicked() {
            if (this.f9061a != null) {
                u.e(c.f9060a, "onAdClicked in");
                this.f9061a.onAdClicked();
            }
            u.e(c.f9060a, "onAdClicked out");
        }

        @Override // com.ubix.ssp.ad.g.e
        public void onAdClosed() {
            if (this.f9061a != null) {
                u.e(c.f9060a, "onAdClosed in");
                this.f9061a.onAdClosed();
            }
            u.e(c.f9060a, "onAdClosed out");
        }

        @Override // com.ubix.ssp.ad.g.e
        public void onAdExposeFailed(AdError adError) {
            if (this.f9061a != null) {
                u.c(c.f9060a, "onAdExposeFailed in");
                this.f9061a.onAdExposeFailed(adError);
            }
            u.c(c.f9060a, "onAdExposeFailed out: ErrorCode:" + adError.getErrorCode() + "   ErrorMessage:" + adError.getErrorMessage());
        }

        @Override // com.ubix.ssp.ad.g.e
        public void onAdExposed() {
            if (this.f9061a != null) {
                u.e(c.f9060a, "onAdExposed in");
                this.f9061a.onAdExposed();
            }
            u.e(c.f9060a, "onAdExposed out");
        }

        @Override // com.ubix.ssp.ad.g.e
        public void onAdLoadFailed(AdError adError) {
            if (this.f9061a != null) {
                u.c(c.f9060a, "onAdLoadFailed in");
                this.f9061a.onAdLoadFailed(adError);
            }
            u.c(c.f9060a, "onAdLoadFailed out: ErrorCode:" + adError.getErrorCode() + "   ErrorMessage:" + adError.getErrorMessage());
        }

        @Override // com.ubix.ssp.ad.g.e
        public void onAdLoadSucceed() {
            if (this.f9061a != null) {
                u.e(c.f9060a, "onAdLoadSucceed in");
                this.f9061a.onAdLoadSucceed();
            }
            u.e(c.f9060a, "onAdLoadSucceed out");
        }
    }

    @Override // com.ubix.ssp.open.interstitial.UBiXInterstitialManager
    public void destroy() {
        com.ubix.ssp.ad.h.b bVar = this.b;
        if (bVar != null) {
            bVar.h();
            u.e(f9060a, "destroy");
        }
    }

    @Override // com.ubix.ssp.open.interstitial.UBiXInterstitialManager
    public String getBiddingToken() {
        com.ubix.ssp.ad.h.b bVar = this.b;
        if (bVar == null) {
            u.e(f9060a, "getBiddingToken:null");
            return null;
        }
        String strB = bVar.B();
        u.f("getBiddingToken:" + strB);
        return strB;
    }

    @Override // com.ubix.ssp.open.interstitial.UBiXInterstitialManager
    public ParamsReview getParamsReview() {
        if (this.b != null) {
            u.e(f9060a, "getParamsReview:" + this.b.C());
            return this.b.C();
        }
        u.e(f9060a, "getParamsReview: return null");
        return null;
    }

    @Override // com.ubix.ssp.open.interstitial.UBiXInterstitialManager
    public long getPrice() {
        if (this.b != null) {
            u.e(f9060a, "getPrice:" + this.b.D());
            return this.b.D();
        }
        u.e(f9060a, "getPrice: return 0");
        return 0L;
    }

    @Override // com.ubix.ssp.open.interstitial.UBiXInterstitialManager
    public boolean isValid() {
        if (this.b != null) {
            u.e(f9060a, "isValid:" + this.b.H());
            return this.b.H();
        }
        u.e(f9060a, "isValid: return false");
        return false;
    }

    @Override // com.ubix.ssp.open.interstitial.UBiXInterstitialManager
    public boolean isVideoAd() {
        if (this.b != null) {
            u.e(f9060a, "isVideoAd:" + this.b.I());
            return this.b.I();
        }
        u.e(f9060a, "isVideoAd: return false");
        return false;
    }

    @Override // com.ubix.ssp.open.interstitial.UBiXInterstitialManager
    public void loadAd() {
        com.ubix.ssp.ad.h.b bVar = this.b;
        if (bVar != null) {
            bVar.J();
            u.e(f9060a, h.Code);
        }
    }

    @Override // com.ubix.ssp.open.interstitial.UBiXInterstitialManager
    public void loadBiddingAd(String str) {
        if (this.b != null) {
            u.e(f9060a, "loadBiddingAd adm:" + str);
            this.b.h(str);
        }
    }

    @Override // com.ubix.ssp.open.interstitial.UBiXInterstitialManager
    public void loadInterstitialAd(Context context, String str, UBiXInterstitialAdListener uBiXInterstitialAdListener) {
        if (u.a()) {
            String str2 = f9060a;
            u.e(str2, "slot id:" + str + "   listener is null:" + (uBiXInterstitialAdListener == null) + "   context is null:" + (context == null));
            if (context != null) {
                u.e(str2, "context is activity:" + (context instanceof Activity));
            }
        }
        com.ubix.ssp.ad.h.b bVar = new com.ubix.ssp.ad.h.b(context, str);
        this.b = bVar;
        bVar.a((com.ubix.ssp.ad.g.e) new a(uBiXInterstitialAdListener));
    }

    @Override // com.ubix.ssp.open.interstitial.UBiXInterstitialManager
    public void lossNotice(UBiXAdLossInfo uBiXAdLossInfo) {
        if (uBiXAdLossInfo == null) {
            u.e(f9060a, "lossInfo is empty");
            return;
        }
        com.ubix.ssp.ad.h.b bVar = this.b;
        if (bVar != null) {
            bVar.b(uBiXAdLossInfo.getInfo());
            u.e(f9060a, "lossNotice");
        }
    }

    @Override // com.ubix.ssp.open.interstitial.UBiXInterstitialManager
    public void setExtraInfo(HashMap<String, String> map) {
        com.ubix.ssp.ad.h.b bVar = this.b;
        if (bVar != null) {
            bVar.a(map);
            u.e(f9060a, "setExtraInfo");
        }
    }

    @Override // com.ubix.ssp.open.interstitial.UBiXInterstitialManager
    public void showAd(Context context) {
        com.ubix.ssp.ad.h.b bVar = this.b;
        if (bVar != null) {
            bVar.c(context);
            u.e(f9060a, "showAd");
        }
    }

    @Override // com.ubix.ssp.open.interstitial.UBiXInterstitialManager
    public void winNotice(long j) {
        com.ubix.ssp.ad.h.b bVar = this.b;
        if (bVar != null) {
            bVar.a(j);
            u.e(f9060a, "winNotice");
        }
    }
}
