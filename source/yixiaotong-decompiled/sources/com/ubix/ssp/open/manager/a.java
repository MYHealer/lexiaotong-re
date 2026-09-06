package com.ubix.ssp.open.manager;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.huawei.openalliance.ad.constant.h;
import com.ubix.ssp.ad.e.a0.u;
import com.ubix.ssp.open.AdError;
import com.ubix.ssp.open.AdSize;
import com.ubix.ssp.open.ParamsReview;
import com.ubix.ssp.open.UBiXAdLossInfo;
import com.ubix.ssp.open.banner.UBiXBannerAdListener;
import com.ubix.ssp.open.banner.UBiXBannerManager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a implements UBiXBannerManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9056a = "a";
    private com.ubix.ssp.ad.c.b b;

    /* JADX INFO: renamed from: com.ubix.ssp.open.manager.a$a, reason: collision with other inner class name */
    class C1126a implements com.ubix.ssp.ad.g.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ UBiXBannerAdListener f9057a;

        C1126a(UBiXBannerAdListener uBiXBannerAdListener) {
            this.f9057a = uBiXBannerAdListener;
        }

        @Override // com.ubix.ssp.ad.g.a
        public void onAdClicked() {
            if (this.f9057a != null) {
                u.e(a.f9056a, "onAdClicked in");
                this.f9057a.onAdClicked();
            }
            u.e(a.f9056a, "onAdClicked out");
        }

        @Override // com.ubix.ssp.ad.g.a
        public void onAdClosed() {
            if (this.f9057a != null) {
                u.e(a.f9056a, "onAdClosed in");
                this.f9057a.onAdClosed();
            }
            u.e(a.f9056a, "onAdClosed out");
        }

        @Override // com.ubix.ssp.ad.g.a
        public void onAdExposeFailed(AdError adError) {
            if (this.f9057a != null) {
                u.c(a.f9056a, "onAdExposeFailed in");
                this.f9057a.onAdExposeFailed(adError);
            }
            u.c(a.f9056a, "onAdExposeFailed out: ErrorCode:" + adError.getErrorCode() + "   ErrorMessage:" + adError.getErrorMessage());
        }

        @Override // com.ubix.ssp.ad.g.a
        public void onAdExposed() {
            if (this.f9057a != null) {
                u.e(a.f9056a, "onAdExposed in");
                this.f9057a.onAdExposed();
            }
            u.e(a.f9056a, "onAdExposed out");
        }

        @Override // com.ubix.ssp.ad.g.a
        public void onAdLoadFailed(AdError adError) {
            if (this.f9057a != null) {
                u.c(a.f9056a, "onAdLoadFailed in");
                this.f9057a.onAdLoadFailed(adError);
            }
            u.c(a.f9056a, "onAdLoadFailed out: ErrorCode:" + adError.getErrorCode() + "   ErrorMessage:" + adError.getErrorMessage());
        }

        @Override // com.ubix.ssp.ad.g.a
        public void onAdLoadSucceed() {
            if (this.f9057a != null) {
                u.e(a.f9056a, "onAdLoadSucceed in");
                this.f9057a.onAdLoadSucceed();
            }
            u.e(a.f9056a, "onAdLoadSucceed out");
        }
    }

    @Override // com.ubix.ssp.open.banner.UBiXBannerManager
    public void destroy() {
        com.ubix.ssp.ad.c.b bVar = this.b;
        if (bVar != null) {
            bVar.L();
            u.e(f9056a, "destroy");
        }
    }

    @Override // com.ubix.ssp.open.banner.UBiXBannerManager
    public View getBannerView() {
        if (this.b != null) {
            u.e(f9056a, "getBannerView:" + this.b.C());
            return this.b.C();
        }
        u.e(f9056a, "getBannerView: return null");
        return null;
    }

    @Override // com.ubix.ssp.open.banner.UBiXBannerManager
    public ParamsReview getParamsReview() {
        if (this.b != null) {
            u.e(f9056a, "getParamsReview:" + this.b.D());
            return this.b.D();
        }
        u.e(f9056a, "getParamsReview: return null");
        return null;
    }

    @Override // com.ubix.ssp.open.banner.UBiXBannerManager
    public long getPrice() {
        if (this.b != null) {
            u.e(f9056a, "getPrice:" + this.b.E());
            return this.b.E();
        }
        u.e(f9056a, "getPrice: return 0");
        return 0L;
    }

    @Override // com.ubix.ssp.open.banner.UBiXBannerManager
    public boolean isValid() {
        if (this.b != null) {
            u.e(f9056a, "isValid:" + this.b.H());
            return this.b.H();
        }
        u.e(f9056a, "isValid: return false");
        return false;
    }

    @Override // com.ubix.ssp.open.banner.UBiXBannerManager
    public void loadAd() {
        com.ubix.ssp.ad.c.b bVar = this.b;
        if (bVar != null) {
            bVar.I();
            u.e(f9056a, h.Code);
        }
    }

    @Override // com.ubix.ssp.open.banner.UBiXBannerManager
    public void loadAd(int i) {
        com.ubix.ssp.ad.c.b bVar = this.b;
        if (bVar != null) {
            bVar.m(-1);
            u.e(f9056a, "loadAd with refreshTime: " + i);
        }
    }

    @Override // com.ubix.ssp.open.banner.UBiXBannerManager
    public void loadBannerAd(Context context, String str, AdSize adSize, UBiXBannerAdListener uBiXBannerAdListener) {
        if (u.a()) {
            String str2 = f9056a;
            u.e(str2, "slot id:" + str + "   AdSize:" + adSize + "   listener is null:" + (uBiXBannerAdListener == null) + "   context is null:" + (context == null));
            if (context != null) {
                u.e(str2, "context is activity:" + (context instanceof Activity));
            }
        }
        com.ubix.ssp.ad.c.b bVar = new com.ubix.ssp.ad.c.b(context, str, adSize);
        this.b = bVar;
        bVar.a((com.ubix.ssp.ad.g.a) new C1126a(uBiXBannerAdListener));
    }

    @Override // com.ubix.ssp.open.banner.UBiXBannerManager
    public void loadBannerAd(Context context, String str, UBiXBannerAdListener uBiXBannerAdListener) {
        loadBannerAd(context, str, null, uBiXBannerAdListener);
    }

    @Override // com.ubix.ssp.open.banner.UBiXBannerManager
    public void lossNotice(UBiXAdLossInfo uBiXAdLossInfo) {
        if (uBiXAdLossInfo == null) {
            u.e(f9056a, "lossInfo is empty");
            return;
        }
        com.ubix.ssp.ad.c.b bVar = this.b;
        if (bVar != null) {
            bVar.b(uBiXAdLossInfo.getInfo());
            u.e(f9056a, "lossNotice");
        }
    }

    @Override // com.ubix.ssp.open.banner.UBiXBannerManager
    public void winNotice(long j) {
        com.ubix.ssp.ad.c.b bVar = this.b;
        if (bVar != null) {
            bVar.a(j);
            u.e(f9056a, "winNotice");
        }
    }
}
