package com.fancy.mpsdk.widget.web;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.webkit.ConsoleMessage;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.fancy._pc;
import com.fancy.adsdk.lib.utils.TextUtil;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class AdTemplateWebView extends WebView {
    public boolean _a;
    public _pc _b;

    public class _a extends WebChromeClient {
        @Override // android.webkit.WebChromeClient
        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            return true;
        }
    }

    public static class _b {
        public AdTemplateWebView _a;
        public Handler _b = new Handler(Looper.getMainLooper());

        public class _a implements Runnable {
            public final /* synthetic */ String _a;
            public final /* synthetic */ String _b;

            public _a(String str, String str2) {
                this._a = str;
                this._b = str2;
            }

            /* JADX WARN: Code duplicated, block: B:46:0x0099  */
            @Override // java.lang.Runnable
            public final void run() {
                AdTemplateWebView adTemplateWebView = _b.this._a;
                if (adTemplateWebView._b == null || adTemplateWebView._a) {
                    return;
                }
                try {
                    switch (this._a) {
                        case "onLoad":
                            _b._a(_b.this, this._b);
                            break;
                        case "onTimeEnd":
                            _b.this._a._b._f();
                            break;
                        case "onClick":
                            _b _bVar = _b.this;
                            String str = this._b;
                            _bVar.getClass();
                            if (!TextUtil.isEmpty(str)) {
                                JSONObject jSONObject = new JSONObject(str);
                                _bVar._a._b._a(jSONObject.optInt("clickType", 1), jSONObject);
                                break;
                            }
                            break;
                        case "playVideo":
                            _b.this._a._b._d();
                            break;
                        case "pauseVideo":
                            _b.this._a._b.pauseVideo();
                            break;
                        case "getVideoProgress":
                            _b.this._a._b._a();
                            break;
                        case "setMuted":
                            _b _bVar2 = _b.this;
                            String str2 = this._b;
                            _bVar2.getClass();
                            _bVar2._a._b._a(TextUtil.isEmpty(str2) ? false : new JSONObject(str2).optBoolean("muted", false));
                            break;
                        case "triggerReward":
                            _b.this._a._b._c();
                            break;
                        case "checkAppInstalled":
                            _b.this._a._b._b();
                            break;
                        case "checkAppDownloaded":
                            _b.this._a._b._e();
                            break;
                        case "onUploadMessage":
                            _b.this._a._b._a(this._b);
                            break;
                        case "handleTimeUpdate":
                            _b _bVar3 = _b.this;
                            String str3 = this._b;
                            _bVar3.getClass();
                            if (!TextUtil.isEmpty(str3)) {
                                _bVar3._a._b._a(new JSONObject(str3).optInt(CrashHianalyticsData.TIME, 0));
                                break;
                            }
                            break;
                        default:
                            break;
                    }
                } catch (JSONException | Exception unused) {
                }
            }
        }

        public _b(AdTemplateWebView adTemplateWebView) {
            this._a = adTemplateWebView;
        }

        public static void _a(_b _bVar, String str) {
            _bVar.getClass();
            try {
                JSONObject jSONObject = TextUtil.isEmpty(str) ? new JSONObject() : new JSONObject(str);
                if (jSONObject.optInt("isSuccess", 0) == 1) {
                    _bVar._a._b._g();
                } else {
                    _bVar._a._b._b(jSONObject.optString("error", "web模版加载失败"));
                }
            } catch (JSONException unused) {
                _bVar._a._b._b("参数解析失败");
            }
        }

        @JavascriptInterface
        public void handleNativeMethod(String str, String str2) {
            if (this._a == null) {
                return;
            }
            this._b.post(new _a(str, str2));
        }
    }

    public AdTemplateWebView(Context context) {
        this(context, null, 0);
    }

    public AdTemplateWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdTemplateWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        _a();
    }

    public final void _a() {
        requestFocus();
        getSettings().setUseWideViewPort(true);
        getSettings().setLoadWithOverviewMode(true);
        getSettings().setSupportZoom(false);
        getSettings().setBuiltInZoomControls(false);
        getSettings().setDisplayZoomControls(false);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setDomStorageEnabled(true);
        getSettings().setDatabaseEnabled(true);
        getSettings().setLoadsImagesAutomatically(true);
        addJavascriptInterface(new _b(this), "androidJsBridge");
        setWebViewClient(new WebViewClient() { // from class: com.fancy.mpsdk.widget.web.AdTemplateWebView.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
            }

            @Override // android.webkit.WebViewClient
            public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public final void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
            }

            @Override // android.webkit.WebViewClient
            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
        });
        setWebChromeClient(new _a());
    }

    @Override // android.webkit.WebView
    public final void destroy() {
        super.destroy();
        this._a = true;
    }

    public void setWebViewBridgeListener(_pc _pcVar) {
        this._b = _pcVar;
    }
}
