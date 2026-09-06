package com.kwad.sdk.core.webview.a;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.kwad.sdk.core.config.e;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a extends WebViewClient {
    private boolean bcl = true;
    protected String mUniqueId = "";

    public final void setNeedHybridLoad(boolean z) {
        this.bcl = z;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (!this.bcl || !e.Kb()) {
            return super.shouldInterceptRequest(webView, str);
        }
        com.kwad.sdk.core.d.c.d("HybridWebViewClient", "shouldInterceptRequest: " + str);
        WebResourceResponse webResourceResponseAd = com.kwad.sdk.core.webview.b.a.PH().ad(str, this.mUniqueId);
        return webResourceResponseAd == null ? super.shouldInterceptRequest(webView, str) : webResourceResponseAd;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (!this.bcl || !e.Kb()) {
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
        String string = webResourceRequest.getUrl().toString();
        com.kwad.sdk.core.d.c.d("HybridWebViewClient", "shouldInterceptRequestAPI 21: " + string);
        WebResourceResponse webResourceResponseAd = com.kwad.sdk.core.webview.b.a.PH().ad(string, this.mUniqueId);
        return webResourceResponseAd == null ? super.shouldInterceptRequest(webView, webResourceRequest) : webResourceResponseAd;
    }
}
