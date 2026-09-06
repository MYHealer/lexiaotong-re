package com.adprof.sdk;

import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class od extends WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ td f1343a;

    public od(td tdVar) {
        this.f1343a = tdVar;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        int i = sd.f1420a[consoleMessage.messageLevel().ordinal()];
        return false;
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        if (str == null || str.isEmpty() || str.startsWith("http") || str.length() > 10) {
            this.f1343a.getClass();
        } else {
            this.f1343a.getClass();
        }
    }
}
