package com.adprof.sdk;

import android.util.Log;
import com.adprof.sdk.api.BannerAdListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class g4 extends fn.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n4 f1184a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ boolean f302a;

    public g4(n4 n4Var, boolean z, wd wdVar) {
        this.f1184a = n4Var;
        this.f302a = z;
    }

    @Override // com.adprof.sdk.fn.a
    public void callback(Exception exc) {
        try {
            pk.d("banner callback  callback ----");
            BannerAdListener bannerAdListener = this.f1184a.f499a;
            if (bannerAdListener != null && this.f302a) {
                bannerAdListener.onBannerAdLoadSuccess();
            }
            if (this.f302a) {
                return;
            }
            this.f1184a.getClass();
            n4 n4Var = this.f1184a;
            n4Var.a(((p5) n4Var).f546a);
            n4 n4Var2 = this.f1184a;
            if (n4Var2.f498a != null) {
                n4Var2.m691a();
                this.f1184a.f498a.removeAllViews();
                n4 n4Var3 = this.f1184a;
                n4Var3.f498a.addView(n4Var3.f500a, n4Var3.a(n4Var3.m690a()));
                n4 n4Var4 = this.f1184a;
                n4Var4.a(n4Var4.f498a);
            }
            this.f1184a.e();
            this.f1184a.d();
        } catch (Throwable th) {
            oh.b(th);
            pk.d("banner show = " + Log.getStackTraceString(th));
        }
    }
}
