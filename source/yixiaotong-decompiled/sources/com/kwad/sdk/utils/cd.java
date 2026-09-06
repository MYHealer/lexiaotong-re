package com.kwad.sdk.utils;

import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class cd {
    public static WebSettings b(WebView webView) {
        webView.getSettings().setAllowFileAccess(false);
        return c(webView);
    }

    private static WebSettings c(WebView webView) {
        WebSettings settings = webView.getSettings();
        settings.setAllowContentAccess(false);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setTextZoom(100);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setMixedContentMode(0);
        CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);
        webView.setSaveEnabled(false);
        return settings;
    }
}
