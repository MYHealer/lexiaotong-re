package com.adprof.sdk.api;

import android.app.Activity;
import android.util.Log;
import com.adprof.sdk.AdprofSdk;
import com.adprof.sdk.bg;
import com.adprof.sdk.d;
import com.adprof.sdk.fn;
import com.adprof.sdk.h;
import com.adprof.sdk.i2;
import com.adprof.sdk.jo;
import com.adprof.sdk.oh;
import com.adprof.sdk.p5;
import com.adprof.sdk.pc;
import com.adprof.sdk.pk;
import com.adprof.sdk.q1;
import com.adprof.sdk.z1;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import java.io.File;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class InterstitialAd extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InterstitialAdListener f1050a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public pc f74a;

    public InterstitialAd(AdRequest adRequest, InterstitialAdListener interstitialAdListener) {
        super(adRequest);
        a(adRequest, interstitialAdListener);
    }

    public final void a(final AdError adError) {
        fn.a(new fn.b() { // from class: com.adprof.sdk.api.InterstitialAd.3
            @Override // com.adprof.sdk.fn.a
            public void callback(Exception exc) {
                InterstitialAd interstitialAd = InterstitialAd.this;
                ((h) interstitialAd).f324a = i2.AdStatusNone;
                pk.a(String.format("InterstitialAd invoke onInterstitialAdShowError l: %s  error = %s", interstitialAd.f1050a, adError));
                InterstitialAdListener interstitialAdListener = InterstitialAd.this.f1050a;
                if (interstitialAdListener != null) {
                    interstitialAdListener.onInterstitialAdShowError(adError);
                }
            }
        }, 0L);
    }

    public void a(AdRequest adRequest, InterstitialAdListener interstitialAdListener) {
        pk.a(String.format("InterstitialAd init: %s l: %s", adRequest, interstitialAdListener));
        if (interstitialAdListener != null) {
            this.f1050a = interstitialAdListener;
        }
        pc pcVar = new pc(adRequest, this.f1050a, null, 4);
        this.f74a = pcVar;
        ((h) this).f325a = pcVar;
    }

    public void destroyAd() {
        try {
            pk.a("InterstitialAd  destroyAd");
            pc pcVar = this.f74a;
            if (pcVar != null) {
                pcVar.a();
            }
            if (this.f1050a != null) {
                this.f1050a = null;
            }
            q1.m710a().b(((h) this).f326a);
        } catch (Exception e) {
            pk.a(e);
            oh.b(e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0055 A[Catch: all -> 0x005f, TRY_LEAVE, TryCatch #0 {all -> 0x005f, blocks: (B:5:0x001a, B:7:0x001e, B:9:0x002f, B:11:0x0035, B:14:0x003a, B:16:0x0040, B:18:0x0049, B:20:0x004f, B:22:0x0055), top: B:30:0x001a }] */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005b, code lost:
    
        if (((com.adprof.sdk.p5) r0).f546a.m604e() != false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isReady() {
        pk.a(String.format("InterstitialAd isReady: %s  %s", ((h) this).f327a, ((h) this).f324a, this.f74a));
        pc pcVar = this.f74a;
        if (pcVar != null) {
            pcVar.getClass();
            try {
                if (((p5) pcVar).f546a != null) {
                    if (new File(((p5) pcVar).f546a.m594a()).canRead()) {
                        i2 i2Var = ((p5) pcVar).f548a;
                        if (i2Var != i2.AdStatusSuc) {
                            if (i2Var == i2.AdStatusReady) {
                            }
                        }
                        return true;
                    }
                    if (bg.a()) {
                        jo joVar = pcVar.f572a;
                        d dVar = ((p5) pcVar).f546a;
                        joVar.getClass();
                        if (dVar != null) {
                            if (!dVar.m603d()) {
                                if (dVar.m605f()) {
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                pk.b(String.format("Interstitial ad mgr isReady error: %s", th));
                oh.b(th);
            }
        }
        return false;
    }

    public boolean loadAd() {
        try {
            pk.a("InterstitialAd loadAd");
            final AdError adErrorA = a();
            fn.a(new fn.b() { // from class: com.adprof.sdk.api.InterstitialAd.1
                @Override // com.adprof.sdk.fn.a
                public void callback(Exception exc) {
                    InterstitialAdListener interstitialAdListener;
                    InterstitialAdListener interstitialAdListener2;
                    AdError adError = adErrorA;
                    if (adError != null && (interstitialAdListener2 = InterstitialAd.this.f1050a) != null) {
                        interstitialAdListener2.onInterstitialAdLoadError(adError);
                    }
                    if (!InterstitialAd.this.isReady() || (interstitialAdListener = InterstitialAd.this.f1050a) == null) {
                        return;
                    }
                    interstitialAdListener.onInterstitialAdLoadSuccess();
                }
            });
            if (adErrorA != null) {
                return false;
            }
            if (isReady()) {
                return true;
            }
            q1.m710a().a(((h) this).f326a);
            ((h) this).f324a = i2.AdStatusLoading;
            pc pcVar = this.f74a;
            pcVar.getClass();
            z1.a().getClass();
            pcVar.a(SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US);
            return true;
        } catch (Exception e) {
            oh.b(e);
            pk.d("InterstitialAd loadAd = " + Log.getStackTraceString(e));
            return false;
        }
    }

    @Override // com.adprof.sdk.api.IBiddingNotify
    public void sendLossNotify(Map<String, Object> map) {
        try {
            pk.a("InterstitialAd sendLossNotify  map = " + map);
            pc pcVar = this.f74a;
            if (pcVar != null) {
                pcVar.sendLossNotify(map);
            }
        } catch (Throwable th) {
            pk.a(th);
            oh.b(th);
        }
    }

    @Override // com.adprof.sdk.api.IBiddingNotify
    public void sendWinNotify(Map<String, Object> map) {
        try {
            pk.a("InterstitialAd sendWinNotify  map = " + map);
            pc pcVar = this.f74a;
            if (pcVar != null) {
                pcVar.sendWinNotify(map);
            }
        } catch (Throwable th) {
            pk.a(th);
            oh.b(th);
        }
    }

    public void showAd(final Activity activity) {
        pk.a(String.format("InterstitialAd showAd: %s", activity));
        if (!AdprofSdk.getInstance().isInit()) {
            a(AdError.ERROR_AD_NOT_INIT);
            return;
        }
        if (!isReady()) {
            a(AdError.ERROR_AD_NOT_READY);
            return;
        }
        if (!q1.a(activity)) {
            activity = q1.a();
        }
        if (q1.a(activity)) {
            fn.a(new fn.b() { // from class: com.adprof.sdk.api.InterstitialAd.2
                @Override // com.adprof.sdk.fn.a
                public void callback(Exception exc) {
                    InterstitialAd.this.f74a.f(activity);
                    ((h) InterstitialAd.this).f324a = i2.AdStatusPlaying;
                }
            });
        } else {
            a(AdError.ERROR_AD_ACTIVITY_IS_NULL);
        }
    }
}
