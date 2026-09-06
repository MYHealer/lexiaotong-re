package com.yfanads.android.adx.webview.settings;

import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.yfanads.android.adx.service.c;
import com.yfanads.android.libs.utils.DeviceUtils;

/* JADX INFO: compiled from: DefaultWebSettings.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class a {
    public static String c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WebSettings f9629a;
    public boolean b;

    public final void a(WebView webView) {
        String ua;
        WebSettings settings = webView.getSettings();
        this.f9629a = settings;
        settings.setJavaScriptEnabled(false);
        this.f9629a.setPluginState(WebSettings.PluginState.OFF);
        this.f9629a.setUseWideViewPort(true);
        this.f9629a.setLoadWithOverviewMode(true);
        this.f9629a.setSupportZoom(false);
        this.f9629a.setBuiltInZoomControls(true);
        this.f9629a.setDisplayZoomControls(true);
        this.f9629a.setCacheMode(1);
        this.f9629a.setAllowFileAccess(false);
        this.f9629a.setJavaScriptCanOpenWindowsAutomatically(false);
        this.f9629a.setLoadsImagesAutomatically(true);
        this.f9629a.setDefaultTextEncodingName("utf-8");
        this.f9629a.setBlockNetworkImage(false);
        this.f9629a.setMixedContentMode(0);
        this.f9629a.setDomStorageEnabled(true);
        c cVar = c.a.f9618a;
        cVar.getClass();
        if (TextUtils.isEmpty(DeviceUtils.getUA())) {
            ua = c.H;
        } else {
            cVar.getClass();
            ua = DeviceUtils.getUA();
        }
        c = ua;
        if (TextUtils.isEmpty(ua)) {
            return;
        }
        this.f9629a.setUserAgentString(c);
    }
}
