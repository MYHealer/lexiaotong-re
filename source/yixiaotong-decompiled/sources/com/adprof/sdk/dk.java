package com.adprof.sdk;

import android.widget.RelativeLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class dk implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ jk f1132a;

    public dk(jk jkVar) {
        this.f1132a = jkVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1132a.b("1");
        jk jkVar = this.f1132a;
        if (ll.m678a(((x0) jkVar).f821a)) {
            try {
                c2 c2Var = jkVar.f394a;
                if (c2Var != null) {
                    c2Var.b();
                    jkVar.f394a = null;
                }
            } catch (Throwable th) {
                pk.b("RewardView disableShakeFeature release detector error", th);
            }
            try {
                pe peVar = jkVar.f397a;
                if (peVar != null) {
                    peVar.c();
                }
                RelativeLayout relativeLayout = ((yj) jkVar).f861a;
                if (relativeLayout != null) {
                    relativeLayout.removeAllViews();
                    ((yj) jkVar).f861a.setVisibility(8);
                }
            } catch (Throwable th2) {
                pk.b("RewardView disableShakeFeature remove view error", th2);
            }
        }
    }
}
