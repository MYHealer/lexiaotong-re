package com.kwad.components.core.page.d.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class b extends com.kwad.sdk.mvp.a {
    public AdWebViewActivityProxy.a adC;
    public WebView aea;
    public com.kwad.components.core.page.a.b aeb;
    public KsAdWebView.c aec;
    public f.a aed;

    @Deprecated
    public com.kwad.components.core.webview.jshandler.b aee;
    public com.kwad.components.core.page.a.a aef;
    public com.kwad.components.core.b.a aeg;
    public boolean aeh = false;
    public boolean aei = false;
    public AdTemplate mAdTemplate;
    public KsAdWebView mAdWebView;
    public boolean mAutoShow;
    public Context mContext;
    public String mH5AuthUrl;
    public String mPageTitle;
    public String mPageUrl;
    public ViewGroup mRootContainer;
    public boolean mShowPermission;
    public com.kwad.sdk.core.webview.d.a.b mWebCardCloseListener;

    private void aU(boolean z) {
        this.aei = z;
    }

    public final void a(f.a aVar) {
        this.aed = aVar;
    }

    public final void a(KsAdWebView.c cVar) {
        this.aec = cVar;
    }

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        this.aec = null;
        this.aed = null;
        this.mWebCardCloseListener = null;
        this.aee = null;
    }

    public final void setH5AuthListener(com.kwad.components.core.page.a.a aVar) {
        this.aef = aVar;
    }

    public final void setWebCardCloseListener(com.kwad.sdk.core.webview.d.a.b bVar) {
        this.mWebCardCloseListener = bVar;
    }

    public final boolean tV() {
        return this.mShowPermission;
    }

    public final boolean uk() {
        return this.aei;
    }

    public final void a(boolean z, View view) {
        KsAdWebView ksAdWebView = this.mAdWebView;
        if (ksAdWebView == null || !ksAdWebView.canGoBack()) {
            com.kwad.components.core.page.a.b bVar = this.aeb;
            if (bVar != null) {
                bVar.tQ();
                return;
            }
            return;
        }
        this.mAdWebView.goBack();
        if (z) {
            com.kwad.sdk.core.adlog.c.cv(this.mAdTemplate);
        }
    }

    public final void a(com.kwad.components.core.webview.jshandler.b bVar) {
        this.aee = bVar;
        aU(true);
    }

    public final void ul() {
        this.aee = null;
        aU(false);
    }

    public final void uc() {
        com.kwad.components.core.webview.jshandler.b bVar = this.aee;
        if (bVar != null) {
            bVar.ux();
        }
    }

    public final boolean um() {
        return !tV();
    }
}
