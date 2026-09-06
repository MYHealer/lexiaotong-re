package com.opos.cmn.biz.web.b.b.b;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.stub.StubApp;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f6045a;
    private Map<String, Object> b;
    private boolean c;
    private WebView d;
    private RelativeLayout e;
    private RelativeLayout f;
    private String j;
    private com.opos.cmn.biz.web.b.a.a.b l;
    private com.opos.cmn.biz.web.b.a.a.a m;
    private com.opos.cmn.biz.web.b.a.a.c n;
    private RelativeLayout g = null;
    private TextView h = null;
    private ProgressBar i = null;
    private boolean k = false;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar = b.this;
            bVar.a(bVar.j);
        }
    }

    /* JADX INFO: renamed from: com.opos.cmn.biz.web.b.b.b.b$b, reason: collision with other inner class name */
    class ViewOnClickListenerC0883b implements View.OnClickListener {
        ViewOnClickListenerC0883b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.r();
        }
    }

    class c extends WebChromeClient {
        c() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            return super.onConsoleMessage(consoleMessage);
        }

        @Override // android.webkit.WebChromeClient
        public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
            quotaUpdater.updateQuota(j2 * 2);
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            b.this.i.setProgress(i);
            if (i < 100 || b.this.i == null) {
                return;
            }
            b.this.i.setVisibility(8);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
        }
    }

    class d extends WebViewClient {
        d() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            StringBuilder sb = new StringBuilder("onPageFinished:url=");
            if (str == null) {
                str = "null";
            }
            com.opos.cmn.an.f.a.a("WebWidgetImpl", sb.append(str).toString());
            if (b.this.k) {
                return;
            }
            b.this.p();
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            StringBuilder sb = new StringBuilder("onPageStarted:url=");
            if (str == null) {
                str = "null";
            }
            com.opos.cmn.an.f.a.a("WebWidgetImpl", sb.append(str).toString());
            b.this.k = false;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            StringBuilder sbAppend = new StringBuilder("onReceivedError:errorCode=").append(i).append(",description=");
            if (str == null) {
                str = "null";
            }
            StringBuilder sbAppend2 = sbAppend.append(str).append(",failingUrl=");
            if (str2 == null) {
                str2 = "null";
            }
            com.opos.cmn.an.f.a.c("WebWidgetImpl", sbAppend2.append(str2).toString());
            b.this.k = true;
            b.this.q();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            com.opos.cmn.an.f.a.c("WebWidgetImpl", "onReceivedSslError:error=" + (sslError != null ? sslError.toString() : "null"));
            b.this.a(sslErrorHandler, sslError);
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            com.opos.cmn.an.f.a.c("WebWidgetImpl", "onRenderProcessGone WebView rendering process killed to reclaim memory. Recreating...");
            b.this.c();
            return true;
        }

        @Override // android.webkit.WebViewClient
        public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
            super.onUnhandledKeyEvent(webView, keyEvent);
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            WebResourceResponse webResourceResponseA = com.opos.cmn.biz.web.a.b.c.a().a(str);
            return webResourceResponseA != null ? webResourceResponseA : super.shouldInterceptRequest(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (com.opos.cmn.an.d.a.a(str) || str.startsWith("http")) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            b.this.b(str);
            return true;
        }
    }

    class e implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SslErrorHandler f6050a;

        e(b bVar, SslErrorHandler sslErrorHandler) {
            this.f6050a = sslErrorHandler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.f6050a.proceed();
        }
    }

    class f implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SslErrorHandler f6051a;

        f(SslErrorHandler sslErrorHandler) {
            this.f6051a = sslErrorHandler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.f6051a.cancel();
            b.this.r();
        }
    }

    public b(Context context, com.opos.cmn.biz.web.b.a.b bVar) {
        this.f6045a = context;
        this.b = bVar.b;
        this.l = bVar.f6042a;
        this.m = bVar.d;
        this.c = bVar.c;
        this.n = bVar.e;
        f();
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslErrorHandler != null) {
            try {
                com.opos.cmn.biz.web.b.a.a.a aVar = this.m;
                if (aVar != null) {
                    aVar.a(sslErrorHandler, sslError);
                } else if (this.f6045a instanceof Activity) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this.f6045a);
                    builder.setMessage("SSL证书验证错误，是否继续？");
                    builder.setPositiveButton("继续", new e(this, sslErrorHandler));
                    builder.setNegativeButton("取消", new f(sslErrorHandler));
                    AlertDialog alertDialogCreate = builder.create();
                    alertDialogCreate.setCancelable(false);
                    alertDialogCreate.setCanceledOnTouchOutside(false);
                    alertDialogCreate.show();
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("WebWidgetImpl", "", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        boolean z = false;
        if (!com.opos.cmn.an.d.a.a(str)) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setComponent(null);
                intent.setSelector(null);
                intent.addFlags(268435456);
                if (com.opos.cmn.an.h.d.a.a(this.f6045a, intent)) {
                    com.opos.cmn.biz.web.b.a.a.c cVar = this.n;
                    if (cVar != null && !cVar.b(str)) {
                        return false;
                    }
                    this.f6045a.startActivity(intent);
                    com.opos.cmn.biz.web.b.a.a.c cVar2 = this.n;
                    if (cVar2 != null) {
                        cVar2.a(str);
                    }
                    z = true;
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("WebWidgetImpl", "", e2);
            }
        }
        StringBuilder sb = new StringBuilder("checkLaunchApp url=");
        if (str == null) {
            str = "null";
        }
        com.opos.cmn.an.f.a.a("WebWidgetImpl", sb.append(str).append("result=").append(z).toString());
        return z;
    }

    private void f() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f6045a);
        this.e = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.e.setFitsSystemWindows(true);
        View viewG = g();
        this.e.addView(viewG);
        if (!this.c) {
            viewG.setVisibility(8);
        }
        h();
        i();
        j();
    }

    private View g() {
        LinearLayout linearLayout = new LinearLayout(this.f6045a);
        linearLayout.setId(1);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.f6045a, 43.33f)));
        if (com.opos.cmn.biz.web.b.b.a.a.b(this.f6045a)) {
            linearLayout.setBackgroundColor(Color.parseColor("#F5EEEEEE"));
        } else {
            com.opos.cmn.biz.web.b.b.a.a.a(linearLayout, com.opos.cmn.an.e.a.a.c(this.f6045a, "o_cmn_biz_ui_web_title_bar_bg.9.png"));
        }
        this.h = new TextView(this.f6045a);
        Drawable drawableC = com.opos.cmn.an.e.a.a.c(this.f6045a, "o_cmn_biz_ui_web_close_bn.png");
        drawableC.setBounds(0, 0, com.opos.cmn.an.h.f.a.a(this.f6045a, 26.0f), com.opos.cmn.an.h.f.a.a(this.f6045a, 24.0f));
        this.h.setCompoundDrawables(drawableC, null, null, null);
        this.h.setGravity(17);
        this.h.setTextSize(2, 15.0f);
        this.h.setTextColor(Color.parseColor("#2ac795"));
        this.h.setCompoundDrawablePadding(com.opos.cmn.an.h.f.a.a(this.f6045a, 2.0f));
        this.h.setText("返回");
        linearLayout.addView(this.h, new LinearLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.f6045a, 43.33f)));
        return linearLayout;
    }

    private void h() {
        this.f = new RelativeLayout(this.f6045a);
        WebView webView = new WebView(this.f6045a);
        this.d = webView;
        this.f.addView(webView, new RelativeLayout.LayoutParams(-1, -1));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(3, 1);
        this.e.addView(this.f, layoutParams);
    }

    private void i() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f6045a);
        this.g = relativeLayout;
        relativeLayout.setVisibility(8);
        this.g.setGravity(17);
        ImageView imageView = new ImageView(this.f6045a);
        imageView.setId(2);
        imageView.setImageDrawable(com.opos.cmn.an.e.a.a.c(this.f6045a, "o_cmn_biz_ui_web_err_tag_img.png"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f6045a, 39.33f), com.opos.cmn.an.h.f.a.a(this.f6045a, 40.0f));
        layoutParams.addRule(14, -1);
        this.g.addView(imageView, layoutParams);
        TextView textView = new TextView(this.f6045a);
        textView.setId(3);
        textView.setText("网络繁忙，请刷新");
        textView.setTextSize(2, 14.0f);
        textView.setTextColor(Color.parseColor("#ababab"));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(14, -1);
        layoutParams2.addRule(3, 2);
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.f6045a, 15.0f);
        this.g.addView(textView, layoutParams2);
        com.opos.cmn.biz.web.b.b.b.a aVar = new com.opos.cmn.biz.web.b.b.b.a(this.f6045a, "o_cmn_biz_ui_web_err_refresh_normal_img.png", "o_cmn_biz_ui_web_err_refresh_press_img.png");
        aVar.setGravity(17);
        aVar.setText("刷新");
        aVar.setTextSize(2, 12.0f);
        aVar.setTextColor(Color.parseColor("#36ae9e"));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f6045a, 52.67f), com.opos.cmn.an.h.f.a.a(this.f6045a, 23.33f));
        layoutParams3.addRule(14, -1);
        layoutParams3.addRule(3, 3);
        layoutParams3.topMargin = com.opos.cmn.an.h.f.a.a(this.f6045a, 37.67f);
        aVar.setOnClickListener(new a());
        this.g.addView(aVar, layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams4.addRule(3, 1);
        this.e.addView(this.g, layoutParams4);
    }

    private void j() {
        ProgressBar progressBar = new ProgressBar(this.f6045a);
        this.i = progressBar;
        com.opos.cmn.biz.web.b.b.a.a.a(progressBar, "mOnlyIndeterminate", new Boolean(false));
        this.i.setIndeterminate(false);
        this.i.setProgressDrawable(new ClipDrawable(new ColorDrawable(Color.parseColor("#33cc9c")), 3, 1));
        this.i.setBackgroundColor(Color.parseColor("#cfcfcf"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.f6045a, 1.33f));
        layoutParams.addRule(3, 1);
        this.e.addView(this.i, layoutParams);
    }

    private void k() {
        this.h.setOnClickListener(new ViewOnClickListenerC0883b());
        m();
        n();
        o();
        l();
        this.d.requestFocusFromTouch();
        this.d.requestFocus();
    }

    private void l() {
        Map<String, Object> map = this.b;
        if (map == null || map.size() <= 0) {
            return;
        }
        try {
            for (Map.Entry<String, Object> entry : this.b.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (!com.opos.cmn.an.d.a.a(key) && value != null) {
                    com.opos.cmn.an.f.a.a("WebWidgetImpl", "addJavascriptInterface jsName=" + key + ",object=" + value);
                    this.d.addJavascriptInterface(value, key);
                }
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("WebWidgetImpl", "", e2);
        }
    }

    private void m() {
        WebSettings settings = this.d.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setDatabasePath(StubApp.getOrigApplicationContext(this.f6045a.getApplicationContext()).getDir("database", 0).getPath());
        settings.setCacheMode(-1);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setUseWideViewPort(true);
        settings.setSavePassword(false);
        settings.setAllowFileAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        CookieManager.getInstance().setAcceptThirdPartyCookies(this.d, true);
        settings.setMixedContentMode(0);
        settings.setAllowContentAccess(false);
    }

    private void n() {
        this.d.setWebChromeClient(new c());
    }

    private void o() {
        this.d.setWebViewClient(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        this.f.setVisibility(0);
        this.g.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        this.f.setVisibility(8);
        this.g.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        com.opos.cmn.biz.web.b.a.a.b bVar = this.l;
        if (bVar != null) {
            bVar.c();
        }
    }

    private void s() {
        if (this.d != null) {
            com.opos.cmn.an.f.a.a("WebWidgetImpl", "destoryWebView");
            this.d.removeAllViews();
            this.f.removeView(this.d);
            this.d.stopLoading();
            this.d.getSettings().setJavaScriptEnabled(false);
            this.d.clearHistory();
            this.d.clearCache(true);
            this.d.destroyDrawingCache();
            this.d.destroy();
            this.d = null;
        }
    }

    public View a() {
        return this.e;
    }

    public void a(String str) {
        if (this.d == null || com.opos.cmn.an.d.a.a(str)) {
            return;
        }
        this.d.loadUrl(str);
        this.j = str;
    }

    public boolean b() {
        RelativeLayout relativeLayout = this.g;
        return relativeLayout != null && relativeLayout.getVisibility() == 0;
    }

    public void c() {
        if (this.d != null) {
            com.opos.cmn.an.f.a.a("WebWidgetImpl", "closeWebView");
            s();
            RelativeLayout relativeLayout = this.e;
            if (relativeLayout != null) {
                relativeLayout.removeAllViews();
                this.e = null;
            }
            this.f6045a = null;
        }
    }

    public void d() {
        com.opos.cmn.an.f.a.a("WebWidgetImpl", "reInitWebView");
        s();
        h();
        k();
    }

    public boolean e() {
        WebView webView = this.d;
        if (webView == null || !webView.canGoBack()) {
            return false;
        }
        this.d.goBack();
        return true;
    }
}
