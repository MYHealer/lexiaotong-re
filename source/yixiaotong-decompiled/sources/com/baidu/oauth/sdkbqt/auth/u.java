package com.baidu.oauth.sdkbqt.auth;

import android.app.AlertDialog;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class u extends WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f1893a;

    u(i iVar) {
        this.f1893a = iVar;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        AlertDialog.Builder positiveButton = new AlertDialog.Builder(this.f1893a.getContext()).setTitle("JavaScript Message").setMessage(str2).setPositiveButton("ok", new v(this, jsResult));
        positiveButton.setCancelable(false);
        positiveButton.create();
        positiveButton.show();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public void onConsoleMessage(String str, int i, String str2) {
        com.baidu.oauth.sdkbqt.a.d.a(str + " -- From line " + i + " of " + str2, new Object[0]);
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        if (this.f1893a.l != null) {
            if (i == 100) {
                this.f1893a.l.setVisibility(8);
            } else {
                if (this.f1893a.l.getVisibility() == 8) {
                    this.f1893a.l.setVisibility(0);
                }
                this.f1893a.l.setProgress(i);
            }
        }
        super.onProgressChanged(webView, i);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        this.f1893a.post(new w(this, str2, jsPromptResult, new String[]{""}));
        return true;
    }
}
