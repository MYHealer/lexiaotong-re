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
import com.ubix.ssp.open.icon.UBiXIconAdListener;
import com.ubix.ssp.open.icon.UBiXIconManager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b implements UBiXIconManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9058a = "b";
    private com.ubix.ssp.ad.f.b b;

    class a implements com.ubix.ssp.ad.g.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ UBiXIconAdListener f9059a;

        a(UBiXIconAdListener uBiXIconAdListener) {
            this.f9059a = uBiXIconAdListener;
        }

        @Override // com.ubix.ssp.ad.g.d
        public void onAdClicked(View view) {
            if (this.f9059a != null) {
                u.e(b.f9058a, "onAdClicked in");
                this.f9059a.onAdClicked();
            }
            u.e(b.f9058a, "onAdClicked out");
        }

        @Override // com.ubix.ssp.ad.g.d
        public void onAdClosed() {
            if (this.f9059a != null) {
                u.e(b.f9058a, "onAdClosed in");
                this.f9059a.onAdClosed();
            }
            u.e(b.f9058a, "onAdClosed out");
        }

        @Override // com.ubix.ssp.ad.g.d
        public void onAdExposeFailed(AdError adError) {
            if (this.f9059a != null) {
                u.c(b.f9058a, "onAdExposeFailed in");
                this.f9059a.onAdExposeFailed(adError);
            }
            u.c(b.f9058a, "onAdExposeFailed out: ErrorCode:" + adError.getErrorCode() + "   ErrorMessage:" + adError.getErrorMessage());
        }

        @Override // com.ubix.ssp.ad.g.d
        public void onAdExposed() {
            if (this.f9059a != null) {
                u.e(b.f9058a, "onAdExposed in");
                this.f9059a.onAdExposed();
            }
            u.e(b.f9058a, "onAdExposed out");
        }

        @Override // com.ubix.ssp.ad.g.d
        public void onAdLoadFailed(AdError adError) {
            if (this.f9059a != null) {
                u.c(b.f9058a, "onAdLoadFailed in");
                this.f9059a.onAdLoadFailed(adError);
            }
            u.c(b.f9058a, "onAdLoadFailed out: ErrorCode:" + adError.getErrorCode() + "   ErrorMessage:" + adError.getErrorMessage());
        }

        @Override // com.ubix.ssp.ad.g.d
        public void onAdLoadSucceed() {
            if (this.f9059a != null) {
                u.e(b.f9058a, "onAdLoadSucceed in");
                this.f9059a.onAdLoadSucceed();
            }
            u.e(b.f9058a, "onAdLoadSucceed out");
        }
    }

    @Override // com.ubix.ssp.open.icon.UBiXIconManager
    public void destroy() {
        com.ubix.ssp.ad.f.b bVar = this.b;
        if (bVar != null) {
            bVar.a();
            u.e(f9058a, "destroy");
        }
    }

    @Override // com.ubix.ssp.open.icon.UBiXIconManager
    public String getBiddingToken() {
        com.ubix.ssp.ad.f.b bVar = this.b;
        if (bVar == null) {
            u.e(f9058a, "getBiddingToken:null");
            return null;
        }
        String strB = bVar.b();
        u.f("getBiddingToken:" + strB);
        return strB;
    }

    @Override // com.ubix.ssp.open.icon.UBiXIconManager
    public View getIconView() {
        if (this.b != null) {
            u.e(f9058a, "getIconView:" + this.b.c());
            return this.b.c();
        }
        u.e(f9058a, "getIconView: return null");
        return null;
    }

    @Override // com.ubix.ssp.open.icon.UBiXIconManager
    public ParamsReview getParamsReview() {
        if (this.b != null) {
            u.e(f9058a, "getParamsReview:" + this.b.d());
            return this.b.d();
        }
        u.e(f9058a, "getParamsReview: return null");
        return null;
    }

    @Override // com.ubix.ssp.open.icon.UBiXIconManager
    public long getPrice() {
        if (this.b != null) {
            u.e(f9058a, "getPrice:" + this.b.e());
            return this.b.e();
        }
        u.e(f9058a, "getPrice: return 0");
        return 0L;
    }

    @Override // com.ubix.ssp.open.icon.UBiXIconManager
    public boolean isValid() {
        if (this.b != null) {
            u.e(f9058a, "isValid:" + this.b.f());
            return this.b.f();
        }
        u.e(f9058a, "isValid: return false");
        return false;
    }

    @Override // com.ubix.ssp.open.icon.UBiXIconManager
    public void loadAd() {
        com.ubix.ssp.ad.f.b bVar = this.b;
        if (bVar != null) {
            bVar.g();
            u.e(f9058a, h.Code);
        }
    }

    @Override // com.ubix.ssp.open.icon.UBiXIconManager
    public void loadBiddingAd(String str) {
        com.ubix.ssp.ad.f.b bVar = this.b;
        if (bVar != null) {
            bVar.a(str);
            u.e(f9058a, "loadBiddingAd adm:" + str);
        }
    }

    @Override // com.ubix.ssp.open.icon.UBiXIconManager
    public void loadIconAd(Context context, String str, AdSize adSize, UBiXIconAdListener uBiXIconAdListener) {
        if (u.a()) {
            String str2 = f9058a;
            u.e(str2, "slot id:" + str + "   AdSize:" + adSize + "   listener is null:" + (uBiXIconAdListener == null) + "   context is null:" + (context == null));
            if (context != null) {
                u.e(str2, "context is activity:" + (context instanceof Activity));
            }
        }
        com.ubix.ssp.ad.f.b bVar = new com.ubix.ssp.ad.f.b(context, str, adSize);
        this.b = bVar;
        bVar.a(new a(uBiXIconAdListener));
    }

    @Override // com.ubix.ssp.open.icon.UBiXIconManager
    public void lossNotice(UBiXAdLossInfo uBiXAdLossInfo) {
        if (uBiXAdLossInfo == null) {
            u.e(f9058a, "lossInfo is empty");
            return;
        }
        com.ubix.ssp.ad.f.b bVar = this.b;
        if (bVar != null) {
            bVar.a(uBiXAdLossInfo.getInfo());
            u.e(f9058a, "lossNotice");
        }
    }

    @Override // com.ubix.ssp.open.icon.UBiXIconManager
    public void winNotice(long j) {
        com.ubix.ssp.ad.f.b bVar = this.b;
        if (bVar != null) {
            bVar.a(j);
            u.e(f9058a, "winNotice");
        }
    }
}
