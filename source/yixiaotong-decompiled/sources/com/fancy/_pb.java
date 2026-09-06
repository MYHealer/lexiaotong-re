package com.fancy;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _pb extends WebChromeClient {
    public final /* synthetic */ Activity _a;
    public final /* synthetic */ com.fancy.adsdk.lib.helper.imp._a _b;

    public _pb(com.fancy.adsdk.lib.helper.imp._a _aVar, Activity activity) {
        this._b = _aVar;
        this._a = activity;
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView webView, int i) {
        ProgressBar progressBar;
        super.onProgressChanged(webView, i);
        if (this._a.isFinishing() || (progressBar = this._b._b) == null) {
            return;
        }
        if (i >= 100) {
            progressBar.setVisibility(8);
        } else {
            progressBar.setProgress(i);
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
        if (this._a.isFinishing() || this._b._c == null || TextUtils.isEmpty(str)) {
            return;
        }
        this._b._c.setTitle(str);
    }
}
