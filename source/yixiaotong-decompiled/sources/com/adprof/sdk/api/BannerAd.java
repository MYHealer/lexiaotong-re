package com.adprof.sdk.api;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.adprof.sdk.AdprofSdk;
import com.adprof.sdk.fn;
import com.adprof.sdk.h;
import com.adprof.sdk.i2;
import com.adprof.sdk.n4;
import com.adprof.sdk.oh;
import com.adprof.sdk.p5;
import com.adprof.sdk.pk;
import com.adprof.sdk.q1;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BannerAd extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BannerAdListener f1047a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public n4 f71a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f72a;
    public final boolean b;

    public BannerAd(AdRequest adRequest, BannerAdListener bannerAdListener) {
        this(adRequest, bannerAdListener, true, false);
    }

    public BannerAd(AdRequest adRequest, BannerAdListener bannerAdListener, boolean z, boolean z2) {
        super(adRequest);
        this.f1047a = bannerAdListener;
        this.f72a = z;
        this.b = z2;
        pk.a("BannerAd closeButton: " + z + " autoRefresh: " + z2);
    }

    @Override // com.adprof.sdk.h
    public AdError a() {
        AdRequest adRequest = ((h) this).f1199a;
        if (adRequest == null || TextUtils.isEmpty(adRequest.getCodeId())) {
            pk.b("PlacementId with AdRequest can't is null");
            return AdError.ERROR_AD_CODE_ID_EMPTY;
        }
        if (AdprofSdk.getInstance().isInit()) {
            return null;
        }
        pk.b("GtAdSdk not initialize");
        return AdError.ERROR_AD_NOT_INIT;
    }

    public void destroyAd() {
        pk.a("BannerAd destroyAd");
        n4 n4Var = this.f71a;
        if (n4Var != null) {
            n4Var.getClass();
            try {
                pk.a("BannerAdManager destroyAd");
                n4Var.f505a = true;
                ((p5) n4Var).f548a = i2.AdStatusNone;
                n4Var.g();
                n4Var.h();
                n4Var.f();
                n4Var.m691a();
                FrameLayout frameLayout = n4Var.f498a;
                if (frameLayout != null) {
                    frameLayout.removeAllViews();
                }
                n4Var.f500a = null;
                n4Var.f503a.clear();
                n4Var.f504a.clear();
                if (n4Var.f495a != null) {
                    q1.m710a().b(n4Var);
                    n4Var.f495a = null;
                }
                Handler handler = n4Var.f497a;
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
                Handler handler2 = n4Var.f507b;
                if (handler2 != null) {
                    handler2.removeCallbacksAndMessages(null);
                }
            } catch (Throwable th) {
                pk.a(th);
                oh.b(th);
            }
            this.f71a = null;
        }
        ((h) this).f325a = null;
    }

    public View getBannerView() {
        pk.a("BannerAd getBannerView");
        try {
            if (this.f71a == null || !isReady()) {
                return null;
            }
            return this.f71a.a();
        } catch (Throwable th) {
            pk.a(th);
            oh.b(th);
            return null;
        }
    }

    @Override // com.adprof.sdk.h
    public int getBidPrice() {
        n4 n4Var = this.f71a;
        if (n4Var != null) {
            return n4Var.getBidPrice();
        }
        return 0;
    }

    @Override // com.adprof.sdk.h
    public Map<String, Object> getExtraInfo() {
        n4 n4Var = this.f71a;
        if (n4Var == null) {
            return new HashMap();
        }
        HashMap map = new HashMap();
        map.put("codeId", ((p5) n4Var).f550a);
        map.put("loadId", ((p5) n4Var).b);
        return map;
    }

    public boolean isReady() {
        n4 n4Var = this.f71a;
        return n4Var != null && ((p5) n4Var).f548a == i2.AdStatusReady;
    }

    public void loadAd() {
        try {
            pk.a("BannerAd loadAd");
            final AdError adErrorA = a();
            fn.a(new fn.b() { // from class: com.adprof.sdk.api.BannerAd.1
                @Override // com.adprof.sdk.fn.a
                public void callback(Exception exc) {
                    BannerAdListener bannerAdListener;
                    AdError adError = adErrorA;
                    if (adError == null || (bannerAdListener = BannerAd.this.f1047a) == null) {
                        return;
                    }
                    bannerAdListener.onBannerAdLoadError(adError);
                }
            });
            if (adErrorA != null) {
                return;
            }
            n4 n4Var = new n4(((h) this).f1199a, this.f1047a, this.f72a, this.b);
            this.f71a = n4Var;
            ((h) this).f325a = n4Var;
            ((h) this).f324a = i2.AdStatusLoading;
            n4Var.a(true);
        } catch (Throwable th) {
            oh.b(th);
            pk.d("BannerAd load = " + Log.getStackTraceString(th));
        }
    }

    @Override // com.adprof.sdk.api.IBiddingNotify
    public void sendLossNotify(Map<String, Object> map) {
        pk.a("BannerAd sendLossNotification " + this.f71a + "  map = " + map);
        n4 n4Var = this.f71a;
        if (n4Var != null) {
            n4Var.sendLossNotify(map);
        }
    }

    @Override // com.adprof.sdk.api.IBiddingNotify
    public void sendWinNotify(Map<String, Object> map) {
        pk.a("BannerAd sendWinNotification " + this.f71a + "  map = " + map);
        n4 n4Var = this.f71a;
        if (n4Var != null) {
            n4Var.sendWinNotify(map);
        }
    }

    public void stopAutoRefresh() {
        pk.a("BannerAd stopAutoRefresh");
        try {
            n4 n4Var = this.f71a;
            if (n4Var != null) {
                n4Var.g();
            }
        } catch (Throwable th) {
            pk.a(th);
            oh.b(th);
        }
    }
}
