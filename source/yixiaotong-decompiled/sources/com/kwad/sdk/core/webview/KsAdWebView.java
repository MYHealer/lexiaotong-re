package com.kwad.sdk.core.webview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.cb;
import com.kwad.sdk.utils.cd;
import com.kwad.sdk.wrapper.m;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class KsAdWebView extends com.kwad.sdk.core.webview.c {
    private long HK;
    private com.kwad.sdk.core.webview.a.c.a NL;
    private com.kwad.sdk.core.webview.a.c bcc;
    private String bcd;
    private boolean bce;
    private com.kwad.sdk.core.webview.d bcf;
    private String mUniqueId;

    public interface b {
        void onFailed();

        void onSuccess();
    }

    public interface c {
        void uu();
    }

    public interface d {
        boolean shouldOverrideUrlLoading(WebView webView, String str);
    }

    public interface e {
        void onPageFinished();

        void onPageStart();

        void onReceivedHttpError(int i, String str, String str2);
    }

    private void setAccessibilityStateDisable(Context context) {
    }

    public com.kwad.sdk.core.webview.a.c.a getClientConfig() {
        return this.NL;
    }

    public long getLoadTime() {
        return this.HK;
    }

    public String getLoadUrl() {
        return this.bcd;
    }

    public String getUniqueId() {
        return this.mUniqueId;
    }

    public KsAdWebView(Context context) {
        super(context);
        this.bce = false;
        init(context);
    }

    public KsAdWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bce = false;
        init(context);
    }

    public KsAdWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bce = false;
        init(context);
    }

    public KsAdWebView(Context context, AttributeSet attributeSet, int i, boolean z) {
        super(context, attributeSet, i, z);
        this.bce = false;
        init(context);
    }

    public void setClientConfig(com.kwad.sdk.core.webview.a.c.a aVar) {
        this.bcc.setClientConfig(aVar);
        com.kwad.sdk.core.webview.a.c.a aVar2 = this.NL;
        if (aVar2 == null || !aVar2.PD()) {
            return;
        }
        this.bcf = new com.kwad.sdk.core.webview.d();
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        com.kwad.sdk.core.webview.a.c.a aVar;
        if (motionEvent.getAction() == 1 && (aVar = this.NL) != null) {
            aVar.aR(System.currentTimeMillis());
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        a(getContext(), getSettings());
        com.kwad.sdk.core.webview.b.c.b.fT(this.mUniqueId);
        this.bcd = str;
        this.HK = System.currentTimeMillis();
        super.loadUrl(str);
    }

    private void init(Context context) {
        com.kwad.sdk.core.d.c.i("KsAdWebView", "init");
        setAccessibilityStateDisable(context);
        WebSettings webSettingsB = cd.b(this);
        webSettingsB.setUseWideViewPort(true);
        webSettingsB.setDomStorageEnabled(true);
        setVerticalScrollBarEnabled(false);
        com.kwad.sdk.core.webview.a.c cVar = new com.kwad.sdk.core.webview.a.c() { // from class: com.kwad.sdk.core.webview.KsAdWebView.1
            @Override // com.kwad.sdk.core.webview.a.c, android.webkit.WebViewClient
            public final void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                if (KsAdWebView.this.bcf != null) {
                    com.kwad.sdk.core.webview.d unused = KsAdWebView.this.bcf;
                    com.kwad.sdk.core.webview.d.d(KsAdWebView.this.NL);
                }
            }

            @Override // com.kwad.sdk.core.webview.a.c, android.webkit.WebViewClient
            public final void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (KsAdWebView.this.bcf != null) {
                    KsAdWebView.this.bcf.c(KsAdWebView.this.NL);
                }
                if (KsAdWebView.this.bcf == null || KsAdWebView.this.bce || KsAdWebView.this.getProgress() < 100) {
                    return;
                }
                KsAdWebView.this.bcf.e(KsAdWebView.this.NL);
            }
        };
        this.bcc = cVar;
        cVar.S(this.mUniqueId);
        setWebViewClient(this.bcc);
        setWebChromeClient(new com.kwad.sdk.core.webview.a.b());
        setDownloadListener(new a(this, (byte) 0));
        this.NL = new com.kwad.sdk.core.webview.a.c.a(getContext());
    }

    private void a(Context context, WebSettings webSettings) {
        boolean zPF;
        boolean zPG;
        String userAgentString = webSettings.getUserAgentString();
        com.kwad.sdk.core.webview.a.c.a aVar = this.NL;
        if (aVar != null) {
            zPF = aVar.PF();
            zPG = this.NL.PG();
        } else {
            zPF = false;
            zPG = false;
        }
        com.kwad.sdk.core.i.c cVarK = com.kwad.sdk.core.i.a.k(zPF, zPG);
        com.kwad.sdk.core.d.c.d("KsAdWebView", "setWebViewUserAgent: uaGetter：" + cVarK);
        String str = userAgentString + cVarK.ce(context);
        com.kwad.sdk.core.d.c.d("KsAdWebView", "setWebViewUserAgent: " + str);
        webSettings.setUserAgentString(str);
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        if (com.kwad.framework.a.a.pe.booleanValue() && !(webViewClient instanceof com.kwad.sdk.core.webview.a.a)) {
            throw new IllegalArgumentException("Not supported set webViewClient, please check it");
        }
        super.setWebViewClient(webViewClient);
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        if (com.kwad.framework.a.a.pe.booleanValue() && !(webChromeClient instanceof com.kwad.sdk.core.webview.a.b)) {
            throw new IllegalArgumentException("client is not instanceof KSWebChromeClient");
        }
        super.setWebChromeClient(webChromeClient);
    }

    @Override // com.kwad.sdk.core.webview.c, android.webkit.WebView
    public void destroy() {
        this.bce = true;
        super.destroy();
        com.kwad.sdk.core.webview.a.c.a aVar = this.NL;
        if (aVar != null) {
            aVar.release();
            this.NL = null;
        }
        com.kwad.sdk.core.webview.a.c cVar = this.bcc;
        if (cVar != null) {
            cVar.destroy();
            this.bcc = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.kwad.sdk.core.webview.a.c.a getReadyClientConfig() {
        com.kwad.sdk.core.webview.a.c cVar = this.bcc;
        if (cVar == null || cVar.getClientConfig() == null) {
            return null;
        }
        return this.bcc.getClientConfig();
    }

    public final void onActivityCreate() {
        com.kwad.sdk.core.webview.d dVar = this.bcf;
        if (dVar != null) {
            dVar.a(this.NL);
        }
    }

    public final void onActivityDestroy() {
        this.bce = true;
        release();
        com.kwad.sdk.core.webview.d dVar = this.bcf;
        if (dVar != null) {
            dVar.b(this.NL);
        }
    }

    class a implements DownloadListener {
        private a() {
        }

        /* synthetic */ a(KsAdWebView ksAdWebView, byte b) {
            this();
        }

        @Override // android.webkit.DownloadListener
        public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            boolean zR = cb.r(KsAdWebView.this, 100);
            com.kwad.sdk.core.d.c.d("KsAdWebView", "onDownloadStart: currentVisible " + zR);
            if (zR) {
                if (KsAdWebView.this.NL == null || KsAdWebView.this.NL.PE()) {
                    if (KsAdWebView.this.NL != null && KsAdWebView.this.NL.getAdTemplate() != null && KsAdWebView.this.NL.PC()) {
                        com.kwad.sdk.core.response.helper.e.eO(KsAdWebView.this.NL.getAdTemplate()).adConversionInfo.appDownloadUrl = str;
                        KsAdWebView.this.NL.getAdTemplate().isWebViewDownload = true;
                        com.kwad.sdk.core.webview.a.c.a readyClientConfig = KsAdWebView.this.getReadyClientConfig();
                        if (readyClientConfig != null) {
                            readyClientConfig.fo(KsAdWebView.this.NL.getAdTemplate());
                        }
                        ((com.kwad.sdk.service.a.a) ServiceProvider.get(com.kwad.sdk.service.a.a.class)).k(m.wrapContextIfNeed(KsAdWebView.this.getContext()), KsAdWebView.this.NL.getAdTemplate());
                        return;
                    }
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                        intent.setFlags(268435456);
                        KsAdWebView.this.getContext().startActivity(intent);
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.c.printStackTrace(e);
                    }
                }
            }
        }
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        com.kwad.sdk.core.webview.a.c.a aVar = this.NL;
        if (aVar == null || aVar.ut() == null) {
            return;
        }
        this.NL.ut().uu();
    }
}
