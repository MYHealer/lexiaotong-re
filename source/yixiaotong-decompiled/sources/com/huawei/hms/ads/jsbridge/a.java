package com.huawei.hms.ads.jsbridge;

import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import com.huawei.hms.ads.jsb.IWebView;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile String f3868a;

    /* JADX INFO: renamed from: com.huawei.hms.ads.jsbridge.a$a, reason: collision with other inner class name */
    private static class CallableC0513a implements Callable<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private IWebView f3869a;
        private WebView b;
        private boolean c;

        CallableC0513a(WebView webView) {
            this.b = webView;
        }

        CallableC0513a(IWebView iWebView) {
            this.c = true;
            this.f3869a = iWebView;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String call() {
            if (this.c) {
                IWebView iWebView = this.f3869a;
                if (iWebView != null) {
                    return iWebView.getUrl();
                }
                return null;
            }
            WebView webView = this.b;
            if (webView != null) {
                return webView.getUrl();
            }
            return null;
        }
    }

    private static Future<String> a(FutureTask futureTask) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            futureTask.run();
        } else {
            new Handler(Looper.getMainLooper()).post(futureTask);
        }
        return futureTask;
    }

    public static void a(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    private static String b(WebView webView) {
        try {
            return a(new FutureTask(new CallableC0513a(webView))).get(1L, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            b.b("Exception will waiting: " + e.getMessage());
            b.b("exception or timeout while waiting for url");
            return null;
        }
    }

    private static String b(IWebView iWebView) {
        try {
            return a(new FutureTask(new CallableC0513a(iWebView))).get(1L, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            b.b("Exception will waiting: " + e.getMessage());
            b.b("exception or timeout while waiting for url");
            return null;
        }
    }

    public String a(WebView webView) {
        if (webView == null) {
            return null;
        }
        String str = this.f3868a;
        if (str != null) {
            return str;
        }
        b.a("securityExtSetFrameUrl is null ,get url from native");
        return b(webView);
    }

    public String a(IWebView iWebView) {
        if (iWebView == null) {
            return null;
        }
        String str = this.f3868a;
        return str != null ? str : b(iWebView);
    }
}
