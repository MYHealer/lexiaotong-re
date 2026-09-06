package com.adprof.sdk.api;

import android.app.Activity;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import com.adprof.sdk.an;
import com.adprof.sdk.fn;
import com.adprof.sdk.h;
import com.adprof.sdk.hm;
import com.adprof.sdk.hp;
import com.adprof.sdk.pk;
import com.adprof.sdk.q1;
import com.adprof.sdk.qm;
import com.adprof.sdk.z1;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class SplashAd extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SplashAdListener f1058a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public hm f81a;

    public SplashAd(AdRequest adRequest, SplashAdListener splashAdListener) {
        super(adRequest);
        a(adRequest, splashAdListener, 0L);
    }

    public SplashAd(AdRequest adRequest, SplashAdListener splashAdListener, long j) {
        super(adRequest);
        a(adRequest, splashAdListener, j);
    }

    public final void a(AdRequest adRequest, SplashAdListener splashAdListener, long j) {
        pk.a("SplashAd init: " + adRequest + " l: " + splashAdListener);
        this.f1058a = splashAdListener;
        hm hmVar = new hm(adRequest, splashAdListener, j);
        this.f81a = hmVar;
        ((h) this).f325a = hmVar;
    }

    public void destroyAd() {
        pk.a("SplashAd destroyAd");
        hm hmVar = this.f81a;
        if (hmVar != null) {
            hmVar.b();
        }
        if (this.f1058a != null) {
            this.f1058a = null;
        }
        q1.m710a().b(((h) this).f326a);
    }

    public boolean isReady() {
        hm hmVar = this.f81a;
        boolean z = hmVar != null && hmVar.m655a();
        pk.a("SplashAd isReady:  " + this.f81a + PPSLabelView.Code + z);
        return z;
    }

    public void loadAd() {
        try {
            pk.a("SplashAd loadAd");
            final AdError adErrorA = a();
            if (adErrorA != null && this.f1058a != null) {
                fn.a(new fn.b() { // from class: com.adprof.sdk.api.SplashAd.1
                    @Override // com.adprof.sdk.fn.a
                    public void callback(Exception exc) {
                        SplashAd.this.f1058a.onSplashAdLoadFail(adErrorA);
                    }
                });
                return;
            }
            if (isReady()) {
                fn.a(new fn.b() { // from class: com.adprof.sdk.api.SplashAd.2
                    @Override // com.adprof.sdk.fn.a
                    public void callback(Exception exc) {
                        SplashAdListener splashAdListener = SplashAd.this.f1058a;
                        if (splashAdListener != null) {
                            splashAdListener.onAdLoadSuccess();
                            SplashAd.this.f1058a.onAdCacheSuccess();
                        }
                    }
                });
                return;
            }
            q1.m710a().a(((h) this).f326a);
            hm hmVar = this.f81a;
            if (hmVar.f1215a <= 0) {
                z1.a().getClass();
                hmVar.f1215a = 5000L;
            }
            hmVar.a(hmVar.f1215a);
        } catch (Exception e) {
            pk.a("---SplashAd loadAd Exception: " + e.getMessage());
        }
    }

    public void onConfigurationChanged(Activity activity, Configuration configuration) {
        qm qmVar;
        hm hmVar = this.f81a;
        if (hmVar == null || hmVar.f366a == null || activity != hp.a((View) hmVar.f364a) || (qmVar = hmVar.f366a.f147a) == null || !(qmVar instanceof an)) {
            return;
        }
    }

    @Override // com.adprof.sdk.api.IBiddingNotify
    public void sendLossNotify(Map<String, Object> map) {
        pk.a("SplashAd sendLossNotification " + this.f81a + " map = " + map);
        hm hmVar = this.f81a;
        if (hmVar != null) {
            hmVar.sendLossNotify(map);
        }
    }

    @Override // com.adprof.sdk.api.IBiddingNotify
    public void sendWinNotify(Map<String, Object> map) {
        pk.a("SplashAd sendWinNotification " + this.f81a + " map = " + map);
        hm hmVar = this.f81a;
        if (hmVar != null) {
            hmVar.sendWinNotify(map);
        }
    }

    public void showAd(ViewGroup viewGroup) {
        try {
            pk.a("SplashAd showAd: " + viewGroup);
            this.f81a.a(viewGroup);
        } catch (Exception unused) {
        }
    }
}
