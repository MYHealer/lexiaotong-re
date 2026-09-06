package com.adprof.sdk;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class c0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f1097a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ f0 f150a;

    public c0(f0 f0Var, ViewGroup viewGroup) {
        this.f150a = f0Var;
        this.f1097a = viewGroup;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        f0 f0Var = this.f150a;
        ViewGroup viewGroup = this.f1097a;
        f0Var.getClass();
        try {
            d dVar = f0Var.f277a;
            if (dVar == null || dVar.g <= f0Var.f267a || !me.m683a()) {
                f0Var.e();
            } else {
                me.a();
                le.a(viewGroup, f0Var.f277a, new d0(f0Var), "AdprofNativeAdRender");
            }
        } catch (Throwable th) {
            pk.a(th);
            oh.b(th);
        }
    }
}
