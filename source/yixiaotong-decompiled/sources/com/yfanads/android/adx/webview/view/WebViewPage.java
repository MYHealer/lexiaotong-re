package com.yfanads.android.adx.webview.view;

import android.content.Context;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.yfanads.android.utils.ScreenUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class WebViewPage extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AdxWebView f9631a;
    public ProgressBar b;

    public WebViewPage(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        AdxWebView adxWebView = new AdxWebView(context);
        this.f9631a = adxWebView;
        addView(adxWebView);
        this.b = new ProgressBar(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ScreenUtil.dip2px(context, 100.0f), ScreenUtil.dip2px(context, 100.0f));
        layoutParams.gravity = 17;
        this.b.setLayoutParams(layoutParams);
        addView(this.b);
    }

    public WebView getWebView() {
        return this.f9631a;
    }

    public void setDownloadListener(DownloadListener downloadListener) {
        this.f9631a.setDownloadListener(downloadListener);
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        this.f9631a.setWebChromeClient(webChromeClient);
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        this.f9631a.setWebViewClient(webViewClient);
    }
}
