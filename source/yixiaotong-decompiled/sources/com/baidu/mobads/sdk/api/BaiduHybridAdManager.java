package com.baidu.mobads.sdk.api;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import com.baidu.mobads.sdk.internal.di;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BaiduHybridAdManager {
    private di mAdProd;
    private String mAppSid;
    private WebView mWebView;
    private BaiduHybridAdViewListener mBaiduHybridAdViewListener = new BaiduHybridAdViewListener() { // from class: com.baidu.mobads.sdk.api.BaiduHybridAdManager.1
        @Override // com.baidu.mobads.sdk.api.BaiduHybridAdViewListener
        public void onAdClick(int i, String str) {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduHybridAdViewListener
        public void onAdFailed(int i, String str, String str2) {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduHybridAdViewListener
        public void onAdShow(int i, String str) {
        }
    };
    private boolean mAppPageReceivedError = false;

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.mAppPageReceivedError = false;
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        this.mAppPageReceivedError = true;
    }

    public void setAppSid(String str) {
        this.mAppSid = str;
    }

    public void setBaiduHybridAdViewListener(BaiduHybridAdViewListener baiduHybridAdViewListener) {
        this.mBaiduHybridAdViewListener = baiduHybridAdViewListener;
    }

    public void injectJavaScriptBridge(WebView webView) {
        if (this.mAppPageReceivedError) {
            return;
        }
        this.mWebView = webView;
        di diVar = new di(this.mWebView);
        this.mAdProd = diVar;
        diVar.h(this.mAppSid);
        this.mAdProd.a(this.mBaiduHybridAdViewListener);
        this.mAdProd.a();
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        di diVar;
        if (!this.mAppPageReceivedError && (diVar = this.mAdProd) != null) {
            diVar.b(webView, str);
        }
        try {
            Uri uri = Uri.parse(str);
            return "mobadssdk".equals(uri.getScheme()) || "mobads".equals(uri.getScheme());
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }
}
