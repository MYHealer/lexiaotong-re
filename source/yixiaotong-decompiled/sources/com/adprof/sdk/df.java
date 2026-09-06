package com.adprof.sdk;

import com.adprof.sdk.api.AdError;
import com.adprof.sdk.api.AdRequest;
import com.adprof.sdk.api.ApkDownloadListener;
import com.adprof.sdk.api.NativeAdData;
import com.adprof.sdk.api.NativeAdLoadListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class df extends p5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ApkDownloadListener f1128a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public NativeAdLoadListener f214a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final g7 f215a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public l0 f216a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList f217a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Set f218a;

    public df(AdRequest adRequest, NativeAdLoadListener nativeAdLoadListener) {
        super(adRequest);
        this.f218a = new HashSet();
        this.f215a = new cf(this);
        ((p5) this).f548a = i2.AdStatusNone;
        this.f214a = nativeAdLoadListener;
        ((p5) this).f549a = new wd(adRequest, 1);
    }

    public void a() {
        try {
            l0 l0Var = this.f216a;
            if (l0Var != null) {
                l0Var.b();
                this.f216a = null;
            }
            if (((p5) this).f548a == i2.AdStatusPlaying) {
                ((p5) this).f548a = i2.AdStatusClose;
            }
            d dVar = ((p5) this).f546a;
            if (dVar != null) {
                dVar.m596a();
                ((p5) this).f546a = null;
            }
            ArrayList arrayList = this.f217a;
            if (arrayList != null) {
                arrayList.clear();
                this.f217a = null;
            }
            pk.a("GtNativeAd data release: " + this.f218a.size());
            for (NativeAdData nativeAdData : this.f218a) {
                if (nativeAdData != null) {
                    nativeAdData.destroy();
                }
            }
            this.f218a.clear();
            this.f214a = null;
            this.f1128a = null;
        } catch (Exception e) {
            pk.a(e);
            oh.b(e);
        }
    }

    @Override // com.adprof.sdk.p5
    public void a(int i, String str, String str2, wd wdVar) {
        a(i, str);
    }

    @Override // com.adprof.sdk.p5
    public void a(d dVar, String str) {
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m608a() {
        ArrayList arrayList;
        try {
            return (((p5) this).f546a == null || ((p5) this).f548a != i2.AdStatusSuc || (arrayList = this.f217a) == null || arrayList.isEmpty() || !((p5) this).f546a.m604e()) ? false : true;
        } catch (Throwable th) {
            pk.b("Native ad mgr isRead error: ", th);
            oh.b(th);
        }
        return false;
    }

    @Override // com.adprof.sdk.p5
    public boolean a(AdError adError, boolean z, String str) {
        if (!super.a(adError, z, str)) {
            return false;
        }
        fn.a(new af(this, z, adError));
        return false;
    }

    @Override // com.adprof.sdk.p5
    public void a(AdError adError) {
        if (super.a(adError, true, "respond_timeout")) {
            fn.a(new af(this, true, adError));
        }
    }

    @Override // com.adprof.sdk.p5
    public void a(List list, wd wdVar) {
        try {
            if (a((d) list.get(0))) {
                ef efVar = new ef(((p5) this).f546a, this, wdVar.c, wdVar.d, wdVar);
                ArrayList arrayList = new ArrayList();
                this.f217a = arrayList;
                arrayList.add(efVar);
                fn.a(new bf(this), 0L);
            }
        } catch (Exception unused) {
        }
    }
}
