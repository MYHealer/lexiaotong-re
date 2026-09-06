package com.baidu.oauth.sdkbqt.auth;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.oauth.sdkbqt.result.OauthResult;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class t extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f1892a;

    t(i iVar) {
        this.f1892a = iVar;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        com.baidu.oauth.sdkbqt.a.d.a(i.b, "override the loading url that is " + str);
        if (!TextUtils.isEmpty(str) && str.contains(BdOauthSdk.getAuthInfo().getRedirectUrl())) {
            HashMap<String, String> mapA = com.baidu.oauth.sdkbqt.a.h.a(str.substring(str.indexOf("#") + 1, str.length()));
            com.baidu.oauth.sdkbqt.result.b bVar = new com.baidu.oauth.sdkbqt.result.b();
            if (mapA.containsKey("error")) {
                bVar.setResultCode(OauthResult.ERROR_CODE_RESPONSE_INVALID);
                bVar.setResultMsg(mapA.get("error_description"));
                this.f1892a.s.onFailure(bVar);
            } else {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("code", mapA.get("code"));
                    jSONObject.put("state", mapA.get("state"));
                    jSONObject.put("showLogin", this.f1892a.j ? "1" : "0");
                    jSONObject.put("finishLogin", "1");
                    bVar.f1903a = jSONObject;
                    bVar.setResultCode(0);
                    this.f1892a.s.onSuccess(bVar);
                } catch (JSONException e) {
                    com.baidu.oauth.sdkbqt.a.d.a(e);
                    bVar.setResultCode(OauthResult.ERROR_CODE_UNKNOW_ERROR);
                    this.f1892a.s.onFailure(bVar);
                }
            }
            this.f1892a.c();
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        if (!com.baidu.oauth.sdkbqt.a.h.a(this.f1892a.getContext()) && !str.startsWith("javascript:")) {
            this.f1892a.i();
        }
        this.f1892a.o.a(str);
        this.f1892a.n.postDelayed(this.f1892a.o, this.f1892a.m);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        this.f1892a.h();
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (com.baidu.oauth.sdkbqt.a.h.a(this.f1892a.getContext()) && this.f1892a.g != null && this.f1892a.g.getVisibility() != 4) {
            this.f1892a.g.setVisibility(4);
        }
        if (this.f1892a.e != null) {
            this.f1892a.loadUrl("javascript:prompt(JSON.stringify({action:{name:'action_set_title',params:[document.title, 'prompt_on_cancel', 'prompt_on_cancel']}}));");
        }
        this.f1892a.n.removeCallbacks(this.f1892a.o);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        this.f1892a.h();
    }
}
