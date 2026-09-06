package com.ubix.ssp.open.manager;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.openalliance.ad.constant.h;
import com.ubix.ssp.ad.e.a0.u;
import com.ubix.ssp.ad.g.i;
import com.ubix.ssp.open.AdError;
import com.ubix.ssp.open.ParamsReview;
import com.ubix.ssp.open.UBiXAdLossInfo;
import com.ubix.ssp.open.splash.UBiXSplashAdListener;
import com.ubix.ssp.open.splash.UBiXSplashManager;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class g implements UBiXSplashManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9070a = "g";
    private transient com.ubix.ssp.ad.j.b b;

    class a implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ UBiXSplashAdListener f9071a;

        a(UBiXSplashAdListener uBiXSplashAdListener) {
            this.f9071a = uBiXSplashAdListener;
        }

        @Override // com.ubix.ssp.ad.g.i
        public void onAdClicked(View view) {
            if (this.f9071a != null) {
                u.e(g.f9070a, "onAdClicked in");
                this.f9071a.onAdClicked();
            }
            u.e(g.f9070a, "onAdClicked out");
        }

        @Override // com.ubix.ssp.ad.g.i
        public void onAdClosed() {
            if (this.f9071a != null) {
                u.e(g.f9070a, "onAdClosed in");
                this.f9071a.onAdClosed();
            }
            u.e(g.f9070a, "onAdClosed out");
        }

        @Override // com.ubix.ssp.ad.g.i
        public void onAdExposeFailed(AdError adError) {
            if (this.f9071a != null) {
                u.c(g.f9070a, "onAdExposeFailed in");
                this.f9071a.onAdExposeFailed(adError);
            }
            u.c(g.f9070a, "onAdExposeFailed out: ErrorCode:" + adError.getErrorCode() + "   ErrorMessage:" + adError.getErrorMessage());
        }

        @Override // com.ubix.ssp.ad.g.i
        public void onAdExposed() {
            if (this.f9071a != null) {
                u.e(g.f9070a, "onAdExposed in");
                this.f9071a.onAdExposed();
            }
            u.e(g.f9070a, "onAdExposed out");
        }

        @Override // com.ubix.ssp.ad.g.i
        public void onAdLoadFailed(AdError adError) {
            if (this.f9071a != null) {
                u.c(g.f9070a, "onAdLoadFailed in");
                this.f9071a.onAdLoadFailed(adError);
            }
            u.c(g.f9070a, "onAdLoadFailed out: ErrorCode:" + adError.getErrorCode() + "   ErrorMessage:" + adError.getErrorMessage());
        }

        @Override // com.ubix.ssp.ad.g.i
        public void onAdLoadSucceed() {
            if (this.f9071a != null) {
                u.e(g.f9070a, "onAdLoadSucceed in");
                this.f9071a.onAdLoadSucceed();
            }
            u.e(g.f9070a, "onAdLoadSucceed out");
        }

        @Override // com.ubix.ssp.ad.g.i
        public void onAdResponseSucceed() {
            if (this.f9071a != null) {
                u.e(g.f9070a, "onAdResponseSucceed in");
                this.f9071a.onAdResponseSucceed();
            }
            u.e(g.f9070a, "onAdResponseSucceed out");
        }

        @Override // com.ubix.ssp.ad.g.i
        public void onAdSkipped() {
            if (this.f9071a != null) {
                u.e(g.f9070a, "onAdSkipped in");
                this.f9071a.onAdSkipped();
            }
            u.e(g.f9070a, "onAdSkipped out");
        }
    }

    @Override // com.ubix.ssp.open.splash.UBiXSplashManager
    public void destroy() {
        com.ubix.ssp.ad.j.b bVar = this.b;
        if (bVar != null) {
            bVar.h();
        }
        u.e(f9070a, "destroy");
    }

    @Override // com.ubix.ssp.open.splash.UBiXSplashManager
    public String getBiddingToken() {
        com.ubix.ssp.ad.j.b bVar = this.b;
        if (bVar == null) {
            u.e(f9070a, "getBiddingToken:null");
            return null;
        }
        String strB = bVar.B();
        u.f("getBiddingToken:" + strB);
        return strB;
    }

    @Override // com.ubix.ssp.open.splash.UBiXSplashManager
    public ParamsReview getParamsReview() {
        if (this.b == null) {
            return null;
        }
        u.e(f9070a, "getParamsReview:" + this.b.C());
        return this.b.C();
    }

    @Override // com.ubix.ssp.open.splash.UBiXSplashManager
    public long getPrice() {
        if (this.b != null) {
            u.e(f9070a, "getPrice:" + this.b.D());
            return this.b.D();
        }
        u.e(f9070a, "getPrice: return 0");
        return 0L;
    }

    @Override // com.ubix.ssp.open.splash.UBiXSplashManager
    public String getRequestId() {
        com.ubix.ssp.ad.j.b bVar = this.b;
        if (bVar != null) {
            return bVar.E();
        }
        return null;
    }

    @Override // com.ubix.ssp.open.splash.UBiXSplashManager
    public boolean isValid() {
        if (this.b != null) {
            u.e(f9070a, "isValid:" + this.b.D());
            return this.b.M();
        }
        u.e(f9070a, "isValid: return false");
        return false;
    }

    @Override // com.ubix.ssp.open.splash.UBiXSplashManager
    public void loadAd() {
        com.ubix.ssp.ad.j.b bVar = this.b;
        if (bVar != null) {
            bVar.O();
            u.e(f9070a, h.Code);
        }
    }

    @Override // com.ubix.ssp.open.splash.UBiXSplashManager
    public void loadBiddingAd(String str) {
        com.ubix.ssp.ad.j.b bVar = this.b;
        if (bVar != null) {
            bVar.h(str);
            u.e(f9070a, "loadBiddingAd adm:" + str);
        }
    }

    @Override // com.ubix.ssp.open.splash.UBiXSplashManager
    public void loadSplashAd(Context context, String str, UBiXSplashAdListener uBiXSplashAdListener) {
        if (u.a()) {
            String str2 = f9070a;
            u.e(str2, "slot id:" + str + "   listener is null:" + (uBiXSplashAdListener == null) + "   context is null:" + (context == null));
            if (context != null) {
                u.e(str2, "context is activity:" + (context instanceof Activity));
            }
        }
        com.ubix.ssp.ad.j.b bVar = new com.ubix.ssp.ad.j.b(context, str);
        this.b = bVar;
        bVar.a((i) new a(uBiXSplashAdListener));
    }

    @Override // com.ubix.ssp.open.splash.UBiXSplashManager
    public void lossNotice(UBiXAdLossInfo uBiXAdLossInfo) {
        if (uBiXAdLossInfo == null) {
            u.e(f9070a, "lossInfo is empty");
            return;
        }
        com.ubix.ssp.ad.j.b bVar = this.b;
        if (bVar != null) {
            bVar.b(uBiXAdLossInfo.getInfo());
            u.e(f9070a, "lossNotice");
        }
    }

    @Override // com.ubix.ssp.open.splash.UBiXSplashManager
    public void setExtraInfo(HashMap<String, String> map) {
        com.ubix.ssp.ad.j.b bVar = this.b;
        if (bVar != null) {
            bVar.a(map);
            u.e(f9070a, "setExtraInfo");
        }
    }

    @Override // com.ubix.ssp.open.splash.UBiXSplashManager
    public void setMaxTimeout(int i) {
        com.ubix.ssp.ad.j.b bVar = this.b;
        if (bVar != null) {
            bVar.r(i * 1000);
        }
        u.e(f9070a, "setMaxTimeout:" + i);
    }

    @Override // com.ubix.ssp.open.splash.UBiXSplashManager
    public void setSkipTime(int i) {
        com.ubix.ssp.ad.j.b bVar = this.b;
        if (bVar != null) {
            bVar.s(i);
        }
        u.e(f9070a, "setSkipTime:" + i);
    }

    @Override // com.ubix.ssp.open.splash.UBiXSplashManager
    public void showAd(ViewGroup viewGroup) {
        com.ubix.ssp.ad.j.b bVar = this.b;
        if (bVar != null) {
            bVar.a(viewGroup);
            u.e(f9070a, "showAd");
        }
    }

    @Override // com.ubix.ssp.open.splash.UBiXSplashManager
    public void winNotice(long j) {
        com.ubix.ssp.ad.j.b bVar = this.b;
        if (bVar != null) {
            bVar.a(j);
            u.e(f9070a, "winNotice");
        }
    }
}
