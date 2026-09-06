package com.adprof.sdk;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class z implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f1546a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ f0 f887a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ boolean f888a;

    public z(f0 f0Var, boolean z, ViewGroup viewGroup) {
        this.f887a = f0Var;
        this.f888a = z;
        this.f1546a = viewGroup;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        try {
            if (pk.f594a) {
                pk.d("AFNativeAdRender  templateId = " + this.f887a.f277a.f180a + "  express = " + this.f888a + "  width = " + this.f1546a.getMeasuredWidth() + "  height = " + this.f1546a.getHeight() + "  visible = " + (this.f1546a.getVisibility() == 0) + "   instance = " + this.f1546a.hashCode());
            }
            this.f887a.a(this.f1546a, "onGlobalLayout");
            this.f1546a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        } catch (Throwable th) {
            pk.a(th);
            oh.b(th);
        }
    }
}
