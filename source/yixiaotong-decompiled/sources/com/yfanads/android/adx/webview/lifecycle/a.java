package com.yfanads.android.adx.webview.lifecycle;

import com.yfanads.android.adx.webview.view.AdxWebView;

/* JADX INFO: compiled from: DefaultWebLifeCycleImpl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AdxWebView f9628a;

    public a(AdxWebView adxWebView) {
        this.f9628a = adxWebView;
    }

    public final void a() {
        AdxWebView adxWebView = this.f9628a;
        if (adxWebView != null) {
            adxWebView.getSettings().setJavaScriptEnabled(false);
            this.f9628a.onPause();
            this.f9628a.pauseTimers();
        }
    }

    public final void b() {
        AdxWebView adxWebView = this.f9628a;
        if (adxWebView != null) {
            com.yfanads.android.adx.webview.settings.a aVar = adxWebView.b;
            boolean z = aVar.b;
            aVar.b = z;
            aVar.f9629a.setJavaScriptEnabled(z);
            this.f9628a.onResume();
            this.f9628a.resumeTimers();
        }
    }
}
