package com.huawei.secure.android.common.webview;

import android.util.Log;
import android.webkit.WebView;
import com.huawei.secure.android.common.util.b;
import com.huawei.secure.android.common.util.c;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class SafeGetUrl {
    private static final String c = "SafeGetUrl";
    private static final long d = 200;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f4581a;
    private WebView b;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f4582a;

        a(CountDownLatch countDownLatch) {
            this.f4582a = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            SafeGetUrl safeGetUrl = SafeGetUrl.this;
            safeGetUrl.setUrl(safeGetUrl.b.getUrl());
            this.f4582a.countDown();
        }
    }

    public SafeGetUrl() {
    }

    public WebView getWebView() {
        return this.b;
    }

    public void setUrl(String str) {
        this.f4581a = str;
    }

    public void setWebView(WebView webView) {
        this.b = webView;
    }

    public SafeGetUrl(WebView webView) {
        this.b = webView;
    }

    public String getUrlMethod() {
        if (this.b == null) {
            return "";
        }
        if (b.a()) {
            return this.b.getUrl();
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        c.a(new a(countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            Log.e(c, "getUrlMethod: InterruptedException " + e.getMessage(), e);
        }
        return this.f4581a;
    }
}
