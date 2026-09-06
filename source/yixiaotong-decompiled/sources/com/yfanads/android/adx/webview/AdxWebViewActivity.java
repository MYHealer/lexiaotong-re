package com.yfanads.android.adx.webview;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.stub.StubApp;
import com.yfanads.android.adx.R;
import com.yfanads.android.adx.webview.client.c;
import com.yfanads.android.adx.webview.view.WebViewPage;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class AdxWebViewActivity extends Activity {
    public static final /* synthetic */ int e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WebViewPage f9624a;
    public String b;
    public String c;
    public boolean d;

    public class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f9625a;

        public a(TextView textView) {
            this.f9625a = textView;
        }

        @Override // com.yfanads.android.adx.webview.client.c, android.webkit.WebViewClient
        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            String title = webView.getTitle();
            if (!TextUtils.isEmpty(title)) {
                com.yfanads.android.adx.utils.a.a("AdxWebViewActivity title " + title);
                this.f9625a.setText(title);
            }
            AdxWebViewActivity.this.f9624a.b.setVisibility(8);
            if (TextUtils.isEmpty(AdxWebViewActivity.this.c)) {
                return;
            }
            AdxWebViewActivity adxWebViewActivity = AdxWebViewActivity.this;
            if (adxWebViewActivity.d) {
                return;
            }
            adxWebViewActivity.d = true;
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(AdxWebViewActivity.this.c));
                intent.addFlags(268435456);
                AdxWebViewActivity.this.startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.yfanads.android.adx.webview.client.c, android.webkit.WebViewClient
        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            AdxWebViewActivity.this.f9624a.b.setVisibility(0);
        }

        @Override // com.yfanads.android.adx.webview.client.c, android.webkit.WebViewClient
        public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            AdxWebViewActivity.this.f9624a.b.setVisibility(8);
        }

        @Override // com.yfanads.android.adx.webview.client.c, android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }
    }

    public class b extends com.yfanads.android.adx.webview.client.b {
        public b() {
        }

        @Override // com.yfanads.android.adx.webview.client.b, android.webkit.WebChromeClient
        public final void onProgressChanged(WebView webView, int i) {
            if (i >= 100) {
                AdxWebViewActivity.this.f9624a.b.setVisibility(8);
            } else {
                if (AdxWebViewActivity.this.f9624a.b.getVisibility() == 8) {
                    AdxWebViewActivity.this.f9624a.b.setVisibility(0);
                }
                AdxWebViewActivity.this.f9624a.b.setProgress(i);
            }
            super.onProgressChanged(webView, i);
        }
    }

    static {
        StubApp.interface11(56428);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view) {
        setResult(101);
        finish();
    }

    public final void a() {
        TextView textView = (TextView) findViewById(R.id.tev_title);
        ImageView imageView = (ImageView) findViewById(R.id.img_back);
        ImageView imageView2 = (ImageView) findViewById(R.id.img_close);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.layout_web_view);
        WebViewPage webViewPage = new WebViewPage(this);
        this.f9624a = webViewPage;
        frameLayout.addView(webViewPage);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.android.adx.webview.AdxWebViewActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.a(view);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.android.adx.webview.AdxWebViewActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.b(view);
            }
        });
        this.f9624a.setWebViewClient(new a(textView));
        this.f9624a.setWebChromeClient(new b());
        this.f9624a.setDownloadListener(new com.yfanads.android.adx.webview.client.a(StubApp.getOrigApplicationContext(getApplicationContext())));
        WebViewPage webViewPage2 = this.f9624a;
        String str = this.b;
        com.yfanads.android.adx.webview.settings.a aVar = webViewPage2.f9631a.b;
        boolean z = !("file://".equals(str) || "content://".equals(str));
        aVar.b = z;
        aVar.f9629a.setJavaScriptEnabled(z);
        webViewPage2.f9631a.loadUrl(str);
    }

    @Override // android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    public final void onBackPressed() {
        WebViewPage webViewPage = this.f9624a;
        if (webViewPage != null) {
            if (webViewPage.f9631a.canGoBack()) {
                webViewPage.f9631a.goBack();
                return;
            }
            com.yfanads.android.adx.utils.a.a("AdxWebViewActivity onBackPressed setResult");
            setResult(101);
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        onBackPressed();
    }
}
