package com.alipay.sdk.widget;

import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
class s extends WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ WebViewWindow f1686a;

    s(WebViewWindow webViewWindow) {
        this.f1686a = webViewWindow;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        if (i == 100) {
            this.f1686a.d.setVisibility(4);
            return;
        }
        if (4 == this.f1686a.d.getVisibility()) {
            this.f1686a.d.setVisibility(0);
        }
        this.f1686a.d.setProgress(i);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return this.f1686a.g.a(this.f1686a, str, str2, str3, jsPromptResult);
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        this.f1686a.g.a(this.f1686a, str);
    }
}
