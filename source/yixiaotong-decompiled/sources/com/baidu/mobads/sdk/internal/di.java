package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.baidu.mobads.sdk.api.BaiduHybridAdViewListener;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IXHybridAdRenderer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class di extends bj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WebView f1808a;
    private BaiduHybridAdViewListener t;
    private IXHybridAdRenderer u;

    public void a(BaiduHybridAdViewListener baiduHybridAdViewListener) {
        this.t = baiduHybridAdViewListener;
    }

    public di(WebView webView) {
        super(webView.getContext());
        this.f1808a = webView;
        webView.removeJavascriptInterface("searchBoxJavaBridge_");
        this.f1808a.removeJavascriptInterface("accessibility");
        this.f1808a.removeJavascriptInterface("accessibilityTraversal");
        this.f1808a.getSettings().setAllowContentAccess(false);
        this.f1808a.getSettings().setSavePassword(false);
        this.f1808a.getSettings().setAllowFileAccess(false);
    }

    public void a(WebView webView, String str, Bitmap bitmap) {
        IXHybridAdRenderer iXHybridAdRenderer = this.u;
        if (iXHybridAdRenderer != null) {
            iXHybridAdRenderer.onPageStarted(webView, str, bitmap);
        }
    }

    public void a(WebView webView, String str) {
        IXHybridAdRenderer iXHybridAdRenderer = this.u;
        if (iXHybridAdRenderer != null) {
            iXHybridAdRenderer.onPageFinished(webView, str);
        }
    }

    public void a(WebView webView, int i, String str, String str2) {
        IXHybridAdRenderer iXHybridAdRenderer = this.u;
        if (iXHybridAdRenderer != null) {
            iXHybridAdRenderer.onReceivedError(webView, i, str, str2);
        }
    }

    public boolean b(WebView webView, String str) {
        IXHybridAdRenderer iXHybridAdRenderer = this.u;
        if (iXHybridAdRenderer == null) {
            return false;
        }
        return iXHybridAdRenderer.shouldOverrideUrlLoading(webView, str);
    }

    public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        IXHybridAdRenderer iXHybridAdRenderer = this.u;
        if (iXHybridAdRenderer != null) {
            iXHybridAdRenderer.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void h() {
        IXHybridAdRenderer iXHybridAdRenderer = (IXHybridAdRenderer) av.a(z.k, bu.a(this.i), (Class<?>[]) new Class[]{Context.class}, this.i);
        this.u = iXHybridAdRenderer;
        this.m = iXHybridAdRenderer;
        if (this.n) {
            return;
        }
        a();
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a() {
        if (this.u == null) {
            this.n = false;
            return;
        }
        this.n = true;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_JSSDK);
            this.u.createProdHandler(jSONObject3);
            m();
            if (!TextUtils.isEmpty(this.q)) {
                jSONObject.put("appid", this.q);
            }
            jSONObject.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_JSSDK);
            jSONObject2.put("timeout", 10000);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.u.loadAd(jSONObject, jSONObject2);
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void a(IOAdEvent iOAdEvent) {
        this.u.setCustomerWebView(this.f1808a);
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void q() {
        super.q();
        BaiduHybridAdViewListener baiduHybridAdViewListener = this.t;
        if (baiduHybridAdViewListener != null) {
            baiduHybridAdViewListener.onAdShow(0, null);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void h(IOAdEvent iOAdEvent) {
        super.h(iOAdEvent);
        BaiduHybridAdViewListener baiduHybridAdViewListener = this.t;
        if (baiduHybridAdViewListener != null) {
            baiduHybridAdViewListener.onAdClick(0, null);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void a(String str, int i, String str2) {
        super.a(str, i, str2);
        BaiduHybridAdViewListener baiduHybridAdViewListener = this.t;
        if (baiduHybridAdViewListener != null) {
            baiduHybridAdViewListener.onAdFailed(0, "", str);
        }
    }
}
