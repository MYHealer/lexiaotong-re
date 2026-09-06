package com.yfanads.android.adx.webview.view;

import android.content.Context;
import android.webkit.WebView;
import com.yfanads.android.adx.webview.lifecycle.a;
import com.yfanads.android.adx.webview.lifecycle.b;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class AdxWebView extends WebView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f9630a;
    public com.yfanads.android.adx.webview.settings.a b;

    public AdxWebView(Context context) {
        super(context);
        a();
    }

    public final void a() {
        com.yfanads.android.adx.webview.settings.a aVar = new com.yfanads.android.adx.webview.settings.a();
        this.b = aVar;
        aVar.a(this);
        this.f9630a = new a(this);
    }

    public b getWebLifeCycle() {
        return this.f9630a;
    }

    @Override // android.webkit.WebView
    public final void onPause() {
        this.f9630a.a();
    }

    @Override // android.webkit.WebView
    public final void onResume() {
        this.f9630a.b();
    }
}
