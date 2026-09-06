package com.hihonor.adsdk.base.widget.base;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.j.j;
import com.hihonor.adsdk.base.widget.web.jsbridge.MyWebView;
import com.hihonor.adsdk.common.f.u;
import com.hihonor.adsdk.common.f.v;
import com.hihonor.adsdk.common.f.y;
import com.hihonor.adsdk.common.safe.SafeIntent;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.lang.ref.WeakReference;
import java.net.URI;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class f<T extends Parcelable> extends com.hihonor.adsdk.base.widget.base.a {
    protected static final String hnadsl = "info";
    protected static final int hnadsm = 100;
    private static final String hnadsn = "BaseWebViewActivity";
    protected final com.hihonor.adsdk.base.widget.web.b.e hnadse = new com.hihonor.adsdk.base.widget.web.b.e(hnadsk());
    protected String hnadsf;
    protected T hnadsg;
    protected b hnadsh;
    protected a hnadsi;
    protected MyWebView hnadsj;
    private FrameLayout hnadsk;

    public static class a extends WebChromeClient {
        WeakReference<f<?>> hnadsa;

        public a(f<?> fVar) {
            this.hnadsa = new WeakReference<>(fVar);
        }

        protected f<?> hnadsa(WeakReference<f<?>> weakReference) {
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            com.hihonor.adsdk.common.b.b.hnadsc(f.hnadsn, "onProgressChanged view = " + webView.getProgress(), new Object[0]);
            f<?> fVarHnadsa = hnadsa(this.hnadsa);
            if (fVarHnadsa != null) {
                fVarHnadsa.hnadsc(i);
                if (i == 100) {
                    fVarHnadsa.hnadsd(webView.getUrl());
                }
            }
        }
    }

    public static class b extends WebViewClient {
        protected WeakReference<f<?>> hnadsa;
        private volatile boolean hnadsb;

        public b(f<?> fVar) {
            this.hnadsa = new WeakReference<>(fVar);
        }

        protected f<?> hnadsa(WeakReference<f<?>> weakReference) {
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        public void hnadsa() {
            this.hnadsb = false;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            com.hihonor.adsdk.common.b.b.hnadsc(f.hnadsn, "onPageFinished isLoadError = " + this.hnadsb, new Object[0]);
            f<?> fVarHnadsa = hnadsa(this.hnadsa);
            if (fVarHnadsa == null) {
                com.hihonor.adsdk.common.b.b.hnadsc(f.hnadsn, "onPageFinished BaseWebViewActivity finish ", new Object[0]);
                return;
            }
            if (this.hnadsb) {
                com.hihonor.adsdk.common.b.b.hnadsc(f.hnadsn, "onPageFinished is load error", new Object[0]);
                webView.setVisibility(8);
            } else {
                if (webView.getProgress() == 100) {
                    fVarHnadsa.hnadsb(str);
                }
                webView.setVisibility(0);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            com.hihonor.adsdk.common.b.b.hnadsc(f.hnadsn, "onPageStarted", new Object[0]);
            f<?> fVarHnadsa = hnadsa(this.hnadsa);
            if (fVarHnadsa != null) {
                fVarHnadsa.hnadsc(str);
                fVarHnadsa.hnadsb(0);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            this.hnadsb = true;
            f<?> fVarHnadsa = hnadsa(this.hnadsa);
            if (fVarHnadsa != null) {
                fVarHnadsa.hnadsb(i);
                fVarHnadsa.hnadsa(i, str, str2);
            }
            com.hihonor.adsdk.common.b.b.hnadsc(f.hnadsn, "onReceivedError#errorCode=" + i + ",description=" + str, new Object[0]);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            this.hnadsb = true;
            f<?> fVarHnadsa = hnadsa(this.hnadsa);
            if (fVarHnadsa != null) {
                fVarHnadsa.hnadsb(ErrorCode.AD_WEB_SSL_ERR);
                fVarHnadsa.hnadsa(ErrorCode.AD_WEB_SSL_ERR, sslError.toString(), "");
            }
            com.hihonor.adsdk.common.b.b.hnadsc(f.hnadsn, "onReceivedSslError " + sslError, new Object[0]);
        }
    }

    private void hnadsl() {
        SafeIntent safeIntent = new SafeIntent(getIntent());
        safeIntent.setExtrasClassLoader(getClassLoader());
        BaseAd baseAd = (T) safeIntent.getParcelableExtra("info");
        this.hnadsg = baseAd;
        if (baseAd instanceof BaseAd) {
            this.hnadse.hnadsa(baseAd);
        }
    }

    private void hnadsm() {
        String strHnadsg = hnadsg();
        this.hnadsf = strHnadsg;
        if (TextUtils.isEmpty(strHnadsg)) {
            this.hnadse.hnadse(this.hnadsf);
            return;
        }
        String strReplaceAll = this.hnadsf.trim().replaceAll(PPSLabelView.Code, "");
        this.hnadsf = strReplaceAll;
        this.hnadse.hnadsd(strReplaceAll);
    }

    private void hnadso() {
        try {
            this.hnadsj = hnadsd();
        } catch (Exception e) {
            this.hnadsj = null;
            com.hihonor.adsdk.common.b.b.hnadsa(hnadsn, (Object) ("initViews, but new WebView err, Exception: " + e.getMessage()));
            this.hnadse.hnadsa(ErrorCode.AD_DEEP_LINK_WEB_VIEW_INIT_FAIL, ErrorCode.REPORT_AD_DEEP_LINK_WEB_VIEW_INIT_FAIL + e.getMessage());
        }
    }

    protected void hnadsa(int i, String str, String str2) {
    }

    @Override // com.hihonor.adsdk.base.widget.base.a
    protected void hnadsa(Bundle bundle) {
        super.hnadsa(bundle);
        y.hnadsb(getWindow(), false);
        y.hnadsa(getWindow());
    }

    protected abstract void hnadsb(int i);

    @Override // com.hihonor.adsdk.base.widget.base.a
    protected final void hnadsb(Bundle bundle) {
        requestWindowFeature(1);
        setRequestedOrientation(hnadsj());
        hnadsl();
        setContentView(hnadsh());
        hnadso();
        hnadsn();
        hnadsq();
        hnadsp();
        hnadsb();
        hnadsm();
        hnadse(this.hnadsf);
    }

    protected void hnadsb(String str) {
    }

    protected a hnadsc() {
        return new a(this);
    }

    protected void hnadsc(int i) {
    }

    protected void hnadsc(String str) {
    }

    protected MyWebView hnadsd() {
        MyWebView myWebView = new MyWebView(new MutableContextWrapper(HnAds.get().getContext()));
        Context context = myWebView.getContext();
        if (context instanceof MutableContextWrapper) {
            ((MutableContextWrapper) context).setBaseContext(this);
        }
        return myWebView;
    }

    protected void hnadsd(String str) {
    }

    protected b hnadse() {
        return new b(this);
    }

    protected void hnadsf() {
    }

    protected abstract String hnadsg();

    protected abstract int hnadsh();

    protected abstract FrameLayout hnadsi();

    protected int hnadsj() {
        return (j.hnadso() || j.hnadsf(HnAds.get().getContext())) ? -1 : 1;
    }

    protected int hnadsk() {
        return 0;
    }

    protected abstract void hnadsp();

    @Override // android.app.Activity
    public void onBackPressed() {
        hnadsb(0);
        MyWebView myWebView = this.hnadsj;
        if (myWebView == null || !myWebView.canGoBack()) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsn, "super.onBackPressed()", new Object[0]);
            super.onBackPressed();
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsn, "onBackPressed(),can go back", new Object[0]);
        b bVar = this.hnadsh;
        if (bVar != null) {
            bVar.hnadsa();
        }
        this.hnadsj.goBack();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsn, "BaseWebViewActivity onDestroy", new Object[0]);
        MyWebView myWebView = this.hnadsj;
        if (myWebView != null) {
            Context context = myWebView.getContext();
            if (context instanceof MutableContextWrapper) {
                ((MutableContextWrapper) context).setBaseContext(HnAds.get().getContext());
            }
            ViewParent parent = this.hnadsj.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeAllViews();
            }
            this.hnadsj.destroy();
            this.hnadsj = null;
        }
        hnadsf();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsn, "onPause", new Object[0]);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsn, "onResume", new Object[0]);
    }

    private void hnadsn() {
        if (this.hnadsj != null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsn, "initWebSetting", new Object[0]);
            WebView.setWebContentsDebuggingEnabled(false);
            this.hnadsj.removeJavascriptInterface("accessibility");
            this.hnadsj.removeJavascriptInterface("accessibilityTraversal");
            this.hnadsj.removeJavascriptInterface("searchBoxJavaBridge_");
            WebSettings settings = this.hnadsj.getSettings();
            settings.setSavePassword(false);
            settings.setAllowFileAccess(false);
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
            settings.setMixedContentMode(0);
            settings.setAllowContentAccess(false);
            settings.setGeolocationEnabled(false);
            settings.setJavaScriptEnabled(true);
            settings.setDomStorageEnabled(true);
            settings.setSupportZoom(true);
            settings.setBuiltInZoomControls(true);
            settings.setUseWideViewPort(true);
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
            settings.setLoadWithOverviewMode(true);
            settings.setDisplayZoomControls(false);
            settings.setTextZoom(100);
            settings.setCacheMode(-1);
            boolean zHnadsi = u.hnadsi();
            int i = Build.VERSION.SDK_INT;
            if (i >= 33) {
                settings.setForceDark(zHnadsi ? 2 : 0);
                settings.setAlgorithmicDarkeningAllowed(zHnadsi);
            } else if (i >= 29) {
                settings.setForceDark(zHnadsi ? 2 : 0);
            }
        }
    }

    private void hnadsq() {
        if (this.hnadsj != null) {
            a aVarHnadsc = hnadsc();
            this.hnadsi = aVarHnadsc;
            this.hnadsj.setWebChromeClient(aVarHnadsc);
            b bVarHnadse = hnadse();
            this.hnadsh = bVarHnadse;
            this.hnadsj.setWebViewClient(bVarHnadse);
        }
    }

    protected void hnadse(String str) {
        if (this.hnadsk == null) {
            hnadsb(ErrorCode.WEB_LAYOUT_CONTAINER_IS_NULL);
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsn, "loadUrl ,but webLayoutContainer is null", new Object[0]);
            this.hnadse.hnadsa(ErrorCode.WEB_LAYOUT_CONTAINER_IS_NULL, ErrorCode.MSG_WEB_LAYOUT_CONTAINER_IS_NULL);
            return;
        }
        if (this.hnadsj == null) {
            hnadsb(ErrorCode.AD_COMMON_WEB_VIEW_IS_NULL);
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsn, "loadUrl ,but webView is null", new Object[0]);
            this.hnadse.hnadsa(ErrorCode.AD_COMMON_WEB_VIEW_IS_NULL, ErrorCode.MSG_AD_COMMON_WEB_VIEW_IS_NULL);
            return;
        }
        if (this.hnadsg == null) {
            hnadsb(ErrorCode.WEB_BASE_AD_IS_NULL);
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsn, "loadUrl ,but ad is null", new Object[0]);
            this.hnadse.hnadsa(ErrorCode.WEB_BASE_AD_IS_NULL, ErrorCode.MSG_WEB_BASE_AD_IS_NULL);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            hnadsb(ErrorCode.WEB_CURRENT_LOAD_URL_IS_NULL);
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsn, "loadUrl ,currentLoadUrl is empty", new Object[0]);
            this.hnadse.hnadsa(ErrorCode.WEB_CURRENT_LOAD_URL_IS_NULL, ErrorCode.MSG_WEB_CURRENT_LOAD_URL_IS_NULL);
        } else if (!hnadsa(str)) {
            hnadsb(-10);
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsn, "loadUrl ,but url is not valid", new Object[0]);
            hnadsa(-10, "net::ERR_UNSUPPORTED_SCHEME", str);
        } else {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsn, "loadUrl", new Object[0]);
            b bVar = this.hnadsh;
            if (bVar != null) {
                bVar.hnadsa();
            }
            hnadsb(0);
            this.hnadsj.loadUrl(str);
        }
    }

    protected boolean hnadsa(String str) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsn, "isValidUrl", new Object[0]);
        try {
            if (!TextUtils.isEmpty(new URI(str).getHost())) {
                return true;
            }
            com.hihonor.adsdk.common.b.b.hnadse(hnadsn, "isValidUrl,url host is null or empty", new Object[0]);
            return false;
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsn, "isValidUrl, check url exception, msg = %s", v.hnadsb(e.getMessage()));
            this.hnadse.hnadsa(-12, "urlString : " + str + " ,check url exception, ex_msg: " + e.getMessage());
            return true;
        }
    }

    private void hnadsb() {
        FrameLayout frameLayoutHnadsi = hnadsi();
        this.hnadsk = frameLayoutHnadsi;
        if (frameLayoutHnadsi == null || this.hnadsj == null) {
            return;
        }
        frameLayoutHnadsi.removeAllViews();
        this.hnadsk.addView(this.hnadsj);
    }
}
