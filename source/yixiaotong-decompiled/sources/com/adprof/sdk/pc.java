package com.adprof.sdk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.adprof.sdk.api.AdError;
import com.adprof.sdk.api.AdRequest;
import com.adprof.sdk.api.InterstitialAdListener;
import com.adprof.sdk.api.RewardAdListener;
import com.adprof.sdk.base.activity.LandTransparentAdActivity;
import com.adprof.sdk.base.activity.PortraitTransparentAdActivity;
import com.huawei.openalliance.ad.constant.br;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class pc extends p5 implements h7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InterstitialAdListener f1363a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public RewardAdListener f571a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final jo f572a;

    public pc(AdRequest adRequest, InterstitialAdListener interstitialAdListener, RewardAdListener rewardAdListener, int i) {
        super(adRequest);
        ((p5) this).f548a = i2.AdStatusNone;
        this.f1363a = interstitialAdListener;
        this.f571a = rewardAdListener;
        wd wdVar = new wd(adRequest, i);
        ((p5) this).f549a = wdVar;
        this.f572a = new jo(wdVar, this);
    }

    public void a() {
        ho hoVar;
        pk.c("InterstitialAdManager destroyAd ---------");
        this.f1363a = null;
        this.f571a = null;
        jo joVar = this.f572a;
        if (joVar != null && (hoVar = joVar.f406a) != null) {
            hoVar.b();
            joVar.f406a = null;
        }
        ((p5) this).f548a = i2.AdStatusNone;
        d dVar = ((p5) this).f546a;
        if (dVar != null) {
            dVar.m596a();
            ((p5) this).f546a = null;
        }
        fn.a aVar = ((p5) this).f547a;
        if (aVar != null) {
            aVar.cancel();
            ((p5) this).f547a = null;
        }
    }

    @Override // com.adprof.sdk.p5
    public void a(int i, String str, String str2, wd wdVar) {
        a(i, str);
    }

    public void a(d dVar) {
        ((p5) this).f548a = i2.AdStatusPlaying;
        if (dVar != null) {
            dVar.f201c = true;
        }
        if (m702a()) {
            this.f1363a.onInterstitialAdShow();
        }
        if (m703b()) {
            this.f571a.onRewardAdShow();
        }
    }

    @Override // com.adprof.sdk.p5
    public void a(d dVar, String str) {
        if (m699a(dVar, str)) {
            fn.a(new nc(this));
        }
    }

    @Override // com.adprof.sdk.p5
    public void a(List list, wd wdVar) {
        try {
            if (a((d) list.get(0))) {
                fn.a(new mc(this));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final boolean m702a() {
        d dVar = ((p5) this).f546a;
        if (dVar != null) {
            return dVar.m602c() && this.f1363a != null;
        }
        return this.f1363a != null;
    }

    @Override // com.adprof.sdk.p5
    public boolean a(AdError adError, boolean z, String str) {
        if (!super.a(adError, z, str)) {
            return false;
        }
        fn.a(new lc(this, z, adError));
        return false;
    }

    public void b() {
        pk.c("---onAdClicked----");
        ((p5) this).f548a = i2.AdStatusClick;
        d dVar = ((p5) this).f546a;
        if (dVar != null) {
            dVar.g = 0;
        }
        if (dVar != null && dVar.m600b()) {
            pk.d("InterstitialAdManager onAdClicked --------- mc ");
            h2.a(((p5) this).f546a);
            return;
        }
        if (m702a()) {
            this.f1363a.onInterstitialAdClick();
        }
        if (m703b()) {
            this.f571a.onRewardAdClick();
        }
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public final boolean m703b() {
        d dVar = ((p5) this).f546a;
        if (dVar != null) {
            return dVar.m606g() && this.f571a != null;
        }
        return this.f571a != null;
    }

    public void c() {
        pk.c("InterstitialAdManager onLandPageClose---------");
        oh.a("landing_page_close", "", ((p5) this).f546a);
    }

    public void d() {
        pk.c("InterstitialAdManager onLandPageShow---------");
        oh.a("landing_page_show", "", ((p5) this).f546a);
    }

    public final void e() {
        kl klVar;
        ((p5) this).f548a = i2.AdStatusClose;
        d dVar = ((p5) this).f546a;
        if (dVar != null && (klVar = dVar.f185a) != null) {
            ((a2) klVar).b(dVar);
        }
        if (m702a()) {
            this.f1363a.onInterstitialAdClosed();
        }
        if (m703b()) {
            this.f571a.onRewardAdClosed();
        }
        a();
    }

    public void f(Activity activity) {
        if (activity == null) {
            a(AdError.ERROR_AD_ACTIVITY_IS_NULL, false, "play");
            return;
        }
        d dVar = ((p5) this).f546a;
        if (dVar != null && !dVar.m604e()) {
            a(AdError.ERROR_AD_EXPIRED, false, "play");
            return;
        }
        d dVar2 = ((p5) this).f546a;
        if (dVar2.f185a == null) {
            new a2().a(dVar2);
        }
        d dVar3 = ((p5) this).f546a;
        if (dVar3 != null) {
            dVar3.f199b = ((p5) this).f549a.f794a.getOrientation() == 0;
        }
        h2.a(((p5) this).f546a);
        Bundle bundle = new Bundle();
        bundle.putBoolean("enableKeepOn", true);
        bundle.putBoolean("enableScreenLockDisplayAd", true);
        jo joVar = this.f572a;
        if (joVar == null) {
            a(AdError.ERROR_AD_PLAY, false, "play");
            return;
        }
        d dVar4 = ((p5) this).f546a;
        joVar.getClass();
        if (joVar.f1254a instanceof pc) {
            ho hoVar = new ho(dVar4, (pc) joVar.f1254a, dVar4.k());
            joVar.f406a = hoVar;
            hoVar.m715a();
        }
        h2.a(dVar4);
        String str = dVar4.m606g() ? "reward_act" : "interstitial_act";
        bundle.putBoolean("isHalfInterstitial", true);
        String strK = dVar4.k();
        wd wdVar = joVar.f407a;
        boolean z = j5.f1243a;
        try {
            Intent intentA = j5.a(activity, wdVar.f794a.getOrientation() == 0 ? PortraitTransparentAdActivity.class : LandTransparentAdActivity.class, strK, str);
            intentA.putExtras(bundle);
            boolean z2 = j5.f1243a;
            activity.startActivity(intentA);
        } catch (Throwable th) {
            HashMap map = new HashMap();
            map.put("error", th.getMessage());
            s5.a(strK, map, "action.reward.video.play.fail", 0);
        }
    }

    @Override // com.adprof.sdk.p5
    public int getBidPrice() {
        d dVar = ((p5) this).f546a;
        return dVar != null ? dVar.b : super.getBidPrice();
    }

    @Override // com.adprof.sdk.p5
    public void a(AdError adError) {
        if (super.a(adError, true, "respond_timeout")) {
            fn.a(new lc(this, true, adError));
        }
    }

    public void a(String str) {
        AdError adError = AdError.ERROR_AD_PLAY;
        adError.setMessage(str);
        if (super.a(adError, false, br.b.V)) {
            fn.a(new lc(this, false, adError));
        }
    }
}
