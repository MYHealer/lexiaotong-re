package com.adprof.sdk;

import android.widget.RelativeLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ad implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ hd f1031a;

    public ad(hd hdVar) {
        this.f1031a = hdVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1031a.b("1");
        hd hdVar = this.f1031a;
        if (ll.m678a(((x0) hdVar).f821a)) {
            try {
                c2 c2Var = hdVar.f339a;
                if (c2Var != null) {
                    c2Var.b();
                    hdVar.f339a = null;
                }
            } catch (Throwable th) {
                pk.b("InterstitialView disableShakeFeature release detector error", th);
            }
            try {
                pe peVar = hdVar.f342a;
                if (peVar != null) {
                    peVar.c();
                }
                RelativeLayout relativeLayout = ((vc) hdVar).f767a;
                if (relativeLayout != null) {
                    relativeLayout.removeAllViews();
                    ((vc) hdVar).f767a.setVisibility(8);
                }
            } catch (Throwable th2) {
                pk.b("InterstitialView disableShakeFeature remove view error", th2);
            }
        }
    }
}
