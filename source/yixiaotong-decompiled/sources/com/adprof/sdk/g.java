package com.adprof.sdk;

import android.app.Activity;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class g implements q1.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f1180a;

    public g(h hVar) {
        this.f1180a = hVar;
    }

    @Override // com.adprof.sdk.q1.a
    public void a(Activity activity) {
        if (pk.f594a) {
            pk.d("---act: gonResume: " + activity.getLocalClassName());
        }
        p5 p5Var = this.f1180a.f325a;
        if (p5Var != null) {
            p5Var.a(activity);
        }
    }

    @Override // com.adprof.sdk.q1.a
    public void b(Activity activity) {
        if (pk.f594a) {
            pk.d("---act: gonPause: " + activity.getLocalClassName());
        }
        p5 p5Var = this.f1180a.f325a;
        if (p5Var != null) {
            p5Var.b(activity);
        }
    }

    @Override // com.adprof.sdk.q1.a
    public void c(Activity activity) {
    }

    @Override // com.adprof.sdk.q1.a
    public void d(Activity activity) {
    }

    @Override // com.adprof.sdk.q1.a
    public void e(Activity activity) {
    }
}
