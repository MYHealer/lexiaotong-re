package com.adprof.sdk;

import android.widget.RelativeLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class wm implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ an f1507a;

    public wm(an anVar) {
        this.f1507a = anVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        an anVar = this.f1507a;
        if (((x0) anVar).f821a == null) {
            pk.b("---handleClick adUnit exception");
        } else {
            anVar.c("1");
        }
        an anVar2 = this.f1507a;
        if (ll.m678a(((x0) anVar2).f821a)) {
            try {
                c2 c2Var = anVar2.f28a;
                if (c2Var != null) {
                    c2Var.b();
                    anVar2.f28a = null;
                }
            } catch (Throwable th) {
                pk.b("SplashView disableShakeFeature release detector error", th);
            }
            try {
                pe peVar = anVar2.f30a;
                if (peVar != null) {
                    peVar.c();
                }
                RelativeLayout relativeLayout = anVar2.f32b;
                if (relativeLayout != null) {
                    relativeLayout.removeAllViews();
                }
                RelativeLayout relativeLayout2 = anVar2.f26a;
                if (relativeLayout2 != null) {
                    relativeLayout2.setVisibility(8);
                }
                TextView textView = anVar2.g;
                if (textView != null) {
                    textView.setVisibility(8);
                }
            } catch (Throwable th2) {
                pk.b("SplashView disableShakeFeature remove view error", th2);
            }
        }
    }
}
