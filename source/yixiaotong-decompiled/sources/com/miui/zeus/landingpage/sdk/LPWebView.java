package com.miui.zeus.landingpage.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.net.http.SslError;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.landingpage.sdk.activity.WebViewActivity;
import com.miui.zeus.landingpage.sdk.js.LPJsCallee;
import com.miui.zeus.mimo.sdk.m;
import com.miui.zeus.mimo.sdk.x8;
import com.miui.zeus.mimo.sdk.y8;
import ijiami_1011.s.s.s;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class LPWebView extends WebView {
    private boolean isYMLandingPage;
    private Context mContext;
    private LPJsCallee mLPJsCallee;
    private OnWebPageFinishedListener mOnWebPageFinishedListener;
    private boolean mPreloadWithWebView;
    private boolean mShowClose;
    private boolean mShowTitle;
    private static final String TAG = s.d(new byte[]{124, 50, 111, 86, 82, 48, 8, 1, 17}, "0b830f");
    private static final String DEFAULT_BROWSER_MAIN_CLASS_NAME = s.d(new byte[]{6, 94, 84, Ascii.CAN, 85, 95, 5, Ascii.SYN, 9, 11, 85, 75, 7, 67, 86, 65, 71, 84, 19, 74, 36, 16, 94, Ascii.DC2, Ascii.SYN, 84, 75, 119, 87, 69, 8, Ascii.DC2, 15, Ascii.SYN, 72}, "e19641");

    public interface OnWebPageFinishedListener {
        void onReceivedTitle(WebView webView, String str);

        void onWebPageError(WebView webView, String str);

        void onWebPageFinished(WebView webView, String str);

        boolean shouldOverrideUrlLoading(WebView webView, String str);
    }

    public LPWebView(Context context) {
        this(context, null);
    }

    public LPWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isYMLandingPage = false;
        init(context);
    }

    public LPWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isYMLandingPage = false;
        init(context);
    }

    private void addJavascriptInterfaceOnMainThread(final String str) {
        if (this.mPreloadWithWebView) {
            return;
        }
        x8.e(new Runnable() { // from class: com.miui.zeus.landingpage.sdk.LPWebView.4
            @Override // java.lang.Runnable
            public void run() {
                if (LPWebView.this.mLPJsCallee == null || !com.miui.zeus.mimo.sdk.b.b(str)) {
                    return;
                }
                m.a(s.d(new byte[]{45, 99, 51, 3, 81, 50, 8, 1, 17}, "a3df3d"), s.d(new byte[]{82, 0, 80, 125, 89, 69, 0, Ascii.ETB, 5, 16, 88, Ascii.NAK, 71, 45, 90, 67, 93, 65, 7, 5, 5, 7, 126, 11, 126, 5, 93, 89, 108, 91, 19, 1, 7, 6}, "3d4783"));
                LPWebView lPWebView = LPWebView.this;
                lPWebView.addJavascriptInterface(lPWebView.mLPJsCallee, s.d(new byte[]{12, 91, 71, 13}, "a22d48"));
            }
        });
    }

    private void configWebView(WebView webView) {
        WebSettings settings = webView.getSettings();
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setDomStorageEnabled(true);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setJavaScriptEnabled(true);
        settings.setDatabasePath(this.mContext.getCacheDir().getAbsolutePath());
        settings.setDatabaseEnabled(true);
        settings.setDefaultTextEncodingName(s.d(new byte[]{101, 98, 34, 72, 89}, "06dead"));
        settings.setBlockNetworkImage(false);
        settings.setAllowContentAccess(false);
        settings.setAllowFileAccess(false);
        settings.setTextZoom(100);
        webView.resumeTimers();
        if (y8.d) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        settings.setMixedContentMode(1);
        webView.setWebViewClient(new WebViewClient() { // from class: com.miui.zeus.landingpage.sdk.LPWebView.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView2, String str) {
                super.onPageFinished(webView2, str);
                if (LPWebView.this.mOnWebPageFinishedListener != null) {
                    LPWebView.this.mOnWebPageFinishedListener.onWebPageFinished(webView2, str);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView2, int i, String str, String str2) {
                super.onReceivedError(webView2, i, str, str2);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView2, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView2, webResourceRequest, webResourceError);
                if (webResourceRequest.isForMainFrame()) {
                    LPWebView.this.onWebPageError(webView2, String.format(s.d(new byte[]{9, 90, 107, 7, 91, 81, 8, Ascii.DC2, 3, 6, 116, Ascii.ETB, Ascii.DC4, 91, 75, 66, 94, 85, 8, 8, 15, 12, 86, 48, Ascii.DC4, 88, Ascii.EM, 88, Ascii.CAN, 17, Ascii.DC2, 72, 70, 7, 67, Ascii.ETB, 9, 70, 122, 13, 92, 81, 65, 94, 70, 71, 66, 73, 70, Ascii.DC4, Ascii.EM, 7, 74, 70, 14, Ascii.SYN, 43, 7, 66, Ascii.SYN, 7, 83, 92, 66, 2, Ascii.DC4, 68, Ascii.ETB}, "f49b84"), webResourceRequest.getUrl().toString(), Integer.valueOf(webResourceError.getErrorCode()), webResourceError.getDescription().toString()));
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView2, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView2, webResourceRequest, webResourceResponse);
                try {
                    LPWebView.this.onWebPageError(webView2, String.format(s.d(new byte[]{90, 95, 103, 92, 7, 83, 8, Ascii.DC2, 3, 6, 121, 17, 65, 65, 112, 75, Ascii.SYN, 89, 19, 68, 0, 3, 88, 9, 92, 95, 82, 108, Ascii.SYN, 90, 65, 94, 70, 71, 66, 73, Ascii.NAK, 84, 71, 75, 11, 68, 34, 11, 2, 7, 17, 95, Ascii.NAK, Ascii.DC4, 70, Ascii.NAK, 68, Ascii.SYN, 4, Ascii.SYN, Ascii.DC4, 13, 67, 40, 80, 66, 70, 88, 3, 83, 65, 94, 70, 71, 66}, "5159d6"), webResourceRequest.getUrl().toString(), Integer.valueOf(webResourceResponse.getStatusCode()), webResourceResponse.getReasonPhrase()));
                } catch (Exception unused) {
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView webView2, SslErrorHandler sslErrorHandler, SslError sslError) {
                super.onReceivedSslError(webView2, sslErrorHandler, sslError);
                LPWebView.this.onWebPageError(webView2, String.format(s.d(new byte[]{9, 12, 107, 87, 7, 7, 8, Ascii.DC2, 3, 6, 98, Ascii.SYN, 10, 39, 75, SignedBytes.MAX_POWER_OF_TWO, 11, 16, 65, 94, 70, 66, 84, Ascii.ETB, Ascii.DC4, 13, 75, 127, 1, 17, Ascii.DC2, 5, 1, 7, 17, 95, 70, 71, 74}, "fb92db"), sslError.toString()));
            }

            @Override // android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView2, WebResourceRequest webResourceRequest) {
                return LPWebView.this.isYMLandingPage ? e.b(LPWebView.this.mContext, webResourceRequest.getUrl()) : super.shouldInterceptRequest(webView2, webResourceRequest);
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView2, String str) {
                m.a(s.d(new byte[]{116, 104, 49, 7, 91, 111, 8, 1, 17}, "88fb99"), s.d(new byte[]{Ascii.DC2, 89, 90, 68, 84, 80, 46, Ascii.DC2, 3, 16, 67, 12, 5, 84, 96, 67, 84, 120, 14, 5, 2, 11, 95, 2, 65, 11, Ascii.NAK, 68, 74, 88, 65}, "a15184") + str);
                if (!str.startsWith(s.d(new byte[]{81, Ascii.SYN, 66, Ascii.SYN, 11, 76, 78}, "9b6f1c")) && !str.startsWith(s.d(new byte[]{9, Ascii.SYN, Ascii.SYN, Ascii.DC4, 69, 3, 78, 75}, "abbd69"))) {
                    if (LPWebView.this.mOnWebPageFinishedListener != null) {
                        return LPWebView.this.mOnWebPageFinishedListener.shouldOverrideUrlLoading(webView2, str);
                    }
                    return true;
                }
                if (!LPWebView.this.isYMLandingPage || com.miui.zeus.mimo.sdk.b.b(str)) {
                    return false;
                }
                Intent intent = new Intent(LPWebView.this.mContext, (Class<?>) WebViewActivity.class);
                intent.putExtra(s.d(new byte[]{89, 84, 77, 110, Ascii.NAK, 92, 14, 19, 57, Ascii.SYN, 94, Ascii.NAK, 109, 83, 85, 67}, "2141f4"), LPWebView.this.mShowTitle);
                intent.putExtra(s.d(new byte[]{91, 87, 72, 59, 71, 88, 14, 19, 57, 1, 93, 10, 67, 87, 110, 6, 65, 68, Ascii.NAK, 11, 8}, "021d40"), LPWebView.this.mShowClose);
                intent.putExtra(s.d(new byte[]{8, 80, 26, 102, 69, 74, 13}, "c5c908"), str);
                intent.setFlags(268435456);
                LPWebView.this.mContext.startActivity(intent);
                return true;
            }
        });
        webView.setWebChromeClient(new WebChromeClient() { // from class: com.miui.zeus.landingpage.sdk.LPWebView.2
            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView webView2, String str) {
                super.onReceivedTitle(webView2, str);
                if (LPWebView.this.mOnWebPageFinishedListener != null) {
                    LPWebView.this.mOnWebPageFinishedListener.onReceivedTitle(webView2, str);
                }
            }
        });
        webView.setDownloadListener(new android.webkit.DownloadListener() { // from class: com.miui.zeus.landingpage.sdk.LPWebView.3
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                try {
                    LPWebView lPWebView = LPWebView.this;
                    ActivityInfo defaultBrowserInfo = lPWebView.getDefaultBrowserInfo(lPWebView.mContext);
                    Intent uri = Intent.parseUri(str, 0);
                    uri.setClassName(defaultBrowserInfo != null ? defaultBrowserInfo.packageName : s.d(new byte[]{83, 92, 9, 77, 3, 90, 5, Ascii.SYN, 9, 11, 85, 75, 82, 65, 11, Ascii.DC4, 17, 81, 19}, "03dcb4"), defaultBrowserInfo != null ? defaultBrowserInfo.name : s.d(new byte[]{85, 92, 93, 79, 85, 93, 5, Ascii.SYN, 9, 11, 85, 75, 84, 65, 95, Ascii.SYN, 71, 86, 19, 74, 36, 16, 94, Ascii.DC2, 69, 86, 66, 32, 87, 71, 8, Ascii.DC2, 15, Ascii.SYN, 72}, "630a43"));
                    uri.addFlags(268435456);
                    LPWebView.this.mContext.startActivity(uri);
                } catch (Exception e) {
                    m.b(s.d(new byte[]{47, 50, 98, 3, 3, 52, 8, 1, 17}, "cb5fab"), s.d(new byte[]{95, 8, 112, 93, 79, 90, 13, 11, 7, 6, 98, 17, 81, Ascii.DC4, SignedBytes.MAX_POWER_OF_TWO, Ascii.DC2, 93, Ascii.DC4, 91, 68}, "0f4284"), e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ActivityInfo getDefaultBrowserInfo(Context context) {
        ActivityInfo activityInfo;
        try {
            Intent intent = new Intent(s.d(new byte[]{84, 93, 82, 65, 88, 88, 5, 74, 15, 12, 69, 0, 91, 71, Ascii.CAN, 82, 84, 69, 8, 11, 8, 76, 103, 44, 112, 100}, "536371"));
            intent.addCategory(s.d(new byte[]{83, 88, 82, 17, 13, 94, 5, 74, 15, 12, 69, 0, 92, 66, Ascii.CAN, 0, 3, 67, 4, 3, 9, 16, 72, 75, 118, 115, 112, 34, 55, 123, 53}, "266cb7"));
            intent.addCategory(s.d(new byte[]{84, 10, 82, 68, 92, 12, 5, 74, 15, 12, 69, 0, 91, 16, Ascii.CAN, 85, 82, 17, 4, 3, 9, 16, 72, 75, 116, 52, 102, 105, 113, 55, 46, 51, 53, 39, 99}, "5d663e"));
            intent.setDataAndType(Uri.parse(s.d(new byte[]{89, 65, 65, 17, 89, Ascii.ETB, 78}, "155ac8")), null);
            List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            if (!listQueryIntentActivities.isEmpty() && (activityInfo = listQueryIntentActivities.get(0).activityInfo) != null && !TextUtils.isEmpty(activityInfo.packageName) && !TextUtils.isEmpty(activityInfo.name)) {
                m.a(TAG, s.d(new byte[]{1, 19, 92, SignedBytes.MAX_POWER_OF_TWO, 66, 3, 19, 68, 15, 17, 17}, "ca371f") + activityInfo.packageName + s.d(new byte[]{79, Ascii.ETB}, "c75002") + activityInfo.name);
                return activityInfo;
            }
        } catch (Exception e) {
            m.b(TAG, s.d(new byte[]{82, 92, 16, 38, 81, 94, 0, 17, 10, Ascii.SYN, 115, Ascii.ETB, 90, 78, Ascii.ETB, 7, 70, 113, 15, 2, 9, 66, 84, 69, 15, Ascii.EM}, "59db48"), e);
        }
        return null;
    }

    private void init(Context context) {
        m.a(TAG, s.d(new byte[]{91, 8, 11, Ascii.DC2}, "2fbf54"));
        this.mLPJsCallee = getLPJsCallee(context);
        this.mContext = context;
        configWebView(this);
    }

    @Override // android.webkit.WebView
    public void destroy() {
        loadUrl(s.d(new byte[]{5, 84, 88, 77, 66, 95, 3, 8, 7, 12, 90}, "d6786e"));
        removeJavascriptInterface(s.d(new byte[]{89, 8, SignedBytes.MAX_POWER_OF_TWO, 93}, "4a54ee"));
        removeJavascriptInterface(s.d(new byte[]{40, 103, 42, 10, 67, 87, 19, 2, 7, 1, 84}, "b4cd72"));
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
        stopLoading();
        clearFormData();
        clearMatches();
        clearSslPreferences();
        clearDisappearingChildren();
        clearHistory();
        clearAnimation();
        removeAllViews();
        LPJsCallee lPJsCallee = this.mLPJsCallee;
        if (lPJsCallee != null) {
            lPJsCallee.onDestroy();
            this.mLPJsCallee = null;
        }
        super.destroy();
    }

    public LPJsCallee getLPJsCallee(Context context) {
        return new LPJsCallee(context, this);
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        m.a(TAG, s.d(new byte[]{9, 89, 7, 2, 48, 67, 13, 68, 19, 16, 93, 88}, "e6ffe1") + str);
        boolean zB = com.miui.zeus.mimo.sdk.b.b(str);
        this.isYMLandingPage = zB;
        if (zB) {
            addJavascriptInterfaceOnMainThread(str);
        }
        super.loadUrl(str);
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str, Map<String, String> map) {
        m.a(TAG, s.d(new byte[]{91, 12, 80, 5, 103, 17, 13, 85, 70, Ascii.ETB, 67, 9, 10}, "7c1a2c") + str);
        boolean zB = com.miui.zeus.mimo.sdk.b.b(str);
        this.isYMLandingPage = zB;
        if (zB) {
            addJavascriptInterfaceOnMainThread(str);
        }
        super.loadUrl(str, map);
    }

    public void onWebPageError(WebView webView, String str) {
        OnWebPageFinishedListener onWebPageFinishedListener = this.mOnWebPageFinishedListener;
        if (onWebPageFinishedListener != null) {
            onWebPageFinishedListener.onWebPageError(webView, str);
        }
    }

    public void setAppLaunchProxy(LPJsCallee.AppLaunchProxy appLaunchProxy) {
        LPJsCallee lPJsCallee = this.mLPJsCallee;
        if (lPJsCallee != null) {
            lPJsCallee.setAppLaunchProxy(appLaunchProxy);
        }
    }

    public void setOnWebPageFinishedListener(OnWebPageFinishedListener onWebPageFinishedListener) {
        this.mOnWebPageFinishedListener = onWebPageFinishedListener;
    }

    public void setPreloadWithWebView(boolean z) {
        this.mPreloadWithWebView = z;
    }

    public void setShowTitle(boolean z, boolean z2) {
        this.mShowTitle = z;
        this.mShowClose = z2;
    }
}
