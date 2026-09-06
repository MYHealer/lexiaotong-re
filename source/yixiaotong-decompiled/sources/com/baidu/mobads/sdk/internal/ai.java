package com.baidu.mobads.sdk.internal;

import android.webkit.WebView;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class ai implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ JSONObject f1718a;
    final /* synthetic */ WebView b;
    final /* synthetic */ ae c;

    ai(ae aeVar, JSONObject jSONObject, WebView webView) {
        this.c = aeVar;
        this.f1718a = jSONObject;
        this.b = webView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f1718a == null || this.b == null) {
            return;
        }
        this.b.loadUrl("javascript:window.sdkCallback.userInteractCb(\"" + this.f1718a.toString().replace("\"", "\\\"") + "\")");
    }
}
