package com.jd.ad.sdk.bl.adinteraction.deeplink;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.ZoomButtonsController;
import com.jd.ad.sdk.logger.Logger;
import com.stub.StubApp;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class JADWebViewActivity extends Activity {
    public static final String mUrlIntent = "urlIntent";
    private WebView mWebView;

    public class jad_an implements DownloadListener {
        public jad_an() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            if (str.endsWith(".apk")) {
                try {
                    JADWebViewActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public class jad_bo extends WebChromeClient {
        public final /* synthetic */ TextView jad_an;

        public jad_bo(JADWebViewActivity jADWebViewActivity, TextView textView) {
            this.jad_an = textView;
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.jad_an.setText(str);
        }
    }

    public class jad_cp implements View.OnClickListener {
        public jad_cp() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            JADWebViewActivity.this.finish();
        }
    }

    public class jad_dq implements View.OnClickListener {
        public jad_dq() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            JADWebViewActivity.this.onBackClick();
        }
    }

    static {
        StubApp.interface11(36872);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBackClick() {
        WebView webView = this.mWebView;
        if (webView == null || !webView.canGoBack()) {
            finish();
        } else {
            this.mWebView.goBack();
        }
    }

    public static boolean startActivity(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        Intent intent = new Intent(context, (Class<?>) JADWebViewActivity.class);
        intent.putExtra(mUrlIntent, new String[]{str});
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
        return true;
    }

    @Override // android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            WebView webView = this.mWebView;
            if (webView != null) {
                webView.destroy();
            }
        } catch (Exception e) {
            Logger.w(com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Exception while webview activity onDestroy:").append(e.getMessage()).toString(), new Object[0]);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        WebView webView = this.mWebView;
        if (webView == null || i != 4 || !webView.canGoBack()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.mWebView.goBack();
        return true;
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        try {
            WebView webView = this.mWebView;
            if (webView != null) {
                webView.onPause();
            }
        } catch (Exception e) {
            Logger.w(com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Exception while webview activity onPause:").append(e.getMessage()).toString(), new Object[0]);
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        try {
            WebView webView = this.mWebView;
            if (webView != null) {
                webView.onResume();
            }
        } catch (Exception e) {
            Logger.w(com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Exception while webview activity onResume:").append(e.getMessage()).toString(), new Object[0]);
        }
    }

    public void setZoomControlGone(View view) {
        try {
            Field declaredField = WebView.class.getDeclaredField("mZoomButtonsController");
            declaredField.setAccessible(true);
            ZoomButtonsController zoomButtonsController = new ZoomButtonsController(view);
            zoomButtonsController.getZoomControls().setVisibility(8);
            declaredField.set(view, zoomButtonsController);
        } catch (Exception e) {
            Logger.w(com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Exception while load webview activity:").append(e.getMessage()).toString(), new Object[0]);
        }
    }

    public static class jad_er extends WebViewClient {
        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            return true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            Uri uri = Uri.EMPTY;
            Uri url = webResourceRequest.getUrl();
            String string = url.toString();
            if (!TextUtils.isEmpty(string) && !string.startsWith("http")) {
                try {
                    Context context = webView.getContext();
                    Intent intent = new Intent("android.intent.action.VIEW", url);
                    if (!(context instanceof Activity)) {
                        intent.addFlags(268435456);
                    }
                    context.startActivity(intent);
                    return true;
                } catch (Throwable unused) {
                }
            }
            return false;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str.startsWith("http")) {
                return false;
            }
            try {
                Context context = webView.getContext();
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                context.startActivity(intent);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
    }
}
