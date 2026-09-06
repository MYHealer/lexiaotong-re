package com.meishu.sdk.core.webview;

import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.meishu.sdk.core.utils.LogUtil;

/* JADX INFO: compiled from: FreedomWebChromeClient.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class e extends WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f4979a;

    public e(String str, g gVar) {
        this.f4979a = gVar;
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        int iA;
        super.onReceivedTitle(webView, str);
        LogUtil.dev("FreedomWebViewClient", "onReceivedTitle:" + str);
        try {
            String url = webView.getUrl();
            if (!q.a(url) && ((iA = this.f4979a.a(url)) == 404 || iA >= 500)) {
                webView.stopLoading();
                try {
                    String str2 = q.h;
                    if (!TextUtils.isEmpty(str2)) {
                        webView.loadDataWithBaseURL("file:///android_asset/", str2, "text/html", "UTF-8", null);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
