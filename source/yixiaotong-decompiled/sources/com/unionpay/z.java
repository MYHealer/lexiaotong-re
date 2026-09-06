package com.unionpay;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
final class z extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ WebViewJavascriptBridge f9370a;

    private z(WebViewJavascriptBridge webViewJavascriptBridge) {
        this.f9370a = webViewJavascriptBridge;
    }

    /* synthetic */ z(WebViewJavascriptBridge webViewJavascriptBridge, byte b) {
        this(webViewJavascriptBridge);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        com.unionpay.utils.j.a("test", "onPageFinished");
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        com.unionpay.utils.j.a("uppay", "shouldOverrideUrlLoading：" + str);
        if (this.f9370a.mAllowScheme && !TextUtils.isEmpty(str) && !str.startsWith("http")) {
            try {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                this.f9370a.mContext.startActivity(intent);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
