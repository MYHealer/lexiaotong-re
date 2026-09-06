package com.yfanads.android.adx.webview.client;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* JADX INFO: compiled from: AdxWebViewClient.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class c extends WebViewClient {
    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        String string = webResourceRequest.getUrl().toString();
        if (TextUtils.isEmpty(string)) {
            com.yfanads.android.adx.utils.a.b("shouldOverrideUrlLoading url is empty, return.");
            return false;
        }
        if (string.startsWith("http://") || string.startsWith("https://")) {
            webView.loadUrl(string);
            return false;
        }
        try {
            Context context = webView.getContext();
            Intent uri = Intent.parseUri(string, 0);
            if (uri.resolveActivity(context.getPackageManager()) == null) {
                return true;
            }
            uri.setFlags(268435456);
            context.startActivity(uri);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            com.yfanads.android.adx.utils.a.b("shouldOverrideUrlLoading startActivity error.");
            return true;
        }
    }
}
