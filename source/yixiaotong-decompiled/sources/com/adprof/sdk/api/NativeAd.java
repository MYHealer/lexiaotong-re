package com.adprof.sdk.api;

import android.util.Log;
import com.adprof.sdk.c2;
import com.adprof.sdk.df;
import com.adprof.sdk.ef;
import com.adprof.sdk.f0;
import com.adprof.sdk.fn;
import com.adprof.sdk.h;
import com.adprof.sdk.i2;
import com.adprof.sdk.oh;
import com.adprof.sdk.pk;
import com.adprof.sdk.q;
import com.adprof.sdk.q1;
import com.adprof.sdk.z1;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class NativeAd extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public NativeAdLoadListener f1054a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public df f78a;

    public NativeAd(AdRequest adRequest, NativeAdLoadListener nativeAdLoadListener) {
        super(adRequest);
        a(adRequest, nativeAdLoadListener);
    }

    public final void a(AdRequest adRequest, NativeAdLoadListener nativeAdLoadListener) {
        pk.a("NativeUnifiedAd init: " + adRequest + " l: " + nativeAdLoadListener);
        this.f1054a = nativeAdLoadListener;
        df dfVar = new df(adRequest, nativeAdLoadListener);
        this.f78a = dfVar;
        ((h) this).f325a = dfVar;
    }

    public void destroyAd() {
        try {
            pk.a("NativeUnifiedAd destroyAd");
            df dfVar = this.f78a;
            if (dfVar != null) {
                dfVar.a();
                this.f78a = null;
            }
            if (this.f1054a != null) {
                this.f1054a = null;
            }
            q1.m710a().b(((h) this).f326a);
        } catch (Exception e) {
            pk.a(e);
            oh.b(e);
        }
    }

    public boolean isReady() {
        pk.a(new StringBuilder("NativeUnifiedAd isReady:  ").append(this.f78a).toString() != null ? this.f78a.m608a() + "" : "adManager null");
        df dfVar = this.f78a;
        boolean z = dfVar != null && dfVar.m608a();
        if (z) {
            ((h) this).f324a = i2.AdStatusSuc;
        }
        return z;
    }

    public boolean loadAd() {
        try {
            pk.a("NativeUnifiedAd loadAd");
            final AdError adErrorA = a();
            if (adErrorA != null && this.f1054a != null) {
                fn.a(new fn.b() { // from class: com.adprof.sdk.api.NativeAd.1
                    @Override // com.adprof.sdk.fn.a
                    public void callback(Exception exc) {
                        NativeAd.this.f1054a.onAdError(adErrorA);
                    }
                });
                return false;
            }
            q1.m710a().a(((h) this).f326a);
            ((h) this).f324a = i2.AdStatusLoading;
            df dfVar = this.f78a;
            dfVar.getClass();
            z1.a().getClass();
            dfVar.a(SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US);
            return true;
        } catch (Exception e) {
            oh.b(e);
            pk.d("NativeUnifiedAd load = " + Log.getStackTraceString(e));
            return false;
        }
    }

    @Override // com.adprof.sdk.api.IBiddingNotify
    public void sendLossNotify(Map<String, Object> map) {
        pk.a("NativeUnifiedAd sendLossNotification " + this.f78a + "  map = " + map);
        df dfVar = this.f78a;
        if (dfVar != null) {
            dfVar.sendLossNotify(map);
        }
    }

    @Override // com.adprof.sdk.api.IBiddingNotify
    public void sendWinNotify(Map<String, Object> map) {
        pk.a("NativeUnifiedAd sendWinNotification " + this.f78a + "  map = " + map);
        df dfVar = this.f78a;
        if (dfVar != null) {
            dfVar.sendWinNotify(map);
        }
    }

    public void setApkDownloadListener(ApkDownloadListener apkDownloadListener) {
        pk.a("NativeUnifiedAd setApkDownloadListener: " + apkDownloadListener);
        df dfVar = this.f78a;
        if (dfVar != null) {
            dfVar.f1128a = apkDownloadListener;
        }
    }

    public void setShakeDisableWhile() {
        ArrayList arrayList;
        f0 f0Var;
        q qVar;
        c2 c2Var;
        df dfVar = this.f78a;
        if (dfVar == null || (arrayList = dfVar.f217a) == null || arrayList.isEmpty()) {
            return;
        }
        for (NativeAdData nativeAdData : dfVar.f217a) {
            if ((nativeAdData instanceof ef) && (f0Var = ((ef) nativeAdData).f248a) != null && (qVar = f0Var.f279a) != null && (c2Var = qVar.f627a) != null) {
                c2Var.f161b = c2Var.f154a;
                c2Var.f165c = System.currentTimeMillis();
                pk.d("shake immune interval set to " + c2Var.f161b + "ms ");
            }
        }
    }
}
